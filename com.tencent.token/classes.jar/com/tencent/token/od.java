package com.tencent.token;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class od
  implements oc
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
  private np q;
  
  public od()
  {
    int[] arrayOfInt = nw.a;
    this.l = null;
    this.m = 0;
    this.n = 0;
    this.o = -1;
    this.p = -1;
  }
  
  private static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramInt1 >= paramArrayList.size()) {
        return paramArrayList;
      }
      paramInt2 = Math.min(paramInt2, paramArrayList.size() - paramInt1);
      if (paramInt2 <= 0) {
        return paramArrayList;
      }
      ArrayList localArrayList = new ArrayList(paramInt2);
      paramArrayList = paramArrayList.subList(paramInt1, paramInt1 + paramInt2);
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        np localnp = (np)paramArrayList.get(paramInt1);
        localArrayList.add(new np(localnp.a, localnp.b));
        paramInt1 += 1;
      }
      return localArrayList;
    }
    return paramArrayList;
  }
  
  public final void a()
  {
    Object localObject = this.e;
    boolean bool;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      bool = false;
    } else {
      bool = true;
    }
    this.g = bool;
    if (this.h == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
    lo.a("SocketConnectorImpl", "doConnect...");
    while ((!this.g) || (!this.j))
    {
      int i1 = this.n;
      if (i1 > this.d) {
        break;
      }
      this.n = (i1 + 1);
      if (og.c())
      {
        this.l = ob.a(this.k, this.c);
      }
      else if (!this.g)
      {
        l1 = System.currentTimeMillis();
        localObject = a(this.e, this.f, this.a);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.f += ((ArrayList)localObject).size();
          if (this.f < this.e.size()) {}
        }
        else
        {
          this.g = true;
        }
        this.l = ob.a((ArrayList)localObject, this.c);
        this.o = 0;
        this.p = ((int)(System.currentTimeMillis() - l1));
        localObject = new StringBuilder("use IpList, dnsTime: 0 ,connectTime：");
        ((StringBuilder)localObject).append(this.p);
        lo.a("SocketConnectorImpl", ((StringBuilder)localObject).toString());
      }
      else
      {
        ArrayList localArrayList1 = new ArrayList();
        localObject = localArrayList1;
        if (!this.j)
        {
          ArrayList localArrayList2 = this.h;
          localObject = localArrayList1;
          if (localArrayList2 != null)
          {
            localObject = localArrayList1;
            if (localArrayList2.size() > 0)
            {
              localObject = localArrayList1;
              if (this.i < this.h.size())
              {
                localArrayList1 = a(this.h, this.i, this.b);
                localObject = localArrayList1;
                if (localArrayList1 != null)
                {
                  localObject = localArrayList1;
                  if (localArrayList1.size() > 0)
                  {
                    this.i += localArrayList1.size();
                    localObject = localArrayList1;
                    if (this.i < this.h.size()) {
                      break label398;
                    }
                    localObject = localArrayList1;
                  }
                }
              }
            }
          }
          this.j = true;
        }
        label398:
        localObject = ob.a((ArrayList)localObject, this.k, this.c);
        if (localObject != null) {
          this.l = ((oa)localObject).c;
        }
        this.o = ob.a;
        this.p = ob.b;
        localObject = new StringBuilder("use IpList DNS parallel , dnsTime:");
        ((StringBuilder)localObject).append(this.o);
        ((StringBuilder)localObject).append(",connectTime：");
        ((StringBuilder)localObject).append(this.p);
        lo.a("SocketConnectorImpl", ((StringBuilder)localObject).toString());
      }
      localObject = this.l;
      if ((localObject != null) && (((Socket)localObject).isConnected()) && (!this.l.isClosed()))
      {
        this.q = new np(this.l.getInetAddress().getHostAddress(), this.l.getPort());
        this.m = 0;
        return;
      }
      if (og.f()) {
        this.m = -3;
      }
      for (long l1 = 3000L;; l1 = 5000L)
      {
        try
        {
          Thread.sleep(l1);
        }
        catch (Exception localException)
        {
          break;
        }
        this.m = -4;
      }
      this.l = null;
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
  
  public final void b(ArrayList paramArrayList)
  {
    this.h = paramArrayList;
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
  
  public final np f()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.od
 * JD-Core Version:    0.7.0.1
 */