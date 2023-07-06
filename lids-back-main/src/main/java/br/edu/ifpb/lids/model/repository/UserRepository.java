package br.edu.ifpb.lids.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.lids.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
   Optional<User> findByLogin(String login);

   Boolean existsByLogin(String login);

}
