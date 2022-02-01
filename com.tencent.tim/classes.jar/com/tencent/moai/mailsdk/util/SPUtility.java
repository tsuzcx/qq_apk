package com.tencent.moai.mailsdk.util;

public class SPUtility
{
  private static final String SMTP_LOGIN_ERROR = "smtp_login_error";
  private static final String TAG = "SPUtility";
  private static final String UNSUPPORT_SEARCH_LATEST = "unsupport_search_latest";
  private static SPDelegate spDelegate = null;
  
  public static String getSmtpLoginError()
  {
    return getValue("smtp_login_error");
  }
  
  public static String getUnSupportSearchLatest()
  {
    return getValue("unsupport_search_latest");
  }
  
  private static String getValue(String paramString)
  {
    if (spDelegate != null) {
      return spDelegate.getValue(paramString);
    }
    return "";
  }
  
  public static void removeSmtpLoginError(String paramString)
  {
    String str2 = getSmtpLoginError();
    String str1 = str2;
    if (str2.contains(paramString)) {
      str1 = str2.replace(paramString + ";", "");
    }
    saveValue("smtp_login_error", str1);
  }
  
  private static void saveValue(String paramString1, String paramString2)
  {
    if (spDelegate != null) {
      spDelegate.saveValue(paramString1, paramString2);
    }
  }
  
  public static void setSmtpLoginError(String paramString)
  {
    String str = getValue("smtp_login_error");
    if (!str.contains(paramString)) {
      saveValue("smtp_login_error", str + paramString + ";");
    }
  }
  
  public static void setSpDelegate(SPDelegate paramSPDelegate)
  {
    if (paramSPDelegate != null) {
      spDelegate = paramSPDelegate;
    }
  }
  
  public static void setUnSupportSearchLatest(String paramString)
  {
    String str;
    String[] arrayOfString;
    int j;
    int i;
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      paramString = StringUtility.getDomain(paramString);
      str = getValue("unsupport_search_latest");
      arrayOfString = str.split(";");
      j = arrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return;
      }
      i += 1;
    }
    saveValue("unsupport_search_latest", str + paramString + ";");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.SPUtility
 * JD-Core Version:    0.7.0.1
 */