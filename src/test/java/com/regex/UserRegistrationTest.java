package com.regex;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest
{
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue()
    {
        UserValidation userValidation=new UserValidation();
        boolean isValid=userValidation.validateFirstName("Haritha");
        Assert.assertTrue(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_Length_ShouldReturnFalse()
    {
        UserValidation userValidation=new UserValidation();
        boolean isValid=userValidation.validateFirstName("Ha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForUpperCase_ShouldReturnFalse()
    {
        UserValidation userValidation=new UserValidation();
        boolean isValid=userValidation.validateFirstName("haritha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForSpecialCharacter_ShouldReturnFalse()
    {
        UserValidation userValidation=new UserValidation();
        boolean isValid=userValidation.validateFirstName("Hari@tha");
        Assert.assertFalse(isValid);
    }

    @Test
    public void givenFirstName_WhenNotProper_ForNumber_ShouldReturnFalse()
    {
        UserValidation userValidation=new UserValidation();
        boolean isValid=userValidation.validateFirstName("Hari123");
        Assert.assertFalse(isValid);
    }

}