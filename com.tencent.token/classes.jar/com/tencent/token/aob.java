package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public final class aob
{
  public static String a()
  {
    if (!rp.a().b()) {
      return "UNKNOWN";
    }
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        paramContext = paramContext.getDeviceId();
      } else {
        paramContext = null;
      }
    }
    catch (Throwable paramContext)
    {
      label27:
      Object localObject;
      break label27;
    }
    paramContext = "00000000000001";
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    return localObject;
  }
  
  public static String b()
  {
    if (!rp.a().b()) {
      return null;
    }
    label280:
    String str;
    for (;;)
    {
      try
      {
        Object localObject = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
        if (((String)localObject).contains("huawei"))
        {
          bi.a();
          return "";
        }
        if (((String)localObject).contains("xiaomi"))
        {
          bi.a();
          return "";
        }
        if (((String)localObject).contains("gionee"))
        {
          bi.a();
          if (TextUtils.isEmpty(""))
          {
            bi.a();
            return "";
          }
        }
        else
        {
          if (((String)localObject).contains("vivo"))
          {
            bi.a();
            bi.a();
            if ((!TextUtils.isEmpty("")) && (!TextUtils.isEmpty("")))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append("_");
              ((StringBuilder)localObject).append("");
              return ((StringBuilder)localObject).toString();
            }
            bi.a();
            return "";
          }
          if (((String)localObject).contains("meizu"))
          {
            bi.a();
            return "";
          }
          if (((String)localObject).contains("lenovo"))
          {
            bi.a();
            if (TextUtils.isEmpty("")) {
              break label287;
            }
            localObject = "".split("_");
            if (localObject == null) {
              break label287;
            }
            if (localObject.length > 0) {
              break label280;
            }
            break label287;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            bi.a();
            return "";
          }
          if (((String)localObject).contains("letv"))
          {
            bi.a();
            return "";
          }
          if (((String)localObject).contains("oppo"))
          {
            bi.a();
            return "";
          }
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      return "";
      str = localThrowable[0];
      continue;
      label287:
      str = null;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aob
 * JD-Core Version:    0.7.0.1
 */