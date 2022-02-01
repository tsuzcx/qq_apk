package c.t.m.g;

import java.io.File;

final class c$2
  implements Runnable
{
  c$2(c paramc, File paramFile, String paramString) {}
  
  public final void run()
  {
    try
    {
      byte[] arrayOfByte = ai.a(this.a);
      if (ai.b(arrayOfByte))
      {
        this.a.delete();
        if (ai.a()) {
          ai.a(3, "DC_Pro", "file " + this.a.getName() + " is empty, then delete.", null);
        }
      }
      else
      {
        h.k.a(this.b, arrayOfByte, new c.2.1(this));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (ai.a()) {
        ai.a("DC_Pro", "upload error,url=" + this.b, localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.c.2
 * JD-Core Version:    0.7.0.1
 */