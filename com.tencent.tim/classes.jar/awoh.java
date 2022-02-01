import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class awoh
  implements ServiceConnection
{
  awoh(awof paramawof) {}
  
  public void eEE()
  {
    if ((awof.a(this.this$0) != null) && (!awof.a(this.this$0).aNk())) {
      awof.a(this.this$0).eEz();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    asbt.i("WadlProxyServiceManager", "onServiceConnected success");
    this.this$0.dnf = false;
    awof.a(this.this$0, awob.a.a(paramIBinder));
    if ((awof.a(this.this$0)) || (awof.a(this.this$0) == null))
    {
      asbt.i("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + awof.a(this.this$0) + ",mWadlService=" + awof.a(this.this$0));
      return;
    }
    try
    {
      awof.a(this.this$0).a(awof.a(this.this$0));
      awof.a(this.this$0);
      eEE();
      try
      {
        awof.a(this.this$0).asBinder().linkToDeath(awof.a(this.this$0), 0);
        return;
      }
      catch (RemoteException paramComponentName)
      {
        paramComponentName.printStackTrace();
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    asbt.i("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(awof.a(this.this$0));
      if (awof.a(this.this$0) != null) {
        awof.a(this.this$0).eEy();
      }
      if (awof.a(this.this$0) != null) {
        awof.a(this.this$0).b(awof.a(this.this$0));
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    finally
    {
      awof.a(this.this$0, null);
      this.this$0.dnf = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awoh
 * JD-Core Version:    0.7.0.1
 */