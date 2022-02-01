package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

final class m$2
  extends TimerTask
{
  m$2(m paramm, Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      this.a.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      ai.a("CC_", "timer cancel error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.m.2
 * JD-Core Version:    0.7.0.1
 */