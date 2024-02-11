package com.cfevents.battleofkindoms.service;



import com.cfevents.battleofkindoms.entity.GroupEvent;

import java.util.List;

public interface GroupEventService {
    public List<GroupEvent> getGroupEvent();

    public GroupEvent addGroupEvent(GroupEvent groupEvent);
}
