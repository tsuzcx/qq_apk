package com.tencent.beacon.base.net.b;

import android.text.TextUtils;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.base.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static String a = "https://otheve.beacon.qq.com/analytics/v2_upload";
  public static String b = "https://othstr.beacon.qq.com/analytics/v2_upload";
  public static String c = "oth.eve.mdt.qq.com";
  public static String d = "oth.str.mdt.qq.com";
  private static boolean e;
  
  public static String a(String paramString)
  {
    String str1;
    if ((paramString == null) || ("".equals(paramString)))
    {
      str1 = "";
      return str1;
    }
    if (paramString.contains("https")) {}
    for (String str2 = "https://";; str2 = "http://")
    {
      int i = paramString.indexOf(str2);
      str1 = paramString;
      if (i == -1) {
        break;
      }
      int j = paramString.indexOf("/", str2.length());
      str1 = paramString.substring(str2.length() + i, j);
      i = str1.indexOf(":");
      paramString = str1;
      if (i != -1) {
        paramString = str1.substring(0, i);
      }
      return paramString;
    }
  }
  
  public static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return c;
    }
    return a;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      d = paramString1;
      b = b.replace("othstr.beacon.qq.com", paramString1);
      e = true;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      c = paramString2;
      a = a.replace("otheve.beacon.qq.com", paramString2);
      e = true;
    }
  }
  
  public static String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return d;
    }
    return b;
  }
  
  public static void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (e)) {
      return;
    }
    c = paramString;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
    Matcher localMatcher = ((Pattern)localObject).matcher(paramString1);
    localObject = ((Pattern)localObject).matcher(paramString2);
    if ((!localMatcher.matches()) || (!((Matcher)localObject).matches()))
    {
      e.a("[event url] set report ip is not valid IP address!");
      return;
    }
    d = paramString1;
    b = b.replace("othstr.beacon.qq.com", paramString1);
    c = paramString2;
    a = a.replace("otheve.beacon.qq.com", paramString2);
    c.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", new Object[] { d, b, c, a });
  }
  
  public static void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (e)) {
      return;
    }
    a = paramString;
  }
  
  public static void d(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (e)) {
      return;
    }
    d = paramString;
  }
  
  public static void e(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (e)) {
      return;
    }
    b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.b
 * JD-Core Version:    0.7.0.1
 */