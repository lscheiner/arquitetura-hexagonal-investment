package br.com.lab.impacta.investment.domain.exception;

public class InvestmentAccountWithoutBalanceException extends DomainException {

	private static final long serialVersionUID = -3095443372859976360L;

	public InvestmentAccountWithoutBalanceException(String message, String description) {
        super(message, description);
    }
}
