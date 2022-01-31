package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PrivacyDeclareViewActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;
import java.util.Locale;

public class PrivacyDeclareHelper
{
  public static final int a = 1001;
  private static PrivacyDeclareHelper.Callback a = null;
  public static final String a = "key_privacy_start";
  public static final int b = 1;
  public static final String b = "key_privacy_type";
  public static final int c = 2;
  public static final String c = "key_privacy_uin";
  public static final int d = 3;
  public static final String d = "key_privacy_underage";
  public static final int e = 1001;
  public static final String e = "url";
  public static final int f = 11;
  public static final String f = "privacy://";
  public static final int g = 2000;
  public static final String g = "https://sqimg.qq.com/qq_product_operations/i18n/loginPrivacy.html?language={language}";
  public static final int h = 2001;
  public static final String h = "privacy://continueClick";
  public static final int i = 2002;
  public static final String i = "privacy://cancelClick";
  public static final String j = "https://sqimg.qq.com/qq_product_operations/i18n/newUser.html?language={language}";
  public static final String k = "privacy://ShowMeABox";
  public static final String l = "checkbox";
  public static final String m = "language";
  public static final String n = "http://ti.qq.com/adyen/index.html";
  public static final String o = "ti.qq.com/adyen/index";
  public static final String p = "privacy://authSuccess";
  private static String q = null;
  
