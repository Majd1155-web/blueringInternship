package com.example.blueringInternship.Mapper;

import com.example.blueringInternship.DTO.UsersDTO;
import com.example.blueringInternship.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
    UsersDTO UsersEntityToUsersDTO(UsersEntity usersEntity);
    UsersEntity UsersDTOToUsersEntity(UsersDTO usersDTO);
}
