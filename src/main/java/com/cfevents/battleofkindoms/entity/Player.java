package com.cfevents.battleofkindoms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "players")
public class Player {
    @Id
    private Integer playerEpf;
    private String playerName;
    private String branchName;
    private String mobNo;
    private String houseName;


}
