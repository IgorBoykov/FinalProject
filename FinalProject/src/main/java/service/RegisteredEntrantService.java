package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RegisteredEntrantRepository;
import domain.RegisteredEntrant;

@Service
public class RegisteredEntrantService {

	@Autowired
	private RegisteredEntrantRepository registeredEntrantRepository;
	
	public void save(RegisteredEntrant entrant) {
		registeredEntrantRepository.save(entrant);
	}
	
	public RegisteredEntrant findById(Integer id) {
		return registeredEntrantRepository.findById(id).get();
	}
	
	public List<RegisteredEntrant> findAllRegisteredEntrants() {
		return registeredEntrantRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		registeredEntrantRepository.deleteById(id);
	}
}
