package com.yigit.blog.dataAccess.abstracts;

import com.yigit.blog.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsById(int id);
}
