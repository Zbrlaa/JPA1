package com.example.jpa.tps.TPJPA2;

import java.time.LocalDate;

import com.example.jpa.tps.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		// Persistance d'une entité
		em.getTransaction().begin();
		Artist ar1 = new Artist("Laylow");
		Album al1 = new Album("Digitalova", LocalDate.now());
		ar1.addAlbum(al1);
		em.persist(ar1);
		em.persist(al1);
		em.getTransaction().commit();

		// Lecture de l'entité persistée
		Artist foundArtist = em.find(Artist.class, ar1.getId());
		System.out.println("Artist found: " + foundArtist.getName());

		/*
		em.getTransaction().begin();
		em.createQuery("DELETE FROM Album").executeUpdate();
		em.createQuery("DELETE FROM Artist").executeUpdate();
		em.getTransaction().commit();
		*/

		/*
		em.getTransaction().begin();
		Album albumToDelete = em.find(Album.class, al1.getId());
		if (albumToDelete != null) {
			em.remove(albumToDelete);
			System.out.println("Album supprimé : " + albumToDelete.getTitle());
		}
		em.getTransaction().commit();
		*/
		
		em.close();
		JpaUtil.close();
	}
}