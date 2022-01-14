package com.ndex.clonemate.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.id = :id and u.deleteYn = 'N'")
    Optional<User> findByUserId(@Param("id") Long id);
}
