import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class zjg
  implements ServiceConnection
{
  private zje a;
  
  public zjg(zje paramzje)
  {
    this.a = paramzje;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zje localzje = this.a;
    if (localzje != null) {
      localzje.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zje localzje = this.a;
    if (localzje != null) {
      localzje.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjg
 * JD-Core Version:    0.7.0.1
 */