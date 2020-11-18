package com.iot.mqtt;

import com.iot.device.entity.Device;
import com.iot.device.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MQTT回调函数
 *
 * @author Mr.Qu
 * @since 2020/11/18
 */
@Slf4j
@Component
public class InitCallback implements MqttCallback {

  @Autowired
  private DeviceService deviceService;

  /**
   * MQTT 断开连接会执行此方法
   */
  @Override
  public void connectionLost(Throwable cause) {
    log.error(cause.getMessage(), cause);
  }

  /**
   * publish发布成功后会执行到这里
   */
  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }

  /**
   * subscribe订阅后得到的消息会执行到这里
   */
  @Override
  public void messageArrived(String topic, MqttMessage message) {
    log.info("[{}] : {}", topic, new String(message.getPayload()));
    deviceService
        .updateDeviceStatus(new Device().setUsername("qbb").setTs(System.currentTimeMillis()));
    /*try {
      JSONObject jsonObject = JSON.parseObject(msg);
      String clientId = String.valueOf(jsonObject.get("clientid"));
      if (topic.endsWith("/disconnected")) {
        log.info("客户端已掉线：{}", clientId);
      } else {
        log.info("客户端已上线：{}", clientId);
      }
    } catch (JSONException e) {
      log.error("JSON Format Parsing Exception : {}", msg);
    }*/
  }
}
