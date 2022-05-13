package com.ky.ClassBrrowSystem.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomBorrowedInfo {
    private String logId;
    private int borrowRoomId;
    private String borrowUserId;
    private int borrowTimeId;
    private String borrowDate;
    private String borrowReason;
    private String applyTime;
    private int isNeedMedia;
    private int isAdmit;
}
