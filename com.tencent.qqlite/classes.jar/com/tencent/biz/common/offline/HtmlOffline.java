package com.tencent.biz.common.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.webviewplugin.MyFileInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import li;
import lj;
import lk;
import ll;
import lm;
import org.json.JSONException;
import org.json.JSONObject;

public class HtmlOffline
{
  public static final int A = 1;
  public static final int B = 0;
  public static final int C = 1;
  public static final int D = 2;
  public static final int E = 3;
  public static final int F = 0;
  public static final int G = 1;
  protected static final int H = 0;
  public static final int a = 0;
  public static final String a = "updateNotification";
  protected static ArrayList a;
  protected static HashMap a;
  protected static final String[] a;
  public static final int b = 1;
  public static final String b = "wording";
  protected static final String[] b = { "0", "1" };
  public static final int c = 2;
  public static final String c = "wifiUpdatingText";
  public static final int d = 3;
  public static final String d = "nonWifiUpdatingText";
  public static final int e = 4;
  public static final String e = "updateCompletedText";
  public static final int f = 5;
  public static final String f = "expirelist";
  public static final int g = 6;
  public static final String g = "bid";
  public static final int h = 7;
  public static final String h = "expired";
  public static final int i = 8;
  public static final String i = "tencent/QQLite/qbiz/";
  public static final int j = 9;
  public static final String j = "tencent/QQLite/qbiz/html5/";
  public static final int k = -1;
  protected static String k = "qbiz/";
  protected static final int l = 30;
  public static String l;
  protected static final int m = 1;
  protected static String m;
  protected static final int n = 5;
  protected static String n;
  protected static final int o = 60;
  protected static String o;
  public static final int p = 0;
  protected static final String p = "config.json";
  public static final int q = 2;
  protected static final String q = "local_html";
  public static final int r = 3;
  protected static final String r = "http://s.p.qq.com/pub/check_bizup";
  public static final int s = 4;
  protected static final String s = "HtmlCheckUpdate";
  public static final int t = 5;
  public static final String t = "QQBrowserOffline";
  public static final int u = 6;
  protected static final String u = "OfflineCheckFile";
  public static final int v = 7;
  public static final int w = 8;
  public static final int x = 9;
  public static final int y = 10;
  public static final int z = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "config.json", "verify.json", "verify.signature" };
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getInt("expire_" + paramString, 0);
  }
  
  protected static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getLong("last_up_" + paramString, 0L);
  }
  
  @SuppressLint({"NewApi"})
  public static WebResourceResponse a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http"))) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = a(paramString1);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      paramString1 = (String)localObject + paramString1;
      paramString2 = g(paramString2);
      paramString1 = paramString1 + "/" + paramString2;
      if (new File(paramString1).exists()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString2);
    return null;
    for (;;)
    {
      try
      {
        localObject = new MyFileInputStream(paramString1);
        paramString1 = "text/html";
        if (!paramString2.contains(".css")) {
          break label248;
        }
        paramString1 = "text/css";
        if (QLog.isDevelopLevel()) {
          QLog.i("HtmlCheckUpdate", 4, "getResponse ****************** :" + paramString2);
        }
        return new WebResourceResponse(paramString1, "utf-8", (InputStream)localObject);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 4, "getResponse get local file fail:" + paramString2);
      return null;
      label248:
      if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      str = d(str + "tencent/QQLite/qbiz/" + "html5/");
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str);
      }
    }
    Object localObject2 = null;
    try
    {
      str = BaseApplicationImpl.getContext().getFilesDir().toString() + File.separator + k;
      if (!TextUtils.isEmpty(str))
      {
        str = d(str + "html5/");
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuffer.length() > 0) {
            localStringBuffer.append(",");
          }
          localStringBuffer.append(str);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("HtmlCheckUpdate", 2, "getLocalOfflineVersions getFilesDir error");
          localObject1 = localObject2;
        }
      }
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc_w 302
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 306	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_0
    //   10: invokevirtual 309	android/content/Context:getPackageName	()Ljava/lang/String;
    //   13: iconst_0
    //   14: invokevirtual 315	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   17: getfield 320	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   20: astore 5
    //   22: aload 5
    //   24: astore 4
    //   26: ldc_w 302
    //   29: astore 5
    //   31: getstatic 325	android/os/Build:BRAND	Ljava/lang/String;
    //   34: ldc_w 327
    //   37: invokestatic 333	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 5
    //   46: ldc_w 302
    //   49: astore 6
    //   51: getstatic 336	android/os/Build:MODEL	Ljava/lang/String;
    //   54: ldc_w 327
    //   57: invokestatic 333	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 7
    //   62: aload 7
    //   64: astore 6
    //   66: ldc_w 302
    //   69: astore 7
    //   71: getstatic 341	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   74: ldc_w 327
    //   77: invokestatic 333	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 8
    //   82: aload 8
    //   84: astore 7
    //   86: new 240	java/lang/StringBuffer
    //   89: dup
    //   90: ldc 74
    //   92: invokespecial 342	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   95: astore 8
    //   97: aload 8
    //   99: ldc_w 344
    //   102: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   105: aload 4
    //   107: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   110: pop
    //   111: aload 8
    //   113: ldc_w 346
    //   116: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   119: aload_1
    //   120: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 8
    //   126: ldc_w 348
    //   129: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: aload_2
    //   133: invokevirtual 351	java/lang/String:trim	()Ljava/lang/String;
    //   136: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: aload 8
    //   142: ldc_w 353
    //   145: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   148: getstatic 356	android/os/Build$VERSION:SDK_INT	I
    //   151: invokevirtual 359	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   154: pop
    //   155: aload 8
    //   157: ldc_w 361
    //   160: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   163: aload 7
    //   165: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: pop
    //   169: aload 8
    //   171: ldc_w 363
    //   174: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   177: aload 5
    //   179: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: aload 8
    //   185: ldc_w 365
    //   188: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   191: aload 6
    //   193: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload 8
    //   199: ldc_w 367
    //   202: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   205: pop
    //   206: aload 8
    //   208: ldc_w 369
    //   211: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: aload_3
    //   215: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload 8
    //   221: ldc_w 371
    //   224: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   227: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 380	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   233: pop
    //   234: aload 8
    //   236: ldc_w 382
    //   239: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   242: ldc_w 384
    //   245: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   248: ldc_w 386
    //   251: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   254: ldc_w 388
    //   257: invokevirtual 269	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   260: pop
    //   261: new 390	android/os/Bundle
    //   264: dup
    //   265: invokespecial 391	android/os/Bundle:<init>	()V
    //   268: astore_1
    //   269: invokestatic 393	com/tencent/biz/common/offline/HtmlOffline:a	()Ljava/lang/String;
    //   272: astore_2
    //   273: aload_2
    //   274: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne +11 -> 288
    //   280: aload_1
    //   281: ldc_w 395
    //   284: aload_2
    //   285: invokevirtual 399	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: aload 8
    //   291: invokevirtual 288	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   294: ldc_w 401
    //   297: aload_1
    //   298: aconst_null
    //   299: invokestatic 406	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   302: astore_0
    //   303: aload_0
    //   304: areturn
    //   305: astore 5
    //   307: aload 5
    //   309: invokevirtual 407	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   312: goto -286 -> 26
    //   315: astore 5
    //   317: aload 5
    //   319: invokevirtual 291	java/lang/Exception:printStackTrace	()V
    //   322: goto -296 -> 26
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 408	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   330: ldc_w 410
    //   333: astore_0
    //   334: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq -34 -> 303
    //   340: ldc 77
    //   342: iconst_2
    //   343: ldc_w 412
    //   346: invokestatic 175	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: ldc_w 410
    //   352: areturn
    //   353: astore_0
    //   354: aload_0
    //   355: invokevirtual 413	java/io/IOException:printStackTrace	()V
    //   358: ldc_w 415
    //   361: astore_0
    //   362: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -62 -> 303
    //   368: ldc 77
    //   370: iconst_2
    //   371: ldc_w 417
    //   374: invokestatic 175	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: ldc_w 415
    //   380: areturn
    //   381: astore 8
    //   383: goto -297 -> 86
    //   386: astore 7
    //   388: goto -322 -> 66
    //   391: astore 6
    //   393: goto -347 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramContext	Context
    //   0	396	1	paramString1	String
    //   0	396	2	paramString2	String
    //   0	396	3	paramString3	String
    //   3	103	4	localObject1	Object
    //   20	158	5	localObject2	Object
    //   305	3	5	localNameNotFoundException	PackageManager.NameNotFoundException
    //   315	3	5	localException1	Exception
    //   40	152	6	localObject3	Object
    //   391	1	6	localException2	Exception
    //   60	104	7	localObject4	Object
    //   386	1	7	localException3	Exception
    //   80	210	8	localObject5	Object
    //   381	1	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   5	22	305	android/content/pm/PackageManager$NameNotFoundException
    //   5	22	315	java/lang/Exception
    //   288	303	325	org/apache/http/client/ClientProtocolException
    //   288	303	353	java/io/IOException
    //   71	82	381	java/lang/Exception
    //   51	62	386	java/lang/Exception
    //   31	42	391	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return l;
    }
    return n;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1.contains("#"))
    {
      String[] arrayOfString = paramString1.split("\\#");
      String str = arrayOfString[0];
      paramString1 = "";
      int i1 = 1;
      int i2 = arrayOfString.length;
      while (i1 < i2)
      {
        paramString1 = paramString1 + "#" + arrayOfString[i1];
        i1 += 1;
      }
      if (str.contains("?")) {
        return str.replace("?", new StringBuilder().append("?").append(paramString2).append("&").toString()) + paramString1;
      }
      return str + "?" + paramString2 + paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
    return paramString1 + "?" + paramString2;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 122	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 182
    //   26: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 68
    //   31: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 122	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 264
    //   48: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 446	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 452	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 457	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 462	java/io/InputStream:close	()V
    //   77: new 464	org/json/JSONObject
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 465	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 466	org/json/JSONException:printStackTrace	()V
    //   93: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +12 -> 108
    //   99: ldc 77
    //   101: iconst_2
    //   102: ldc_w 468
    //   105: invokestatic 175	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 413	java/io/IOException:printStackTrace	()V
    //   118: goto -41 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   77	86	88	org/json/JSONException
    //   59	68	110	java/io/IOException
    //   73	77	113	java/io/IOException
  }
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str = a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = new File(str + paramString + "/" + "config.json");
        if (paramString.exists()) {
          try
          {
            paramString = new FileInputStream(paramString);
            if (paramString != null)
            {
              str = Util.a(paramString);
              if (TextUtils.isEmpty(str)) {}
            }
          }
          catch (IOException paramString)
          {
            try
            {
              paramString.close();
              try
              {
                paramString = new JSONObject(str);
                return paramString;
              }
              catch (JSONException paramString)
              {
                paramString.printStackTrace();
              }
              paramString = paramString;
              paramString.printStackTrace();
              paramString = null;
            }
            catch (IOException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "last_up_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "expire_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    a(paramContext, paramString1, paramString2, true, new lj());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, LoadedBack paramLoadedBack)
  {
    if (paramLoadedBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramLoadedBack.a(1, null);
      return;
    }
    String str = b(paramString1);
    if (TextUtils.isEmpty(str))
    {
      paramLoadedBack.a(3, null);
      return;
    }
    JSONObject localJSONObject = a(paramString1);
    if (localJSONObject != null)
    {
      l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramLoadedBack.a(5, null);
        return;
      }
    }
    if (e(paramString1))
    {
      paramLoadedBack.a(7, null);
      return;
    }
    a(paramString1);
    str = str + paramString1 + ".zip";
    long l1 = System.currentTimeMillis();
    OfflineDownloader.a(paramContext, MsfSdkUtils.insertMtype("qb_offline", paramString2), paramInt, paramString1, str, new lm(l1, paramContext, paramString1, paramLoadedBack));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack)
  {
    if (paramLoadedBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramLoadedBack.a(1, null);
      return;
    }
    a(paramContext, paramString1, paramString2, false, paramLoadedBack);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "addDownloadToQueue: add to queue:" + paramString1);
    }
    int i2 = jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramString1.equals(((HtmlOffline.LoadQueue)jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString)) {
        return;
      }
      i1 += 1;
    }
    paramContext = new HtmlOffline.LoadQueue(paramContext, paramString1, paramString2, paramLoadedBack, paramBoolean);
    jdField_a_of_type_JavaUtilArrayList.add(paramContext);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean, int paramInt)
  {
    if (paramLoadedBack == null) {}
    do
    {
      return;
      if (!a(paramString1))
      {
        paramLoadedBack.a(3, null);
        return;
      }
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
      {
        paramLoadedBack.a(1, null);
        return;
      }
    } while ((Arrays.asList(b).contains(paramString1)) || (paramInt > 60) || (paramInt < 0));
    JSONObject localJSONObject = a(paramString1);
    if (localJSONObject != null)
    {
      long l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramLoadedBack.a(5, null);
        return;
      }
    }
    if (e(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, paramString1 + " is downloading");
      }
      paramLoadedBack.a(7, null);
      return;
    }
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.size() >= 1))
    {
      a(paramContext, paramString1, paramString2, paramLoadedBack, paramBoolean);
      return;
    }
    a(paramString1);
    new lk(paramInt, paramString1, paramContext, paramString2, paramLoadedBack, paramBoolean).start();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, LoadedCallBack paramLoadedCallBack)
  {
    b(paramContext, Uri.parse(paramString1).getQueryParameter("_bid"), paramString2, paramLoadedCallBack);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, LoadedBack paramLoadedBack)
  {
    if (paramLoadedBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramLoadedBack.a(1, null);
      return;
    }
    String str = Uri.parse(paramString1).getQueryParameter("_bid");
    int i2 = AuthorizeConfig.a().a(paramString1);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 5;
    }
    a(paramContext, str, paramString2, paramLoadedBack, paramBoolean, i1);
  }
  
  protected static void a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "addDownloadingState:" + paramString);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      int i1 = 0;
      try
      {
        i2 = Integer.valueOf(paramString1).intValue();
        i1 = i2;
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          int i2;
          continue;
          paramString1 = paramString3;
        }
      }
      if (paramString3 != null) {
        break label204;
      }
      paramString1 = "";
      paramString3 = "";
      try
      {
        String str = BaseApplicationImpl.a().getPackageManager().getPackageInfo(BaseApplicationImpl.a().getPackageName(), 0).versionName;
        paramString3 = str;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      i2 = paramInt2;
      if (paramInt2 == -1) {
        i2 = OfflineDownloader.a(BaseApplicationImpl.getContext());
      }
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, i1, paramInt1, "" + paramLong, "3", "" + i2, paramString1);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "reportDownTime: " + paramString3);
  }
  
  public static boolean a(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (paramContext == null)
    {
      a(str, 3, 0L, 4, "lixian_cover", "0");
      return false;
    }
    if (!a(str))
    {
      a(str, 2, 0L, OfflineDownloader.a(paramContext), "lixian_cover", "0");
      return false;
    }
    if (Arrays.asList(b).contains(str))
    {
      a(str, 4, 0L, OfflineDownloader.a(paramContext), "lixian_cover", "0");
      return false;
    }
    new li(paramContext, paramString, paramAsyncCallBack).start();
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte[4096];
      for (;;)
      {
        int i1 = paramContext.read(paramString2);
        if (i1 == -1)
        {
          paramString1.flush();
          paramContext.close();
          paramString1.close();
          return true;
        }
        paramString1.write(paramString2, 0, i1);
      }
      return false;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (!b(paramString)) {
        break label203;
      }
      if (Environment.getExternalStorageState().equals("mounted")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "no sd");
    return false;
    paramString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    paramString = paramString + "tencent/QQLite/qbiz/";
    Object localObject = paramString + "html5/";
    l = (String)localObject;
    m = paramString + "tmp/";
    for (;;)
    {
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        break;
      }
      paramString = new File(paramString + "tmp/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return true;
      try
      {
        label203:
        localObject = BaseApplicationImpl.getContext().getFilesDir().toString() + File.separator + k;
        paramString = (String)localObject;
        localObject = paramString + "html5/";
        n = (String)localObject;
        o = paramString + "tmp/";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getFilesDir error");
        }
        a(paramString, 0, 0L, -1, "lixian_error", "0");
      }
    }
    return false;
  }
  
  protected static boolean a(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    int i1 = 0;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    do
    {
      return false;
      paramString = paramString.listFiles();
    } while (paramString == null);
    List localList = Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString);
    if (i1 < paramString.length)
    {
      if (paramString[i1] == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        try
        {
          String str1 = paramString[i1].getCanonicalPath();
          if (!paramString[i1].isFile()) {
            break label181;
          }
          String str2 = paramString[i1].getName();
          if ((!TextUtils.isEmpty(str2)) && (localList.contains(str2))) {
            continue;
          }
          str1 = str1.substring(paramInt);
          try
          {
            paramJSONObject.get(str1);
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HtmlCheckUpdate", 2, " delete :" + str1);
            }
            paramString[i1].delete();
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        continue;
        label181:
        if (paramString[i1].isDirectory()) {
          a(localIOException, paramInt, paramJSONObject);
        }
      }
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
    }
    long l1;
    do
    {
      return false;
      String str = a(paramString1);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString1;
      if (!new File(str).exists()) {
        return true;
      }
      paramString2 = g(paramString2);
      l1 = System.currentTimeMillis();
      if (OfflineSecurity.c(paramString2, str, paramString1)) {
        break;
      }
      Util.a(str);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "verfySingleFile fail :" + paramString2);
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("OfflineCheckFile", 4, "verifyFile:time=" + (System.currentTimeMillis() - l1) + ", file:" + paramString2);
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return m;
    }
    return o;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack)
  {
    a(paramContext, paramString1, paramString2, paramLoadedBack, false, 5);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, LoadedCallBack paramLoadedCallBack)
  {
    if (paramLoadedCallBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramLoadedCallBack.a("{\"r\":-1}");
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "0";
    }
    for (;;)
    {
      new ll(a(paramString1), paramContext, paramString1, paramString2, paramLoadedCallBack).start();
      return;
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, LoadedBack paramLoadedBack)
  {
    a(paramContext, paramString1, paramString2, paramLoadedBack, paramBoolean, 5);
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      if (!jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    do
    {
      do
      {
        return;
        if (jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        }
      } while ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty()));
      paramString = (HtmlOffline.LoadQueue)jdField_a_of_type_JavaUtilArrayList.remove(0);
    } while (paramString.jdField_a_of_type_AndroidContentContext == null);
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "start checkUpByBusinessId from queue:" + paramString.jdField_a_of_type_JavaLangString);
    }
    a(paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_JavaLangString, paramString.b, paramString.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack, paramString.jdField_a_of_type_Boolean, 0);
  }
  
  protected static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          int i1 = Integer.valueOf(paramString).intValue();
          if ((i1 >= 1000) && (i1 < 2000)) {
            return false;
          }
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    return true;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return null;
        } while (!a(paramString));
        paramString = a(paramString);
      } while (paramString == null);
      l1 = System.currentTimeMillis();
      l2 = paramString.optLong("expired", 0L);
    } while ((l2 > 0L) && (l1 > l2));
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return false;
          str1 = b(paramString);
        } while (TextUtils.isEmpty(str1));
        str1 = str1 + paramString + ".zip";
        if (new File(str1).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("HtmlCheckUpdate", 2, "doUpdate: no zip ! : businessId:" + paramString);
      return false;
      str2 = a(paramString);
      str2 = str2 + paramString;
      File localFile = new File(str2);
      if ((localFile.exists()) || (localFile.mkdirs())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowserOffline", 2, "error : mkdirs: error:" + str2);
    return false;
    long l1 = System.currentTimeMillis();
    if (!ZipUtils.a(str1, str2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "unZipFolder fail!");
      }
      Util.a(str2);
      Util.b(str1);
      return false;
    }
    Util.b(str1);
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "time of unzip：" + (System.currentTimeMillis() - l1));
    }
    d(paramString);
    return true;
  }
  
  protected static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = 0;
        for (;;)
        {
          if (i1 < paramString.length)
          {
            Object localObject = paramString[i1];
            JSONObject localJSONObject;
            if ((localObject.isDirectory()) && (TextUtils.isDigitsOnly(localObject.getName())))
            {
              localJSONObject = a(localObject.getName());
              if (localJSONObject == null) {}
            }
            try
            {
              localStringBuffer.append(localObject.getName() + "|" + localJSONObject.getString("version") + ",");
              i1 += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  protected static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.i("HtmlCheckUpdate", 4, "checkOfflineFiles " + paramString);
      }
      localObject = a(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramString = (String)localObject + paramString + "/";
    try
    {
      localObject = new FileInputStream(new File(paramString + "verify.json"));
      JSONObject localJSONObject = new JSONObject(OfflineSecurity.a((InputStream)localObject));
      ((InputStream)localObject).close();
      a(paramString, paramString.length(), localJSONObject);
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String e(String paramString)
  {
    String str = "file://" + Environment.getExternalStorageDirectory().getPath() + "/" + "tencent/QQLite/qbiz/html5/";
    if ((paramString == null) || (!paramString.startsWith(str))) {
      return "";
    }
    paramString = paramString.substring(str.length());
    int i1 = paramString.indexOf('/');
    if (i1 <= 0) {
      return "";
    }
    try
    {
      Integer.parseInt(paramString.substring(0, i1), 10);
      paramString = paramString.substring(i1 + 1);
      if (paramString.length() > 0) {
        return "http://" + paramString;
      }
    }
    catch (NumberFormatException paramString)
    {
      return "";
    }
    return "";
  }
  
  protected static boolean e(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    while (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
    }
    do
    {
      return false;
      String str = a(paramString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString;
      if (!new File(str).exists()) {
        return true;
      }
      if (OfflineSecurity.b(str, paramString)) {
        return true;
      }
      Util.a(str);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "verfySign fail :" + paramString);
    return false;
  }
  
  private static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String[] arrayOfString = paramString.substring(paramString.indexOf(":") + 3).split("\\?");
    paramString = arrayOfString;
    if (arrayOfString[0].contains("#")) {
      paramString = arrayOfString[0].split("\\#");
    }
    return paramString[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline
 * JD-Core Version:    0.7.0.1
 */