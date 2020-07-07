package br.com.springbootcourse.validation;

import br.com.springbootcourse.converters.ConvertValue;
import br.com.springbootcourse.exception.ResourceNotFoundException;

public class Validation {
	
	
	public static boolean validationNumber(String number) throws Exception {
		if(!ConvertValue.isNumeric(number)) throw new ResourceNotFoundException("Please set a numeric value!");
		return true;
	}
}
