import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class adef
  implements adfh
{
  public adef(ArConfigService paramArConfigService) {}
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (ArConfigService.a(this.this$0) != null) {}
    try
    {
      int j = ArConfigService.a(this.this$0).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).a(null, null, paramARCommonConfigInfo);
        i += 1;
      }
      ArConfigService.a(this.this$0).finishBroadcast();
      return;
    }
    catch (RemoteException paramARCommonConfigInfo)
    {
      paramARCommonConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (ArConfigService.a(this.this$0) != null) {}
    try
    {
      int j = ArConfigService.a(this.this$0).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).a(paramArConfigInfo, null, null);
        i += 1;
      }
      ArConfigService.a(this.this$0).finishBroadcast();
      return;
    }
    catch (RemoteException paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (ArConfigService.a(this.this$0) != null) {}
    try
    {
      int j = ArConfigService.a(this.this$0).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).a(null, paramArEffectConfig, null);
        i += 1;
      }
      ArConfigService.a(this.this$0).finishBroadcast();
      return;
    }
    catch (RemoteException paramArEffectConfig)
    {
      paramArEffectConfig.printStackTrace();
    }
  }
  
  public void ez(int paramInt)
  {
    if (ArConfigService.a(this.this$0) != null) {}
    try
    {
      int j = ArConfigService.a(this.this$0).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).ez(paramInt);
        i += 1;
      }
      ArConfigService.a(this.this$0).finishBroadcast();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        localRemoteException.printStackTrace();
      }
      aden.i(localRemoteException.getCurrentAccountUin(), false, paramInt);
    }
    localQQAppInterface = (QQAppInterface)this.this$0.weakApp.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "onDownloadError,mApp is null! ");
      return;
    }
  }
  
  public void m(long paramLong1, long paramLong2)
  {
    if (ArConfigService.a(this.this$0) != null) {}
    try
    {
      int j = ArConfigService.a(this.this$0).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).m(paramLong1, paramLong2);
        i += 1;
      }
      ArConfigService.a(this.this$0).finishBroadcast();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void onDownloadSuccess()
  {
    if (ArConfigService.a(this.this$0) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess before sync");
      }
    }
    synchronized (this.this$0.cQ)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync start");
      }
      try
      {
        int j = ArConfigService.a(this.this$0).beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              ((adgn)ArConfigService.a(this.this$0).getBroadcastItem(i)).onDownloadSuccess();
              i += 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                localRemoteException.printStackTrace();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess  sync fail end,error reason:binder server muti-thread");
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess after sync");
        }
        ??? = (QQAppInterface)this.this$0.weakApp.get();
        if (??? != null) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess,mApp is null! ");
        return;
        ArConfigService.a(this.this$0).finishBroadcast();
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync end");
    }
    aden.i(((QQAppInterface)???).getCurrentAccountUin(), true, 0);
  }
  
  public void zE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adef
 * JD-Core Version:    0.7.0.1
 */