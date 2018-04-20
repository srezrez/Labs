package by.bsuir.convertor.action;

public class Convertor {

	StringBuilder res;
	
	public void init() {
		res = new StringBuilder();
	}
	
	/**
	 * Method converts decimal numbers into binary.
	 * @param num - input number
	 * @return String - converted number
	 */
	public String convert(int num) {
		init();
		res = new StringBuilder();
		while(num>0) {
			res.append(num%2);
			num/=2;
		}
		res.reverse();
		return res.toString();
	}
}
