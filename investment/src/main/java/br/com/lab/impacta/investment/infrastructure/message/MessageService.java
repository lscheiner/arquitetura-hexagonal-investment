package br.com.lab.impacta.investment.infrastructure.message;

import java.util.Locale;

import org.springframework.lang.Nullable;

public interface MessageService {

	String getMessage(String code, @Nullable Object[] args, Locale locale);

	String getMessage(String code, @Nullable Object[] args);

	String getMessage(String code);

}
