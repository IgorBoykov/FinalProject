package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StatementRepository;
import domain.Statement;

@Service
public class StatementService {

	@Autowired
	private StatementRepository statementRepository;

	public void save(Statement statement) {
		statementRepository.save(statement);
	}

	public List<Statement> findAllStatements() {
		return statementRepository.findAll();
	}
}
