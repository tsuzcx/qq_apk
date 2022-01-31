package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.annotation.Nullable;

public final class ax
{
  final a a;
  final Proxy b;
  final InetSocketAddress c;
  
  public ax(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (parama == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.a = parama;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public Proxy b()
  {
    return this.b;
  }
  
  public InetSocketAddress c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.a.i != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ax)) && (((ax)paramObject).a.equals(this.a)) && (((ax)paramObject).b.equals(this.b)) && (((ax)paramObject).c.equals(this.c));
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    return "Route{" + this.c + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ax
 * JD-Core Version:    0.7.0.1
 */