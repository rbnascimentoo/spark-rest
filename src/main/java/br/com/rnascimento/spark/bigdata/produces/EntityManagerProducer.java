package br.com.rnascimento.spark.bigdata.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	@Produces
	@ApplicationScoped
	public EntityManager criarEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("spark-bigdata");
		return emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
