package salmon;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.macaulish.service.MonitorServer;

@SpringBootApplication
public class SalmonApplication {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

	public static void main(String[] args) {
		SpringApplication.run(SalmonApplication.class, args);
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
	}
}
