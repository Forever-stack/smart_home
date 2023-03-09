package com.lit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lit.entity.Mode;
import com.lit.entity.Modeinfo;

import java.util.List;

public interface ModeService extends IService<Mode> {
    List<Mode> getModeByUserID(String userID);
    String addMode(Mode mode);
    int addModeInfo(Modeinfo modeinfo);
}
