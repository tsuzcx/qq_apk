package com.tencent.token;

import com.tencent.halley.common.b;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class bm
  implements bl
{
  private int a = 1;
  private int b = 1;
  private int c = 20000;
  private int d = 3;
  private ArrayList e = null;
  private int f = 0;
  private boolean g = false;
  private ArrayList h = null;
  private int i = 0;
  private boolean j = false;
  private String k = "dispatcher.3g.qq.com";
  private Socket l;
  private int m;
  private int n;
  private int o;
  private int p;
  private ay q;
  
  public bm()
  {
    int[] arrayOfInt = bf.a;
    this.l = null;
    this.m = 0;
    this.n = 0;
    this.o = -1;
    this.p = -1;
  }
  
  private static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (paramInt1 >= paramArrayList.size())) {}
    do
    {
      return paramArrayList;
      paramInt2 = Math.min(paramInt2, paramArrayList.size() - paramInt1);
    } while (paramInt2 <= 0);
    ArrayList localArrayList = new ArrayList(paramInt2);
    paramArrayList = paramArrayList.subList(paramInt1, paramInt1 + paramInt2);
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ay localay = (ay)paramArrayList.get(paramInt1);
      localArrayList.add(new ay(localay.a(), localay.b()));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public final void a()
  {
    boolean bool;
    if ((this.e == null) || (this.e.size() <= 0))
    {
      bool = true;
      this.g = bool;
      if (this.h != null) {
        break label167;
      }
      bool = true;
      label33:
      this.j = bool;
      b.a("SocketConnectorImpl", "doConnect...");
    }
    for (;;)
    {
      if (((!this.g) || (!this.j)) && (this.n <= this.d))
      {
        this.n += 1;
        if (!bp.c()) {
          break label172;
        }
        this.l = bk.a(this.k, this.c);
      }
      label167:
      label172:
      long l1;
      for (;;)
      {
        if ((this.l != null) && (this.l.isConnected()) && (!this.l.isClosed()))
        {
          this.q = new ay(this.l.getInetAddress().getHostAddress(), this.l.getPort());
          this.m = 0;
          return;
          bool = false;
          break;
          bool = false;
          break label33;
          Object localObject;
          if (!this.g)
          {
            l1 = System.currentTimeMillis();
            localObject = a(this.e, this.f, this.a, true);
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              this.f += ((ArrayList)localObject).size();
              if (this.f < this.e.size()) {}
            }
            else
            {
              this.g = true;
            }
            this.l = bk.a((ArrayList)localObject, this.c);
            this.o = 0;
            this.p = ((int)(System.currentTimeMillis() - l1));
            b.a("SocketConnectorImpl", "use IpList, dnsTime: 0 ,connectTime：" + this.p);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localObject = localArrayList;
            if (!this.j)
            {
              localObject = localArrayList;
              if (this.h != null)
              {
                localObject = localArrayList;
                if (this.h.size() > 0)
                {
                  localObject = localArrayList;
                  if (this.i < this.h.size())
                  {
                    localArrayList = a(this.h, this.i, this.b, true);
                    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
                      break label519;
                    }
                    this.i += localArrayList.size();
                    localObject = localArrayList;
                    if (this.i < this.h.size()) {
                      break label437;
                    }
                    localObject = localArrayList;
                  }
                }
              }
              this.j = true;
            }
            for (;;)
            {
              label437:
              localObject = bk.a((ArrayList)localObject, this.k, this.c);
              if (localObject != null) {
                this.l = ((bj)localObject).c();
              }
              this.o = bk.a;
              this.p = bk.b;
              b.a("SocketConnectorImpl", "use IpList DNS parallel , dnsTime:" + this.o + ",connectTime：" + this.p);
              break;
              label519:
              this.j = true;
              localObject = localArrayList;
            }
          }
        }
      }
      if (bp.f())
      {
        this.m = -3;
        l1 = 3000;
      }
      try
      {
        Thread.sleep(l1);
        for (;;)
        {
          label552:
          this.l = null;
          break;
          this.m = -4;
          l1 = 5000;
          try
          {
            Thread.sleep(l1);
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        break label552;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.k = paramString;
  }
  
  public final void a(ArrayList paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  public final void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.h = paramArrayList;
  }
  
  public final void a(int[] paramArrayOfInt)
  {
    paramArrayOfInt.clone();
  }
  
  public final int b()
  {
    return this.m;
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4))
    {
      this.a = paramInt;
      this.b = paramInt;
    }
  }
  
  public final Socket c()
  {
    return this.l;
  }
  
  public final int d()
  {
    return this.o;
  }
  
  public final int e()
  {
    return this.p;
  }
  
  public final ay f()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bm
 * JD-Core Version:    0.7.0.1
 */