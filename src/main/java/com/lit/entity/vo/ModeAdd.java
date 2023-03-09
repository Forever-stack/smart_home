package com.lit.entity.vo;

import com.lit.entity.Devices;
import lombok.Data;

import java.util.List;

@Data
public class ModeAdd {
    private List<Devices> deviceSetting;
    private String userID;
    private String modeName;
}
