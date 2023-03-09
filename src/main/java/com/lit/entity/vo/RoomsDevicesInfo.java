package com.lit.entity.vo;

import com.lit.entity.Devices;
import com.lit.entity.Rooms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomsDevicesInfo extends Rooms {
    private List<Devices> devices;

    public RoomsDevicesInfo(Rooms rooms) {
        super(rooms);
    }
}
