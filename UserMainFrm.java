package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserMainFrm extends JFrame {

    public static void UserMainPage(User user) {
        //主页面
        JFrame frame1 = new JFrame();
        frame1.setSize(700, 500);
        frame1.setLocation(500, 300);
        frame1.setTitle("陈雨晨的会计学习系统");
        //frame1.setLayout( new GridLayout(3,3));
        frame1.setLayout(new FlowLayout());
        //创建菜单栏组件JMeneBar
        JMenuBar menubar = new JMenuBar();
        //创建Jmenu菜单组件,并加入JMenubar
        JMenu menu1 = new JMenu(" 会计基础理论 ");
        JMenu menu2 = new JMenu(" 流动资产 ");
        JMenu menu3 = new JMenu(" 非流动资产 ");
        JMenu menu4 = new JMenu(" 负债 ");
        JMenu menu5 = new JMenu(" 所有者权益 ");
        JMenu menu6 = new JMenu(" 收入,费用和利润 ");
        JMenu menu7 = new JMenu(" 财务报告 ");
        JMenu menu8 = new JMenu(" 个人中心 ");
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        menubar.add(menu5);
        menubar.add(menu6);
        menubar.add(menu7);
        menubar.add(menu8);
        //创建JMenuItem菜单项组件,并加入JMenu
        //会计基础理论
        JMenuItem m1item1 = new JMenuItem("会计要素和会计等式");
        m1item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FactorFrm.factor();
            }
        });
        JMenuItem m1item2 = new JMenuItem("借贷记账法");
        JMenuItem m1item3 = new JMenuItem("财产清查");
        menu1.add(m1item1);
        menu1.addSeparator();
        menu1.add(m1item2);
        menu1.addSeparator();
        menu1.add(m1item3);
        //流动资产
        JMenuItem m2item1 = new JMenuItem("货币资金");
        JMenuItem m2item2 = new JMenuItem("交易性金融资产");
        JMenuItem m2item3 = new JMenuItem("应付及预付账款");
        JMenuItem m2item4 = new JMenuItem("存货");
        menu2.add(m2item1);
        menu2.addSeparator();
        menu2.add(m2item2);
        menu2.addSeparator();
        menu2.add(m2item3);
        menu2.addSeparator();
        menu2.add(m2item4);
        //非流动资产
        JMenuItem m3item1 = new JMenuItem("固定资产");
        JMenuItem m3item2 = new JMenuItem("无形资产");
        JMenuItem m3item3 = new JMenuItem("投资性房地产");
        JMenuItem m3item4 = new JMenuItem("长期股权投资");
        JMenuItem m3item5 = new JMenuItem("长期待摊费用");
        menu3.add(m3item1);
        menu3.addSeparator();
        menu3.add(m3item2);
        menu3.addSeparator();
        menu3.add(m3item3);
        menu3.addSeparator();
        menu3.add(m3item4);
        menu3.addSeparator();
        menu3.add(m3item5);
        //负债
        JMenuItem m4item1 = new JMenuItem("短期借款");
        JMenuItem m4item2 = new JMenuItem("应付职工薪酬");
        JMenuItem m4item3 = new JMenuItem("非流动负债");
        menu4.add(m4item1);
        menu4.addSeparator();
        menu4.add(m4item2);
        menu4.addSeparator();
        menu4.add(m4item3);
        //所有者权益
        JMenuItem m5item1 = new JMenuItem("实收资本");
        JMenuItem m5item2 = new JMenuItem("资本公积");
        JMenuItem m5item3 = new JMenuItem("其他综合收益");
        JMenuItem m5item4 = new JMenuItem("留存收益");
        menu5.add(m5item1);
        menu5.addSeparator();
        menu5.add(m5item2);
        menu5.addSeparator();
        menu5.add(m5item3);
        menu5.addSeparator();
        menu5.add(m5item4);
        //收入费用利润
        JMenuItem m6item1 = new JMenuItem("收入");
        JMenuItem m6item2 = new JMenuItem("费用");
        JMenuItem m6item3 = new JMenuItem("利润");
        menu6.add(m6item1);
        menu6.addSeparator();
        menu6.add(m6item2);
        menu6.addSeparator();
        menu6.add(m6item3);
        //财务报告
        JMenuItem m7item1 = new JMenuItem("资产负债表");
        JMenuItem m7item2 = new JMenuItem("利润表");
        JMenuItem m7item3 = new JMenuItem("现金流量表");
        JMenuItem m7item4 = new JMenuItem("所有者权益变动表");
        JMenuItem m7item5 = new JMenuItem("附注");
        menu7.add(m7item1);
        menu7.addSeparator();
        menu7.add(m7item2);
        menu7.addSeparator();
        menu7.add(m7item3);
        menu7.addSeparator();
        menu7.add(m7item4);
        menu7.addSeparator();
        menu7.add(m7item5);
        //产品成本核算
        JMenuItem m8item1 = new JMenuItem("进入");
        menu8.add(m8item1);
        m8item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalFrm.personalcenter(user);
                // todo 个人中心页面
            }
        });
        // 设置考试日期
        LocalDate examDate = LocalDate.of(2025, 12, 31); // 假设考试日期为2025年12月31日
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 计算距离考试的天数
        long daysUntilExam = ChronoUnit.DAYS.between(currentDate, examDate);
        JLabel lbtime = new JLabel("距离考试还剩" + daysUntilExam + "天");
        Font timefont = new Font("仿宋", Font.BOLD, 25);
        lbtime.setFont(timefont);
        lbtime.setForeground(new Color(0, 202, 177));
        JPanel pltime = new JPanel();
        pltime.add(lbtime);
        //文本域
        JTextArea ta1 = new JTextArea("请输入你的目标", 10, 50);
        //滚动面板
        JScrollPane sp1 = new JScrollPane(ta1);
        //垂直滚动条总是可见
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //文本域可编辑
        ta1.setEditable(true);
        //新建打开保存按钮
        JButton newbuilt = new JButton(" 新 建 ");
        JScrollPane spnewbuilt = new JScrollPane();
        spnewbuilt.setSize(500, 300);
        JTextArea ta = new JTextArea();
        newbuilt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JTextArea ta = new JTextArea();
                        /*spnewbuilt.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        spnewbuilt.setViewportView(ta);
                        ta.setVisible(true);*/

            }
        });
        JButton open = new JButton(" 打 开 ");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(null);
                jf.setVisible(true);
                File file = jf.getSelectedFile();
                try {
                    FileReader fr = new FileReader(file);
                    String ts = "";
                    String tt = "";
                    BufferedReader inf = new BufferedReader(fr);
                    while ((tt = inf.readLine()) != null) {
                        ts += tt + "\r\n";
                    }
                    ta.setText(ts);
                    spnewbuilt.setViewportView(ta);

                    ta.setEditable(true);
                    inf.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton save = new JButton(" 保 存 ");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                jf.showSaveDialog(null);
                jf.setVisible(true);
                File file = jf.getSelectedFile();
                FileWriter fa;
                try {
                    fa = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fa);
                    String tx = ta.getText();
                    bw.write(tx);
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JPanel plbutton = new JPanel();
        plbutton.add(newbuilt);
        plbutton.add(open);
        plbutton.add(save);
        //插入图片
        JLabel lbimg = new JLabel();
        ImageIcon imic = new ImageIcon("imgs/background.png");
        Image img = imic.getImage();
        img = img.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        imic.setImage(img);
        lbimg.setIcon(imic);
        frame1.getLayeredPane().add(lbimg);
        JPanel plimg = new JPanel();
        plimg.add(lbimg);
        JLayeredPane pane = new JLayeredPane();  // 分层网格
        JPanel panel1 = new JPanel();
        JButton buttonimg = new JButton("欢迎进入社区交流");
        buttonimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // ComUserFrm.communication();
                try {
                    UserComFrm us = new UserComFrm("localhost", 4445);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ImageIcon image;
        image = new ImageIcon("jimgs/background.png");
        //设置组件透明
        buttonimg.setOpaque(false);
        JLabel label = new JLabel(image);        //把背景图片添加到标签里
        panel1 = (JPanel) frame1.getContentPane();    //把我的面板设置为内容面板
        panel1.add(label);
        buttonimg.setBounds(265, 415, 140, 30);
        pane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        pane.add(buttonimg, JLayeredPane.MODAL_LAYER);
        frame1.setLayeredPane(pane);
        //弹出菜单
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem calculator = new JMenuItem("计算器");
        // 添加计算器菜单项的动作监听器
        calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建一个计算器窗口并显示
                JsFrm calculatorWindow = new JsFrm();
                calculatorWindow.setVisible(true);
            }
        });
        popupMenu.add(calculator);
        frame1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果单击鼠标右键,显示JPopMenu菜单
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        //将面板插入窗口
        frame1.add(sp1);
        frame1.add(plbutton);
        frame1.add(pltime);
        frame1.add(plimg);
        frame1.setJMenuBar(menubar);
        //窗口设置可见
        frame1.setVisible(true);
    }
}

