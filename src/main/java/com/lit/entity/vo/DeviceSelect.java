package com.lit.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeviceSelect {
    private String roomID;
    private String roomName;
    private List<String> deviceName;
    private List<String> deviceID;
}
