package br.com.rnascimento.spark.bigdata.transformer;

import javax.inject.Inject;
import javax.json.bind.Jsonb;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

	@Inject
	private Jsonb jsonb;

	@Override
	public String render(Object model) throws Exception {
		return jsonb.toJson(model);
	}

}
