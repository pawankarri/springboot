package validations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import validations.dto.UserRequest;
import validations.entity.User;
import validations.exception.UserNotFoundException;
import validations.repository.UserRepository;
@Service
public class UserService {


        @Autowired
        private UserRepository repository;
    
    
        public User saveUser(UserRequest userRequest) {
            User user = User.
                    build(0, userRequest.getName(), userRequest.getEmail(),
                            userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
            return repository.save(user);
        }
    
    
        public List<User> getALlUsers() {
            return repository.findAll();
        }
    
    
        public User getUser(int id) throws UserNotFoundException {
            User user= repository.findByUserId(id);
            if(user!=null){
                return user;
            }else{
                throw new UserNotFoundException("user not found with id : "+id);
            }

        }
    }
