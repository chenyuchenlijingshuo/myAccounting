package cn.itcast.accountinglearn.model;
public class   User{ //用户实体类 角色:1.学生端 2.教师端
    Integer userId; //用户id
    String userName;//用户姓名
    String password;//密码
    Integer role;//角色
    String sex;//性别
    String area; //籍贯
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getRole() {return role;}
    public void setRole(Integer role) {this.role = role;}
    public String getSex() {return sex;}
    public void setSex(String sex) {this.sex = sex;}
    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}
}
