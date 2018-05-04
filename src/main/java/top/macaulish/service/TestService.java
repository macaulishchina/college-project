package top.macaulish.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestService {

    private static Logger logger = LoggerFactory.getLogger(TestService.class);
    @After(value = "execution(* top.macaulish.net.core.socket.MQTTMessageHandler.onAcceptMessage(..))&&args(message)")
    public void testAspect(JSONObject message){
        logger.info(this.getClass().getName()+"AOP Test");
        System.out.println("message");
    }
}
