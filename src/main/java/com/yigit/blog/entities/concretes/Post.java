package com.yigit.blog.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id")
    )
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User user;
}
