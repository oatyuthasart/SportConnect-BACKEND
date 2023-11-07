package sit.cp23ms2.sportconnect.services;

import sit.cp23ms2.sportconnect.dtos.activity.ActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.CreateActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.PageActivityDto;
import sit.cp23ms2.sportconnect.dtos.activity.UpdateActivityDto;
import sit.cp23ms2.sportconnect.entities.Activity;
import sit.cp23ms2.sportconnect.entities.ActivityParticipant;
import sit.cp23ms2.sportconnect.entities.Category;
import sit.cp23ms2.sportconnect.exceptions.type.ApiNotFoundException;
import sit.cp23ms2.sportconnect.repositories.ActivityParticipantRepository;
import sit.cp23ms2.sportconnect.repositories.ActivityRepository;
import sit.cp23ms2.sportconnect.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ActivityService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ActivityRepository repository;
    @Autowired
    private ActivityParticipantRepository activityParticipantRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    //nameError
    final private FieldError titleErrorObj = new FieldError("createActivityDto",
            "title", "Title already used in other Activity now! Please use other title");

    public PageActivityDto getActivity(int pageNum, int pageSize, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        Pageable pageRequest = PageRequest.of(pageNum, pageSize, sort);
        Page<Activity> listActivities = repository.findAllActivities(pageRequest); //ได้เป็น Pageable ของ User
        PageActivityDto pageActivityDto = modelMapper.map(listActivities, PageActivityDto.class); //map ใส่ PageUserDto
        return  pageActivityDto;
    }

    public Activity getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ApiNotFoundException("Activity not found!"));
    }

    public ActivityDto create(CreateActivityDto newActivity, BindingResult result) throws MethodArgumentNotValidException {
        //Error validation
        if(repository.existsByTitle(newActivity.getTitle())) {
            result.addError(titleErrorObj);
        }
        if (result.hasErrors()) throw new MethodArgumentNotValidException(null, result);

        Activity activity = modelMapper.map(newActivity, Activity.class);
        //save Activity to database
        Activity createdActivity = repository.saveAndFlush(activity);
        //create participant (because hoseUser is also participant)
        ActivityParticipant activityParticipant = new ActivityParticipant();
        activityParticipantRepository.insertWithEnum(createdActivity.getHostUser().getUserId()
                , createdActivity.getActivityId(), "ready", createdActivity.getCreatedAt());

        return modelMapper.map(createdActivity, ActivityDto.class);
    }

    public ActivityDto update(UpdateActivityDto updateActivity, Integer id, BindingResult result) throws MethodArgumentNotValidException {
        Activity activity = getById(id);
        if(repository.existsByTitleAndActivityIdNot(updateActivity.getTitle(), id)) { //Check duplicate title
            result.addError(titleErrorObj);
        }
        if (result.hasErrors()) throw new MethodArgumentNotValidException(null, result);

        System.out.println(updateActivity.getTitle());

        Activity updatedActivity = mapActivity(activity, updateActivity);

        return modelMapper.map(repository.saveAndFlush(updatedActivity), ActivityDto.class);
    }

    public Activity mapActivity(Activity existingActivity, UpdateActivityDto updateActivity) {
        if(updateActivity.getTitle() != null && !updateActivity.getTitle().trim().equals("")) //Set Title
            System.out.println(updateActivity.getTitle());
            existingActivity.setTitle(updateActivity.getTitle());
        if(updateActivity.getCategoryId() != null) { //Set Category
            Category newCategory = categoryRepository.findById(updateActivity.getCategoryId()).orElseThrow(() -> new ApiNotFoundException("Category not found!"));
            existingActivity.setCategoryId(newCategory);
        }
        if(updateActivity.getDescription() != null && !updateActivity.getDescription().trim().equals("")) //Set Description
            existingActivity.setDescription(updateActivity.getDescription());
        if(updateActivity.getPlace() != null && !updateActivity.getPlace().trim().equals("")) //Set Place
            existingActivity.setPlace(updateActivity.getPlace());
        if(updateActivity.getDateTime() != null && !updateActivity.getDateTime().toString().trim().equals("")) //Set Date & Time
            existingActivity.setDateTime(updateActivity.getDateTime());
        return existingActivity;
    }

    public void delete(Integer id) {
        repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + "does not exist !"));
        repository.deleteById(id);
    }
}
