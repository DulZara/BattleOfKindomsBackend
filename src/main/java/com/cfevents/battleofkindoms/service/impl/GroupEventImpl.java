package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.DTO.GroupEventDTO;
import com.cfevents.battleofkindoms.entity.Event;
import com.cfevents.battleofkindoms.entity.GroupEvent;
import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.entity.Player;
import com.cfevents.battleofkindoms.repository.GroupEventRepository;
import com.cfevents.battleofkindoms.service.EventService;
import com.cfevents.battleofkindoms.service.GroupEventService;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupEventImpl implements GroupEventService {

    @Autowired
    private GroupEventRepository groupEventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private HouseService houseService;

    @Autowired
    public GroupEventImpl(GroupEventRepository groupEventRepository) {
        this.groupEventRepository = groupEventRepository;
    }

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
    public GroupEvent updateParticipationConform(Integer groupNo, String newParticipationConform) {
        Optional<GroupEvent> optionalGroupEvent = groupEventRepository.findById(groupNo);

        if (optionalGroupEvent.isPresent()) {
            GroupEvent groupEvent = optionalGroupEvent.get();
            groupEvent.setParticipationConform(newParticipationConform);
            return groupEventRepository.save(groupEvent);
        } else {
            // Handle not found exception or return null/throw an exception
            return null;
        }
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

    @Override
    public GroupEvent updateGroupEvent(int groupNo, GroupEvent groupEvent) {
        GroupEvent groupvar =groupEventRepository.findById(groupNo).get();
        groupvar.setEventId(groupEvent.getEventId());
        groupvar.setEventName(groupEvent.getEventName());
        groupvar.setEventType(groupEvent.getEventType());
        groupvar.setEventGender(groupEvent.getEventGender());
        groupvar.setHouseName(groupEvent.getHouseName());
        groupvar.setPlayerEpf(groupEvent.getPlayerEpf());
        groupvar.setParticipationConform(groupEvent.getParticipationConform());
        groupEventRepository.save(groupvar);
        return groupvar;
    }
}
