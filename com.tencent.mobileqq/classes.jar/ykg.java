import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class ykg
  implements ServiceConnection
{
  private yke a;
  
  public ykg(yke paramyke)
  {
    this.a = paramyke;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    yke localyke = this.a;
    if (localyke != null) {
      localyke.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    yke localyke = this.a;
    if (localyke != null) {
      localyke.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykg
 * JD-Core Version:    0.7.0.1
 */