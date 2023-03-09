package com.lit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Devices implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "deviceID", type = IdType.ID_WORKER_STR)
    private String deviceID;

    @TableField("deviceName")
    private String deviceName;

    @TableField("deviceType")
    private String deviceType;

    @TableField("deviceGrade")
    private Integer deviceGrade;

    @TableField("roomID")
    private String roomID;

    @TableField("switchs")
    private boolean switchs;

}
