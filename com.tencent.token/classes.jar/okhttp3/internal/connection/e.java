package okhttp3.internal.connection;

import com.tencent.token.fc;
import java.io.IOException;
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
import okhttp3.a;
import okhttp3.ab;
import okhttp3.o;
import okhttp3.p;
import okhttp3.s;

public final class e
{
  private final a a;
  private final d b;
  private final okhttp3.e c;
  private final p d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private final List<ab> h = new ArrayList();
  
  public e(a parama, d paramd, okhttp3.e parame, p paramp)
  {
    this.a = parama;
    this.b = paramd;
    this.c = parame;
    this.d = paramp;
    a(parama.a(), parama.h());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(Proxy paramProxy)
  {
    this.g = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.a.a().f();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i = this.a.a().g(); (i < 1) || (i > 65535); i = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = a(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.g.add(InetSocketAddress.createUnresolved((String)localObject, i));
    }
    for (;;)
    {
      return;
      this.d.a(this.c, (String)localObject);
      paramProxy = this.a.b().a((String)localObject);
      if (paramProxy.isEmpty()) {
        throw new UnknownHostException(this.a.b() + " returned no addresses for " + (String)localObject);
      }
      this.d.a(this.c, (String)localObject, paramProxy);
      int k = paramProxy.size();
      int j = 0;
      while (j < k)
      {
        localObject = (InetAddress)paramProxy.get(j);
        this.g.add(new InetSocketAddress((InetAddress)localObject, i));
        j += 1;
      }
    }
  }
  
  private void a(s params, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.e = Collections.singletonList(paramProxy);
      this.f = 0;
      return;
    }
    params = this.a.g().select(params.a());
    if ((params != null) && (!params.isEmpty())) {}
    for (params = fc.a(params);; params = fc.a(new Proxy[] { Proxy.NO_PROXY }))
    {
      this.e = params;
      break;
    }
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  private Proxy d()
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
    }
    Object localObject = this.e;
    int i = this.f;
    this.f = (i + 1);
    localObject = (Proxy)((List)localObject).get(i);
    a((Proxy)localObject);
    return localObject;
  }
  
  public void a(ab paramab, IOException paramIOException)
  {
    if ((paramab.b().type() != Proxy.Type.DIRECT) && (this.a.g() != null)) {
      this.a.g().connectFailed(this.a.a().a(), paramab.b().address(), paramIOException);
    }
    this.b.a(paramab);
  }
  
  public boolean a()
  {
    return (c()) || (!this.h.isEmpty());
  }
  
  public a b()
  {
    if (!a()) {
      throw new NoSuchElementException();
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (!c()) {
        break;
      }
      Proxy localProxy = d();
      int j = this.g.size();
      int i = 0;
      if (i < j)
      {
        ab localab = new ab(this.a, localProxy, (InetSocketAddress)this.g.get(i));
        if (this.b.c(localab)) {
          this.h.add(localab);
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localab);
        }
      }
    } while (localArrayList.isEmpty());
    if (localArrayList.isEmpty())
    {
      localArrayList.addAll(this.h);
      this.h.clear();
    }
    return new a(localArrayList);
  }
  
  public static final class a
  {
    private final List<ab> a;
    private int b = 0;
    
    a(List<ab> paramList)
    {
      this.a = paramList;
    }
    
    public boolean a()
    {
      return this.b < this.a.size();
    }
    
    public ab b()
    {
      if (!a()) {
        throw new NoSuchElementException();
      }
      List localList = this.a;
      int i = this.b;
      this.b = (i + 1);
      return (ab)localList.get(i);
    }
    
    public List<ab> c()
    {
      return new ArrayList(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.e
 * JD-Core Version:    0.7.0.1
 */