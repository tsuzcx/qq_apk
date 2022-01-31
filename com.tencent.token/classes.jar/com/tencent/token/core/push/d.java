package com.tencent.token.core.push;

import com.tencent.token.global.h;
import java.net.InetSocketAddress;
import java.net.Socket;

class d
  implements Runnable
{
  d(b paramb) {}
  
  public void run()
  {
    this.a.c();
    if ((b.e() == null) || (b.f() == null) || (b.e().length == 0) || (b.f().length == 0))
    {
      b.b(0);
      return;
    }
    if (b.a(this.a) >= b.b(this.a))
    {
      b.b(0);
      b.a(this.a, 0);
      return;
    }
    h.a("pushservice connect....");
    try
    {
      int i = b.a(this.a) % b.e().length;
      h.a("socket connect server ok [" + b.e()[i] + ", " + b.f()[i] + "]");
      b.b(this.a, 0L);
      b.a(this.a, new Socket());
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(b.e()[i], b.f()[i]);
      b.c(this.a).connect(localInetSocketAddress, 3000);
      b.c(this.a).setKeepAlive(true);
      h.a("socket connect server ok [" + b.e()[i] + ", " + b.f()[i] + "]");
      b.d(this.a);
      b.b(2);
      b.e(this.a);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      h.c(localException.toString());
      this.a.c();
      b.b(6);
      b.a(this.a, System.currentTimeMillis());
      return;
    }
    finally
    {
      b.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.d
 * JD-Core Version:    0.7.0.1
 */