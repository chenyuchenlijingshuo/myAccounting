package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.UserDao;
import cn.itcast.accountinglearn.model.User;
import cn.itcast.accountinglearn.utils.DbUtil;
import cn.itcast.accountinglearn.utils.toolUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class FristFrm extends Component {
    public  void first(){
        JFrame fm = new JFrame("陈雨晨的会计学习系统-注册");
        fm.setSize(850,595);
        fm.setLocation(430,200);
        fm.setLayout(null);
        //背景图
        ImageIcon img = new ImageIcon("imgs/first.png");
        JLabel background = new JLabel(img);
        fm.getLayeredPane().add(background,Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(-83, -70,1000,700);
        ((JPanel)fm.getContentPane()).setOpaque(false);//设置透明
        JPanel pan = (JPanel) fm.getContentPane();
        pan.setOpaque(false);
        //标题
        JLabel enroll = new JLabel("注册");
        Font titlefont = new Font("仿宋",Font.BOLD,40);
        enroll.setFont(titlefont);
        enroll.setForeground(new Color(242, 79, 18));
        //学号
        JLabel user_id = new JLabel("学 号 :");
        Font useridfont = new Font("仿宋",Font.BOLD,25);
        user_id.setFont(useridfont);
        user_id.setForeground(new Color(249, 104, 53));
        JTextField useridtf = new JTextField("",30);
        //姓名
        JLabel name = new JLabel("姓 名 :");
        Font namefont = new Font("仿宋",Font.BOLD,25);
        name.setFont(namefont);
        name.setForeground(new Color(252, 196, 116));
        JTextField nametf = new JTextField("",30);
        //密码
        JLabel password1 = new JLabel("密 码 :");
        Font passwordfont = new Font("仿宋",Font.BOLD,25);
        password1.setFont(passwordfont);
        password1.setForeground(new Color(255, 225, 175));
        JPasswordField passwordtf = new JPasswordField("",30);
        JLabel password = new JLabel("");
        passwordtf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String pwd = passwordtf.getText();
                if(toolUtil.isEmpty(pwd)){
                    password.setText("密码不能为空");
                    password.setForeground(Color.red);
                }
                else{
                    boolean flag=pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
                    if(flag){
                        password.setText("√");
                        password.setForeground(Color.GREEN);
                    }else{
                        JOptionPane.showConfirmDialog(FristFrm.this,"密码需为6-16位数字和字母的组合,输入错误请重新进入","提示",JOptionPane.CLOSED_OPTION);
                        password.setText("");
                        System.exit(0);
                    }
                }
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        //角色
        JLabel role = new JLabel("角 色 :");
        Font rolefont = new Font("仿宋",Font.BOLD,25);
        role.setFont(rolefont);
        role .setForeground(new Color(255, 225, 175));
        JTextField  roletf = new JTextField("1",30);
        roletf.setEditable(false);
        JLabel role1 = new JLabel("");
        //性别
        JLabel sex = new JLabel("性 别 :   ");
        Font sexfont = new Font("仿宋",Font.BOLD,25);
        sex.setFont(sexfont);
        sex.setForeground(new Color(255, 251, 126));
        //创建ButtonGroup按钮
        ButtonGroup group = new ButtonGroup();
        JRadioButton man = new JRadioButton("男",true);
        JRadioButton woman = new JRadioButton("          女       ");
        group.add(man);
        group.add(woman);
        //籍贯
        JLabel area = new JLabel("籍 贯 :   ");
        Font areafont = new Font("仿宋",Font.BOLD,25);
        area.setFont(areafont);
        area.setForeground(new Color(255, 255, 255));
        JComboBox comboBox = new JComboBox(); //下拉框
        comboBox.addItem("请选择籍贯所在地 ");
        comboBox.addItem("北 京");
        comboBox.addItem("石 家 庄");
        comboBox.addItem("银 川");
        comboBox.addItem("杭 州");
        //按钮 注册和进入登录界面
        JButton new1  = new JButton("注  册");
        new1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid = useridtf.getText();
                String username = nametf.getText();
                String password = passwordtf.getText();
                String role = roletf.getText();
                String sex =man.getText();
                String area = (String)comboBox.getSelectedItem();
                User user = new User();
                user.setUserId(Integer.valueOf(userid));
                user.setUserName(username);
                user.setPassword(password);
                user.setRole(Integer.valueOf(role));
                user.setSex(sex);
                user.setArea(area);
                Connection con = null;
                if(toolUtil.isEmpty(userid) || toolUtil.isEmpty(username) || toolUtil.isEmpty(password)){
                        JOptionPane.showMessageDialog(null,"学号,姓名和密码不能为空");
                        return;}
                try {
                    UserDao.adduser(user);
                    JOptionPane.showConfirmDialog(FristFrm.this,
                            "注册成功，欢迎您进入陈雨晨的会计学习系统!", "注册成功",
                            JOptionPane.CLOSED_OPTION);
                    UserMainFrm.UserMainPage(user);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JLabel lb1 = new JLabel("                                   ");
        JButton new2  = new JButton("已 注 册 进 入 登 录");
        new2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegFrm rf = new RegFrm();
            }
        });
        //标题面板
        JPanel pl1 = new JPanel();
        pl1.add(enroll);
        pl1.setSize(100,50);
        pl1.setLocation(360,20);
        pl1.setOpaque(false);
        //学号面板
        JPanel pl2 = new JPanel();
        pl2.add(user_id);
        pl2.add(useridtf);
        pl2.setSize(500,70);
        pl2.setLocation(150,100);
        pl2.setOpaque(false);
        //姓名面板
        JPanel pl3 = new JPanel();
        pl3.add(name);
        pl3.add(nametf);
        pl3.setSize(500,70);
        pl3.setLocation(150,170);
        pl3.setOpaque(false);
        //密码面板
        JPanel pl4 = new JPanel();
        pl4.add(password1);
        pl4.add(passwordtf);
        pl4.add(password);
        pl4.setSize(500,70);
        pl4.setLocation(150,240);
        pl4.setOpaque(false);
        //角色面板
        JPanel pl5 =new JPanel();
        pl5.add(role);
        pl5.add(roletf);
        pl5.setSize(500,70);
        pl5.setLocation(150,310);
        pl5.setOpaque(false);
        //性别面板
        JPanel pl6 =new JPanel();
        pl6.add(sex);
        pl6.add(man);
        pl6.add(woman);
        pl6.setSize(500,70);
        pl6.setLocation(150,380);
        pl6.setOpaque(false);
        //籍贯面板
        JPanel pl7 = new JPanel();
        pl7.add(area);
        pl7.add(comboBox);
        pl7.setSize(500,70);
        pl7.setLocation(150,450);
        pl7.setOpaque(false);
        //按钮面板
        JPanel pl8 = new JPanel();
        pl8.add(new1);
        pl8.add(lb1);
        pl8.add(new2);
        pl8.setSize(500,50);
        pl8.setLocation(150,500);
        pl8.setOpaque(false);
        fm.add(pl1);
        fm.add(pl2);
        fm.add(pl3);
        fm.add(pl4);
        fm.add(pl5);
        fm.add(pl6);
        fm.add(pl7);
        fm.add(pl8);
        fm.setVisible(true);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
