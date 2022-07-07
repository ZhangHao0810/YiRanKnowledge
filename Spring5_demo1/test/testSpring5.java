import com.yiran.spring5.Book;
import com.yiran.spring5.User;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring5
 *
 * @author Administrator
 * @date 2022/07/06
 */
public class testSpring5 {


    @Test
    public void testAdd() {
//        1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //可以换用另一个容器 BeanFactory，效果相同
        BeanFactory factory = new ClassPathXmlApplicationContext("bean1.xml");
//        2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        factory.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

    /**
     * 测试book1,基于XML set 方法进行属性的注入。
     */
    @Test
    public void testBook1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.setBname("testBook1");
    }

}
