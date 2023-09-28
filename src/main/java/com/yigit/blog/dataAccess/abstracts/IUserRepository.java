package com.yigit.blog.dataAccess.abstracts;

import com.yigit.blog.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);
    boolean existsById(int id);
}
