package c.t.m.g;

import android.os.Looper;

public abstract class z
  extends al.a
{
  protected volatile boolean a = false;
  protected byte[] b = new byte[0];
  
  public abstract int a();
  
  public int a(Looper arg1)
  {
    synchronized (this.b)
    {
      if (this.a) {
        return -1;
      }
      this.a = true;
      if (ai.a()) {
        ai.a(3, c(), "startup()", null);
      }
      int i = a();
      return i;
    }
  }
  
  public abstract void b();
  
  public abstract String c();
  
  public void d()
  {
    synchronized (this.b)
    {
      if (!this.a) {
        return;
      }
      if (ai.a()) {
        ai.a(3, c(), "shutdown()", null);
      }
      b();
      this.a = false;
      return;
    }
  }
  
  public final boolean f()
  {
    synchronized (this.b)
    {
      boolean bool = this.a;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.z
 * JD-Core Version:    0.7.0.1
 */