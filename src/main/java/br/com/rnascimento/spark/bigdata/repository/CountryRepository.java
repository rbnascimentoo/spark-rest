package br.com.rnascimento.spark.bigdata.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.rnascimento.spark.bigdata.model.Country;

@Repository
public interface CountryRepository extends EntityRepository<Country, Long> {

}
