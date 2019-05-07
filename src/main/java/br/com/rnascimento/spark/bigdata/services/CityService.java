package br.com.rnascimento.spark.bigdata.services;

import java.util.List;

import javax.inject.Inject;

import br.com.rnascimento.spark.bigdata.model.City;
import br.com.rnascimento.spark.bigdata.repository.CityRepository;

public class CityService {

	@Inject
	private CityRepository cityRepository;

	public void save(City city) {
		this.cityRepository.save(city);
	}

	public void remove(Long id) {
		City city = this.findBy(id);
		this.cityRepository.remove(city);
	}

	public City findBy(Long id) {
		return this.cityRepository.findBy(id);
	}

	public List<City> findAll() {
		return this.cityRepository.findAll();
	}
}
