package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.a;
import okhttp3.ab;
import okhttp3.b;
import okhttp3.g;
import okhttp3.internal.connection.f;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.z;

public final class fs
  implements t
{
  private final v a;
  private final boolean b;
  private volatile f c;
  private Object d;
  private volatile boolean e;
  
  public fs(v paramv, boolean paramBoolean)
  {
    this.a = paramv;
    this.b = paramBoolean;
  }
  
  private int a(z paramz, int paramInt)
  {
    paramz = paramz.a("Retry-After");
    if (paramz == null) {
      return paramInt;
    }
    if (paramz.matches("\\d+")) {
      return Integer.valueOf(paramz).intValue();
    }
    return 2147483647;
  }
  
  private a a(s params)
  {
    Object localObject2;
    Object localObject1;
    g localg;
    Object localObject3;
    if (params.c())
    {
      localObject2 = this.a.k();
      localObject1 = this.a.l();
      localg = this.a.m();
      localObject3 = localg;
    }
    else
    {
      localg = null;
      localObject1 = localg;
      localObject3 = localObject1;
      localObject2 = localg;
    }
    return new a(params.f(), params.g(), this.a.i(), this.a.j(), (SSLSocketFactory)localObject2, (HostnameVerifier)localObject1, (g)localObject3, this.a.o(), this.a.e(), this.a.u(), this.a.v(), this.a.f());
  }
  
  private x a(z paramz, ab paramab)
  {
    if (paramz != null)
    {
      int i = paramz.b();
      String str = paramz.a().b();
      Proxy localProxy = null;
      switch (i)
      {
      default: 
        return null;
      case 503: 
        if ((paramz.g() != null) && (paramz.g().b() == 503)) {
          return null;
        }
        if (a(paramz, 2147483647) == 0) {
          return paramz.a();
        }
        return null;
      case 408: 
        if (!this.a.s()) {
          return null;
        }
        if ((paramz.a().d() instanceof fu)) {
          return null;
        }
        if ((paramz.g() != null) && (paramz.g().b() == 408)) {
          return null;
        }
        if (a(paramz, 0) > 0) {
          return null;
        }
        return paramz.a();
      case 407: 
        if (paramab != null) {
          localProxy = paramab.b();
        } else {
          localProxy = this.a.e();
        }
        if (localProxy.type() == Proxy.Type.HTTP) {
          return this.a.o().a(paramab, paramz);
        }
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
      case 401: 
        return this.a.n().a(paramab, paramz);
      case 307: 
      case 308: 
        if ((!str.equals("GET")) && (!str.equals("HEAD"))) {
          return null;
        }
        break;
      }
      if (!this.a.r()) {
        return null;
      }
      paramab = paramz.a("Location");
      if (paramab == null) {
        return null;
      }
      s locals = paramz.a().a().c(paramab);
      if (locals == null) {
        return null;
      }
      if ((!locals.b().equals(paramz.a().a().b())) && (!this.a.q())) {
        return null;
      }
      x.a locala = paramz.a().e();
      if (fo.c(str))
      {
        boolean bool = fo.d(str);
        if (fo.e(str))
        {
          locala.a("GET", null);
        }
        else
        {
          paramab = localProxy;
          if (bool) {
            paramab = paramz.a().d();
          }
          locala.a(str, paramab);
        }
        if (!bool)
        {
          locala.b("Transfer-Encoding");
          locala.b("Content-Length");
          locala.b("Content-Type");
        }
      }
      if (!a(paramz, locals)) {
        locala.b("Authorization");
      }
      return locala.a(locals).a();
    }
    throw new IllegalStateException();
  }
  
  private boolean a(IOException paramIOException, f paramf, boolean paramBoolean, x paramx)
  {
    paramf.a(paramIOException);
    if (!this.a.s()) {
      return false;
    }
    if ((paramBoolean) && ((paramx.d() instanceof fu))) {
      return false;
    }
    if (!a(paramIOException, paramBoolean)) {
      return false;
    }
    return paramf.f();
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool1 = paramIOException instanceof ProtocolException;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      bool1 = bool2;
      if ((paramIOException instanceof SocketTimeoutException))
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    return !(paramIOException instanceof SSLPeerUnverifiedException);
  }
  
  private boolean a(z paramz, s params)
  {
    paramz = paramz.a().a();
    return (paramz.f().equals(params.f())) && (paramz.g() == params.g()) && (paramz.b().equals(params.b()));
  }
  
  /* Error */
  public z a(okhttp3.t.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 256 1 0
    //   6: astore 6
    //   8: aload_1
    //   9: checkcast 258	com/tencent/token/fp
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 262	com/tencent/token/fp:h	()Lokhttp3/e;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 265	com/tencent/token/fp:i	()Lokhttp3/p;
    //   26: astore 9
    //   28: new 226	okhttp3/internal/connection/f
    //   31: dup
    //   32: aload_0
    //   33: getfield 22	com/tencent/token/fs:a	Lokhttp3/v;
    //   36: invokevirtual 269	okhttp3/v:p	()Lokhttp3/j;
    //   39: aload_0
    //   40: aload 6
    //   42: invokevirtual 179	okhttp3/x:a	()Lokhttp3/s;
    //   45: invokespecial 271	com/tencent/token/fs:a	(Lokhttp3/s;)Lokhttp3/a;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 273	com/tencent/token/fs:d	Ljava/lang/Object;
    //   56: invokespecial 276	okhttp3/internal/connection/f:<init>	(Lokhttp3/j;Lokhttp3/a;Lokhttp3/e;Lokhttp3/p;Ljava/lang/Object;)V
    //   59: astore 4
    //   61: aload_0
    //   62: aload 4
    //   64: putfield 278	com/tencent/token/fs:c	Lokhttp3/internal/connection/f;
    //   67: aconst_null
    //   68: astore 5
    //   70: iconst_0
    //   71: istore_2
    //   72: aload 6
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 280	com/tencent/token/fs:e	Z
    //   79: ifne +375 -> 454
    //   82: aload 7
    //   84: aload_1
    //   85: aload 4
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 283	com/tencent/token/fp:a	(Lokhttp3/x;Lokhttp3/internal/connection/f;Lcom/tencent/token/fl;Lokhttp3/internal/connection/c;)Lokhttp3/z;
    //   92: astore 6
    //   94: aload 6
    //   96: astore_1
    //   97: aload 5
    //   99: ifnull +27 -> 126
    //   102: aload 6
    //   104: invokevirtual 286	okhttp3/z:f	()Lokhttp3/z$a;
    //   107: aload 5
    //   109: invokevirtual 286	okhttp3/z:f	()Lokhttp3/z$a;
    //   112: aconst_null
    //   113: invokevirtual 291	okhttp3/z$a:a	(Lokhttp3/aa;)Lokhttp3/z$a;
    //   116: invokevirtual 293	okhttp3/z$a:a	()Lokhttp3/z;
    //   119: invokevirtual 296	okhttp3/z$a:c	(Lokhttp3/z;)Lokhttp3/z$a;
    //   122: invokevirtual 293	okhttp3/z$a:a	()Lokhttp3/z;
    //   125: astore_1
    //   126: aload_0
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 299	okhttp3/internal/connection/f:b	()Lokhttp3/ab;
    //   133: invokespecial 301	com/tencent/token/fs:a	(Lokhttp3/z;Lokhttp3/ab;)Lokhttp3/x;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnonnull +17 -> 157
    //   143: aload_0
    //   144: getfield 24	com/tencent/token/fs:b	Z
    //   147: ifne +8 -> 155
    //   150: aload 4
    //   152: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   155: aload_1
    //   156: areturn
    //   157: aload_1
    //   158: invokevirtual 306	okhttp3/z:e	()Lokhttp3/aa;
    //   161: invokestatic 311	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   164: iload_2
    //   165: iconst_1
    //   166: iadd
    //   167: istore_2
    //   168: iload_2
    //   169: bipush 20
    //   171: if_icmpgt +158 -> 329
    //   174: aload 6
    //   176: invokevirtual 130	okhttp3/x:d	()Lokhttp3/y;
    //   179: instanceof 132
    //   182: ifne +127 -> 309
    //   185: aload_0
    //   186: aload_1
    //   187: aload 6
    //   189: invokevirtual 179	okhttp3/x:a	()Lokhttp3/s;
    //   192: invokespecial 214	com/tencent/token/fs:a	(Lokhttp3/z;Lokhttp3/s;)Z
    //   195: ifne +50 -> 245
    //   198: aload 4
    //   200: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   203: new 226	okhttp3/internal/connection/f
    //   206: dup
    //   207: aload_0
    //   208: getfield 22	com/tencent/token/fs:a	Lokhttp3/v;
    //   211: invokevirtual 269	okhttp3/v:p	()Lokhttp3/j;
    //   214: aload_0
    //   215: aload 6
    //   217: invokevirtual 179	okhttp3/x:a	()Lokhttp3/s;
    //   220: invokespecial 271	com/tencent/token/fs:a	(Lokhttp3/s;)Lokhttp3/a;
    //   223: aload 8
    //   225: aload 9
    //   227: aload_0
    //   228: getfield 273	com/tencent/token/fs:d	Ljava/lang/Object;
    //   231: invokespecial 276	okhttp3/internal/connection/f:<init>	(Lokhttp3/j;Lokhttp3/a;Lokhttp3/e;Lokhttp3/p;Ljava/lang/Object;)V
    //   234: astore 4
    //   236: aload_0
    //   237: aload 4
    //   239: putfield 278	com/tencent/token/fs:c	Lokhttp3/internal/connection/f;
    //   242: goto +11 -> 253
    //   245: aload 4
    //   247: invokevirtual 314	okhttp3/internal/connection/f:a	()Lcom/tencent/token/fl;
    //   250: ifnonnull +12 -> 262
    //   253: aload_1
    //   254: astore 5
    //   256: aload 6
    //   258: astore_1
    //   259: goto -184 -> 75
    //   262: new 316	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   269: astore 4
    //   271: aload 4
    //   273: ldc_w 319
    //   276: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 4
    //   282: aload_1
    //   283: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: ldc_w 328
    //   292: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: new 222	java/lang/IllegalStateException
    //   299: dup
    //   300: aload 4
    //   302: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokespecial 332	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   308: athrow
    //   309: aload 4
    //   311: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   314: new 334	java/net/HttpRetryException
    //   317: dup
    //   318: ldc_w 336
    //   321: aload_1
    //   322: invokevirtual 112	okhttp3/z:b	()I
    //   325: invokespecial 339	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   328: athrow
    //   329: aload 4
    //   331: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   334: new 316	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   341: astore_1
    //   342: aload_1
    //   343: ldc_w 341
    //   346: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_1
    //   351: iload_2
    //   352: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: new 155	java/net/ProtocolException
    //   359: dup
    //   360: aload_1
    //   361: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokespecial 160	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   367: athrow
    //   368: astore_1
    //   369: aload 4
    //   371: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   374: aload_1
    //   375: athrow
    //   376: astore_1
    //   377: goto +64 -> 441
    //   380: astore 6
    //   382: aload 6
    //   384: instanceof 346
    //   387: ifne +83 -> 470
    //   390: iconst_1
    //   391: istore_3
    //   392: goto +3 -> 395
    //   395: aload_0
    //   396: aload 6
    //   398: aload 4
    //   400: iload_3
    //   401: aload_1
    //   402: invokespecial 348	com/tencent/token/fs:a	(Ljava/io/IOException;Lokhttp3/internal/connection/f;ZLokhttp3/x;)Z
    //   405: ifeq +6 -> 411
    //   408: goto -333 -> 75
    //   411: aload 6
    //   413: athrow
    //   414: astore 6
    //   416: aload_0
    //   417: aload 6
    //   419: invokevirtual 351	okhttp3/internal/connection/RouteException:b	()Ljava/io/IOException;
    //   422: aload 4
    //   424: iconst_0
    //   425: aload_1
    //   426: invokespecial 348	com/tencent/token/fs:a	(Ljava/io/IOException;Lokhttp3/internal/connection/f;ZLokhttp3/x;)Z
    //   429: ifeq +6 -> 435
    //   432: goto -357 -> 75
    //   435: aload 6
    //   437: invokevirtual 353	okhttp3/internal/connection/RouteException:a	()Ljava/io/IOException;
    //   440: athrow
    //   441: aload 4
    //   443: aconst_null
    //   444: invokevirtual 229	okhttp3/internal/connection/f:a	(Ljava/io/IOException;)V
    //   447: aload 4
    //   449: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   452: aload_1
    //   453: athrow
    //   454: aload 4
    //   456: invokevirtual 303	okhttp3/internal/connection/f:d	()V
    //   459: new 242	java/io/IOException
    //   462: dup
    //   463: ldc_w 355
    //   466: invokespecial 356	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   469: athrow
    //   470: iconst_0
    //   471: istore_3
    //   472: goto -77 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	fs
    //   0	475	1	parama	okhttp3.t.a
    //   71	281	2	i	int
    //   391	81	3	bool	boolean
    //   59	396	4	localObject1	Object
    //   68	187	5	locala	okhttp3.t.a
    //   6	251	6	localObject2	Object
    //   380	32	6	localIOException	IOException
    //   414	22	6	localRouteException	okhttp3.internal.connection.RouteException
    //   12	71	7	localfp	fp
    //   19	205	8	locale	okhttp3.e
    //   26	200	9	localp	okhttp3.p
    // Exception table:
    //   from	to	target	type
    //   126	138	368	java/io/IOException
    //   82	94	376	finally
    //   382	390	376	finally
    //   395	408	376	finally
    //   411	414	376	finally
    //   416	432	376	finally
    //   435	441	376	finally
    //   82	94	380	java/io/IOException
    //   82	94	414	okhttp3/internal/connection/RouteException
  }
  
  public void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public boolean a()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fs
 * JD-Core Version:    0.7.0.1
 */