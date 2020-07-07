package br.com.springbootcourse.converters;

public class ConvertValue {

	public static Double convertDouble(String stringToDouble) {
		if(stringToDouble == null) return 0D;
		String number = stringToDouble.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String numberVerify) {
		if (numberVerify == null) return false;
		String number = numberVerify.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
