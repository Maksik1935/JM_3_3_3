package com.example.jm_3_3_3.service;

import com.example.jm_3_3_3.exception.UserNotFoundException;
import com.example.jm_3_3_3.model.User;
import com.example.jm_3_3_3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
        private final UserRepository dao;

        public UserServiceImpl(UserRepository dao) {
            this.dao = dao;
        }

        @Override
        public User addUser(User user) {
            return dao.save(user);
        }

        @Override
        public User findUser(Long id) {
            return dao.findById(id).orElseThrow(UserNotFoundException::new);
        }

        @Override
        public User updateUser(User user) {
            return dao.save(user);
        }

        @Override
        public void deleteUser(Long id) {
            dao.delete(findUser(id));
        }

        @Override
        public List<User> getAllUsers() {
            return dao.findAll();
        }
    }
