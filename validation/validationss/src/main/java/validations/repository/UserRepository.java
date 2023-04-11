package validations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import validations.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
