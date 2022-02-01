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
import com.tencent.service.update.e;
import com.tencent.token.cd;
import com.tencent.token.ck;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.gamelogin.GameLoginService;
import com.tencent.token.core.push.PushService;
import com.tencent.token.cs;
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
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
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
    if (paramByte > 9) {
      c1 = (char)(paramByte - 10 + 65);
    } else {
      c1 = (char)(paramByte + 48);
    }
    char c2;
    if (i > 9) {
      c2 = (char)(i - 10 + 65);
    } else {
      c2 = (char)(i + 48);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Character.valueOf(c1).toString());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(Character.valueOf(c2).toString());
    return localStringBuilder.toString();
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
      localJSONObject.put("op_time", cd.c().s() / 1000L);
      localJSONObject.put("uin", paramLong);
      localJSONObject.put("ques_id_0", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(0)).a());
      localJSONObject.put("answer_0", paramArrayOfString[0]);
      localJSONObject.put("ques_id_1", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(1)).a());
      localJSONObject.put("answer_1", paramArrayOfString[1]);
      localJSONObject.put("ques_id_2", ((DeterminVerifyFactorsResult.QuesInfoItem)paramList.get(2)).a());
      localJSONObject.put("answer_2", paramArrayOfString[2]);
      paramList = localJSONObject.toString();
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("plain: ");
      paramArrayOfString.append(paramList);
      g.a(paramArrayOfString.toString());
      paramList = b(paramList.getBytes());
      return paramList;
    }
    catch (JSONException paramList)
    {
      label192:
      break label192;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("testabc src=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",dst=");
    localStringBuilder.append(localStringBuffer.toString());
    g.a(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    if (!e.a().b()) {
      return null;
    }
    try
    {
      if (e.a().b()) {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      } else {
        paramContext = "";
      }
    }
    catch (Exception paramContext)
    {
      label40:
      StringBuilder localStringBuilder;
      break label40;
    }
    paramContext = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("androidID =");
    localStringBuilder.append(paramContext);
    g.b(localStringBuilder.toString());
    if (paramContext == null) {
      return null;
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
    if (paramString.length() < 5) {
      return paramString;
    }
    int i = 0;
    String str = paramString.substring(0, 3);
    while (i < paramString.length() - 5)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramChar);
      str = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString.substring(paramString.length() - 2, paramString.length()));
    return localStringBuilder.toString();
  }
  
  public static String a(Calendar paramCalendar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramCalendar.get(1));
    localStringBuffer.append('-');
    localStringBuffer.append(a(paramCalendar.get(2) + 1, 2));
    localStringBuffer.append('-');
    localStringBuffer.append(a(paramCalendar.get(5), 2));
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
      Object localObject = new JSONObject();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        ((JSONObject)localObject).put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
      paramVarArgs = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("plain data: ");
      ((StringBuilder)localObject).append(paramVarArgs);
      g.a(((StringBuilder)localObject).toString());
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
    try
    {
      localMethod = Activity.class.getMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE });
      switch (paramInt)
      {
      case 1: 
        localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2130771991), Integer.valueOf(2130771990) });
        return;
      }
    }
    catch (Exception paramActivity)
    {
      Method localMethod;
      g.c(paramActivity.toString());
      return;
    }
    localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2130771989), Integer.valueOf(2130771992) });
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
      paramBaseActivity.showToast(2131493627);
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
      paramIndexActivity.showToast(2131493627);
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
    Context localContext = RqdApplication.n();
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
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
    Context localContext = RqdApplication.n();
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
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
      Context localContext = RqdApplication.n();
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("account_tip_flag");
        paramString = localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        paramString.putBoolean("account_tip_flag", paramBoolean);
        paramString.commit();
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    Object localObject = (ConnectivityManager)RqdApplication.n().getSystemService("connectivity");
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((NetworkInfo)localObject).getState();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (NetworkInfo.State.CONNECTED == localObject) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(char paramChar)
  {
    if (!Character.isLetterOrDigit(paramChar)) {
      switch (paramChar)
      {
      default: 
        break;
      case '#': 
      case '%': 
      case '(': 
      case ')': 
      case '+': 
      case ',': 
      case '-': 
      case '.': 
      case '=': 
      case '@': 
      case '[': 
      case ']': 
      case '_': 
      case '{': 
      case '}': 
        return true;
      }
    }
    return false;
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
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    return paramContext != null;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Context localContext = RqdApplication.n();
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString2, false);
    }
    return localContext.getSharedPreferences(paramString2, 0).getBoolean(paramString2, false);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int i = 0;
    int j = 0;
    int m = 0;
    int n = 0;
    int k = paramInt;
    paramInt = n;
    int i1;
    for (;;)
    {
      n = k - 1;
      i1 = j;
      if (k <= 0) {
        break;
      }
      j = i + 1;
      i = paramArrayOfByte[i];
      i1 = i;
      if (i == 0) {
        break;
      }
      if (i == 95)
      {
        i1 = i;
        break;
      }
      k = i;
      if (i == 32) {
        k = 42;
      }
      i1 = c[k];
      if (i1 < 0)
      {
        i = j;
        k = n;
        j = i1;
      }
      else
      {
        switch (m % 4)
        {
        default: 
          break;
        case 3: 
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1));
          paramInt += 1;
          break;
        case 2: 
          i = paramInt + 1;
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1 >> 2));
          arrayOfByte[i] = ((byte)((i1 & 0x3) << 6));
          paramInt = i;
          break;
        case 1: 
          i = paramInt + 1;
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1 >> 4));
          arrayOfByte[i] = ((byte)((i1 & 0xF) << 4));
          paramInt = i;
          break;
        case 0: 
          arrayOfByte[paramInt] = ((byte)(i1 << 2));
        }
        m += 1;
        i = j;
        k = n;
        j = i1;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      default: 
        return arrayOfByte;
      case 2: 
        i = paramInt + 1;
      case 3: 
        arrayOfByte[i] = 0;
        return arrayOfByte;
      }
      return null;
    }
    return arrayOfByte;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    Context localContext = RqdApplication.n();
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getInt(paramString2, 0);
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
      return c.g().getResources().getString(2131493329);
    }
    if ((i == k) && (j == m + 1)) {
      return c.g().getResources().getString(2131493337);
    }
    if ((i == k) && (j <= m + 6))
    {
      switch (n)
      {
      default: 
        return a(b);
      case 7: 
        return c.g().getResources().getString(2131493335);
      case 6: 
        return c.g().getResources().getString(2131493334);
      case 5: 
        return c.g().getResources().getString(2131493333);
      case 4: 
        return c.g().getResources().getString(2131493332);
      case 3: 
        return c.g().getResources().getString(2131493331);
      case 2: 
        return c.g().getResources().getString(2131493330);
      }
      return c.g().getResources().getString(2131493336);
    }
    return a(b);
  }
  
  public static String b(Context paramContext)
  {
    if (!e.a().b()) {
      return null;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception paramContext)
    {
      label28:
      StringBuilder localStringBuilder;
      break label28;
    }
    paramContext = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("deviceId =");
    localStringBuilder.append(paramContext);
    g.b(localStringBuilder.toString());
    if (paramContext == null) {
      return null;
    }
    return MD5.toMD5(paramContext);
  }
  
  public static String b(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("B");
        localStringBuilder.append(b.a(paramString.getBytes()));
        return localStringBuilder.toString();
      }
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("A");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = cs.a().c();
    if ((arrayOfByte != null) && (arrayOfByte.length == 16))
    {
      paramArrayOfByte = new a().b(paramArrayOfByte, arrayOfByte);
      if (paramArrayOfByte == null)
      {
        g.c("encrypt pwd failed");
        return null;
      }
      return ck.a(paramArrayOfByte);
    }
    boolean bool;
    if (arrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    return null;
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
    if (paramLong >= 0L)
    {
      if (paramLong % 86400L == 0L)
      {
        int i = (int)(paramLong / 86400L);
        if (i == 0) {
          return 1;
        }
        return i;
      }
      return 1 + (int)(paramLong / 86400L);
    }
    return 0;
  }
  
  public static String c(Context paramContext)
  {
    if (!e.a().b()) {
      return null;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }
    catch (Exception paramContext)
    {
      label31:
      StringBuilder localStringBuilder;
      break label31;
    }
    paramContext = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mac =");
    localStringBuilder.append(paramContext);
    g.b(localStringBuilder.toString());
    if (paramContext == null) {
      return null;
    }
    return MD5.toMD5(paramContext);
  }
  
  public static boolean c()
  {
    Object localObject = (ActivityManager)RqdApplication.n().getSystemService("activity");
    String str = RqdApplication.n().getPackageName();
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
    byte[] arrayOfByte = cs.a().c();
    if ((arrayOfByte != null) && (arrayOfByte.length == 16)) {
      try
      {
        paramString = new a().a(ck.a(paramString), arrayOfByte);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    boolean bool;
    if (arrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = cs.a().c();
    if ((arrayOfByte != null) && (arrayOfByte.length == 16))
    {
      paramArrayOfByte = new a().b(paramArrayOfByte, arrayOfByte);
      if (paramArrayOfByte == null)
      {
        g.c("encrypt pwd failed");
        return null;
      }
      return paramArrayOfByte;
    }
    boolean bool;
    if (arrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
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
    if (!e.a().b()) {
      return null;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
    }
    catch (Exception paramContext)
    {
      label31:
      StringBuilder localStringBuilder;
      break label31;
    }
    paramContext = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bssid =");
    localStringBuilder.append(paramContext);
    g.b(localStringBuilder.toString());
    if (paramContext == null) {
      return null;
    }
    return MD5.toMD5(paramContext);
  }
  
  public static boolean d()
  {
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)RqdApplication.n().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject == null) {
      return false;
    }
    localObject = ((ComponentName)localObject).getPackageName();
    String str = RqdApplication.n().getPackageName();
    if (localObject == null) {
      return false;
    }
    return (((String)localObject).length() > 0) && (str.equals(localObject));
  }
  
  public static byte[] d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data hex: ");
    localStringBuilder.append(paramString);
    g.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("@decSeedDataV2 data: ");
    localStringBuilder.append(paramString);
    TmsLog.i("mod_seed", localStringBuilder.toString());
    try
    {
      paramString = new a().a(ck.a(paramString), cd.c().f());
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
    while (i < localStringBuffer1.length())
    {
      if ((i != 0) && (i != 1) && (i != localStringBuffer1.length() - 1)) {
        localStringBuffer2.append('*');
      } else {
        localStringBuffer2.append(localStringBuffer1.charAt(i));
      }
      i += 1;
    }
    return localStringBuffer2.toString();
  }
  
  public static String e(Context paramContext)
  {
    if (!e.a().b()) {
      return null;
    }
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      if (paramString.startsWith("http://")) {
        return "http://";
      }
      if (paramString.startsWith("https://")) {
        return "https://";
      }
      return null;
    }
    return null;
  }
  
  public static boolean e()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    try
    {
      Object localObject = RqdApplication.n();
      if (cs.a().e() == null) {
        return false;
      }
      String str = String.valueOf(cs.a().e().mUin);
      if (!TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("account_tip_flag");
        localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        bool1 = ((SharedPreferences)localObject).getBoolean("account_tip_flag", false);
        if (bool1) {
          try
          {
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putBoolean("account_tip_flag", false);
            ((SharedPreferences.Editor)localObject).commit();
          }
          catch (Exception localException1)
          {
            break label127;
          }
        }
        return bool1;
      }
    }
    catch (Exception localException2)
    {
      bool1 = bool2;
      label127:
      localException2.printStackTrace();
    }
    return bool1;
  }
  
  public static long f(long paramLong)
  {
    long l = 0L;
    if (paramLong == 0L) {
      return 0L;
    }
    String str = ck.a(MD5.toMD5Byte(Long.toString(paramLong)));
    int j = Math.min(31, str.length() - 1);
    for (paramLong = l; j >= 0; paramLong = l)
    {
      int k = 0;
      int i;
      if ((str.charAt(j) >= '0') && (str.charAt(j) <= '9'))
      {
        i = str.charAt(j) - '0';
      }
      else if ((str.charAt(j) >= 'a') && (str.charAt(j) <= 'f'))
      {
        i = str.charAt(j) - 'a';
      }
      else
      {
        i = k;
        if (str.charAt(j) >= 'A')
        {
          i = k;
          if (str.charAt(j) <= 'F') {
            i = str.charAt(j) - 'A';
          }
        }
      }
      l = paramLong;
      if (i % 2 != 0) {
        l = paramLong + (1L << j);
      }
      j -= 1;
    }
    return paramLong;
  }
  
  public static String f(String paramString)
  {
    String str = e(paramString);
    if (str == null) {
      return null;
    }
    paramString = paramString.substring(str.length());
    int i = paramString.indexOf('/');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static boolean f()
  {
    List localList = ((ActivityManager)RqdApplication.n().getSystemService("activity")).getRunningServices(50);
    int i = 0;
    while (i < localList.size())
    {
      if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.widget.TokenService")) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String g(String paramString)
  {
    g.a(paramString);
    if (paramString == null) {
      return "null";
    }
    try
    {
      int j = paramString.indexOf("//");
      if (j == -1) {
        break label208;
      }
      int i = c.a();
      j += 2;
      str1 = paramString.substring(0, j);
      str2 = paramString.substring(j, paramString.length() - 1);
      switch (i)
      {
      case 3: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("gray.");
        localStringBuilder.append(str2);
        return localStringBuilder.toString();
      }
    }
    catch (Exception localException)
    {
      String str1;
      String str2;
      StringBuilder localStringBuilder;
      localException.printStackTrace();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("exp.");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("test.");
    localStringBuilder.append(str2);
    str1 = localStringBuilder.toString();
    return str1;
    label208:
    return paramString;
    return paramString;
  }
  
  public static boolean g()
  {
    List localList = ((ActivityManager)RqdApplication.n().getSystemService("activity")).getRunningServices(50);
    if (localList == null) {
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.core.push.PushService")) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean h()
  {
    List localList = ((ActivityManager)RqdApplication.n().getSystemService("activity")).getRunningServices(50);
    int i = 0;
    while (i < localList.size())
    {
      if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.core.gamelogin.GameLoginService"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("game login: ");
        localStringBuilder.append(((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName());
        g.c(localStringBuilder.toString());
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void i()
  {
    int j = 0;
    try
    {
      Context localContext = RqdApplication.n();
      int[] arrayOfInt = AppWidgetManager.getInstance(localContext).getAppWidgetIds(new ComponentName(localContext, TokenWidgetProvider.class));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("widget_big num=");
      localStringBuilder.append(arrayOfInt.length);
      g.a(localStringBuilder.toString());
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
    Intent localIntent = new Intent(RqdApplication.n(), GameLoginService.class);
    RqdApplication.n().stopService(localIntent);
  }
  
  public static String k()
  {
    Object localObject = RqdApplication.n();
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
      Object localObject = RqdApplication.n();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "";
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: new 835	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 836	java/util/ArrayList:<init>	()V
    //   7: astore_0
    //   8: new 838	java/io/DataInputStream
    //   11: dup
    //   12: invokestatic 423	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   15: invokevirtual 102	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 842	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: ldc_w 844
    //   24: invokevirtual 850	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: invokespecial 853	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 856	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +38 -> 75
    //   40: aload_2
    //   41: invokevirtual 294	java/lang/String:length	()I
    //   44: iconst_1
    //   45: if_icmple -14 -> 31
    //   48: aload_2
    //   49: invokevirtual 858	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   52: ldc_w 860
    //   55: invokevirtual 750	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   58: iflt -27 -> 31
    //   61: aload_0
    //   62: aload_2
    //   63: bipush 8
    //   65: invokevirtual 724	java/lang/String:substring	(I)Ljava/lang/String;
    //   68: invokevirtual 863	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: goto -41 -> 31
    //   75: aload_0
    //   76: invokevirtual 864	java/util/ArrayList:size	()I
    //   79: ifle +20 -> 99
    //   82: aload_0
    //   83: aload_0
    //   84: invokevirtual 864	java/util/ArrayList:size	()I
    //   87: iconst_1
    //   88: isub
    //   89: invokevirtual 865	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   92: checkcast 217	java/lang/String
    //   95: astore_0
    //   96: goto +7 -> 103
    //   99: ldc_w 867
    //   102: astore_0
    //   103: aload_1
    //   104: invokevirtual 870	java/io/DataInputStream:close	()V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: goto +15 -> 125
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   118: aload_1
    //   119: invokevirtual 870	java/io/DataInputStream:close	()V
    //   122: goto +9 -> 131
    //   125: aload_1
    //   126: invokevirtual 870	java/io/DataInputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: ldc_w 867
    //   134: areturn
    //   135: astore_0
    //   136: goto -5 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	101	0	localObject1	Object
    //   109	1	0	localObject2	Object
    //   113	17	0	localException	Exception
    //   135	1	0	localIOException	java.io.IOException
    //   30	96	1	localDataInputStream	java.io.DataInputStream
    //   35	28	2	str	String
    // Exception table:
    //   from	to	target	type
    //   31	36	109	finally
    //   40	72	109	finally
    //   75	96	109	finally
    //   114	118	109	finally
    //   31	36	113	java/lang/Exception
    //   40	72	113	java/lang/Exception
    //   75	96	113	java/lang/Exception
    //   0	31	135	java/io/IOException
    //   103	107	135	java/io/IOException
    //   118	122	135	java/io/IOException
    //   125	131	135	java/io/IOException
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