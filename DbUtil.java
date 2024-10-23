package cn.itcast.accountinglearn.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    String dbDriver="com.mysql.jdbc.Driver";
    String dbUrl="jdbc:mysql://localhost:3306/javaaccounting/serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
    String dbUserName="root";
    String dbPassWord="123456";
    public Connection getConnection ()throws Exception{
        //1.加载并注册数据库驱动
        Class.forName(dbDriver);
        //2.通过DriverManager获取数据库连接
        Connection con =(Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        return con;
    }
    public void closeCon(Connection con)throws Exception{
        //关闭连接,释放资源
        if(con!=null){
            con.close();
        }
    }

}
