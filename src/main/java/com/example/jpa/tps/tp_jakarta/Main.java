package com.example.jpa.tps.tp_jakarta;

import com.example.jpa.tps.tp_jakarta.utils.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        // Persistance d'une entité
        em.getTransaction().begin();
        Person person = new Person("Alice", 30);
        em.persist(person);
        em.getTransaction().commit();

        // Lecture de l'entité persistée
        Person foundPerson = em.find(Person.class, person.getId());
        System.out.println("Person found: " + foundPerson.getName() + ", Age: " + foundPerson.getAge());

        em.close();
        JpaUtil.close();
    }
}