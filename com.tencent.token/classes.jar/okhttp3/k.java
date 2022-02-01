package okhttp3;

import com.tencent.token.fc;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class k
{
  public static final k a = new a(true).a(i).a(new TlsVersion[] { TlsVersion.TLS_1_2 }).a(true).a();
  public static final k b = new a(true).a(j).a(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).a(true).a();
  public static final k c = new a(b).a(new TlsVersion[] { TlsVersion.TLS_1_0 }).a(true).a();
  public static final k d = new a(false).a();
  private static final h[] i = { h.aX, h.bb, h.aY, h.bc, h.bi, h.bh };
  private static final h[] j = { h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.aI, h.aJ, h.ag, h.ah, h.E, h.I, h.i };
  final boolean e;
  final boolean f;
  @Nullable
  final String[] g;
  @Nullable
  final String[] h;
  
  k(a parama)
  {
    this.e = parama.a;
    this.g = parama.b;
    this.h = parama.c;
    this.f = parama.d;
  }
  
  private k b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.g != null)
    {
      arrayOfString1 = fc.a(h.a, paramSSLSocket.getEnabledCipherSuites(), this.g);
      if (this.h == null) {
        break label118;
      }
    }
    label118:
    for (String[] arrayOfString2 = fc.a(fc.h, paramSSLSocket.getEnabledProtocols(), this.h);; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
      int k = fc.a(h.a, arrayOfString3, "TLS_FALLBACK_SCSV");
      paramSSLSocket = arrayOfString1;
      if (paramBoolean)
      {
        paramSSLSocket = arrayOfString1;
        if (k != -1) {
          paramSSLSocket = fc.a(arrayOfString1, arrayOfString3[k]);
        }
      }
      return new a(this).a(paramSSLSocket).b(arrayOfString2).a();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    k localk = b(paramSSLSocket, paramBoolean);
    if (localk.h != null) {
      paramSSLSocket.setEnabledProtocols(localk.h);
    }
    if (localk.g != null) {
      paramSSLSocket.setEnabledCipherSuites(localk.g);
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {}
    while (((this.h != null) && (!fc.b(fc.h, this.h, paramSSLSocket.getEnabledProtocols()))) || ((this.g != null) && (!fc.b(h.a, this.g, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  @Nullable
  public List<h> b()
  {
    if (this.g != null) {
      return h.a(this.g);
    }
    return null;
  }
  
  @Nullable
  public List<TlsVersion> c()
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
    if (!(paramObject instanceof k)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (k)paramObject;
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
  
  public static final class a
  {
    boolean a;
    @Nullable
    String[] b;
    @Nullable
    String[] c;
    boolean d;
    
    public a(k paramk)
    {
      this.a = paramk.e;
      this.b = paramk.g;
      this.c = paramk.h;
      this.d = paramk.f;
    }
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public a a(boolean paramBoolean)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      this.d = paramBoolean;
      return this;
    }
    
    public a a(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      this.b = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public a a(TlsVersion... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].javaName;
        i += 1;
      }
      return b(arrayOfString);
    }
    
    public a a(h... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].bk;
        i += 1;
      }
      return a(arrayOfString);
    }
    
    public k a()
    {
      return new k(this);
    }
    
    public a b(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      this.c = ((String[])paramVarArgs.clone());
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.k
 * JD-Core Version:    0.7.0.1
 */