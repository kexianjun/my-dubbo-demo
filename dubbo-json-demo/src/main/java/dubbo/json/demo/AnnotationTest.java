package dubbo.json.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import dubbo.demo.api.DemoService;
import org.springframework.stereotype.Component;

@Component(value = "annotationTest")
public class AnnotationTest {
    @Reference
    private DemoService demoService;

    public void demoServiceTest(String hello) {
        System.out.println(demoService.sayHello(hello));
    }
}
