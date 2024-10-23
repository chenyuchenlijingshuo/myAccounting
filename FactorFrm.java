
package cn.itcast.accountinglearn.JFrame;

import cn.itcast.accountinglearn.dao.FactorDao;
import cn.itcast.accountinglearn.model.Factor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class FactorFrm {
    public static void main(String[] args) {
      factor();
    }
    public static void factor(){
        //会计要素界面
        JFrame fmfactor = new JFrame("陈雨晨的会计学习系统");
        fmfactor.setSize(900,750);
        fmfactor.setLocation(420,200);
        //创建表格
        Object [] columnTitle = {"序号","名称","定义","特征","来源","分类","证明"};
        Object [][]tableDate ={};
        DefaultTableModel dm =new DefaultTableModel(tableDate,columnTitle);
        JTable table = new JTable(dm);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setSize(800,200);
        jsp.setLocation(50,20);
        //将数据库的内容放入表格
            List<Factor>list =null;
            try{
                list = FactorDao.getAllFactor();
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }
        for (int i = 0; i < list.size(); i++) {
            Factor factor = list.get(i);
            dm.addRow(new Object[]{factor.getFactorid(),factor.getFactorname(),factor.getFactordefine(),factor.getFactorfeature(),factor.getFactorsource(),factor.getFactorclassify(),factor.getFactorconfirm()});
        }
        //占位符
        JLabel zhanwei1 = new JLabel();
        JLabel zhanwei2 = new JLabel();
        JLabel zhanwei3 = new JLabel();
        //添加图片
        //六个label
        JLabel lb1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("imgs/zichan.png");
        Image img1 = icon1.getImage();
        img1 = img1.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon1.setImage(img1);
        lb1.setIcon(icon1);
        JLabel lb2 = new JLabel();
        ImageIcon icon2 = new ImageIcon("imgs/fuzhai.png");
        Image img2 = icon2.getImage();
        img2 = img2.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon2.setImage(img2);
        lb2.setIcon(icon2);
        JLabel lb3 = new JLabel();
        ImageIcon icon3 = new ImageIcon("imgs/suoyouzhe.png");
        Image img3 = icon3.getImage();
        img3 = img3.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon3.setImage(img3);
        lb3.setIcon(icon3);
        JLabel lb4 = new JLabel();
        ImageIcon icon4 = new ImageIcon("imgs/shouru.png");
        Image img4 = icon4.getImage();
        img4 = img4.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon4.setImage(img4);
        lb4.setIcon(icon4);
        JLabel lb5 = new JLabel();
        ImageIcon icon5 = new ImageIcon("imgs/feiyong.png");
        Image img5= icon5.getImage();
        img5 = img5.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon5.setImage(img5);
        lb5.setIcon(icon5);
        JLabel lb6 = new JLabel();
        ImageIcon icon6 = new ImageIcon("imgs/lirun.png");
        Image img6 = icon6.getImage();
        img6 = img6.getScaledInstance(250,200,Image.SCALE_DEFAULT);
        icon6.setImage(img6);
        lb6.setIcon(icon6);
        fmfactor.getLayeredPane().add(lb1);
        //Jpanel下部分
        JPanel pl =new JPanel();
        pl.setLayout(new GridLayout(3,3,10,20));
        pl.add(zhanwei1);
        pl.add(zhanwei2);
        pl.add(zhanwei3);
        pl.add(lb1);
        pl.add(lb2);
        pl.add(lb3);
        pl.add(lb4);
        pl.add(lb5);
        pl.add(lb6);
        fmfactor.add(jsp);
        fmfactor.add(pl);
        fmfactor.setVisible(true);
    }
}
