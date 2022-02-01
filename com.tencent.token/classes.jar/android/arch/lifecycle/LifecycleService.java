package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.token.bj;
import com.tencent.token.bj.a;
import com.tencent.token.bm;
import com.tencent.token.bw;

public class LifecycleService
  extends Service
  implements bm
{
  private final bw a = new bw(this);
  
  public bj getLifecycle()
  {
    return this.a.a;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.a.a(bj.a.ON_START);
    return null;
  }
  
  public void onCreate()
  {
    this.a.a(bj.a.ON_CREATE);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    bw localbw = this.a;
    localbw.a(bj.a.ON_STOP);
    localbw.a(bj.a.ON_DESTROY);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    this.a.a(bj.a.ON_START);
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