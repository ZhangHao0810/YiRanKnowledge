import com.yiran.spring5.demo.User;
import com.yiran.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring5
 *
 * @author Administrator
 * @date 2022/07/06
 */
public class TestBean {


    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        User mybean = context.getBean("myBean", User.class);
        mybean.add();
    }


}
