import com.yiran.spring5.config.SpringConfig;
import com.yiran.spring5.demo.Book;
import com.yiran.spring5.demo.Orders;
import com.yiran.spring5.demo.User;
import com.yiran.spring5.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring5
 *
 * @author Administrator
 * @date 2022/07/06
 */
public class TestSpring5 {


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
    public void testBook1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.setBname("testBook1");
    }

    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
    }

    @Test
    public void testAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }

}
