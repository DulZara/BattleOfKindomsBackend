package com.cfevents.battleofkindoms.DTO;

import lombok.Data;

@Data
public class WinnerDTO {
    private Integer eventId;
    private String eventName;
    private String eventGender;
    private String eventType;
    private String houseName;
    private Integer groupNo;
    private String place;
    private Integer score;
}