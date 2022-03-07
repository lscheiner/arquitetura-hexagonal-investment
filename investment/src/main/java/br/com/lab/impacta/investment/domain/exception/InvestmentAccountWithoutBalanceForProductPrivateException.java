package br.com.lab.impacta.investment.domain.exception;

public class InvestmentAccountWithoutBalanceForProductPrivateException extends DomainException {

	private static final long serialVersionUID = -18634880669578187L;

	public InvestmentAccountWithoutBalanceForProductPrivateException(String message, String description) {
        super(message, description);

    }
}
