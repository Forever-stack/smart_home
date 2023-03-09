package com.lit.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lit.entity.Mode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface ModeDao extends BaseMapper<Mode> {
}
