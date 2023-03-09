package com.lit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lit.Dao.UserDao;
import com.lit.entity.Devices;
import com.lit.entity.Rooms;
import com.lit.entity.User;
import com.lit.entity.vo.RoomsDevicesInfo;
import com.lit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> login(User user) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("userName",user.getUserName());
        qw.eq("password",user.getPassword());
        List<User> userList = userDao.selectList(qw);
        return userList;
    }

    @Override
    public List<User> getByUserID(String userID) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("userID",userID);
        List userList = userDao.selectList(qw);
        return userList;
    }
    @Override
    public List<RoomsDevicesInfo> getRoomAndDevice(String familyID) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("familyID",familyID);
        List<RoomsDevicesInfo> roomsDevicesInfoList = new LinkedList<>();
        List<Rooms> rooms = userDao.selectList(qw);

        for(Rooms rooms1:rooms){
            QueryWrapper qw1 = new QueryWrapper();
            qw1.eq("roomID",rooms1.getRoomID());
            List<Devices> devicesList = userDao.selectList(qw1);
            RoomsDevicesInfo roomsDevicesInfo = new RoomsDevicesInfo();
            roomsDevicesInfo.setDevices(devicesList);
            roomsDevicesInfo.setRoomName(rooms1.getRoomName());
            roomsDevicesInfo.setRoomID(rooms1.getRoomID());
            roomsDevicesInfoList.add(roomsDevicesInfo);
        }
        return roomsDevicesInfoList;
    }
}
