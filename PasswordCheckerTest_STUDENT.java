
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] p = {"Saturn1S@aturn","Satur","saturn1s@aturn","SATURN1S@TURN","Saturn1@","Saturn1S@aaaturn","SaturnS@aturn"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList

	}

	@After
	public void tearDown() throws Exception {
		passwords = null;

	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidLength(passwords.get(0)));
		}
		catch(LengthException e)
		{
			assertTrue("unSuccessfully threw a lengthExcepetion",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidLength(passwords.get(1)));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwords.get(0)));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("unSuccessfully threw a NoUpperAlphaException",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwords.get(2)));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}	
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwords.get(0)));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("unSuccessfully threw a upperalphaexception",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwords.get(3)));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertFalse(PasswordCheckerUtility.isWeakPassword(passwords.get(0)));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("unSuccessfully threw a WeakPasswordException",false);
		}
		try{
			assertFalse(PasswordCheckerUtility.isWeakPassword(passwords.get(4)));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}	
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(passwords.get(0)));
		}
		catch(InvalidSequenceException  e)
		{
			assertTrue("unSuccessfully threw a InvalidSequenceException",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(passwords.get(5)));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasDigit(passwords.get(0)));
		}
		catch(NoDigitException  e)
		{
			assertTrue("unSuccessfully threw a NoDigitException",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.hasDigit(passwords.get(6)));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
		}
		catch(Exception  e)
		{
			assertTrue("unSuccessfully threw a exception",false);
		}	
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		assertTrue(PasswordCheckerUtility.getInvalidPasswords(passwords).size()==5);
		
		
	}
	
}
