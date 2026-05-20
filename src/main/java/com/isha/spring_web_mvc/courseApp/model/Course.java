package com.isha.spring_web_mvc.courseApp.model;

// model
public class Course
{

    private Integer cid;
    private String cname;
    private Double cprice;


    // getters and setters

    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    // to string method
    public String toString()
    {
        return "[ cid = "+cid+ " cname = "+ cname+" cprice = "+cprice+" ]";
    }
}
