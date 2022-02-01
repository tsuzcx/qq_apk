package c.t.m.g;

import android.os.Looper;

public abstract class x
  extends y
{
  public abstract int a(Looper paramLooper);
  
  public final int b(Looper paramLooper)
  {
    synchronized (this.p)
    {
      if (this.o) {
        return -1;
      }
      this.o = true;
      if (ai.a()) {
        ai.a(3, b(), "startup()", null);
      }
      int i = a(paramLooper);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.x
 * JD-Core Version:    0.7.0.1
 */