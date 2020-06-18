package com.regex;

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
}
