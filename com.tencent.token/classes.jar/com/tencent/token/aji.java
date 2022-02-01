package com.tencent.token;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class aji
{
  final ahs a;
  final ajg b;
  private final ahw c;
  private final aig d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private final List<ait> h = new ArrayList();
  
  public aji(ahs paramahs, ajg paramajg, ahw paramahw, aig paramaig)
  {
    this.a = paramahs;
    this.b = paramajg;
    this.c = paramahw;
    this.d = paramaig;
    paramajg = paramahs.a;
    paramahs = paramahs.h;
    if (paramahs != null)
    {
      paramahs = Collections.singletonList(paramahs);
    }
    else
    {
      paramahs = this.a.g.select(paramajg.a());
      if ((paramahs != null) && (!paramahs.isEmpty())) {
        paramahs = aix.a(paramahs);
      } else {
        paramahs = aix.a(new Proxy[] { Proxy.NO_PROXY });
      }
    }
    this.e = paramahs;
    this.f = 0;
  }
  
  private void a(Proxy paramProxy)
  {
    this.g = new ArrayList();
    Object localObject;
    int i;
    if ((paramProxy.type() != Proxy.Type.DIRECT) && (paramProxy.type() != Proxy.Type.SOCKS))
    {
      localObject = paramProxy.address();
      if ((localObject instanceof InetSocketAddress))
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)localObject;
        localObject = localInetSocketAddress.getAddress();
        if (localObject == null) {
          localObject = localInetSocketAddress.getHostName();
        } else {
          localObject = ((InetAddress)localObject).getHostAddress();
        }
        i = localInetSocketAddress.getPort();
      }
      else
      {
        paramProxy = new StringBuilder("Proxy.address() is not an InetSocketAddress: ");
        paramProxy.append(localObject.getClass());
        throw new IllegalArgumentException(paramProxy.toString());
      }
    }
    else
    {
      localObject = this.a.a.b;
      i = this.a.a.c;
    }
    if ((i > 0) && (i <= 65535))
    {
      if (paramProxy.type() == Proxy.Type.SOCKS)
      {
        this.g.add(InetSocketAddress.createUnresolved((String)localObject, i));
        return;
      }
      paramProxy = this.a.b.a((String)localObject);
      if (!paramProxy.isEmpty())
      {
        int j = 0;
        int k = paramProxy.size();
        while (j < k)
        {
          localObject = (InetAddress)paramProxy.get(j);
          this.g.add(new InetSocketAddress((InetAddress)localObject, i));
          j += 1;
        }
        return;
      }
      paramProxy = new StringBuilder();
      paramProxy.append(this.a.b);
      paramProxy.append(" returned no addresses for ");
      paramProxy.append((String)localObject);
      throw new UnknownHostException(paramProxy.toString());
    }
    paramProxy = new StringBuilder("No route to ");
    paramProxy.append((String)localObject);
    paramProxy.append(":");
    paramProxy.append(i);
    paramProxy.append("; port is out of range");
    throw new SocketException(paramProxy.toString());
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  public final boolean a()
  {
    return (c()) || (!this.h.isEmpty());
  }
  
  public final a b()
  {
    if (a())
    {
      Object localObject1 = new ArrayList();
      while (c()) {
        if (c())
        {
          Object localObject2 = this.e;
          int i = this.f;
          this.f = (i + 1);
          localObject2 = (Proxy)((List)localObject2).get(i);
          a((Proxy)localObject2);
          i = 0;
          int j = this.g.size();
          while (i < j)
          {
            ait localait = new ait(this.a, (Proxy)localObject2, (InetSocketAddress)this.g.get(i));
            if (this.b.c(localait)) {
              this.h.add(localait);
            } else {
              ((List)localObject1).add(localait);
            }
            i += 1;
          }
          if (!((List)localObject1).isEmpty()) {
            break;
          }
        }
        else
        {
          localObject1 = new StringBuilder("No route to ");
          ((StringBuilder)localObject1).append(this.a.a.b);
          ((StringBuilder)localObject1).append("; exhausted proxy configurations: ");
          ((StringBuilder)localObject1).append(this.e);
          throw new SocketException(((StringBuilder)localObject1).toString());
        }
      }
      if (((List)localObject1).isEmpty())
      {
        ((List)localObject1).addAll(this.h);
        this.h.clear();
      }
      return new a((List)localObject1);
    }
    throw new NoSuchElementException();
  }
  
  public static final class a
  {
    final List<ait> a;
    int b = 0;
    
    a(List<ait> paramList)
    {
      this.a = paramList;
    }
    
    public final boolean a()
    {
      return this.b < this.a.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aji
 * JD-Core Version:    0.7.0.1
 */