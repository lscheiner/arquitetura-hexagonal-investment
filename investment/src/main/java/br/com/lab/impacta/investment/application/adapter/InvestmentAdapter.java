package br.com.lab.impacta.investment.application.adapter;

import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse;
import br.com.lab.impacta.investment.domain.model.Investment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestmentAdapter {

	public static InvestmentResponse toDtoInvestment(Investment investment) {
		return new InvestmentResponse(investment.getId(), investment.getValue(), investment.getDate());
	}
}
