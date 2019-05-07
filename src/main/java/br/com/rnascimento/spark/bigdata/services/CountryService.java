package br.com.rnascimento.spark.bigdata.services;

import java.util.List;

import javax.inject.Inject;

import br.com.rnascimento.spark.bigdata.model.Country;
import br.com.rnascimento.spark.bigdata.repository.CountryRepository;

public class CountryService {

	@Inject
	private CountryRepository countryRepository;

	public void save(Country country) {
		this.countryRepository.save(country);
	}

	public void remove(Long id) {
		Country country = this.findBy(id);
		this.countryRepository.remove(country);
	}

	public Country findBy(Long id) {
		return this.countryRepository.findBy(id);
	}

	public List<Country> findAll() {
		return this.countryRepository.findAll();
	}
}
