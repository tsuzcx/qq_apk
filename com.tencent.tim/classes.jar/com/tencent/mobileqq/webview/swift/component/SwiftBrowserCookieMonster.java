package com.tencent.mobileqq.webview.swift.component;

import aczz;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import aqgz;
import aqhs;
import arbb;
import arbc;
import arbd;
import arbe;
import arch;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import jml;
import jqo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class SwiftBrowserCookieMonster
{
  private static final LruCache<String, SwiftBrowserCookieMonster> G = new LruCache(8);
  public static volatile b a;
  public static final AtomicInteger ci = new AtomicInteger(1);
  public static volatile String cyU;
  public static volatile String cyV;
  public static volatile String cyW;
  private static final byte[] gM = new byte[0];
  public static volatile String hK;
  public static volatile String sKey;
  long aun = 0L;
  public final jml authConfig;
  public volatile boolean cXy;
  boolean cXz = false;
  public volatile String cyX;
  public String cyY;
  public String cyZ;
  public String cza;
  public String czb;
  public final String czc;
  final ConcurrentHashMap<String, CopyOnWriteArrayList<a>> gG = new ConcurrentHashMap();
  public volatile String pSkey;
  final AtomicInteger state = new AtomicInteger(1);
  
  SwiftBrowserCookieMonster(String paramString)
  {
    this.czc = paramString;
    if (G.size() == 0) {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    this.authConfig = jml.a();
    G.put(paramString, this);
    egV();
  }
  
  public static String F(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.format("http://%s/", new Object[] { paramString });
    }
    return String.format("https://%s/", new Object[] { paramString });
  }
  
  public static String J(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  /* Error */
  public static SwiftBrowserCookieMonster a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 133	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:pY	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +34 -> 46
    //   15: getstatic 60	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:G	Landroid/support/v4/util/LruCache;
    //   18: aload_2
    //   19: invokevirtual 143	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: ifnonnull +12 -> 41
    //   32: new 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: aconst_null
    //   47: astore_0
    //   48: goto -7 -> 41
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   25	4	1	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   7	30	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	26	51	finally
    //   32	41	51	finally
  }
  
  static void a(List<String> paramList, arch paramarch)
  {
    ThreadManager.post(new SwiftBrowserCookieMonster.5(paramList, paramarch), 5, null, false);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    int m = 0;
    int k = 0;
    if (paramAppRuntime != null) {}
    for (;;)
    {
      try
      {
        if (!paramAppRuntime.isLogin()) {
          break label536;
        }
        if (paramIntent == null) {
          break label529;
        }
        if (!paramIntent.getBooleanExtra("avoidLoginWeb", false)) {
          break label524;
        }
        i = 0;
        paramIntent = paramIntent.getStringExtra("url");
        if (i == 0) {
          break;
        }
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = jml.a();
          TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
          String str = paramAppRuntime.getAccount();
          Object localObject1 = paramIntent.a("pt4_token");
          paramIntent = paramAppRuntime.getAppRuntime("modular_web");
          if ((paramIntent instanceof AppInterface))
          {
            Object localObject2 = new arch((AppInterface)paramIntent);
            paramIntent = ((arch)localObject2).bg("p_skey");
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "p_skey top hosts: " + TextUtils.join(", ", paramIntent));
              }
              a(paramIntent, (arch)localObject2);
              if (localObject1 == null) {
                break label546;
              }
              i = ((Set)localObject1).size();
              if (paramIntent == null) {
                break label551;
              }
              j = paramIntent.size();
              localObject2 = new String[j + i];
              i = m;
              if (localObject1 != null)
              {
                i = m;
                if (((Set)localObject1).size() > 0)
                {
                  localObject1 = ((Set)localObject1).iterator();
                  j = k;
                  i = j;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2[j] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject1).next() });
                    j += 1;
                    continue;
                  }
                }
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label543;
              }
              QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
              break label543;
            }
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              if (paramIntent.hasNext())
              {
                localObject2[i] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), (String)paramIntent.next() });
                i += 1;
                continue;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("SwiftBrowserCookieMonster", 2, "now preGetPskey and pt4Token: " + TextUtils.join(",", (Object[])localObject2));
            }
            localTicketManager.GetPskey(str, 16L, (String[])localObject2, new arbc());
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
            }
            m(paramAppRuntime);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
          continue;
        }
        paramIntent = null;
      }
      catch (Exception paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserCookieMonster", 2, "preGetKey exception:" + paramAppRuntime.toString());
        }
        paramAppRuntime.printStackTrace();
        return;
      }
      continue;
      label524:
      int i = 1;
      continue;
      label529:
      i = 1;
      paramIntent = null;
      continue;
      label536:
      paramIntent = null;
      i = 0;
      continue;
      label543:
      continue;
      label546:
      i = 0;
      continue;
      label551:
      int j = 0;
    }
  }
  
  public static boolean a(CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/"))
    {
      paramCookiesMap.addCookie(paramString1, d("dvid1", aqhs.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = aqgz.getIMEI();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, d("dvid5", aqhs.bytes2HexStr(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = aqgz.getIMSI();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, d("dvid4", aqhs.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = aqgz.be(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, d("dvid2", aqhs.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = aqgz.getBSSID(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, d("dvid3", aqhs.bytes2HexStr(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      return true;
    }
    return false;
  }
  
  public static boolean aGc()
  {
    return (!TextUtils.isEmpty(sKey)) && (!TextUtils.isEmpty(cyU)) && (!TextUtils.isEmpty(cyW)) && (!TextUtils.isEmpty(hK)) && (!TextUtils.isEmpty(cyV));
  }
  
  static void appendCookieStr(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      insertSemicolon(paramStringBuilder);
      paramStringBuilder.append(paramString2).append(paramString1);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, paramString2 + "is empty");
      }
    } while (TextUtils.isEmpty(paramString3));
    insertSemicolon(paramStringBuilder);
    paramStringBuilder.append(paramString2).append(paramString3);
  }
  
  public static void b(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.postImmediately(new SwiftBrowserCookieMonster.6(paramAppRuntime, paramIntent), new arbd(), false);
  }
  
  public static String d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { paramString1, paramString2, paramString3 });
    }
    return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure; HttpOnly;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public static void egU()
  {
    sKey = "";
    cyU = "";
    cyV = "";
    cyW = "";
    hK = "";
    ci.set(1);
    G.evictAll();
    a = null;
    QLog.i("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
  }
  
  static void egV()
  {
    if (a == null) {
      ThreadManager.postImmediately(new SwiftBrowserCookieMonster.9(), null, false);
    }
  }
  
  public static String f(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (TicketManager)paramAppRuntime.getManager(2);
      long l = System.currentTimeMillis();
      String str1 = paramAppRuntime.getAccount();
      String str2 = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
      arbe localarbe = new arbe(paramString, l);
      localObject = ((TicketManager)localObject).GetPskey(str1, 16L, new String[] { str2 }, localarbe);
      if (localObject == null) {
        break label258;
      }
    }
    label258:
    for (Object localObject = ((Ticket)localObject).getPt4Token(paramString);; localObject = null)
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof AppInterface)) {
        new arch((AppInterface)paramAppRuntime).iA(paramString, "pt4_token");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label221;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache success for " + paramString + ", token is: " + jqo.b(new StringBuilder().append("pt4_token=").append((String)localObject).toString(), new String[0]));
      }
      while (localObject != null)
      {
        return localObject;
        label221:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + paramString);
      }
      return "";
      return "";
    }
  }
  
  static void insertSemicolon(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (!paramStringBuilder.toString().endsWith(";")) {
        break label33;
      }
      paramStringBuilder.append(" ");
    }
    label33:
    while (paramStringBuilder.toString().endsWith("; ")) {
      return;
    }
    paramStringBuilder.append("; ");
  }
  
  public static boolean m(AppRuntime paramAppRuntime)
  {
    if (ci.compareAndSet(1, 2))
    {
      paramAppRuntime = new SwiftBrowserCookieMonster.3(paramAppRuntime);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.postImmediately(paramAppRuntime, null, false);
      }
    }
    else
    {
      return true;
    }
    paramAppRuntime.run();
    return true;
  }
  
  static boolean n(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      bool1 = bool2;
      if (paramAppRuntime != null)
      {
        bool1 = bool2;
        if (paramAppRuntime.isLogin())
        {
          bool2 = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + paramAppRuntime.getAccount(), false);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserCookieMonster", 2, "account: " + paramAppRuntime.getAccount() + ", mPtloginFlag: " + bool2);
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public static String pX(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i = paramString.length();
        while (i < 10)
        {
          ((StringBuilder)localObject).append("0");
          i += 1;
        }
        localObject = paramString;
      }
    }
    else {
      return localObject;
    }
    return "o" + paramString;
  }
  
  public static String pY(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = Uri.parse(paramString);
        String str = ((Uri)localObject).getScheme();
        if ((("http".equals(str)) || ("https".equals(str))) && (((Uri)localObject).isHierarchical()))
        {
          localObject = F(((Uri)localObject).getHost(), "http".equals(str));
          return localObject;
        }
      }
      catch (Exception localException)
      {
        QLog.e("SwiftBrowserCookieMonster", 1, "getCookieHost[" + paramString + "] error:" + localException.toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static String pZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 568	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +200 -> 206
    //   9: invokestatic 89	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 572	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +144 -> 163
    //   22: aload 4
    //   24: invokevirtual 170	mqq/app/AppRuntime:isLogin	()Z
    //   27: ifeq +136 -> 163
    //   30: aload 4
    //   32: invokevirtual 575	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   35: invokevirtual 578	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   38: invokestatic 99	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   41: pop
    //   42: invokestatic 584	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   45: aload_0
    //   46: invokevirtual 587	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: astore_2
    //   52: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +55 -> 110
    //   58: ldc 227
    //   60: iconst_2
    //   61: new 229	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 589
    //   71: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 119	java/lang/String
    //   79: invokestatic 462	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 591
    //   88: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: iconst_0
    //   93: anewarray 119	java/lang/String
    //   96: invokestatic 594	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: aload 4
    //   113: aload_2
    //   114: invokevirtual 597	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:g	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   117: areturn
    //   118: astore_0
    //   119: ldc_w 417
    //   122: astore_1
    //   123: ldc 227
    //   125: iconst_1
    //   126: new 229	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 599
    //   136: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 602	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 604
    //   149: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_1
    //   159: astore_2
    //   160: goto -50 -> 110
    //   163: ldc 227
    //   165: iconst_1
    //   166: new 229	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 606
    //   176: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: iconst_0
    //   181: anewarray 119	java/lang/String
    //   184: invokestatic 594	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 608
    //   193: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: ldc_w 417
    //   205: areturn
    //   206: ldc 227
    //   208: iconst_1
    //   209: new 229	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 606
    //   219: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: iconst_0
    //   224: anewarray 119	java/lang/String
    //   227: invokestatic 594	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   230: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 608
    //   236: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: ldc_w 417
    //   248: areturn
    //   249: astore_0
    //   250: goto -127 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString	String
    //   49	110	1	str1	String
    //   51	109	2	str2	String
    //   4	107	3	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   15	97	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   30	50	118	java/lang/Throwable
    //   52	108	249	java/lang/Throwable
  }
  
  public static void q(AppRuntime arg0)
  {
    int i = ci.get();
    if (3 != i)
    {
      if (1 == i)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        }
        m(localAppRuntime);
      }
    }
    else {
      return;
    }
    synchronized (ci)
    {
      for (;;)
      {
        i = ci.get();
        if (2 == i) {
          try
          {
            ci.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (TextUtils.isEmpty(sKey))
    {
      i = 0;
      if (!TextUtils.isEmpty(cyU)) {
        break label171;
      }
    }
    label171:
    for (int j = 0;; j = 1)
    {
      VipUtils.a(null, "webview_report", "0X800619D", "0X800619D", 0, 0, new String[] { "" + i, "" + j });
      return;
      i = 1;
      break;
    }
  }
  
  CookiesMap a(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramIntent = new CookiesMap();
    if (!a(paramIntent, paramAppRuntime)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {
      if (!b(paramIntent, paramAppRuntime))
      {
        this.cXz = bool;
        c(paramIntent, paramAppRuntime);
      }
    }
    for (;;)
    {
      a(paramIntent);
      return paramIntent;
      bool = false;
      break;
      a(paramIntent, paramAppRuntime);
    }
  }
  
  String a(String paramString, AppRuntime paramAppRuntime)
  {
    int j = 2;
    Object localObject = paramString;
    int i;
    if (this.cXz)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (TextUtils.isEmpty(cyW)) {
        break label247;
      }
      if (this.czb == null) {
        break label213;
      }
      i = 1;
      if (this.cyZ == null) {
        break label218;
      }
      label53:
      VipUtils.a(null, "webview_report", "0X80060AC", "0X80060AC", 0, i | j, new String[] { paramString });
      boolean bool = n(paramAppRuntime);
      StringBuilder localStringBuilder = new StringBuilder("http");
      if (!bool) {
        break label224;
      }
      localObject = "s";
      label107:
      localStringBuilder = localStringBuilder.append((String)localObject).append("://");
      if (!bool) {
        break label232;
      }
      localObject = "ssl.";
      label132:
      localObject = localStringBuilder.append((String)localObject).append("ptlogin2.qq.com/jump?clientuin=").append(paramAppRuntime.getAccount()).append("&clientkey=").append(cyW).append("&keyindex=19&pt_mq=");
      if (!paramString.startsWith("https://s.p.qq.com")) {
        break label240;
      }
    }
    label213:
    label218:
    label224:
    label232:
    label240:
    for (paramAppRuntime = "1";; paramAppRuntime = "0")
    {
      localObject = paramAppRuntime + "&u1=" + URLEncoder.encode(paramString);
      return localObject;
      i = 0;
      break;
      j = 0;
      break label53;
      localObject = "";
      break label107;
      localObject = "";
      break label132;
    }
    label247:
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Can't do ptlogin jumping because STwxWeb is empty!");
    }
    this.aun |= 0x8;
    return paramString;
  }
  
  void a(CookiesMap paramCookiesMap)
  {
    String str = aczz.h(BaseApplicationImpl.getContext(), "key_local_cache", "0");
    if ("0".equals(str)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "addLocaleIdCookie, localeIdStr = 0");
    }
    for (;;)
    {
      return;
      str = "qq_locale_id=" + str + ';';
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "addLocaleIdCookie, cookie = " + str);
      }
      Iterator localIterator = paramCookiesMap.keySet().iterator();
      while (localIterator.hasNext()) {
        paramCookiesMap.addCookie((String)localIterator.next(), str);
      }
    }
  }
  
  void a(CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    String str = this.czc;
    if (paramAppRuntime == null)
    {
      localObject = "login_key_set_failed=NullRuntime; EXPIRES=" + (String)localObject + ";";
      paramCookiesMap.addCookie(str, (String)localObject);
      a(paramCookiesMap, this.czc, "aq.qq.com");
      if (paramAppRuntime != null) {
        break label171;
      }
    }
    label171:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "webview_report", "0X8006117", "0X8006117", i, 0, new String[] { this.czc });
      return;
      localObject = "login_key_set_failed=AlreadyLogout; EXPIRES=" + (String)localObject + ";";
      break;
    }
  }
  
  void a(CookiesMap paramCookiesMap, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    paramCookiesMap = paramCookiesMap.entrySet().iterator();
    while (paramCookiesMap.hasNext())
    {
      Object localObject = (Map.Entry)paramCookiesMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ArrayList)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localHashMap.put(str, ((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]));
      }
    }
    if (localHashMap.size() > 0)
    {
      CookieManager.getInstance().setCookies(localHashMap);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
        CookieSyncManager.getInstance().sync();
      }
    }
  }
  
  public void a(a parama)
  {
    if (parama != null)
    {
      Iterator localIterator = this.gG.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CopyOnWriteArrayList)this.gG.get(localObject);
        if (((CopyOnWriteArrayList)localObject).contains(parama)) {
          ((CopyOnWriteArrayList)localObject).remove(parama);
        }
      }
    }
  }
  
  boolean a(CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {}
    for (String str1 = pX(paramAppRuntime.getAccount());; str1 = "")
    {
      paramAppRuntime = F("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, d("superuin", str1, "ptlogin2.qq.com", false));
      Iterator localIterator = this.authConfig.a("skey").iterator();
      String str2;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        paramAppRuntime = F(str2, true);
        paramCookiesMap.addCookie(paramAppRuntime, d("uin", str1, str2, false));
      }
      localIterator = this.authConfig.a("pskey").iterator();
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        paramAppRuntime = F(str2, true);
        paramCookiesMap.addCookie(paramAppRuntime, d("p_uin", str1, str2, false));
      }
      if (TextUtils.isEmpty(str1))
      {
        this.aun |= 0x80;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserCookieMonster", 2, "cookieUin isempty，url:" + paramAppRuntime);
        }
        return false;
      }
      return true;
    }
  }
  
  public boolean a(String paramString, a parama, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (this.state.get() == 3)
    {
      if (paramAppRuntime == null)
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = a(paramString, (AppRuntime)localObject1);
        if (parama == null) {
          break label327;
        }
        if (this.aun > 0L)
        {
          egX();
          QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.aun);
        }
        localObject2 = CookieManager.getInstance().getCookie(paramString);
        if (((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains("skey="))) && ((!this.authConfig.cQ(paramString)) && (!rP((String)localObject2)))) {
          break label181;
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, retry set cookie: " + (String)localObject2 + "");
        reset();
        a(paramString, parama, paramAppRuntime, paramIntent);
      }
      for (;;)
      {
        return true;
        localObject1 = paramAppRuntime;
        break;
        label181:
        if ((this.cXz) || (this.aun > 0L))
        {
          if (this.cXz) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + jqo.filterKeyForLog((String)localObject1, new String[0]));
          }
          parama.a((String)localObject1, null, this.aun);
          destroy();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "hit cookie cache, just call onSetCookiesFinished " + jqo.filterKeyForLog((String)localObject1, new String[0]) + ", errorCode: " + this.aun);
          }
          parama.a((String)localObject1, null, this.aun);
        }
      }
    }
    label327:
    if (parama != null)
    {
      localObject2 = (CopyOnWriteArrayList)this.gG.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.gG.put(paramString, localObject1);
      }
      if (!((CopyOnWriteArrayList)localObject1).contains(parama)) {
        ((CopyOnWriteArrayList)localObject1).add(parama);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "now add callback for " + jqo.filterKeyForLog(paramString, new String[0]));
      }
    }
    jqo.le("Web_qqbrowser_check_and_set_cookies");
    paramString = new SwiftBrowserCookieMonster.1(this, paramAppRuntime, paramIntent);
    if (this.state.compareAndSet(1, 2))
    {
      CookieSyncManager.createInstance(BaseApplicationImpl.getApplication().getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "post thread to set all cookies");
      }
      ThreadManager.postImmediately(paramString, new arbb(this), false);
    }
    return true;
  }
  
  void b(CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.authConfig.a("skey").iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCookiesMap.addCookie(F(str, true), d("skey", "", str, false));
    }
    paramCookiesMap.addCookie(F("ptlogin2.qq.com", true), d("superkey", "", "ptlogin2.qq.com", true));
    if (!TextUtils.isEmpty(this.czb)) {
      paramCookiesMap.addCookie(this.czc, d("p_skey", "", this.czb, false));
    }
    if (!TextUtils.isEmpty(this.cyY)) {
      paramCookiesMap.addCookie(this.czc, d("a2", "", this.cyY, true));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserCookieMonster", 2, jqo.filterKeyForLog(this.czc, new String[0]) + " forbidden login state, remove all login key");
    }
  }
  
  boolean b(CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((!TextUtils.isEmpty(this.czb)) && (TextUtils.isEmpty(this.pSkey)))
    {
      this.pSkey = e(paramAppRuntime, this.czb);
      StringBuilder localStringBuilder = new StringBuilder().append(this.czb).append(": pSkey is miss and fetch result is ");
      if (TextUtils.isEmpty(this.pSkey))
      {
        localObject1 = "fail";
        QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
        label87:
        if ((!TextUtils.isEmpty(this.cyZ)) && (TextUtils.isEmpty(this.cyX)))
        {
          this.cyX = f(paramAppRuntime, this.cyZ);
          localObject1 = new StringBuilder().append(this.cyZ).append(": pt4Token is miss and fetch result is ");
          if (!TextUtils.isEmpty(this.cyX)) {
            break label501;
          }
          paramAppRuntime = "fail";
          QLog.i("SwiftBrowserCookieMonster", 1, paramAppRuntime);
        }
        label154:
        paramAppRuntime = localObject2;
        if (!TextUtils.isEmpty(this.czb))
        {
          VipUtils.a(null, "webview_report", "0X80060AB", "0X80060AB", 0, 0, new String[] { this.czc, this.czb });
          if (TextUtils.isEmpty(this.pSkey)) {
            break label526;
          }
          if ((this.czc == null) || (!QzoneConfig.isNeedSecureVerify()) || (!this.czc.contains("qzone.qq.com"))) {
            break label508;
          }
          localObject1 = J("p_skey", this.pSkey, this.czb);
          label264:
          paramCookiesMap.addCookie(this.czc, (String)localObject1);
          paramAppRuntime = localObject2;
          if (this.czc != null)
          {
            paramAppRuntime = localObject2;
            if (this.czc.contains("http://"))
            {
              paramAppRuntime = localObject2;
              if (this.czc.contains("qzone.qq.com"))
              {
                paramCookiesMap.addCookie(this.czc.replace("http", "https"), (String)localObject1);
                paramAppRuntime = localObject2;
              }
            }
          }
        }
        label336:
        if (!TextUtils.isEmpty(this.cyZ))
        {
          if (TextUtils.isEmpty(this.cyX)) {
            break label609;
          }
          paramAppRuntime = d("pt4_token", this.cyX, this.cyZ, false);
          paramCookiesMap.addCookie(this.czc, paramAppRuntime);
        }
      }
    }
    label501:
    label508:
    do
    {
      if ((!TextUtils.isEmpty(this.czb)) && (this.czb.equals("docs.qq.com")))
      {
        paramAppRuntime = d("tdsourcetag", "s_qq_c2c_chatfiles", this.czb, false);
        paramCookiesMap.addCookie(this.czc, paramAppRuntime);
      }
      return true;
      localObject1 = "success";
      break;
      if (!QLog.isColorLevel()) {
        break label87;
      }
      QLog.d("SwiftBrowserCookieMonster", 1, this.czb + jqo.b(new StringBuilder().append(" p_skey=").append(this.pSkey).toString(), new String[0]));
      break label87;
      paramAppRuntime = "success";
      break label154;
      localObject1 = d("p_skey", this.pSkey, this.czb, false);
      break label264;
      localObject1 = CookieManager.getInstance().getCookie(this.czc);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_skey=")))
      {
        paramAppRuntime = (AppRuntime)localObject1;
        if (!((String)localObject1).contains("p_skey=;")) {
          break label336;
        }
      }
      this.aun |= 0x20;
      QLog.e("SwiftBrowserCookieMonster", 1, this.czb + ": get pSkey fail!");
      return false;
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null) {
        localObject1 = CookieManager.getInstance().getCookie(this.czc);
      }
    } while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("pt4_token=")) && (!((String)localObject1).contains("pt4_token=;")));
    label526:
    label609:
    this.aun |= 0x40;
    QLog.e("SwiftBrowserCookieMonster", 1, this.cyZ + ": get pt4Token fail!");
    return false;
  }
  
  boolean c(CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if (!aGc()) {
      q(paramAppRuntime);
    }
    if (!TextUtils.isEmpty(cyU))
    {
      try
      {
        paramAppRuntime = MessageDigest.getInstance("MD5");
        paramAppRuntime.update(cyU.getBytes());
        paramAppRuntime = paramAppRuntime.digest();
        int i = paramAppRuntime.length;
        long l1 = paramAppRuntime[(i - 4)] & 0xFF;
        long l2 = (paramAppRuntime[(i - 3)] & 0xFF) << 16;
        long l3 = (paramAppRuntime[(i - 2)] & 0xFF) << 8;
        cyV = Long.toString(paramAppRuntime[(i - 1)] & 0xFF | l1 << 24 | l2 | l3);
      }
      catch (NoSuchAlgorithmException paramAppRuntime)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SwiftBrowserCookieMonster", 2, "Super key hash failed:" + paramAppRuntime.getMessage());
          }
          this.aun |= 0x4;
        }
      }
      paramAppRuntime = F("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, d("superkey", cyU, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, d("supertoken", cyV, "ptlogin2.qq.com", false));
      paramCookiesMap.addCookie(F("ptlogin2.qq.com", false), d("superkey", cyU, "ptlogin2.qq.com", true));
      if (!TextUtils.isEmpty(this.cyY))
      {
        if (TextUtils.isEmpty(hK)) {
          break label374;
        }
        paramAppRuntime = d("a2", hK, this.cyY, true);
        paramCookiesMap.addCookie(this.czc, paramAppRuntime);
      }
    }
    for (;;)
    {
      a(paramCookiesMap, this.czc, this.cyY);
      if (TextUtils.isEmpty(sKey)) {
        break label389;
      }
      paramAppRuntime = this.authConfig.a("skey").iterator();
      while (paramAppRuntime.hasNext())
      {
        String str = (String)paramAppRuntime.next();
        paramCookiesMap.addCookie(F(str, true), d("skey", sKey, str, false));
      }
      this.aun |= 0x2;
      break;
      label374:
      this.aun |= 0x10;
    }
    label389:
    this.aun |= 1L;
    return true;
  }
  
  public void destroy()
  {
    reset();
    this.gG.clear();
    G.remove(this.czc);
  }
  
  String e(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str = ((TicketManager)paramAppRuntime.getManager(2)).getPskey(paramAppRuntime.getAccount(), paramString);
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof AppInterface)) {
        new arch((AppInterface)paramAppRuntime).iA(paramString, "p_skey");
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(str)) {
          break label140;
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("Get p_skey success for ").append(paramString).append(jqo.b(" p_skey=" + str, new String[0]));
        QLog.d("SwiftBrowserCookieMonster", 2, paramAppRuntime.toString());
      }
      while (str != null)
      {
        return str;
        label140:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get p_skey failed for " + paramString);
      }
      return "";
    }
    return "";
  }
  
  /* Error */
  void egT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1000	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cXy	Z
    //   6: ifne +49 -> 55
    //   9: aload_0
    //   10: getfield 79	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czc	Ljava/lang/String;
    //   13: ldc_w 1002
    //   16: invokevirtual 678	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +39 -> 58
    //   22: aload_0
    //   23: ldc_w 1004
    //   26: putfield 1006	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cza	Ljava/lang/String;
    //   29: aload_0
    //   30: ldc_w 417
    //   33: putfield 657	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyZ	Ljava/lang/String;
    //   36: aload_0
    //   37: ldc_w 417
    //   40: putfield 888	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyY	Ljava/lang/String;
    //   43: aload_0
    //   44: ldc_w 417
    //   47: putfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czb	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 1000	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cXy	Z
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 79	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czc	Ljava/lang/String;
    //   63: invokestatic 1009	jqo:dV	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 1006	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cza	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 106	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:authConfig	Ljml;
    //   74: aload_0
    //   75: getfield 79	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czc	Ljava/lang/String;
    //   78: invokevirtual 1012	jml:dJ	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 888	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyY	Ljava/lang/String;
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 106	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:authConfig	Ljml;
    //   89: aload_0
    //   90: getfield 79	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czc	Ljava/lang/String;
    //   93: invokevirtual 1015	jml:dH	(Ljava/lang/String;)Ljava/lang/String;
    //   96: putfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czb	Ljava/lang/String;
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 106	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:authConfig	Ljml;
    //   104: aload_0
    //   105: getfield 79	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czc	Ljava/lang/String;
    //   108: invokevirtual 1018	jml:dI	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 657	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyZ	Ljava/lang/String;
    //   114: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -67 -> 50
    //   120: ldc 227
    //   122: iconst_2
    //   123: new 229	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 1020
    //   133: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 1006	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cza	Ljava/lang/String;
    //   140: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 1022
    //   146: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 655	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:czb	Ljava/lang/String;
    //   153: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 1024
    //   159: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 657	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyZ	Ljava/lang/String;
    //   166: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 1026
    //   172: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 888	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:cyY	Ljava/lang/String;
    //   179: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -138 -> 50
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	SwiftBrowserCookieMonster
    //   191	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	191	finally
    //   50	55	191	finally
    //   58	188	191	finally
  }
  
  @Deprecated
  public void egW()
  {
    egT();
    CookiesMap localCookiesMap = new CookiesMap();
    a(localCookiesMap, null);
    b(localCookiesMap);
    a(localCookiesMap, true);
    G.evictAll();
  }
  
  void egX() {}
  
  String g(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject2 = new StringBuilder();
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    Object localObject3 = pX(str);
    if (!TextUtils.isEmpty(paramString)) {
      ((StringBuilder)localObject2).append(paramString);
    }
    insertSemicolon((StringBuilder)localObject2);
    ((StringBuilder)localObject2).append("uin=").append((String)localObject3);
    StringBuilder localStringBuilder;
    Object localObject1;
    label192:
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("skey="))) {
      if (TextUtils.isEmpty(sKey))
      {
        sKey = localTicketManager.getSkey(str);
        localStringBuilder = new StringBuilder().append("getCookie4WebSo: skey is miss and fetch result is ");
        if (TextUtils.isEmpty(sKey))
        {
          localObject1 = "fail";
          QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
        }
      }
      else
      {
        if (TextUtils.isEmpty(sKey)) {
          break label499;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, jqo.b("skey=" + sKey, new String[0]));
        localObject1 = localTicketManager.GetLocalTicket(str, 4096);
        if (localObject1 != null) {
          QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + ((Ticket)localObject1)._create_time);
        }
        appendCookieStr((StringBuilder)localObject2, sKey, "skey=", "");
        bool1 = false;
      }
    }
    for (;;)
    {
      label258:
      boolean bool2;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_skey=;")))
      {
        if (!QLog.isColorLevel()) {
          break label1401;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
        bool2 = false;
      }
      for (;;)
      {
        label293:
        boolean bool3;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pt4_token=;")))
        {
          if (!QLog.isColorLevel()) {
            break label1395;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
          bool3 = false;
        }
        label906:
        label1045:
        for (;;)
        {
          label328:
          if ((bool1) || (bool2) || (bool3))
          {
            QLog.i("SwiftBrowserCookieMonster", 1, "getCookie4WebSo: cookie need update: isNeedReplaceSkey(" + bool1 + "), isNeedReplacePskey(" + bool2 + "), isNeedReplacePt4Token(" + bool3 + ").");
            paramString = ((StringBuilder)localObject2).toString().replaceAll(" ", "");
            localObject1 = new StringBuilder();
            if (paramString.contains(";"))
            {
              localObject2 = paramString.split(";");
              int j = localObject2.length;
              int i = 0;
              if (i < j)
              {
                localObject3 = localObject2[i];
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  if (((StringBuilder)localObject1).length() != 0) {
                    break label929;
                  }
                  ((StringBuilder)localObject1).append((String)localObject3);
                }
                for (;;)
                {
                  i += 1;
                  break label448;
                  localObject1 = "success";
                  break;
                  label499:
                  QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                  break label192;
                  if (paramString.contains("skey=;"))
                  {
                    if (!QLog.isColorLevel()) {
                      break label1407;
                    }
                    QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
                    bool1 = false;
                    break label258;
                  }
                  if (!paramString.contains("skey=")) {
                    break label1407;
                  }
                  bool1 = true;
                  break label258;
                  localObject1 = this.authConfig.dH(this.czc);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1401;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("p_skey=")))
                  {
                    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin=;")))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
                      }
                      label628:
                      if (TextUtils.isEmpty(this.pSkey))
                      {
                        this.pSkey = localTicketManager.getPskey(str, (String)localObject1);
                        localObject3 = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                        if (!TextUtils.isEmpty(this.pSkey)) {
                          break label759;
                        }
                      }
                    }
                    label759:
                    for (localObject1 = "fail";; localObject1 = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, (String)localObject1);
                      appendCookieStr((StringBuilder)localObject2, this.pSkey, "p_skey=", "");
                      bool2 = false;
                      break;
                      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("p_uin="))) {
                        break label628;
                      }
                      insertSemicolon((StringBuilder)localObject2);
                      ((StringBuilder)localObject2).append("p_uin=").append((String)localObject3);
                      break label628;
                    }
                  }
                  if (!paramString.contains("p_skey=")) {
                    break label1401;
                  }
                  bool2 = true;
                  break label293;
                  localObject1 = this.authConfig.dI(this.czc);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1395;
                  }
                  if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pt4_token=")))
                  {
                    if (TextUtils.isEmpty(this.cyX))
                    {
                      this.cyX = f(paramAppRuntime, (String)localObject1);
                      localObject1 = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.cyX)) {
                        break label906;
                      }
                    }
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      appendCookieStr((StringBuilder)localObject2, this.cyX, "pt4_token=", "");
                      bool3 = false;
                      break;
                    }
                  }
                  if (!paramString.contains("pt4_token=")) {
                    break label1395;
                  }
                  bool3 = true;
                  break label328;
                  insertSemicolon((StringBuilder)localObject1);
                  if ((((String)localObject3).startsWith("p_skey=")) && (bool2))
                  {
                    if (TextUtils.isEmpty(this.pSkey))
                    {
                      this.pSkey = localTicketManager.getPskey(str, this.authConfig.dH(this.czc));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pSkey is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.pSkey)) {
                        break label1045;
                      }
                    }
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      appendCookieStr((StringBuilder)localObject1, this.pSkey, "p_skey=", (String)localObject3);
                      break;
                    }
                  }
                  if ((((String)localObject3).startsWith("skey=")) && (bool1))
                  {
                    if (TextUtils.isEmpty(sKey))
                    {
                      sKey = localTicketManager.getSkey(str);
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: sKey is miss and fetch result is ");
                      if (TextUtils.isEmpty(sKey))
                      {
                        paramString = "fail";
                        label1117:
                        QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      }
                    }
                    else
                    {
                      if (TextUtils.isEmpty(sKey)) {
                        break label1245;
                      }
                      QLog.i("SwiftBrowserCookieMonster", 1, jqo.b("skey=" + sKey, new String[0]));
                    }
                    for (;;)
                    {
                      paramString = localTicketManager.GetLocalTicket(str, 4096);
                      if (paramString != null) {
                        QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + paramString._create_time);
                      }
                      appendCookieStr((StringBuilder)localObject1, sKey, "skey=", (String)localObject3);
                      break;
                      paramString = "success";
                      break label1117;
                      label1245:
                      QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                    }
                  }
                  if ((((String)localObject3).startsWith("pt4_token=")) && (bool3))
                  {
                    if (TextUtils.isEmpty(this.cyX))
                    {
                      this.cyX = f(paramAppRuntime, this.authConfig.dI(this.czc));
                      localStringBuilder = new StringBuilder().append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                      if (!TextUtils.isEmpty(this.cyX)) {
                        break label1363;
                      }
                    }
                    label1363:
                    for (paramString = "fail";; paramString = "success")
                    {
                      QLog.i("SwiftBrowserCookieMonster", 1, paramString);
                      appendCookieStr((StringBuilder)localObject1, this.cyX, "pt4_token=", (String)localObject3);
                      break;
                    }
                  }
                  ((StringBuilder)localObject1).append((String)localObject3);
                }
              }
            }
          }
          label448:
          for (paramAppRuntime = (AppRuntime)localObject1;; paramAppRuntime = (AppRuntime)localObject2) {
            return paramAppRuntime.toString();
          }
          label929:
          label1395:
          bool3 = false;
        }
        label1401:
        bool2 = false;
      }
      label1407:
      bool1 = false;
    }
  }
  
  public boolean isReady()
  {
    return this.state.get() == 3;
  }
  
  boolean rP(String paramString)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool1;
      if (!paramString.contains("p_skey"))
      {
        bool1 = bool3;
        if (!TextUtils.isEmpty(this.czb)) {
          if (!this.czb.equals("docs.qq.com"))
          {
            bool1 = bool3;
            if (!this.czb.equals("docx.qq.com")) {}
          }
          else
          {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          QLog.i("SwiftBrowserCookieMonster", 1, "isNeedPskey we should re - setAllCookies");
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  void reset()
  {
    this.state.set(1);
    this.cXz = false;
    this.aun = 0L;
  }
  
  public static class CookiesMap
    extends Hashtable<String, ArrayList<String>>
  {
    public void addCookie(String paramString1, String paramString2)
    {
      try
      {
        getCookies(paramString1).add(paramString2);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    public ArrayList<String> getCookies(String paramString)
    {
      try
      {
        ArrayList localArrayList2 = (ArrayList)get(paramString);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          put(paramString, localArrayList1);
        }
        return localArrayList1;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Bundle paramBundle, long paramLong);
  }
  
  static class b
    implements TicketManagerListener
  {
    public void onTicketRefreshed()
    {
      QLog.i("SwiftBrowserCookieMonster", 1, "TicketManager invoke onTicketRefreshed");
      SwiftBrowserCookieMonster.egU();
      SwiftBrowserCookieMonster.b(MobileQQ.sMobileQQ.waitAppRuntime(null), new Intent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster
 * JD-Core Version:    0.7.0.1
 */