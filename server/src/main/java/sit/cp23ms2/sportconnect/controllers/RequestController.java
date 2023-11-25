package sit.cp23ms2.sportconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sit.cp23ms2.sportconnect.dtos.activity.PageActivityDto;
import sit.cp23ms2.sportconnect.dtos.request.CreateRequestDto;
import sit.cp23ms2.sportconnect.dtos.request.PageRequestDto;
import sit.cp23ms2.sportconnect.dtos.request.RequestDto;
import sit.cp23ms2.sportconnect.services.RequestService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/requests")
@Component
public class RequestController {
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public RequestService requestService;

    @GetMapping
    public PageRequestDto getRequest(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int pageSize,
                                      @RequestParam(required = false) Integer activityId,
                                      @RequestParam(required = false) Integer userId,
                                      HttpServletResponse response) throws IOException {
        //response.sendRedirect("https://google.com");

        return requestService.getRequest(page, pageSize, activityId, userId);
    }

    @PostMapping
    public ResponseEntity<?> createRequest(@Valid @RequestBody CreateRequestDto newRequest, BindingResult result) throws MethodArgumentNotValidException {
        return requestService.createRequest(newRequest, result);
    }

    @DeleteMapping("/{activityId}_{userId}")
    public void deleteRequest(@PathVariable Integer activityId, @PathVariable Integer userId) {
        requestService.delete(activityId, userId);
    }
}
