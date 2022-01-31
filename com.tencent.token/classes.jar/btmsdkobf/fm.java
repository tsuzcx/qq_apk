package btmsdkobf;

import android.os.Handler;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

class fm
  implements Runnable
{
  fm(cb paramcb, cy.f paramf, byte[] paramArrayOfByte, ca.a parama) {}
  
  public void run()
  {
    ??? = new AtomicReference();
    try
    {
      i = new ca(cb.e(this.d), cb.f(this.d), cb.g(this.d), cb.h(this.d)).a(this.a, this.b, (AtomicReference)???);
      ??? = new fn(this, i, (byte[])((AtomicReference)???).get());
      ee localee = ee.cT();
      if (cx.ay()) {
        localee.addUrgentTask((Runnable)???, "shark-http-callback");
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (cb.a(this.d))
      {
        for (;;)
        {
          cb.i(this.d);
          if (cb.c(this.d).size() > 0) {
            cb.j(this.d).sendEmptyMessage(1);
          }
          eh.e(cb.aS(), "[http_control]-------- send finish, running tasks: " + cb.b(this.d) + ", waiting tasks: " + cb.c(this.d).size());
          return;
          localThrowable = localThrowable;
          eh.b(cb.aS(), "sendDataAsyn(), exception:", localThrowable);
          int i = -1200;
        }
        localThrowable.addTask((Runnable)???, "shark-http-callback");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fm
 * JD-Core Version:    0.7.0.1
 */