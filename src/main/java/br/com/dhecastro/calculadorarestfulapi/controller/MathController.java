package br.com.dhecastro.calculadorarestfulapi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dhecastro.calculadorarestfulapi.exceptions.DivisionForZeroException;
import br.com.dhecastro.calculadorarestfulapi.exceptions.UnsupportedMathOperationsException;
import br.com.dhecastro.calculadorarestfulapi.util.CalculadoraUtil;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne) || !CalculadoraUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		Double sum = CalculadoraUtil.convertToDouble(numberOne) + CalculadoraUtil.convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne) || !CalculadoraUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		Double sub = CalculadoraUtil.convertToDouble(numberOne) - CalculadoraUtil.convertToDouble(numberTwo);
		return sub;
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne) || !CalculadoraUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		Double mult = CalculadoraUtil.convertToDouble(numberOne) * CalculadoraUtil.convertToDouble(numberTwo);
		return mult;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne) || !CalculadoraUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		if(CalculadoraUtil.isNumeric(numberTwo)) {
			if(CalculadoraUtil.convertToDouble(numberTwo) == 0D) {
				throw new DivisionForZeroException("Division for zero not permited");
			}
		}
		
		Double div = CalculadoraUtil.convertToDouble(numberOne) / CalculadoraUtil.convertToDouble(numberTwo);
		return div;
	}
	
	@RequestMapping(value="/sqrt/{numberOne}", method=RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		Double sqrt = Math.sqrt(CalculadoraUtil.convertToDouble(numberOne));
		return sqrt;
	}

	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	
		if(!CalculadoraUtil.isNumeric(numberOne) || !CalculadoraUtil.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value");
		}
		
		Double sum = CalculadoraUtil.convertToDouble(numberOne) + CalculadoraUtil.convertToDouble(numberTwo);
		
		return sum/2;
	}
}
