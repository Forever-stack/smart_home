package com.lit.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lit.Dao.DevicesDao;
import com.lit.entity.Devices;
import com.lit.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DevicesDao, Devices> implements DeviceService {

    @Autowired
    DevicesDao devicesDao;

    @Override
    public int changeSwitch(Devices devices) {
        UpdateWrapper<Devices> uw = new UpdateWrapper<>();
        uw.eq("deviceID",devices.getDeviceID()).set("switchs",devices.isSwitchs());
        return devicesDao.update(null,uw);
    }
}
