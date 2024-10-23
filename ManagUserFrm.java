package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.KowDao;
import cn.itcast.accountinglearn.dao.ManagUserDao;
import cn.itcast.accountinglearn.model.KnowLedge;
import cn.itcast.accountinglearn.model.Situation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagUserFrm {
    public static void main(String[] args) {
     ManagingUsers();
    }
    public static void ManagingUsers(){
        JFrame fm = new JFrame("陈雨晨的会计学习系统-用户学习情况");
        fm.setLocation(450,300);
        fm.setSize(800,500);
        fm.setLayout(new BorderLayout());
        //背景
        //1,把图片添加到标签里
        ImageIcon img = new ImageIcon("imgs/learn.png");
        JLabel background = new JLabel(img);
        fm.getLayeredPane().add(background,Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0,790,490);
        JPanel pan = (JPanel) fm.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //标题
        JLabel lbtitle = new JLabel("用户学习情况管理");
        lbtitle.setBounds(250,10,300,50);
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        lbtitle.setFont(titlefont);
        lbtitle.setForeground(new Color(245, 96, 38));
        //创建表格
        Object [] columnTitle = {"用户id","知识点id","开始学习时间","结束学习时间"};
        Object [][]tableDate ={};
        DefaultTableModel dm =new DefaultTableModel(tableDate,columnTitle);
        JTable table = new JTable(dm);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setSize(750,165);
        jsp.setLocation(20,60);
        //将数据库的内容放入表格
        List<Situation> list =null;
        try{
            list = ManagUserDao.getAllSituation();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        for (int i = 0; i < list.size(); i++)
        {
            Situation situation = list.get(i);
            dm.addRow(new Object[]{situation.getUserid(),situation.getKnowledgeid(),situation.getBegin(),situation.getEnd()});
        }
        //对用户信息进行增删改查
        JLabel zhanwei1 = new JLabel("                  ");
        JLabel userid = new JLabel("              用户id");
        JLabel knowledgeid = new JLabel("  知识点id");
        JLabel begintime = new JLabel("   开学学习时间");
        JLabel overtime = new JLabel("   结束学习时间");
        //添加
        JButton add = new JButton("添加学生学习信息");
        JTextField user_idadd = new JTextField();
        JTextField knowledge_idadd = new JTextField();
        JTextField begin_timeadd = new JTextField();
        JTextField over_timeadd = new JTextField();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  user_id= user_idadd.getText();
                String  knowledge_id=knowledge_idadd .getText();
                String begin_time = begin_timeadd.getText();
                String over_time = over_timeadd.getText();
                Situation s = new Situation();
                s.setUserid(Integer.valueOf((user_id)));
                s.setKnowledgeid(Integer.valueOf(knowledge_id));
                s.setBegin(begin_time);
                s.setEnd(over_time);
                try{
                    ManagUserDao.addmanaguser(s);
                    JOptionPane.showMessageDialog(null,"添加成功!");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //修改
        JButton modify = new JButton("修改学生学习信息");
        JTextField user_idmodify = new JTextField();
        JTextField knowledge_idmodify = new JTextField();
        JTextField begin_timemodify = new JTextField();
        JTextField over_timemodify = new JTextField();
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id= user_idmodify.getText();
                String knowledge_id = knowledge_idmodify.getText();
                String begin = begin_timemodify.getText();
                String over = over_timemodify.getText();
                Situation s = new Situation();
                s.setUserid(Integer.valueOf((user_id)));
                s.setKnowledgeid(Integer.valueOf(knowledge_id));
                s.setBegin(begin);
                s.setEnd(over);
                try{
                    int i =ManagUserDao.modifymanaguser(s);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,用户id:"+user_id+"知识点id:" + knowledge_id + "开始学习时间:" + begin + "结束学习时间:" + over );
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"修改异常");
                }
            }
        });
        //删除
        JButton delete = new JButton("删除学生学习信息");
        JTextField user_iddelete = new JTextField();
        JTextField knowledge_iddelete = new JTextField();
        JLabel zhanwei2 = new JLabel("                ");
        JLabel zhanwei3 = new JLabel("                ");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id =user_iddelete.getText();
                String knowledge_id = knowledge_iddelete.getText();
                Situation s =new Situation();
                s.setUserid(Integer.valueOf(user_id));
                s.setKnowledgeid(Integer.valueOf(knowledge_id));
                try{
                    ManagUserDao.deletemanaguser(s);
                    JOptionPane.showMessageDialog(null,"删除成功!");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //查询
        JButton consult = new JButton("查询学生学习信息");
        JTextField user_idconsult = new JTextField();
        JTextField knowledge_idconsult = new JTextField();
        JLabel zhanwei4 = new JLabel("                ");
        JLabel zhanwei5 = new JLabel("                ");
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id = user_idconsult.getText();
                String knowledge_id = knowledge_idconsult.getText();
                int key1 = Integer.valueOf(user_id);
                int key2 = Integer.valueOf(knowledge_id);
                try {
                    List<Situation> list = new ArrayList<>(ManagUserDao.getFactor(key1,key2));
                    if(list != null ){
                        JOptionPane.showMessageDialog(null, ("查询成功 "));
                        dm.getDataVector().clear();
                        for (int i = 0; i < list.size(); i++) {
                            Situation situation = list.get(i);
                            dm.addRow(new Object[]{situation.getUserid(),situation.getKnowledgeid(),situation.getBegin(),situation.getEnd()});
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"查询失败");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"查询异常");
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel pl1 = new JPanel();
        pl1.add(lbtitle);
        JPanel pl2 =new JPanel();
        pl2.add(zhanwei1);
        pl2.add(userid);
        pl2.add(knowledgeid );
        pl2.add(begintime);
        pl2.add(overtime);
        //添加
        pl2.add(add);
        pl2.add(user_idadd);
        pl2.add(knowledge_idadd );
        pl2.add(begin_timeadd);
        pl2.add(over_timeadd);
        //修改
        pl2.add(modify);
        pl2.add(user_idmodify);
        pl2.add(knowledge_idmodify);
        pl2.add(begin_timemodify);
        pl2.add(over_timemodify);
        //删除
        pl2.add(delete);
        pl2.add(user_iddelete);
        pl2.add(knowledge_iddelete);
        pl2.add(zhanwei2);
        pl2.add(zhanwei3);
        //查询
        pl2.add(consult);
        pl2.add(user_idconsult);
        pl2.add(knowledge_idconsult);
        pl2.add(zhanwei4);
        pl2.add(zhanwei5);
        pl2.setLayout(new GridLayout(5,5,20,5));
        pl2.setSize(750,150);
        pl2.setLocation(20,270);
        pl2.setOpaque(false);
        pan.add(lbtitle,BorderLayout.PAGE_START);
        pan.add(jsp,BorderLayout.CENTER);
        pan.add(pl2,BorderLayout.PAGE_END);
        fm.setVisible(true);
    }
}
