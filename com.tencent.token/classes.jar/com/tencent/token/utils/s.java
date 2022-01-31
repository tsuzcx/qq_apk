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
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.ap;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult.QuesInfoItem;
import com.tencent.token.core.gamelogin.GameLoginService;
import com.tencent.token.core.push.PushService;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.HelpActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.widget.TokenService;
import com.tencent.token.widget.TokenWidgetProvider;
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

public final class s
{
  static Date a = new Date();
  static Calendar b = Calendar.getInstance();
  static final short[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt);
    int i = localStringBuffer.length();
    paramInt = 0;
    while (paramInt < 2 - i)
    {
      localStringBuffer.insert(0, 0);
      paramInt += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(long paramLong)
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
    localStringBuffer.append('-');
    if (i < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(i);
    localStringBuffer.append('-');
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
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      e.b("androidID =" + paramContext);
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
    int i = 0;
    if (paramString.length() < 5) {
      return paramString;
    }
    String str = paramString.substring(0, 3);
    while (i < paramString.length() - 5)
    {
      str = str + '*';
      i += 1;
    }
    return str + paramString.substring(paramString.length() - 2, paramString.length());
  }
  
  private static String a(Calendar paramCalendar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramCalendar.get(1)).append('-').append(a(paramCalendar.get(2) + 1)).append('-').append(a(paramCalendar.get(5)));
    return localStringBuffer.toString();
  }
  
