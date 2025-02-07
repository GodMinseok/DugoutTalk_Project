package org.example.dugouttalk.repository;

import org.example.dugouttalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(String userId);
    User findByPassword(String password);
    User findByEmail(String email);
    User findByNickname(String nickname);
}
