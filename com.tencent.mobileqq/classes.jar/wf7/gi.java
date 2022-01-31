package wf7;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class gi
{
  private static String TAG = "CryptorUtils";
  
  public static byte[] F(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = a(paramString[k]);
      arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramContext = hb.e(paramString.getBytes("gbk"), null);
      if (paramContext != null)
      {
        paramContext = de.encodeToString(paramContext, 0);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      label33:
      break label33;
    }
  }
  
  public static String c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramContext = hb.f(de.decode(paramString, 0), null);
      if (paramContext != null)
      {
        paramContext = new String(paramContext, "gbk");
        return paramContext;
      }
    }
    catch (UnsupportedEncodingException paramContext)
    {
      return null;
    }
    catch (Exception paramContext)
    {
      label37:
      break label37;
    }
  }
  
  public static final String k(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gi
 * JD-Core Version:    0.7.0.1
 */