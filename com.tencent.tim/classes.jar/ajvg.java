import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class ajvg
  implements ServiceConnection
{
  ajvg(ajvf paramajvf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceConnected");
    }
    this.b.b = ajvc.a.a(paramIBinder);
    try
    {
      this.b.b.a(this.b.a);
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceConnected.");
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramComponentName.printStackTrace();
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceDisconnected");
    }
    synchronized (ajvf.a(this.b))
    {
      this.b.b = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvg
 * JD-Core Version:    0.7.0.1
 */