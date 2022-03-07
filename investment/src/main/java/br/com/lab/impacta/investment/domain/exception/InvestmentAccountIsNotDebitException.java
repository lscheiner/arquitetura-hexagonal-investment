package br.com.lab.impacta.investment.domain.exception;

public class InvestmentAccountIsNotDebitException extends DomainException {

	private static final long serialVersionUID = 352887208351336002L;

	public InvestmentAccountIsNotDebitException(String message, String description) {
		super(message, description);
	}
}
