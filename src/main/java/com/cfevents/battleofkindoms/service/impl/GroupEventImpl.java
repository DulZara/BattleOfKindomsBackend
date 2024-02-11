package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.GroupEvent;
import com.cfevents.battleofkindoms.repository.GroupEventRepository;
import com.cfevents.battleofkindoms.service.GroupEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupEventImpl implements GroupEventService {

    @Autowired
    private GroupEventRepository groupEventRepository;

    @Override
    public List<GroupEvent> getGroupEvent() {
        return groupEventRepository.findAll();
    }

    @Override
    public GroupEvent addGroupEvent(GroupEvent groupEvent) {
        return groupEventRepository.save(groupEvent);
    }
}