  private static Resources a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramPackageManager = paramPackageManager.getResourcesForApplication(paramString1);
        paramString1 = paramPackageManager.getConfiguration();
        if ("ch_simple".equals(paramString2))
        {
          paramString1.locale = Locale.SIMPLIFIED_CHINESE;
          paramPackageManager.updateConfiguration(paramString1, null);
          return paramPackageManager;
        }
        if ("english".equals(paramString2))
        {
          paramString1.locale = Locale.ENGLISH;
          continue;
        }
        if (!"deutsch".equals(paramString2)) {
          break label80;
        }
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        paramPackageManager.printStackTrace();
        return null;
      }
      paramString1.locale = Locale.GERMANY;
      continue;
      label80:
      if ("fran".equals(paramString2)) {
        paramString1.locale = Locale.FRANCE;
      } else if ("espa".equals(paramString2)) {
        paramString1.locale = new Locale("es");
      } else if ("ch_cht".equals(paramString2)) {
        paramString1.locale = Locale.SIMPLIFIED_CHINESE;
      } else {
        paramString1.locale = Locale.ENGLISH;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    return a(paramContext, "http://ti.qq.com/adyen/index.html");
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.toLowerCase().trim();
    }
    return b(paramContext, paramInt, str);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    int i1;
    do
    {
      return paramString;
      i1 = LocaleUtil.a(paramContext);
      if (i1 == 2) {
        return paramString.replace("{language}", "ch_simple");
      }
      if (i1 == 3) {
        return paramString.replace("{language}", "ch_chT");
      }
      if (i1 == 1) {
        return paramString.replace("{language}", "English");
      }
      if (i1 == 4) {
        return paramString.replace("{language}", "Japanese");
      }
      if (i1 == 5) {
        return paramString.replace("{language}", "Korean");
      }
      if (i1 == 6) {
        return paramString.replace("{language}", "Deutsch");
      }
      if (i1 == 7) {
        return paramString.replace("{language}", "Fran");
      }
    } while (i1 != 8);
    return paramString.replace("{language}", "Espa");
  }
  
  private static void a()
  {
    a = null;
  }
  
  public static void a(Context paramContext, Bundle paramBundle, PrivacyDeclareHelper.Callback paramCallback)
  {
    if ((paramContext == null) || (paramCallback == null)) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      new QQToastNotifier(paramContext).a(paramContext.getResources().getString(2131562452), paramContext.getResources().getDimensionPixelSize(2131427376), 1, 0);
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a = paramCallback;
    paramBundle = localBundle.getString("key_privacy_uin", null);
    int i1 = localBundle.getInt("key_privacy_type", 0);
    if (a(i1, paramBundle))
    {
      paramCallback = new Intent(paramContext, PrivacyDeclareViewActivity.class);
      paramBundle = "";
      if (i1 == 1)
      {
        paramBundle = "https://sqimg.qq.com/qq_product_operations/i18n/loginPrivacy.html?language={language}";
        localBundle.putInt("key_privacy_start", 1001);
        localBundle.putString("url", a(paramContext.getApplicationContext(), paramBundle));
        paramCallback.putExtras(localBundle);
        try
        {
          if ((paramContext instanceof BaseActivity))
          {
            ((BaseActivity)paramContext).startActivityForResult(paramCallback, 1001);
            label168:
            ((Activity)paramContext).overridePendingTransition(2130968596, 2130968597);
            return;
          }
        }
        catch (Exception paramContext)
        {
          a.a();
        }
      }
    }
    for (;;)
    {
      a();
      return;
      if ((i1 != 2) && (i1 != 3)) {
        break;
      }
      paramBundle = "https://sqimg.qq.com/qq_product_operations/i18n/newUser.html?language={language}";
      break;
      paramContext.startActivity(paramCallback);
      break label168;
      a.c();
    }
  }
  
  public static void a(String paramString)
  {
    q = null;
    try
    {
      EUCountryUtils.b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("lich", 2, "clear Privacy Showed error" + paramString.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      EUCountryUtils.a(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("lich", 2, "add PrivacyShowed Info error" + paramString1.toString());
    }
  }
  
  private static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      if ((paramString != null) && (paramString.equals(q))) {
        bool = false;
      }
    }
    else {
      return bool;
    }
    q = paramString;
    try
    {
      bool = EUCountryUtils.d(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.d("lich", 2, "select should show error" + paramString.toString());
    }
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramInt1, paramInt2, null);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if (a == null) {
      return false;
    }
    int i1;
    if ((paramContext instanceof RegisterPhoneNumActivity)) {
      i1 = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("lich", 2, "Privacy activity receive result --- code:" + paramInt2 + " , from:" + i1 + ", uin:" + EUCountryUtils.a(paramString));
      }
      if (paramInt1 == 1001) {
        if (paramInt2 == -1)
        {
          a.c();
          label98:
          a();
        }
      }
      for (;;)
      {
        return bool;
        if ((paramContext instanceof LoginActivity))
        {
          i1 = 1;
          break;
        }
        if (!(paramContext instanceof SplashActivity)) {
          break label164;
        }
        i1 = 3;
        break;
        if (paramInt2 == 11)
        {
          a.b();
          break label98;
        }
        a.a();
        break label98;
        bool = false;
      }
      label164:
      i1 = 0;
    }
  }
  
  public static String b(Context paramContext, int paramInt, String paramString)
  {
    String str = paramContext.getResources().getString(paramInt);
    if (paramString == null) {}
    do
    {
      return str;
      paramContext = a(paramContext.getApplicationContext().getPackageManager(), paramContext.getPackageName(), paramString);
    } while (paramContext == null);
    try
    {
      paramContext = paramContext.getString(paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    int i1;
    do
    {
      return paramString;
      i1 = LocaleUtil.a(paramContext);
      if (i1 == 2) {
        return paramString.replace("${language}", "ch_simple");
      }
      if (i1 == 3) {
        return paramString.replace("${language}", "ch_chT");
      }
      if (i1 == 1) {
        return paramString.replace("${language}", "English");
      }
      if (i1 == 4) {
        return paramString.replace("${language}", "Japanese");
      }
      if (i1 == 5) {
        return paramString.replace("${language}", "Korean");
      }
      if (i1 == 6) {
        return paramString.replace("${language}", "Deutsch");
      }
      if (i1 == 7) {
        return paramString.replace("${language}", "Fran");
      }
    } while (i1 != 8);
    return paramString.replace("${language}", "Espa");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyDeclareHelper
 * JD-Core Version:    0.7.0.1
 */