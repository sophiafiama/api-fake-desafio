package com.sophiafiama.apifilmesdesafio.service;



import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.model.Role;
import com.sophiafiama.apifilmesdesafio.model.User;
import com.sophiafiama.apifilmesdesafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User createUser(User user){
        return userRepository.save(user);
    }


    public String deleteUser(Integer id){
         userRepository.deleteById(id);
         return "Usuário deletado";
    }

    public User userUpdate( User user){
        User userUpdate = userRepository.findById(user.getId()).get();
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        return userRepository.saveAndFlush(user);
    }


    public User findById(Integer id){
        return userRepository.findById(id).get();
    }

    public Page<User> listAllUsers(int offset, int pageSize, String field){
        Page<User> users =  userRepository.findAll(PageRequest.of(offset,pageSize)
                .withSort(Sort.by(field)));
        return users;
    }

    public String disable(Integer id){
        User userUpdate = userRepository.findById(id).get();
        userUpdate.setStatus(false);

        userRepository.saveAndFlush(userUpdate);

        return "Usuário desativado";

    }


}
