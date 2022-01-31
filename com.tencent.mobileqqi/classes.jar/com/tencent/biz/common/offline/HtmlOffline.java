package com.tencent.biz.common.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import bhi;
import bhj;
import bhk;
import bhl;
import bhm;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.webviewplugin.MyFileInputStream;
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
import org.json.JSONException;
import org.json.JSONObject;

public class HtmlOffline
{
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
  public static final String f = "tencent/MobileQQ/qbiz/";
  public static final int g = 6;
  public static final String g = "tencent/MobileQQ/qbiz/html5/";
  public static final int h = 7;
  public static String h;
  public static final int i = 8;
  public static String i;
  public static final int j = -1;
  protected static final String j = "config.json";
  protected static final int k = 30;
  protected static final String k = "local_html";
  protected static final int l = 1;
  protected static final String l = "http://s.p.qq.com/pub/check_bizup";
  protected static final int m = 5;
  protected static final String m = "HtmlCheckUpdate";
  protected static final int n = 60;
  static final String n = "QQBrowserOffline";
  public static final int o = 0;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = 6;
  public static final int u = 7;
  
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
  public static WebResourceResponse a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http"))) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return null;
        } while ((h == null) && (!a()));
        if (!paramBoolean) {
          break;
        }
        str = h + paramString1;
        if (!new File(str).exists()) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("HtmlCheckUpdate", 4, "getResponse start VerifyFile :" + paramString1);
        }
        if (OfflineSecurity.a(str, paramString1)) {
          break;
        }
        Util.a(h + paramString1);
      } while (!QLog.isColorLevel());
      QLog.i("HtmlCheckUpdate", 2, "getResponse VerifyFile fail :" + paramString1);
      return null;
      paramString1 = h + paramString1 + "/";
      str = paramString2;
      if (paramString2.contains("#")) {
        str = paramString2.split("\\#")[0];
      }
      paramString2 = str.split("\\?");
      paramString1 = paramString1 + paramString2[0].replace("http://", "");
      if (new File(paramString1).exists()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString1);
    return null;
    for (;;)
    {
      try
      {
        paramString2 = new MyFileInputStream(paramString1);
        paramString1 = "text/html";
        if (!str.contains(".css")) {
          break label416;
        }
        paramString1 = "text/css";
        if (QLog.isDevelopLevel()) {
          QLog.i("HtmlCheckUpdate", 4, "getResponse ****************** :" + str);
        }
        return new WebResourceResponse(paramString1, "utf-8", paramString2);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 4, "getResponse get local file fail:" + str);
      return null;
      label416:
      if (str.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((str.contains(".jpg")) || (str.contains(".gif")) || (str.contains(".png")) || (str.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 195
    //   2: astore 4
    //   4: aload_0
    //   5: invokevirtual 252	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: aload_0
    //   9: invokevirtual 255	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: iconst_0
    //   13: invokevirtual 261	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: getfield 266	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   19: astore 5
    //   21: aload 5
    //   23: astore 4
    //   25: ldc 195
    //   27: astore 5
    //   29: getstatic 271	android/os/Build:BRAND	Ljava/lang/String;
    //   32: ldc_w 273
    //   35: invokestatic 279	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload 6
    //   42: astore 5
    //   44: ldc 195
    //   46: astore 6
    //   48: getstatic 282	android/os/Build:MODEL	Ljava/lang/String;
    //   51: ldc_w 273
    //   54: invokestatic 279	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 7
    //   59: aload 7
    //   61: astore 6
    //   63: ldc 195
    //   65: astore 7
    //   67: getstatic 287	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   70: ldc_w 273
    //   73: invokestatic 279	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 8
    //   78: aload 8
    //   80: astore 7
    //   82: new 289	java/lang/StringBuffer
    //   85: dup
    //   86: ldc 52
    //   88: invokespecial 290	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   91: astore 8
    //   93: aload 8
    //   95: ldc_w 292
    //   98: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: aload 4
    //   103: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload 8
    //   109: ldc_w 297
    //   112: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   115: aload_1
    //   116: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   119: pop
    //   120: aload 8
    //   122: ldc_w 299
    //   125: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: aload_2
    //   129: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   132: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload 8
    //   138: ldc_w 304
    //   141: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   144: getstatic 307	android/os/Build$VERSION:SDK_INT	I
    //   147: invokevirtual 310	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   150: pop
    //   151: aload 8
    //   153: ldc_w 312
    //   156: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: aload 7
    //   161: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: aload 8
    //   167: ldc_w 314
    //   170: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   173: aload 5
    //   175: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aload 8
    //   181: ldc_w 316
    //   184: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: aload 6
    //   189: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   192: pop
    //   193: aload 8
    //   195: ldc_w 318
    //   198: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   201: pop
    //   202: aload 8
    //   204: ldc_w 320
    //   207: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   210: aload_3
    //   211: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: aload 8
    //   217: ldc_w 322
    //   220: invokevirtual 295	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   223: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   226: invokevirtual 331	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   229: pop
    //   230: new 333	android/os/Bundle
    //   233: dup
    //   234: invokespecial 334	android/os/Bundle:<init>	()V
    //   237: astore_1
    //   238: aload_0
    //   239: aload 8
    //   241: invokevirtual 335	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   244: ldc_w 337
    //   247: aload_1
    //   248: aconst_null
    //   249: invokestatic 342	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   252: astore_0
    //   253: aload_0
    //   254: areturn
    //   255: astore 5
    //   257: aload 5
    //   259: invokevirtual 343	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   262: goto -237 -> 25
    //   265: astore 5
    //   267: aload 5
    //   269: invokevirtual 344	java/lang/Exception:printStackTrace	()V
    //   272: goto -247 -> 25
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 345	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   280: ldc_w 347
    //   283: astore_0
    //   284: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -34 -> 253
    //   290: ldc 55
    //   292: iconst_2
    //   293: ldc_w 349
    //   296: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: ldc_w 347
    //   302: areturn
    //   303: astore_0
    //   304: aload_0
    //   305: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   308: ldc_w 352
    //   311: astore_0
    //   312: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq -62 -> 253
    //   318: ldc 55
    //   320: iconst_2
    //   321: ldc_w 354
    //   324: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: ldc_w 352
    //   330: areturn
    //   331: astore 8
    //   333: goto -251 -> 82
    //   336: astore 7
    //   338: goto -275 -> 63
    //   341: astore 6
    //   343: goto -299 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramContext	Context
    //   0	346	1	paramString1	String
    //   0	346	2	paramString2	String
    //   0	346	3	paramString3	String
    //   2	100	4	localObject1	Object
    //   19	155	5	localObject2	Object
    //   255	3	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   265	3	5	localException1	Exception
    //   38	150	6	localObject3	Object
    //   341	1	6	localException2	Exception
    //   57	103	7	localObject4	Object
    //   336	1	7	localException3	Exception
    //   76	164	8	localObject5	Object
    //   331	1	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   4	21	255	android/content/pm/PackageManager$NameNotFoundException
    //   4	21	265	java/lang/Exception
    //   238	253	275	org/apache/http/client/ClientProtocolException
    //   238	253	303	java/io/IOException
    //   67	78	331	java/lang/Exception
    //   48	59	336	java/lang/Exception
    //   29	40	341	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while (!a());
      paramString = a(paramString);
    } while (paramString == null);
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
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
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
      return str + "?" + paramString2 + paramString1;
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
    //   5: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 95	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 178
    //   26: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 45
    //   31: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 95	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 375
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 379	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 385	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 388	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 393	java/io/InputStream:close	()V
    //   77: new 364	org/json/JSONObject
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 394	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 368	org/json/JSONException:printStackTrace	()V
    //   93: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +12 -> 108
    //   99: ldc 55
    //   101: iconst_2
    //   102: ldc_w 396
    //   105: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 350	java/io/IOException:printStackTrace	()V
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
      paramString = paramString + "/" + "config.json";
      paramString = new File(h + paramString);
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
            String str;
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
  
  public static void a(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramAsyncCallBack.a(paramString, "-1");
      return;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str))
    {
      paramAsyncCallBack.a(paramString, "-1");
      return;
    }
    if (paramContext == null)
    {
      paramAsyncCallBack.a(paramString, "-1");
      a(str, 3, 0L, 4, "lixian_cover");
      return;
    }
    if (!a())
    {
      paramAsyncCallBack.a(paramString, "-1");
      a(str, 2, 0L, OfflineDownloader.a(paramContext), "lixian_cover");
      return;
    }
    if (Arrays.asList(b).contains(str))
    {
      paramAsyncCallBack.a(paramString, "1");
      a(str, 4, 0L, OfflineDownloader.a(paramContext), "lixian_cover");
      return;
    }
    new bhi(paramContext, paramString, paramAsyncCallBack).start();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    a(paramContext, paramString1, paramString2, true, new bhj());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, LoadedBack paramLoadedBack)
  {
    if (paramLoadedBack == null) {
      return;
    }
    if (!a())
    {
      paramLoadedBack.a(3);
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramLoadedBack.a(1);
      return;
    }
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
        paramLoadedBack.a(5);
        return;
      }
    }
    if (c(paramString1))
    {
      paramLoadedBack.a(7);
      return;
    }
    a(paramString1);
    OfflineDownloader.a(paramContext, paramString2, paramInt, paramString1, i + paramString1 + ".zip", new bhm(System.currentTimeMillis(), paramContext, paramString1, paramLoadedBack));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack)
  {
    if (paramLoadedBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramLoadedBack.a(1);
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
      if (!a())
      {
        paramLoadedBack.a(3);
        return;
      }
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
      {
        paramLoadedBack.a(1);
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
        paramLoadedBack.a(5);
        return;
      }
    }
    if (c(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, paramString1 + "is downloading");
      }
      paramLoadedBack.a(7);
      return;
    }
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.size() >= 1))
    {
      a(paramContext, paramString1, paramString2, paramLoadedBack, paramBoolean);
      return;
    }
    a(paramString1);
    new bhk(paramInt, paramString1, paramContext, paramString2, paramLoadedBack, paramBoolean).start();
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
      paramLoadedBack.a(1);
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
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int i1 = 0;
    try
    {
      int i2 = Integer.valueOf(paramString1).intValue();
      i1 = i2;
    }
    catch (NumberFormatException paramString1)
    {
      label24:
      break label24;
    }
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", paramString2, i1, paramInt1, "" + paramLong, "3", "" + paramInt2, "");
  }
  
  protected static boolean a()
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "no sd");
      }
    }
    Object localObject2;
    do
    {
      return false;
      localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      localObject1 = (String)localObject2 + "tencent/MobileQQ/qbiz/";
      h = (String)localObject2 + "tencent/MobileQQ/qbiz/html5/";
      localObject2 = new File(h);
    } while ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()));
    i = (String)localObject1 + "tmp/";
    Object localObject1 = new File(i);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte[1024];
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
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return false;
        str1 = i + paramString + ".zip";
        if (new File(str1).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("HtmlCheckUpdate", 2, "doUpdate: no zip ! : businessId:" + paramString);
      return false;
      str2 = h + paramString;
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
    b(paramString);
    return true;
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
  
  public static String b(String paramString)
  {
    String str = "file://" + Environment.getExternalStorageDirectory().getPath() + "/" + "tencent/MobileQQ/qbiz/html5/";
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
      new bhl(a(paramString1), paramContext, paramString1, paramString2, paramLoadedCallBack).start();
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "checkOfflineFiles " + paramString);
    }
    paramString = h + paramString + "/";
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString + "verify.json"));
      JSONObject localJSONObject = new JSONObject(OfflineSecurity.a(localFileInputStream));
      localFileInputStream.close();
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
  
  protected static boolean c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    while (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline
 * JD-Core Version:    0.7.0.1
 */