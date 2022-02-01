package btmsdkobf;

import android.text.TextUtils;
import com.tencent.token.auo;
import java.io.UnsupportedEncodingException;

public class dx
{
  private static String TAG = "CryptorUtils";
  
  public static String E(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str;
    try
    {
      paramString = auo.a(paramString.getBytes("gbk"), null);
      if (paramString == null) {
        break label63;
      }
      paramString = dw.encodeToString(paramString, 0);
      return paramString;
    }
    catch (Exception localException)
    {
      paramString = TAG;
      str = "getEncodeString, Exception: ";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramString = TAG;
      str = "getEncodeString, UnsupportedEncodingException: ";
    }
    eh.h(paramString, str.concat(String.valueOf(localUnsupportedEncodingException)));
    label63:
    return null;
  }
  
  public static String F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str;
    try
    {
      paramString = auo.b(dw.decode(paramString, 0), null);
      if (paramString == null) {
        break label67;
      }
      paramString = new String(paramString, "gbk");
      return paramString;
    }
    catch (Exception localException)
    {
      paramString = TAG;
      str = "getDecodeString, Exception: ";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramString = TAG;
      str = "getDecodeString, UnsupportedEncodingException: ";
    }
    eh.h(paramString, str.concat(String.valueOf(localUnsupportedEncodingException)));
    label67:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dx
 * JD-Core Version:    0.7.0.1
 */