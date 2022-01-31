package com.tencent.token;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public class ic
  extends ih
{
  public static ih a()
  {
    try
    {
      Class.forName("org.conscrypt.ConscryptEngineSocket");
      if (!Conscrypt.isAvailable()) {
        return null;
      }
      ic localic = new ic();
      return localic;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private Provider e()
  {
    return new OpenSSLProvider();
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.a(paramSSLSocket);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])ih.a(paramList).toArray(new String[0]));
      return;
    }
    super.a(paramSSLSocket, paramString, paramList);
  }
  
  public void a(SSLSocketFactory paramSSLSocketFactory)
  {
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
  }
  
  public SSLContext b()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS", e());
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ic
 * JD-Core Version:    0.7.0.1
 */