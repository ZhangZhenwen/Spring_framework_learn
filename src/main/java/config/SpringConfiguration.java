package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * created by IntelliJ IDEA
 *
 * 配置类 和bean.xml一致
 * Spring中的新注解
 * @Configuration
 *      作用：指定当前类是个配置类
 *      当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以buxie
 * @ComponentScan
 *      作用：通过注解指定Spring在创建容器时要扫描的包
 *      属性：
 *          value：指定创建容器时，要扫描的包
 *                 使用此注解就等同于在xml中配置了
 * @Bean
 *      作用：把当前方法的返回值作为bean对象存入Ioc容器中
 *      属性 ：
 *          name：用于指定bean的id，默认值：当前方法的名称
 *      注解配置方式时，如果方法有参数，Spring会去容器中查找有没有可用的bean对象
 *      和autowried注解的作用一样
 * @Import
 *      作用：导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码
 *                 当我们使用Import的注解之后，有Import注解的类就是父配置类，导入的都是子配置类
 * @propertySource
 *      作用：用于指定properties文件的文字
 *      属性：
 *          value：指定文件的名称和路径  关键字：classpath 类路径下
 *
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/17
 */
@ComponentScan(basePackages = {"com.zhenwen"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
