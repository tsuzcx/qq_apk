package com.tencent.token;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class aje
{
  boolean a;
  boolean b;
  private final List<aib> c;
  private int d = 0;
  
  public aje(List<aib> paramList)
  {
    this.c = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.d;
    while (i < this.c.size())
    {
      if (((aib)this.c.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final aib a(SSLSocket paramSSLSocket)
  {
    int i = this.d;
    int j = this.c.size();
    while (i < j)
    {
      localObject = (aib)this.c.get(i);
      if (((aib)localObject).a(paramSSLSocket))
      {
        this.d = (i + 1);
        break label64;
      }
      i += 1;
    }
    Object localObject = null;
    label64:
    if (localObject != null)
    {
      this.a = b(paramSSLSocket);
      aiv.a.a((aib)localObject, paramSSLSocket, this.b);
      return localObject;
    }
    localObject = new StringBuilder("Unable to find acceptable protocols. isFallback=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", modes=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", supported protocols=");
    ((StringBuilder)localObject).append(Arrays.toString(paramSSLSocket.getEnabledProtocols()));
    throw new UnknownServiceException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aje
 * JD-Core Version:    0.7.0.1
 */