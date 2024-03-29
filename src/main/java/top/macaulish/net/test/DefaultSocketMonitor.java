package top.macaulish.net.test;

import org.json.JSONObject;
import top.macaulish.net.core.socket.AbstractSocketMonitor;

public class DefaultSocketMonitor extends AbstractSocketMonitor {

    /**
     * 指定绑定的端口，并监听此端口
     *
     * @param port 本地网络端口
     */
    public DefaultSocketMonitor(int port) {
        super(port);
    }

    @Override
    protected JSONObject translate(String message) {
        return new JSONObject().put("data",message);
    }

    @Override
    protected String translate(JSONObject message) {
        return message.toString();
    }
}
