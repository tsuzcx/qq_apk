package c.t.m.g;

import android.location.LocationManager;

final class ay$1
  implements Runnable
{
  ay$1(ay paramay) {}
  
  public final void run()
  {
    try
    {
      bool1 = ay.b(this.a).h.addNmeaListener(ay.a(this.a));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          bool2 = ay.b(this.a).h.addGpsStatusListener(ay.a(this.a));
          if ((!bool1) && (!bool2))
          {
            bz.a = true;
            ay.c(this.a);
          }
          return;
          localThrowable1 = localThrowable1;
          boolean bool1 = true;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          boolean bool2 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ay.1
 * JD-Core Version:    0.7.0.1
 */