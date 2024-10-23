package cn.itcast.accountinglearn.utils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender implements Runnable{
  private int sendport;//发送端的端口号

  public Sender(int sendport){
      this.sendport=sendport;
  }
  public void run(){   //计科22101陈雨晨 2205006192
      try{
          //创建一个socket对象
          DatagramSocket ds = new DatagramSocket();
          //键盘录入数据
          Scanner sc = new Scanner(System.in);
          while(true){
              String data =sc.nextLine();
              byte[] arr =data.getBytes();
              DatagramPacket dp = new DatagramPacket(arr,arr.length, InetAddress.getByName("localhost"),sendport);
              ds.send(dp);
          }
      }catch(Exception e){
          e.printStackTrace();
      }
  }
}
