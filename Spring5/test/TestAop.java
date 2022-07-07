import com.yiran.spring5.aop.anno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
