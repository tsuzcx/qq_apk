package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

final class ai$1
  extends TimerTask
{
  ai$1(HandlerThread paramHandlerThread, Handler paramHandler, Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      ai.a(this.a);
      if (this.d != null) {
        this.d.cancel();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!ai.a()) {}
      ai.a("HandlerThreadUtil", "timertask error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ai.1
 * JD-Core Version:    0.7.0.1
 */