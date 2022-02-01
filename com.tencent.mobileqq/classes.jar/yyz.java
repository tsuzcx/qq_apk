import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class yyz
  implements ServiceConnection
{
  private yyx a;
  
  public yyz(yyx paramyyx)
  {
    this.a = paramyyx;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    yyx localyyx = this.a;
    if (localyyx != null) {
      localyyx.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    yyx localyyx = this.a;
    if (localyyx != null) {
      localyyx.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyz
 * JD-Core Version:    0.7.0.1
 */