package br.com.rnascimento.spark.bigdata.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.rnascimento.spark.bigdata.model.City;

@Repository
public interface CityRepository extends EntityRepository<City, Long> {
	
}