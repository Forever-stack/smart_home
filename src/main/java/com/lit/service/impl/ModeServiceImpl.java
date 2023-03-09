package com.lit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lit.Dao.ModeDao;
import com.lit.Dao.ModeinfoDao;
import com.lit.Dao.NewIDdao;
import com.lit.entity.Mode;
import com.lit.entity.Modeinfo;
import com.lit.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeServiceImpl extends ServiceImpl<ModeDao,Mode> implements ModeService {
    @Autowired
    ModeDao modeDao;
    @Autowired
    ModeinfoDao modeinfoDao;
    @Autowired
    NewIDdao newIDdao;
    @Override
    public List<Mode> getModeByUserID(String userID) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("userID",userID);
        List<Mode> mode = modeDao.selectList(qw);
        return mode;
    }

    @Override
    public String addMode(Mode mode) {
        String newModeID= newIDdao.newID("MODE");
        mode.setModeID(newModeID);
        int ins =  modeDao.insert(mode);
        if (ins>=0){
            return newModeID;
        }
        return null ;

    }

    @Override
    public int addModeInfo(Modeinfo modeinfo) {

        return modeinfoDao.insert(modeinfo);
    }

}
