package dualsim.common;

import android.content.Context;
import android.os.Looper;
import java.util.ArrayList;
import tmsdk.common.KcSdkShellManager;

public class DualSimSDKManagerExt
  implements ISimInterface
{
  private static DualSimSDKManagerExt sInstance;
  
  private void checkNeedWait()
  {
    if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) || (KcSdkShellManager.mHasManagerInit)) {
      return;
    }
    int i = 20;
    for (;;)
    {
      int j = i - 1;
      if ((i <= 0) || (KcSdkShellManager.mHasManagerInit)) {
        break;
      }
      try
      {
        Thread.sleep(200L);
        i = j;
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
  }
  
  public static ISimInterface getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new DualSimSDKManagerExt();
      }
      return sInstance;
    }
    finally {}
  }
  
  public int checkSpecialPermission(Context paramContext, int paramInt)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        paramInt = localISimInterface.checkSpecialPermission(paramContext, paramInt);
        return paramInt;
      }
    }
    catch (Throwable paramContext) {}
    return 2;
  }
  
  public boolean fetchSoluAndSave()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.fetchSoluAndSave();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean fetchSoluAndSaveSafely()
  {
    return false;
  }
  
  public int getActiveDataTrafficSimSlot(Context paramContext)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        int i = localISimInterface.getActiveDataTrafficSimSlot(paramContext);
        return i;
      }
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public ArrayList<Integer> getAvailableSimSlotsList(Context paramContext)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        paramContext = localISimInterface.getAvailableSimSlotsList(paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public String getSlotIMSI(int paramInt, Context paramContext)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        paramContext = localISimInterface.getSlotIMSI(paramInt, paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public boolean isAdapterFetchSuccessAfterStartup()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isAdapterFetchSuccessAfterStartup();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isDualSimAdapter()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isDualSimAdapter();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isDualSimCards()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isDualSimCards();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isInitFinished()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isInitFinished();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isPermInstalledPackagesWarning()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isPermInstalledPackagesWarning();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public boolean isPermLocationWarning()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isPermLocationWarning();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public boolean isSingleSimCard()
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null)
      {
        boolean bool = localISimInterface.isSingleSimCard();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean reFetchAdapterIfNeed(boolean paramBoolean)
  {
    return false;
  }
  
  public void registerInitCallback(ISimInterface.IDualSimInitCallback paramIDualSimInitCallback)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null) {
        localISimInterface.registerInitCallback(paramIDualSimInitCallback);
      }
      return;
    }
    catch (Throwable paramIDualSimInitCallback) {}
  }
  
  public void unRegisterInitCallback(ISimInterface.IDualSimInitCallback paramIDualSimInitCallback)
  {
    try
    {
      checkNeedWait();
      ISimInterface localISimInterface = KcSdkShellManager.getInstance().getSimInterface();
      if (localISimInterface != null) {
        localISimInterface.unRegisterInitCallback(paramIDualSimInitCallback);
      }
      return;
    }
    catch (Throwable paramIDualSimInitCallback) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dualsim.common.DualSimSDKManagerExt
 * JD-Core Version:    0.7.0.1
 */