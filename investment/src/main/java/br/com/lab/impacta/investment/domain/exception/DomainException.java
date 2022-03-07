package br.com.lab.impacta.investment.domain.exception;

import lombok.Getter;

@Getter
public abstract class DomainException extends RuntimeException {

	private static final long serialVersionUID = -5891251835224016774L;

	private String description;

	public DomainException(String message, String description) {
		super(message);
		this.description = description;
	}
}
