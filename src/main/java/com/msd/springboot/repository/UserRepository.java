package com.msd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msd.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

}
