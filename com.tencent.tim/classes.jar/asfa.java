import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class asfa
  implements ServiceConnection
{
  asfa(asey paramasey) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    asev.d("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    asey.a(this.b, iua.a.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    asev.d("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    asey.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asfa
 * JD-Core Version:    0.7.0.1
 */