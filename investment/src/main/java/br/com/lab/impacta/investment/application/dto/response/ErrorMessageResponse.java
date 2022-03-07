package br.com.lab.impacta.investment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessageResponse {
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
}