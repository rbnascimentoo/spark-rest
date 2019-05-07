package br.com.rnascimento.spark.bigdata.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel {

	private int codigo;
	private String mensagem;
}
