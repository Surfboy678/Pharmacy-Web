package com.brodacki.janusz.pharmacy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {
    public static boolean checkEmailOrPassword(String pattern, String patternStr){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(patternStr);
        return matcher.matches();
    }
}