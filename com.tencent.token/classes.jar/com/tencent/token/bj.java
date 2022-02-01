package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class bj
{
  private int a;
  private String b = "";
  private Socket c = null;
  private int d = -1;
  private int e = -1;
  private ay f;
  
  public void a()
  {
    b.c("ConnectorImpl", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
    l1 = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.b)) {}
    for (;;)
    {
      try
      {
        Object localObject = InetAddress.getByName(this.b);
        this.d = ((int)(System.currentTimeMillis() - l1));
        localObject = new InetSocketAddress(((InetAddress)localObject).getHostAddress(), 14000);
        Socket localSocket = new Socket();
        l1 = 0L;
        try
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          this.a = bd.a().b.a;
          l1 = l2;
          localSocket.connect((SocketAddress)localObject, this.a);
          l1 = l2;
          if (localSocket.isConnected())
          {
            l1 = l2;
            if (!localSocket.isClosed())
            {
              l1 = l2;
              this.c = localSocket;
              l1 = l2;
              this.e = ((int)(System.currentTimeMillis() - l2));
            }
          }
        }
        catch (Exception localException2)
        {
          InetSocketAddress localInetSocketAddress;
          localException2.printStackTrace();
          localException2.getClass().getSimpleName();
          bq.a(localException2);
          this.e = ((int)(System.currentTimeMillis() - l1));
          this.c = null;
          continue;
        }
        System.currentTimeMillis();
        return;
      }
      catch (Exception localException1)
      {
        localException1.getClass().getSimpleName();
        new StringBuilder("Dns InetAddress exception: domain").append(this.b).toString();
        localInetSocketAddress = null;
        continue;
      }
      localInetSocketAddress = new InetSocketAddress(this.f.a(), this.f.b());
      this.d = 0;
    }
  }
  
  public void a(ay paramay)
  {
    this.f = paramay;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    try
    {
      this.c.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public Socket c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bj
 * JD-Core Version:    0.7.0.1
 */