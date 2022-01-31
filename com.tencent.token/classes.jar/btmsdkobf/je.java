package btmsdkobf;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class je
  implements ServiceConnection
{
  je(m paramm) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      m.a(this.a, l.a.b(paramIBinder));
      if (m.a(this.a) != null) {
        m.a(this.a).a("Deviceid Service Connected", this.a);
      }
      m.a(this.a, "Service onServiceConnected");
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    m.a(this.a, null);
    m.a(this.a, "Service onServiceDisconnected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.je
 * JD-Core Version:    0.7.0.1
 */