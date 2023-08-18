package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.amartek.app.model.User;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
    // @Query("SELECT u FROM User u JOIN u.Employee e WHERE e.email = ?1 ")
    @Query("SELECT u from User u WHERE u.Email = ?1")
    public User login(String email);

    // INSERT USING JPQL
}
