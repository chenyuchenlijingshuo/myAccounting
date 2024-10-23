package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.FactorDao;
import cn.itcast.accountinglearn.dao.KowDao;
import cn.itcast.accountinglearn.model.Factor;
import cn.itcast.accountinglearn.model.KnowLedge;
import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class KowManageFrm {
    public static void main(String[] args) {
         knowledgemanagement();
    }
    public static void knowledgemanagement(){

        JFrame fm = new JFrame("陈雨晨的会计学习系统-会计知识管理");
        fm.setLocation(300,200);
        fm.setSize(1100,700);
        fm.setLayout(new BorderLayout());
        //背景
        //1,把图片添加到标签里
        ImageIcon img = new ImageIcon("imgs/denglu.jpg");
        JLabel background = new JLabel(img);
        fm.getLayeredPane().add(background,Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0,1090,690);
        JPanel pan = (JPanel) fm.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //标题
        JLabel lbtitle = new JLabel("会计知识管理");
        lbtitle.setBounds(450,20,300,50);
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        lbtitle.setFont(titlefont);
        lbtitle.setForeground(new Color(255, 28, 28));
        pan.add(lbtitle);
        //创建表格
        Object [] columnTitle = {"序号","知识点","类别","数量","老师","描述","难度"};
        Object [][]tableDate ={};
        DefaultTableModel dm =new DefaultTableModel(tableDate,columnTitle);
        JTable table = new JTable(dm);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setSize(800,300);
        jsp.setLocation(150,80);
        //将数据库的内容放入表格
        List<KnowLedge> list =null;
        try{
            list = KowDao.getAllFactor();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        for (int i = 0; i < list.size(); i++) {
            KnowLedge knowLedge = list.get(i);
            dm.addRow(new Object[]{knowLedge.getKnowledgeid(),knowLedge.getKnowledgename(),knowLedge.getTypeid(),knowLedge.getNumber(),knowLedge.getTeacher(),knowLedge.getDescribe(),knowLedge.getDifficulty()});
        }
        //增删改查
        JLabel knowledgeid =new JLabel("  序号      ");
        JLabel knowledgename= new JLabel("       知识点     ");
        JLabel type_id = new JLabel("        类别 ");
        JLabel number = new JLabel("       数量      ");
        JLabel teacher = new JLabel("       老师      ");
        JLabel describe = new JLabel("       描述      ");
        JLabel difficulty = new JLabel("       难度");
        JLabel zhanwei10 = new JLabel("                      ");

        JTextField knowledgeidadd = new JTextField(10);
        JTextField knowledgeadd = new JTextField(10);
        JTextField type_idadd = new JTextField(10);
        JTextField numberadd = new JTextField(10);
        JTextField teacheradd = new JTextField(10);
        JTextField describeadd =new JTextField(10);
        JTextField difficultyadd =new JTextField(10);
        JButton btadd = new JButton("添加知识信息");
        btadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String knowledge_id = knowledgeidadd.getText();
                String knowledge_name = knowledgeadd.getText();
                String type_id = type_idadd.getText();
                String number = numberadd.getText();
                String teacher = teacheradd.getText();
                String describe = describeadd.getText();
                String difficulty = difficultyadd.getText();
                KnowLedge k = new KnowLedge();
                k.setKnowledgeid(Integer.valueOf(knowledge_id));
                k.setKnowledgename(knowledge_name);
                k.setTypeid(Integer.valueOf(type_id));
                k.setNumber(Integer.valueOf(number));
                k.setTeacher(teacher);
                k.setDescribe(describe);
                k.setDifficulty(difficulty);
                try {
                    KowDao.addkow(k);
                    JOptionPane.showMessageDialog(null, "添加成功!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        JTextField knowledgeidmodify = new JTextField(10);
        JTextField knowledgenamemodify = new JTextField(10);
        JTextField type_idmodify = new JTextField(10);
        JTextField numbermodify = new JTextField(10);
        JTextField teachermodify = new JTextField(10);
        JTextField describemodify =new JTextField(10);
        JTextField difficultymodify =new JTextField(10);
        JButton btmodify = new JButton("修改知识信息");
        btmodify.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    String knowledge_id = knowledgeidmodify.getText();
                    String knowledge_name = knowledgenamemodify.getText();
                    String type_id = type_idmodify.getText();
                    String number = numbermodify.getText();
                    String teacher = teachermodify.getText();
                    String describe = describemodify.getText();
                    String difficulty = difficultymodify.getText();
                    KnowLedge k = new KnowLedge();
                    k.setKnowledgeid(Integer.valueOf(knowledge_id));
                    k.setKnowledgename(knowledge_name);
                    k.setTypeid(Integer.valueOf(type_id));
                    k.setNumber(Integer.valueOf(number));
                    k.setTeacher(teacher);
                    k.setDescribe(describe);
                    k.setDifficulty(difficulty);
                    try {
                        int i = KowDao.modifykow(k);
                        if (i == 1) {
                            JOptionPane.showMessageDialog(null, "修改成功,序号:" + knowledge_id + "知识点:" + knowledge_name + "类型:" + type_id + "数量:" + number + "老师:" + teacher + "描述:" + describe + "难度:" + difficulty);
                        } else {
                            JOptionPane.showMessageDialog(null, "修改失败");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "修改异常");
                    }
                }
        });
        JTextField knowledgeiddelete = new JTextField(10);
        JLabel zhanwei0 = new JLabel("                      ");
        JLabel zhanwei1 = new JLabel("                      ");
        JLabel zhanwei2 = new JLabel("                      ");
        JLabel zhanwei3 = new JLabel("                      ");
        JLabel zhanwei4 = new JLabel("                      ");
        JLabel zhanweidelete = new JLabel("                      ");
        JButton btdelete = new JButton("删除知识信息");
        btdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String knowledge_id = knowledgeiddelete.getText();
                KnowLedge k = new KnowLedge();
                k.setKnowledgeid(Integer.valueOf(knowledge_id));
                try{
                    KowDao.deletekow(k);
                    JOptionPane.showMessageDialog(null,"删除成功!");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        JTextField knowledgeidshow = new JTextField(10);
        JLabel zhanwei5 = new JLabel("                      ");
        JLabel zhanwei6 = new JLabel("                      ");
        JLabel zhanwei7 = new JLabel("                      ");
        JLabel zhanwei8 = new JLabel("                      ");
        JLabel zhanwei9 = new JLabel("                      ");
        JLabel zhanweishow = new JLabel("                      ");
        JButton btshow = new JButton("查询知识信息");

        btshow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String knowledge_id = knowledgeidshow.getText();
                int key = Integer.valueOf(knowledge_id);
                try {
                    List<KnowLedge> list = new ArrayList<>(KowDao.getFactor(key));
                    if(list != null ){
                        JOptionPane.showMessageDialog(null, ("查询成功 "));
                        dm.getDataVector().clear();
                        for (int i = 0; i < list.size(); i++) {
                            KnowLedge knowLedge = list.get(i);
                            dm.addRow(new Object[]{knowLedge.getKnowledgeid(),knowLedge.getKnowledgename(),knowLedge.getTypeid(),knowLedge.getNumber(),knowLedge.getTeacher(),knowLedge.getDescribe(),knowLedge.getDifficulty()});
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
        JPanel pl3 = new JPanel(new GridLayout(5,5,20,5));
        //JScrollPane pl3 =new JScrollPane();
        pl3.add(knowledgeid);
        pl3.add(knowledgename);
        pl3.add(type_id);
        pl3.add(number);
        pl3.add(teacher);
        pl3.add(describe);
        pl3.add(difficulty);
        pl3.add(zhanwei10);

        pl3.add(knowledgeidadd);
        pl3.add(knowledgeadd);
        pl3.add(type_idadd);
        pl3.add(numberadd);
        pl3.add(teacheradd);
        pl3.add(describeadd);
        pl3.add(difficultyadd);
        pl3.add(btadd);

        pl3.add(knowledgeidmodify);
        pl3.add(knowledgenamemodify);
        pl3.add(type_idmodify);
        pl3.add(numbermodify);
        pl3.add(teachermodify);
        pl3.add(describemodify);
        pl3.add(difficultymodify);
        pl3.add(btmodify);

        pl3.add(knowledgeiddelete);
        pl3.add(zhanwei0);
        pl3.add(zhanwei1);
        pl3.add(zhanwei2);
        pl3.add(zhanwei3);
        pl3.add(zhanwei4);
        pl3.add(zhanweidelete);
        pl3.add(btdelete);

        pl3.add(knowledgeidshow);
        pl3.add(zhanwei5);
        pl3.add(zhanwei6);
        pl3.add(zhanwei7);
        pl3.add(zhanwei8);
        pl3.add(zhanwei9);
        pl3.add(zhanweishow);
        pl3.add(btshow);
        pl3.setSize(1050,200);
        pl3.setLocation(20,430);
        pl3.setOpaque(false);
        pan.add(lbtitle,BorderLayout.PAGE_START);
        pan.add(jsp,BorderLayout.CENTER);
        pan.add(pl3,BorderLayout.PAGE_END);
        fm.setVisible(true);
    }
}
