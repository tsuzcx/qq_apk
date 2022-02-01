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
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new KcSdkShellManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private boolean initImpl(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, IKingCardExceptionCallback paramIKingCardExceptionCallback)
  {
    try
    {
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
      {
        Log.e("KcSdkShellManager", "init");
        c.a(paramContext);
        this.mIKingCardExceptionCallback = paramIKingCardExceptionCallback;
        Thread localThread = Thread.currentThread();
        if (localThread.getId() != Looper.getMainLooper().getThread().getId())
        {
          String str = localThread.getName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("kingcardsdk_");
          localStringBuilder.append(str);
          localThread.setName(localStringBuilder.toString());
        }
        Thread.setDefaultUncaughtExceptionHandler(new KingCardUncaughtExceptionHandler(paramContext, paramIKingCardExceptionCallback));
        return loadJPatch(paramContext, paramString1, paramString2, paramString3, paramBoolean);
      }
      throw new IllegalThreadStateException("Must init king card sdk in work thread");
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private boolean loadJPatch(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject = c.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdkPatch: ");
    localStringBuilder.append((String)localObject);
    Log.e("KcSdkShellManager", localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("KcSdkShellManager", "?????");
      if (loadSdk(paramContext, paramString2, paramString3, paramBoolean, (String)localObject)) {
        return true;
      }
      Log.e("KcSdkShellManager", "load sdk patch error ");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sdkPath:");
    ((StringBuilder)localObject).append(paramString1);
    Log.e("KcSdkShellManager", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists())) {
      return loadSdk(paramContext, paramString2, paramString3, paramBoolean, paramString1);
    }
    return false;
  }
  
  /* Error */
  private boolean loadSdk(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: aload_3
    //   6: iload 4
    //   8: aload 5
    //   10: invokespecial 154	tmsdk/common/KcSdkShellManager:loadSdkImpl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Z
    //   13: istore 4
    //   15: aload_0
    //   16: monitorexit
    //   17: iload 4
    //   19: ireturn
    //   20: astore_1
    //   21: goto +12 -> 33
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	KcSdkShellManager
    //   0	37	1	paramContext	Context
    //   0	37	2	paramString1	String
    //   0	37	3	paramString2	String
    //   0	37	4	paramBoolean	boolean
    //   0	37	5	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	15	20	finally
    //   25	29	20	finally
    //   2	15	24	java/lang/Throwable
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
      if (paramBoolean) {
        paramBoolean = this.mITmsContextInterface.initInBaseProcess(paramContext, paramString1, paramString2);
      } else {
        paramBoolean = this.mITmsContextInterface.initInOtherProcess(paramContext, paramString1, paramString2);
      }
      paramContext = this.mITmsContextInterface.getClass();
      this.mIKingCardInterface = ((IKingCardInterface)paramContext.getDeclaredMethod("getKingCardManager", new Class[0]).invoke(this.mITmsContextInterface, new Object[0]));
      this.mISimInterface = ((ISimInterface)paramContext.getDeclaredMethod("getDualSimManager", new Class[0]).invoke(this.mITmsContextInterface, new Object[0]));
      paramContext = new StringBuilder();
      paramContext.append("mIKingCardInterface:");
      paramContext.append(this.mIKingCardInterface);
      Log.e("KcSdkShellManager", paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append("mISimInterface:");
      paramContext.append(this.mISimInterface);
      Log.e("KcSdkShellManager", paramContext.toString());
      return paramBoolean;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
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
    ITmsContextInterface localITmsContextInterface = this.mITmsContextInterface;
    if (localITmsContextInterface != null) {
      localITmsContextInterface.setPhoneInfoBridge(paramIPhoneInfoBridge);
    }
  }
  
  public void setTMSDKLogEnable(boolean paramBoolean)
  {
    this.isLogEnabled = paramBoolean;
    ITmsContextInterface localITmsContextInterface = this.mITmsContextInterface;
    if (localITmsContextInterface != null) {
      localITmsContextInterface.setTMSDKLogEnable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmsdk.common.KcSdkShellManager
 * JD-Core Version:    0.7.0.1
 */