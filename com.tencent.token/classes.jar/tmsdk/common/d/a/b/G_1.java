package tmsdk.common.d.a.b;

import a.e.d;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.eh;
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
      eh localeh = paramMessage.e;
      d locald = z.a(this.a, paramMessage.b);
      if (locald == null)
      {
        z.a(this.a, paramMessage, -609);
        return;
      }
      locald.b = paramMessage.a;
      int i;
      if (localeh == null) {
        i = z.d(this.a).a(locald);
      }
      for (;;)
      {
        if (i == 0) {
          break label204;
        }
        z.a(this.a, paramMessage, i - 3);
        return;
        localeh.a(1);
        if (localeh.a()) {
          break;
        }
        i = z.d(this.a).a(locald);
        localeh.a(2);
      }
    } while (this.b);
    z.d(this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.G
 * JD-Core Version:    0.7.0.1
 */