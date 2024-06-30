package com.example.demo.mapper;

import com.example.demo.bean.User;
import com.example.demo.dto.UserDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T19:21:23+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( source.getEmail() );
        userDTO.setFirstName( source.getFirstName() );
        userDTO.setId( source.getId() );
        userDTO.setLastName( source.getLastName() );

        return userDTO;
    }
}
