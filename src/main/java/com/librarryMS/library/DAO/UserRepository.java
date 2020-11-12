package com.librarryMS.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarryMS.library.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
