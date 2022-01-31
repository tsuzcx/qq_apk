package com.tencent.open.base;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public class APNUtil
{
  public static final int a = 1;
  protected static Uri a;
  protected static final String a;
  public static final int b = 2;
  public static final String b = "wifi";
  public static final int c = 4;
  public static final String c = "cmwap";
  public static final int d = 8;
  public static final String d = "cmnet";
  public static final int e = 16;
  public static final String e = "uniwap";
  public static final int f = 32;
  public static final String f = "uninet";
  public static final int g = 64;
  public static final String g = "wap";
  public static final int h = 128;
  public static final String h = "net";
  public static final int i = 256;
  public static final String i = "ctwap";
  public static final int j = 512;
  public static final String j = "ctnet";
  public static final int k = 1024;
  public static final String k = "none";
  public static final int l = 2048;
  public static final String l = "3gnet";
  public static final String m = "3gwap";
  public static final String n = "unconnect";
  public static final String o = "unknown";
  public static final String p = "wifi";
  public static final String q = "2g";
  public static final String r = "3g";
  public static final String s = "4g";
  public static final String t = "apn";
  public static final String u = "proxy";
  public static final String v = "port";
  
  static
  {
    jdField_a_of_type_JavaLangString = APNUtil.class.getName();
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
    int i1;
    if (paramContext == null) {
      i1 = -1;
    }
    int i2;
    do
    {
      return i1;
      paramContext.moveToFirst();
      if (paramContext.isAfterLast())
      {
        if (paramContext != null) {
          paramContext.close();
        }
        return -1;
      }
      i2 = paramContext.getInt(paramContext.getColumnIndex("port"));
      i1 = i2;
    } while (paramContext == null);
    paramContext.close();
    return i2;
  }
  
  public static String a(Context paramContext)
  {
    int i1 = b(paramContext);
    if (i1 == 2) {
      paramContext = "wifi";
    }
    String str;
    do
    {
      return paramContext;
      if (i1 == 1) {
        return "cmwap";
      }
      if (i1 == 4) {
        return "cmnet";
      }
      if (i1 == 16) {
        return "uniwap";
      }
      if (i1 == 8) {
        return "uninet";
      }
      if (i1 == 64) {
        return "wap";
      }
      if (i1 == 32) {
        return "net";
      }
      if (i1 == 512) {
        return "ctwap";
      }
      if (i1 == 256) {
        return "ctnet";
      }
      if (i1 == 2048) {
        return "3gnet";
      }
      if (i1 == 1024) {
        return "3gwap";
      }
      str = b(paramContext);
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (str.length() != 0);
    return "none";
  }
  
  public static boolean a(Context paramContext)
  {
    int i1 = b(paramContext);
    return (i1 == 1) || (i1 == 16) || (i1 == 64) || (i1 == 512) || (i1 == 1024);
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return 128;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 128;
      }
      if (((NetworkInfo)localObject).getTypeName().toUpperCase().equals("WIFI")) {
        return 2;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      if (((String)localObject).startsWith("cmwap")) {
        return 1;
      }
      if ((((String)localObject).startsWith("cmnet")) || (((String)localObject).startsWith("epc.tmobile.com"))) {
        break label232;
      }
      if (((String)localObject).startsWith("uniwap")) {
        return 16;
      }
      if (((String)localObject).startsWith("uninet")) {
        return 8;
      }
      if (((String)localObject).startsWith("wap")) {
        return 64;
      }
      if (((String)localObject).startsWith("net")) {
        return 32;
      }
      if (((String)localObject).startsWith("ctwap")) {
        return 512;
      }
      if (((String)localObject).startsWith("ctnet")) {
        return 256;
      }
      if (((String)localObject).startsWith("3gwap")) {
        return 1024;
      }
      if (((String)localObject).startsWith("3gnet")) {
        return 2048;
      }
      if (((String)localObject).startsWith("#777"))
      {
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          int i1 = paramContext.length();
          if (i1 > 0) {
            return 512;
          }
        }
        return 256;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 128;
    label232:
    return 4;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
      if (localCursor == null) {
        return null;
      }
      localCursor.moveToFirst();
      if (localCursor.isAfterLast())
      {
        if (localCursor == null) {
          break label89;
        }
        localCursor.close();
        break label89;
      }
      String str = localCursor.getString(localCursor.getColumnIndex("apn"));
      paramContext = str;
      if (localCursor != null)
      {
        localCursor.close();
        return str;
      }
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "";
    }
    return paramContext;
    label89:
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static String c(Context paramContext)
  {
    String str = null;
    Cursor localCursor = paramContext.getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
    if (localCursor == null) {
      paramContext = str;
    }
    do
    {
      do
      {
        return paramContext;
        localCursor.moveToFirst();
        if (!localCursor.isAfterLast()) {
          break;
        }
        paramContext = str;
      } while (localCursor == null);
      localCursor.close();
      return null;
      str = localCursor.getString(localCursor.getColumnIndex("proxy"));
      paramContext = str;
    } while (localCursor == null);
    localCursor.close();
    return str;
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = null;
    Cursor localCursor = paramContext.getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
    if (localCursor == null) {}
    do
    {
      return localObject;
      localCursor.moveToFirst();
      if (localCursor.isAfterLast())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        return "80";
      }
      localObject = localCursor.getString(localCursor.getColumnIndex("port"));
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "80";
      }
      localObject = paramContext;
    } while (localCursor == null);
    localCursor.close();
    return paramContext;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1;
    if (paramContext == null) {
      bool1 = true;
    }
    do
    {
      return bool1;
      paramContext = paramContext.getAllNetworkInfo();
      bool1 = bool2;
    } while (paramContext == null);
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= paramContext.length) {
        break;
      }
      if (paramContext[i1].isConnectedOrConnecting()) {
        return true;
      }
      i1 += 1;
    }
  }
  
  public static String e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "MOBILE";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.getTypeName();
    }
    return "MOBILE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.APNUtil
 * JD-Core Version:    0.7.0.1
 */