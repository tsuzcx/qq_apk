package com.tencent.token;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.annotation.Nullable;

public final class ais
{
  public final ahr a;
  public final Proxy b;
  public final InetSocketAddress c;
  
  public ais(ahr paramahr, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramahr != null)
    {
      if (paramProxy != null)
      {
        if (paramInetSocketAddress != null)
        {
          this.a = paramahr;
          this.b = paramProxy;
          this.c = paramInetSocketAddress;
          return;
        }
        throw new NullPointerException("inetSocketAddress == null");
      }
      throw new NullPointerException("proxy == null");
    }
    throw new NullPointerException("address == null");
  }
  
  public final boolean a()
  {
    return (this.a.i != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ais))
    {
      paramObject = (ais)paramObject;
      if ((paramObject.a.equals(this.a)) && (paramObject.b.equals(this.b)) && (paramObject.c.equals(this.c))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Route{");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ais
 * JD-Core Version:    0.7.0.1
 */