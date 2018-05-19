package app.controller;

import app.dao.PersonDAO;
import app.model.Person;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class MainController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    String index(Model model) {
        List<Person> people = personService.findAll();
        model.addAttribute("people", people);
        return "index";
    }

    @PostMapping("/person")
    String person(
            @RequestParam String name,
            @RequestParam int age
    ) {
        Person person = new Person(name, age);
        personService.save(person);
        return "redirect:/";
    }


}
