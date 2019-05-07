package br.com.rnascimento.spark.bigdata.services;

import java.util.List;

import javax.inject.Inject;

import br.com.rnascimento.spark.bigdata.model.State;
import br.com.rnascimento.spark.bigdata.repository.StateRepository;

public class StateService {

	@Inject
	private StateRepository stateRepository;

	public void save(State state) {
		this.stateRepository.save(state);
	}

	public void remove(Long id) {
		State state = this.findBy(id);
		this.stateRepository.remove(state);
	}

	public State findBy(Long id) {
		return this.stateRepository.findBy(id);
	}

	public List<State> findAll() {
		return this.stateRepository.findAll();
	}
}
