package sit.cp23ms2.sportconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sit.cp23ms2.sportconnect.dtos.activity_participants.CreateActivityParticipantDto;
import sit.cp23ms2.sportconnect.dtos.activity_participants.PageActivityParticipantDto;
import sit.cp23ms2.sportconnect.dtos.request.CreateRequestDto;
import sit.cp23ms2.sportconnect.dtos.request.PageRequestDto;
import sit.cp23ms2.sportconnect.entities.ActivityParticipant;
import sit.cp23ms2.sportconnect.services.ActivityParticipantsService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/participants")
@Component
public class ActivityParticipantsController {
    @Autowired
    public ActivityParticipantsService activityParticipantsService;

    @GetMapping
    public PageActivityParticipantDto getActivityParticipants(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int pageSize,
                                                 @RequestParam(required = false) Integer activityId,
                                                 @RequestParam(required = false) Integer userId,
                                                 HttpServletResponse response) throws IOException {
        //response.sendRedirect("https://google.com");

        return activityParticipantsService.getActivityParticipants(page, pageSize, activityId, userId);
    }

    @PostMapping
    public ResponseEntity<?> createActivityParticipant(@Valid @RequestBody CreateActivityParticipantDto newActivityParticipant, BindingResult result) throws MethodArgumentNotValidException {
        return activityParticipantsService.createActivityParticipants(newActivityParticipant, result);
    }

    @DeleteMapping("/{activityId}_{userId}")
    public void deleteRequest(@PathVariable Integer activityId, @PathVariable Integer userId) {
        activityParticipantsService.delete(activityId, userId);
    }
}
