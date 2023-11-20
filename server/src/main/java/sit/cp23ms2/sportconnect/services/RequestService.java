package sit.cp23ms2.sportconnect.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;
import sit.cp23ms2.sportconnect.dtos.activity.PageActivityDto;
import sit.cp23ms2.sportconnect.dtos.request.CreateRequestDto;
import sit.cp23ms2.sportconnect.dtos.request.PageRequestDto;
import sit.cp23ms2.sportconnect.dtos.request.RequestDto;
import sit.cp23ms2.sportconnect.entities.Activity;
import sit.cp23ms2.sportconnect.entities.Request;
import sit.cp23ms2.sportconnect.repositories.RequestRepository;

@Service
public class RequestService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RequestRepository repository;

    public PageRequestDto getRequest(int pageNum, int pageSize, Integer activityId, Integer userId) {
        Pageable pageRequest = PageRequest.of(pageNum, pageSize);
        Page<Request> listRequests = repository.findAllRequests(pageRequest, activityId, userId); //ได้เป็น Pageable ของ Request
        PageRequestDto pageRequestDto = modelMapper.map(listRequests, PageRequestDto.class); //map ใส่ PageRequestDto
        return  pageRequestDto;
    }

    public ResponseEntity<?> createRequest(CreateRequestDto newRequest, BindingResult result) throws MethodArgumentNotValidException {
        if(repository.existsByActivity_ActivityIdAndUser_UserId(newRequest.getActivityId(), newRequest.getUserId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("You already requested to this party");
        }
        Request request = modelMapper.map(newRequest, Request.class);
        Request createdRequest = repository.saveAndFlush(request);
//        return modelMapper.map(createdRequest, RequestDto.class);
        return new ResponseEntity<RequestDto>(modelMapper.map(createdRequest, RequestDto.class), HttpStatus.CREATED);
    }

    public void delete(Integer activityId, Integer userId) {
        repository.findByActivityActivityIdAndUser_UserId(activityId, userId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Request of Activity ID: " + activityId + " and User ID: " + userId + "does not exist !"));
        repository.deleteByActivity_ActivityIdAndUser_UserId(activityId, userId);
    }
}
