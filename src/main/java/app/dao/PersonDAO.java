package app.dao;


import app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository <Person, Integer> {



}
