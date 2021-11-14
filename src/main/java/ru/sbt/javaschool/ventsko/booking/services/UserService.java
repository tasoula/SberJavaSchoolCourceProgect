package ru.sbt.javaschool.ventsko.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.javaschool.ventsko.booking.mapes.User;
import ru.sbt.javaschool.ventsko.booking.repositiries.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User add(User item){
        return userRepository.saveAndFlush(item);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

    public User findById(long id){
        return userRepository.getById(id);
    }

    public User findByName(String name){
        return getAll().stream().filter(e->e.getName().equals(name)).findAny().get();
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
