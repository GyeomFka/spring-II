package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 모든_빈_출력하기() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);//object가 뿌려진다.
            System.out.println(" name = " + beanDefinitionName + " object = " + bean) ;
        }
    }

    @Test
    void 스프링의_디폴트_빈_말고_애플리케이션_빈만_출력하기() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);//object가 뿌려진다.
                System.out.println(" name = " + beanDefinitionName + " object = " + bean) ;
            }
        }
    }
}
