package IO.BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 10:02
 * @Description：
 */
public class FileToArrayList {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("IO/FileWriter_Test2.txt"));

        ArrayList<String> arrayList=new ArrayList<>();

        String line;
        while ((line=br.readLine())!=null)
        arrayList.add(line);

        br.close();
        for (int i=0;i<arrayList.size();i++){
            String s= arrayList.get(i);
            System.out.println(s);
        }
    }
}
