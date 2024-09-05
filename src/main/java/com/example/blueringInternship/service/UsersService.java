package com.example.blueringInternship.service;

import com.example.blueringInternship.DTO.UsersDTO;
import com.example.blueringInternship.Mapper.UsersMapper;
import com.example.blueringInternship.entity.UsersEntity;
import com.example.blueringInternship.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private GeneralService generalService;

    @Autowired
    private UsersMapper usersMapper;

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void CreateUser(Map<String, Object> usersDTO) {
        UsersEntity user = new UsersEntity();
        generalService.updateEntity(usersDTO, user, UsersEntity.class);
        usersRepository.saveAndFlush(user);
    }

    public List<UsersDTO> GetUsers(){
        return usersRepository.findAll()
                .stream()
                .map(user -> {
                   UsersDTO usersDTO = usersMapper.UsersEntityToUsersDTO(user);
                   return usersDTO;
                })
                .collect(Collectors.toList());
    }

    public void UpdateUser(Integer id, Map<String, Object> usersDTO) {
        UsersEntity user = usersRepository.findById(id).get();
        generalService.updateEntity(usersDTO, user, UsersEntity.class);
        usersRepository.saveAndFlush(user);
    }

    public void DeleteUser(Integer id) {
        usersRepository.deleteById(id);
    }
}
