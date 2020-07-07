package br.com.springbootcourse.math;

import org.springframework.stereotype.Service;

import br.com.springbootcourse.converters.ConvertValue;
import br.com.springbootcourse.validation.Validation;

@Service
public class SimpleMath {
	
	public Double sum(String numberOne, String numberTwo) throws Exception {
		Validation.validationNumber(numberOne);
		Validation.validationNumber(numberTwo);
		return ConvertValue.convertDouble(numberOne) + ConvertValue.convertDouble(numberTwo);
	}
	
	public Double sub(String numberOne, String numberTwo) throws Exception {
		Validation.validationNumber(numberOne);
		Validation.validationNumber(numberTwo);
		return ConvertValue.convertDouble(numberOne) - ConvertValue.convertDouble(numberTwo);
	}
	
	public Double mult(String numberOne, String numberTwo) throws Exception {
		Validation.validationNumber(numberOne);
		Validation.validationNumber(numberTwo);
		return ConvertValue.convertDouble(numberOne) * ConvertValue.convertDouble(numberTwo);
	}
	
	public Double divis(String numberOne, String numberTwo) throws Exception {
		Validation.validationNumber(numberOne);
		Validation.validationNumber(numberTwo);
		return ConvertValue.convertDouble(numberOne) / ConvertValue.convertDouble(numberTwo);
	}
	
	public Double med(String numberOne, String numberTwo) throws Exception {
		Validation.validationNumber(numberOne);
		Validation.validationNumber(numberTwo);
		return (ConvertValue.convertDouble(numberOne) + ConvertValue.convertDouble(numberTwo)) / 2;
	}
	
	public Double raiz(String number) throws Exception {
		Validation.validationNumber(number);
		return (Double) Math.sqrt(ConvertValue.convertDouble(number));
	}
}
