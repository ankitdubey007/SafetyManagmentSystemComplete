package com.safety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safety.Model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
