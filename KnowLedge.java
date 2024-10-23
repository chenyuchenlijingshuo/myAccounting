package cn.itcast.accountinglearn.model;
public class KnowLedge { //知识点实体类
    Integer knowledgeid; //知识点id
     String knowledgename;//知识点名称
    Integer typeid;//知识点类别: 1.初级会计实务 2.经济法
    Integer number;//相关知识点数量
    String teacher;//知识点对应的老师
    String describe;//对知识点的描述
    String difficulty;//知识点的难度
    public Integer getKnowledgeid() {return knowledgeid;}
    public void setKnowledgeid(Integer knowledgeid) {
        this.knowledgeid = knowledgeid;
    }
    public String getKnowledgename() {
        return knowledgename;
    }
    public void setKnowledgename(String knowledgename) {
        this.knowledgename = knowledgename;
    }
    public Integer getTypeid() {
        return typeid;
    }
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
