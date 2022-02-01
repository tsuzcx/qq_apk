package tmsdk.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dualsim.common.IKingCardInterface;
import dualsim.common.ILogPrint;
import dualsim.common.IPhoneInfoBridge;
import dualsim.common.ISimInterface;
import dualsim.common.KcConfig;
import java.io.File;
import java.lang.reflect.Method;
import kcsdkext.c;

public class KcSdkShellManager
  implements ITmsContextInterface
{
  public static final String TAG = "KcSdkShellManager";
  public static boolean mHasManagerInit = false;
  private static KcSdkShellManager mInstance;
  private boolean isLogEnabled = false;
  private KcConfig kcConfig;
  private ILogPrint logPrint;
  private IKingCardExceptionCallback mIKingCardExceptionCallback;
  private IKingCardInterface mIKingCardInterface;
  private ISimInterface mISimInterface;
  private ITmsContextInterface mITmsContextInterface;
  private IPhoneInfoBridge phoneInfoBridge;
  
  public static KcSdkShellManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new KcSdkShellManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private boolean initImpl(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, IKingCardExceptionCallback paramIKingCardExceptionCallback)
  {
    try
    {
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        throw new IllegalThreadStateException("Must init king card sdk in work thread");
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    Log.e("KcSdkShellManager", "init");
    c.a(paramContext);
    this.mIKingCardExceptionCallback = paramIKingCardExceptionCallback;
    Thread localThread = Thread.currentThread();
    if (localThread.getId() != Looper.getMainLooper().getThread().getId())
    {
      String str = localThread.getName();
      localThread.setName("kingcardsdk_" + str);
    }
    Thread.setDefaultUncaughtExceptionHandler(new KingCardUncaughtExceptionHandler(paramContext, paramIKingCardExceptionCallback));
    paramBoolean = loadJPatch(paramContext, paramString1, paramString2, paramString3, paramBoolean);
    return paramBoolean;
  }
  
  private boolean loadJPatch(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str = c.a();
    Log.e("KcSdkShellManager", "sdkPatch: " + str);
    if (!TextUtils.isEmpty(str))
    {
      Log.e("KcSdkShellManager", "?????");
      if (loadSdk(paramContext, paramString2, paramString3, paramBoolean, str)) {
        return true;
      }
      Log.e("KcSdkShellManager", "load sdk patch error ");
    }
    Log.e("KcSdkShellManager", "sdkPath:" + paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return false;
    }
    return loadSdk(paramContext, paramString2, paramString3, paramBoolean, paramString1);
  }
  
  private boolean loadSdk(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    try
    {
      paramBoolean = loadSdkImpl(paramContext, paramString1, paramString2, paramBoolean, paramString3);
      return paramBoolean;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramBoolean = false;
      }
    }
    finally {}
  }
  
  private boolean loadSdkImpl(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    try
    {
      this.mITmsContextInterface = ((ITmsContextInterface)new DexClassLoader(paramString3, paramContext.getApplicationInfo().dataDir, paramContext.getApplicationInfo().nativeLibraryDir, KcSdkShellManager.class.getClassLoader()).loadClass("tmsdk.common.KcSdkManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
      this.mITmsContextInterface.setLogPrint(this.logPrint);
      this.mITmsContextInterface.setTMSDKLogEnable(this.isLogEnabled);
      this.mITmsContextInterface.setPhoneInfoBridge(this.phoneInfoBridge);
      this.mITmsContextInterface.setKcConfig(this.kcConfig);
      if (paramBoolean) {}
      for (paramBoolean = this.mITmsContextInterface.initInBaseProcess(paramContext, paramString1, paramString2);; paramBoolean = this.mITmsContextInterface.initInOtherProcess(paramContext, paramString1, paramString2))
      {
        paramContext = this.mITmsContextInterface.getClass();
        this.mIKingCardInterface = ((IKingCardInterface)paramContext.getDeclaredMethod("getKingCardManager", new Class[0]).invoke(this.mITmsContextInterface, new Object[0]));
        this.mISimInterface = ((ISimInterface)paramContext.getDeclaredMethod("getDualSimManager", new Class[0]).invoke(this.mITmsContextInterface, new Object[0]));
        Log.e("KcSdkShellManager", "mIKingCardInterface:" + this.mIKingCardInterface);
        Log.e("KcSdkShellManager", "mISimInterface:" + this.mISimInterface);
        return paramBoolean;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public IKingCardExceptionCallback getKingCardExceptionCallback()
  {
    return this.mIKingCardExceptionCallback;
  }
  
  public IKingCardInterface getKingCardInterface()
  {
    return this.mIKingCardInterface;
  }
  
  public ISimInterface getSimInterface()
  {
    return this.mISimInterface;
  }
  
  public boolean init(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, IKingCardExceptionCallback paramIKingCardExceptionCallback)
  {
    if (mHasManagerInit) {
      return true;
    }
    paramBoolean = initImpl(paramContext, paramString1, paramString2, paramString3, paramBoolean, paramIKingCardExceptionCallback);
    mHasManagerInit = paramBoolean;
    return paramBoolean;
  }
  
  public boolean initInBaseProcess(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean initInBaseProcess(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return init(paramContext, paramString1, paramString2, paramString3, true, null);
  }
  
  public boolean initInOtherProcess(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean initInOtherProcess(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return init(paramContext, paramString1, paramString2, paramString3, false, null);
  }
  
  public void setKcConfig(KcConfig paramKcConfig)
  {
    this.kcConfig = paramKcConfig;
    try
    {
      if (this.mITmsContextInterface != null) {
        this.mITmsContextInterface.setKcConfig(paramKcConfig);
      }
      return;
    }
    catch (Throwable paramKcConfig) {}
  }
  
  public void setLogPrint(ILogPrint paramILogPrint)
  {
    this.logPrint = paramILogPrint;
    try
    {
      if (this.mITmsContextInterface != null) {
        this.mITmsContextInterface.setLogPrint(paramILogPrint);
      }
      return;
    }
    catch (Throwable paramILogPrint) {}
  }
  
  public void setPhoneInfoBridge(IPhoneInfoBridge paramIPhoneInfoBridge)
  {
    this.phoneInfoBridge = paramIPhoneInfoBridge;
    if (this.mITmsContextInterface != null) {
      this.mITmsContextInterface.setPhoneInfoBridge(paramIPhoneInfoBridge);
    }
  }
  
  public void setTMSDKLogEnable(boolean paramBoolean)
  {
    this.isLogEnabled = paramBoolean;
    if (this.mITmsContextInterface != null) {
      this.mITmsContextInterface.setTMSDKLogEnable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmsdk.common.KcSdkShellManager
 * JD-Core Version:    0.7.0.1
 */