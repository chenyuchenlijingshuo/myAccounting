package cn.itcast.accountinglearn.dao;

import cn.itcast.accountinglearn.model.KnowLedge;
import cn.itcast.accountinglearn.model.Situation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagUserDao {
    public static void main(String[] args) throws Exception {
        getAllSituation();
    }
    //查询数据库中会计要素放入表格
    public static List<Situation> getAllSituation()throws Exception{
        List<Situation> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from situation";
        PreparedStatement pst = con.prepareStatement(sql);
        try{
            Situation situation= null;
            rs=pst.executeQuery();
            while(rs.next()){
                situation =new Situation();
                int user_id =rs.getInt("user_id");
                int konwledge_id = rs.getInt("idknowledge_points");
                Date begin = rs.getDate("begin");
                Date end = rs.getDate("end");

                situation.setUserid(user_id);
                situation.setKnowledgeid(konwledge_id);
                situation.setBegin(String.valueOf(begin));
                situation.setEnd(String.valueOf(end));
                list.add(situation);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
    //添加
    public static void addmanaguser(Situation s) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql="INSERT INTO situation(user_id,idknowledge_points,begin,end)VALUES (?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,s.getUserid());
        pst.setInt(2,s.getKnowledgeid());
        pst.setString(3,s.getBegin());
        pst.setString(4, s.getEnd());
        pst.executeUpdate();
    }
    //修改
    public static int modifymanaguser(Situation s) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE situation SET begin=?,end=? WHERE user_id=? AND idknowledge_points = ?";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(3,s.getUserid());
        pst.setInt(4,s.getKnowledgeid());
        pst.setString(1,s.getBegin());
        pst.setString(2, s.getEnd());
        return pst.executeUpdate();
    }
    //删除
    public static void deletemanaguser(Situation s) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql="DELETE FROM situation WHERE user_id=? AND idknowledge_points = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,s.getUserid());
        pst.setInt(2,s.getKnowledgeid());
        pst.executeUpdate();
    }
    public static List<Situation> getFactor(int key1,int key2)throws Exception{
        List<Situation> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from situation Where user_id=? AND idknowledge_points=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,key1);
        pst.setInt(2,key2);
        try{
            Situation situation= null;
            rs=pst.executeQuery();
            while(rs.next()){
                situation =new Situation();
                int user_id =rs.getInt("user_id");
                int konwledge_id = rs.getInt("idknowledge_points");
                Date begin = rs.getDate("begin");
                Date end = rs.getDate("end");

                situation.setUserid(user_id);
                situation.setKnowledgeid(konwledge_id);
                situation.setBegin(String.valueOf(begin));
                situation.setEnd(String.valueOf(end));
                list.add(situation);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
}
