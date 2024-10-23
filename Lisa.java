package cn.itcast.accountinglearn.utils;

import java.util.Scanner;

public class Lisa {   //计科22101 陈雨晨 2205006192
    public static void main(String[] args) {
        System.out.println("我是Lisa，微信聊天欢迎你");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你的微信号(端口号)");
        int receiveport =sc.nextInt();
        System.out.println("请录入好友的微信号(端口号)");
        int sendport =sc.nextInt();
        //开启线程
        new Thread(new Receiver(receiveport)).start();
        new Thread(new Sender(sendport)).start();
    }
}
