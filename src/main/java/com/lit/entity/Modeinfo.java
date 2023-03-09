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
public class Modeinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("deviceID")
    private String deviceID;

    @TableField("modeID")
    private String modeID;
    @TableField("switchs")
    private Boolean switchs;


}
