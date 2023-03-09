package com.lit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lit.Dao.DevicesDao;
import com.lit.Dao.RoomsDao;
import com.lit.entity.Devices;
import com.lit.entity.Rooms;
import com.lit.entity.vo.DeviceSelect;
import com.lit.entity.vo.RoomsDevicesInfo;
import com.lit.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
@Service
public class RoomsServiceImpl extends ServiceImpl<RoomsDao, Rooms> implements RoomsService {
    @Autowired
    RoomsDao roomsDao;
    @Autowired
    DevicesDao devicesDao;
    @Override
    public List<RoomsDevicesInfo> getRoomAndDevice(String familyID) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("familyID",familyID);
        List<RoomsDevicesInfo> roomsDevicesInfoList = new ArrayList<>();
        List<Rooms> rooms = roomsDao.selectList(qw);

        for(Rooms rooms1:rooms){
            QueryWrapper qw1 = new QueryWrapper();
            qw1.eq("roomID",rooms1.getRoomID());
            List<Devices> devicesList = devicesDao.selectList(qw1);
            RoomsDevicesInfo roomsDevicesInfo = new RoomsDevicesInfo();
            roomsDevicesInfo.setDevices(devicesList);
            roomsDevicesInfo.setRoomName(rooms1.getRoomName());
            roomsDevicesInfo.setRoomID(rooms1.getRoomID());
            roomsDevicesInfoList.add(roomsDevicesInfo);
        }
        return roomsDevicesInfoList;
    }

    public List<DeviceSelect>  getDeviceSelect(String familyID){
        List<DeviceSelect> deviceSelectList = new ArrayList<>();
        List<RoomsDevicesInfo> roomsDevicesInfoList = this.getRoomAndDevice(familyID);
        for (RoomsDevicesInfo rd:roomsDevicesInfoList) {
            DeviceSelect deviceSelect = new DeviceSelect();
            deviceSelect.setRoomID(rd.getRoomID());
            deviceSelect.setRoomName(rd.getRoomName());
            List<String> deviceNameList = new ArrayList<>();
            List<String> deviceIDList = new ArrayList<>();
            for (Devices dev:rd.getDevices() ) {
                deviceNameList.add(dev.getDeviceName());
                deviceIDList.add(dev.getDeviceID());
            }
            deviceSelect.setDeviceID(deviceIDList);
            deviceSelect.setDeviceName(deviceNameList);
            deviceSelectList.add(deviceSelect);
        }
        return deviceSelectList;
    }
}
