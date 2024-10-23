package cn.itcast.accountinglearn.dao;

import cn.itcast.accountinglearn.model.Factor;
import cn.itcast.accountinglearn.model.KnowLedge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KowDao {
    //查询数据库中会计要素放入表格
    public static List<KnowLedge> getAllFactor()throws Exception{
        List<KnowLedge> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from knowledge_points";
        PreparedStatement pst = con.prepareStatement(sql);
        try{
            KnowLedge knowLedge = null;
            rs=pst.executeQuery();
            while(rs.next()){
                knowLedge =new KnowLedge();
                int idknowledge_points =rs.getInt("idknowledge_points");
                String konwledge_name =rs.getString("knowledge_name");
                int type_id = rs.getInt("type_id");
                int number = rs.getInt("number");
                String teacher = rs.getString("teacher");
                String describe = rs.getString("describe1");
                String difficulty = rs.getString("difficulty");

                knowLedge.setKnowledgeid(idknowledge_points);
                knowLedge.setKnowledgename(konwledge_name);
                knowLedge.setTypeid(type_id);
                knowLedge.setNumber(number );
                knowLedge.setTeacher(teacher);
                knowLedge.setDescribe(describe);
                knowLedge.setDifficulty(difficulty);
                list.add(knowLedge);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
    //添加
    public static void addkow(KnowLedge k) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql="INSERT INTO knowledge_points(idknowledge_points,knowledge_name,type_id,number,teacher,describe1,difficulty)VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,k.getKnowledgeid());
        pst.setString(2,k.getKnowledgename());
        pst.setInt(3,k.getTypeid());
        pst.setInt(4,k.getNumber());
        pst.setString(5,k.getTeacher());
        pst.setString(6,k.getDescribe());
        pst.setString(7,k.getDifficulty());
        pst.executeUpdate();
    }
    //修改
    public static int modifykow(KnowLedge k) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE knowledge_points SET knowledge_name=?,type_id=?,number=?,teacher=?,describe1=?,difficulty=?  WHERE  idknowledge_points = ? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(7,k.getKnowledgeid());
        pst.setString(1,k.getKnowledgename());
        pst.setInt(2,k.getTypeid());
        pst.setInt(3,k.getNumber());
        pst.setString(4,k.getTeacher());
        pst.setString(5,k.getDescribe());
        pst.setString(6,k.getDifficulty());
        return pst.executeUpdate();
    }
    //删除
    public static void deletekow(KnowLedge k) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql="DELETE FROM knowledge_points WHERE idknowledge_points=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,k.getKnowledgeid());
        pst.executeUpdate();
    }
    public static List<KnowLedge> getFactor(int key)throws Exception{
        List<KnowLedge> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from knowledge_points Where idknowledge_points=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,key);
        try{
            KnowLedge knowLedge = null;
            rs=pst.executeQuery();
            while(rs.next()){
                knowLedge =new KnowLedge();
                int idknowledge_points =rs.getInt("idknowledge_points");
                String konwledge_name =rs.getString("knowledge_name");
                int type_id = rs.getInt("type_id");
                int number = rs.getInt("number");
                String teacher = rs.getString("teacher");
                String describe = rs.getString("describe1");
                String difficulty = rs.getString("difficulty");

                knowLedge.setKnowledgeid(idknowledge_points);
                knowLedge.setKnowledgename(konwledge_name);
                knowLedge.setTypeid(type_id);
                knowLedge.setNumber(number );
                knowLedge.setTeacher(teacher);
                knowLedge.setDescribe(describe);
                knowLedge.setDifficulty(difficulty);
                list.add(knowLedge);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
    public static List<KnowLedge> add(KnowLedge k)throws Exception{
        List<KnowLedge> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql ="INSERT INTO knowledge_points(idknowledge_points,knowledge_name,type_id,number,teacher,describe1,difficulty)VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,k.getKnowledgeid());
        pst.setString(2,k.getKnowledgename());
        pst.setInt(3,k.getTypeid());
        pst.setInt(4,k.getNumber());
        pst.setString(5,k.getTeacher());
        pst.setString(6,k.getDescribe());
        pst.setString(7,k.getDifficulty());
        pst.executeUpdate();
        try{
            KnowLedge knowLedge = null;
            rs=pst.executeQuery();
            while(rs.next()){
                knowLedge =new KnowLedge();
                int idknowledge_points =rs.getInt("idknowledge_points");
                String konwledge_name =rs.getString("knowledge_name");
                int type_id = rs.getInt("type_id");
                int number = rs.getInt("number");
                String teacher = rs.getString("teacher");
                String describe = rs.getString("describe1");
                String difficulty = rs.getString("difficulty");

                knowLedge.setKnowledgeid(idknowledge_points);
                knowLedge.setKnowledgename(konwledge_name);
                knowLedge.setTypeid(type_id);
                knowLedge.setNumber(number );
                knowLedge.setTeacher(teacher);
                knowLedge.setDescribe(describe);
                knowLedge.setDifficulty(difficulty);
                list.add(knowLedge);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
}
