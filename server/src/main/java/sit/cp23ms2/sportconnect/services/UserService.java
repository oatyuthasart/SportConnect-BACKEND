package sit.cp23ms2.sportconnect.services;

import sit.cp23ms2.sportconnect.dtos.user.PageUserDto;
import sit.cp23ms2.sportconnect.entities.User;
import sit.cp23ms2.sportconnect.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository repository;

    public PageUserDto getUser(int pageNum, int pageSize, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        Pageable pageRequest = PageRequest.of(pageNum, pageSize, sort);
        Page<User> listUsers = repository.findAllUsers(pageRequest); //ได้เป็น Pageable ของ User
        PageUserDto pageUserDto = modelMapper.map(listUsers, PageUserDto.class); //map ใส่ PageUserDto
        return  pageUserDto;
    }
}
