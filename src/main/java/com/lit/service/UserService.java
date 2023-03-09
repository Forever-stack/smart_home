package com.lit.service;

import com.lit.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lit.entity.vo.RoomsDevicesInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郑ang
 * @since 2023-03-02
 */
public interface UserService extends IService<User> {
    List<User> login(User user);
    List<User> getByUserID(String userID);
    public List<RoomsDevicesInfo> getRoomAndDevice(String roomID);
}
