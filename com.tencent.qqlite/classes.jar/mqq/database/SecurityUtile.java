package mqq.database;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

class SecurityUtile
{
  private static char[] codeKey = { 0, 1, 0, 1 };
  private static int codeKeyLen = 0;
  
  public static String decode(String paramString)
  {
    return xor(paramString);
  }
  
  public static String encode(String paramString)
  {
    return xor(paramString);
  }
  
  public static void setKey(Context paramContext)
  {
    localObject2 = null;
    localObject1 = null;
    if (0 != 0) {
      throw new NullPointerException();
    }
    try
    {
      String str = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
      if (str != null)
      {
        localObject1 = str;
        localObject2 = str;
        if (str.length() >= codeKey.length) {}
      }
      else
      {
        localObject2 = str;
        localObject1 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      paramContext = (Context)localObject1;
      if (((String)localObject1).length() >= codeKey.length) {}
    }
    else
    {
      paramContext = "361910168";
    }
    codeKey = paramContext.toCharArray();
    codeKeyLen = codeKey.length;
  }
  
  private static String xor(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toCharArray();
    char[] arrayOfChar = new char[paramString.length];
    if (codeKeyLen >= paramString.length)
    {
      i = 0;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ codeKey[i]));
        i += 1;
      }
    }
    int i = 0;
    while (i < paramString.length)
    {
      arrayOfChar[i] = ((char)(paramString[i] ^ codeKey[(i % codeKeyLen)]));
      i += 1;
    }
    if (arrayOfChar.length == 0) {
      return "";
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.database.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */