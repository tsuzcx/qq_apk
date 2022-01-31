package com.tencent.component.network.module.common.a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public final class f
{
  private String a = "";
  
  public f(String paramString)
    throws UnknownHostException
  {
    this.a = paramString;
  }
  
  public final InetAddress[] a(String paramString, long paramLong)
    throws IOException, SocketTimeoutException, j, UnknownHostException, Exception
  {
    InetAddress[] arrayOfInetAddress = null;
    g localg = new g(paramString);
    Object localObject1 = localg.a();
    if (localObject1 == null) {
      localObject1 = arrayOfInetAddress;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = new i();
        ((i)localObject2).a(paramLong);
        localObject2 = ((i)localObject2).a(this.a, (byte[])localObject1);
        localObject1 = arrayOfInetAddress;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = new h(new d((byte[])localObject2), paramString);
        localObject1 = arrayOfInetAddress;
        if (((h)localObject2).c() != localg.b()) {
          continue;
        }
        arrayOfInetAddress = ((h)localObject2).a();
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress == null) {
          continue;
        }
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress.length <= 0) {
          continue;
        }
        localObject1 = e.a();
        ((h)localObject2).b();
        ((e)localObject1).a(paramString);
        return arrayOfInetAddress;
      }
      catch (j paramString)
      {
        throw paramString;
      }
      catch (SocketTimeoutException paramString)
      {
        throw paramString;
      }
      catch (IOException paramString)
      {
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.f
 * JD-Core Version:    0.7.0.1
 */