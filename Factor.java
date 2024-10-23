package cn.itcast.accountinglearn.model;
public class Factor {
    //会计要素实体类
    Integer factorid;//会计要素id
    String factorname;//名称
    String factordefine;//定义
    String factorfeature;//特征
    String factorsource;//来源
    String factorclassify;//分类
    String factorconfirm;//确认条件
    public Integer getFactorid() {
        return factorid;
    }
    public void setFactorid(Integer factorid) {
        this.factorid = factorid;
    }
    public String getFactorname() {
        return factorname;
    }
    public void setFactorname(String factorname) {
        this.factorname = factorname;
    }
    public String getFactordefine() {
        return factordefine;
    }
    public void setFactordefine(String factordefine) {
        this.factordefine = factordefine;
    }
    public String getFactorfeature() {
        return factorfeature;
    }
    public void setFactorfeature(String factorfeature) {
        this.factorfeature = factorfeature;
    }
    public String getFactorsource() {
        return factorsource;
    }
    public void setFactorsource(String factorsource) {
        this.factorsource = factorsource;
    }
    public String getFactorclassify() {
        return factorclassify;
    }
    public void setFactorclassify(String factorclassify) {
        this.factorclassify = factorclassify;
    }
    public String getFactorconfirm() {
        return factorconfirm;
    }
    public void setFactorconfirm(String factorconfirm) {
        this.factorconfirm = factorconfirm;
    }
}
