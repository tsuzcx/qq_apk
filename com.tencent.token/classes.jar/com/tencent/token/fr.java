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

public final class fr
  implements t
{
  private final v a;
  private final boolean b;
  private volatile f c;
  private Object d;
  private volatile boolean e;
  
  public fr(v paramv, boolean paramBoolean)
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
    g localg = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (params.c())
    {
      localSSLSocketFactory = this.a.k();
      localHostnameVerifier = this.a.l();
      localg = this.a.m();
    }
    for (;;)
    {
      return new a(params.f(), params.g(), this.a.i(), this.a.j(), localSSLSocketFactory, localHostnameVerifier, localg, this.a.o(), this.a.e(), this.a.u(), this.a.v(), this.a.f());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private x a(z paramz, ab paramab)
  {
    Proxy localProxy = null;
    if (paramz == null) {
      throw new IllegalStateException();
    }
    int i = paramz.b();
    String str = paramz.a().b();
    switch (i)
    {
    }
    label384:
    do
    {
      do
      {
        s locals;
        do
        {
          do
          {
            do
            {
              return null;
              if (paramab != null) {}
              for (localProxy = paramab.b(); localProxy.type() != Proxy.Type.HTTP; localProxy = this.a.e()) {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
              }
              return this.a.o().a(paramab, paramz);
              return this.a.n().a(paramab, paramz);
            } while (((!str.equals("GET")) && (!str.equals("HEAD"))) || (!this.a.r()));
            paramab = paramz.a("Location");
          } while (paramab == null);
          locals = paramz.a().a().c(paramab);
        } while ((locals == null) || ((!locals.b().equals(paramz.a().a().b())) && (!this.a.q())));
        x.a locala = paramz.a().e();
        boolean bool;
        if (fn.c(str))
        {
          bool = fn.d(str);
          if (!fn.e(str)) {
            break label384;
          }
          locala.a("GET", null);
        }
        for (;;)
        {
          if (!bool)
          {
            locala.b("Transfer-Encoding");
            locala.b("Content-Length");
            locala.b("Content-Type");
          }
          if (!a(paramz, locals)) {
            locala.b("Authorization");
          }
          return locala.a(locals).a();
          paramab = localProxy;
          if (bool) {
            paramab = paramz.a().d();
          }
          locala.a(str, paramab);
        }
      } while ((!this.a.s()) || ((paramz.a().d() instanceof ft)) || ((paramz.g() != null) && (paramz.g().b() == 408)) || (a(paramz, 0) > 0));
      return paramz.a();
    } while (((paramz.g() != null) && (paramz.g().b() == 503)) || (a(paramz, 2147483647) != 0));
    return paramz.a();
  }
  
  private boolean a(IOException paramIOException, f paramf, boolean paramBoolean, x paramx)
  {
    paramf.a(paramIOException);
    if (!this.a.s()) {}
    while (((paramBoolean) && ((paramx.d() instanceof ft))) || (!a(paramIOException, paramBoolean)) || (!paramf.f())) {
      return false;
    }
    return true;
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException))
      {
        if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean)) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    } while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
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
    //   6: astore 4
    //   8: aload_1
    //   9: checkcast 258	com/tencent/token/fo
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 262	com/tencent/token/fo:h	()Lokhttp3/e;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 265	com/tencent/token/fo:i	()Lokhttp3/p;
    //   26: astore 9
    //   28: new 226	okhttp3/internal/connection/f
    //   31: dup
    //   32: aload_0
    //   33: getfield 22	com/tencent/token/fr:a	Lokhttp3/v;
    //   36: invokevirtual 269	okhttp3/v:p	()Lokhttp3/j;
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 169	okhttp3/x:a	()Lokhttp3/s;
    //   45: invokespecial 271	com/tencent/token/fr:a	(Lokhttp3/s;)Lokhttp3/a;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 273	com/tencent/token/fr:d	Ljava/lang/Object;
    //   56: invokespecial 276	okhttp3/internal/connection/f:<init>	(Lokhttp3/j;Lokhttp3/a;Lokhttp3/e;Lokhttp3/p;Ljava/lang/Object;)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 278	com/tencent/token/fr:c	Lokhttp3/internal/connection/f;
    //   65: iconst_0
    //   66: istore_2
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 280	com/tencent/token/fr:e	Z
    //   74: ifeq +18 -> 92
    //   77: aload_1
    //   78: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   81: new 242	java/io/IOException
    //   84: dup
    //   85: ldc_w 284
    //   88: invokespecial 285	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: aload 7
    //   94: aload 4
    //   96: aload_1
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 288	com/tencent/token/fo:a	(Lokhttp3/x;Lokhttp3/internal/connection/f;Lcom/tencent/token/fk;Lokhttp3/internal/connection/c;)Lokhttp3/z;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +28 -> 138
    //   113: aload 6
    //   115: invokevirtual 291	okhttp3/z:f	()Lokhttp3/z$a;
    //   118: aload 5
    //   120: invokevirtual 291	okhttp3/z:f	()Lokhttp3/z$a;
    //   123: aconst_null
    //   124: invokevirtual 296	okhttp3/z$a:a	(Lokhttp3/aa;)Lokhttp3/z$a;
    //   127: invokevirtual 298	okhttp3/z$a:a	()Lokhttp3/z;
    //   130: invokevirtual 301	okhttp3/z$a:c	(Lokhttp3/z;)Lokhttp3/z$a;
    //   133: invokevirtual 298	okhttp3/z$a:a	()Lokhttp3/z;
    //   136: astore 4
    //   138: aload_0
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 304	okhttp3/internal/connection/f:b	()Lokhttp3/ab;
    //   145: invokespecial 306	com/tencent/token/fr:a	(Lokhttp3/z;Lokhttp3/ab;)Lokhttp3/x;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnonnull +97 -> 249
    //   155: aload_0
    //   156: getfield 24	com/tencent/token/fr:b	Z
    //   159: ifne +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   166: aload 4
    //   168: areturn
    //   169: astore 6
    //   171: aload_0
    //   172: aload 6
    //   174: invokevirtual 309	okhttp3/internal/connection/RouteException:b	()Ljava/io/IOException;
    //   177: aload_1
    //   178: iconst_0
    //   179: aload 4
    //   181: invokespecial 311	com/tencent/token/fr:a	(Ljava/io/IOException;Lokhttp3/internal/connection/f;ZLokhttp3/x;)Z
    //   184: ifne -114 -> 70
    //   187: aload 6
    //   189: invokevirtual 313	okhttp3/internal/connection/RouteException:a	()Ljava/io/IOException;
    //   192: athrow
    //   193: astore 4
    //   195: aload_1
    //   196: aconst_null
    //   197: invokevirtual 229	okhttp3/internal/connection/f:a	(Ljava/io/IOException;)V
    //   200: aload_1
    //   201: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   204: aload 4
    //   206: athrow
    //   207: astore 6
    //   209: aload 6
    //   211: instanceof 315
    //   214: ifne +21 -> 235
    //   217: iconst_1
    //   218: istore_3
    //   219: aload_0
    //   220: aload 6
    //   222: aload_1
    //   223: iload_3
    //   224: aload 4
    //   226: invokespecial 311	com/tencent/token/fr:a	(Ljava/io/IOException;Lokhttp3/internal/connection/f;ZLokhttp3/x;)Z
    //   229: ifne -159 -> 70
    //   232: aload 6
    //   234: athrow
    //   235: iconst_0
    //   236: istore_3
    //   237: goto -18 -> 219
    //   240: astore 4
    //   242: aload_1
    //   243: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   246: aload 4
    //   248: athrow
    //   249: aload 4
    //   251: invokevirtual 318	okhttp3/z:e	()Lokhttp3/aa;
    //   254: invokestatic 323	com/tencent/token/fb:a	(Ljava/io/Closeable;)V
    //   257: iload_2
    //   258: iconst_1
    //   259: iadd
    //   260: istore_2
    //   261: iload_2
    //   262: bipush 20
    //   264: if_icmple +35 -> 299
    //   267: aload_1
    //   268: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   271: new 140	java/net/ProtocolException
    //   274: dup
    //   275: new 325	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 328
    //   285: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_2
    //   289: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokespecial 145	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   298: athrow
    //   299: aload 6
    //   301: invokevirtual 213	okhttp3/x:d	()Lokhttp3/y;
    //   304: instanceof 218
    //   307: ifeq +23 -> 330
    //   310: aload_1
    //   311: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   314: new 340	java/net/HttpRetryException
    //   317: dup
    //   318: ldc_w 342
    //   321: aload 4
    //   323: invokevirtual 115	okhttp3/z:b	()I
    //   326: invokespecial 345	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   329: athrow
    //   330: aload_0
    //   331: aload 4
    //   333: aload 6
    //   335: invokevirtual 169	okhttp3/x:a	()Lokhttp3/s;
    //   338: invokespecial 204	com/tencent/token/fr:a	(Lokhttp3/z;Lokhttp3/s;)Z
    //   341: ifne +55 -> 396
    //   344: aload_1
    //   345: invokevirtual 282	okhttp3/internal/connection/f:d	()V
    //   348: new 226	okhttp3/internal/connection/f
    //   351: dup
    //   352: aload_0
    //   353: getfield 22	com/tencent/token/fr:a	Lokhttp3/v;
    //   356: invokevirtual 269	okhttp3/v:p	()Lokhttp3/j;
    //   359: aload_0
    //   360: aload 6
    //   362: invokevirtual 169	okhttp3/x:a	()Lokhttp3/s;
    //   365: invokespecial 271	com/tencent/token/fr:a	(Lokhttp3/s;)Lokhttp3/a;
    //   368: aload 8
    //   370: aload 9
    //   372: aload_0
    //   373: getfield 273	com/tencent/token/fr:d	Ljava/lang/Object;
    //   376: invokespecial 276	okhttp3/internal/connection/f:<init>	(Lokhttp3/j;Lokhttp3/a;Lokhttp3/e;Lokhttp3/p;Ljava/lang/Object;)V
    //   379: astore_1
    //   380: aload_0
    //   381: aload_1
    //   382: putfield 278	com/tencent/token/fr:c	Lokhttp3/internal/connection/f;
    //   385: aload 4
    //   387: astore 5
    //   389: aload 6
    //   391: astore 4
    //   393: goto -323 -> 70
    //   396: aload_1
    //   397: invokevirtual 348	okhttp3/internal/connection/f:a	()Lcom/tencent/token/fk;
    //   400: ifnull +38 -> 438
    //   403: new 112	java/lang/IllegalStateException
    //   406: dup
    //   407: new 325	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 350
    //   417: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 4
    //   422: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   425: ldc_w 355
    //   428: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokespecial 356	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   437: athrow
    //   438: goto -53 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	fr
    //   0	441	1	parama	okhttp3.t.a
    //   66	223	2	i	int
    //   218	19	3	bool	boolean
    //   6	174	4	localObject1	Object
    //   193	32	4	localx	x
    //   240	146	4	localIOException1	IOException
    //   391	30	4	localObject2	Object
    //   68	320	5	localIOException2	IOException
    //   102	49	6	localObject3	Object
    //   169	19	6	localRouteException	okhttp3.internal.connection.RouteException
    //   207	183	6	localIOException3	IOException
    //   12	81	7	localfo	fo
    //   19	350	8	locale	okhttp3.e
    //   26	345	9	localp	okhttp3.p
    // Exception table:
    //   from	to	target	type
    //   92	104	169	okhttp3/internal/connection/RouteException
    //   92	104	193	finally
    //   171	193	193	finally
    //   209	217	193	finally
    //   219	235	193	finally
    //   92	104	207	java/io/IOException
    //   138	150	240	java/io/IOException
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
 * Qualified Name:     com.tencent.token.fr
 * JD-Core Version:    0.7.0.1
 */