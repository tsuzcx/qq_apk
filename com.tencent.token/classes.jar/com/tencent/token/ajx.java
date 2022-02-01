package com.tencent.token;

import java.util.Arrays;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class ajx
{
  public static final ajx a = new a(true).a(i).a(new akq[] { akq.b }).a().b();
  public static final ajx b = new a(true).a(j).a(new akq[] { akq.b, akq.c, akq.d }).a().b();
  public static final ajx c = new a(b).a(new akq[] { akq.d }).a().b();
  public static final ajx d = new a(false).b();
  private static final ajv[] i = { ajv.aX, ajv.bb, ajv.aY, ajv.bc, ajv.bi, ajv.bh };
  private static final ajv[] j = { ajv.aX, ajv.bb, ajv.aY, ajv.bc, ajv.bi, ajv.bh, ajv.aI, ajv.aJ, ajv.ag, ajv.ah, ajv.E, ajv.I, ajv.i };
  final boolean e;
  public final boolean f;
  @Nullable
  final String[] g;
  @Nullable
  final String[] h;
  
  ajx(a parama)
  {
    this.e = parama.a;
    this.g = parama.b;
    this.h = parama.c;
    this.f = parama.d;
  }
  
  public final boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {
      return false;
    }
    if ((this.h != null) && (!akt.b(akt.h, this.h, paramSSLSocket.getEnabledProtocols()))) {
      return false;
    }
    return (this.g == null) || (akt.b(ajv.a, this.g, paramSSLSocket.getEnabledCipherSuites()));
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ajx)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (ajx)paramObject;
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
  
  public final int hashCode()
  {
    if (this.e) {
      return ((Arrays.hashCode(this.g) + 527) * 31 + Arrays.hashCode(this.h)) * 31 + (this.f ^ true);
    }
    return 17;
  }
  
  public final String toString()
  {
    if (!this.e) {
      return "ConnectionSpec()";
    }
    Object localObject1 = this.g;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (localObject1 != null) {
        localObject1 = ajv.a((String[])localObject1);
      } else {
        localObject1 = null;
      }
      localObject1 = localObject1.toString();
    }
    else
    {
      localObject1 = "[all enabled]";
    }
    Object localObject3 = this.h;
    if (localObject3 != null)
    {
      if (localObject3 != null) {
        localObject2 = akq.a((String[])localObject3);
      }
      localObject2 = localObject2.toString();
    }
    else
    {
      localObject2 = "[all enabled]";
    }
    localObject3 = new StringBuilder("ConnectionSpec(cipherSuites=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", tlsVersions=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(", supportsTlsExtensions=");
    ((StringBuilder)localObject3).append(this.f);
    ((StringBuilder)localObject3).append(")");
    return ((StringBuilder)localObject3).toString();
  }
  
  public static final class a
  {
    boolean a;
    @Nullable
    String[] b;
    @Nullable
    String[] c;
    boolean d;
    
    public a(ajx paramajx)
    {
      this.a = paramajx.e;
      this.b = paramajx.g;
      this.c = paramajx.h;
      this.d = paramajx.f;
    }
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public final a a()
    {
      if (this.a)
      {
        this.d = true;
        return this;
      }
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public final a a(ajv... paramVarArgs)
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
    
    public final a a(akq... paramVarArgs)
    {
      if (this.a)
      {
        String[] arrayOfString = new String[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length)
        {
          arrayOfString[i] = paramVarArgs[i].f;
          i += 1;
        }
        return b(arrayOfString);
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public final a a(String... paramVarArgs)
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
    
    public final a b(String... paramVarArgs)
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
    
    public final ajx b()
    {
      return new ajx(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajx
 * JD-Core Version:    0.7.0.1
 */