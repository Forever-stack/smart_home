package com.lit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lit.entity.Devices;

public interface DeviceService extends IService<Devices> {
    int changeSwitch(Devices devices);
}
