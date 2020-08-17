package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PersonDao {

    private final PersonRepository personRepository;
    @Autowired
    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPersonData(Person person) {
        return personRepository.insert(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonInformationById(String id) {

        return personRepository.findById(id);
    }

    public Person updatePersonUsingId(String id, Person person) {

        Optional<Person> person1 = personRepository.findById(id);
        Person person2 = person1.get();
        person2.setId(person.getId());
        person2.setName(person.getName());
        return personRepository.save(person2);
    }

    public void deletePersonUsingId(String id) {
        try {
            personRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
