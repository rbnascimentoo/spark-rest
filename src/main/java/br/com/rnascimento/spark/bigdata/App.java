package br.com.rnascimento.spark.bigdata;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.Jsonb;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.com.rnascimento.spark.bigdata.corsfilter.CorsFilter;
import br.com.rnascimento.spark.bigdata.model.City;
import br.com.rnascimento.spark.bigdata.model.Country;
import br.com.rnascimento.spark.bigdata.model.State;
import br.com.rnascimento.spark.bigdata.responses.ResponseModel;
import br.com.rnascimento.spark.bigdata.services.CityService;
import br.com.rnascimento.spark.bigdata.services.CountryService;
import br.com.rnascimento.spark.bigdata.services.StateService;
import br.com.rnascimento.spark.bigdata.transformer.JsonTransformer;
import spark.Spark;

public class App {

	@Inject
	private JsonTransformer jsonTransformer;

	@Inject
	private CityService cityService;

	@Inject
	private StateService stateService;

	@Inject
	private CountryService countryService;

	@Inject
	private Jsonb jsonb;

	public void main(@Observes ContainerInitialized event) {

		Spark.port(8080);
		CorsFilter.enableCORS();

		Spark.path("api/", () -> {

			// city
			Spark.get("city", (req, res) -> {
				res.type("application/json");
				return cityService.findAll();
			}, jsonTransformer);

			Spark.post("city", (req, res) -> {
				try {
					res.type("application/json");
					City city = jsonb.fromJson(req.body(), City.class);
					cityService.save(city);
					return new ResponseModel(200, "City saved successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.get("city/:codigo", (req, res) -> {
				res.type("application/json");
				String codigo = req.params("codigo");
				Long id = Long.valueOf(codigo);
				City city = cityService.findBy(id);
				return city;
			}, jsonTransformer);

			Spark.put("city", (req, res) -> {
				try {
					res.type("application/json");
					City city = jsonb.fromJson(req.body(), City.class);
					cityService.save(city);
					return new ResponseModel(1, "City updated successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.delete("city/:codigo", (req, res) -> {
				try {
					res.type("application/json");
					String codigo = req.params("codigo");
					Long id = Long.valueOf(codigo);
					cityService.remove(id);
					return new ResponseModel(1, "City deleted successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			// state
			Spark.get("state", (req, res) -> {
				res.type("application/json");
				return stateService.findAll();
			}, jsonTransformer);

			Spark.post("state", (req, res) -> {
				try {
					res.type("application/json");
					State state = jsonb.fromJson(req.body(), State.class);
					stateService.save(state);
					return new ResponseModel(200, "State saved successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.get("state/:codigo", (req, res) -> {
				res.type("application/json");
				String codigo = req.params("codigo");
				Long id = Long.valueOf(codigo);
				State state = stateService.findBy(id);
				return state;
			}, jsonTransformer);

			Spark.put("state", (req, res) -> {
				try {
					res.type("application/json");
					State state = jsonb.fromJson(req.body(), State.class);
					stateService.save(state);
					return new ResponseModel(200, "State updated successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.delete("state/:codigo", (req, res) -> {
				try {
					res.type("application/json");
					String codigo = req.params("codigo");
					Long id = Long.valueOf(codigo);
					stateService.remove(id);
					return new ResponseModel(1, "State deleted successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			// country
			Spark.get("country", (req, res) -> {
				res.type("application/json");
				return countryService.findAll();
			}, jsonTransformer);

			Spark.post("country", (req, res) -> {
				try {
					res.type("application/json");
					Country country = jsonb.fromJson(req.body(), Country.class);
					countryService.save(country);
					return new ResponseModel(200, "Country saved successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.get("country/:codigo", (req, res) -> {
				res.type("application/json");
				String codigo = req.params("codigo");
				Long id = Long.valueOf(codigo);
				Country country = countryService.findBy(id);
				return country;
			}, jsonTransformer);

			Spark.put("country", (req, res) -> {
				try {
					res.type("application/json");
					Country country = jsonb.fromJson(req.body(), Country.class);
					countryService.save(country);
					return new ResponseModel(1, "Country updated successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			Spark.delete("country/:codigo", (req, res) -> {
				try {
					res.type("application/json");
					String codigo = req.params("codigo");
					Long id = Long.valueOf(codigo);
					countryService.remove(id);
					return new ResponseModel(1, "Country deleted successfully!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

		});
	}
}
