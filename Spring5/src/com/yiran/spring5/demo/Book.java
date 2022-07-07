package com.yiran.spring5.demo;

/**
 *  演示使用XML的Set方法进行属性注入。
 *
 * @author zh
 * @date 2022/07/06
 */
public class Book {

    private String bname;

    private String bauthor;

    // 创建属性对应的方法。
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }


    //    //有参构造
//    public Book(String bname) {
//        this.bname = bname;
//    }

//    public static void main(String[] args) {
//        Book book = new Book("Spring实战");
//        book.setBname("Java核心技术");
//    }


    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }
}
