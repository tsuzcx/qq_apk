package okhttp3.internal.connection;

import com.tencent.token.gl;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.q;

public final class b
{
  private final List a;
  private int b = 0;
  private boolean c;
  private boolean d;
  
  public b(List paramList)
  {
    this.a = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    while (i < this.a.size())
    {
      if (((q)this.a.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public q a(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    int j = this.a.size();
    q localq;
    if (i < j)
    {
      localq = (q)this.a.get(i);
      if (localq.a(paramSSLSocket)) {
        this.b = (i + 1);
      }
    }
    for (;;)
    {
      if (localq == null)
      {
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        i += 1;
        break;
      }
      this.c = b(paramSSLSocket);
      gl.a.a(localq, paramSSLSocket, this.d);
      return localq;
      localq = null;
    }
  }
  
  public boolean a(IOException paramIOException)
  {
    this.d = true;
    if (!this.c) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException)))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.b
 * JD-Core Version:    0.7.0.1
 */