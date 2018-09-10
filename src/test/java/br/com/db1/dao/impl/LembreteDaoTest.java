package br.com.db1.dao.impl;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1.AbstractTestCase;
import br.com.db1.model.Uf;

public class LembreteDaoTest extends AbstractTestCase {

	private UfDao dao;

	@Before
	public void init() {
		dao = new UfDao(manager);
	}

	@Test
	public void findAllTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Lembrete");
		queryCidade.executeUpdate();

		Query queryUf = manager.createNativeQuery("DELETE FROM Lembrete");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Lembrete lembra = new Lembrete();
		lembra.setLembrete("Compra");
		manager.persist(lembra);

		Assert.assertTrue(dao.findAll().size() > 0);

	}

	@Test
	public void findByIdTest() {
		
	}

	@Test
	public void findByNameTest() {
		Query queryLembrete = manager.createNativeQuery("DELETE FROM Lembrete");
		queryLembrete.executeUpdate();

		Query queryLembrate = manager.createNativeQuery("DELETE FROM Uf where lembrete = :pLembrete");
		queryUf.setParameter("pLembrete", "Compra");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findByName("Compra").size() == 0);

		Lembrete lembra = new Lembrete();
		lembra.setLembrete("Compra");
		manager.persist(lembra);

		Assert.assertTrue(dao.findByName("Compra").size() == 1);
	}

	@Test
	public void saveTest() {
		Query queryLembrete = manager.createNativeQuery("DELETE FROM Lembrete");
		queryLembrete.executeUpdate();

		Query queryLembrete = manager.createNativeQuery("DELETE FROM Lembrete");
		queryLembrete.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Lembrete lembra = new Lembrete();
		lembra.setLembrete("Compra");
		dao.save(lembra);

		Assert.assertTrue(dao.findAll().size() == 1);
		
		lembrete.setLembrete("Compra");
		dao.save(lembrete);
		Assert.assertTrue(dao.findAll().size() == 1);


	}

	@Test
	public void deleteTest() {
		Query queryLembrete = manager.createNativeQuery("DELETE FROM Lembrete");
		queryLembrete.executeUpdate();

		Query queryLembrete = manager.createNativeQuery("DELETE FROM Lembrete");
		queryLembrete.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Lembrete lembra = new Lembrete();
		lembra.setLembrete("Compra");
		dao.save(lembra);

		Assert.assertTrue(dao.findAll().size() == 1);
		
		dao.delete(uf.getId());
		Assert.assertTrue(dao.findAll().size() == 0);

	}

}