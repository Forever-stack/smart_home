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
public class Mode implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "modeID", type = IdType.ID_WORKER_STR)
    private String modeID;

    @TableField("modeName")
    private String modeName;

    @TableField("userID")
    private String userID;

    @TableField("switchFlag")
    private boolean switchFlag;


}
