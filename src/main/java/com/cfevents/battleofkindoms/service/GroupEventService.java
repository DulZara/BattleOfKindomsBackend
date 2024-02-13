package com.cfevents.battleofkindoms.service;



import com.cfevents.battleofkindoms.DTO.GroupEventDTO;
import com.cfevents.battleofkindoms.entity.GroupEvent;
import com.cfevents.battleofkindoms.entity.Player;

import java.util.List;

public interface GroupEventService {
    public List<GroupEvent> getGroupEvent();

    public GroupEvent addGroupEvent(GroupEvent groupEvent);
    List<GroupEventDTO> getAllGroupEventData();
    GroupEvent updateParticipationConform(Integer groupNo, String newParticipationConform);

    public GroupEvent updateGroupEvent(int groupNo, GroupEvent groupEvent);


}
