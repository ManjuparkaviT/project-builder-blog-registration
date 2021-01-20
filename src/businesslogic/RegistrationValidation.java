package businesslogic;

public class RegistrationValidation{
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validPassword( password, confirmPassword) && validEmail(email)) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean validPassword(String password, String confirmPassword) {
		int length=password.length();
		int upper=0,lower=0,digit=0;
		for(int i=0;i<length;i++) {
			char a=password.charAt(i);
			if(Character.isDigit(a))digit+=1;
			else if(Character.isUpperCase(a))upper+=1;
			else if(Character.isLowerCase(a))lower+=1;
		}
		if(length>=8 && length<=20 && upper>=1 && lower>=1 && digit>=1 && password.equals(confirmPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean validEmail(String email) {
		int c=0,b=0,c1=0;
		for(int i=0;i<email.length();i++) {
			char a=email.charAt(i);
			if (Character.isAlphabetic(a) || Character.isDigit(a)|| a=='@' || a=='.' || a=='_' )c+=1;
			if(a=='@')b+=1;
			if(a=='.')c1+=1;
		}
		if(email.length()>0 && c==email.length() && b==1 && c1==1)return true;
		else return false;
	}
}