package com.manas.bidbits.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

        UserModel findByEmail(String email);

        UserModel findByCampusID(String campusID);

}
