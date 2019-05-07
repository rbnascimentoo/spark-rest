package br.com.rnascimento.spark.bigdata.produces;

import javax.enterprise.inject.Produces;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBindProduces {

	@Produces
	public Jsonb createJsonB() {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb;
	}
}
