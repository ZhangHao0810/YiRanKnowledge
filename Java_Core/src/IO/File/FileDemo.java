package IO.File;

import java.io.File;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 10:09
 * @Description：
 *  File类是 文件和目录路径名的抽象表示形式，File类的实例是不可变得。
 *
 *      注意不要被File内部的参数所迷惑，到底创建的是文件还是文件夹，要看File对象调用了什么样的方法。
 *
 *  File的常用功能
 *      创建文件 boolean createNewFile()  mkdir() 创建指定文件夹。
 *              mkdirs()创建指定文件夹，当文件夹所在目录不存在，顺道一块创建。......
 *      删除文件    boolean delete()
 *          *删除一个文件夹，文件夹下面不能有子文件和子文件夹。
 *          *删除(d//e//a) 删的是a，e和d依然保存。
 *          注意他所删除的文件不保存在Windows回收站。
 *      获取文件    File getAbsoluteFile()
 *                  String getAbsolutePath()
 *                  File getName()
 *                  File getParent()
 *                  File getParentFile()
 *                  ....
 *      判断文件功能 boolean exists()
 *                  boolean isAbsolute()
 *                  ......
 *
 */
public class FileDemo {
    public static void main(String[] args) {
        /*路径*/
//      File file=  new File("D:\\DATA\\IDEA DATA\\Crazy_Java 实例\\IO\\File");

        /*前面父路径，后面子路径*/
//        File file2=new File("D:\\\\DATA\\\\IDEA DATA\\\\Crazy_Java 实例\\\\IO","File");

        /*父路径对象，和子路径*/
//        File parent=new File("\"D:\\\\\\\\DATA\\\\\\\\IDEA DATA\\\\\\\\Crazy_Java 实例\\\\\\\\IO");
//        File file3=new File(parent,"File");
/*用匿名类*/
        File file4=new File(new File("D:\\\\DATA\\\\IDEA DATA\\\\Crazy_Java 实例\\\\IO"),"File.txt");

    }
}
