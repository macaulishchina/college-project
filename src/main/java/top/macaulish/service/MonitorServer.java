package top.macaulish.service;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.macaulish.dao.MonitorDao;
import top.macaulish.orm.MonitorInfoEntity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 常驻基础服务：持久化终端发送到消息队列的数据
 */
@Aspect
@Component
public class MonitorServer {

    private static Logger logger = LoggerFactory.getLogger(MonitorServer.class);

    @Autowired
    private MonitorDao monitor;

    @After(value = "execution(* top.macaulish.net.core.socket.MQTTMessageHandler.onAcceptMessage(..))&&args(message)")
    public void persistGISMessage(JSONObject message){
        logger.info("***"+new Date(System.currentTimeMillis())+":保存接收到的数据到数据库。**************");
        MonitorInfoEntity monitorInfo = new MonitorInfoEntity();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        try {
            monitorInfo.setHardwareDate(new Date(dateFormat.parse(message.getString("date")).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        monitorInfo.setImei(message.getString("IMEI"));
        monitorInfo.setLatitude(message.getDouble("latitude"));
        monitorInfo.setLongitude(message.getDouble("longitude"));
        monitorInfo.setMonitorDate(new Date(System.currentTimeMillis()));
        monitorInfo.setMonitorIp(message.getString("IP"));
        monitorInfo.setMonitorPort(message.getInt("port"));
        monitorInfo.setSpeed(message.getDouble("speed"));
        monitor.addMonitorInfo(monitorInfo);
    }



//    @Override
//    public void run() {
//        startPersist();
//    }
//
//    /**
//     * 启动持久化服务
//     * @return 启动成功返回真
//     */
//    private boolean startPersist(){
//        try {
//            new MoziMQTTHandler(MoziMQTTHandler.loadConfig()).work();
//        }catch (Exception e){
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 停止持久化服务
//     * @return 关闭成功返回真
//     */
//    public boolean stopPersist(){
//        return false;
//    }
}
