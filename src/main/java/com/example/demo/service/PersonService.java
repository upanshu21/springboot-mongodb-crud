package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person insertPersonData(Person person) {
        return personDao.insertPersonData(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personDao.getAllPersonInformation();
    }

    public Optional<Person> getPersonInformationUsingId(String id) {

        return personDao.getPersonInformationById(id);
    }

    public void updatePersonUsingId(String id, Person person) {

         personDao.updatePersonUsingId(id, person);
    }

    public void deletePersonUsingId(String id) {

        personDao.deletePersonUsingId(id);
    }

}
