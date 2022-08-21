package com.salihynbl.fttechnology.service.implementations;

import com.salihynbl.fttechnology.dto.user.CreateUserDto;
import com.salihynbl.fttechnology.dto.user.UserDto;
import com.salihynbl.fttechnology.model.User;
import com.salihynbl.fttechnology.repository.UserRepository;
import com.salihynbl.fttechnology.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User userToCreate = this.modelMapper.map(createUserDto, User.class);
        return this.modelMapper.map(this.userRepository.save(userToCreate), UserDto.class);
    }
}
