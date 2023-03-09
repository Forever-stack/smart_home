package com.lit.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lit.entity.Modeinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郑ang
 * @since 2023-03-08
 */
@Repository
@Mapper
public interface ModeinfoDao extends BaseMapper<Modeinfo> {

}
