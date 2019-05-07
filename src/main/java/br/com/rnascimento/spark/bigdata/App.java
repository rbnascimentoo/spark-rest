package br.com.rnascimento.spark.bigdata;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.Jsonb;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.com.rnascimento.spark.bigdata.corsfilter.CorsFilter;
import br.com.rnascimento.spark.bigdata.repository.CityRepository;
import br.com.rnascimento.spark.bigdata.repository.CountryRepository;
import br.com.rnascimento.spark.bigdata.repository.StateRepository;
import br.com.rnascimento.spark.bigdata.transformer.JsonTransformer;
import spark.Spark;

public class App {

	@Inject
	private JsonTransformer jsonTransformer;
	
	@Inject
	private CityRepository cityRepository;
	
	@Inject
	private StateRepository stateRepository; 
	
	@Inject
	private CountryRepository countryRepository; 

	@Inject
	private Jsonb jsonb;

	public void main(@Observes ContainerInitialized event) {

		Spark.port(8080);
		CorsFilter.enableCORS();

		Spark.path("api/", () -> {
			
			//city
			Spark.get("city", (req, res) -> {
				res.type("application/json");
				return cityRepository.findAll();
			}, jsonTransformer);
			
			//state
			Spark.get("state", (req, res) -> {
				res.type("application/json");
				return stateRepository.findAll();
			}, jsonTransformer);
			
			//country
			Spark.get("country", (req, res) -> {
				res.type("application/json");
				return countryRepository.findAll();
			}, jsonTransformer);
			
		});
	}
}
