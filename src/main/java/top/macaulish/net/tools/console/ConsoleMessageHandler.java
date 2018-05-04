package top.macaulish.net.tools.console;

import org.json.JSONObject;
import top.macaulish.net.core.socket.AbstractMessageHandler;
import top.macaulish.net.test.DefaultSocketMonitor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleMessageHandler extends AbstractMessageHandler {

    public ConsoleMessageHandler(DefaultSocketMonitor defaultSocketMonitor) {
        super();
    }

    @Override
    public void onAcceptMessage(JSONObject message) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println(sdf.format(date)+" :"+message.toString());
    }

    @Override
    public void onDeliverMessage(JSONObject message) throws Exception {

    }

    @Override
    public void work() {

    }

}
