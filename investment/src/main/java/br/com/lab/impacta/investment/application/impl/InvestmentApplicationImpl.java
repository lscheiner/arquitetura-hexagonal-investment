package br.com.lab.impacta.investment.application.impl;

import org.springframework.stereotype.Component;

import br.com.lab.impacta.investment.application.InvestmentApplication;
import br.com.lab.impacta.investment.application.adapter.InvestmentAdapter;
import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse;
import br.com.lab.impacta.investment.domain.model.Investment;
import br.com.lab.impacta.investment.domain.service.InvestmentService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InvestmentApplicationImpl implements InvestmentApplication {

	private InvestmentService investmentService;

	@Override
	public InvestmentResponse invest(Long accountId, InvestmentRequest investmentRequest) {
		Investment investment = this.investmentService.invest(investmentRequest.getProductId(), accountId,
				investmentRequest.getValue());

		return InvestmentAdapter.toDtoInvestment(investment);
	}
}
