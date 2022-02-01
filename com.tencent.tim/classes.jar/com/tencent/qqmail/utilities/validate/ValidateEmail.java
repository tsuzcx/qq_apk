package com.tencent.qqmail.utilities.validate;

import java.util.regex.Pattern;

public final class ValidateEmail
{
  public static final int EMAIL_ERR_ILLEGAL = 4;
  public static final int EMAIL_ERR_NONE = 0;
  public static final int EMAIL_ERR_SPACE = 3;
  public static final int EMAIL_ERR_TOO_LONG = 2;
  public static final int EMAIL_ERR_TOO_SHORT = 1;
  
  public static String composeMailValidateAddr(String paramString)
    throws ValidateEmail.EmailException
  {
    int i = 0;
    if (paramString.matches("[1-9][0-9]{4,}"))
    {
      localObject = paramString + "@qq.com";
      return localObject;
    }
    if (paramString.matches(".*[^\\p{ASCII}]+.*")) {
      throw new EmailException(paramString);
    }
    Object localObject = paramString.split("@");
    if (localObject.length == 2)
    {
      if (localObject[0].matches("([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)\\.?(([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)\\.?)*"))
      {
        if (paramString.matches("(?i)([0].*|[0-9]{1,4})(@qq.com|@vip.qq.com)")) {
          throw new EmailException(paramString);
        }
        String[] arrayOfString = localObject[1].split("\\.");
        if ((arrayOfString == null) || (arrayOfString.length < 2)) {
          throw new EmailException(paramString);
        }
        do
        {
          i += 1;
          localObject = paramString;
          if (i >= arrayOfString.length) {
            break;
          }
        } while (arrayOfString[i].matches("([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)"));
        throw new EmailException(paramString);
      }
      throw new EmailException(paramString);
    }
    throw new EmailException(paramString);
  }
  
  public static boolean isEmailValidate(String paramString)
  {
    return paramString.matches("^(?:.*?<)?[-A-Za-z\\d.+_=]+@[-A-Za-z\\d._]+\\.[-A-Za-z\\d._]+>?$");
  }
  
  public static boolean isMailAddressVerified(String paramString)
  {
    if (paramString.matches("[1-9][0-9]{4,}")) {}
    for (;;)
    {
      return true;
      if (paramString.matches(".*[^\\p{ASCII}]+.*")) {
        return false;
      }
      String[] arrayOfString = paramString.split("@");
      if (arrayOfString.length != 2) {
        return false;
      }
      if (!arrayOfString[0].matches("([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)\\.?(([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)\\.?)*")) {
        return false;
      }
      if (paramString.matches("(?i)([0].*|[0-9]{1,4})(@qq.com|@vip.qq.com)")) {
        return false;
      }
      paramString = arrayOfString[1].split("\\.");
      if ((paramString == null) || (paramString.length < 2)) {
        return false;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        if (!paramString[i].matches("([^\\s\\(\\)><@,;:\\\\\"\\.\\[\\]]+)")) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean loginQQEmailAliasVerify(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return true;
    }
    return Pattern.matches("[0-9a-z-_.@]*", paramString);
  }
  
  public static String looseFormatEmail(String paramString)
    throws ValidateEmail.EmailException
  {
    Object localObject = paramString.split("@");
    String str;
    if (localObject.length == 1) {
      str = paramString + "@qq.com";
    }
    while (!Pattern.matches("([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)", str))
    {
      throw new EmailException(paramString);
      if (localObject.length > 1)
      {
        str = localObject[0];
        localObject = localObject[1];
        if ((str.length() == 0) || (((String)localObject).length() == 0)) {
          throw new EmailException(paramString);
        }
        str = str + "@" + (String)localObject;
      }
      else
      {
        throw new EmailException(paramString);
      }
    }
    return str;
  }
  
  public static String manipulateMailAddress(String paramString)
  {
    String str = paramString;
    if (paramString.matches("[1-9][0-9]{4,}")) {
      str = paramString + "@qq.com";
    }
    return str;
  }
  
  public static int verfifyQQEmailDomainType(String paramString)
  {
    int k = 0;
    int j = k;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        j = 4;
      }
    }
    else {
      return j;
    }
    if (paramString.charAt(0) == ' ') {
      return 3;
    }
    paramString = ("#" + paramString).trim().substring(1);
    int i = 0;
    for (;;)
    {
      j = k;
      if (i >= paramString.length()) {
        break;
      }
      j = paramString.charAt(i);
      if (j == 32) {
        return 3;
      }
      if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && ((j < 48) || (j > 57)) && (j != 95) && (j != 45) && (j != 46)) {
        return 4;
      }
      i += 1;
    }
  }
  
  public static int verifyProtocolMailFormat(String paramString)
  {
    int n = 4;
    int m = 0;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      int k;
      if (paramString.contains(" ")) {
        k = 3;
      }
      do
      {
        return k;
        k = n;
      } while (!paramString.contains("@"));
      String str = paramString.substring(paramString.lastIndexOf('@') + 1, paramString.length());
      if ((str != null) && (str.isEmpty())) {}
      for (int i = 4;; i = 0)
      {
        int j = 0;
        k = m;
        while (k < paramString.length())
        {
          m = j;
          if (paramString.charAt(k) == '@') {
            m = j + 1;
          }
          k += 1;
          j = m;
        }
        k = n;
        if (j > 1) {
          break;
        }
        return i;
      }
    }
    return 0;
  }
  
  public static int verifyQQEmailAliasLengthType(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      int i = paramString.lastIndexOf("@");
      if (i > 0)
      {
        if (paramString.substring(0, i).length() <= 18) {}
      }
      else {
        do
        {
          return 2;
          if (paramString.length() < 3) {
            return 1;
          }
        } while (paramString.length() > 18);
      }
    }
    return 0;
  }
  
  public static int verifyQQEmailAliasType(String paramString)
  {
    int k = 0;
    int j = k;
    int i;
    if (paramString != null)
    {
      j = k;
      if (!paramString.isEmpty()) {
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      if (i < paramString.length())
      {
        j = paramString.charAt(i);
        if (j == 32) {
          j = 3;
        }
      }
      else
      {
        return j;
      }
      if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && ((j < 48) || (j > 57)) && (j != 95) && (j != 45) && (j != 46)) {
        return 4;
      }
      i += 1;
    }
  }
  
  public static int verifyQQMailFormat(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isEmpty())
      {
        i = paramString.lastIndexOf("@");
        if (i < 0) {
          break label63;
        }
        String str = paramString.substring(0, i);
        paramString = paramString.substring(i + 1, paramString.length());
        i = verifyQQEmailAliasType(str);
        if (i == 0) {
          break label58;
        }
      }
    }
    return i;
    label58:
    return verfifyQQEmailDomainType(paramString);
    label63:
    return verifyQQEmailAliasType(paramString);
  }
  
  public static class EmailException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public EmailException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.validate.ValidateEmail
 * JD-Core Version:    0.7.0.1
 */