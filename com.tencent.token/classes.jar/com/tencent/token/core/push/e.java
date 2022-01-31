package com.tencent.token.core.push;

import com.tencent.token.global.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class e
  implements Runnable
{
  e(b paramb) {}
  
  public void run()
  {
    if (b.c(this.a) == null) {
      this.a.d();
    }
    for (;;)
    {
      return;
      b.a(this.a, com.tencent.token.utils.encrypt.b.a());
      Object localObject = com.tencent.token.utils.encrypt.b.a(b.f(this.a), 2L, b.g(this.a));
      if ((b.f(this.a) == null) || (localObject == null) || (((String)localObject).length() == 0))
      {
        this.a.c();
        b.b(6);
        b.a(this.a, System.currentTimeMillis());
        return;
      }
      localObject = i.a((String)localObject);
      try
      {
        OutputStream localOutputStream = b.c(this.a).getOutputStream();
        InputStream localInputStream = b.c(this.a).getInputStream();
        localOutputStream.write((byte[])localObject);
        localOutputStream.flush();
        h.a("socket available: " + localInputStream.available());
        int i = b.a(this.a, localInputStream, false);
        if (i == 0)
        {
          b.b(3);
          b.h(this.a);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        h.c("socket exchange key failed" + localIOException.toString());
        this.a.d();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        h.c("socket exchange key failed" + localException.toString());
        this.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.e
 * JD-Core Version:    0.7.0.1
 */