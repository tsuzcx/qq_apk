import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class vtc
  implements ServiceConnection
{
  private vta a;
  
  public vtc(vta paramvta)
  {
    this.a = paramvta;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    vta localvta = this.a;
    if (localvta != null) {
      localvta.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    vta localvta = this.a;
    if (localvta != null) {
      localvta.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vtc
 * JD-Core Version:    0.7.0.1
 */