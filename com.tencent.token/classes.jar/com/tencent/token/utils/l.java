package com.tencent.token.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.token.cc;
import com.tencent.token.cj;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.gamelogin.GameLoginService;
import com.tencent.token.core.push.PushService;
import com.tencent.token.cr;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.g;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.HelpActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.widget.TokenService;
import com.tencent.token.widget.TokenWidgetProvider;
import com.tmsdk.common.util.TmsLog;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  static Date a = new Date();
  static Calendar b = Calendar.getInstance();
  static final short[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    i -= paramByte * 16;
    char c1;
    if (paramByte > 9)
    {
      c1 = (char)(paramByte - 10 + 65);
      if (i <= 9) {
        break label116;
      }
    }
    label116:
    for (char c2 = (char)(i - 10 + 65);; c2 = (char)(i + 48))
    {
      String str = "" + Character.valueOf(c1).toString();
      return str + Character.valueOf(c2).toString();
      c1 = (char)(paramByte + 48);
      break;
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt1);
    int i = localStringBuffer.length();
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - i)
    {
      localStringBuffer.insert(0, 0);
      paramInt1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(int paramInt, long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("seq_id", paramInt);
      localJSONObject.put("op_time", cc.c().s() / 1000L);
      localJSONObject.put("uin", paramLong);
      localJSONObject.put("ques_id_0", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(0)).a());
      localJSONObject.put("answer_0", paramArrayOfString[0]);
      localJSONObject.put("ques_id_1", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(1)).a());
      localJSONObject.put("answer_1", paramArrayOfString[1]);
      localJSONObject.put("ques_id_2", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(2)).a());
      localJSONObject.put("answer_2", paramArrayOfString[2]);
      paramList = localJSONObject.toString();
      g.a("plain: " + paramList);
      paramList = b(paramList.getBytes());
      return paramList;
    }
    catch (JSONException paramList) {}
    return null;
  }
  
  public static String a(long paramLong)
  {
    a.setTime(paramLong);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    StringBuffer localStringBuffer = new StringBuffer();
    int i = b.get(2);
    int j = b.get(5);
    localStringBuffer.append(i + 1);
    localStringBuffer.append('-');
    if (j < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(j);
    return localStringBuffer.toString();
  }
  
  public static String a(long paramLong, char paramChar)
  {
    a.setTime(paramLong);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    StringBuffer localStringBuffer = new StringBuffer();
    int i = b.get(2) + 1;
    int j = b.get(5);
    int k = b.get(11);
    int m = b.get(12);
    localStringBuffer.append(b.get(1));
    localStringBuffer.append(paramChar);
    if (i < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(i);
    localStringBuffer.append(paramChar);
    if (j < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(j);
    localStringBuffer.append(' ');
    if (k < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(k);
    localStringBuffer.append(':');
    if (m < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(m);
    g.a("testabc src=" + paramLong + ",dst=" + localStringBuffer.toString());
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      g.b("androidID =" + paramContext);
      if (paramContext == null) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return MD5.toMD5(paramContext);
  }
  
  public static String a(String paramString)
  {
    if (paramString.length() < 3) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer("12******9");
    localStringBuffer.replace(0, 2, paramString.substring(0, 2));
    localStringBuffer.replace(8, 9, paramString.substring(paramString.length() - 1, paramString.length()));
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, char paramChar)
  {
    int i = 0;
    if (paramString.length() < 5) {
      return paramString;
    }
    String str = paramString.substring(0, 3);
    while (i < paramString.length() - 5)
    {
      str = str + paramChar;
      i += 1;
    }
    return str + paramString.substring(paramString.length() - 2, paramString.length());
  }
  
  public static String a(Calendar paramCalendar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramCalendar.get(1)).append('-').append(a(paramCalendar.get(2) + 1, 2)).append('-').append(a(paramCalendar.get(5), 2));
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(a(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0)
    {
      g.c("params count % 2 should be 0");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localJSONObject.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
      paramVarArgs = localJSONObject.toString();
      g.a("plain data: " + paramVarArgs);
      paramVarArgs = b(paramVarArgs.getBytes());
      return paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Method localMethod;
    try
    {
      localMethod = Activity.class.getMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE });
      switch (paramInt)
      {
      case 0: 
        localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2131034133), Integer.valueOf(2131034136) });
        return;
      }
    }
    catch (Exception paramActivity)
    {
      g.c(paramActivity.toString());
      return;
    }
    localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2131034135), Integer.valueOf(2131034134) });
    return;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      g.b(paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, HelpActivity.class);
    localIntent.putExtra("help_url", paramString1);
    localIntent.putExtra("help_title", paramString2);
    localIntent.putExtra("help_url_need_login_sig", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, HelpActivity.class);
    localIntent.putExtra("help_url", paramString1);
    localIntent.putExtra("help_title", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (paramString == null) {
      paramBaseActivity.showToast(2131231482);
    }
    try
    {
      paramBaseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramBaseActivity)
    {
      paramBaseActivity.printStackTrace();
      g.b(paramBaseActivity.toString());
    }
  }
  
  public static void a(IndexActivity paramIndexActivity, String paramString)
  {
    if (paramString == null) {
      paramIndexActivity.showToast(2131231482);
    }
    try
    {
      paramIndexActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramIndexActivity)
    {
      paramIndexActivity.printStackTrace();
      g.b(paramIndexActivity.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    Context localContext = RqdApplication.l();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = localContext.getSharedPreferences(paramString1 + paramString2, 0).edit();
      paramString1.putInt(paramString2, paramInt);
      paramString1.commit();
      return;
    }
    paramString1 = localContext.getSharedPreferences(paramString2, 0).edit();
    paramString1.putInt(paramString2, paramInt);
    paramString1.commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Context localContext = RqdApplication.l();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = localContext.getSharedPreferences(paramString1 + paramString2, 0).edit();
      paramString1.putBoolean(paramString2, paramBoolean);
      paramString1.commit();
      return;
    }
    paramString1 = localContext.getSharedPreferences(paramString2, 0).edit();
    paramString1.putBoolean(paramString2, paramBoolean);
    paramString1.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Context localContext = RqdApplication.l();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = localContext.getSharedPreferences(paramString + "account_tip_flag", 0).edit();
        paramString.putBoolean("account_tip_flag", paramBoolean);
        paramString.commit();
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    Object localObject = (ConnectivityManager)RqdApplication.l().getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      do
      {
        return false;
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
      } while (localObject == null);
      localObject = ((NetworkInfo)localObject).getState();
    } while (localObject == null);
    if (NetworkInfo.State.CONNECTED == localObject) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(char paramChar)
  {
    if (!Character.isLetterOrDigit(paramChar)) {}
    switch (paramChar)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    a.setTime(paramLong1);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int i = b.get(1);
    int j = b.get(6);
    a.setTime(paramLong2);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int k = b.get(1);
    int m = b.get(6);
    return (i == k) && (j == m);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext == null) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Context localContext = RqdApplication.l();
    if (!TextUtils.isEmpty(paramString1)) {
      return localContext.getSharedPreferences(paramString1 + paramString2, 0).getBoolean(paramString2, false);
    }
    return localContext.getSharedPreferences(paramString2, 0).getBoolean(paramString2, false);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = c[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  public static int b(String paramString1, String paramString2)
  {
    Context localContext = RqdApplication.l();
    if (!TextUtils.isEmpty(paramString1)) {
      return localContext.getSharedPreferences(paramString1 + paramString2, 0).getInt(paramString2, 0);
    }
    return localContext.getSharedPreferences(paramString2, 0).getInt(paramString2, 0);
  }
  
  public static String b(long paramLong)
  {
    a.setTime(System.currentTimeMillis());
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int i = b.get(1);
    int j = b.get(6);
    a.setTime(paramLong);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int k = b.get(1);
    int m = b.get(6);
    int n = b.get(7);
    if ((i == k) && (j == m)) {
      return c.g().getResources().getString(2131231186);
    }
    if ((i == k) && (j == m + 1)) {
      return c.g().getResources().getString(2131231194);
    }
    if ((i == k) && (j <= m + 6))
    {
      switch (n)
      {
      default: 
        return a(b);
      case 1: 
        return c.g().getResources().getString(2131231193);
      case 2: 
        return c.g().getResources().getString(2131231187);
      case 3: 
        return c.g().getResources().getString(2131231188);
      case 4: 
        return c.g().getResources().getString(2131231189);
      case 5: 
        return c.g().getResources().getString(2131231190);
      case 6: 
        return c.g().getResources().getString(2131231191);
      }
      return c.g().getResources().getString(2131231192);
    }
    return a(b);
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      g.b("deviceId =" + paramContext);
      if (paramContext == null) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return MD5.toMD5(paramContext);
  }
  
  public static String b(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i))) {
        return "B" + b.a(paramString.getBytes());
      }
      i += 1;
    }
    return "A" + paramString;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = cr.a().c();
    if ((arrayOfByte == null) || (arrayOfByte.length != 16))
    {
      if (arrayOfByte == null) {}
      for (boolean bool = true;; bool = false)
      {
        g.a(bool);
        return null;
      }
    }
    paramArrayOfByte = new a().b(paramArrayOfByte, arrayOfByte);
    if (paramArrayOfByte == null)
    {
      g.c("encrypt pwd failed");
      return null;
    }
    return cj.a(paramArrayOfByte);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, HelpActivity.class);
    localIntent.putExtra("help_url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean b()
  {
    return RqdApplication.c == 1;
  }
  
  public static int c(long paramLong)
  {
    int i = 0;
    if (paramLong >= 0L)
    {
      if (paramLong % 86400L != 0L) {
        break label35;
      }
      int j = (int)(paramLong / 86400L);
      i = j;
      if (j == 0) {
        i = 1;
      }
    }
    return i;
    label35:
    return (int)(paramLong / 86400L) + 1;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      g.b("mac =" + paramContext);
      if (paramContext == null) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return MD5.toMD5(paramContext);
  }
  
  public static boolean c()
  {
    Object localObject = (ActivityManager)RqdApplication.l().getSystemService("activity");
    String str = RqdApplication.l().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(str)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public static byte[] c(String paramString)
  {
    byte[] arrayOfByte = cr.a().c();
    if ((arrayOfByte == null) || (arrayOfByte.length != 16))
    {
      if (arrayOfByte == null) {}
      for (boolean bool = true;; bool = false)
      {
        g.a(bool);
        return null;
      }
    }
    try
    {
      paramString = new a().a(cj.a(paramString), arrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = cr.a().c();
    boolean bool;
    if ((arrayOfByte == null) || (arrayOfByte.length != 16)) {
      if (arrayOfByte == null)
      {
        bool = true;
        g.a(bool);
        paramArrayOfByte = null;
      }
    }
    do
    {
      return paramArrayOfByte;
      bool = false;
      break;
      arrayOfByte = new a().b(paramArrayOfByte, arrayOfByte);
      paramArrayOfByte = arrayOfByte;
    } while (arrayOfByte != null);
    g.c("encrypt pwd failed");
    return null;
  }
  
  public static String d(long paramLong)
  {
    a.setTime(paramLong);
    b.setTime(a);
    b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    StringBuffer localStringBuffer = new StringBuffer();
    int i = b.get(11);
    int j = b.get(12);
    if (i < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(i);
    localStringBuffer.append(':');
    if (j < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(j);
    return localStringBuffer.toString();
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      g.b("bssid =" + paramContext);
      if (paramContext == null) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return MD5.toMD5(paramContext);
  }
  
  public static boolean d()
  {
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)RqdApplication.l().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject == null) {
      return false;
    }
    localObject = ((ComponentName)localObject).getPackageName();
    String str = RqdApplication.l().getPackageName();
    if (localObject == null) {
      return false;
    }
    return (((String)localObject).length() > 0) && (str.equals(localObject));
  }
  
  public static byte[] d(String paramString)
  {
    g.a("data hex: " + paramString);
    TmsLog.i("mod_seed", "@decSeedDataV2 data: " + paramString);
    try
    {
      paramString = new a().a(cj.a(paramString), cc.c().f());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      TmsLog.e("mod_seed", "@decSeedDataV2 err.", paramString);
    }
    return null;
  }
  
  public static String e(long paramLong)
  {
    if (paramLong <= 0L) {
      return "";
    }
    StringBuffer localStringBuffer1 = new StringBuffer(Long.toString(paramLong));
    StringBuffer localStringBuffer2 = new StringBuffer("");
    int i = 0;
    if (i < localStringBuffer1.length())
    {
      if ((i == 0) || (i == 1) || (i == localStringBuffer1.length() - 1)) {
        localStringBuffer2.append(localStringBuffer1.charAt(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer2.append('*');
      }
    }
    return localStringBuffer2.toString();
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String e(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = null;
    }
    do
    {
      return str;
      str = "http://";
    } while (paramString.startsWith("http://"));
    if (paramString.startsWith("https://")) {
      return "https://";
    }
    return null;
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    try
    {
      Object localObject = RqdApplication.l();
      bool1 = bool3;
      if (cr.a().e() == null) {
        return false;
      }
      bool1 = bool3;
      String str = String.valueOf(cr.a().e().mUin);
      bool1 = bool3;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool3;
        localObject = ((Context)localObject).getSharedPreferences(str + "account_tip_flag", 0);
        bool1 = bool3;
        bool3 = ((SharedPreferences)localObject).getBoolean("account_tip_flag", false);
        bool2 = bool3;
        if (bool3)
        {
          bool1 = bool3;
          localObject = ((SharedPreferences)localObject).edit();
          bool1 = bool3;
          ((SharedPreferences.Editor)localObject).putBoolean("account_tip_flag", false);
          bool1 = bool3;
          ((SharedPreferences.Editor)localObject).commit();
          return bool3;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      bool2 = bool1;
    }
    return bool2;
  }
  
  public static long f(long paramLong)
  {
    long l = 0L;
    if (paramLong == 0L) {}
    String str;
    int j;
    do
    {
      return l;
      str = cj.a(MD5.toMD5Byte(Long.toString(paramLong)));
      j = Math.min(31, str.length() - 1);
      paramLong = l;
      l = paramLong;
    } while (j < 0);
    int k = 0;
    int i;
    if ((str.charAt(j) >= '0') && (str.charAt(j) <= '9'))
    {
      i = str.charAt(j) - '0';
      label82:
      if (i % 2 == 0) {
        break label177;
      }
      paramLong = (1L << j) + paramLong;
    }
    label177:
    for (;;)
    {
      j -= 1;
      break;
      if ((str.charAt(j) >= 'a') && (str.charAt(j) <= 'f'))
      {
        i = str.charAt(j) - 'a';
        break label82;
      }
      i = k;
      if (str.charAt(j) < 'A') {
        break label82;
      }
      i = k;
      if (str.charAt(j) > 'F') {
        break label82;
      }
      i = str.charAt(j) - 'A';
      break label82;
    }
  }
  
  public static String f(String paramString)
  {
    String str = e(paramString);
    if (str == null) {
      paramString = null;
    }
    int i;
    do
    {
      return paramString;
      str = paramString.substring(str.length());
      i = str.indexOf('/');
      paramString = str;
    } while (i == -1);
    return str.substring(0, i);
  }
  
  public static boolean f()
  {
    boolean bool2 = false;
    List localList = ((ActivityManager)RqdApplication.l().getSystemService("activity")).getRunningServices(50);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < localList.size())
      {
        if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.widget.TokenService")) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String g(String paramString)
  {
    g.a(paramString);
    if (paramString == null) {
      str1 = "null";
    }
    for (;;)
    {
      return str1;
      try
      {
        int i = paramString.indexOf("//");
        str1 = paramString;
        if (i != -1)
        {
          int j = c.a();
          str2 = paramString.substring(0, i + 2);
          str3 = paramString.substring(i + 2, paramString.length() - 1);
          str1 = paramString;
          switch (j)
          {
          case 1: 
          case 0: 
            return str2 + "test." + str3;
          }
        }
      }
      catch (Exception localException)
      {
        String str2;
        String str3;
        localException.printStackTrace();
        return paramString;
      }
    }
    return str2 + "exp." + str3;
    String str1 = str2 + "gray." + str3;
    return str1;
    return paramString;
  }
  
  public static boolean g()
  {
    List localList = ((ActivityManager)RqdApplication.l().getSystemService("activity")).getRunningServices(50);
    if (localList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < localList.size())
      {
        if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.core.push.PushService")) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean h()
  {
    boolean bool2 = false;
    List localList = ((ActivityManager)RqdApplication.l().getSystemService("activity")).getRunningServices(50);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < localList.size())
      {
        if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.core.gamelogin.GameLoginService"))
        {
          g.c("game login: " + ((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName());
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void i()
  {
    int j = 0;
    try
    {
      Context localContext = RqdApplication.l();
      int[] arrayOfInt = AppWidgetManager.getInstance(localContext).getAppWidgetIds(new ComponentName(localContext, TokenWidgetProvider.class));
      g.a("widget_big num=" + arrayOfInt.length);
      int i = j;
      if (arrayOfInt != null)
      {
        i = j;
        if (arrayOfInt.length > 0) {
          i = 1;
        }
      }
      if ((i != 0) && (!f())) {
        localContext.startService(new Intent(localContext, TokenService.class));
      }
      if (!g()) {
        localContext.startService(new Intent(localContext, PushService.class));
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void j()
  {
    Intent localIntent = new Intent(RqdApplication.l(), GameLoginService.class);
    RqdApplication.l().stopService(localIntent);
  }
  
  public static String k()
  {
    Object localObject = RqdApplication.l();
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (((NetworkInfo)localObject).getType() == 0)
        {
          if (((NetworkInfo)localObject).getExtraInfo() == null) {
            return "";
          }
          return ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.getDefault());
        }
        return ((NetworkInfo)localObject).getTypeName().toLowerCase(Locale.getDefault());
      }
      return "";
    }
    return "";
  }
  
  public static String l()
  {
    try
    {
      Object localObject = RqdApplication.l();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return "";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: new 827	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 828	java/util/ArrayList:<init>	()V
    //   7: astore_0
    //   8: new 830	java/io/DataInputStream
    //   11: dup
    //   12: invokestatic 415	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   15: invokevirtual 102	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 834	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: ldc_w 836
    //   24: invokevirtual 842	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: invokespecial 845	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +64 -> 96
    //   35: aload_2
    //   36: invokevirtual 848	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +61 -> 102
    //   44: aload_1
    //   45: invokevirtual 286	java/lang/String:length	()I
    //   48: iconst_1
    //   49: if_icmple -14 -> 35
    //   52: aload_1
    //   53: invokevirtual 850	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   56: ldc_w 852
    //   59: invokevirtual 743	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   62: iflt -27 -> 35
    //   65: aload_0
    //   66: aload_1
    //   67: ldc_w 852
    //   70: invokevirtual 286	java/lang/String:length	()I
    //   73: invokevirtual 717	java/lang/String:substring	(I)Ljava/lang/String;
    //   76: invokevirtual 855	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: goto -45 -> 35
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 369	java/lang/Exception:printStackTrace	()V
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 858	java/io/DataInputStream:close	()V
    //   96: ldc_w 860
    //   99: astore_1
    //   100: aload_1
    //   101: areturn
    //   102: aload_0
    //   103: invokevirtual 861	java/util/ArrayList:size	()I
    //   106: ifle +33 -> 139
    //   109: aload_0
    //   110: aload_0
    //   111: invokevirtual 861	java/util/ArrayList:size	()I
    //   114: iconst_1
    //   115: isub
    //   116: invokevirtual 862	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   119: checkcast 217	java/lang/String
    //   122: astore_0
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: ifnull -26 -> 100
    //   129: aload_2
    //   130: invokevirtual 858	java/io/DataInputStream:close	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore_0
    //   136: goto -40 -> 96
    //   139: ldc_w 860
    //   142: astore_0
    //   143: goto -20 -> 123
    //   146: astore_0
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 858	java/io/DataInputStream:close	()V
    //   155: aload_0
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	59	0	localArrayList	java.util.ArrayList
    //   83	28	0	localException	Exception
    //   122	12	0	str1	String
    //   135	1	0	localIOException	java.io.IOException
    //   142	1	0	str2	String
    //   146	10	0	localObject	Object
    //   39	86	1	str3	String
    //   30	122	2	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   35	40	83	java/lang/Exception
    //   44	80	83	java/lang/Exception
    //   102	123	83	java/lang/Exception
    //   0	31	135	java/io/IOException
    //   92	96	135	java/io/IOException
    //   129	133	135	java/io/IOException
    //   151	155	135	java/io/IOException
    //   155	157	135	java/io/IOException
    //   35	40	146	finally
    //   44	80	146	finally
    //   84	88	146	finally
    //   102	123	146	finally
  }
  
  public static int n()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.l
 * JD-Core Version:    0.7.0.1
 */