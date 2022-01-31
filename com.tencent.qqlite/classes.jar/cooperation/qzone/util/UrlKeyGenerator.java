package cooperation.qzone.util;

import android.text.TextUtils;
import android.webkit.URLUtil;
import fly;
import flz;

public abstract class UrlKeyGenerator
{
  private static UrlKeyGenerator jdField_a_of_type_CooperationQzoneUtilUrlKeyGenerator;
  private static final String jdField_a_of_type_JavaLangString = "http://";
  private static UrlKeyGenerator jdField_b_of_type_CooperationQzoneUtilUrlKeyGenerator;
  private static final String jdField_b_of_type_JavaLangString = "https://";
  
  public static UrlKeyGenerator a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new fly();
      }
      return a;
    }
    finally {}
  }
  
  public static UrlKeyGenerator b()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new flz();
      }
      return b;
    }
    finally {}
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.util.UrlKeyGenerator
 * JD-Core Version:    0.7.0.1
 */