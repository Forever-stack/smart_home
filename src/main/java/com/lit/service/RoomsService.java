package com.lit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lit.entity.Rooms;
import com.lit.entity.vo.DeviceSelect;
import com.lit.entity.vo.RoomsDevicesInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomsService extends IService<Rooms> {
    public List<RoomsDevicesInfo> getRoomAndDevice(String familyID);
    List<DeviceSelect>  getDeviceSelect(String familyID);

}
