package okhttp3.internal.connection;

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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector
{
  private final Address address;
  private final Call call;
  private final EventListener eventListener;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase, Call paramCall, EventListener paramEventListener)
  {
    this.address = paramAddress;
    this.routeDatabase = paramRouteDatabase;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    resetNextProxy(paramAddress.url(), paramAddress.proxy());
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextProxy()
  {
    return this.nextProxyIndex < this.proxies.size();
  }
  
  private Proxy nextProxy()
    throws IOException
  {
    if (!hasNextProxy()) {
      throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }
    Object localObject = this.proxies;
    int i = this.nextProxyIndex;
    this.nextProxyIndex = (i + 1);
    localObject = (Proxy)((List)localObject).get(i);
    resetNextInetSocketAddress((Proxy)localObject);
    return localObject;
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws IOException
  {
    this.inetSocketAddresses = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.address.url().host();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i = this.address.url().port(); (i < 1) || (i > 65535); i = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = getHostString(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.inetSocketAddresses.add(InetSocketAddress.createUnresolved((String)localObject, i));
    }
    for (;;)
    {
      return;
      this.eventListener.dnsStart(this.call, (String)localObject);
      paramProxy = this.address.dns().lookup((String)localObject);
      if (paramProxy.isEmpty()) {
        throw new UnknownHostException(this.address.dns() + " returned no addresses for " + (String)localObject);
      }
      this.eventListener.dnsEnd(this.call, (String)localObject, paramProxy);
      int k = paramProxy.size();
      int j = 0;
      while (j < k)
      {
        localObject = (InetAddress)paramProxy.get(j);
        this.inetSocketAddresses.add(new InetSocketAddress((InetAddress)localObject, i));
        j += 1;
      }
    }
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.proxies = Collections.singletonList(paramProxy);
      this.nextProxyIndex = 0;
      return;
    }
    paramHttpUrl = this.address.proxySelector().select(paramHttpUrl.uri());
    if ((paramHttpUrl != null) && (!paramHttpUrl.isEmpty())) {}
    for (paramHttpUrl = Util.immutableList(paramHttpUrl);; paramHttpUrl = Util.immutableList(new Proxy[] { Proxy.NO_PROXY }))
    {
      this.proxies = paramHttpUrl;
      break;
    }
  }
  
  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.proxy().type() != Proxy.Type.DIRECT) && (this.address.proxySelector() != null)) {
      this.address.proxySelector().connectFailed(this.address.url().uri(), paramRoute.proxy().address(), paramIOException);
    }
    this.routeDatabase.failed(paramRoute);
  }
  
  public boolean hasNext()
  {
    return (hasNextProxy()) || (!this.postponedRoutes.isEmpty());
  }
  
  public Selection next()
    throws IOException
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (!hasNextProxy()) {
        break;
      }
      Proxy localProxy = nextProxy();
      int j = this.inetSocketAddresses.size();
      int i = 0;
      if (i < j)
      {
        Route localRoute = new Route(this.address, localProxy, (InetSocketAddress)this.inetSocketAddresses.get(i));
        if (this.routeDatabase.shouldPostpone(localRoute)) {
          this.postponedRoutes.add(localRoute);
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localRoute);
        }
      }
    } while (localArrayList.isEmpty());
    if (localArrayList.isEmpty())
    {
      localArrayList.addAll(this.postponedRoutes);
      this.postponedRoutes.clear();
    }
    return new Selection(localArrayList);
  }
  
  public static final class Selection
  {
    private int nextRouteIndex = 0;
    private final List<Route> routes;
    
    Selection(List<Route> paramList)
    {
      this.routes = paramList;
    }
    
    public List<Route> getAll()
    {
      return new ArrayList(this.routes);
    }
    
    public boolean hasNext()
    {
      return this.nextRouteIndex < this.routes.size();
    }
    
    public Route next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      List localList = this.routes;
      int i = this.nextRouteIndex;
      this.nextRouteIndex = (i + 1);
      return (Route)localList.get(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.connection.RouteSelector
 * JD-Core Version:    0.7.0.1
 */