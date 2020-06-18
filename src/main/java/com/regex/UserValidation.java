package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation
{
    public static final String FIRST_NAME_REGEX="^[A-Z]{1}[A-Za-z]{2,}$";

    public boolean validateFirstName(String firstName)
    {
        Pattern pattern=Pattern.compile(FIRST_NAME_REGEX);
        return pattern.matcher(firstName).matches();
    }

    public static final String LAST_NAME_REGEX="^[A-Z]{1}[A-Za-z]{2,}$";

    public boolean validateLastName(String lastName)
    {
        Pattern pattern=Pattern.compile(LAST_NAME_REGEX);
        return pattern.matcher(lastName).matches();
    }

    public static final String PHONE_NUMBER_REGEX="^(91)[\\s][0-9]{10}$";

    public boolean validatePhoneNumber(String phoneNumber)
    {
        Pattern pattern=Pattern.compile(PHONE_NUMBER_REGEX);
        return pattern.matcher(phoneNumber).matches();
    }

    public static class ValidateEmail
    {
        private Pattern pattern;
        private Matcher matcher;
        public static final String EMAIL_REGEX = "^[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$";

        public void validateEmail()
        {
            pattern = Pattern.compile(EMAIL_REGEX);
        }

        public boolean validate(final String email)
        {
            return pattern.matcher(email).matches();
        }
    }
}
