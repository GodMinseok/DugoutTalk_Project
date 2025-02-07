package org.example.dugouttalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_pwd", unique = true, nullable = false)
    private String password;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_nickname", unique = true, nullable = false)
    private String nickname; // 게시판에 보일 닉네임

    @Column(name = "user_favorite_team", nullable = false)
    private String favoriteTeam; // 자신이 응원하는 팀

}
