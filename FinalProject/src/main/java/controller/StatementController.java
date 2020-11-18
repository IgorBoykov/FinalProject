package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Faculty;
import domain.Statement;
import domain.User;
import service.FacultyService;
import service.StatementService;
import service.UserService;

@Controller
public class StatementController {

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private StatementService statementService;

	@RequestMapping(value = "/entrantRegistration", method = RequestMethod.GET)
	public ModelAndView showSubjects(@RequestParam("currentFacultyId") Integer currentFacultyId,
			@RequestParam("currentUserEmail") String currentUserEmail) {
		Faculty faculty = facultyService.findFacultyById(currentFacultyId);
		User user = userService.findByEmail(currentUserEmail);

		Statement statement = new Statement();
		statement.setFaculty(faculty);
		statement.setUser(user);

		ModelAndView modelAndView = new ModelAndView("entrantRegistration");
		modelAndView.addObject("statement", statement);
		return modelAndView;
	}

	@RequestMapping(value = "/addMarks", method = RequestMethod.POST)
	public ModelAndView registration(@Validated @ModelAttribute("statement") Statement statement,
			BindingResult bindingResult) {
		Faculty faculty = facultyService.findFacultyById(statement.getFacultyId());
		User user = userService.findByEmail(statement.getUserEmail());

		statement.setUser(user);
		statement.setFaculty(faculty);
		statementService.save(statement);

		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/rating", method = RequestMethod.GET)
	public ModelAndView showRating() {
		ModelAndView modelAndView = new ModelAndView("rating");
		modelAndView.addObject("statements", statementService.findAllStatements());
		return modelAndView;
	}
}
