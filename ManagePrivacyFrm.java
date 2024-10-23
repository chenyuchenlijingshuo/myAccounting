package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.KowDao;
import cn.itcast.accountinglearn.dao.ManagUserDao;
import cn.itcast.accountinglearn.dao.UserDao;
import cn.itcast.accountinglearn.model.KnowLedge;
import cn.itcast.accountinglearn.model.Situation;
import cn.itcast.accountinglearn.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManagePrivacyFrm {
    public static void main(String[] args) {
      managepri();
    }
    public static void managepri(){
        JFrame fm = new JFrame("陈雨晨的会计学习系统");
        fm.setLocation(400,300);
        fm.setSize(950,570);
        fm.setLayout(new BorderLayout());
        //背景
        //1,把图片添加到标签里
        ImageIcon img = new ImageIcon("imgs/user.png");
        JLabel background = new JLabel(img);
        fm.getLayeredPane().add(background,Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0,940,540);
        JPanel pan = (JPanel) fm.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //标题
        JLabel lbtitle = new JLabel("会计用户管理");
        lbtitle.setBounds(330,20,300,50);
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        lbtitle.setFont(titlefont);
        lbtitle.setForeground(new Color(0, 168, 182));
        //创建表格
        Object [] columnTitle = {"用户id","用户名","密码","角色","性别","籍贯"};
        Object [][]tableDate ={};
        DefaultTableModel dm =new DefaultTableModel(tableDate,columnTitle);
        JTable table = new JTable(dm);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setSize(800,200);
        jsp.setLocation(50,100);
        //将数据库的内容放入表格
        List<User> list =null;
        try{
            list = UserDao.getAllSituation();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        for (int i = 0; i < list.size(); i++)
        {   User u =list.get(i);
            dm.addRow(new Object[]{u.getUserId(),u.getUserName(),u.getPassword(),u.getRole(),u.getSex(),u.getArea()});
        }
        //增删改查
        JLabel userid =new JLabel("   用户id   ");
        JLabel username= new JLabel("       用户名     ");
        JLabel password = new JLabel("        密码 ");
        JLabel role = new JLabel("       角色      ");
        JLabel sex = new JLabel("       性别      ");
        JLabel area = new JLabel("       籍贯      ");
        JLabel zhanwei10 = new JLabel("                      ");
        JTextField useridadd = new JTextField(10);
        JTextField usernameadd = new JTextField(10);
        JTextField passwordadd = new JTextField(10);
        JTextField roleadd = new JTextField(10);
        JTextField sexadd = new JTextField(10);
        JTextField areaadd =new JTextField(10);
        JButton btadd = new JButton("添加用户信息");
        btadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid = useridadd.getText();
                String username = usernameadd.getText();
                String password = passwordadd.getText();
                String role = roleadd.getText();
                String sex =sexadd.getText();
                String area = areaadd.getText();
                User u = new User();
                u.setUserId(Integer.valueOf(userid));
                u.setUserName(username);
                u.setPassword(password);
                u.setRole(Integer.valueOf(role));
                u.setSex(sex);
                u.setArea(area);
                try{
                    UserDao.adduser(u);
                    JOptionPane.showMessageDialog(null,"添加成功!");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        JTextField useridmodify = new JTextField(10);
        JTextField usernamemodify = new JTextField(10);
        JTextField passwordmodify = new JTextField(10);
        JTextField rolemodify = new JTextField(10);
        JTextField sexmodify = new JTextField(10);
        JTextField areamodify =new JTextField(10);
        JButton btmodify = new JButton("修改用户信息");
        btmodify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid = useridmodify.getText();
                String username = usernamemodify.getText();
                String password = passwordmodify.getText();
                String role = rolemodify.getText();
                String sex =sexmodify.getText();
                String area = areamodify.getText();
                User u = new User();
                u.setUserId(Integer.valueOf(userid));
                u.setUserName(username);
                u.setPassword(password);
                u.setRole(Integer.valueOf(role));
                u.setSex(sex);
                u.setArea(area);
                try{
                    int i = UserDao.modifyuser(u);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,学号:" + userid + "用户名" + username + "密码:" + password + "角色:" + role + "性别:" + sex + "籍贯:" + area );
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
        JTextField useriddelete = new JTextField(10);
        JLabel zhanwei0 = new JLabel("                      ");
        JLabel zhanwei1 = new JLabel("                      ");
        JLabel zhanwei2 = new JLabel("                      ");
        JLabel zhanwei3 = new JLabel("                      ");
        JLabel zhanweidelete = new JLabel("                      ");
        JButton btdelete = new JButton("删除用户信息");
        btdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id = useriddelete.getText();
                User u =new User();
                u.setUserId(Integer.valueOf(user_id));
                try{
                    UserDao.deleteuser(u);
                    JOptionPane.showMessageDialog(null,"删除成功!");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        JTextField useridshow = new JTextField(10);
        JLabel zhanwei5 = new JLabel("                      ");
        JLabel zhanwei6 = new JLabel("                      ");
        JLabel zhanwei7 = new JLabel("                      ");
        JLabel zhanwei8 = new JLabel("                      ");
        JLabel zhanweishow = new JLabel("                      ");
        JButton btshow = new JButton("查询用户信息");
        btshow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id = useridshow.getText();
                int key = Integer.valueOf(user_id);
                try {
                    List<User> list = new ArrayList<>(UserDao.getFactor(key));
                    if(list != null ){
                        JOptionPane.showMessageDialog(null, ("查询成功 "));
                        dm.getDataVector().clear();
                        for (int i = 0; i < list.size(); i++) {
                            User user = list.get(i);
                            dm.addRow(new Object[]{user.getUserId(),user.getUserName(),user.getPassword(),user.getRole(),user.getSex(),user.getArea()});
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
        pl3.add(userid);
        pl3.add(username);
        pl3.add(password);
        pl3.add(role);
        pl3.add(sex);
        pl3.add(area);
        pl3.add(zhanwei10);
        pl3.add(useridadd);
        pl3.add(usernameadd);
        pl3.add(passwordadd);
        pl3.add(roleadd);
        pl3.add(sexadd);
        pl3.add(areaadd);
        pl3.add(btadd);
        pl3.add(useridmodify);
        pl3.add(usernamemodify);
        pl3.add(passwordmodify);
        pl3.add(rolemodify);
        pl3.add(sexmodify);
        pl3.add(areamodify);
        pl3.add(btmodify);
        pl3.add(useriddelete);
        pl3.add(zhanwei0);
        pl3.add(zhanwei1);
        pl3.add(zhanwei2);
        pl3.add(zhanwei3);
        pl3.add(zhanweidelete);
        pl3.add(btdelete);
        pl3.add(useridshow);
        pl3.add(zhanwei5);
        pl3.add(zhanwei6);
        pl3.add(zhanwei7);
        pl3.add(zhanwei8);
        pl3.add(zhanweishow);
        pl3.add(btshow);
        pl3.setSize(920,170);
        pl3.setLocation(10,350);
        pl3.setOpaque(false);
        JPanel pl1 = new JPanel();
        pl1.add(lbtitle);
        pan.add(lbtitle,BorderLayout.PAGE_START);
        pan.add(jsp,BorderLayout.CENTER);
        pan.add(pl3,BorderLayout.PAGE_END);
        fm.setVisible(true);
    }
}
