package com.tencent.token.core.push;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.cx;
import com.tencent.token.dg;
import com.tencent.token.ex;
import com.tencent.token.global.h;
import com.tencent.token.utils.encrypt.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class b
{
  private static String[] A = null;
  private static int[] B = null;
  static b a = null;
  private static int x = 0;
  private int C = 10;
  private int D = 300000;
  private int E = 300000;
  private int F = 0;
  private final int[] G = { 1000, 10000, 30000, 90000, 180000, 300000 };
  private final int H = 3000;
  private final int I = 3000;
  public final byte b = 0;
  public final byte c = 1;
  byte[] d = null;
  HandlerThread e;
  Handler f;
  private final long g = 2L;
  private final ex h = new ex("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private ex i = new ex("-1");
  private byte[] j;
  private String k = "";
  private final int l = 0;
  private final int m = 1;
  private final int n = 101;
  private final int o = 102;
  private final int p = 103;
  private final int q = 104;
  private final int r = 105;
  private final int s = 106;
  private final int t = 107;
  private final int u = 108;
  private final int v = 109;
  private Socket w = null;
  private long y;
  private long z;
  
  private int a(InputStream paramInputStream, boolean paramBoolean)
  {
    int i2;
    if ((paramInputStream == null) || (this.w == null))
    {
      d();
      i2 = -2;
      return i2;
    }
    byte[] arrayOfByte;
    int i3;
    Object localObject;
    int i1;
    try
    {
      this.w.setSoTimeout(3000);
      if (paramBoolean) {
        paramInputStream.skip(paramInputStream.available());
      }
      arrayOfByte = new byte[5];
      paramInputStream.read(arrayOfByte);
      i3 = dg.a(arrayOfByte, 1);
      if (i3 <= 42)
      {
        h.c("socket rsp msg len not correct: " + i3);
        return -1;
      }
      i2 = dg.a(arrayOfByte, 3);
      localObject = new byte[i3];
      i1 = 0;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
        h.c("socket decodeInputSream failed" + paramInputStream.toString());
        d();
        return -2;
        paramInputStream = new l();
        i2 = i.a((byte[])localObject, i3, paramInputStream);
        i1 = i2;
        if (i2 == 0)
        {
          i2 = i.a((byte[])localObject, i3, paramInputStream);
          i1 = i2;
          if (i2 == 0)
          {
            paramInputStream = new ex(new String(paramInputStream.m), 16);
            this.j = com.tencent.token.utils.encrypt.b.a(this.i, paramInputStream, this.h);
            i1 = i2;
            if (this.j == null)
            {
              i1 = 1;
              continue;
              paramInputStream = new o();
              i2 = i.a((byte[])localObject, i3, paramInputStream);
              i1 = i2;
              if (i2 == 0)
              {
                i2 = i.a((byte[])localObject, i3, paramInputStream);
                if ((i2 != 0) && (paramInputStream.n > 0L))
                {
                  l1 = System.currentTimeMillis();
                  l2 = paramInputStream.n;
                  localObject = cx.c();
                  ((cx)localObject).a(l2 * 1000L - l1);
                  ((cx)localObject).i();
                }
                i1 = i2;
                if (i2 == 0)
                {
                  this.k = new String(paramInputStream.p);
                  i1 = i2;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      h.c("socket decodeInputSream failed" + paramInputStream.toString());
      d();
      return -2;
    }
    paramInputStream.read((byte[])localObject, 5, i3 - 5);
    h.a("socket pkg type: " + i2);
    switch (i2)
    {
    }
    for (;;)
    {
      i2 = i1;
      if (i1 == 0) {
        break;
      }
      c(i1);
      return i1;
      long l1;
      long l2;
      paramInputStream = new n();
      i2 = i.a((byte[])localObject, i3, paramInputStream);
      i1 = i2;
      if (i2 == 0)
      {
        i2 = i.a((byte[])localObject, i3, paramInputStream);
        i1 = i2;
        if (i2 == 0)
        {
          this.d = b(paramInputStream.n);
          if (this.d == null) {
            this.d = b(paramInputStream.n);
          }
          paramInputStream = this.d;
          i1 = i2;
          if (paramInputStream == null)
          {
            i1 = 101;
            continue;
            while (i1 < 5)
            {
              localObject[i1] = arrayOfByte[i1];
              i1 += 1;
            }
            i1 = 101;
          }
        }
      }
    }
  }
  
  public static b a()
  {
    if (a == null)
    {
      a = new b();
      x = 0;
    }
    return a;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new a().b(paramArrayOfByte, this.j);
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte == null)
    {
      h.c("encrypt data failed");
      paramArrayOfByte = null;
    }
    return paramArrayOfByte;
  }
  
  private m b(Handler paramHandler)
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new g(this, paramHandler));
      return null;
    }
    catch (Exception paramHandler)
    {
      return null;
    }
    catch (Error paramHandler) {}
    return null;
  }
  
  public static void b()
  {
    a = null;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new a().a(paramArrayOfByte, this.j);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      h.c(paramArrayOfByte.toString());
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      c();
      x = 7;
      return;
    case 109: 
      d();
      return;
    case 1: 
    case 103: 
      c();
      x = 6;
      this.z = System.currentTimeMillis();
      return;
    }
    c();
    x = 8;
  }
  
  private void g()
  {
    try
    {
      new c(this).c(new String[] { "" });
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void h()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new d(this));
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void i()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new e(this));
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void j()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new f(this));
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private int k()
  {
    if (this.F < this.G.length) {
      return this.G[this.F];
    }
    return this.G[(this.G.length - 1)];
  }
  
  public m a(Handler paramHandler)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (x)
    {
    case 4: 
    default: 
      localObject1 = localObject2;
      if (4 == x) {
        localObject1 = b(paramHandler);
      }
      break;
    }
    do
    {
      return localObject1;
      g();
      break;
      h();
      break;
      i();
      break;
      j();
      break;
      localObject1 = localObject2;
    } while (System.currentTimeMillis() - this.z <= k());
    x = 1;
    return null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      x = paramInt;
      return;
      c();
      x = paramInt;
      return;
    } while (x != 8);
    x = 1;
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    A = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      A[i1] = paramArrayOfString[i1];
      h.a("socket server ip[" + i1 + "]=" + A[i1]);
      i1 += 1;
    }
    B = new int[paramArrayOfInt.length];
    i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      B[i1] = paramArrayOfInt[i1];
      h.a("socket server port[" + i1 + "]=" + B[i1]);
      i1 += 1;
    }
    this.C = paramInt1;
    this.E = paramInt2;
    this.D = paramInt3;
    h.a("socket reconn params reconn_count: " + this.C + ", reconn_time_interval: " + this.E + ", heart_break_time: " + this.D);
    this.F = 0;
  }
  
  public void c()
  {
    if (this.w == null) {
      return;
    }
    try
    {
      this.w.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      h.c("socket close connection failed" + localIOException.toString());
      return;
    }
    catch (Exception localException)
    {
      h.c("socket close connection failed" + localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    x = 5;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.b
 * JD-Core Version:    0.7.0.1
 */