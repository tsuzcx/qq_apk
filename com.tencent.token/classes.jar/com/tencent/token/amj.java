package com.tencent.token;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public final class amj
  extends amn
{
  public static amn a()
  {
    try
    {
      Class.forName("org.conscrypt.ConscryptEngineSocket");
      if (!Conscrypt.isAvailable()) {
        return null;
      }
      amj localamj = new amj();
      return localamj;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  @Nullable
  public final String a(SSLSocket paramSSLSocket)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.a(paramSSLSocket);
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<akj> paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])amn.a(paramList).toArray(new String[0]));
      return;
    }
    super.a(paramSSLSocket, paramString, paramList);
  }
  
  public final void a(SSLSocketFactory paramSSLSocketFactory)
  {
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
  }
  
  public final SSLContext b()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS", new OpenSSLProvider());
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amj
 * JD-Core Version:    0.7.0.1
 */