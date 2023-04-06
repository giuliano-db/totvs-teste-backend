package com.totvs.entrevista.pessoa.util.validation;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CaracteresUnicosValidator implements ConstraintValidator <CaracteresUnicos, String> {
	 
	@Override
	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        if (value == null) {
	            return true;
	        }
	        Set<Character> uniqueChars = new HashSet <>();
	        for (int i = 0; i < value.length(); i++) {
	            char c = value.charAt(i);
	            if (uniqueChars.contains(c)) {
	                return false;
	            } else {
	                uniqueChars.add(c);
	            }
	        }
	        return true;
	    }


}
