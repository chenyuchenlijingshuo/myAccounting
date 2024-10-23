package cn.itcast.accountinglearn.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;

public class AdminisFrm {
    public static void main(String[] args) {
        AdmimistratorLogin();
    }
    public static void AdmimistratorLogin(){
        //管理员登录界面
        JFrame adjf = new JFrame("陈雨晨的会计学习系统-管理员");
        adjf.setLayout(new GridLayout(2,2));
        adjf.setSize(600,500);
        adjf.setLocation(550,250);
        //创建菜单栏组件
        JMenuBar menubar = new JMenuBar();
        //创建2个JMenu菜单组件,加入JMenuBar
        JMenu menu1 = new JMenu("  会计知识管理  ");
        JMenu menu2 = new JMenu("  用户信息  ");
        JMenu menu3 = new JMenu("  社区交流  ");
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        //创建两个JMenuItem菜单项组件,加入JMenu
        JMenuItem item1 = new JMenuItem("进入");
        menu1.add(item1);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KowManageFrm.knowledgemanagement();
            }
        });
        JMenuItem item2 = new JMenuItem("用户学习情况");
        menu2.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagUserFrm.ManagingUsers();
            }
        });
        JMenuItem item3 = new JMenuItem("用户个人情况");
        menu2.add(item3);
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ManagePrivacyFrm.managepri();
            }
        });
        JMenuItem item4 = new JMenuItem("进入");
        menu3.add(item4);
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // ComManageFrm.communication();
                try {
                    AdminComFrm ad = new AdminComFrm(4445);
                } catch (SocketException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //向JFrame添加JMenuBar
        adjf.setJMenuBar(menubar);
        //添加图片 左上
        JLabel lbimg = new JLabel();
        ImageIcon icon = new ImageIcon("imgs/chuji.png");
        Image img = icon.getImage();
        img = img.getScaledInstance(270,200,Image.SCALE_DEFAULT);
        icon.setImage(img);
        lbimg.setIcon(icon);
        adjf.getLayeredPane().add(lbimg);
        //公告栏 右上
        JLabel lb1 = new JLabel("公告栏:");
        Font lb1font = new Font("仿宋", Font.BOLD, 20);
        lb1.setFont(lb1font);
        lb1.setForeground(new Color(28, 34, 46));
        JLabel lb2 =new JLabel("5月18日24年全国会计专业技术考试开考");
        Font lb2font = new Font("仿宋", Font.BOLD, 15);
        lb2.setFont(lb2font);
        JLabel lb3 =new JLabel("5月25日时不我待抓学习财会监督有作为");
        Font lb3font = new Font("仿宋", Font.BOLD, 15);
        lb3.setFont(lb3font);
        JLabel lb4 =new JLabel("6月1日财政部会计财务中心24年单位预算");
        Font lb4font = new Font("仿宋", Font.BOLD, 15);
        lb4.setFont(lb4font);
        JLabel lb5 =new JLabel("6月10日收看第十四届全国人民代表大会");
        Font lb5font = new Font("仿宋", Font.BOLD, 15);
        lb5.setFont(lb5font);
        //公告栏 左下
        JLabel lb6 = new JLabel("考试公告栏:");
        Font lb6font = new Font("仿宋", Font.BOLD, 20);
        lb6.setFont(lb6font);
        lb6.setForeground(new Color(28, 34, 46));
        JLabel lb7 =new JLabel("3月23日关于推迟会计考试日期事项公告");
        Font lb7font = new Font("仿宋", Font.BOLD, 15);
        lb7.setBounds(0,0,270,50);
        lb7.setFont(lb7font);
        JLabel lb8 =new JLabel("6月22日关于调整会计专考试日程公告");
        Font lb8font = new Font("仿宋", Font.BOLD, 15);
        lb8.setFont(lb8font);
        JLabel lb9 =new JLabel("1月12日全国会计考试严重违纪违规名单");
        Font lb9font = new Font("仿宋", Font.BOLD, 15);
        lb9.setFont(lb9font);
        JLabel lb10 =new JLabel("1月18日全国会计中级资格考试日程安排");
        Font lb10font = new Font("仿宋", Font.BOLD, 15);
        lb10.setFont(lb10font);
        JButton bt = new JButton("点击查阅今日公告");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoticeFrm.Notice();
            }
        });
        //添加图片 右下
        JLabel lbimg1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("imgs/chuji1.png");
        Image img1 = icon1.getImage();
        img1 = img1.getScaledInstance(270,200,Image.SCALE_DEFAULT);
        icon1.setImage(img1);
        lbimg1.setIcon(icon1);
        adjf.getLayeredPane().add(lbimg1);
        JPanel pl1 = new JPanel();
        pl1.add(lbimg);
        JPanel pl2 = new JPanel();
        pl2.add(lb1);
        pl2.add(lb2);
        pl2.add(lb3);
        pl2.add(lb4);
        pl2.add(lb5);
        pl2.setLayout(new FlowLayout());
        JPanel pl3 = new JPanel();
        pl3.add(lb6);
        pl3.add(lb7);
        pl3.add(lb8);
        pl3.add(lb9);
        pl3.add(lb10);
        pl3.add(bt);
        JPanel pl4 = new JPanel();
        pl4.add(lbimg1);
        adjf.add(pl1);
        adjf.add(pl2);
        adjf.add(pl3);
        adjf.add(pl4);
        adjf.setVisible(true);
    }
}
