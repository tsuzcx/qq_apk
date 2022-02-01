import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class zfl
  implements ServiceConnection
{
  private zfj a;
  
  public zfl(zfj paramzfj)
  {
    this.a = paramzfj;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zfj localzfj = this.a;
    if (localzfj != null) {
      localzfj.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zfj localzfj = this.a;
    if (localzfj != null) {
      localzfj.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfl
 * JD-Core Version:    0.7.0.1
 */