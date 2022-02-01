package com.tencent.qqmail.register.util;

import com.tencent.qqmail.QMApplicationContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUtil
{
  private static final String REGEX_ALL_DIGITAL = "[0-9]*";
  private static final String REGEX_ILLEGAL_CHARACTER = "[^a-zA-Z0-9!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]";
  
  public static String getAppName()
  {
    return QMApplicationContext.sharedInstance().getString(2131690411);
  }
  
  public static boolean isIllegalCharacter(String paramString)
  {
    return Pattern.compile("[^a-zA-Z0-9!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]").matcher(paramString).find();
  }
  
  public static boolean isMobiPhoneNum(String paramString)
  {
    return Pattern.compile("^1[34578]\\d{9}$", 2).matcher(paramString).matches();
  }
  
  public static boolean isPasswordContainSpace(String paramString)
  {
    return paramString.contains(" ");
  }
  
  public static boolean isPasswordLengthLessThanNightAndAllDigital(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() <= 9) && (Pattern.compile("[0-9]*").matcher(paramString).matches());
  }
  
  public static boolean isPasswordTooLong(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() > 16);
  }
  
  public static boolean isPasswordTooShort(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() < 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUtil
 * JD-Core Version:    0.7.0.1
 */