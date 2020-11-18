package com.iot;

import com.iot.device.entity.Device;
import com.iot.device.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientApplicationTests {

  @Autowired
  private DeviceService deviceService;

  @Test
  void contextLoads() {
    deviceService
        .updateDeviceStatus(new Device().setUsername("qbb").setTs(System.currentTimeMillis()));
  }

}
