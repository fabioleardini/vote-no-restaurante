package votenorestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import votenorestaurante.model.User;
import votenorestaurante.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean userExists(User user){
        return (findByEmail(user.getEmail()) != null);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
