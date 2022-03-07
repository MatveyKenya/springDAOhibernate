package ru.matveykenya.springdaohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.matveykenya.springdaohibernate.entity.Person;
import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByCityOfLiving(String city);
    Optional<List<Person>> findByNameAndSurname(String name, String surname);
    List<Person> findAllByAgeLessThanOrderByAge(int age);

    //реализация второго способа обновления через Query на endpoint: /update-by-query
    @Transactional
    @Modifying
    @Query("update Person p set p.name=:name, p.surname=:surname, p.age=:age, p.phoneNumber=:phoneNumber, p.cityOfLiving=:cityOfLiving where p.id=:id")
    void updatePersonByQuery(Long id, String name, String surname, int age, String phoneNumber, String cityOfLiving);
}
