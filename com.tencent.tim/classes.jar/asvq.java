import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class asvq
  implements ServiceConnection
{
  asvq(asvp paramasvp) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    asvp.a(this.a, ajmj.a.a(paramIBinder));
    try
    {
      if (asvp.a(this.a) != null) {
        asvp.a(this.a).a(asvp.a(this.a));
      }
      if (paramIBinder != null) {
        paramIBinder.linkToDeath(new asvr(this, paramIBinder), 0);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceConnected " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    try
    {
      if (asvp.a(this.a) != null)
      {
        asvp.a(this.a).b(asvp.a(this.a));
        asvp.a(this.a, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvq
 * JD-Core Version:    0.7.0.1
 */