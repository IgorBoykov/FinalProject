package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.RegisteredEntrant;

public interface RegisteredEntrantRepository extends JpaRepository<RegisteredEntrant, Integer>{

}
