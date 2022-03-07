package br.com.lab.impacta.investment.domain.exception;

public class InvestmentProductNotFoundException extends DomainException {

	private static final long serialVersionUID = -3639523238015183800L;

	public InvestmentProductNotFoundException(String message, String description) {
		super(message, description);
	}
}