  public static String a(List paramList, String[] paramArrayOfString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ques_id_0", ((UpgradeDeterminResult.QuesInfoItem)paramList.get(0)).mId);
      localJSONObject.put("answer_0", paramArrayOfString[0]);
      localJSONObject.put("ques_id_1", ((UpgradeDeterminResult.QuesInfoItem)paramList.get(1)).mId);
      localJSONObject.put("answer_1", paramArrayOfString[1]);
      localJSONObject.put("ques_id_2", ((UpgradeDeterminResult.QuesInfoItem)paramList.get(2)).mId);
      localJSONObject.put("answer_2", paramArrayOfString[2]);
      paramList = localJSONObject.toString();
      e.a("plain: " + paramList);
      paramList = b(paramList.getBytes());
      return paramList;
    }
    catch (JSONException paramList) {}
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      k = j / 16;
      j -= k * 16;
      char c1;
      if (k > 9)
      {
        c1 = (char)(k - 10 + 65);
        label73:
        if (j <= 9) {
          break label166;
        }
      }
      label166:
      for (char c2 = (char)(j - 10 + 65);; c2 = (char)(j + 48))
      {
        String str = "" + Character.valueOf(c1).toString();
        localStringBuffer.append(str + Character.valueOf(c2).toString());
        i += 1;
        break;
        c1 = (char)(k + 48);
        break label73;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0)
    {
      e.c("params count % 2 should be 0");
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
      e.a("plain data: " + paramVarArgs);
      paramVarArgs = b(paramVarArgs.getBytes());
      return paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  public static void a(int paramInt, TextView paramTextView1, TextView paramTextView2)
  {
    if (paramInt == 86)
    {
      paramTextView1.setText(2131362402);
      paramTextView2.setText(2131362403);
    }
    do
    {
      return;
      if (paramInt == 852)
      {
        paramTextView1.setText(2131362404);
        paramTextView2.setText(2131362405);
        return;
      }
      if (paramInt == 853)
      {
        paramTextView1.setText(2131362406);
        paramTextView2.setText(2131362407);
        return;
      }
      if (paramInt == 886)
      {
        paramTextView1.setText(2131362408);
        paramTextView2.setText(2131362409);
        return;
      }
      if (paramInt == 1111)
      {
        paramTextView1.setText(2131362410);
        paramTextView2.setText(2131362411);
        return;
      }
      if (paramInt == 81)
      {
        paramTextView1.setText(2131362412);
        paramTextView2.setText(2131362413);
        return;
      }
      if (paramInt == 82)
      {
        paramTextView1.setText(2131362414);
        paramTextView2.setText(2131362415);
        return;
      }
      if (paramInt == 65)
      {
        paramTextView1.setText(2131362416);
        paramTextView2.setText(2131362417);
        return;
      }
      if (paramInt == 1)
      {
        paramTextView1.setText(2131362418);
        paramTextView2.setText(2131362419);
        return;
      }
      if (paramInt == 61)
      {
        paramTextView1.setText(2131362420);
        paramTextView2.setText(2131362421);
        return;
      }
      if (paramInt == 39)
      {
        paramTextView1.setText(2131362422);
        paramTextView2.setText(2131362423);
        return;
      }
      if (paramInt == 60)
      {
        paramTextView1.setText(2131362424);
        paramTextView2.setText(2131362425);
        return;
      }
      if (paramInt == 63)
      {
        paramTextView1.setText(2131362426);
        paramTextView2.setText(2131362427);
        return;
      }
      if (paramInt == 66)
      {
        paramTextView1.setText(2131362428);
        paramTextView2.setText(2131362429);
        return;
      }
    } while (paramInt != 62);
    paramTextView1.setText(2131362430);
    paramTextView2.setText(2131362431);
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
        localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2130968583), Integer.valueOf(2130968586) });
        return;
      }
    }
    catch (Exception paramActivity)
    {
      e.c(paramActivity.toString());
      return;
    }
    localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(2130968585), Integer.valueOf(2130968584) });
    return;
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
      paramBaseActivity.showToast(2131361798);
    }
    try
    {
      paramBaseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramBaseActivity)
    {
      paramBaseActivity.printStackTrace();
      e.b(paramBaseActivity.toString());
    }
  }
  
  public static void a(IndexActivity paramIndexActivity, String paramString)
  {
    if (paramString == null) {
      paramIndexActivity.showToast(2131361798);
    }
    try
    {
      paramIndexActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramIndexActivity)
    {
      paramIndexActivity.printStackTrace();
      e.b(paramIndexActivity.toString());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = RqdApplication.i();
    if (!TextUtils.isEmpty(null))
    {
      localObject = ((Context)localObject).getSharedPreferences(null + paramString, 0).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences(paramString, 0).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Context localContext = RqdApplication.i();
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
    Object localObject = (ConnectivityManager)RqdApplication.i().getSystemService("connectivity");
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
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    for (;;)
    {
      n = k - 1;
      int i1 = i;
      if (k > 0)
      {
        i = j + 1;
        j = paramArrayOfByte[j];
        i1 = j;
        if (j != 0)
        {
          i1 = j;
          if (j != 95)
          {
            k = j;
            if (j == 32) {
              k = 42;
            }
            j = c[k];
            if (j < 0) {
              break label309;
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
          }
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
        return null;
        i = paramInt + 1;
        arrayOfByte[i] = 0;
      }
      label309:
      k = n;
      n = i;
      i = j;
      j = n;
    }
  }
  
  public static String b(long paramLong)
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
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      e.b("deviceId =" + paramContext);
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
    if (paramString.length() < 3) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer("12******9");
    localStringBuffer.replace(0, 2, paramString.substring(0, 2));
    localStringBuffer.replace(8, 9, paramString.substring(paramString.length() - 1, paramString.length()));
    return localStringBuffer.toString();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = ax.a().c();
    if ((arrayOfByte == null) || (arrayOfByte.length != 16))
    {
      if (arrayOfByte == null) {}
      for (boolean bool = true;; bool = false)
      {
        e.a(bool);
        return null;
      }
    }
    paramArrayOfByte = new a().b(paramArrayOfByte, arrayOfByte);
    if (paramArrayOfByte == null)
    {
      e.c("encrypt pwd failed");
      return null;
    }
    return ap.a(paramArrayOfByte);
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
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, HelpActivity.class);
    localIntent.putExtra("help_url", paramString1);
    localIntent.putExtra("help_title", paramString2);
    localIntent.putExtra("h5_scene", 0);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean b()
  {
    return RqdApplication.c == 1;
  }
  
  public static String c(long paramLong)
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
      return com.tencent.token.global.b.e().getResources().getString(2131362023);
    }
    if ((i == k) && (j == m + 1)) {
      return com.tencent.token.global.b.e().getResources().getString(2131362024);
    }
    if ((i == k) && (j <= m + 6))
    {
      switch (n)
      {
      default: 
        return a(b);
      case 1: 
        return com.tencent.token.global.b.e().getResources().getString(2131362031);
      case 2: 
        return com.tencent.token.global.b.e().getResources().getString(2131362025);
      case 3: 
        return com.tencent.token.global.b.e().getResources().getString(2131362026);
      case 4: 
        return com.tencent.token.global.b.e().getResources().getString(2131362027);
      case 5: 
        return com.tencent.token.global.b.e().getResources().getString(2131362028);
      case 6: 
        return com.tencent.token.global.b.e().getResources().getString(2131362029);
      }
      return com.tencent.token.global.b.e().getResources().getString(2131362030);
    }
    return a(b);
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      e.b("mac =" + paramContext);
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
  
  /* Error */
  public static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 103	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: invokevirtual 565	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 571	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_3
    //   15: new 573	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: ldc_w 575
    //   23: iconst_0
    //   24: invokevirtual 579	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   27: aload_1
    //   28: invokespecial 582	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 585	java/io/File:exists	()Z
    //   38: ifeq +30 -> 68
    //   41: aload 5
    //   43: invokevirtual 588	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: astore_0
    //   47: aload_0
    //   48: astore_1
    //   49: aload_3
    //   50: ifnull +9 -> 59
    //   53: aload_3
    //   54: invokevirtual 593	java/io/InputStream:close	()V
    //   57: aload_0
    //   58: astore_1
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: new 595	java/io/FileOutputStream
    //   71: dup
    //   72: aload 5
    //   74: invokespecial 598	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: aload_0
    //   79: astore 4
    //   81: aload_3
    //   82: astore_1
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore 7
    //   90: aload_0
    //   91: astore 4
    //   93: aload_3
    //   94: astore_1
    //   95: aload_3
    //   96: aload 7
    //   98: invokevirtual 602	java/io/InputStream:read	([B)I
    //   101: istore_2
    //   102: iload_2
    //   103: iconst_m1
    //   104: if_icmpeq +59 -> 163
    //   107: aload_0
    //   108: astore 4
    //   110: aload_3
    //   111: astore_1
    //   112: aload_0
    //   113: aload 7
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 606	java/io/FileOutputStream:write	([BII)V
    //   120: goto -30 -> 90
    //   123: astore 5
    //   125: aload_0
    //   126: astore 4
    //   128: aload_3
    //   129: astore_1
    //   130: aload 5
    //   132: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 593	java/io/InputStream:close	()V
    //   143: aload 6
    //   145: astore_1
    //   146: aload_0
    //   147: ifnull -88 -> 59
    //   150: aload_0
    //   151: invokevirtual 607	java/io/FileOutputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   161: aconst_null
    //   162: areturn
    //   163: aload_0
    //   164: astore 4
    //   166: aload_3
    //   167: astore_1
    //   168: aload 5
    //   170: invokevirtual 588	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: astore 5
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 593	java/io/InputStream:close	()V
    //   183: aload_0
    //   184: invokevirtual 607	java/io/FileOutputStream:close	()V
    //   187: aload 5
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   195: aload 5
    //   197: areturn
    //   198: astore_0
    //   199: aconst_null
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 593	java/io/InputStream:close	()V
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 607	java/io/FileOutputStream:close	()V
    //   222: aload_0
    //   223: athrow
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   229: goto -7 -> 222
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 4
    //   236: aload_3
    //   237: astore_1
    //   238: goto -34 -> 204
    //   241: astore_0
    //   242: goto -38 -> 204
    //   245: astore 5
    //   247: aconst_null
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_3
    //   251: goto -126 -> 125
    //   254: astore 5
    //   256: aconst_null
    //   257: astore_0
    //   258: goto -133 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramString	String
    //   101	16	2	i	int
    //   14	237	3	localInputStream	java.io.InputStream
    //   79	156	4	localContext	Context
    //   31	42	5	localFile	java.io.File
    //   123	46	5	localException1	Exception
    //   173	23	5	str	String
    //   245	1	5	localException2	Exception
    //   254	1	5	localException3	Exception
    //   1	143	6	localObject	Object
    //   88	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	57	61	java/lang/Exception
    //   83	90	123	java/lang/Exception
    //   95	102	123	java/lang/Exception
    //   112	120	123	java/lang/Exception
    //   168	175	123	java/lang/Exception
    //   139	143	156	java/lang/Exception
    //   150	154	156	java/lang/Exception
    //   179	183	190	java/lang/Exception
    //   183	187	190	java/lang/Exception
    //   3	15	198	finally
    //   208	212	224	java/lang/Exception
    //   217	222	224	java/lang/Exception
    //   15	47	232	finally
    //   68	78	232	finally
    //   83	90	241	finally
    //   95	102	241	finally
    //   112	120	241	finally
    //   130	135	241	finally
    //   168	175	241	finally
    //   3	15	245	java/lang/Exception
    //   15	47	254	java/lang/Exception
    //   68	78	254	java/lang/Exception
  }
  
  public static String c(String paramString)
  {
    int k = paramString.length();
    int i = 0;
    while (i < k)
    {
      char c1 = paramString.charAt(i);
      if (!Character.isLetterOrDigit(c1)) {
        switch (c1)
        {
        }
      }
      for (int j = 0; j == 0; j = 1) {
        return "B" + b.a(paramString.getBytes());
      }
      i += 1;
    }
    return "A" + paramString;
  }
  
  public static boolean c()
  {
    Object localObject = (ActivityManager)RqdApplication.i().getSystemService("activity");
    String str = RqdApplication.i().getPackageName();
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
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = ax.a().c();
    boolean bool;
    if ((arrayOfByte == null) || (arrayOfByte.length != 16)) {
      if (arrayOfByte == null)
      {
        bool = true;
        e.a(bool);
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
    e.c("encrypt pwd failed");
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
      e.b("bssid =" + paramContext);
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
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)RqdApplication.i().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject == null) {
      return false;
    }
    localObject = ((ComponentName)localObject).getPackageName();
    String str = RqdApplication.i().getPackageName();
    if (localObject == null) {
      return false;
    }
    return (((String)localObject).length() > 0) && (str.equals(localObject));
  }
  
  public static byte[] d(String paramString)
  {
    byte[] arrayOfByte = ax.a().c();
    if ((arrayOfByte == null) || (arrayOfByte.length != 16))
    {
      if (arrayOfByte == null) {}
      for (boolean bool = true;; bool = false)
      {
        e.a(bool);
        return null;
      }
    }
    try
    {
      paramString = new a().a(ap.a(paramString), arrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
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
  
  public static boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    try
    {
      Object localObject = RqdApplication.i();
      bool1 = bool3;
      if (ax.a().e() == null) {
        return false;
      }
      bool1 = bool3;
      String str = String.valueOf(ax.a().e().mUin);
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
  
  public static byte[] e(String paramString)
  {
    e.a("data hex: " + paramString);
    try
    {
      paramString = new a().a(ap.a(paramString), ag.c().f());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
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
      str = ap.a(MD5.toMD5Byte(Long.toString(paramLong)));
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
      paramLong += (1L << j);
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
  
  public static boolean f()
  {
    boolean bool2 = false;
    List localList = ((ActivityManager)RqdApplication.i().getSystemService("activity")).getRunningServices(50);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < localList.size())
      {
        if (((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals("com.tencent.token.core.gamelogin.GameLoginService"))
        {
          e.c("game login: " + ((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName());
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
    String str = f(paramString);
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
  
  public static void g()
  {
    Context localContext = RqdApplication.i();
    Object localObject2 = AppWidgetManager.getInstance(localContext);
    ComponentName localComponentName = new ComponentName(localContext, TokenWidgetProvider.class);
    Object localObject1 = null;
    try
    {
      localObject2 = ((AppWidgetManager)localObject2).getAppWidgetIds(localComponentName);
      localObject1 = localObject2;
      e.a("widget_big num=" + localObject2.length);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        int i = 0;
      }
    }
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      i = 1;
      if ((i != 0) && (!m())) {
        localContext.startService(new Intent(localContext, TokenService.class));
      }
      if (!n()) {
        localContext.startService(new Intent(localContext, PushService.class));
      }
      return;
    }
  }
  
  public static void h()
  {
    Intent localIntent = new Intent(RqdApplication.i(), GameLoginService.class);
    RqdApplication.i().stopService(localIntent);
  }
  
  public static void h(String paramString)
  {
    Object localObject = RqdApplication.i();
    if (!TextUtils.isEmpty(null))
    {
      localObject = ((Context)localObject).getSharedPreferences(null + paramString, 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, true);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences(paramString, 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramString, true);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static String i()
  {
    Object localObject = RqdApplication.i();
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
  
  public static boolean i(String paramString)
  {
    Context localContext = RqdApplication.i();
    if (!TextUtils.isEmpty(null)) {
      return localContext.getSharedPreferences(null + paramString, 0).getBoolean(paramString, false);
    }
    return localContext.getSharedPreferences(paramString, 0).getBoolean(paramString, false);
  }
  
  public static int j(String paramString)
  {
    Context localContext = RqdApplication.i();
    if (!TextUtils.isEmpty(null)) {
      return localContext.getSharedPreferences(null + paramString, 0).getInt(paramString, 0);
    }
    return localContext.getSharedPreferences(paramString, 0).getInt(paramString, 0);
  }
  
  public static String j()
  {
    try
    {
      Object localObject = RqdApplication.i();
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
  public static String k()
  {
    // Byte code:
    //   0: new 838	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 839	java/util/ArrayList:<init>	()V
    //   7: astore_0
    //   8: new 841	java/io/DataInputStream
    //   11: dup
    //   12: invokestatic 401	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   15: invokevirtual 103	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 565	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: ldc_w 843
    //   24: invokevirtual 571	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: invokespecial 846	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 849	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +55 -> 92
    //   40: aload_2
    //   41: invokevirtual 201	java/lang/String:length	()I
    //   44: iconst_1
    //   45: if_icmple -14 -> 31
    //   48: aload_2
    //   49: invokevirtual 851	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   52: ldc_w 853
    //   55: invokevirtual 855	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   58: iflt -27 -> 31
    //   61: aload_0
    //   62: aload_2
    //   63: ldc_w 853
    //   66: invokevirtual 201	java/lang/String:length	()I
    //   69: invokevirtual 758	java/lang/String:substring	(I)Ljava/lang/String;
    //   72: invokevirtual 858	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: goto -45 -> 31
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   84: aload_1
    //   85: invokevirtual 859	java/io/DataInputStream:close	()V
    //   88: ldc_w 861
    //   91: areturn
    //   92: aload_0
    //   93: invokevirtual 862	java/util/ArrayList:size	()I
    //   96: ifle +27 -> 123
    //   99: aload_0
    //   100: aload_0
    //   101: invokevirtual 862	java/util/ArrayList:size	()I
    //   104: iconst_1
    //   105: isub
    //   106: invokevirtual 863	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   109: checkcast 200	java/lang/String
    //   112: astore_0
    //   113: aload_1
    //   114: invokevirtual 859	java/io/DataInputStream:close	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: goto -32 -> 88
    //   123: ldc_w 861
    //   126: astore_0
    //   127: goto -14 -> 113
    //   130: astore_0
    //   131: aload_1
    //   132: invokevirtual 859	java/io/DataInputStream:close	()V
    //   135: aload_0
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	55	0	localArrayList	java.util.ArrayList
    //   79	22	0	localException	Exception
    //   112	6	0	str1	String
    //   119	1	0	localIOException	java.io.IOException
    //   126	1	0	str2	String
    //   130	6	0	localObject	Object
    //   30	102	1	localDataInputStream	java.io.DataInputStream
    //   35	28	2	str3	String
    // Exception table:
    //   from	to	target	type
    //   31	36	79	java/lang/Exception
    //   40	76	79	java/lang/Exception
    //   92	113	79	java/lang/Exception
    //   0	31	119	java/io/IOException
    //   84	88	119	java/io/IOException
    //   113	117	119	java/io/IOException
    //   131	137	119	java/io/IOException
    //   31	36	130	finally
    //   40	76	130	finally
    //   80	84	130	finally
    //   92	113	130	finally
  }
  
  public static int l()
  {
    return Build.VERSION.SDK_INT;
  }
  
  private static boolean m()
  {
    boolean bool2 = false;
    List localList = ((ActivityManager)RqdApplication.i().getSystemService("activity")).getRunningServices(50);
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
  
  private static boolean n()
  {
    List localList = ((ActivityManager)RqdApplication.i().getSystemService("activity")).getRunningServices(50);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.s
 * JD-Core Version:    0.7.0.1
 */