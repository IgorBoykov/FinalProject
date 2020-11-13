package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Statement;

public interface StatementRepository extends JpaRepository<Statement, Integer> {

}
