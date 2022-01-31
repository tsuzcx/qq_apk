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
import android.text.TextUtils;
import java.io.File;
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
  public static final String PID_MOBILE_QQ = "50079";
  public static final String PID_QQPIM = "50190";
  public static final String QQBROWSER_DOWNLOAD_URL = "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  public static final int RESULT_INVALID_CONTEXT = 3;
  public static final int RESULT_INVALID_URL = 2;
  public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
  public static final int RESULT_OK = 0;
  public static final int RESULT_QQBROWSER_LOW = 5;
  public static final int RESULT_UNKNOWN = 1;
  private static final int SUPPORT_3RD_PARTY_CALL_VERSION = 33;
  private static final int SUPPORT_QB_SCHEME_VERSION = 42;
  private static final int VERSION_420 = 420000;
  
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
  
  private static BrowserInfo getBrowserInfo(Context paramContext)
  {
    localBrowserInfo = new BrowserInfo();
    label146:
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
        break label146;
      }
    } while (paramContext == null);
    localBrowserInfo.ver = paramContext.versionCode;
    localBrowserInfo.quahead += paramContext.versionName.replaceAll("\\.", "");
    return localBrowserInfo;
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
  
  private static boolean isBrowserInstalled(Context paramContext)
  {
    return getBrowserInfo(paramContext).browserType != -1;
  }
  
  private static boolean isSupportQBScheme(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    if (paramContext.browserType == -1) {}
    while ((paramContext.browserType == 2) && (paramContext.ver < 42)) {
      return false;
    }
    return true;
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
    int i = 26;
    paramHashMap = paramContext.getApplicationInfo().processName;
    if (paramHashMap.contains("com.tencent.mobileqq")) {
      i = 13;
    }
    for (;;)
    {
      try
      {
        paramString.putExtra("loginType", i);
        paramContext.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramContext) {}
      if (paramHashMap.contains("com.qzone")) {
        i = 14;
      } else if (paramHashMap.contains("com.tencent.WBlog")) {
        i = 15;
      } else if (paramHashMap.contains("com.tencent.mm")) {
        i = 24;
      }
    }
    return 4;
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap)
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
      paramContext.startActivity(localIntent);
      return true;
      localIntent.putExtra("key_reader_sdk_url", paramString1);
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
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      label138:
      break label138;
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
  
  public static class BrowserInfo
  {
    public int browserType = -1;
    public String quahead = "";
    public int ver = -1;
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