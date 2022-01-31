package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import android.widget.Toast;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.Post3DESEncryption;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static final String AD_WEBVIEW_CLICK_STAT_KEY = "ad_webview_click_stat_key";
  private static final String AD_WEBVIEW_CLICK_STAT_POSID_FOR_QB = "ad_webview_click_stat_posid_for_qb";
  private static final String AD_WEBVIEW_DETAIL_URL = "ad_webview_detail_url";
  private static final int CAN_LOAD_X5_FALSE = -1;
  private static final String EXTENSION_DEX_FILE = "tbs_sdk_extension_dex.jar";
  private static final String EXTENSION_IMPL_CLASS = "com.tencent.tbs.sdk.extension.TbsSDKExtension";
  private static final int IS_X5ENABLE_FALSE = -2;
  private static final String KEY_FOR_MOBILEQQ_CURRENT_URL = "curUrlQQ";
  private static final String KEY_RESULT_CODE = "result_code";
  private static final String KEY_TBS_CORE_VERSION = "tbs_core_version";
  private static final String KEY_TBS_JARFILES = "tbs_jarfiles";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  private static final String MIDPAGEEXTURL = "mttbrowser://miniqb/ch=icon?";
  private static final String MINIQB_HOME_PAGE = "miniqb://home";
  private static final String MINIQB_HOME_PAGE_JUMPQB_URL = "qb://navicard/addCard?cardId=168&cardName=168";
  private static final String MINIQB_HOME_PAGE_NEW = "http://adsolution.imtt.qq.com/index?p=tad&u=";
  private static final String MINIQB_HOME_PAGE_NEW_TEST = "http://redpacket.cs0309.imtt.qq.com/index?p=tad&u=";
  private static final int MSG_CORE_INITED = 3;
  private static final int MSG_INIT_SYSCORE = 2;
  private static final int MSG_INIT_X5CORE = 1;
  private static final int PRELOAD_X5_COUNTER_MAX = 3;
  public static final int SVNVERSION = 352876;
  private static final String TAG = "QbSdk";
  private static final int TBS_OLD_CORE_VERSION = 25438;
  static final String TBS_PRELOAD_X5_COUNTER = "tbs_preload_x5_counter";
  static final String TBS_PRELOAD_X5_RECORDER = "tbs_preload_x5_recorder";
  static final String TBS_PRELOAD_X5_VERSION = "tbs_preload_x5_version";
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  private static boolean isPreloadX5Checking;
  private static boolean mDownloadWithoutWifi = false;
  private static boolean mIsPreInitialized;
  static boolean mIsSysWebViewForced;
  static boolean mIsSysWebViewForcedByOuter;
  private static String mQQBuildNumber;
  private static boolean mTBSInstalling = false;
  private static String mTID;
  public static boolean mTbsDebugInstallOnline;
  private static TbsListener mTbsListener;
  public static TbsListener mTbsListenerDebug;
  static TbsListener mTbsListenerWrapper = new TbsListener()
  {
    public void onDownloadFinish(int paramAnonymousInt)
    {
      TbsDownloader.mIsDownloading = false;
      if (QbSdk.mTbsListener != null) {
        QbSdk.mTbsListener.onDownloadFinish(paramAnonymousInt);
      }
      if (QbSdk.mTbsListenerDebug != null) {
        QbSdk.mTbsListenerDebug.onDownloadFinish(paramAnonymousInt);
      }
    }
    
    public void onDownloadProgress(int paramAnonymousInt)
    {
      if (QbSdk.mTbsListenerDebug != null) {
        QbSdk.mTbsListenerDebug.onDownloadProgress(paramAnonymousInt);
      }
      if (QbSdk.mTbsListener != null) {
        QbSdk.mTbsListener.onDownloadProgress(paramAnonymousInt);
      }
    }
    
    public void onInstallFinish(int paramAnonymousInt)
    {
      QbSdk.setTBSInstallingStatus(false);
      TbsDownloader.mIsDownloading = false;
      if (QbSdk.mTbsListener != null) {
        QbSdk.mTbsListener.onInstallFinish(paramAnonymousInt);
      }
      if (QbSdk.mTbsListenerDebug != null) {
        QbSdk.mTbsListenerDebug.onInstallFinish(paramAnonymousInt);
      }
    }
  };
  static volatile boolean mTmpIsSysWebViewForced;
  private static Class<?> sExtensionClass;
  private static Object sExtensionObj;
  public static boolean sIsVersionPrinted = false;
  private static String[] sJarFiles;
  private static int sTbsVersion;
  private static String sTbsVersionString = "";
  
  static
  {
    mIsSysWebViewForced = false;
    mIsSysWebViewForcedByOuter = false;
    mIsPreInitialized = false;
    mTID = null;
    mQQBuildNumber = null;
    mTmpIsSysWebViewForced = mIsSysWebViewForced;
    isPreloadX5Checking = true;
    mTbsListener = null;
    mTbsListenerDebug = null;
    mTbsDebugInstallOnline = false;
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  static boolean canLoadX5(Context paramContext, boolean paramBoolean)
  {
    return canLoadX5(paramContext, paramBoolean, false);
  }
  
  static boolean canLoadX5(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = false;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.isShareTbsCoreAvailableInner(paramContext)))
    {
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302);
      paramBoolean2 = false;
      return paramBoolean2;
    }
    if (!init(paramContext, paramBoolean1))
    {
      TbsLog.e("loaderror", "315");
      return false;
    }
    Object localObject1 = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(36001) });
    if (localObject1 != null)
    {
      if (((localObject1 instanceof String)) && (((String)localObject1).equalsIgnoreCase("AuthenticationFail")))
      {
        if (!paramBoolean2) {
          Toast.makeText(paramContext, "Authentication fail, use sys webview, please contact tencent ", 1).show();
        }
        TbsLog.e("loaderror", "317");
        return false;
      }
      localObject1 = (Bundle)localObject1;
      int j = ((Bundle)localObject1).getInt("result_code", -1);
      if (j == 0)
      {
        paramBoolean1 = true;
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label283;
        }
        SDKEngine.setTbsCoreVersion(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
        sTbsVersionString = String.valueOf(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
        if (sTbsVersionString.length() == 5) {
          sTbsVersionString = "0" + sTbsVersionString;
        }
        if (sTbsVersionString.length() != 6) {
          sTbsVersionString = "";
        }
        sJarFiles = ((Bundle)localObject1).getStringArray("tbs_jarfiles");
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (!paramBoolean1) {
          TbsLog.e("loaderror", "319");
        }
        return paramBoolean1;
        paramBoolean1 = false;
        break;
        label283:
        if (Build.VERSION.SDK_INT >= 12) {
          sTbsVersionString = ((Bundle)localObject1).getString("tbs_core_version", "0");
        }
        try
        {
          for (;;)
          {
            sTbsVersion = Integer.parseInt(sTbsVersionString);
            SDKEngine.setTbsCoreVersion(sTbsVersion);
            if (((sTbsVersion <= 0) || (sTbsVersion > 25438)) && (sTbsVersion != 25472)) {
              break label413;
            }
            i = 1;
            if (i == 0) {
              break;
            }
            FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307);
            TbsLog.e("loaderror", "is_obsolete -- delete 319");
            return false;
            sTbsVersionString = ((Bundle)localObject1).getString("tbs_core_version");
            if (sTbsVersionString == null) {
              sTbsVersionString = "0";
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            sTbsVersion = 0;
            continue;
            label413:
            i = 0;
          }
        }
      }
      try
      {
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          localObject1 = ReflectionUtils.invokeInstance(sExtensionObj, "getErrorCodeForLogReport", new Class[0], new Object[0]);
          if (localObject1 != null)
          {
            i = ((Integer)localObject1).intValue();
            if (i != -1) {
              TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, i);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307);
      continue;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 404);
      continue;
      Object localObject2 = sExtensionObj;
      Class localClass = Integer.TYPE;
      int i = DeviceInfo.getTotalRAM();
      localObject2 = ReflectionUtils.invokeInstance(localObject2, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i) });
      if (localObject2 != null)
      {
        if (((localObject2 instanceof String)) && (((String)localObject2).equalsIgnoreCase("AuthenticationFail")))
        {
          if (!paramBoolean2) {
            Toast.makeText(paramContext, "Authentication fail, use sys webview, please contact tencent ", 1).show();
          }
          TbsLog.e("loaderror", "317");
          return false;
        }
        paramBoolean1 = bool1;
        if ((localObject2 instanceof Boolean))
        {
          bool1 = SDKEngine.isSupportable(paramContext);
          boolean bool2 = isX5Disabled(paramContext, SDKEngine.getTbsCoreVersion());
          sTbsVersion = SDKEngine.getTbsCoreVersion();
          if ((((Boolean)localObject2).booleanValue()) && (bool1) && (!bool2)) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            paramBoolean2 = paramBoolean1;
            if (paramBoolean1) {
              break;
            }
            TbsLog.e("loaderror", "318");
            TbsLog.w("loaderror", "isSupportable:" + bool1);
            TbsLog.w("loaderror", "isX5Disable:" + bool2);
            TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject2);
            return paramBoolean1;
          }
        }
      }
      else
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 308);
        paramBoolean1 = bool1;
      }
    }
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!init(paramContext, false)) {}
    return false;
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)paramContext).booleanValue();
      }
    }
    return bool1;
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    try
    {
      new android.webkit.WebView(paramContext).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      SDKEngine localSDKEngine;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          if (new WebView(paramContext).getWebViewClientExtension() != null)
          {
            localSDKEngine = SDKEngine.getInstance(false);
            if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
              localSDKEngine.wizard().clearAllX5Cache(paramContext, paramBoolean);
            }
          }
          return;
        }
        catch (Throwable paramContext) {}
        localThrowable = localThrowable;
        TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(localThrowable));
      }
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localSDKEngine.wizard().dexLoader();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  private static boolean deleteFilesUseless(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      File localFile1 = new File(paramContext.getFilesDir().getParentFile().getPath() + "/app_x5core");
      bool1 = bool2;
      if (localFile1 != null)
      {
        bool1 = bool2;
        if (localFile1.exists())
        {
          if (!localFile1.isDirectory()) {
            return true;
          }
          FileUtil.delete(new File(paramContext.getFilesDir().getParentFile().getPath() + "/app_tes_private"));
          File localFile2 = new File(paramContext.getFilesDir().getParentFile().getPath() + "/app_appcache");
          FileUtil.delete(new File(localFile2, "ApplicationCache.db"));
          FileUtil.delete(new File(localFile2, "cache.db"));
          localFile2 = paramContext.getCacheDir();
          FileUtil.delete(new File(localFile2, "com.android.renderscript.cache"));
          FileUtil.delete(new File(localFile2, "webviewCache"));
          FileUtil.delete(new File(localFile2, "webviewCacheChromium"));
          FileUtil.delete(new File(localFile2, "webviewCacheChromiumStaging"));
          FileUtil.delete(paramContext.getDatabasePath("smtt_webviewPrivate.db"));
          FileUtil.delete(paramContext.getDatabasePath("smtt_webviewPrivate.db-journal"));
          FileUtil.delete(paramContext.getDatabasePath("webview.db"));
          FileUtil.delete(paramContext.getDatabasePath("webview.db-journal"));
          FileUtil.delete(paramContext.getDatabasePath("webviewCache_x5.db"));
          FileUtil.delete(paramContext.getDatabasePath("webviewCache_x5.db-journal"));
          FileUtil.delete(paramContext.getDatabasePath("webviewCookiesChromium.db"));
          FileUtil.delete(paramContext.getDatabasePath("webviewCookiesChromiumPrivate.db"));
          FileUtil.delete(paramContext.getDatabasePath("webview_x5.db"));
          FileUtil.delete(paramContext.getDatabasePath("webview_x5.db-journal"));
          FileUtil.delete(new File(paramContext.getFilesDir(), "safe_uxss.js"));
          FileUtil.delete(new File(paramContext.getFilesDir().getParentFile().getPath() + "/lib" + "/libwebviewext.so"));
          FileUtil.delete(new File(paramContext.getFilesDir().getParentFile().getPath() + "/shared_prefs" + "/SHARED_PREFERENCE_SECURE_WEBVIEW.xml"));
          FileUtil.delete(new File(paramContext.getFilesDir().getParentFile().getPath() + "/shared_prefs" + "/x5_config.xml"));
          FileUtil.delete(localFile1);
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "deleteFilesUseless Exception: " + Log.getStackTraceString(paramContext));
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    SDKEngine localSDKEngine;
    do
    {
      do
      {
        return false;
        localSDKEngine = SDKEngine.getInstance(false);
      } while ((localSDKEngine == null) || (!localSDKEngine.isX5Core()));
    } while (localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void forceSysWebView()
  {
    mIsSysWebViewForcedByOuter = true;
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  static void forceSysWebViewInner()
  {
    mIsSysWebViewForced = true;
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedInner");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l = 0L;
    if (paramContext != null) {
      l = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    if (sJarFiles != null)
    {
      int j = sJarFiles.length;
      paramContext2 = new String[j];
      int i = 0;
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i >= j) {
          break;
        }
        paramContext2[i] = (paramString + sJarFiles[i]);
        i += 1;
      }
    }
    paramContext1 = ReflectionUtils.invokeInstance(sExtensionObj, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if (paramContext1 == null) {
      paramContext1 = "";
    }
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return mDownloadWithoutWifi;
  }
  
  public static String getQQBuildNumber()
  {
    return mQQBuildNumber;
  }
  
  public static boolean getTBSInstalling()
  {
    return mTBSInstalling;
  }
  
  public static String getTID()
  {
    return mTID;
  }
  
  static String getTbsCoreVersionString()
  {
    return sTbsVersionString;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    deleteFilesUseless(paramContext);
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.getAvailableTbsCoreVersion(paramContext);
    }
    return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  public static String getX5CoreTimestamp()
  {
    Object localObject = ReflectionUtils.invokeStatic(sExtensionClass, "getX5CoreTimestamp", null, new Object[0]);
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  static Bundle incrUpdate(Context paramContext, Bundle paramBundle)
    throws Exception
  {
    if (!initForPatch(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = ReflectionUtils.invokeInstance(sExtensionObj, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean init(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 126	com/tencent/smtt/sdk/QbSdk:sIsVersionPrinted	Z
    //   3: ifne +15 -> 18
    //   6: ldc 82
    //   8: ldc_w 661
    //   11: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: iconst_1
    //   15: putstatic 126	com/tencent/smtt/sdk/QbSdk:sIsVersionPrinted	Z
    //   18: getstatic 132	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForced	Z
    //   21: ifeq +28 -> 49
    //   24: iload_1
    //   25: ifne +24 -> 49
    //   28: ldc 82
    //   30: ldc_w 663
    //   33: iconst_0
    //   34: invokestatic 666	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   37: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   40: aload_0
    //   41: sipush 401
    //   44: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   47: iconst_0
    //   48: ireturn
    //   49: getstatic 134	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForcedByOuter	Z
    //   52: ifeq +24 -> 76
    //   55: ldc 82
    //   57: ldc_w 668
    //   60: iconst_1
    //   61: invokestatic 666	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   64: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   67: aload_0
    //   68: sipush 402
    //   71: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   74: iconst_0
    //   75: ireturn
    //   76: getstatic 144	com/tencent/smtt/sdk/QbSdk:isPreloadX5Checking	Z
    //   79: ifne +7 -> 86
    //   82: aload_0
    //   83: invokestatic 671	com/tencent/smtt/sdk/QbSdk:preloadX5Check	(Landroid/content/Context;)V
    //   86: invokestatic 319	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   89: aload_0
    //   90: invokevirtual 323	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnonnull +23 -> 120
    //   100: ldc 82
    //   102: ldc_w 673
    //   105: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   111: aload_0
    //   112: sipush 312
    //   115: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: invokestatic 215	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   124: ifeq +62 -> 186
    //   127: getstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   130: ifeq +41 -> 171
    //   133: getstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   136: aload_0
    //   137: invokestatic 265	com/tencent/smtt/sdk/TbsShareManager:getAvailableTbsCoreVersion	(Landroid/content/Context;)I
    //   140: if_icmpeq +31 -> 171
    //   143: aconst_null
    //   144: putstatic 634	com/tencent/smtt/sdk/QbSdk:sExtensionClass	Ljava/lang/Class;
    //   147: aconst_null
    //   148: putstatic 167	com/tencent/smtt/sdk/QbSdk:sExtensionObj	Ljava/lang/Object;
    //   151: ldc 82
    //   153: ldc_w 675
    //   156: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   162: aload_0
    //   163: sipush 302
    //   166: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload_0
    //   172: invokestatic 265	com/tencent/smtt/sdk/TbsShareManager:getAvailableTbsCoreVersion	(Landroid/content/Context;)I
    //   175: putstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   178: getstatic 634	com/tencent/smtt/sdk/QbSdk:sExtensionClass	Ljava/lang/Class;
    //   181: ifnull +276 -> 457
    //   184: iconst_1
    //   185: ireturn
    //   186: iconst_0
    //   187: istore_2
    //   188: getstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   191: ifeq +206 -> 397
    //   194: invokestatic 319	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   197: aload_0
    //   198: invokevirtual 631	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   201: istore_3
    //   202: iload_3
    //   203: istore_2
    //   204: getstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   207: iload_3
    //   208: if_icmpeq +189 -> 397
    //   211: iload_3
    //   212: ldc_w 676
    //   215: if_icmpeq +77 -> 292
    //   218: aconst_null
    //   219: putstatic 634	com/tencent/smtt/sdk/QbSdk:sExtensionClass	Ljava/lang/Class;
    //   222: aconst_null
    //   223: putstatic 167	com/tencent/smtt/sdk/QbSdk:sExtensionObj	Ljava/lang/Object;
    //   226: ldc 82
    //   228: new 280	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 678
    //   238: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: iload_3
    //   242: invokevirtual 681	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: iconst_1
    //   249: invokestatic 666	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   252: ldc 82
    //   254: new 280	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 683
    //   264: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   270: invokevirtual 681	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: iconst_1
    //   277: invokestatic 666	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   280: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   283: aload_0
    //   284: sipush 303
    //   287: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   290: iconst_0
    //   291: ireturn
    //   292: new 503	java/io/File
    //   295: dup
    //   296: aload_0
    //   297: ldc_w 685
    //   300: iconst_0
    //   301: invokevirtual 689	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   304: ldc_w 691
    //   307: invokespecial 533	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   310: astore 4
    //   312: iload_3
    //   313: istore_2
    //   314: aload 4
    //   316: ifnull +81 -> 397
    //   319: iload_3
    //   320: istore_2
    //   321: aload 4
    //   323: invokevirtual 524	java/io/File:isDirectory	()Z
    //   326: ifeq +71 -> 397
    //   329: new 503	java/io/File
    //   332: dup
    //   333: aload 4
    //   335: ldc_w 693
    //   338: invokespecial 533	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   341: astore 4
    //   343: iload_3
    //   344: istore_2
    //   345: aload 4
    //   347: invokevirtual 521	java/io/File:exists	()Z
    //   350: ifeq +47 -> 397
    //   353: aload 4
    //   355: invokevirtual 695	java/io/File:delete	()Z
    //   358: pop
    //   359: ldc 82
    //   361: new 280	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 697
    //   371: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 4
    //   376: invokevirtual 700	java/io/File:getName	()Ljava/lang/String;
    //   379: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc_w 702
    //   385: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: iconst_1
    //   392: invokestatic 705	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   395: iload_3
    //   396: istore_2
    //   397: iload_2
    //   398: putstatic 314	com/tencent/smtt/sdk/QbSdk:sTbsVersion	I
    //   401: goto -223 -> 178
    //   404: astore 4
    //   406: ldc 82
    //   408: new 280	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 707
    //   418: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 4
    //   423: invokestatic 467	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   426: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   438: aload_0
    //   439: sipush 305
    //   442: aload 4
    //   444: invokevirtual 710	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   447: ldc 223
    //   449: ldc_w 712
    //   452: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: iconst_0
    //   456: ireturn
    //   457: aload_0
    //   458: invokestatic 215	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   461: ifeq +57 -> 518
    //   464: aload_0
    //   465: invokestatic 715	com/tencent/smtt/sdk/TbsShareManager:isShareTbsCoreAvailable	(Landroid/content/Context;)Z
    //   468: ifeq +38 -> 506
    //   471: new 503	java/io/File
    //   474: dup
    //   475: aload_0
    //   476: invokestatic 719	com/tencent/smtt/sdk/TbsShareManager:getAvailableTbsCorePath	(Landroid/content/Context;)Ljava/lang/String;
    //   479: ldc 32
    //   481: invokespecial 721	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: astore 4
    //   486: aload 4
    //   488: invokevirtual 521	java/io/File:exists	()Z
    //   491: ifne +48 -> 539
    //   494: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   497: aload_0
    //   498: sipush 403
    //   501: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   504: iconst_0
    //   505: ireturn
    //   506: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   509: aload_0
    //   510: sipush 304
    //   513: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   516: iconst_0
    //   517: ireturn
    //   518: new 503	java/io/File
    //   521: dup
    //   522: invokestatic 319	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   525: aload_0
    //   526: invokevirtual 323	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   529: ldc 32
    //   531: invokespecial 533	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   534: astore 4
    //   536: goto -50 -> 486
    //   539: new 723	dalvik/system/DexClassLoader
    //   542: dup
    //   543: aload 4
    //   545: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   548: aload 5
    //   550: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   553: aconst_null
    //   554: ldc 2
    //   556: invokevirtual 730	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   559: invokespecial 733	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   562: ldc 35
    //   564: invokevirtual 737	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   567: putstatic 634	com/tencent/smtt/sdk/QbSdk:sExtensionClass	Ljava/lang/Class;
    //   570: getstatic 634	com/tencent/smtt/sdk/QbSdk:sExtensionClass	Ljava/lang/Class;
    //   573: iconst_2
    //   574: anewarray 170	java/lang/Class
    //   577: dup
    //   578: iconst_0
    //   579: ldc_w 490
    //   582: aastore
    //   583: dup
    //   584: iconst_1
    //   585: ldc_w 490
    //   588: aastore
    //   589: invokevirtual 741	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   592: astore 4
    //   594: aload_0
    //   595: invokestatic 215	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   598: ifeq +59 -> 657
    //   601: aload 4
    //   603: iconst_2
    //   604: anewarray 4	java/lang/Object
    //   607: dup
    //   608: iconst_0
    //   609: aload_0
    //   610: aastore
    //   611: dup
    //   612: iconst_1
    //   613: aload_0
    //   614: invokestatic 745	com/tencent/smtt/sdk/TbsShareManager:getAvailableTbsCoreHostContext	(Landroid/content/Context;)Landroid/content/Context;
    //   617: aastore
    //   618: invokevirtual 751	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   621: putstatic 167	com/tencent/smtt/sdk/QbSdk:sExtensionObj	Ljava/lang/Object;
    //   624: getstatic 167	com/tencent/smtt/sdk/QbSdk:sExtensionObj	Ljava/lang/Object;
    //   627: ldc_w 753
    //   630: iconst_1
    //   631: anewarray 170	java/lang/Class
    //   634: dup
    //   635: iconst_0
    //   636: getstatic 175	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   639: aastore
    //   640: iconst_1
    //   641: anewarray 4	java/lang/Object
    //   644: dup
    //   645: iconst_0
    //   646: iconst_1
    //   647: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: aastore
    //   651: invokestatic 185	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: iconst_1
    //   656: ireturn
    //   657: aload 4
    //   659: iconst_2
    //   660: anewarray 4	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: aload_0
    //   666: aastore
    //   667: dup
    //   668: iconst_1
    //   669: aload_0
    //   670: aastore
    //   671: invokevirtual 751	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   674: putstatic 167	com/tencent/smtt/sdk/QbSdk:sExtensionObj	Ljava/lang/Object;
    //   677: goto -53 -> 624
    //   680: astore 4
    //   682: ldc 82
    //   684: new 280	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 755
    //   694: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 4
    //   699: invokestatic 467	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   702: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 231	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   714: aload_0
    //   715: sipush 306
    //   718: aload 4
    //   720: invokevirtual 710	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   723: goto -276 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	paramContext	Context
    //   0	726	1	paramBoolean	boolean
    //   187	211	2	i	int
    //   201	195	3	j	int
    //   310	65	4	localFile1	File
    //   404	39	4	localException	Exception
    //   484	174	4	localObject	Object
    //   680	39	4	localThrowable	Throwable
    //   93	456	5	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   86	95	404	java/lang/Exception
    //   100	118	404	java/lang/Exception
    //   120	169	404	java/lang/Exception
    //   171	178	404	java/lang/Exception
    //   178	184	404	java/lang/Exception
    //   188	202	404	java/lang/Exception
    //   204	211	404	java/lang/Exception
    //   218	290	404	java/lang/Exception
    //   292	312	404	java/lang/Exception
    //   321	343	404	java/lang/Exception
    //   345	395	404	java/lang/Exception
    //   397	401	404	java/lang/Exception
    //   457	486	404	java/lang/Exception
    //   486	504	404	java/lang/Exception
    //   506	516	404	java/lang/Exception
    //   518	536	404	java/lang/Exception
    //   539	624	404	java/lang/Exception
    //   624	655	404	java/lang/Exception
    //   657	677	404	java/lang/Exception
    //   86	95	680	java/lang/Throwable
    //   100	118	680	java/lang/Throwable
    //   120	169	680	java/lang/Throwable
    //   171	178	680	java/lang/Throwable
    //   178	184	680	java/lang/Throwable
    //   188	202	680	java/lang/Throwable
    //   204	211	680	java/lang/Throwable
    //   218	290	680	java/lang/Throwable
    //   292	312	680	java/lang/Throwable
    //   321	343	680	java/lang/Throwable
    //   345	395	680	java/lang/Throwable
    //   397	401	680	java/lang/Throwable
    //   457	486	680	java/lang/Throwable
    //   486	504	680	java/lang/Throwable
    //   506	516	680	java/lang/Throwable
    //   518	536	680	java/lang/Throwable
    //   539	624	680	java/lang/Throwable
    //   624	655	680	java/lang/Throwable
    //   657	677	680	java/lang/Throwable
  }
  
  static boolean initForPatch(Context paramContext)
  {
    try
    {
      if (sExtensionClass != null) {
        return true;
      }
      File localFile1 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localFile1 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForPatch (false) optDir == null");
        return false;
      }
      File localFile2 = new File(localFile1, "tbs_sdk_extension_dex.jar");
      if (!localFile2.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initForPatch (false) dexFile.exists()=false", true);
        return false;
      }
      sExtensionClass = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      sExtensionObj = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForPatch sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  private static boolean initForX5DisableConfig(Context paramContext)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (sExtensionClass != null) {
          return true;
        }
        File localFile = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
        if (localFile == null)
        {
          TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if (TbsShareManager.isShareTbsCoreAvailable(paramContext))
          {
            localObject = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar");
            if (!((File)localObject).exists()) {
              return false;
            }
          }
          else
          {
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 1001);
            return false;
          }
        }
        else
        {
          localObject = new File(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), "tbs_sdk_extension_dex.jar");
          continue;
        }
        sExtensionClass = new DexClassLoader(((File)localObject).getAbsolutePath(), localFile.getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        localObject = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class });
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          sExtensionObj = ((Constructor)localObject).newInstance(new Object[] { paramContext, TbsShareManager.getAvailableTbsCoreHostContext(paramContext) });
          ReflectionUtils.invokeInstance(sExtensionObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
        return false;
      }
      sExtensionObj = ((Constructor)localObject).newInstance(new Object[] { paramContext, paramContext });
    }
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      Context localContext = paramWebView.getContext();
      int i = paramString1.indexOf("url=");
      paramIntent = null;
      if (i > 0) {
        paramIntent = paramString1.substring(i + 4);
      }
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebView.loadUrl(paramIntent);
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      paramString1 = paramIntent;
      if ("miniqb://home".equals(paramIntent)) {
        paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";
      }
      if (MttLoader.loadUrl(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl") != 0)
      {
        paramString1 = SDKEngine.getInstance(false);
        if ((paramString1 != null) && (paramString1.isX5Core()) && (paramString1.wizard().startMiniQB(localContext, paramIntent, null, paramString2) == 0)) {
          return true;
        }
      }
    }
    for (;;)
    {
      return false;
      paramWebView.loadUrl(paramString1);
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return false;
        paramString2 = SDKEngine.getInstance(false);
      } while ((paramString2 == null) || (!paramString2.isX5Core()));
      paramString1 = paramString2.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
    } while (paramString1 == null);
    paramContext = Boolean.valueOf(false);
    if ((paramString1 instanceof Boolean)) {
      paramContext = (Boolean)paramString1;
    }
    return paramContext.booleanValue();
  }
  
  public static boolean isSdkVideoServiceFg(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        if (paramContext.size() == 0) {
          return false;
        }
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null))
          {
            boolean bool = localRunningAppProcessInfo.processName.contains("com.tencent.mtt:VideoService");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "isSdkVideoServiceFg Exception: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    boolean bool1 = bool2;
    if (localSDKEngine != null)
    {
      bool1 = bool2;
      if (localSDKEngine.isInited()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt)
  {
    return isX5Disabled(paramContext, paramInt, 20000);
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!initForX5DisableConfig(paramContext)) {}
    do
    {
      return true;
      paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(36001), Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        return ((Boolean)paramContext).booleanValue();
      }
      paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(36001) });
    } while (paramContext == null);
    return ((Boolean)paramContext).booleanValue();
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus() == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    if (!initForX5DisableConfig(paramContext)) {
      return true;
    }
    i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i), Integer.valueOf(36001) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    try
    {
      mTmpIsSysWebViewForced = mIsSysWebViewForced;
      if (!mIsPreInitialized)
      {
        new Thread()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            }
            do
            {
              do
              {
                do
                {
                  return;
                  new android.webkit.WebView(paramContext);
                } while (paramPreInitCallback == null);
                paramPreInitCallback.onViewInitFinished();
                return;
                paramAnonymousMessage = SDKEngine.getInstance(true).wizard();
                if (paramAnonymousMessage != null) {
                  paramAnonymousMessage.createSDKWebview(paramContext);
                }
              } while (paramPreInitCallback == null);
              paramPreInitCallback.onViewInitFinished();
              return;
            } while (paramPreInitCallback == null);
            paramPreInitCallback.onCoreInitFinished();
          }
        }
        {
          public void run()
          {
            if (TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(this.val$context) == 0) {
              TbsInstaller.getInstance().installTbsCoreIfNeeded(this.val$context, true);
            }
            SDKEngine localSDKEngine = SDKEngine.getInstance(true);
            localSDKEngine.init(this.val$context, false, true);
            if (TbsShareManager.isThirdPartyApp(this.val$context))
            {
              if (!TbsShareManager.forceLoadX5FromTBSDemo(this.val$context.getApplicationContext())) {
                TbsDownloader.needDownload(this.val$context);
              }
              if ((!WebView.mSysWebviewCreated) && (!QbSdk.mTmpIsSysWebViewForced)) {
                QbSdk.mIsSysWebViewForced = false;
              }
            }
            boolean bool = localSDKEngine.isX5Core();
            this.val$handler.sendEmptyMessage(3);
            if (!bool)
            {
              this.val$handler.sendEmptyMessage(2);
              return;
            }
            this.val$handler.sendEmptyMessage(1);
          }
        }.start();
        mIsPreInitialized = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void preloadX5Check(Context paramContext)
  {
    isPreloadX5Checking = true;
    int i1 = -1;
    int m = -1;
    Object localObject1 = null;
    int i = -1;
    int i2 = -1;
    Object localObject2 = localObject1;
    int k = i;
    int j = m;
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject2 = localObject1;
        k = i;
        j = m;
      }
      for (localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
      {
        localObject2 = localObject1;
        k = i;
        j = m;
        i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
        n = i3;
        if (i3 < 0) {
          break;
        }
        n = i3 + 1;
        j = n;
        i = j;
        if (j <= 4) {
          break;
        }
        return;
        localObject2 = localObject1;
        k = i;
        j = m;
      }
      localObject2 = localObject1;
      k = i;
      j = m;
      m = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
      if (m <= 0) {
        return;
      }
      if (n <= 4)
      {
        localObject2 = localObject1;
        k = i;
        j = m;
        ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", n).commit();
      }
      localObject2 = localObject1;
      k = i;
      j = m;
      int i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
      localObject2 = localObject1;
      n = i2;
      k = i;
      j = m;
      if (i3 >= 0)
      {
        localObject2 = localObject1;
        k = i;
        j = m;
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        n = i3 + 1;
        localObject2 = localObject1;
        k = i;
        j = m;
        localEditor.putInt("tbs_preload_x5_counter", n).commit();
        j = m;
        k = i;
        localObject2 = localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable));
        int n = i2;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + j + "; value:" + i);
      }
      i = i1;
      if (k <= 0) {
        break label540;
      }
      i = i1;
      if (k > 3) {
        break label540;
      }
      TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
      SDKEngine.getInstance(true).init(paramContext);
      TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
      i = 0;
    }
    if (n > 3) {
      try
      {
        i = localObject2.getInt("tbs_preload_x5_version", -1);
        localObject1 = localObject2.edit();
        if (i == j)
        {
          FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), false);
          paramContext = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallFile();
          if (paramContext != null) {
            FileUtil.delete(paramContext, false);
          }
          TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + j + " is deleted!");
          ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i);
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
        return;
      }
    }
    try
    {
      label540:
      j = localObject2.getInt("tbs_preload_x5_counter", -1);
      if (j > 0) {
        localObject2.edit().putInt("tbs_preload_x5_counter", j - 1).commit();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
      }
    }
    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
  }
  
  public static void reset(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    try
    {
      TbsDownloader.stopDownload();
      TbsDownloader.clearAllCache(paramContext);
      FileUtil.delete(paramContext.getDir("tbs", 0));
      TbsLog.i("QbSdk", "delete downloaded apk success", true);
      TbsInstaller.getInstance().mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    mTID = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    mDownloadWithoutWifi = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    mQQBuildNumber = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    mTBSInstalling = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    mTbsListener = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static boolean startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {}
    SDKEngine localSDKEngine;
    do
    {
      return false;
      localSDKEngine = SDKEngine.getInstance(false);
    } while ((localSDKEngine == null) || (!localSDKEngine.isX5Core()) || ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) || (localSDKEngine.wizard().startMiniQB(paramContext, paramString, paramHashMap, null) != 0));
    return true;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return startQBForDoc(paramContext, paramString1, paramInt1, paramInt2, paramString2, null);
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl") == 0;
  }
  
  public static int startQBWeb(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    SDKEngine localSDKEngine;
    do
    {
      return -1;
      localSDKEngine = SDKEngine.getInstance(false);
    } while ((localSDKEngine == null) || (!localSDKEngine.isX5Core()));
    paramContext = localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startQBWeb", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString, null });
    if (paramContext == null) {
      return -3;
    }
    return ((Integer)paramContext).intValue();
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      return false;
    }
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    Object localObject1 = paramString;
    Object localObject3 = paramString;
    Object localObject2 = localObject3;
    String str;
    if ("miniqb://home".equals(paramString))
    {
      str = "qb://navicard/addCard?cardId=168&cardName=168";
      localObject2 = localObject3;
      localObject1 = str;
      if (localSDKEngine != null)
      {
        localObject2 = localObject3;
        localObject1 = str;
        if (localSDKEngine.isX5Core())
        {
          Object localObject4 = (Bundle)localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
          localObject2 = localObject3;
          localObject1 = str;
          if (localObject4 != null)
          {
            paramString = ((Bundle)localObject4).getString("ad_webview_detail_url");
            localObject4 = ((Bundle)localObject4).getString("ad_webview_click_stat_posid_for_qb");
            localObject2 = localObject3;
            localObject1 = str;
            if (!TextUtils.isEmpty(paramString))
            {
              localObject3 = paramString;
              localObject2 = paramString;
              localObject1 = localObject3;
              if (paramHashMap != null)
              {
                paramHashMap.put("PosID", localObject4);
                localObject1 = localObject3;
                localObject2 = paramString;
              }
            }
          }
        }
      }
    }
    localObject3 = localObject2;
    paramString = (String)localObject1;
    if ("miniqb://home".equals(localObject2))
    {
      localObject3 = localObject2;
      paramString = (String)localObject1;
      if (paramHashMap != null)
      {
        str = (String)paramHashMap.get("curUrlQQ");
        localObject3 = localObject2;
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty(str))
        {
          paramString = Post3DESEncryption.bytesToHex(str.getBytes());
          paramString = "http://adsolution.imtt.qq.com/index?p=tad&u=" + paramString;
          localObject3 = paramString;
        }
      }
    }
    if (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl") != 0)
    {
      if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
        if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
        {
          if (localSDKEngine.wizard().startMiniQB(paramContext, (String)localObject3, paramHashMap, null) == 0) {
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    mIsSysWebViewForcedByOuter = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean useSoftWare()
  {
    if (sExtensionObj == null) {}
    Object localObject1;
    do
    {
      return false;
      Object localObject2 = ReflectionUtils.invokeInstance(sExtensionObj, "useSoftWare", new Class[0], new Object[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = sExtensionObj;
        localObject2 = Integer.TYPE;
        int i = DeviceInfo.getTotalRAM();
        localObject1 = ReflectionUtils.invokeInstance(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i) });
      }
    } while (localObject1 == null);
    return ((Boolean)localObject1).booleanValue();
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */