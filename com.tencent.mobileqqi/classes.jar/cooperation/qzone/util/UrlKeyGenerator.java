package cooperation.qzone.util;

import android.text.TextUtils;
import android.webkit.URLUtil;
import idh;

public abstract class UrlKeyGenerator
{
  public static final UrlKeyGenerator a = new idh();
  private static final String a = "http://";
  private static final String b = "https://";
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!URLUtil.isNetworkUrl(paramString)) {
      return paramString;
    }
    return b(paramString);
  }
  
  public abstract String b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.util.UrlKeyGenerator
 * JD-Core Version:    0.7.0.1
 */