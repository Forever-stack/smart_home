package com.lit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Rooms implements Serializable {
    public Rooms(Rooms rooms) {
        this.roomName = rooms.roomName;
        this.roomID = rooms.roomID;
        this.familyID = rooms.familyID;
    }

    private static final long serialVersionUID=1L;

    @TableField("roomName")
    private String roomName;

    @TableId(value = "roomID", type = IdType.ID_WORKER_STR)
    private String roomID;

    @TableField("familyID")
    private String familyID;


}
