package com.lit.controller;


import com.alibaba.fastjson.JSONObject;
import com.lit.entity.Devices;
import com.lit.entity.Mode;
import com.lit.entity.Modeinfo;
import com.lit.entity.User;
import com.lit.entity.vo.ModeAdd;
import com.lit.service.ModeService;
import com.lit.service.UserService;
import com.lit.utils.JwtUitls;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郑ang
 * @since 2023-03-02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    public  String helloword(HttpServletRequest request){
        request.getRequestURL();
        return "helloword";
    }

    @Autowired
    UserService userService;

    @Autowired
    ModeService modeService;
    @Autowired
    JwtUitls jwtUitls;
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletRequest request) {
        User getInfo;
        if (userService.login(user).size()>0){
            getInfo =  userService.login(user).get(0);
        }else{
            return "登录失败";
        }
        JSONObject json = new JSONObject();  //创建Json对象
        json.put("username", user.getUserName());         //设置Json对象的属性
        json.put("userID",getInfo.getUserID());
        json.put("familyID",getInfo.getFamilyID());
        System.out.println(json.toString());  //调用toString方法将json对象转换成json字符串
        System.out.println(userService.login(user));
        System.out.println(request.getRequestURL()+"request url");

        String pwd1 = DigestUtils.md5Hex(user.getPassword()).toUpperCase();
        if (userService.login(user).size()==1){
            String pwd2 = getInfo.getPassword();
            pwd2 = DigestUtils.md5Hex(pwd2).toUpperCase();
            if (pwd1.equals(pwd2)){
                String token = jwtUitls.createToken(getInfo.getUserID(),getInfo.getUserName());

                json.put("token",token);
                System.out.println(json.toString());
                return json.toString();
            }else {
                System.out.println(userService.login(user).size());
                System.out.println("登录失败");
                return "登录失败";
            }
        }
        return "登录失败";
    }
    @GetMapping("/getMode")
    public List<Mode> getMode(HttpServletRequest request){
        String userID =  request.getHeader("userID");
        List<Mode> modeList = modeService.getModeByUserID(userID);
//        向第一个位置添加全部场景
        Mode mode = new Mode();
        mode.setModeID("allModes");
        mode.setModeName("全部场景");
        mode.setSwitchFlag(false);
        mode.setUserID(userID);
        modeList.add(0,mode);
        System.out.println(modeService.getById(userID));
        return modeList;
    }

    @PostMapping("/AddMode")
    public String addMode(@RequestBody ModeAdd modeAdd){

        System.out.println(modeAdd.toString());
        if (modeAdd.getModeName()!=null&&modeAdd.getDeviceSetting().size()!=0){
            Mode mode = new Mode();
            mode.setSwitchFlag(false);
            mode.setUserID(modeAdd.getUserID());
            mode.setModeName(modeAdd.getModeName());
            String newmodeID = modeService.addMode(mode);
            modeAdd.getDeviceSetting();

            for (Devices devices:modeAdd.getDeviceSetting() ) {
                Modeinfo modeinfo = new Modeinfo();
                modeinfo.setDeviceID(devices.getDeviceID());
                modeinfo.setSwitchs(devices.isSwitchs());
                modeinfo.setModeID(newmodeID);
                System.out.println("============================");
                System.out.println(modeinfo.toString());
                System.out.println("============================");
                modeService.addModeInfo(modeinfo);
            }
            return "success";
        }else {
            return "err";
        }

    }

}

