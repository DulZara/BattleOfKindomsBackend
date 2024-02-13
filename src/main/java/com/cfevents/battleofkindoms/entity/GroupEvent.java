package com.cfevents.battleofkindoms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "groups")
public class GroupEvent {
    @Id
    private Integer groupNo;
    private Integer eventId;
    private String eventName;
    private String eventType;
    private String eventGender;
    private String houseName;
    private List<Integer> playerEpf;
    private String participationConform;
}
