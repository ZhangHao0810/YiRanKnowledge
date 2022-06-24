package IO.BufferedStream;

import java.io.*;
import java.util.ArrayList;

/**
 * @author SuperZhang
 * @description BufferedStream 缓冲流的整合样例。
 * @since 2022/6/24 22:19
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        bufferedWriterDemo();
        bufferReaderDemo();
        fileCopyDemo();
    }

    /**
     * * BufferedWriter 将文本写入字符输出流，缓冲各个字符，提供单个字符，数组，和字符串的高效写入。
     * * BufferedReader 从字符输入流中读取文本，缓冲各个字符，从而实现字符，数组的高效读取。
     * *
     * *  用缓冲流进行文件的输入输出会更高效。
     * *  缓冲流的特殊功能。
     * *      BufferedWriter
     * *          void newLine() ：写一个换行符，这个换行符由系统决定。
     * *      BufferedReader
     * *          String readLine() : 一次读取一行数据，但是不读取换行符。没有数据了，返回NULL
     *
     * @since 2019/10/4 7:12
     */
    private static void bufferReaderDemo() throws IOException {
//        创建输入缓冲流对象
        FileReader fileReader = new FileReader("Java_Core/src/IO/BufferedStream/Array.txt");
        BufferedReader br = new BufferedReader(fileReader);

        /**
         * br.readLine() 一次性读一行
         */
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        /**
         * br.read()， 读一个字符。
         */
        int ch;
        while ((ch = br.read()) != -1) {
            System.out.print((char) ch);
        }
        /**
         * br.read(char[] chs),读数组长度的字符。缓冲读，每次读一行
         */
        char[] chs = new char[1024];
        int len;
        while ((len = br.read(chs)) != -1) {
            System.out.println(new String(chs, 0, len));
        }
        br.close();
    }

    /**
     * BufferedWriter，传入FileWriter。将字符串写入文件。
     *
     * @since 2019/10/4 8:49
     */
    private static void bufferedWriterDemo() throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello,I am ArrayList!");
        arrayList.add("you can see me~");
        arrayList.add("put your hands up!");

        FileWriter fileWriter = new FileWriter("Java_Core/src/IO/BufferedStream/Array.txt");
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (String s : arrayList) {
            bw.write(s);
            bw.newLine();  //加入换行
            bw.flush(); //刷新缓冲
        }
        bw.close();
    }

    private static void fileCopyDemo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Java_Core/src/IO/BufferedStream/Array.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("Java_Core/src/IO/BufferedStream/Array_Copy.txt"));
//      利用字符缓冲流的行读行写功能进行文件的复制。。
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }

}
