package com.yigit.blog.dataAccess.abstracts;

import com.yigit.blog.entities.concretes.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag,Integer> {
    boolean existsById(int id);
}
