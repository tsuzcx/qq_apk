package com.tencent.manager.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;

public class b
{
  public static long a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramBundle.getString("roomid"));
      return l;
    }
    catch (NumberFormatException paramBundle) {}
    return 0L;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("&");
    int i = 0;
    if (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {}
      while (!"vid".equals(arrayOfString[0]))
      {
        i += 1;
        break;
      }
      return arrayOfString[1];
    }
    return "";
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    String str;
    do
    {
      return paramBundle;
      str = paramBundle.getString("roomtype");
      paramBundle = str;
    } while (!TextUtils.isEmpty(str));
    return "0";
  }
  
  public static String c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("is_record", "");
  }
  
  public static boolean d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return true;
    }
    return paramBundle.getString("enter_record_if_finish", "1").equals("1");
  }
  
  public static String e(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("startsrc", "");
  }
  
  public static int f(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 2;
    }
    return paramBundle.getInt("first");
  }
  
  public static String g(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("fromid", "");
  }
  
  public static String h(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("listname", "");
  }
  
  public static String i(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64.decode(paramBundle.getString("nowapp_ext", ""), 0));
  }
  
  public static String j(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64.decode(paramBundle.getString("nowplugin_ext", ""), 0));
  }
  
  public static String k(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64.decode(paramBundle.getString("h5_ext", ""), 0));
  }
  
  public static String l(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("url", "");
    }
    return "";
  }
  
  public static int m(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("hostloading_percent", 0);
    }
    return i;
  }
  
  public static boolean n(Bundle paramBundle)
  {
    return b(paramBundle).equals("10001");
  }
  
  public static boolean o(Bundle paramBundle)
  {
    return b(paramBundle).equals("9001");
  }
  
  public static String p(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("cover_file", "");
    }
    return "";
  }
  
  public static String q(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("coverurl", "");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.b
 * JD-Core Version:    0.7.0.1
 */