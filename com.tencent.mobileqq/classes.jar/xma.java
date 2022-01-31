import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class xma
  implements ServiceConnection
{
  private xly a;
  
  public xma(xly paramxly)
  {
    this.a = paramxly;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    xly localxly = this.a;
    if (localxly != null) {
      localxly.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    xly localxly = this.a;
    if (localxly != null) {
      localxly.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xma
 * JD-Core Version:    0.7.0.1
 */