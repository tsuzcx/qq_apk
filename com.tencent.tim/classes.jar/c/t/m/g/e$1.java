package c.t.m.g;

import java.util.concurrent.atomic.AtomicBoolean;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    if (e.a(this.a).get()) {
      return;
    }
    e.a(this.a).set(true);
    try
    {
      e.b(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      ai.a("UserTrackPro", "uploadUTR() error.", localThrowable);
      return;
    }
    finally
    {
      e.a(this.a).set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.e.1
 * JD-Core Version:    0.7.0.1
 */