import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!password.equals(passwordConfirm)) {
			throw new UnmatchedException("Passwords do not match");
		}
	}
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	public static boolean isValidLength(String password) throws LengthException{
		if(password.length()<6) {
			throw new LengthException("The password must be at least 6 characters long");
		}
		return true;
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
		} else {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
		} else {
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}	
	}
	public static boolean hasDigit(String password) throws NoDigitException{
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
		} else {
			throw new NoDigitException("The password must contain at least one digit");
		}	
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()) {
			return true;
		} else {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}	
	}
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		char c1=password.charAt(1);
		char c2=password.charAt(0);
		for(int i=2;i<password.length();i++) {
			if(password.charAt(i)==c1&&password.charAt(i)==c2) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
			c2=c1;
			c1=password.charAt(i);
		}
		return true;
	}
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		return isValidLength(password)&&hasUpperAlpha(password)&hasLowerAlpha(password)&&hasDigit(password)&&hasSpecialChar(password)&&NoSameCharInSequence(password);
	}
	public static boolean hasBetweenSixAndNineChars(String password) {
		return password.length()>=6&&password.length()<=10;
	}
	public static boolean isWeakPassword(String password) throws WeakPasswordException{ 
		try {
			isValidPassword(password);
		} catch (Exception e) {
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
		}
		if(hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");

		}
		return false;
		
	}
	public static java.util.ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		java.util.ArrayList<String> inv= new java.util.ArrayList<String>();
		for( String pas: passwords){
			try {
				isValidPassword(pas);
			} catch (Exception e) {
				inv.add(pas+ " "+e.getMessage());
			} 
		}
		return inv;
	}
	
	

}












