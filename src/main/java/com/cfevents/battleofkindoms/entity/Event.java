package com.cfevents.battleofkindoms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "events")
public class Event {
    @Id
    private Integer eventId;
    private String eventName;
    private String eventGender;
    private String eventType;

}
