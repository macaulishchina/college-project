package top.macaulish.net.core.socket;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Mozi开发版消息交互支持类
 * 基于Socket通信和MQTT协议
 */
@Component
public class MoziMQTTHandler {

    private static Logger logger = LoggerFactory.getLogger(MoziMQTTHandler.class);

    @Autowired
    private MQTTMessageHandler handler;

    /**
     * 读取配置文件，读取文件的位置和优先级参见MonitorConfig接口实现
     * 如果配置文件不存在，根据默认属性创建配置文件
     *
     * @return 包含配置信息的对象
     */
    public static MonitorConfig loadConfig() {
        File configFile = new File("./monitor.config");
        FileOutputStream fos = null;
        PrintWriter pw = null;

        if (!configFile.exists()) {   //配置文件不存在
            try {
                configFile.createNewFile();
                fos = new FileOutputStream(configFile);
                pw = new PrintWriter(fos);
                MonitorConfig config = ConfigFactory.create(MonitorConfig.class);
                String conStr = config.toString().substring(1,config.toString().length()-1);
                conStr = conStr.replaceAll(", ",System.getProperty("line.separator"));
                pw.write(conStr.toCharArray());
                pw.flush();
                logger.info("create new config file to " + configFile.getAbsolutePath());
                return config;
            } catch (Exception e) {
                logger.info("fail to create new config file to " + configFile.getAbsolutePath());
                e.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        logger.info("load config file from " + configFile.getAbsolutePath());
        return ConfigFactory.create(MonitorConfig.class);
    }

    public void work() {
        handler.work();
    }

    public static void main(String args[]){
        ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        ac.getBean("moziMQTTHandler",MoziMQTTHandler.class).work();
    }
}
