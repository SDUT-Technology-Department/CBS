package com.ky.ClassBrrowSystem.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String roomId;
    private String roomName;
    private int isMedia;
    private int capacity;
    private String img;
    private int isSpecial;
    private int isPower;
    private String description;
}
