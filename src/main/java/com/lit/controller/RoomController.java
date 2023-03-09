package com.lit.controller;

import com.lit.entity.User;
import com.lit.entity.vo.RoomsDevicesInfo;
import com.lit.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/family")
public class RoomController {

    @Autowired
    RoomsService roomsService;
    @GetMapping("/roomsDevices")
    List<RoomsDevicesInfo> getRoomsDevices(HttpServletRequest request){
        String familyID = request.getHeader("familyID");
        System.out.println(familyID+"roomcontroller");
        System.out.println(roomsService.getRoomAndDevice(familyID));
       return roomsService.getRoomAndDevice(familyID);
    }
    @PostMapping("/getDeviceSelect")
    public List getDeviceSelect(HttpServletRequest request){
//        "roomID": "null",
//                "roomName": "请选择房间",
//                "devicesName": ["请先选择房间"],
//        "deviceID":[]
        String familyID = request.getHeader("familyID");
        System.out.println(roomsService.getDeviceSelect(familyID).toArray().toString());
        return roomsService.getDeviceSelect(familyID);
    }
}
