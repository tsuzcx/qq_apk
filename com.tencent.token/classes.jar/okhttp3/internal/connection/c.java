package okhttp3.internal.connection;

import com.tencent.token.ez;
import com.tencent.token.fb;
import com.tencent.token.fc;
import com.tencent.token.fk;
import com.tencent.token.fm;
import com.tencent.token.fu;
import com.tencent.token.gb;
import com.tencent.token.gg;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Protocol;
import okhttp3.a;
import okhttp3.ab;
import okhttp3.i;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.e.a;
import okhttp3.internal.http2.e.b;
import okhttp3.j;
import okhttp3.k;
import okhttp3.p;
import okhttp3.s;
import okhttp3.t.a;
import okhttp3.v;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.z;
import okhttp3.z.a;
import okio.r;

public final class c
  extends e.b
  implements i
{
  public boolean a;
  public int b;
  public int c = 1;
  public final List<Reference<f>> d = new ArrayList();
  public long e = 9223372036854775807L;
  private final j g;
  private final ab h;
  private Socket i;
  private Socket j;
  private okhttp3.q k;
  private Protocol l;
  private okhttp3.internal.http2.e m;
  private okio.e n;
  private okio.d o;
  
  public c(j paramj, ab paramab)
  {
    this.g = paramj;
    this.h = paramab;
  }
  
  private x a(int paramInt1, int paramInt2, x paramx, s params)
  {
    String str = "CONNECT " + fb.a(params, true) + " HTTP/1.1";
    z localz;
    do
    {
      params = new fu(null, null, this.n, this.o);
      this.n.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.o.a().a(paramInt2, TimeUnit.MILLISECONDS);
      params.a(paramx.c(), str);
      params.b();
      localz = params.a(false).a(paramx).a();
      long l2 = fm.a(localz);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramx = params.b(l1);
      fb.b(paramx, 2147483647, TimeUnit.MILLISECONDS);
      paramx.close();
      switch (localz.b())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localz.b());
      case 200: 
        if ((!this.n.c().e()) || (!this.o.c().e())) {
          throw new IOException("TLS tunnel buffered too many bytes!");
        }
        return null;
      }
      params = this.h.a().d().a(this.h, localz);
      if (params == null) {
        throw new IOException("Failed to authenticate with proxy");
      }
      paramx = params;
    } while (!"close".equalsIgnoreCase(localz.a("Connection")));
    return params;
  }
  
  private void a(int paramInt)
  {
    this.j.setSoTimeout(0);
    this.m = new e.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(paramInt).a();
    this.m.c();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, okhttp3.e parame, p paramp)
  {
    x localx = e();
    s locals = localx.a();
    int i1 = 0;
    for (;;)
    {
      if (i1 < 21)
      {
        a(paramInt1, paramInt2, parame, paramp);
        localx = a(paramInt2, paramInt3, localx, locals);
        if (localx != null) {}
      }
      else
      {
        return;
      }
      fb.a(this.i);
      this.i = null;
      this.o = null;
      this.n = null;
      paramp.a(parame, this.h.c(), this.h.b(), null);
      i1 += 1;
    }
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, okhttp3.e parame, p paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   4: invokevirtual 258	okhttp3/ab:b	()Ljava/net/Proxy;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   13: invokevirtual 174	okhttp3/ab:a	()Lokhttp3/a;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 273	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 279	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +14 -> 40
    //   29: aload 6
    //   31: invokevirtual 273	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 282	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +89 -> 126
    //   40: aload 5
    //   42: invokevirtual 285	okhttp3/a:c	()Ljavax/net/SocketFactory;
    //   45: invokevirtual 291	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   48: astore 5
    //   50: aload_0
    //   51: aload 5
    //   53: putfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   56: aload 4
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   63: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   66: aload 6
    //   68: invokevirtual 294	okhttp3/p:a	(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   71: aload_0
    //   72: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   75: iload_2
    //   76: invokevirtual 206	java/net/Socket:setSoTimeout	(I)V
    //   79: invokestatic 299	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
    //   82: aload_0
    //   83: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   86: aload_0
    //   87: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   90: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   93: iload_1
    //   94: invokevirtual 302	com/tencent/token/gb:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   102: invokestatic 307	okio/k:b	(Ljava/net/Socket;)Lokio/q;
    //   105: invokestatic 310	okio/k:a	(Lokio/q;)Lokio/e;
    //   108: putfield 79	okhttp3/internal/connection/c:n	Lokio/e;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   116: invokestatic 313	okio/k:a	(Ljava/net/Socket;)Lokio/p;
    //   119: invokestatic 316	okio/k:a	(Lokio/p;)Lokio/d;
    //   122: putfield 81	okhttp3/internal/connection/c:o	Lokio/d;
    //   125: return
    //   126: new 203	java/net/Socket
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 319	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   135: astore 5
    //   137: goto -87 -> 50
    //   140: astore_3
    //   141: new 265	java/net/ConnectException
    //   144: dup
    //   145: new 57	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 321
    //   155: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   162: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   165: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 325	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload 4
    //   178: aload_3
    //   179: invokevirtual 329	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   182: pop
    //   183: aload 4
    //   185: athrow
    //   186: astore_3
    //   187: ldc_w 331
    //   190: aload_3
    //   191: invokevirtual 334	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq -72 -> 125
    //   200: new 150	java/io/IOException
    //   203: dup
    //   204: aload_3
    //   205: invokespecial 341	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	c
    //   0	209	1	paramInt1	int
    //   0	209	2	paramInt2	int
    //   0	209	3	parame	okhttp3.e
    //   0	209	4	paramp	p
    //   16	120	5	localObject	Object
    //   7	124	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   79	97	140	java/net/ConnectException
    //   97	125	186	java/lang/NullPointerException
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   12: invokevirtual 174	okhttp3/ab:a	()Lokhttp3/a;
    //   15: astore 6
    //   17: aload 6
    //   19: invokevirtual 347	okhttp3/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   28: aload 6
    //   30: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   33: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   36: aload 6
    //   38: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   41: invokevirtual 349	okhttp3/s:g	()I
    //   44: iconst_1
    //   45: invokevirtual 354	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   48: checkcast 356	javax/net/ssl/SSLSocket
    //   51: astore_3
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 361	okhttp3/internal/connection/b:a	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/k;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 365	okhttp3/k:d	()Z
    //   64: ifeq +23 -> 87
    //   67: invokestatic 299	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   76: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 368	okhttp3/a:e	()Ljava/util/List;
    //   84: invokevirtual 371	com/tencent/token/gb:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   87: aload_3
    //   88: invokevirtual 374	javax/net/ssl/SSLSocket:startHandshake	()V
    //   91: aload_3
    //   92: invokevirtual 378	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 383	okhttp3/q:a	(Ljavax/net/ssl/SSLSession;)Lokhttp3/q;
    //   100: astore_2
    //   101: aload 6
    //   103: invokevirtual 386	okhttp3/a:j	()Ljavax/net/ssl/HostnameVerifier;
    //   106: aload 6
    //   108: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   111: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   114: aload_1
    //   115: invokeinterface 392 3 0
    //   120: ifne +139 -> 259
    //   123: aload_2
    //   124: invokevirtual 394	okhttp3/q:b	()Ljava/util/List;
    //   127: iconst_0
    //   128: invokeinterface 400 2 0
    //   133: checkcast 402	java/security/cert/X509Certificate
    //   136: astore_1
    //   137: new 404	javax/net/ssl/SSLPeerUnverifiedException
    //   140: dup
    //   141: new 57	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 406
    //   151: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 6
    //   156: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   159: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   162: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 408
    //   168: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokestatic 413	okhttp3/g:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   175: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 415
    //   181: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 419	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   188: invokeinterface 424 1 0
    //   193: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 426
    //   199: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokestatic 431	com/tencent/token/gg:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   206: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 432	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   215: athrow
    //   216: astore_2
    //   217: aload_3
    //   218: astore_1
    //   219: aload_2
    //   220: astore_3
    //   221: aload_1
    //   222: astore_2
    //   223: aload_3
    //   224: invokestatic 435	com/tencent/token/fb:a	(Ljava/lang/AssertionError;)Z
    //   227: ifeq +142 -> 369
    //   230: aload_1
    //   231: astore_2
    //   232: new 150	java/io/IOException
    //   235: dup
    //   236: aload_3
    //   237: invokespecial 341	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   240: athrow
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +10 -> 253
    //   246: invokestatic 299	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
    //   249: aload_2
    //   250: invokevirtual 438	com/tencent/token/gb:b	(Ljavax/net/ssl/SSLSocket;)V
    //   253: aload_2
    //   254: invokestatic 252	com/tencent/token/fb:a	(Ljava/net/Socket;)V
    //   257: aload_1
    //   258: athrow
    //   259: aload 6
    //   261: invokevirtual 441	okhttp3/a:k	()Lokhttp3/g;
    //   264: aload 6
    //   266: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   269: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   272: aload_2
    //   273: invokevirtual 394	okhttp3/q:b	()Ljava/util/List;
    //   276: invokevirtual 444	okhttp3/g:a	(Ljava/lang/String;Ljava/util/List;)V
    //   279: aload 4
    //   281: astore_1
    //   282: aload 5
    //   284: invokevirtual 365	okhttp3/k:d	()Z
    //   287: ifeq +11 -> 298
    //   290: invokestatic 299	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
    //   293: aload_3
    //   294: invokevirtual 447	com/tencent/token/gb:a	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   297: astore_1
    //   298: aload_0
    //   299: aload_3
    //   300: putfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   303: aload_0
    //   304: aload_0
    //   305: getfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   308: invokestatic 307	okio/k:b	(Ljava/net/Socket;)Lokio/q;
    //   311: invokestatic 310	okio/k:a	(Lokio/q;)Lokio/e;
    //   314: putfield 79	okhttp3/internal/connection/c:n	Lokio/e;
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   322: invokestatic 313	okio/k:a	(Ljava/net/Socket;)Lokio/p;
    //   325: invokestatic 316	okio/k:a	(Lokio/p;)Lokio/d;
    //   328: putfield 81	okhttp3/internal/connection/c:o	Lokio/d;
    //   331: aload_0
    //   332: aload_2
    //   333: putfield 449	okhttp3/internal/connection/c:k	Lokhttp3/q;
    //   336: aload_1
    //   337: ifnull +25 -> 362
    //   340: aload_1
    //   341: invokestatic 454	okhttp3/Protocol:a	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   344: astore_1
    //   345: aload_0
    //   346: aload_1
    //   347: putfield 456	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   350: aload_3
    //   351: ifnull +10 -> 361
    //   354: invokestatic 299	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
    //   357: aload_3
    //   358: invokevirtual 438	com/tencent/token/gb:b	(Ljavax/net/ssl/SSLSocket;)V
    //   361: return
    //   362: getstatic 459	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   365: astore_1
    //   366: goto -21 -> 345
    //   369: aload_1
    //   370: astore_2
    //   371: aload_3
    //   372: athrow
    //   373: astore_1
    //   374: aload_3
    //   375: astore_2
    //   376: goto -134 -> 242
    //   379: astore_3
    //   380: aload 5
    //   382: astore_1
    //   383: goto -162 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	c
    //   0	386	1	paramb	b
    //   1	123	2	localq	okhttp3.q
    //   216	4	2	localAssertionError1	java.lang.AssertionError
    //   222	154	2	localObject1	Object
    //   22	353	3	localObject2	Object
    //   379	1	3	localAssertionError2	java.lang.AssertionError
    //   3	277	4	localObject3	Object
    //   6	375	5	localk	k
    //   15	250	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   52	87	216	java/lang/AssertionError
    //   87	216	216	java/lang/AssertionError
    //   259	279	216	java/lang/AssertionError
    //   282	298	216	java/lang/AssertionError
    //   298	336	216	java/lang/AssertionError
    //   340	345	216	java/lang/AssertionError
    //   345	350	216	java/lang/AssertionError
    //   362	366	216	java/lang/AssertionError
    //   23	52	241	finally
    //   223	230	241	finally
    //   232	241	241	finally
    //   371	373	241	finally
    //   52	87	373	finally
    //   87	216	373	finally
    //   259	279	373	finally
    //   282	298	373	finally
    //   298	336	373	finally
    //   340	345	373	finally
    //   345	350	373	finally
    //   362	366	373	finally
    //   23	52	379	java/lang/AssertionError
  }
  
  private void a(b paramb, int paramInt, okhttp3.e parame, p paramp)
  {
    if (this.h.a().i() == null) {
      if (this.h.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE))
      {
        this.j = this.i;
        this.l = Protocol.H2_PRIOR_KNOWLEDGE;
        a(paramInt);
      }
    }
    do
    {
      return;
      this.j = this.i;
      this.l = Protocol.HTTP_1_1;
      return;
      paramp.b(parame);
      a(paramb);
      paramp.a(parame, this.k);
    } while (this.l != Protocol.HTTP_2);
    a(paramInt);
  }
  
  private x e()
  {
    return new x.a().a(this.h.a().a()).a("Host", fb.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", fc.a()).a();
  }
  
  public fk a(v paramv, t.a parama, f paramf)
  {
    if (this.m != null) {
      return new okhttp3.internal.http2.d(paramv, parama, paramf, this.m);
    }
    this.j.setSoTimeout(parama.c());
    this.n.a().a(parama.c(), TimeUnit.MILLISECONDS);
    this.o.a().a(parama.d(), TimeUnit.MILLISECONDS);
    return new fu(paramv, paramf, this.n, this.o);
  }
  
  public ab a()
  {
    return this.h;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, okhttp3.e arg6, p paramp)
  {
    if (this.l != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject = this.h.a().f();
    b localb = new b((List)localObject);
    if (this.h.a().i() == null)
    {
      if (!((List)localObject).contains(k.d)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      }
      localObject = this.h.a().a().f();
      if (!gb.c().b((String)localObject)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + (String)localObject + " not permitted by network security policy"));
      }
    }
    label272:
    label473:
    for (localObject = null;; localObject = null)
    {
      try
      {
        for (;;)
        {
          if (this.h.d())
          {
            a(paramInt1, paramInt2, paramInt3, ???, paramp);
            Socket localSocket = this.i;
            if (localSocket != null) {
              break label272;
            }
          }
          while ((this.h.d()) && (this.i == null))
          {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
            if (!this.h.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
              break label473;
            }
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            a(paramInt1, paramInt2, ???, paramp);
            a(localb, paramInt4, ???, paramp);
            paramp.a(???, this.h.c(), this.h.b(), this.l);
          }
        }
      }
      catch (IOException localIOException)
      {
        fb.a(this.j);
        fb.a(this.i);
        this.j = null;
        this.i = null;
        this.n = null;
        this.o = null;
        this.k = null;
        this.l = null;
        this.m = null;
        paramp.a(???, this.h.c(), this.h.b(), null, localIOException);
        if (localObject == null) {
          localObject = new RouteException(localIOException);
        }
        while ((!paramBoolean) || (!localb.a(localIOException)))
        {
          throw ((Throwable)localObject);
          ((RouteException)localObject).a(localIOException);
        }
      }
      if (this.m == null) {
        break;
      }
      synchronized (this.g)
      {
        this.c = this.m.a();
        return;
      }
    }
  }
  
  public void a(okhttp3.internal.http2.e parame)
  {
    synchronized (this.g)
    {
      this.c = parame.a();
      return;
    }
  }
  
  public void a(okhttp3.internal.http2.g paramg)
  {
    paramg.a(ErrorCode.REFUSED_STREAM);
  }
  
  public boolean a(a parama, @Nullable ab paramab)
  {
    if ((this.d.size() >= this.c) || (this.a)) {}
    do
    {
      do
      {
        return false;
      } while (!ez.a.a(this.h.a(), parama));
      if (parama.a().f().equals(a().a().a().f())) {
        return true;
      }
    } while ((this.m == null) || (paramab == null) || (paramab.b().type() != Proxy.Type.DIRECT) || (this.h.b().type() != Proxy.Type.DIRECT) || (!this.h.c().equals(paramab.c())) || (paramab.a().j() != gg.a) || (!a(parama.a())));
    try
    {
      parama.k().a(parama.a().f(), c().b());
      return true;
    }
    catch (SSLPeerUnverifiedException parama) {}
    return false;
  }
  
  public boolean a(s params)
  {
    if (params.g() != this.h.a().a().g()) {
      return false;
    }
    if (!params.f().equals(this.h.a().a().f()))
    {
      if ((this.k != null) && (gg.a.a(params.f(), (X509Certificate)this.k.b().get(0)))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.j.isClosed()) || (this.j.isInputShutdown()) || (this.j.isOutputShutdown())) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.m == null) {
          break;
        }
      } while (!this.m.d());
      return false;
    } while (!paramBoolean);
    try
    {
      int i1 = this.j.getSoTimeout();
      try
      {
        this.j.setSoTimeout(1);
        paramBoolean = this.n.e();
        return !paramBoolean;
      }
      finally
      {
        this.j.setSoTimeout(i1);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public Socket b()
  {
    return this.j;
  }
  
  public okhttp3.q c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    return this.m != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.h.a().a().f()).append(":").append(this.h.a().a().g()).append(", proxy=").append(this.h.b()).append(" hostAddress=").append(this.h.c()).append(" cipherSuite=");
    if (this.k != null) {}
    for (Object localObject = this.k.a();; localObject = "none") {
      return localObject + " protocol=" + this.l + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.c
 * JD-Core Version:    0.7.0.1
 */