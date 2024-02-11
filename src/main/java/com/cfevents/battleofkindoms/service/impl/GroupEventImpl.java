package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.DTO.GroupEventDTO;
import com.cfevents.battleofkindoms.entity.Event;
import com.cfevents.battleofkindoms.entity.GroupEvent;
import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.repository.GroupEventRepository;
import com.cfevents.battleofkindoms.service.EventService;
import com.cfevents.battleofkindoms.service.GroupEventService;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupEventImpl implements GroupEventService {

    @Autowired
    private GroupEventRepository groupEventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private HouseService houseService;

    @Override
    public List<GroupEvent> getGroupEvent() {
        return groupEventRepository.findAll();
    }

    @Override
    public GroupEvent addGroupEvent(GroupEvent groupEvent) {
        return groupEventRepository.save(groupEvent);
    }

    @Override
    public List<GroupEventDTO> getAllGroupEventData() {
        List<GroupEvent> groupEvents = groupEventRepository.findAll();
        return groupEvents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateParticipationConform(Integer groupNo, String newStatus) {
        GroupEvent groupEvent = groupEventRepository.findById(groupNo)
                .orElseThrow(() -> new RuntimeException("GroupEvent not found with groupNo: " + groupNo));

        groupEvent.setParticipationConform(newStatus);
        groupEventRepository.save(groupEvent);

    }
    private GroupEventDTO convertToDTO(GroupEvent groupEvent) {
        GroupEventDTO dto = new GroupEventDTO();
        dto.setGroupNo(groupEvent.getGroupNo());
        dto.setParticipationConform(groupEvent.getParticipationConform());

        // Fetch event and house details based on eventId and houseName
        Event event = eventService.getEventById(groupEvent.getEventId());
        House house = houseService.getHouseByName(groupEvent.getHouseName());

        dto.setEventName(event.getEventName());
        dto.setEventType(event.getEventType());
        dto.setEventGender(event.getEventGender());
        dto.setHouseName(house.getHouseName());

        return dto;
    }
}
