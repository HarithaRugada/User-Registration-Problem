package com.regex;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class UserRegistrationTest
{
    UserValidation userValidation=new UserValidation();

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue()
    {
        boolean isValid=userValidation.validateFirstName("Haritha");
        Assert.assertTrue(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_Length_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateFirstName("Ha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForUpperCase_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateFirstName("haritha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForSpecialCharacter_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateFirstName("Hari@tha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForNumber_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateFirstName("Hari123");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue()
    {
        boolean isValid=userValidation.validateLastName("Rugada");
        Assert.assertTrue(isValid);
    }

    @Test
    public void givenLastName_WhenNotProper_Length_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateLastName("Ru");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenLastName_WhenNotProper_ForUpperCase_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateLastName("rugada");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenLastName_WhenNotProper_ForSpecialCharacter_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateLastName("Rug.ada");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenLastName_WhenNotProper_ForNumber_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validateLastName("Rugada123");
        Assert.assertFalse(isValid);
    }

    @RunWith(Parameterized.class)
    public static class ValidateEmailTest
    {
        private String emailId;
        private static UserValidation.ValidateEmail validateEmail;
        private Boolean expectedValidation;

        public void ValidateEmailTest(String emailId, Boolean expectedValidation)
        {
            this.emailId = emailId;
            this.expectedValidation = expectedValidation;
        }

        @BeforeClass
        public static void initialize()
        {
            validateEmail = new UserValidation.ValidateEmail();
        }

            @Parameterized.Parameters
            public static Collection data()
            {
                Object[][] data = new Object[][]
                        {
                                //Test cases which are expected to be true
                                {"abc@yahoo.com", true},
                                {"abc-100@yahoo.com", true},
                                {"abc.100@yahoo.com", true},
                                {"abc111@abc.com", true},
                                {"abc-100@abc.net", true},
                                {"abc.100@abc.com.au", true},
                                {"abc@1.com", true},
                                {"abc@gmail.com.com", true},
                                {"abc+100@gmail.com", true},

                                //Test cases which are expected to be false
                                {"abc", false},
                                {"abc@.com.my", false},
                                {"abc123@gmail.a", false},
                                {"abc123@.com", false},
                                {"abc123@.com.com", false},
                                {".abc@abc.com", false},
                                {"abc()*@gmail.com", false},
                                {"abc@%*.com", false},
                                {"abc..2002@gmail.com", false},
                                {"abc.@gmail.com", false},
                                {"abc@abc@gmail.com", false},
                                {"abc@gmail.com.1a", false},
                                {"abc@gmail.com.aa.au", false}
                        };
                return Arrays.asList(data);
            }

            @Test
            public void test()
            {
                Boolean isValid = validateEmail.validate(this.emailId);
                assertEquals(this.expectedValidation,isValid);
            }
        }

    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue()
    {
        boolean isValid=userValidation.validatePhoneNumber("91 9876543210");
        Assert.assertTrue(isValid);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_Length_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePhoneNumber("91 903229");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_Code_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePhoneNumber("87 9876543210");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_NoCode_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePhoneNumber("9876543210");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPassword_WhenProper_Length_Capital_ShouldReturnTrue()
    {
        boolean isValid=userValidation.validatePassword("abc1@dAefgh");
        Assert.assertTrue(isValid);
    }

    @Test
    public void givenPassword_WhenNotProper_NoCapital_NoNumeric_ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePassword("abcdefgh");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPassword_WhenNotProper_NoLength__ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePassword("a1bCc");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPassword_WhenNotProper_NoNumeric__ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePassword("aferesrbCc");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenPassword_WhenNotProper_NoSpecial__ShouldReturnFalse()
    {
        boolean isValid=userValidation.validatePassword("afer1esrbCc");
        Assert.assertFalse(isValid);
    }
}
