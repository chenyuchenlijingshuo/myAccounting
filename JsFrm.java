package cn.itcast.accountinglearn.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class JsFrm extends JFrame implements ActionListener {
        // 第一行：计算式
        private JTextField expText = new JTextField();
        // 第二行：计算结果，设初始值为0
        private JTextField resultText = new JTextField("0");
        private String num1="",num2="";//两个操作数
        private String fh=""; //运算符
        private double r; //计算结果
        // 构造方法
        public JsFrm() {
            super("计算器");
            //各个按钮上的文字
            String[] keysValue= { "7", "8", "9", "÷", "4", "5", "6",
                    "×", "1", "2", "3", "-", "0","CE", "+","=" };
            //各个按钮上的动作命令标识
            String[] actionCmd= { "7", "8", "9", "/", "4", "5", "6",
                    "*", "1", "2", "3", "-", "0","CE", "+","=" };
            JButton keys[]=new JButton[keysValue.length];
            Font font=new Font("宋体",Font.PLAIN,18);
            //设置计算式文本框的位置为(10,10),宽为：240,高为：40
            expText.setBounds(10, 10, 240, 40);
            expText.setFont(font);
            expText.setBackground(Color.white);
            expText.setHorizontalAlignment(SwingConstants.RIGHT);
            expText.setEditable(false);// 计算式不能修改
            //设置计算结果文本框的大小
            resultText.setBounds(10, 50, 240, 40);
            resultText.setFont(font);
            resultText.setBackground(Color.white);
            //设置文本框的对齐方式：右对齐
            resultText.setHorizontalAlignment(SwingConstants.RIGHT);
            resultText.setEditable(false);// 计算结果不能修改
            // 设置窗口布局
            this.setLayout(null);
            this.add(expText);  // 将计算式文本框添加到窗口中
            this.add(resultText);// 将计算结果文本框添加到窗口中
            // 放置按钮
            int x=10,y=100;
            for (int i=0;i<keysValue.length;i++) {
                keys[i]=new JButton();
                keys[i].setText(keysValue[i]);
                keys[i].setActionCommand(actionCmd[i]);
                keys[i].setBounds(x,y,60,45);
                keys[i].setFont(font);
                if(x<=130) {
                    x+=60;
                } else {
                    x=10;
                    y+=50;
                }
                this.add(keys[i]);
            }
            // 给每个按钮添加监听
            for (int i=0;i<keysValue.length;i++) {
                keys[i].addActionListener(this);
            }
            // 窗口大小不能修改
            this.setResizable(false);
            // 设置窗口大小
            this.setSize(270, 350);
            //设置窗口的相对位置，位于屏幕中央
            this.setLocationRelativeTo(null);

            this.setVisible(true); // 设置窗口可见

        }

        //计算
        public void result(String z) {
            if(z.equals("+"))
                r=Double.parseDouble(num1)+Double.parseDouble(num2); //parseDouble可以将字符串转化为double值
            if(z.equals("-"))
                r=Double.parseDouble(num1)-Double.parseDouble(num2);
            if(z.equals("*"))
                r=Double.parseDouble(num1)*Double.parseDouble(num2);
            if(z.equals("/"))
                r=Double.parseDouble(num1)/Double.parseDouble(num2);
            num1=Double.toString(r);
            //将结果显示在文本框resultText中
            resultText.setText(num1);
            //算完后将  数2  和  运算符 清空
            num2="";
            fh="";
        }

        public void actionPerformed(ActionEvent e)throws IndexOutOfBoundsException{
            //e.getActionCommand()得到的是组件对象上的字符串
            String cmd=e.getActionCommand();
            if(cmd.equals("0")||cmd.equals("1")||cmd.equals("2")||cmd.equals("3")
                    ||cmd.equals("4")||cmd.equals("5")||cmd.equals("6")
                    ||cmd.equals("7")||cmd.equals("8")||cmd.equals("9")) {
                if(fh.equals("")) {
                    num1+=cmd;
                    expText.setText(num1);
                }
                else {
                    num2+=cmd;
                    expText.setText(num1+fh+num2);
                }
            }
            //运算
            if(cmd.equals("+")) {
                if(fh!="")
                    result(fh);//调用result函数计算结果,并将结果显示在文本框resultText中
                fh="+";
                //在计算式文本框中显示第一个数和符号
                expText.setText(num1+fh);
            }
            if(cmd.equals("-")) {
                if(fh!="")
                    result(fh);
                fh="-";
                expText.setText(num1+fh);
            }
            if(cmd.equals("*")) {
                if(fh!="")
                    result(fh);
                fh="*";
                expText.setText(num1+fh);
            }
            if(cmd.equals("/")) {
                if(fh!="")
                    result(fh);
                fh="/";
                expText.setText(num1+fh);
            }
            if(cmd.equals("=")) {
                result(fh);
            }
            // "CE"键清空数据
            if(cmd.equals("CE")) {
                num1="";
                num2="";
                fh="";
                expText.setText("");
                resultText.setText("0");
            }
        }
    }
