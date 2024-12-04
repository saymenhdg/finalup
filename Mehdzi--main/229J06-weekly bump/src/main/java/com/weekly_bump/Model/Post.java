package com.weekly_bump.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Base64;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    private User user;  // The user who created the post

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] postImg;

    // Method to return post image as Base64
    public String getPostImageBase64() {
        return postImg != null ? Base64.getEncoder().encodeToString(postImg) : null;
    }
}
