package app.service;


import app.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person save(Person person);



}
