package dubbo.json.demo;

import dubbo.demo.api.DemoService;

public class StubDemoService implements DemoService {
    private DemoService demoService;

    public StubDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public String sayHello(String hello) {
        System.out.println("stub service begin");
        String sayHello = demoService.sayHello(hello);
        System.out.println("stub service end");
        return sayHello;
    }
}
