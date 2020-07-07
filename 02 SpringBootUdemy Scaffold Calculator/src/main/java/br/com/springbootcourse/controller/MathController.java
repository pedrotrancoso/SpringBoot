package br.com.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootcourse.math.SimpleMath;

@RestController
public class MathController {
	
	@Autowired
	SimpleMath math;
		
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return math.sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value="sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return math.sub(numberOne, numberTwo);
	}

	@RequestMapping(value="mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return math.mult(numberOne, numberTwo);
	}
	
	@RequestMapping(value="div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double divis(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return math.divis(numberOne, numberTwo);
	}
	
	@RequestMapping(value="med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return math.med(numberOne, numberTwo);
	}
	
	@RequestMapping(value="raiz/{number}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("number") String number) throws Exception {
		return math.raiz(number);
	}
}
