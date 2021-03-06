package dubbo.json.demo;

import org.apache.dubbo.config.annotation.Service;

import dubbo.demo.api.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String hello) {
        return hello + System.lineSeparator() + " new line";
    }
}
