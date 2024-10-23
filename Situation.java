package cn.itcast.accountinglearn.model;
public class Situation {
    //学习情况实体类
    Integer userid;//用户id
    Integer knowledgeid;//知识点id
    String begin;//开始学习时间
    String end;//结束学习时间
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(Integer knowledgeid) {
        this.knowledgeid = knowledgeid;
    }


    public String getBegin() {
        return  begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return  end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
