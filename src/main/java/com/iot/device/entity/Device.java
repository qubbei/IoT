package com.iot.device.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author Mr.Qu
 * @title: Device
 * @since 2020/11/17 15:42
 */
@Data
@Accessors(chain = true)
public class Device implements Serializable {

  private String username;

  private long ts;

}
