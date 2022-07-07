package com.yiran.spring5.bean;

/**
 * 员工类
 *
 * @author zh
 * @date 2022/07/07
 */
public class Emp {

    private String ename;
    private String gender;

    //    员工属于某一个部门
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }
}
