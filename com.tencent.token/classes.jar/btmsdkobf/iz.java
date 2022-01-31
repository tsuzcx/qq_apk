package btmsdkobf;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

final class iz
  implements ServiceConnection
{
  iz(long paramLong, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    ev.i(System.currentTimeMillis() - this.a);
    this.b.set(paramIBinder);
    this.c.set(this);
    try
    {
      synchronized (this.d)
      {
        this.d.notifyAll();
        label42:
        return;
      }
    }
    catch (Throwable paramIBinder)
    {
      break label42;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.iz
 * JD-Core Version:    0.7.0.1
 */