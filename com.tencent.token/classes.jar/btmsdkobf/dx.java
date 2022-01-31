package btmsdkobf;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import tmsdk.common.tcc.b;

public class dx
{
  private static String TAG = "CryptorUtils";
  
  public static String E(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = b.encrypt(paramString.getBytes("gbk"), null);
      if (paramString != null)
      {
        paramString = dw.encodeToString(paramString, 0);
        return paramString;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      eh.h(TAG, "getEncodeString, UnsupportedEncodingException: " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        eh.h(TAG, "getEncodeString, Exception: " + paramString);
      }
    }
  }
  
  public static String F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = b.decrypt(dw.decode(paramString, 0), null);
      if (paramString != null)
      {
        paramString = new String(paramString, "gbk");
        return paramString;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      eh.h(TAG, "getDecodeString, UnsupportedEncodingException: " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        eh.h(TAG, "getDecodeString, Exception: " + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dx
 * JD-Core Version:    0.7.0.1
 */