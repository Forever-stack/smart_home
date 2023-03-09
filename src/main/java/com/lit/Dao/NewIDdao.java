package com.lit.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NewIDdao {
    @Select("SELECT newid(#{name})")
    String newID(String name);
}
