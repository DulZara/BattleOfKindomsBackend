package com.cfevents.battleofkindoms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "winners")
public class Winner {
    @Id
    private Integer winnerCode;
    private Integer eventId;
    private String eventName;
    private String eventGender;
    private String eventType;
    private String houseName;
    private Integer groupId;
    private String place;
    private Integer score;
}
