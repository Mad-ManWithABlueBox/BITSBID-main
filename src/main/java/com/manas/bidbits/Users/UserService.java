package com.manas.bidbits.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

        @Autowired
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        // Create
        public UserModel addUser(UserModel userModel) {
            UserModel presentUser = userRepository.findByEmail(userModel.getEmail());
            return Objects.requireNonNullElseGet(presentUser, () -> userRepository.save(userModel));
        }

        // Read
        public UserModel getUserById(Long userId) {
            return userRepository.findById(userId).orElse(null);
        }

        // Update
        public UserModel updateUser(UserModel userModel) {
            UserModel existingUser = userRepository.findById(userModel.getUserId()).orElse(null);
            assert existingUser != null;
            existingUser.setName(userModel.getName());
            existingUser.setEmail(userModel.getEmail());
            return userRepository.save(existingUser);
        }

        // Delete
        public String deleteUser(Long userId) {
            userRepository.deleteById(userId);
            return "User removed !! " + userId;
        }

        // Get all
        public Iterable<UserModel> getAllUsers() {
            return userRepository.findAll();
        }

        // Get by email
        public UserModel getUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }

        // Get by email
        public UserModel getUserByCampusID(String  campusID) {
            return userRepository.findByCampusID(campusID);
        }

    public UserModel setCampusId(Long userId, String campusId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        userModel.setCampusID(campusId);
        return userRepository.save(userModel);
    }

    public UserModel setHostel(Long userId, String hostel) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        userModel.setHostel(hostel);
        return userRepository.save(userModel);
    }

    public UserModel setPhone(Long userId, String phone) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        userModel.setPhone(phone);
        return userRepository.save(userModel);
    }
}
