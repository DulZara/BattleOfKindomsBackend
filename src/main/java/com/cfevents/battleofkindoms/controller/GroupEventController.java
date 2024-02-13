package com.cfevents.battleofkindoms.controller;

import com.cfevents.battleofkindoms.DTO.GroupEventDTO;
import com.cfevents.battleofkindoms.entity.GroupEvent;
import com.cfevents.battleofkindoms.entity.Player;
import com.cfevents.battleofkindoms.service.GroupEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupEventController {

    @Autowired
    private GroupEventService groupEventService;

    @GetMapping("/getGroups")
    public List<GroupEvent> getGroupEvent() {
        return groupEventService.getGroupEvent();
    }

    @PostMapping("/addGroup")
    public GroupEvent addGroupEvent(@RequestBody GroupEvent groupEvent) {

        return groupEventService.addGroupEvent(groupEvent);
    }
    @GetMapping("/getAllGroupData")
    public List<GroupEventDTO> getAllGroupEventData() {
        return groupEventService.getAllGroupEventData();
    }

    @PatchMapping("/{groupNo}/update-participation-conform")
    public ResponseEntity<GroupEvent> updateParticipationConform(
            @PathVariable Integer groupNo,
            @RequestParam String newParticipationConform
    ) {
        GroupEvent updatedGroupEvent = groupEventService.updateParticipationConform(groupNo, newParticipationConform);
        if (updatedGroupEvent != null) {
            return ResponseEntity.ok(updatedGroupEvent);
        } else {
            // Handle not found exception
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateGroupEvent/{groupNo}")
    public GroupEvent updateGroupEvent(@RequestParam int groupNo, @RequestBody GroupEvent groupEvent) {
        return groupEventService.updateGroupEvent(groupNo, groupEvent);
    }
}
