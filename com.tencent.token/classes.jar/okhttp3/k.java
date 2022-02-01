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
    if (this.g != null) {
      arrayOfString1 = fc.a(h.a, paramSSLSocket.getEnabledCipherSuites(), this.g);
    } else {
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    }
    String[] arrayOfString2;
    if (this.h != null) {
      arrayOfString2 = fc.a(fc.h, paramSSLSocket.getEnabledProtocols(), this.h);
    } else {
      arrayOfString2 = paramSSLSocket.getEnabledProtocols();
    }
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
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Object localObject = b(paramSSLSocket, paramBoolean);
    String[] arrayOfString = ((k)localObject).h;
    if (arrayOfString != null) {
      paramSSLSocket.setEnabledProtocols(arrayOfString);
    }
    localObject = ((k)localObject).g;
    if (localObject != null) {
      paramSSLSocket.setEnabledCipherSuites((String[])localObject);
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {
      return false;
    }
    if ((this.h != null) && (!fc.b(fc.h, this.h, paramSSLSocket.getEnabledProtocols()))) {
      return false;
    }
    return (this.g == null) || (fc.b(h.a, this.g, paramSSLSocket.getEnabledCipherSuites()));
  }
  
  @Nullable
  public List<h> b()
  {
    String[] arrayOfString = this.g;
    if (arrayOfString != null) {
      return h.a(arrayOfString);
    }
    return null;
  }
  
  @Nullable
  public List<TlsVersion> c()
  {
    String[] arrayOfString = this.h;
    if (arrayOfString != null) {
      return TlsVersion.a(arrayOfString);
    }
    return null;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof k)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (k)paramObject;
    boolean bool = this.e;
    if (bool != paramObject.e) {
      return false;
    }
    if (bool)
    {
      if (!Arrays.equals(this.g, paramObject.g)) {
        return false;
      }
      if (!Arrays.equals(this.h, paramObject.h)) {
        return false;
      }
      if (this.f != paramObject.f) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.e) {
      return ((527 + Arrays.hashCode(this.g)) * 31 + Arrays.hashCode(this.h)) * 31 + (this.f ^ true);
    }
    return 17;
  }
  
  public String toString()
  {
    if (!this.e) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.g != null) {
      str1 = b().toString();
    } else {
      str1 = "[all enabled]";
    }
    String str2;
    if (this.h != null) {
      str2 = c().toString();
    } else {
      str2 = "[all enabled]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionSpec(cipherSuites=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", tlsVersions=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", supportsTlsExtensions=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
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
      if (this.a)
      {
        this.d = paramBoolean;
        return this;
      }
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public a a(String... paramVarArgs)
    {
      if (this.a)
      {
        if (paramVarArgs.length != 0)
        {
          this.b = ((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public a a(TlsVersion... paramVarArgs)
    {
      if (this.a)
      {
        String[] arrayOfString = new String[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length)
        {
          arrayOfString[i] = paramVarArgs[i].javaName;
          i += 1;
        }
        return b(arrayOfString);
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public a a(h... paramVarArgs)
    {
      if (this.a)
      {
        String[] arrayOfString = new String[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length)
        {
          arrayOfString[i] = paramVarArgs[i].bk;
          i += 1;
        }
        return a(arrayOfString);
      }
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public k a()
    {
      return new k(this);
    }
    
    public a b(String... paramVarArgs)
    {
      if (this.a)
      {
        if (paramVarArgs.length != 0)
        {
          this.c = ((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.k
 * JD-Core Version:    0.7.0.1
 */