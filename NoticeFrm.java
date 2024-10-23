package cn.itcast.accountinglearn.JFrame;

import javax.swing.*;
import java.awt.*;

public class NoticeFrm {
    //公告界面
    public static void main(String[] args) {
        Notice();

    }
    public static void Notice(){
        JFrame fm= new JFrame("陈雨晨的会计学习系统-今日公告");
        fm.setSize(600,350);
        fm.setLocation(550,300);
        fm.setLayout(new BorderLayout());
        //标题
        JLabel lbtitle = new JLabel("中华人民共和国财政部公告");
        Font titlefont = new Font("仿宋",Font.BOLD,30);
        lbtitle.setFont(titlefont);
        lbtitle.setForeground(new Color(247, 23, 35));
        //内容
        JLabel lbneirong1 = new JLabel("  根据《国务院关于同意开展服务贸易创新发展试点的批复》,");
        Font neirongfont = new Font("仿宋",Font.BOLD,20);
        lbneirong1.setFont(neirongfont);
        JLabel lbneirong2 = new JLabel("为做好服务贸易创新发展试点工作,落实《服务贸易创新发展试" );
        lbneirong2.setFont(neirongfont);
        JLabel lbneirong3 = new JLabel("点方案》提出的对试点地区进口国内急需的研发设计,节能环保");
        lbneirong3.setFont(neirongfont);
        JLabel lbneirong4 = new JLabel("和环境服务等给予贴息支持的要求,明确服务进口重点领域,促进");
        lbneirong4.setFont(neirongfont);
        JLabel lbneirong5 = new JLabel("相关产业健康发展,商务部会同发展改革委,财政部等有关部门共");
        lbneirong5.setFont(neirongfont);
        JLabel lbneirong6 = new JLabel("同编制了《鼓励进口服务的目录》,现予以发布");
        lbneirong6.setFont(neirongfont);
        //时间
        JLabel lbtime = new JLabel("                                       2024年6月27日");
        lbtime.setFont(neirongfont);
        JPanel pl1 = new JPanel();
        pl1.add(lbtitle);
        JPanel pl2 = new JPanel();
        pl2.add(lbneirong1);
        pl2.add(lbneirong2);
        pl2.add(lbneirong3);
        pl2.add(lbneirong4);
        pl2.add(lbneirong5);
        pl2.add(lbneirong6);
        JPanel pl3 =new JPanel();
        pl3.add(lbtime);
        fm.add(pl1,BorderLayout.PAGE_START);
        fm.add(pl2,BorderLayout.CENTER);
        fm.add(pl3,BorderLayout.PAGE_END);
        fm.setVisible(true);
    }
}
