package com.maximodev.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximodev.workshopmongo.domain.User;
import com.maximodev.workshopmongo.dto.UserDTO;
import com.maximodev.workshopmongo.repository.UserRepository;
import com.maximodev.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> userOptional =userRepository.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User objUser){
        User user = userRepository.getUserById(objUser.getId());
        updateData(user, objUser);
        return userRepository.save(user);
    }

    private void updateData(User user, User objUser){
        user.setName(objUser.getName());
        user.setEmail(objUser.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }
}
