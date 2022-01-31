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
import okhttp3.af;
import okhttp3.ah;
import okhttp3.ak;
import okhttp3.ap;
import okhttp3.aq;
import okhttp3.at;
import okhttp3.ax;
import okhttp3.b;
import okhttp3.i;
import okhttp3.internal.connection.g;

public final class hl
  implements ah
{
  private final ak a;
  private final boolean b;
  private volatile g c;
  private Object d;
  private volatile boolean e;
  
  public hl(ak paramak, boolean paramBoolean)
  {
    this.a = paramak;
    this.b = paramBoolean;
  }
  
  private int a(at paramat, int paramInt)
  {
    paramat = paramat.a("Retry-After");
    if (paramat == null) {
      return paramInt;
    }
    if (paramat.matches("\\d+")) {
      return Integer.valueOf(paramat).intValue();
    }
    return 2147483647;
  }
  
  private a a(af paramaf)
  {
    i locali = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramaf.c())
    {
      localSSLSocketFactory = this.a.k();
      localHostnameVerifier = this.a.l();
      locali = this.a.m();
    }
    for (;;)
    {
      return new a(paramaf.f(), paramaf.g(), this.a.i(), this.a.j(), localSSLSocketFactory, localHostnameVerifier, locali, this.a.o(), this.a.e(), this.a.u(), this.a.v(), this.a.f());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private ap a(at paramat, ax paramax)
  {
    Proxy localProxy = null;
    if (paramat == null) {
      throw new IllegalStateException();
    }
    int i = paramat.b();
    String str = paramat.a().b();
    switch (i)
    {
    }
    label384:
    do
    {
      do
      {
        af localaf;
        do
        {
          do
          {
            do
            {
              return null;
              if (paramax != null) {}
              for (localProxy = paramax.b(); localProxy.type() != Proxy.Type.HTTP; localProxy = this.a.e()) {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
              }
              return this.a.o().a(paramax, paramat);
              return this.a.n().a(paramax, paramat);
            } while (((!str.equals("GET")) && (!str.equals("HEAD"))) || (!this.a.r()));
            paramax = paramat.a("Location");
          } while (paramax == null);
          localaf = paramat.a().a().c(paramax);
        } while ((localaf == null) || ((!localaf.b().equals(paramat.a().a().b())) && (!this.a.q())));
        aq localaq = paramat.a().e();
        boolean bool;
        if (hh.c(str))
        {
          bool = hh.d(str);
          if (!hh.e(str)) {
            break label384;
          }
          localaq.a("GET", null);
        }
        for (;;)
        {
          if (!bool)
          {
            localaq.b("Transfer-Encoding");
            localaq.b("Content-Length");
            localaq.b("Content-Type");
          }
          if (!a(paramat, localaf)) {
            localaq.b("Authorization");
          }
          return localaq.a(localaf).a();
          paramax = localProxy;
          if (bool) {
            paramax = paramat.a().d();
          }
          localaq.a(str, paramax);
        }
      } while ((!this.a.s()) || ((paramat.a().d() instanceof hn)) || ((paramat.g() != null) && (paramat.g().b() == 408)) || (a(paramat, 0) > 0));
      return paramat.a();
    } while (((paramat.g() != null) && (paramat.g().b() == 503)) || (a(paramat, 2147483647) != 0));
    return paramat.a();
  }
  
  private boolean a(IOException paramIOException, g paramg, boolean paramBoolean, ap paramap)
  {
    paramg.a(paramIOException);
    if (!this.a.s()) {}
    while (((paramBoolean) && ((paramap.d() instanceof hn))) || (!a(paramIOException, paramBoolean)) || (!paramg.f())) {
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
  
  private boolean a(at paramat, af paramaf)
  {
    paramat = paramat.a().a();
    return (paramat.f().equals(paramaf.f())) && (paramat.g() == paramaf.g()) && (paramat.b().equals(paramaf.b()));
  }
  
  /* Error */
  public at a(okhttp3.ai paramai)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 256 1 0
    //   6: astore 4
    //   8: aload_1
    //   9: checkcast 258	com/tencent/token/hi
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 262	com/tencent/token/hi:h	()Lokhttp3/g;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 265	com/tencent/token/hi:i	()Lokhttp3/y;
    //   26: astore 9
    //   28: new 226	okhttp3/internal/connection/g
    //   31: dup
    //   32: aload_0
    //   33: getfield 22	com/tencent/token/hl:a	Lokhttp3/ak;
    //   36: invokevirtual 269	okhttp3/ak:p	()Lokhttp3/o;
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 169	okhttp3/ap:a	()Lokhttp3/af;
    //   45: invokespecial 271	com/tencent/token/hl:a	(Lokhttp3/af;)Lokhttp3/a;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 273	com/tencent/token/hl:d	Ljava/lang/Object;
    //   56: invokespecial 276	okhttp3/internal/connection/g:<init>	(Lokhttp3/o;Lokhttp3/a;Lokhttp3/g;Lokhttp3/y;Ljava/lang/Object;)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 278	com/tencent/token/hl:c	Lokhttp3/internal/connection/g;
    //   65: iconst_0
    //   66: istore_2
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 280	com/tencent/token/hl:e	Z
    //   74: ifeq +18 -> 92
    //   77: aload_1
    //   78: invokevirtual 282	okhttp3/internal/connection/g:d	()V
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
    //   99: invokevirtual 288	com/tencent/token/hi:a	(Lokhttp3/ap;Lokhttp3/internal/connection/g;Lcom/tencent/token/hd;Lokhttp3/internal/connection/c;)Lokhttp3/at;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +28 -> 138
    //   113: aload 6
    //   115: invokevirtual 291	okhttp3/at:f	()Lokhttp3/au;
    //   118: aload 5
    //   120: invokevirtual 291	okhttp3/at:f	()Lokhttp3/au;
    //   123: aconst_null
    //   124: invokevirtual 296	okhttp3/au:a	(Lokhttp3/av;)Lokhttp3/au;
    //   127: invokevirtual 298	okhttp3/au:a	()Lokhttp3/at;
    //   130: invokevirtual 301	okhttp3/au:c	(Lokhttp3/at;)Lokhttp3/au;
    //   133: invokevirtual 298	okhttp3/au:a	()Lokhttp3/at;
    //   136: astore 4
    //   138: aload_0
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 304	okhttp3/internal/connection/g:b	()Lokhttp3/ax;
    //   145: invokespecial 306	com/tencent/token/hl:a	(Lokhttp3/at;Lokhttp3/ax;)Lokhttp3/ap;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnonnull +97 -> 249
    //   155: aload_0
    //   156: getfield 24	com/tencent/token/hl:b	Z
    //   159: ifne +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 282	okhttp3/internal/connection/g:d	()V
    //   166: aload 4
    //   168: areturn
    //   169: astore 6
    //   171: aload_0
    //   172: aload 6
    //   174: invokevirtual 309	okhttp3/internal/connection/RouteException:b	()Ljava/io/IOException;
    //   177: aload_1
    //   178: iconst_0
    //   179: aload 4
    //   181: invokespecial 311	com/tencent/token/hl:a	(Ljava/io/IOException;Lokhttp3/internal/connection/g;ZLokhttp3/ap;)Z
    //   184: ifne -114 -> 70
    //   187: aload 6
    //   189: invokevirtual 313	okhttp3/internal/connection/RouteException:a	()Ljava/io/IOException;
    //   192: athrow
    //   193: astore 4
    //   195: aload_1
    //   196: aconst_null
    //   197: invokevirtual 229	okhttp3/internal/connection/g:a	(Ljava/io/IOException;)V
    //   200: aload_1
    //   201: invokevirtual 282	okhttp3/internal/connection/g:d	()V
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
    //   226: invokespecial 311	com/tencent/token/hl:a	(Ljava/io/IOException;Lokhttp3/internal/connection/g;ZLokhttp3/ap;)Z
    //   229: ifne -159 -> 70
    //   232: aload 6
    //   234: athrow
    //   235: iconst_0
    //   236: istore_3
    //   237: goto -18 -> 219
    //   240: astore 4
    //   242: aload_1
    //   243: invokevirtual 282	okhttp3/internal/connection/g:d	()V
    //   246: aload 4
    //   248: athrow
    //   249: aload 4
    //   251: invokevirtual 318	okhttp3/at:e	()Lokhttp3/av;
    //   254: invokestatic 323	com/tencent/token/gn:a	(Ljava/io/Closeable;)V
    //   257: iload_2
    //   258: iconst_1
    //   259: iadd
    //   260: istore_2
    //   261: iload_2
    //   262: bipush 20
    //   264: if_icmple +35 -> 299
    //   267: aload_1
    //   268: invokevirtual 282	okhttp3/internal/connection/g:d	()V
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
    //   301: invokevirtual 213	okhttp3/ap:d	()Lokhttp3/ar;
    //   304: instanceof 218
    //   307: ifeq +23 -> 330
    //   310: aload_1
    //   311: invokevirtual 282	okhttp3/internal/connection/g:d	()V
    //   314: new 340	java/net/HttpRetryException
    //   317: dup
    //   318: ldc_w 342
    //   321: aload 4
    //   323: invokevirtual 115	okhttp3/at:b	()I
    //   326: invokespecial 345	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   329: athrow
    //   330: aload_0
    //   331: aload 4
    //   333: aload 6
    //   335: invokevirtual 169	okhttp3/ap:a	()Lokhttp3/af;
    //   338: invokespecial 204	com/tencent/token/hl:a	(Lokhttp3/at;Lokhttp3/af;)Z
    //   341: ifne +55 -> 396
    //   344: aload_1
    //   345: invokevirtual 282	okhttp3/internal/connection/g:d	()V
    //   348: new 226	okhttp3/internal/connection/g
    //   351: dup
    //   352: aload_0
    //   353: getfield 22	com/tencent/token/hl:a	Lokhttp3/ak;
    //   356: invokevirtual 269	okhttp3/ak:p	()Lokhttp3/o;
    //   359: aload_0
    //   360: aload 6
    //   362: invokevirtual 169	okhttp3/ap:a	()Lokhttp3/af;
    //   365: invokespecial 271	com/tencent/token/hl:a	(Lokhttp3/af;)Lokhttp3/a;
    //   368: aload 8
    //   370: aload 9
    //   372: aload_0
    //   373: getfield 273	com/tencent/token/hl:d	Ljava/lang/Object;
    //   376: invokespecial 276	okhttp3/internal/connection/g:<init>	(Lokhttp3/o;Lokhttp3/a;Lokhttp3/g;Lokhttp3/y;Ljava/lang/Object;)V
    //   379: astore_1
    //   380: aload_0
    //   381: aload_1
    //   382: putfield 278	com/tencent/token/hl:c	Lokhttp3/internal/connection/g;
    //   385: aload 4
    //   387: astore 5
    //   389: aload 6
    //   391: astore 4
    //   393: goto -323 -> 70
    //   396: aload_1
    //   397: invokevirtual 348	okhttp3/internal/connection/g:a	()Lcom/tencent/token/hd;
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
    //   0	441	0	this	hl
    //   0	441	1	paramai	okhttp3.ai
    //   66	223	2	i	int
    //   218	19	3	bool	boolean
    //   6	174	4	localObject1	Object
    //   193	32	4	localap	ap
    //   240	146	4	localIOException1	IOException
    //   391	30	4	localObject2	Object
    //   68	320	5	localIOException2	IOException
    //   102	49	6	localObject3	Object
    //   169	19	6	localRouteException	okhttp3.internal.connection.RouteException
    //   207	183	6	localIOException3	IOException
    //   12	81	7	localhi	hi
    //   19	350	8	localg	okhttp3.g
    //   26	345	9	localy	okhttp3.y
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
 * Qualified Name:     com.tencent.token.hl
 * JD-Core Version:    0.7.0.1
 */