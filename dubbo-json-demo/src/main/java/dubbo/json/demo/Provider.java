package dubbo.json.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-provider.xml"});
        context.start();

        /*DemoService consumer = context.getBean("demoServiceConsumer", DemoService.class);
        System.out.println(consumer.sayHello("hello"));*/

        System.in.read(); // press any key to exit
    }
}
