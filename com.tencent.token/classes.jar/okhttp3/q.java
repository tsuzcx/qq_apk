package okhttp3;

import com.tencent.token.gn;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class q
{
  public static final q a = new r(true).a(i).a(new TlsVersion[] { TlsVersion.TLS_1_2 }).a(true).a();
  public static final q b = new r(true).a(j).a(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).a(true).a();
  public static final q c = new r(b).a(new TlsVersion[] { TlsVersion.TLS_1_0 }).a(true).a();
  public static final q d = new r(false).a();
  private static final l[] i = { l.aX, l.bb, l.aY, l.bc, l.bi, l.bh };
  private static final l[] j = { l.aX, l.bb, l.aY, l.bc, l.bi, l.bh, l.aI, l.aJ, l.ag, l.ah, l.E, l.I, l.i };
  final boolean e;
  final boolean f;
  @Nullable
  final String[] g;
  @Nullable
  final String[] h;
  
  q(r paramr)
  {
    this.e = paramr.a;
    this.g = paramr.b;
    this.h = paramr.c;
    this.f = paramr.d;
  }
  
  private q b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.g != null)
    {
      arrayOfString1 = gn.a(l.a, paramSSLSocket.getEnabledCipherSuites(), this.g);
      if (this.h == null) {
        break label118;
      }
    }
    label118:
    for (String[] arrayOfString2 = gn.a(gn.h, paramSSLSocket.getEnabledProtocols(), this.h);; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
      int k = gn.a(l.a, arrayOfString3, "TLS_FALLBACK_SCSV");
      paramSSLSocket = arrayOfString1;
      if (paramBoolean)
      {
        paramSSLSocket = arrayOfString1;
        if (k != -1) {
          paramSSLSocket = gn.a(arrayOfString1, arrayOfString3[k]);
        }
      }
      return new r(this).a(paramSSLSocket).b(arrayOfString2).a();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    q localq = b(paramSSLSocket, paramBoolean);
    if (localq.h != null) {
      paramSSLSocket.setEnabledProtocols(localq.h);
    }
    if (localq.g != null) {
      paramSSLSocket.setEnabledCipherSuites(localq.g);
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {}
    while (((this.h != null) && (!gn.b(gn.h, this.h, paramSSLSocket.getEnabledProtocols()))) || ((this.g != null) && (!gn.b(l.a, this.g, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  @Nullable
  public List b()
  {
    if (this.g != null) {
      return l.a(this.g);
    }
    return null;
  }
  
  @Nullable
  public List c()
  {
    if (this.h != null) {
      return TlsVersion.a(this.h);
    }
    return null;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof q)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (q)paramObject;
    } while ((this.e != paramObject.e) || ((this.e) && ((!Arrays.equals(this.g, paramObject.g)) || (!Arrays.equals(this.h, paramObject.h)) || (this.f != paramObject.f))));
    return true;
  }
  
  public int hashCode()
  {
    int k = 17;
    int m;
    int n;
    if (this.e)
    {
      m = Arrays.hashCode(this.g);
      n = Arrays.hashCode(this.h);
      if (!this.f) {
        break label53;
      }
    }
    label53:
    for (k = 0;; k = 1)
    {
      k += ((m + 527) * 31 + n) * 31;
      return k;
    }
  }
  
  public String toString()
  {
    if (!this.e) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.g != null)
    {
      str1 = b().toString();
      if (this.h == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = c().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f + ")";
      str1 = "[all enabled]";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.q
 * JD-Core Version:    0.7.0.1
 */