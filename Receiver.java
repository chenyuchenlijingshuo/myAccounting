package cn.itcast.accountinglearn.utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver implements Runnable{  //计科22101陈雨晨 2205006192
    private int receiveport;//接收数据所对应的端口号
    //构造方法
    public Receiver(int receiveport){
        this.receiveport =receiveport;
    }
    public void run(){
        try{
            //创建一个socket对象
            DatagramSocket ds =new DatagramSocket(8000);
            //创建一个packet对象
            byte[]arr =new byte[1024];
            DatagramPacket dp =new DatagramPacket(arr,arr.length);
            //接收数据
            while(true){
                ds.receive(dp);
                //解析数据
                String str =new String(dp.getData(),0,dp.getLength());
                String ip =dp.getAddress().getHostAddress();
                System.out.println("收到"+ip+"发来的信息："+str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
