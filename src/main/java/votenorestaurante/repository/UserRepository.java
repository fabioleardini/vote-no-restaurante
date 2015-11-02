package votenorestaurante.repository;

import org.springframework.data.repository.CrudRepository;

import votenorestaurante.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
