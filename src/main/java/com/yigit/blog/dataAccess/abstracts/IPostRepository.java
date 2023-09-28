package com.yigit.blog.dataAccess.abstracts;

import com.yigit.blog.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Integer> {
    boolean existsById(int id);
}
