package com.yiran.spring5.autowire;

/**
 * 员工类
 *
 * @author zh
 * @date 2022/07/07
 */
public class Emp {

    //    员工属于某一个部门
    private Dept dept;


    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
