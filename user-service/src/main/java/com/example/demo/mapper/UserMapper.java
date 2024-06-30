package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.bean.User;
import com.example.demo.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);


	UserDTO toDto(User source);
}
