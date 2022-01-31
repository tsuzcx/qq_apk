package com.tencent.open.business.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class MobileInfoUtil
{
  protected static String a;
  protected static String b;
  protected static String c;
  protected static String d;
  protected static String e;
  protected static final String f = "appcenter_mobileinfo";
  public static final String g = "wifi_mac_address";
  public static final String h = "imei";
  public static final String i = "imei";
  
  public static String a()
  {
    if (TextUtils.isEmpty(a)) {
      a = "";
    }
    try
    {
      Object localObject1 = CommonDataAdapter.a().a();
      if (localObject1 != null)
      {
        a = ((Context)localObject1).getSharedPreferences("appcenter_mobileinfo", 0).getString("wifi_mac_address", "");
        if (TextUtils.isEmpty(a))
        {
          Object localObject2 = (WifiManager)((Context)localObject1).getSystemService("wifi");
          if (localObject2 != null)
          {
            localObject2 = ((WifiManager)localObject2).getConnectionInfo();
            if (localObject2 != null)
            {
              a = ((WifiInfo)localObject2).getMacAddress();
              if (a != null)
              {
                localObject1 = ((Context)localObject1).getSharedPreferences("appcenter_mobileinfo", 0).edit();
                ((SharedPreferences.Editor)localObject1).putString("wifi_mac_address", a);
                ((SharedPreferences.Editor)localObject1).commit();
              }
            }
          }
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localSecurityException.printStackTrace();
      }
    }
    return a;
  }
  
  public static String b()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(c))
    {
      c = "";
      Object localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        c = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 0).getString("imei", "");
        if (TextUtils.isEmpty(c))
        {
          c = ((TelephonyManager)((Context)localObject).getSystemService("phone")).getDeviceId();
          if (c != null)
          {
            localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("imei", c);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
    }
    return c;
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(d))
    {
      d = "";
      Object localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        d = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 0).getString("imei", "");
        if (TextUtils.isEmpty(d))
        {
          d = ((TelephonyManager)((Context)localObject).getSystemService("phone")).getDeviceId();
          if (d != null)
          {
            localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("imei", d);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
    }
    return c;
  }
  
  public static String e()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    WindowManager localWindowManager = (WindowManager)CommonDataAdapter.a().a().getSystemService("window");
    int j = localWindowManager.getDefaultDisplay().getWidth();
    int k = localWindowManager.getDefaultDisplay().getHeight();
    return j + "x" + k;
  }
  
  public static String f()
  {
    return "";
  }
  
  public static String g()
  {
    return "";
  }
  
  public static String h()
  {
    try
    {
      Context localContext = CommonDataAdapter.a().a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("imei=").append(c()).append('&');
      localStringBuilder.append("model=").append(Build.MODEL).append('&');
      localStringBuilder.append("os=").append(Build.VERSION.RELEASE).append('&');
      localStringBuilder.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
      String str = APNUtil.b(localContext);
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localStringBuilder.append("network=").append((String)localObject).append('&');
      localObject = localStringBuilder.append("sdcard=");
      if (Environment.getExternalStorageState().equals("mounted")) {}
      for (int j = 1;; j = 0)
      {
        ((StringBuilder)localObject).append(j).append('&');
        localStringBuilder.append("display=").append(e()).append('&');
        localStringBuilder.append("manu=").append(Build.MANUFACTURER).append("&");
        localStringBuilder.append("wifi=").append(APNUtil.e(localContext));
        localObject = localStringBuilder.toString();
        return localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public static String i()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", CommonDataAdapter.a().e());
      localJSONObject.put("longitude", f());
      localJSONObject.put("platform", CommonDataAdapter.a().g());
      localJSONObject.put("uin", CommonDataAdapter.a().a());
      localJSONObject.put("imei", c());
      localJSONObject.put("imei", c());
      localJSONObject.put("resolution", e());
      localJSONObject.put("network", APNUtil.a(CommonDataAdapter.a().a()));
      localJSONObject.put("wifimac", a());
      localJSONObject.put("mobile_pf", "1");
      localJSONObject.put("os_ver", Build.VERSION.RELEASE);
      localJSONObject.put("lang", b());
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("model_name", Build.MODEL);
      localJSONObject.put("sdk_ver", "1.5");
      localJSONObject.put("timezone", TimeZone.getDefault().getID());
      localJSONObject.put("city", g());
      localJSONObject.put("longitude", f());
      localJSONObject.put("ret_code", "0");
      localJSONObject.put("qua", CommonDataAdapter.a().e());
      localJSONObject.put("qz_ver", CommonDataAdapter.a().b());
      localJSONObject.put("imsi", d());
      localJSONObject.put("androidID", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
      localJSONObject.put("os_api_level", Build.VERSION.SDK_INT);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.e("getMobileInfo", "gather mobile info exception.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.business.base.MobileInfoUtil
 * JD-Core Version:    0.7.0.1
 */