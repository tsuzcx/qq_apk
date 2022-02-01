package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.token.av;
import com.tencent.token.av.a;
import com.tencent.token.ay;
import com.tencent.token.bi;

public class LifecycleService
  extends Service
  implements ay
{
  private final bi a = new bi(this);
  
  public av getLifecycle()
  {
    return this.a.a;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.a.a(av.a.ON_START);
    return null;
  }
  
  public void onCreate()
  {
    this.a.a(av.a.ON_CREATE);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    bi localbi = this.a;
    localbi.a(av.a.ON_STOP);
    localbi.a(av.a.ON_DESTROY);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    this.a.a(av.a.ON_START);
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleService
 * JD-Core Version:    0.7.0.1
 */