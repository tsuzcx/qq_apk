package com.tencent.common.config;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class AppSetting
{
  private static String A;
  public static int a = 537057609;
  public static final String a = "6600";
  public static final boolean a = true;
  public static int b = 0;
  public static final String b = "130";
  public static final boolean b = false;
  public static int c = 0;
  public static final String c = "FD0A68FFFF59A54A";
  public static boolean c = false;
  public static int d = 0;
  public static final String d = "25030";
  public static boolean d = false;
  public static final String e = "AQQ_2013 4.6";
  public static final boolean e = true;
  public static final String f = "2013";
  public static boolean f = false;
  public static final String g = "6.0.1";
  public static boolean g = false;
  public static final String h = "QQ/5.0";
  public static boolean h = false;
  public static final String i = "V 6.0.1.6600";
  public static final boolean i = true;
  public static final String j = "6.0.1.6600";
  public static boolean j = false;
  public static final String k = "6.0.1.6600.2018-09-26.r25030.YingYongBao";
  public static boolean k = false;
  public static final String l = "2013 6.0.1";
  public static final boolean l = true;
  public static final String m = "2013 6.0.16600";
  public static boolean m = false;
  public static String n;
  public static boolean n = false;
  public static String o;
  public static boolean o = false;
  public static final String p = "enable_ptt_roam";
  public static final String q = "c2c_del_msg_oper_enable";
  private static final String r = "NA_0";
  private static final String s = "000000";
  private static final String t = "ADR";
  private static final String u = "18";
  private static final String v;
  private static final String w = "V3";
  private static String x;
  private static String y;
  private static String z;
  
  static
  {
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    v = Build.VERSION.RELEASE;
    x = null;
    f = false;
    g = true;
    h = true;
    j = false;
    z = "N";
    jdField_n_of_type_JavaLangString = "false";
    jdField_d_of_type_Int = 1048576;
    k = true;
    jdField_o_of_type_JavaLangString = "use_msg_reflesh_delay";
    m = true;
    jdField_n_of_type_Boolean = true;
    jdField_o_of_type_Boolean = true;
  }
  
  public static final String a()
  {
    return "FD0A68FFFF59A54A";
  }
  
  public static String a(Context paramContext)
  {
    if (x == null) {}
    try
    {
      Object localObject = paramContext.getFilesDir().getAbsolutePath();
      if (new File((String)localObject).exists())
      {
        localObject = new File((String)localObject + "/channel2.ini");
        if (((File)localObject).exists())
        {
          paramContext = new FileInputStream((File)localObject);
          localObject = a(paramContext);
          paramContext.close();
          if (localObject != null)
          {
            paramContext = ((String)localObject).trim();
            if (paramContext.length() > 8) {
              x = paramContext.substring(8);
            }
          }
          return x;
        }
        localObject = new FileOutputStream((File)localObject);
        paramContext = paramContext.getAssets().open("channel.ini");
        String str = a(paramContext);
        paramContext.close();
        if (str != null)
        {
          paramContext = str.trim();
          ((OutputStream)localObject).write(paramContext.getBytes());
          if (paramContext.length() > 8) {
            x = paramContext.substring(8);
          }
        }
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        return x;
      }
      paramContext = paramContext.getAssets().open("channel.ini");
      localObject = a(paramContext);
      paramContext.close();
      if (localObject != null)
      {
        paramContext = ((String)localObject).trim();
        if (paramContext.length() > 8) {
          x = paramContext.substring(8);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppSetting", 2, "read channel failed: " + paramContext.toString());
        }
        x = "0";
      }
    }
    return x;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localStringBuffer.append(((Time)localObject).format("%Y-%m-%d %H:%M:%S") + "|");
    localStringBuffer.append("mobileQQ|");
    try
    {
      localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      localStringBuffer.append((String)localObject + "|");
      localStringBuffer.append(a(paramContext) + "|");
      localStringBuffer.append("|");
      localStringBuffer.append("|");
      localStringBuffer.append("|");
      localStringBuffer.append("|");
      paramContext = paramString;
      if (paramString == null) {
        paramContext = "";
      }
      localStringBuffer.append(paramContext + "|");
      localStringBuffer.append(a + "|");
      localStringBuffer.append(z);
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str = "";
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i1));
    }
    return localStringBuffer.toString();
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext.getResources().getDisplayMetrics().widthPixels;
    jdField_c_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      int i1 = b;
      b = jdField_c_of_type_Int;
      jdField_c_of_type_Int = i1;
    }
    A = "" + b / 16 + jdField_c_of_type_Int / 16;
  }
  
  public static final String b()
  {
    if (y != null) {
      return y;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label299;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < localObject2.length)
      {
        if ((localObject2[i1] > ' ') && (localObject2[i1] != '/') && (localObject2[i1] != '_') && (localObject2[i1] != '&') && (localObject2[i1] != '|') && (localObject2[i1] != '-')) {
          localStringBuffer.append(localObject2[i1]);
        }
        i1 += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      y = "AQQ_2013 4.6/2013 6.0.16600&NA_0/000000&ADR&" + A + "18" + "&" + (String)localObject2 + "&" + x + "&" + "FD0A68FFFF59A54A" + "&" + v + "&" + "V3";
      return y;
      label299:
      str2 = "ALL";
    }
  }
  
  public static String c()
  {
    return "2013 6.0.1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */