package br.com.lab.impacta.investment.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DebitAccountRequest {
	private Double valueOfDebit;
}
