package app.service.impl;

import app.dao.PersonDAO;
import app.model.Person;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    public List<Person> findAll() {
return personDAO.findAll();

    }

    public Person save(Person person) {
    return personDAO.save(person);

    }
}
