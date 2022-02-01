package tmsdk.common.d.a.b;

import a.e.d;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.ei;
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
    if (z.c(this.a).a()) {
      return;
    }
    paramMessage = (j)z.c(this.a).c();
    if (paramMessage == null) {
      return;
    }
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
    ei localei = paramMessage.e;
    d locald = z.a(this.a, paramMessage.b);
    if (locald == null)
    {
      z.a(this.a, paramMessage, -609);
      return;
    }
    locald.b = paramMessage.a;
    int i;
    if (localei == null)
    {
      i = z.d(this.a).a(locald);
    }
    else
    {
      localei.a(1);
      if (localei.a()) {
        return;
      }
      i = z.d(this.a).a(locald);
      localei.a(2);
    }
    if (i != 0)
    {
      z.a(this.a, paramMessage, i - 3);
      return;
    }
    if (!this.b) {
      z.d(this.a).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.G
 * JD-Core Version:    0.7.0.1
 */