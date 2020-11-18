package com.iot.device.mapper;

import com.iot.device.entity.Device;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author Mr.Qu
 * @title: DeviceMapper
 * @since 2020/11/17 15:56
 */
@Repository
public interface DeviceMapper {

  boolean updateDeviceStatus(Device param);

}
