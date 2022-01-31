package taiji;

import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.locks.ReentrantLock;

class by
  implements Runnable
{
  by(bx parambx, Parcel paramParcel1, Parcel paramParcel2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        bx.a(this.c).lock();
        bx.b(this.c).transact(1, this.a, this.b, 0);
        bx.a(this.c).unlock();
        this.b.readException();
        int i = this.b.readInt();
        if (System.currentTimeMillis() - l < 200L)
        {
          if (i != 0) {
            continue;
          }
          bx.a(this.c, -1);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      try
      {
        notify();
        return;
      }
      finally {}
      bx.a(this.c, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.by
 * JD-Core Version:    0.7.0.1
 */