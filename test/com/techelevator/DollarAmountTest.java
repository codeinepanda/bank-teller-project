package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class DollarAmountTest {

	@Before
	public void setup(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
	}
	
	@Test
	public void getDollars_returns_the_number_of_whole_dollars(){
		
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfDollars = anAmount.getDollars();
		Assert.assertEquals(12, numberOfDollars);
	}
	
	@Test
	public void getCents_returns_the_number_of_cents(){
		
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfCents = anAmount.getCents();
		Assert.assertEquals(34, numberOfCents);
	}
	
	@Test
	public void isGreaterThan_returns_true_for_lesser_amounts(){
		
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertTrue(firstAmount.isGreaterThan(secondAmount));
	}
	
	@Test
	public void constructor_takes_dollars_cents(){
		DollarAmount tenTwentyFive = new DollarAmount(10,25);
		DollarAmount tenTwentyFive2 = new DollarAmount(1025);
		Assert.assertEquals(tenTwentyFive, tenTwentyFive2);
	}
	
	@Test
	public void is_less_than_or_equal_to_returns_true_if_equal_to(){
		DollarAmount tenTwentyFive = new DollarAmount(10,25);
		DollarAmount tenTwentyFive2 = new DollarAmount(1025);
		boolean isLessOrEqual = tenTwentyFive.isLessThanOrEqualTo(tenTwentyFive2);
		
		
		Assert.assertTrue(isLessOrEqual);
	}
	
	@Test
	public void is_less_than_or_equal_to_returns_true_if_less_than(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		
		boolean isLessOrEqual = ten.isLessThanOrEqualTo(twenty);
		
		Assert.assertTrue(isLessOrEqual);
	}
	
	@Test
	public void is_less_than_or_equal_to_returns_false_if_greater_than(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		
		boolean isLessOrEqual = twenty.isLessThanOrEqualTo(ten);
		
		Assert.assertFalse(isLessOrEqual);
	}
	
	@Test
	public void is_negative_returns_true(){
		DollarAmount negTen = new DollarAmount(-1000);
		boolean isNeg = negTen.isNegative();
		
		Assert.assertTrue(isNeg);
	}
	
	@Test
	public void is_negative_returns_false_if_positive(){
		DollarAmount ten = new DollarAmount(-000);
		boolean isNeg = ten.isNegative();
		
		Assert.assertFalse(isNeg);
	}
	
	@Test
	public void is_less_than_returns_true_if_less_than(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount tenTwentyFive2 = new DollarAmount(1025);
		boolean isLess = ten.isLessThan(tenTwentyFive2);
		
		
		Assert.assertTrue(isLess);
	}
	
	@Test
	public void is_less_than_returns_false_if_greater_than(){
		DollarAmount twenty = new DollarAmount(2000);
		DollarAmount tenTwentyFive2 = new DollarAmount(1025);
		boolean isLess = twenty.isLessThan(tenTwentyFive2);
		
		
		Assert.assertFalse(isLess);
	}
	
	@Test
	public void compare_to_returns_0_if_both_variables_are_equal(){
		DollarAmount tenTwentyFive = new DollarAmount(10,25);
		DollarAmount tenTwentyFive2 = new DollarAmount(1025);
		
		
		Assert.assertEquals(0, tenTwentyFive.compareTo(tenTwentyFive2));
	}
	
	@Test
	public void compare_to_returns_1_if_amount_is_greater_than_other_amount(){
		DollarAmount tenTwentyFive = new DollarAmount(1025);
		DollarAmount ten = new DollarAmount(1000);
		
		
		Assert.assertEquals(1, tenTwentyFive.compareTo(ten));
	}
	
	@Test
	public void compare_to_returns_neg_1_if_amount_is_less_than_other_amount(){
		DollarAmount tenTwentyFive = new DollarAmount(1025);
		DollarAmount ten = new DollarAmount(1000);
		
		
		Assert.assertEquals(-1, ten.compareTo(tenTwentyFive));
	}
	
	/////////
	@Test
	public void to_String_changes_dollar_amount_to_string(){
		DollarAmount nineCents = new DollarAmount(9);
		Assert.assertEquals("$0.09", nineCents.toString());
	}
	
	@Test
	public void to_String_changes_dollar_amount_to_string2(){
		DollarAmount tenAndNineCents = new DollarAmount(1009);
		Assert.assertEquals("$10.09", tenAndNineCents.toString());
	}
	
	@Test
	public void to_String_changes_dollar_amount_to_string3(){
		DollarAmount ten = new DollarAmount(1000);
		Assert.assertEquals("$10.00", ten.toString());
	}
	
	@Test
	public void to_String_changes_dollar_amount_to_string4(){
		DollarAmount ninetyNineCents = new DollarAmount(99);
		Assert.assertEquals("$0.99", ninetyNineCents.toString());
	}
	
	@Test
	public void to_String_changes_dollar_amount_to_string5(){
		DollarAmount nineNinetyNineCents = new DollarAmount(999);
		Assert.assertEquals("$9.99", nineNinetyNineCents.toString());
	}
	
	@Test
	public void to_String_changes_dollar_amount_to_string6(){
		DollarAmount nineNinety = new DollarAmount(990);
		Assert.assertEquals("$9.90", nineNinety.toString());
	}
	
	
	@Test
	public void equals_declares_true_if_obj_is_equal_to_dollar_amount(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount otherTen = new DollarAmount(1000);
		
		Assert.assertTrue(ten.equals(otherTen));
	}
	
	@Test
	public void equals_declares_false_if_obj_is_equal_to_dollar_amount(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		
		Assert.assertFalse(ten.equals(twenty));
	}
	
	
	@Test
	public void equals_declares_false_if_obj_is_null(){
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		twenty = null;
		
		Assert.assertFalse(ten.equals(twenty));
	}
	
	
	@Test
	public void equals_declares_false_if_obj_is_not_a_dollar_amount(){
		DollarAmount ten = new DollarAmount(1000);
		
		String words = "wordstring";
		
		Assert.assertFalse(ten.equals(words));
	}
	
	@Test
	public void hash_code_returns_total_amount_in_cents(){
		DollarAmount ten = new DollarAmount(1000);
		
		Assert.assertEquals(1000, ten.hashCode());
	}
	
	
	
	
	
}
