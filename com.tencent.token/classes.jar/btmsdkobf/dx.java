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
    StringBuilder localStringBuilder;
    String str;
    try
    {
      paramString = b.encrypt(paramString.getBytes("gbk"), null);
      if (paramString == null) {
        break label87;
      }
      paramString = dw.encodeToString(paramString, 0);
      return paramString;
    }
    catch (Exception localException)
    {
      paramString = TAG;
      localStringBuilder = new StringBuilder();
      str = "getEncodeString, Exception: ";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramString = TAG;
      localStringBuilder = new StringBuilder();
      str = "getEncodeString, UnsupportedEncodingException: ";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(localUnsupportedEncodingException);
    eh.h(paramString, localStringBuilder.toString());
    label87:
    return null;
  }
  
  public static String F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder;
    String str;
    try
    {
      paramString = b.decrypt(dw.decode(paramString, 0), null);
      if (paramString == null) {
        break label91;
      }
      paramString = new String(paramString, "gbk");
      return paramString;
    }
    catch (Exception localException)
    {
      paramString = TAG;
      localStringBuilder = new StringBuilder();
      str = "getDecodeString, Exception: ";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramString = TAG;
      localStringBuilder = new StringBuilder();
      str = "getDecodeString, UnsupportedEncodingException: ";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(localUnsupportedEncodingException);
    eh.h(paramString, localStringBuilder.toString());
    label91:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dx
 * JD-Core Version:    0.7.0.1
 */