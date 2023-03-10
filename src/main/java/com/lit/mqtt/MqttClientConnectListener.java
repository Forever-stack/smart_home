package com.lit.mqtt;

import net.dreamlu.iot.mqtt.core.client.MqttClientCreator;
import net.dreamlu.iot.mqtt.spring.client.event.MqttConnectedEvent;
import net.dreamlu.iot.mqtt.spring.client.event.MqttDisconnectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MqttClientConnectListener {
    private static final Logger logger = LoggerFactory.getLogger(MqttClientConnectListener.class);

    @Autowired
    private MqttClientCreator mqttClientCreator;

    @EventListener
    public void onConnected(MqttConnectedEvent event) {
        logger.info("MqttConnectedEvent:{}", event);
    }

    @EventListener
    public void onDisconnect(MqttDisconnectEvent event) {
        // 离线时更新重连时的密码，适用于类似阿里云 mqtt clientId 连接带时间戳的方式
        logger.info("MqttDisconnectEvent:{}", event);
        // 在断线时更新 clientId、username、password
        mqttClientCreator.clientId("newClient" + System.currentTimeMillis())
                .username("newUserName")
                .password("newPassword");
    }

}