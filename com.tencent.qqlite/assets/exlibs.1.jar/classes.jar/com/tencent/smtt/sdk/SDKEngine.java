package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class SDKEngine
{
  public static final String COUNT_PROPERTIES = "count.prop";
  private static int REBOOT_CALLED_TIMES_MAX = 3;
  private static final String TAG = "SDKEngine";
  private static String mCalledCountKey = null;
  private static boolean mCompatibleChecked = false;
  private static int mInitCount = 0;
  private static SDKEngine mInstance = null;
  private static int mTbsCoreVersion = 0;
  static boolean mTbsNeedReboot = false;
  private static final int sMinSupportCoreVersion = 25102;
  private boolean mIsInited = false;
  private TbsWizard mTbsWizard = null;
  private boolean mUsedTbs = false;
  private File mX5CorePath = null;
  
  static
  {
    mCompatibleChecked = false;
    mTbsCoreVersion = 0;
    mInitCount = 0;
    mTbsNeedReboot = false;
  }
  
  private int getCountProp()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(this.mX5CorePath, "count.prop"));
      Properties localProperties;
      int i;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localProperties = new Properties();
        localProperties.load(localFileInputStream);
        i = Integer.valueOf(localProperties.getProperty(mCalledCountKey, "1")).intValue();
        return i;
      }
      catch (Exception localException2)
      {
        break label53;
      }
      localException1 = localException1;
    }
    label53:
    return 0;
  }
  
  public static SDKEngine getInstance(boolean paramBoolean)
  {
    if ((mInstance == null) && (paramBoolean)) {
      mInstance = new SDKEngine();
    }
    return mInstance;
  }
  
  public static int getTbsCoreVersion()
  {
    return mTbsCoreVersion;
  }
  
  private static boolean isCompatible()
  {
    return Build.VERSION.SDK_INT >= 7;
  }
  
  static boolean isSupportable(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {}
    for (mTbsCoreVersion = TbsShareManager.getAvailableTbsCoreVersion(paramContext); (mTbsCoreVersion != 0) && (mTbsCoreVersion < 25102); mTbsCoreVersion = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext))
    {
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 309);
      return false;
    }
    return true;
  }
  
  private void setCountProp(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(mCalledCountKey, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.mX5CorePath, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  static void setTbsCoreVersion(int paramInt)
  {
    mTbsCoreVersion = paramInt;
  }
  
  private void useSystemWebView(Context paramContext, boolean paramBoolean)
  {
    if ((QbSdk.mIsSysWebViewForced) && (!paramBoolean) && (this.mUsedTbs)) {}
    do
    {
      return;
      this.mUsedTbs = false;
      if (paramBoolean)
      {
        TbsLog.w("SDKEngine", "useSystemWebView -> QbSdk.forceSysWebViewInner");
        QbSdk.forceSysWebViewInner();
      }
    } while ((mTbsCoreVersion == 0) || (this.mUsedTbs));
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 405);
  }
  
  public String getCrashExtraMessage()
  {
    if ((this.mTbsWizard == null) || (QbSdk.mIsSysWebViewForced)) {
      return "system webview get nothing...";
    }
    return this.mTbsWizard.getCrashExtraMessage();
  }
  
  boolean getTbsNeedReboot()
  {
    int i;
    if (mTbsNeedReboot)
    {
      if (mCalledCountKey == null) {
        return false;
      }
      i = getCountProp();
      if (i != 0) {
        break label32;
      }
      setCountProp(1);
    }
    for (;;)
    {
      return mTbsNeedReboot;
      label32:
      if (i + 1 > REBOOT_CALLED_TIMES_MAX) {
        break;
      }
      setCountProp(i + 1);
    }
  }
  
  public void init(Context paramContext)
  {
    try
    {
      init(paramContext, false, false);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      init(paramContext, paramBoolean, false);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject1;
      boolean bool;
      try
      {
        mInitCount += 1;
        TbsCoreLoadStat.getInstance().clearErrorCodeQueue();
        localObject1 = TbsInstaller.getInstance();
        if (mInitCount == 1)
        {
          bool = true;
          ((TbsInstaller)localObject1).installTbsCoreIfNeeded(paramContext, bool);
          paramBoolean2 = QbSdk.canLoadX5(paramContext, paramBoolean1, paramBoolean2);
          bool = isCompatible();
          if (bool) {
            break label539;
          }
          TbsLog.e("loaderror", "320");
          break label539;
          TbsLog.e("SDKEngine", "SDKEngine--init canLoadTbs=" + paramBoolean1);
          if (!paramBoolean1)
          {
            TbsLog.e("SDKEngine", "SDKEngine--init can_load_x5=" + paramBoolean2);
            TbsLog.e("SDKEngine", "SDKEngine--init is_compatible=" + bool);
            TbsLog.e("SDKEngine", "SDKEngine--init isTbsCoreLegaL=" + true);
          }
          if (!paramBoolean1) {
            break label514;
          }
          paramBoolean1 = this.mUsedTbs;
          if (!paramBoolean1) {}
        }
        else
        {
          bool = false;
          continue;
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label366;
        }
        if (!TbsShareManager.isShareTbsCoreAvailable(paramContext)) {
          break label339;
        }
        localObject4 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
        try
        {
          localObject3 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
          localObject1 = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
          if (localObject3 != null) {
            break label580;
          }
          TbsLog.e("SDKEngine", "useSystemWebView by ERROR_TBSCORE_DEXOPT_DIR");
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 311);
          useSystemWebView(paramContext, true);
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          Context localContext1;
          break;
          int i = 1;
          continue;
          i = 0;
          continue;
          Context localContext2 = paramContext;
        }
      }
      TbsLog.e("SDKEngine", "useSystemWebView by exception: " + localThrowable1);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 310, localThrowable1);
      useSystemWebView(paramContext, true);
      TbsInstaller.getInstance();
      this.mX5CorePath = TbsInstaller.getTbsCorePrivateDir(paramContext);
      this.mIsInited = true;
      continue;
      label339:
      TbsLog.e("SDKEngine", "useSystemWebView by ERROR_HOST_UNAVAILABLE");
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304);
      useSystemWebView(paramContext, true);
      continue;
      label366:
      localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      Object localObject3 = localObject2;
      if (mTbsCoreVersion == 25436) {
        break;
      }
      if (mTbsCoreVersion != 25437) {
        break label568;
      }
      break;
      if (i == 0) {
        break label574;
      }
      localContext1 = paramContext.getApplicationContext();
      Object localObject4 = localObject2;
      if (localObject2 == null)
      {
        TbsLog.e("SDKEngine", "useSystemWebView by ERROR_TBSCORE_SHARE_DIR");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 312);
        useSystemWebView(paramContext, true);
      }
      else
      {
        localObject2 = QbSdk.getDexLoaderFileList(paramContext, localContext1, ((File)localObject4).getAbsolutePath());
        i = 0;
        while (i < localObject2.length) {
          i += 1;
        }
        this.mTbsWizard = new TbsWizard(paramContext, localContext1, ((File)localObject4).getAbsolutePath(), ((File)localObject3).getAbsolutePath(), (String[])localObject2);
        this.mUsedTbs = true;
        continue;
        label514:
        TbsLog.e("SDKEngine", "useSystemWebView by !canLoadTbs");
        TbsLog.e("loaderror", "324");
        useSystemWebView(paramContext, false);
        continue;
        label539:
        if ((paramBoolean2) && (bool) && (1 != 0)) {
          paramBoolean1 = true;
        }
      }
    }
  }
  
  boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean isX5Core()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return false;
    }
    return this.mUsedTbs;
  }
  
  void setCalledCountKey(String paramString)
  {
    mCalledCountKey = paramString;
  }
  
  boolean setTbsNeedReboot(boolean paramBoolean)
  {
    mTbsNeedReboot = paramBoolean;
    return paramBoolean;
  }
  
  public boolean useSoftWare()
  {
    return QbSdk.useSoftWare();
  }
  
  public TbsWizard wizard()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return null;
    }
    return this.mTbsWizard;
  }
  
  TbsWizard wizardForReaderView()
  {
    return this.mTbsWizard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SDKEngine
 * JD-Core Version:    0.7.0.1
 */