package cn.itcast.accountinglearn.dao;

import cn.itcast.accountinglearn.model.KnowLedge;
import cn.itcast.accountinglearn.model.Situation;
import cn.itcast.accountinglearn.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    public User login (Connection con,User user)throws Exception{
        User resultUser = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql = "select * from user where username=? and password=?";
        PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
//        pstmt.setString(5, user.getSex());
//        pstmt.setString(6, user.getArea());
        ResultSet rs = pstmt.executeQuery();
        resultUser = new User();
        if(rs.next()){
//             resultUser.setUserId(rs.getInt("userid"));
             resultUser.setUserName(rs.getString("username"));
             resultUser.setSex(rs.getString("sex"));
            resultUser.setRole(rs.getInt("role"));
            resultUser.setArea(rs.getString("area"));

       }
        return resultUser;
    }
    //查询数据库中会计要素放入表格
    public static List<User> getAllSituation()throws Exception{
        List<User> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from user";
        PreparedStatement pst = con.prepareStatement(sql);
        try{
            User u =null;
            rs=pst.executeQuery();
            while(rs.next()){

                u = new User();
                int user_id =rs.getInt("user_id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                int role = rs.getInt("role");
                String sex = rs.getString("sex");
                String area = rs.getString("area");
                u.setUserId(user_id);
                u.setUserName(username1);
                u.setPassword(password1);
                u.setRole(role);
                u.setSex(sex);
                u.setArea(area);
                list.add(u);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
    //添加信息
    public static void adduser(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql="INSERT INTO user(user_id,username,password,role,sex,area)VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,u.getUserId());
        pst.setString(2,u.getUserName());
        pst.setString(3,u.getPassword());
        pst.setInt(4,u.getRole());
        pst.setString(5, u.getSex());
        pst.setString(6, u.getArea());
        pst.executeUpdate();
    }
    //修改信息
    public static int modifyuser(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE user SET username=?,password=?,role=?,sex=?,area=? WHERE user_id=? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(6,u.getUserId());
        pst.setString(1,u.getUserName());
        pst.setString(2,u.getPassword());
        pst.setInt(3,u.getRole());
        pst.setString(4,u.getSex());
        pst.setString(5,u.getArea());
        return pst.executeUpdate();
    }
    //删除学生信息
    public static void deleteuser(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url, username, password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "DELETE FROM user WHERE user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,u.getUserId());
        pst.executeUpdate();
    }
   public static User authenticateUser(String username, String password) {
        User user = null;
        String  url= "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username1 = "root";
        String Password = "123456";
        try {
            Connection connection = DriverManager.getConnection(url, username1, Password);
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
           if (resultSet.next())
            {   int user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                int role = resultSet.getInt("role");
                String gender = resultSet.getString("sex");
                String area = resultSet.getString("area");
                user = new User();
            }
              connection.close(); }
            catch (SQLException e)
                 { e.printStackTrace(); }
        return user; }
    //连接个人中心
    public  User  connectionpersonal(User user)throws Exception{
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url, username, password);
        User resultUser = null;
        String sql = "select * from user where username=? and password=?";
        PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
//        pstmt.setString(5, user.getSex());
//        pstmt.setString(6, user.getArea());
        ResultSet rs = pstmt.executeQuery();
        resultUser = new User();
        if(rs.next()){
//             resultUser.setUserId(rs.getInt("userid"));
            resultUser.setUserName(rs.getString("username"));
            resultUser.setSex(rs.getString("sex"));
            resultUser.setRole(rs.getInt("role"));
            resultUser.setArea(rs.getString("area"));

        }
        return resultUser;
    }
   //获取密码
    public static String getpassword(String user_id){
        String password ="";
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try{
            String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
            String username = "root";
            String password1 = "123456";
            connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT password FROM user WHERE user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user_id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                password = resultSet.getString("password");
                resultSet.getInt("user_id" );
            }else{
                return null;
            }
        }catch(Exception e){

        }
        return password;
    }

    public static User getusers(User u){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        User resultUser = new User();
        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, u.getUserName());
            statement.setString(2, u.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
//             resultUser.setUserId(rs.getInt("userid"));
                resultUser.setArea(resultSet.getString("area"));
            }
            resultUser.setArea(resultSet.getString("area"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultUser;
    }
    public static List<User> getFactor(int key)throws Exception{
        List<User> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con= DriverManager.getConnection(url,username,password);
        String sql =" select * from user Where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,key);
        try{
            User u =null;
            rs=pst.executeQuery();
            while(rs.next()){

                u = new User();
                int user_id =rs.getInt("user_id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                int role = rs.getInt("role");
                String sex = rs.getString("sex");
                String area = rs.getString("area");
                u.setUserId(user_id);
                u.setUserName(username1);
                u.setPassword(password1);
                u.setRole(role);
                u.setSex(sex);
                u.setArea(area);
                list.add(u);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
    //修改个人姓名
    public static int modifyname(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE user SET username=?WHERE user_id=? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(2,u.getUserId());
        pst.setString(1,u.getUserName());
        return pst.executeUpdate();
    }
    //修改密码
    public static int modifypassword(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE user SET password=?WHERE user_id=? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(2,u.getUserId());
        pst.setString(1,u.getPassword());
        return pst.executeUpdate();
    }
    //修改性别
    public static int modifysex(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE user SET sex=?WHERE user_id=? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(2,u.getUserId());
        pst.setString(1,u.getSex());
        return pst.executeUpdate();
    }
    //修改籍贯
    public static int modifyarea(User u) throws Exception {
        Connection con = null;
        //1.加载数据库的驱动到JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取PreparedStatement对象
        String sql = "UPDATE user SET area=?WHERE user_id=? ";
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        pst.setInt(2,u.getUserId());
        pst.setString(1,u.getArea());
        return pst.executeUpdate();
    }
}
