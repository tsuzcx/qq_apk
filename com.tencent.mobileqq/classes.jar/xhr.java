import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class xhr
  implements ServiceConnection
{
  private xhp a;
  
  public xhr(xhp paramxhp)
  {
    this.a = paramxhp;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    xhp localxhp = this.a;
    if (localxhp != null) {
      localxhp.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    xhp localxhp = this.a;
    if (localxhp != null) {
      localxhp.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhr
 * JD-Core Version:    0.7.0.1
 */