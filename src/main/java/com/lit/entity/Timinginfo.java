package com.lit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郑ang
 * @since 2023-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Timinginfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("deviceID")
    private String deviceID;

    @TableField("TID")
    private String tid;

    /**
     * interval时间段  point时间点
     */
    private Integer type;

    private Date start;

    private Date end;

    private Boolean switchs;


}
