package c.t.m.g;

public abstract class y
{
  protected volatile boolean o = false;
  protected byte[] p = new byte[0];
  
  public abstract void a();
  
  public abstract String b();
  
  public final boolean d()
  {
    synchronized (this.p)
    {
      boolean bool = this.o;
      return bool;
    }
  }
  
  public final void e()
  {
    synchronized (this.p)
    {
      if (!this.o) {
        return;
      }
      if (ai.a()) {
        ai.a(3, b(), "shutdown()", null);
      }
      a();
      this.o = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.y
 * JD-Core Version:    0.7.0.1
 */