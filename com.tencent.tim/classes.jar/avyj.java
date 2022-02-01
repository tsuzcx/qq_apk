import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class avyj
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceConnected");
    }
    if (avyi.access$000() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      avyi.access$100();
      return;
    }
    paramComponentName = (avyi.a)avyi.access$000().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return OnPluginManagerLoadedListener is null");
      }
      avyi.access$100();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder alive");
      }
      avyi.b = new avxv(avyr.a.a(paramIBinder));
      paramComponentName.a(avyi.b);
    }
    for (;;)
    {
      avyi.access$100();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder not alive");
      }
      paramComponentName.a(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    if (avyi.b != null)
    {
      avyi.b.destroy();
      avyi.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyj
 * JD-Core Version:    0.7.0.1
 */