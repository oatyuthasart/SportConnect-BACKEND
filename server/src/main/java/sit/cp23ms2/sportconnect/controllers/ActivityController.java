package sit.cp23ms2.sportconnect.controllers;

import sit.cp23ms2.sportconnect.dtos.activity.ActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.CreateActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.PageActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.UpdateActivityDto;
import sit.cp23ms2.sportconnect.services.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/api/activities")
@Component
public class ActivityController {
    @Autowired
    public ActivityService activityService;
    @Autowired
    public ModelMapper modelMapper;

    @GetMapping
    public PageActivityDto getActivity(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int pageSize,
                                       @RequestParam(defaultValue = "place") String sortBy,
                                       @RequestParam(required = false)Set<Integer> categoryIds,
                                        @RequestParam(required = false)String title,
                                        @RequestParam(required = false)String place
            , HttpServletResponse response) throws IOException {
        //response.sendRedirect("https://google.com");

        return activityService.getActivity(page, pageSize, sortBy, categoryIds, title, place);
    }

    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable Integer id) {
        return modelMapper.map(activityService.getById(id), ActivityDto.class);
    }

    @PostMapping
    public ActivityDto createActivity(@Valid @RequestBody CreateActivityDto newActivity, BindingResult result) throws MethodArgumentNotValidException {
        return activityService.create(newActivity, result);
    }

    @PatchMapping("/{id}")
    public ActivityDto updateActivity(@Valid @RequestBody UpdateActivityDto updateActivityDto,
                                      @PathVariable Integer id, BindingResult result) throws MethodArgumentNotValidException {
        return activityService.update(updateActivityDto, id, result);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.delete(id);
    }
}
