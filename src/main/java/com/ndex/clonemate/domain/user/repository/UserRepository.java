package com.ndex.clonemate.domain.user.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    <T> Optional<T> findById(Class<T> type, @Param("id") Long id);

    @Query("select u from User u where u.id = :id and u.deleteYn = 'N'")
    Optional<User> findByUserId(@Param("id") Long id);

    Optional<User> findByAccount(String account);

    boolean existsByEmail(String email);

    boolean existsByAccount(String account);

    @Query(nativeQuery = true, value = "select u from User u"
            + " where u.randomYn = :randomYn and u.deleteYn = :deleteYn and u.certifyYn = :certifyYn"
            + " order by random() limit 10")
    List<User> findByRandom(@Param("randomYn") char randomYn,
                            @Param("deleteYn") char deleteYn,
                            @Param("certifyYn") char certifyYn);
}
