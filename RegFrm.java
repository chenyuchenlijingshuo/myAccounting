package cn.itcast.accountinglearn.JFrame;
import cn.itcast.accountinglearn.dao.UserDao;
import cn.itcast.accountinglearn.model.User;
import cn.itcast.accountinglearn.utils.DbUtil;
import cn.itcast.accountinglearn.utils.toolUtil;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
public class RegFrm extends JFrame{
    public RegFrm(){
        init();
    }
    public  void init(){
        //登录窗口
        JFrame frame = new JFrame();
        frame.setSize(400,250);
        frame.setLocation(600,300);
        frame.setTitle("陈雨晨的会计学习系统-登录");
        frame.setLayout(new FlowLayout());
        //小标题
        JLabel welcom = new JLabel("欢迎来到会计学习系统");
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        welcom.setFont(titlefont);
        welcom.setForeground(new Color(80, 62, 154));
        //姓名
        JLabel name = new JLabel("姓 名 :");
        Font namefont = new Font("仿宋",Font.ITALIC,20);
        name.setFont(namefont);
        JTextField nametf = new JTextField("",20);
        //密码
        JLabel password1 = new JLabel("密 码 :");
        Font passwordfont = new Font("仿宋",Font.ITALIC,20);
        password1.setFont(passwordfont);
        JPasswordField passwordtf = new JPasswordField("",20);
        JLabel password = new JLabel("");
        //编辑密码文本框的监听器
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
                        JOptionPane.showConfirmDialog(RegFrm.this,"密码需为6-16位数字和字母的组合,输入错误请重新进入","提示",JOptionPane.CLOSED_OPTION);
                        password.setText("");
                        System.exit(0);
                    }
                }
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        //性别
        /*JLabel sex = new JLabel("性 别 :   ");
        Font sexfont = new Font("仿宋",Font.ITALIC,20);
        sex.setFont(sexfont);
        //创建ButtonGroup按钮
        ButtonGroup group = new ButtonGroup();
        JRadioButton man = new JRadioButton(" 男       ",true);
        JRadioButton woman = new JRadioButton(" 女       ");
        group.add(man);
        group.add(woman);
        //籍贯
        JLabel area = new JLabel("籍 贯 :   ");
        Font areafont = new Font("仿宋",Font.ITALIC,20);
        area.setFont(areafont);
        JComboBox comboBox = new JComboBox(); //下拉框
        comboBox.addItem("请选择籍贯所在地 ");
        comboBox.addItem("北 京");
        comboBox.addItem("石 家 庄");
        comboBox.addItem("银 川");
        comboBox.addItem("杭 州");*/
        //登录按钮
        JButton enroll = new JButton("用户登录");
        JButton maneger = new JButton("管理员登录");
        maneger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDao userDao = new UserDao();
                DbUtil dbUtil =new DbUtil();
                Connection con = null;
                String userName = nametf.getText().trim();
                String password2 = passwordtf.getText().trim();
                String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
                String username = "root";
                String password = "123456";
                try {
                    con= DriverManager.getConnection(url,username,password);
                    String sql ="select * from user where username ='" +userName+ "' AND password ='" +password2 +"';";
                    PreparedStatement pstmt = null;
                    pstmt = con.prepareStatement(sql);
                    if(toolUtil.isEmpty(userName) || toolUtil.isEmpty(password2)){
                        JOptionPane.showMessageDialog(null,"姓名和密码不能为空");
                        return;
                    }
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password2);
                    ResultSet rs =pstmt.executeQuery(sql);
                    if(rs.next()) {
                        User login = userDao.login(con,user);
                        if(login.getRole() == 2) {
                            JOptionPane.showConfirmDialog(RegFrm.this,
                                    "登陆成功，欢迎管理员进入!", "登陆成功",
                                    JOptionPane.CLOSED_OPTION);
                            dispose();
                            AdminisFrm.AdmimistratorLogin();
                        }else {
                            JOptionPane.showConfirmDialog(RegFrm.this,
                                    "登录失败，您不是管理员!", "登录失败",
                                    JOptionPane.CLOSED_OPTION);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"姓名或密码错误!");
                    }
                }catch(Exception e21){
                    e21.printStackTrace();
                }
            }
        });
        enroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDao userDao = new UserDao();
                    Connection con = null;
                    String userName = nametf.getText().trim();
                    String password2 = passwordtf.getText().trim();
                    String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
                    String username = "root";
                    String password = "123456";
                try {
                    con= DriverManager.getConnection(url,username,password);
                    String sql ="select * from user where username ='" +userName+ "' AND password ='" +password2 +"';";
                    PreparedStatement pstmt = null;
                    pstmt = con.prepareStatement(sql);
                     if(toolUtil.isEmpty(userName) || toolUtil.isEmpty(password2)){
                        JOptionPane.showMessageDialog(null,"姓名和密码不能为空");
                        return;
                    }
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password2);
                    ResultSet rs =pstmt.executeQuery(sql);
                    if(rs.next()) {
                        User login = userDao.login(con,user);
                        if(login.getRole() == 1){
                            JOptionPane.showConfirmDialog(RegFrm.this,
                                    "登陆成功，欢迎用户进入!", "登陆成功",
                                    JOptionPane.CLOSED_OPTION);
                            dispose();
                            UserMainFrm.UserMainPage(user);
                        }else {
                            JOptionPane.showConfirmDialog(RegFrm.this,
                                    "登录失败，您不是用户!", "登录失败",
                                    JOptionPane.CLOSED_OPTION);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"姓名或密码错误!");
                    }
                    }catch(Exception e21){
                           e21.printStackTrace();
                    }
                }
        });
        //退出
        JButton exit = new JButton("退出");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //小标题面板
        JPanel pl1 =new JPanel();
        pl1.add(welcom);
        //姓名面板
        JPanel pl2 = new JPanel();
        pl2.add(name);
        pl2.add(nametf);
        //密码面板
        JPanel pl3 = new JPanel();
        pl3.add(password1);
        pl3.add(passwordtf);
        pl3.add(password);
        //性别面板
        /*JPanel pl4 =new JPanel();
        pl4.add(sex);
        pl4.add(man);
        pl4.add(woman);
        //籍贯面板
        JPanel pl5 = new JPanel();
        pl5.add(area);
        pl5.add(comboBox);*/
        //按钮面板
        JPanel pl6 = new JPanel();
        pl6.add(enroll);
       // pl6.add(register);
        pl6.add(maneger);
        pl6.add(exit);
        //窗口插入面板
        frame.add(pl1);
        frame.add(pl2);
        frame.add(pl3);
        //frame.add(pl4);
        //frame.add(pl5);
        frame.add(pl6);
        frame.setVisible(true);
    }
}

