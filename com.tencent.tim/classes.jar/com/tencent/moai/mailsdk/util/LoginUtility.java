package com.tencent.moai.mailsdk.util;

public class LoginUtility
{
  public static final int LOGIN_ACCOUNT_LOCK_ERROR = 4;
  private static final String[] LOGIN_ACCOUNT_LOCK_ERROR_STRING;
  public static final int LOGIN_CONNECT_ERROR = 3;
  private static final String[] LOGIN_CONNECT_ERROR_STRING;
  public static final int LOGIN_OTHER_ERROR = 7;
  private static final String[] LOGIN_OTHER_ERROR_STRING = { "unknow error" };
  public static final int LOGIN_SUSPEND_ERROR = 2;
  private static final String[] LOGIN_SUSPEND_ERROR_STRING;
  public static final int LOGIN_TWO_STEP_ERROR = 5;
  private static final String[] LOGIN_TWO_STEP_ERROR_STRING;
  public static final int LOGIN_UNKNOWN_ERROR = 0;
  public static final int LOGIN_UNSAFE_ERROR = 6;
  private static final String[] LOGIN_UNSAFE_ERROR_STRING;
  public static final int LOGIN_USER_ERROR = 1;
  private static final String[] LOGIN_USER_ERROR_STRING = { "password error", "user not found", "user not exist", "account not exist", "invalid username", "invalid login user", "invalid login or pass", "incorrect username", "unknown user name", "bad username or password", "user name or password is wrong", "user name or password error", "bad pass", "[authenticationfailed] authentication failed", "login failure", "err.login.passerr", "expired" };
  private static final String[] LOGIN_USER_ERROR_STRING_EQUAL = { "no login login error" };
  
  static
  {
    LOGIN_TWO_STEP_ERROR_STRING = new String[] { "account is blocked. login to your account via a web browser to verify your identity", "(#mbr1240) please verify your account", "application-specific" };
    LOGIN_SUSPEND_ERROR_STRING = new String[] { "suspended", "nosupport", "not enabled", "custom imap off", "error=\"userdisabled\" authresult=27", "no imap is disabled", "pop3 is disabled", "please enable mail protocol first" };
    LOGIN_CONNECT_ERROR_STRING = new String[] { "response null", "read response error", "init socket error", "internal", "service temporarily unavailable", "too many simultaneous connection", "system busy", "too many connection", "service busy" };
    LOGIN_ACCOUNT_LOCK_ERROR_STRING = new String[] { "unable to lock maildrop", "maildrop opened for exclusive access by another user", "登录太频繁", "auth limit" };
    LOGIN_UNSAFE_ERROR_STRING = new String[] { "cleartext logins disabled", "command received in invalid state", "starttls required", "cleartext logins disabled" };
  }
  
  public static int getProtocolLoginError(String paramString)
  {
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      if (isContains(paramString, LOGIN_SUSPEND_ERROR_STRING)) {
        return 2;
      }
      if ((isContains(paramString, LOGIN_USER_ERROR_STRING)) || (isEqual(paramString, LOGIN_USER_ERROR_STRING_EQUAL))) {
        return 1;
      }
      if (isContains(paramString, LOGIN_CONNECT_ERROR_STRING)) {
        return 3;
      }
      if (isContains(paramString, LOGIN_ACCOUNT_LOCK_ERROR_STRING)) {
        return 4;
      }
      if (isContains(paramString, LOGIN_TWO_STEP_ERROR_STRING)) {
        return 5;
      }
      if (isContains(paramString, LOGIN_UNSAFE_ERROR_STRING)) {
        return 6;
      }
      if (isContains(paramString, LOGIN_OTHER_ERROR_STRING)) {
        return 7;
      }
    }
    return 0;
  }
  
  private static boolean isContains(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.contains(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean isEqual(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    int j;
    if (!paramString.startsWith("A"))
    {
      bool1 = bool2;
      if (!paramString.startsWith("a")) {}
    }
    else
    {
      i = paramString.indexOf(" ");
      bool1 = bool2;
      if (i != -1)
      {
        paramString = paramString.substring(i + 1);
        bool1 = bool2;
        if (!StringUtility.isNullOrEmpty(paramString))
        {
          j = paramArrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isProtocolLoginError(int paramInt)
  {
    return (paramInt == 200004) || (paramInt == 200005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.LoginUtility
 * JD-Core Version:    0.7.0.1
 */