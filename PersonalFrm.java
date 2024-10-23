package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.KowDao;
import cn.itcast.accountinglearn.dao.UserDao;
import cn.itcast.accountinglearn.model.KnowLedge;
import cn.itcast.accountinglearn.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.*;

public class PersonalFrm {
    public static void main(String[] args , User user) {
        personalcenter(user);
    }
    public static void personalcenter(User user){
        User u = new User();// 创建一个用户对象
        u = user;

        JFrame fm = new JFrame("陈雨晨的会计学习系统");
        fm.setSize(500,350);
        fm.setLocation(600,300);
        fm.setLayout(new FlowLayout());
        //标题
        JLabel lbtitle = new JLabel("     个人中心    ");
        lbtitle.setBounds(450,20,300,50);
        lbtitle.setLocation(200,20);
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        lbtitle.setFont(titlefont);
        lbtitle.setForeground(new Color(20, 237, 195));
        //学号
        JLabel userid = new JLabel("学 号 :");
        Font useridfont = new Font("仿宋",Font.ITALIC,20);
        userid.setFont(useridfont);
        JTextField useridtf = new JTextField("1014",20);
        JLabel usertishi = new JLabel("    学号不可修改");
        //姓名
        JLabel name = new JLabel("姓 名 :");
        Font namefont = new Font("仿宋",Font.ITALIC,20);
        name.setFont(namefont);
        JTextField nametf = new JTextField("",20);
        nametf.setText(u.getUserName());
        JButton namemodify = new JButton("修改姓名");
        namemodify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametf.getText();
                String user_id = useridtf.getText();
                user.setUserId(Integer.valueOf(user_id));
                user.setUserName(name);
                try{
                    int i =UserDao.modifyname(user);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,姓名:" + name );
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
        //密码
        JLabel password1 = new JLabel("密 码 :");
        Font passwordfont = new Font("仿宋",Font.ITALIC,20);
        password1.setFont(passwordfont);
        JPasswordField passwordtf = new JPasswordField("",20);
        //passwordtf.setText(UserDao.getpassword("1005"));
        passwordtf.setText(u.getPassword());
        JLabel password = new JLabel();
        JButton passwordmodify = new JButton("修改密码");
        passwordmodify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordtf.getText();
                String user_id = useridtf.getText();
                user.setUserId(Integer.valueOf(user_id));
                user.setPassword(password);
                try{
                    int i =UserDao.modifypassword(user);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,密码:" +password );
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
        //性别
        JLabel sex = new JLabel("性 别 :    ");
        Font sexfont = new Font("仿宋",Font.ITALIC,20);
        sex.setFont(sexfont);
        JButton sexmodify = new JButton("修改性别");
        //创建ButtonGroup按钮
        ButtonGroup group = new ButtonGroup();
        JRadioButton man = new JRadioButton("男");
        JRadioButton woman = new JRadioButton("         女            ",true);
        group.add(man);
        group.add(woman);
        sexmodify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sex = man.getText();
                String user_id = useridtf.getText();
                user.setUserId(Integer.valueOf(user_id));
                user.setSex(sex);
                try{
                    int i =UserDao.modifysex(user);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,性别:" + sex );
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
        //籍贯
        JLabel area = new JLabel("籍 贯 :   ");
        Font areafont = new Font("仿宋",Font.ITALIC,20);
        area.setFont(areafont);
        JComboBox comboBox = new JComboBox(); //下拉框
        comboBox.addItem("请 选 择 籍 贯 所 在 地   ");
        comboBox.addItem("北京");
        comboBox.addItem("石家庄");
        comboBox.addItem("银川");
        comboBox.addItem("杭州");
        comboBox.addItem("邢台");
        comboBox.setSelectedItem("石家庄");
        if(UserDao.getusers(u).getArea().equals("北京")){
            comboBox.setSelectedIndex(1);
        }else if(UserDao.getusers(u).getArea().equals("石家庄")){
            comboBox.setSelectedIndex(0);
        }else if(UserDao.getusers(u).getArea().equals("北京")){
            comboBox.setSelectedIndex(1);
        }else if(UserDao.getusers(u).getArea().equals("银川")){
            comboBox.setSelectedIndex(2);
        }else if(UserDao.getusers(u).getArea().equals("杭州")){
            comboBox.setSelectedIndex(3);
        }else{
            comboBox.addItem(UserDao.getusers(u).getArea());
            comboBox.setSelectedIndex(4);
        }
        JButton areamodify = new JButton("修改籍贯");
        areamodify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String area = (String)comboBox.getSelectedItem();
                String user_id = useridtf.getText();
                user.setUserId(Integer.valueOf(user_id));
                user.setArea(area);
                try{
                    int i =UserDao.modifyarea(user);
                    if(i==1) {
                        JOptionPane.showMessageDialog(null, "修改成功,籍贯:" + area );
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
        //学号面板
        JPanel pl1 = new JPanel();
        pl1.add(userid);
        pl1.add(useridtf);
        pl1.add(usertishi);
        //姓名面板
        JPanel pl2 = new JPanel();
        pl2.add(name);
        pl2.add(nametf);
        pl2.add(namemodify);
        //密码面板
        JPanel pl3 = new JPanel();
        pl3.add(password1);
        pl3.add(passwordtf);
        pl3.add(password);
        pl3.add(passwordmodify);
        //性别面板
        JPanel pl4 =new JPanel();
        pl4.add(sex);
        pl4.add(man);
        pl4.add(woman);
        pl4.add(sexmodify);
        //籍贯面板
        JPanel pl5 = new JPanel();
        pl5.add(area);
        pl5.add(comboBox);
        pl5.add(areamodify);
        fm.add(lbtitle);
        fm.add(pl1);
        fm.add(pl2);
        fm.add(pl3);
        fm.add(pl4);
        fm.add(pl5);
        fm.setVisible(true);
    }
}
