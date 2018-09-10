package br.com.db1.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

	public class LembreteTest {
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("db1start");
		manager = factory.createEntityManager();
	}
	
	@After
	public void fim(){
		factory.close();
	}
	
	@Test
	public void inserirTest() {
		Lembrete lembrete = new Lembrete();
		lembrete.setLembrete("Compra");
		
		manager.getTransaction().begin();
		manager.persist(lembrete);
		manager.getTransaction().commit();
	}
	
	@Test
	public void updateTest(){
		Query q = manager.createQuery("from uf where nome = :pLembrete");
		q.setParameter("pLembrete", "Compra");
		q.setMaxResults(1);
		Lembrete lembrete = (Lembrete) q.getSingleResult();
				
		System.out.println(lembrete);
		
		lembrete.setNome("AA");
		manager.getTransaction().begin();
		manager.persist(lembrete);
		manager.getTransaction().commit();
	}
}
