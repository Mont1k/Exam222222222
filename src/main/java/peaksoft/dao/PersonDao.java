package peaksoft.dao;

import peaksoft.model.Person;

public interface PersonDao {
    void createTables();
    void savePerson(Person person);
    void deletePersonById(Long id);




}
