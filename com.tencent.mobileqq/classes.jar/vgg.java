import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class vgg
  implements ServiceConnection
{
  private vge a;
  
  public vgg(vge paramvge)
  {
    this.a = paramvge;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    vge localvge = this.a;
    if (localvge != null) {
      localvge.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    vge localvge = this.a;
    if (localvge != null) {
      localvge.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgg
 * JD-Core Version:    0.7.0.1
 */