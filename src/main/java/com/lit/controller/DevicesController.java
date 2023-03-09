package com.lit.controller;


import com.lit.entity.Devices;
import com.lit.service.DeviceService;
import com.lit.utils.JwtUitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/device")
public class DevicesController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    JwtUitls jwtUitls;
    @PostMapping("/switch")
    int changeSwitch(@RequestBody Devices devices ,HttpServletRequest request){
        System.out.println(devices+"===============================");
        int num =deviceService.changeSwitch(devices);
        System.out.println(num+"修改之后===============================");
        if (num>0){
            return num;
        }else {
            return -1;
        }
    }

}
