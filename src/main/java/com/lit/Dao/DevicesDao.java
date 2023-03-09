package com.lit.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lit.entity.Devices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DevicesDao extends BaseMapper<Devices> {
}
