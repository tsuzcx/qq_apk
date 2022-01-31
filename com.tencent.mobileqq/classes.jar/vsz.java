import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class vsz
  implements ServiceConnection
{
  private vsx a;
  
  public vsz(vsx paramvsx)
  {
    this.a = paramvsx;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    vsx localvsx = this.a;
    if (localvsx != null) {
      localvsx.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    vsx localvsx = this.a;
    if (localvsx != null) {
      localvsx.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsz
 * JD-Core Version:    0.7.0.1
 */