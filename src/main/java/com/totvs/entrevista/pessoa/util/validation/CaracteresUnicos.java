package com.totvs.entrevista.pessoa.util.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CaracteresUnicosValidator.class })
public @interface CaracteresUnicos {
	String message() default "O conteúdo deve ser caracteres únicos.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
