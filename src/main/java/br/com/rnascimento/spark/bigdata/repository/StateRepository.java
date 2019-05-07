package br.com.rnascimento.spark.bigdata.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.rnascimento.spark.bigdata.model.State;

@Repository
public interface StateRepository extends EntityRepository<State, Long>{

}
