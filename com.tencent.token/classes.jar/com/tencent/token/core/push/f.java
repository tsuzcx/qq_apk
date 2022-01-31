package com.tencent.token.core.push;

import com.tencent.token.cx;
import com.tencent.token.dg;
import com.tencent.token.global.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class f
  implements Runnable
{
  f(b paramb) {}
  
  public void run()
  {
    if (b.c(this.a) == null) {
      this.a.d();
    }
    for (;;)
    {
      return;
      Object localObject2 = cx.c();
      ((cx)localObject2).m();
      long l = ((cx)localObject2).k();
      Object localObject1 = cx.b();
      localObject2 = ((cx)localObject2).o();
      Object localObject3 = new byte[((String)localObject2).length() + 10 + 2 + ((String)localObject1).length() + 2 + b.i(this.a).length()];
      dg.b((byte[])localObject3, 0, l);
      dg.a((byte[])localObject3, 8, (short)((String)localObject2).length());
      dg.a((byte[])localObject3, 10, ((String)localObject2).getBytes(), ((String)localObject2).length());
      int i = ((String)localObject2).length() + 10;
      dg.a((byte[])localObject3, i, (short)((String)localObject1).length());
      i += 2;
      dg.a((byte[])localObject3, i, ((String)localObject1).getBytes(), ((String)localObject1).length());
      i += ((String)localObject1).length();
      dg.a((byte[])localObject3, i, (short)b.i(this.a).length());
      dg.a((byte[])localObject3, i + 2, b.i(this.a).getBytes(), b.i(this.a).length());
      localObject2 = b.a(this.a, (byte[])localObject3);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b.a(this.a, (byte[])localObject3);
      }
      if (localObject1 == null)
      {
        this.a.c();
        b.b(7);
        return;
      }
      localObject1 = i.a((byte[])localObject1);
      try
      {
        localObject2 = b.c(this.a).getOutputStream();
        localObject3 = b.c(this.a).getInputStream();
        ((OutputStream)localObject2).write((byte[])localObject1);
        ((OutputStream)localObject2).flush();
        h.a("socket available: " + ((InputStream)localObject3).available());
        i = b.a(this.a, (InputStream)localObject3, true);
        if (i == 0)
        {
          b.b(4);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        h.c("socket client verify failed" + localIOException.toString());
        this.a.d();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        h.c("socket client verify failed" + localException.toString());
        this.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.f
 * JD-Core Version:    0.7.0.1
 */