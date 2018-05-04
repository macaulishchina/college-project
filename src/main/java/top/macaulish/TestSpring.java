package top.macaulish;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import top.macaulish.orm.MonitorInfoEntity;
import top.macaulish.service.MonitorServer;

public class TestSpring {

    @Test
    public void testHibernate(){
        System.out.println("hello world");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        MonitorServer monitorServer = context.getBean("monitorServer",MonitorServer.class);
        JSONObject json = new JSONObject();
        json.put("IMEI","123456789123456");
        json.put("date","02/22 22:22:22");
        json.put("latitude",3323.0064);
        json.put("longitude",12011.1166);
        json.put("IP","127.0.0.1");
        json.put("port",3301);
        json.put("speed",1);
        monitorServer.persistGISMessage(json);
//        HibernateTemplate template = context.getBean("hibernateTemplate",HibernateTemplate.class);
//        MonitorInfoEntity entity =  template.get(MonitorInfoEntity.class,123);
//        System.out.println(entity);

    }
}
