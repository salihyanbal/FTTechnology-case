package com.salihynbl.fttechnology.service;

import com.salihynbl.fttechnology.dto.user.CreateUserDto;
import com.salihynbl.fttechnology.dto.user.UserDto;

public interface UserService {

    UserDto createUser(CreateUserDto createUserDto);
}
