package cn.itcast.accountinglearn.dao;

import cn.itcast.accountinglearn.model.Factor;

import javax.lang.model.element.NestingKind;
import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FactorDao {
    //查询数据库中会计要素放入表格
    public static List <Factor> getAllFactor()throws Exception{
        List<Factor> list = new ArrayList<>();
        Connection con =null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/javaaccounting?serverTimezone=GMT%2B8  &  useSSL=true & characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        con=DriverManager.getConnection(url,username,password);
        String sql =" select * from factor";
        PreparedStatement pst = con.prepareStatement(sql);
        try{
            Factor factor = null;
            rs=pst.executeQuery();
            while(rs.next()){
                factor =new Factor();
                int factorid =rs.getInt("factorid");
                String factor_name =rs.getString("factor name");
                String factor_define = rs.getString("factor define");
                String factor_feature = rs.getString("factor feature");
                String factor_source = rs.getString("factor source");
                String factor_classify = rs.getString("factor classify");
                String factor_confirm = rs.getString("factor confirm");

                factor.setFactorid(factorid);
                factor.setFactorname(factor_name);
                factor.setFactordefine(factor_define);
                factor.setFactorfeature(factor_feature);
                factor.setFactorsource(factor_source);
                factor.setFactorclassify(factor_classify);
                factor.setFactorconfirm(factor_confirm);
                list.add(factor);
            }
            return list;
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }
}
