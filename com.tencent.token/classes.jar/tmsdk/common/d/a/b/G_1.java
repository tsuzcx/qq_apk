package tmsdk.common.d.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tmsdk.common.d.a.c.n;
import tmsdk.common.d.a.c.s;

class G
  extends Handler
{
  private boolean b = false;
  
  G(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (z.c(this.a).a()) {}
    label204:
    do
    {
      do
      {
        return;
        paramMessage = (j)z.c(this.a).c();
      } while (paramMessage == null);
      if (!z.d(this.a).f())
      {
        z.f(this.a).a(z.e(this.a));
        if (!z.d(this.a).c())
        {
          z.a(this.a, paramMessage, -2);
          return;
        }
      }
      this.b = paramMessage.d;
      d.b.d locald = paramMessage.e;
      a.e.d locald1 = z.a(this.a, paramMessage.b);
      if (locald1 == null)
      {
        z.a(this.a, paramMessage, -609);
        return;
      }
      locald1.b = paramMessage.a;
      int i;
      if (locald == null) {
        i = z.d(this.a).a(locald1);
      }
      for (;;)
      {
        if (i == 0) {
          break label204;
        }
        z.a(this.a, paramMessage, i - 3);
        return;
        locald.a(1);
        if (locald.a()) {
          break;
        }
        i = z.d(this.a).a(locald1);
        locald.a(2);
      }
    } while (this.b);
    z.d(this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.G
 * JD-Core Version:    0.7.0.1
 */