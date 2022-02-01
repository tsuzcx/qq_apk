package wf7;

import android.os.Handler;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

class ez$2
  implements Runnable
{
  ez$2(ez paramez, em.d paramd, byte[] paramArrayOfByte, ey.a parama) {}
  
  public void run()
  {
    ??? = new AtomicReference();
    try
    {
      i = new ey(ez.e(this.px), ez.f(this.px), ez.g(this.px), ez.h(this.px)).a(this.py, this.pz, (AtomicReference)???);
      ??? = (byte[])((AtomicReference)???).get();
      ea.bV().a(new ez.2.1(this, i, (byte[])???), "shark-http-callback");
      synchronized (ez.a(this.px))
      {
        ez.i(this.px);
        if (ez.c(this.px).size() > 0) {
          ez.j(this.px).sendEmptyMessage(1);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = -1200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ez.2
 * JD-Core Version:    0.7.0.1
 */