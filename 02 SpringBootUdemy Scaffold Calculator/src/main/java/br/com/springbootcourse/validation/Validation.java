package br.com.springbootcourse.validation;

import br.com.springbootcourse.converters.ConvertValue;
import br.com.springbootcourse.exception.UnsuportedMathOperationException;

public class Validation {
	
	
	public static boolean validationNumber(String number) throws Exception {
		if(!ConvertValue.isNumeric(number)) throw new UnsuportedMathOperationException("Please set a numeric value!");
		return true;
	}
}
