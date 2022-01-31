package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MttLoader
{
  private static final int BROWSER_MTT = 2;
  private static final int BROWSER_NONE = -1;
  private static final int BROWSER_QBX = 0;
  private static final int BROWSER_QBX5 = 1;
  public static final String CHANNEL_ID = "ChannelID";
  @Deprecated
  public static final String KEY_ACTIVITY_NAME = "KEY_ACT";
  @Deprecated
  public static final String KEY_APP_NAME = "KEY_APPNAME";
  public static final String KEY_EUSESTAT = "KEY_EUSESTAT";
  @Deprecated
  public static final String KEY_PACKAGE = "KEY_PKG";
  public static final String KEY_PID = "KEY_PID";
  private static final String LOGIN_TYPE_KEY = "loginType";
  private static final int LOGIN_TYPE_VALUE_MM = 24;
  private static final int LOGIN_TYPE_VALUE_OTHERS = 26;
  private static final int LOGIN_TYPE_VALUE_QQ = 13;
  private static final int LOGIN_TYPE_VALUE_QQMICROBLOG = 15;
  private static final int LOGIN_TYPE_VALUE_QZONE = 14;
  public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
  public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
  private static final String MTT_PACKAGE_MTT = "com.tencent.mtt";
  private static final String MTT_PACKAGE_MTT_X86 = "com.tencent.mtt.x86";
  private static final String MTT_PACKAGE_QBX = "com.tencent.qbx";
  private static final String MTT_PACKAGE_QBX5 = "com.tencent.qbx5";
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  public static final String PID_ARTICLE_NEWS = "21272";
  public static final String PID_MOBILE_QQ = "50079";
  public static final String PID_QQPIM = "50190";
  public static final String PID_QZONE = "10494";
  public static final String PID_WECHAT = "10318";
  public static final String POS_ID = "PosID";
  public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final String QQBROWSER_DOWNLOAD_URL = "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  private static final String QQBROWSER_PARAMS_ENCODE = ",encoded=1";
  public static final String QQBROWSER_PARAMS_FROME = ",from=";
  public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
  public static final String QQBROWSER_PARAMS_PD = ",product=";
  public static final String QQBROWSER_PARAMS_VERSION = ",version=";
  public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
  public static final int RESULT_INVALID_CONTEXT = 3;
  public static final int RESULT_INVALID_URL = 2;
  public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
  public static final int RESULT_OK = 0;
  public static final int RESULT_QQBROWSER_LOW = 5;
  public static final int RESULT_UNKNOWN = 1;
  public static final String STAT_KEY = "StatKey";
  private static final int SUPPORT_3RD_PARTY_CALL_VERSION = 33;
  private static final int SUPPORT_QB_SCHEME_VERSION = 42;
  private static final int VERSION_420 = 420000;
  private static final int VERSION_580 = 580000;
  private static final int VERSION_601 = 601000;
  
  private static String certToCharsString(Certificate paramCertificate)
    throws CertificateEncodingException
  {
    paramCertificate = paramCertificate.getEncoded();
    int k = paramCertificate.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramCertificate[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label49:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label102;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label49;
        label102:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static BrowserPackageInfo chooseClassName(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramContext.size() <= 0)
    {
      paramContext = null;
      return paramContext;
    }
    paramUri = new BrowserPackageInfo(null);
    localObject = paramContext.iterator();
    for (;;)
    {
      paramContext = paramUri;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramContext = (ResolveInfo)((Iterator)localObject).next();
      String str = paramContext.activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramUri.classname = paramContext.activityInfo.name;
        paramUri.packagename = paramContext.activityInfo.packageName;
        return paramUri;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramUri.classname = paramContext.activityInfo.name;
        paramUri.packagename = paramContext.activityInfo.packageName;
      }
    }
  }
  
  public static BrowserInfo getBrowserInfo(Context paramContext)
  {
    localBrowserInfo = new BrowserInfo();
    label187:
    do
    {
      PackageManager localPackageManager;
      Object localObject6;
      Object localObject4;
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          localBrowserInfo.browserType = 2;
          localObject1 = localObject6;
          localBrowserInfo.packageName = "com.tencent.mtt";
          localObject1 = localObject6;
          localBrowserInfo.quahead = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              localBrowserInfo.ver = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              localBrowserInfo.quahead += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              localObject1 = localObject6;
              localBrowserInfo.vn = ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              return localBrowserInfo;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        return localBrowserInfo;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        localBrowserInfo.browserType = 0;
        localObject4 = localObject1;
        localBrowserInfo.packageName = "com.tencent.qbx";
        localObject4 = localObject1;
        localBrowserInfo.quahead = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          PackageInfo localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          localBrowserInfo.browserType = 1;
          localObject4 = localPackageInfo1;
          localBrowserInfo.packageName = "com.tencent.qbx5";
          localObject4 = localPackageInfo1;
          localBrowserInfo.quahead = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          for (;;)
          {
            Object localObject2 = localObject4;
            try
            {
              localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
              localObject2 = localObject4;
              localBrowserInfo.packageName = "com.tencent.mtt";
              localObject2 = localObject4;
              localBrowserInfo.browserType = 2;
              localObject2 = localObject4;
              localBrowserInfo.quahead = "ADRQB_";
              paramContext = (Context)localObject4;
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException4)
            {
              try
              {
                PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                localObject2 = localPackageInfo2;
                localBrowserInfo.packageName = "com.tencent.mtt.x86";
                localObject2 = localPackageInfo2;
                localBrowserInfo.browserType = 2;
                localObject2 = localPackageInfo2;
                localBrowserInfo.quahead = "ADRQB_";
                paramContext = localPackageInfo2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Object localObject5 = localObject2;
                  try
                  {
                    localObject6 = chooseClassName(paramContext, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                    paramContext = localObject2;
                    if (localObject6 == null) {
                      break;
                    }
                    paramContext = localObject2;
                    localObject5 = localObject2;
                    if (TextUtils.isEmpty(((BrowserPackageInfo)localObject6).packagename)) {
                      break;
                    }
                    localObject5 = localObject2;
                    paramContext = localPackageManager.getPackageInfo(((BrowserPackageInfo)localObject6).packagename, 0);
                    localObject5 = paramContext;
                    localBrowserInfo.packageName = ((BrowserPackageInfo)localObject6).packagename;
                    localObject5 = paramContext;
                    localBrowserInfo.browserType = 2;
                    localObject5 = paramContext;
                    localBrowserInfo.quahead = "ADRQB_";
                  }
                  catch (Exception paramContext)
                  {
                    paramContext = (Context)localObject5;
                  }
                }
              }
            }
          }
        }
        break label187;
      }
    } while (paramContext == null);
    localBrowserInfo.ver = paramContext.versionCode;
    localBrowserInfo.quahead += paramContext.versionName.replaceAll("\\.", "");
    localBrowserInfo.vn = paramContext.versionName.replaceAll("\\.", "");
    return localBrowserInfo;
  }
  
  public static String getDownloadUrlWithQb(String paramString)
  {
    try
    {
      paramString = "http://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  }
  
  private static int getLoginType(Context paramContext)
  {
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    do
    {
      return i;
      if (paramContext.equals("com.qzone")) {
        return 14;
      }
      if (paramContext.equals("com.tencent.WBlog")) {
        return 15;
      }
    } while (!paramContext.equals("com.tencent.mm"));
    return 24;
  }
  
  public static String getValidQBUrl(Context paramContext, String paramString)
  {
    String str = paramString;
    int j;
    int i;
    if (paramString.toLowerCase().startsWith("qb://"))
    {
      j = 0;
      paramContext = getBrowserInfo(paramContext);
      if (paramContext.browserType != -1) {
        break label49;
      }
      i = 1;
    }
    for (;;)
    {
      str = paramString;
      if (i != 0) {
        str = getDownloadUrlWithQb(paramString);
      }
      return str;
      label49:
      i = j;
      if (paramContext.browserType == 2)
      {
        i = j;
        if (paramContext.ver < 33) {
          i = 1;
        }
      }
    }
  }
  
  private static boolean hasValidProtocal(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.toLowerCase().indexOf("://");
      j = paramString.toLowerCase().indexOf('.');
    } while ((i > 0) && (j > 0) && (i > j));
    return paramString.toLowerCase().contains("://");
  }
  
  public static boolean isBrowserInstalled(Context paramContext)
  {
    return getBrowserInfo(paramContext).browserType != -1;
  }
  
  public static boolean isBrowserInstalledEx(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= 6001500L) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= 601500) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isGreatBrowserVer(Context paramContext, long paramLong1, long paramLong2)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= paramLong1) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= paramLong2) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSupportQBScheme(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    if (paramContext.browserType == -1) {}
    while ((paramContext.browserType == 2) && (paramContext.ver < 42)) {
      return false;
    }
    return true;
  }
  
  public static boolean isSupportingTbsTips(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    return (paramContext.browserType == 2) && (paramContext.ver >= 580000);
  }
  
  public static int loadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      return 3;
    }
    Object localObject1 = paramString;
    if (!hasValidProtocal(paramString)) {
      localObject1 = "http://" + paramString;
    }
    Object localObject2;
    try
    {
      localObject2 = Uri.parse((String)localObject1);
      if (localObject2 == null) {
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      return 2;
    }
    Object localObject3 = getBrowserInfo(paramContext);
    if (((BrowserInfo)localObject3).browserType == -1) {
      return 4;
    }
    if ((((BrowserInfo)localObject3).browserType == 2) && (((BrowserInfo)localObject3).ver < 33)) {
      return 5;
    }
    localObject1 = new Intent("android.intent.action.VIEW");
    if (((BrowserInfo)localObject3).browserType == 2) {
      if ((((BrowserInfo)localObject3).ver >= 33) && (((BrowserInfo)localObject3).ver <= 39))
      {
        ((Intent)localObject1).setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
        paramString = (String)localObject1;
      }
    }
    for (;;)
    {
      paramString.setData((Uri)localObject2);
      if (paramHashMap == null) {
        break;
      }
      localObject1 = paramHashMap.keySet();
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (String)paramHashMap.get(localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramString.putExtra((String)localObject2, (String)localObject3);
        }
      }
      if ((((BrowserInfo)localObject3).ver >= 40) && (((BrowserInfo)localObject3).ver <= 45))
      {
        ((Intent)localObject1).setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
        paramString = (String)localObject1;
      }
      else
      {
        paramString = (String)localObject1;
        if (((BrowserInfo)localObject3).ver >= 46)
        {
          localObject1 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject3 = chooseClassName(paramContext, (Uri)localObject2);
          paramString = (String)localObject1;
          if (localObject3 != null)
          {
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty(((BrowserPackageInfo)localObject3).classname))
            {
              ((Intent)localObject1).setClassName(((BrowserPackageInfo)localObject3).packagename, ((BrowserPackageInfo)localObject3).classname);
              paramString = (String)localObject1;
              continue;
              if (((BrowserInfo)localObject3).browserType == 1)
              {
                if (((BrowserInfo)localObject3).ver == 1)
                {
                  ((Intent)localObject1).setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                  paramString = (String)localObject1;
                }
                else
                {
                  paramString = (String)localObject1;
                  if (((BrowserInfo)localObject3).ver == 2)
                  {
                    ((Intent)localObject1).setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                    paramString = (String)localObject1;
                  }
                }
              }
              else if (((BrowserInfo)localObject3).browserType == 0)
              {
                if ((((BrowserInfo)localObject3).ver >= 4) && (((BrowserInfo)localObject3).ver <= 6))
                {
                  ((Intent)localObject1).setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                  paramString = (String)localObject1;
                }
                else
                {
                  paramString = (String)localObject1;
                  if (((BrowserInfo)localObject3).ver > 6)
                  {
                    localObject1 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    localObject3 = chooseClassName(paramContext, (Uri)localObject2);
                    paramString = (String)localObject1;
                    if (localObject3 != null)
                    {
                      paramString = (String)localObject1;
                      if (!TextUtils.isEmpty(((BrowserPackageInfo)localObject3).classname))
                      {
                        ((Intent)localObject1).setClassName(((BrowserPackageInfo)localObject3).packagename, ((BrowserPackageInfo)localObject3).classname);
                        paramString = (String)localObject1;
                      }
                    }
                  }
                }
              }
              else
              {
                localObject1 = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject3 = chooseClassName(paramContext, (Uri)localObject2);
                paramString = (String)localObject1;
                if (localObject3 != null)
                {
                  paramString = (String)localObject1;
                  if (!TextUtils.isEmpty(((BrowserPackageInfo)localObject3).classname))
                  {
                    ((Intent)localObject1).setClassName(((BrowserPackageInfo)localObject3).packagename, ((BrowserPackageInfo)localObject3).classname);
                    paramString = (String)localObject1;
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      paramString.putExtra("loginType", getLoginType(paramContext));
      paramString.addFlags(268435456);
      paramContext.startActivity(paramString);
      return 0;
    }
    catch (ActivityNotFoundException paramContext) {}
    return 4;
  }
  
  public static int loadUrl(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    j = 0;
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        i = j;
        if (localObject != null)
        {
          localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
          i = j;
          if (localObject != null)
          {
            int k = ((PackageInfo)localObject).versionCode;
            i = j;
            if (k > 601000) {
              i = 1;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        int i = j;
        continue;
      }
      try
      {
        localObject = URLEncoder.encode(paramString1, "UTF-8");
        j = i;
        if (i != 0)
        {
          paramString1 = (String)localObject;
          j = i;
        }
      }
      catch (Exception localException)
      {
        j = 0;
        continue;
        str = "";
      }
    }
    if (j != 0)
    {
      localObject = ",encoded=1";
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=").append("TBS").append(",packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=").append("2.0.0.1044").append((String)localObject);
      return loadUrl(paramContext, localStringBuilder.toString(), paramHashMap);
    }
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap)
  {
    return openDocWithQb(paramContext, paramString1, paramInt, paramString2, paramHashMap, null);
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    Intent localIntent;
    try
    {
      localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
      if (paramHashMap != null)
      {
        Object localObject = paramHashMap.keySet();
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = (String)paramHashMap.get(str1);
            if (!TextUtils.isEmpty(str2)) {
              localIntent.putExtra(str1, str2);
            }
          }
        }
      }
      paramHashMap = new File(paramString1);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    localIntent.putExtra("key_reader_sdk_id", 3);
    localIntent.putExtra("key_reader_sdk_type", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("key_reader_sdk_path", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      localIntent.setData(Uri.fromFile(paramHashMap));
      localIntent.putExtra("loginType", getLoginType(paramContext.getApplicationContext()));
      if (paramBundle != null) {
        localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return true;
      if (paramInt == 1) {
        localIntent.putExtra("key_reader_sdk_url", paramString1);
      }
    }
  }
  
  public static boolean openVideoWithQb(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Uri.parse(paramString);
    paramString = new Intent("android.intent.action.VIEW");
    paramString.setFlags(268435456);
    paramString.setDataAndType((Uri)localObject, "video/*");
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.putExtra(str1, str2);
          }
        }
      }
    }
    int i = 0;
    try
    {
      paramString.putExtra("loginType", getLoginType(paramContext));
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      label149:
      break label149;
    }
    if (i == 0) {}
    try
    {
      paramString.setComponent(null);
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
  }
  
  /* Error */
  public static boolean verifySignature(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 7
    //   17: new 524	java/util/jar/JarFile
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 527	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: aload 5
    //   29: astore_0
    //   30: aload 6
    //   32: astore_3
    //   33: aload 4
    //   35: ldc_w 529
    //   38: invokevirtual 533	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   41: astore 8
    //   43: aload 8
    //   45: ifnonnull +27 -> 72
    //   48: iconst_0
    //   49: ifeq +11 -> 60
    //   52: new 535	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 536	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 5
    //   74: astore_0
    //   75: aload 6
    //   77: astore_3
    //   78: sipush 8192
    //   81: newarray byte
    //   83: astore 7
    //   85: aload 5
    //   87: astore_0
    //   88: aload 6
    //   90: astore_3
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 543	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   98: astore 5
    //   100: aload 5
    //   102: astore_0
    //   103: aload 5
    //   105: astore_3
    //   106: aload 5
    //   108: aload 7
    //   110: iconst_0
    //   111: aload 7
    //   113: arraylength
    //   114: invokevirtual 549	java/io/InputStream:read	([BII)I
    //   117: iconst_m1
    //   118: if_icmpne -18 -> 100
    //   121: aload 5
    //   123: astore_0
    //   124: aload 5
    //   126: astore_3
    //   127: aload 5
    //   129: invokevirtual 550	java/io/InputStream:close	()V
    //   132: aload 5
    //   134: astore_0
    //   135: aload 5
    //   137: astore_3
    //   138: aload 8
    //   140: invokevirtual 556	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   143: astore 6
    //   145: aload 5
    //   147: astore_0
    //   148: aload 5
    //   150: astore_3
    //   151: aload 6
    //   153: arraylength
    //   154: istore_1
    //   155: iload_1
    //   156: iconst_1
    //   157: if_icmpge +25 -> 182
    //   160: aload 5
    //   162: ifnull +8 -> 170
    //   165: aload 5
    //   167: invokevirtual 550	java/io/InputStream:close	()V
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: aload 5
    //   184: astore_0
    //   185: aload 5
    //   187: astore_3
    //   188: aload 6
    //   190: iconst_0
    //   191: aaload
    //   192: invokestatic 558	com/tencent/smtt/sdk/stat/MttLoader:certToCharsString	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   195: astore 6
    //   197: aload 6
    //   199: ifnull +43 -> 242
    //   202: aload 5
    //   204: astore_0
    //   205: aload 5
    //   207: astore_3
    //   208: aload 6
    //   210: ldc 73
    //   212: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: istore_2
    //   216: iload_2
    //   217: ifeq +25 -> 242
    //   220: aload 5
    //   222: ifnull +8 -> 230
    //   225: aload 5
    //   227: invokevirtual 550	java/io/InputStream:close	()V
    //   230: aload 4
    //   232: ifnull +8 -> 240
    //   235: aload 4
    //   237: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   240: iconst_1
    //   241: ireturn
    //   242: aload 5
    //   244: ifnull +8 -> 252
    //   247: aload 5
    //   249: invokevirtual 550	java/io/InputStream:close	()V
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   262: iconst_0
    //   263: ireturn
    //   264: astore_0
    //   265: aload 8
    //   267: astore_3
    //   268: aload 7
    //   270: astore 4
    //   272: aload 4
    //   274: ifnull +8 -> 282
    //   277: aload 4
    //   279: invokevirtual 550	java/io/InputStream:close	()V
    //   282: aload_3
    //   283: ifnull +7 -> 290
    //   286: aload_3
    //   287: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   290: aload_0
    //   291: athrow
    //   292: astore_0
    //   293: aload 9
    //   295: astore_0
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 550	java/io/InputStream:close	()V
    //   304: aload_0
    //   305: ifnull -235 -> 70
    //   308: aload_0
    //   309: invokevirtual 539	java/util/jar/JarFile:close	()V
    //   312: iconst_0
    //   313: ireturn
    //   314: astore_0
    //   315: iconst_0
    //   316: ireturn
    //   317: astore_3
    //   318: goto -14 -> 304
    //   321: astore 4
    //   323: goto -41 -> 282
    //   326: astore_3
    //   327: goto -37 -> 290
    //   330: astore_0
    //   331: goto -271 -> 60
    //   334: astore_0
    //   335: goto -265 -> 70
    //   338: astore_0
    //   339: goto -169 -> 170
    //   342: astore_0
    //   343: goto -163 -> 180
    //   346: astore_0
    //   347: goto -117 -> 230
    //   350: astore_0
    //   351: goto -111 -> 240
    //   354: astore_0
    //   355: goto -103 -> 252
    //   358: astore_0
    //   359: goto -97 -> 262
    //   362: astore 5
    //   364: aload 4
    //   366: astore_3
    //   367: aload_0
    //   368: astore 4
    //   370: aload 5
    //   372: astore_0
    //   373: goto -101 -> 272
    //   376: astore_0
    //   377: aload 4
    //   379: astore_0
    //   380: goto -84 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramFile	File
    //   154	4	1	i	int
    //   215	2	2	bool	boolean
    //   7	294	3	localObject1	Object
    //   317	1	3	localIOException1	java.io.IOException
    //   326	1	3	localIOException2	java.io.IOException
    //   366	1	3	localObject2	Object
    //   25	253	4	localObject3	Object
    //   321	44	4	localIOException3	java.io.IOException
    //   368	10	4	localFile	File
    //   9	239	5	localInputStream	java.io.InputStream
    //   362	9	5	localObject4	Object
    //   12	197	6	localObject5	Object
    //   15	254	7	arrayOfByte	byte[]
    //   4	262	8	localJarEntry	java.util.jar.JarEntry
    //   1	293	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	264	finally
    //   17	27	292	java/lang/Throwable
    //   308	312	314	java/io/IOException
    //   300	304	317	java/io/IOException
    //   277	282	321	java/io/IOException
    //   286	290	326	java/io/IOException
    //   52	60	330	java/io/IOException
    //   65	70	334	java/io/IOException
    //   165	170	338	java/io/IOException
    //   175	180	342	java/io/IOException
    //   225	230	346	java/io/IOException
    //   235	240	350	java/io/IOException
    //   247	252	354	java/io/IOException
    //   257	262	358	java/io/IOException
    //   33	43	362	finally
    //   78	85	362	finally
    //   91	100	362	finally
    //   106	121	362	finally
    //   127	132	362	finally
    //   138	145	362	finally
    //   151	155	362	finally
    //   188	197	362	finally
    //   208	216	362	finally
    //   33	43	376	java/lang/Throwable
    //   78	85	376	java/lang/Throwable
    //   91	100	376	java/lang/Throwable
    //   106	121	376	java/lang/Throwable
    //   127	132	376	java/lang/Throwable
    //   138	145	376	java/lang/Throwable
    //   151	155	376	java/lang/Throwable
    //   188	197	376	java/lang/Throwable
    //   208	216	376	java/lang/Throwable
  }
  
  public static class BrowserInfo
  {
    public int browserType = -1;
    public String packageName = null;
    public String quahead = "";
    public int ver = -1;
    public String vn = "0";
  }
  
  private static class BrowserPackageInfo
  {
    public String classname = "";
    public String packagename = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.MttLoader
 * JD-Core Version:    0.7.0.1
 */