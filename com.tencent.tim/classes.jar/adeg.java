import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.QLog;

public class adeg
  implements adfa.a
{
  public adeg(ArConfigService paramArConfigService) {}
  
  public void bq(int paramInt, boolean paramBoolean)
  {
    if (ArConfigService.b(this.this$0) != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = ArConfigService.b(this.this$0).beginBroadcast();
        i = 0;
        if (i >= j) {
          break label129;
        }
        if (paramBoolean) {}
        try
        {
          ((adgk)ArConfigService.b(this.this$0).getBroadcastItem(i)).KT(paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        ((adgk)ArConfigService.b(this.this$0).getBroadcastItem(i)).hn(paramInt, 0);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onFinish error:" + localException.getMessage());
        }
      }
      return;
      label129:
      ArConfigService.b(this.this$0).finishBroadcast();
      return;
      i += 1;
    }
  }
  
  public void onProgress(int paramInt1, int paramInt2)
  {
    if (ArConfigService.b(this.this$0) != null) {
      try
      {
        int j = ArConfigService.b(this.this$0).beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label106;
          }
          try
          {
            ((adgk)ArConfigService.b(this.this$0).getBroadcastItem(i)).hm(paramInt1, paramInt2);
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
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onProgress error:" + localException.getMessage());
        }
      }
    }
    label106:
    ArConfigService.b(this.this$0).finishBroadcast();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adeg
 * JD-Core Version:    0.7.0.1
 */