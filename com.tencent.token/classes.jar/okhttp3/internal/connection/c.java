package okhttp3.internal.connection;

import com.tencent.token.gl;
import com.tencent.token.gn;
import com.tencent.token.gq;
import com.tencent.token.hd;
import com.tencent.token.hg;
import com.tencent.token.ho;
import com.tencent.token.ih;
import com.tencent.token.im;
import java.io.IOException;
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
import okhttp3.ac;
import okhttp3.af;
import okhttp3.ai;
import okhttp3.ak;
import okhttp3.ap;
import okhttp3.aq;
import okhttp3.at;
import okhttp3.au;
import okhttp3.ax;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.p;
import okhttp3.n;
import okhttp3.q;

public final class c
  extends p
  implements n
{
  public boolean a;
  public int b;
  public int c = 1;
  public final List d = new ArrayList();
  public long e = 9223372036854775807L;
  private final okhttp3.o g;
  private final ax h;
  private Socket i;
  private Socket j;
  private ac k;
  private Protocol l;
  private okhttp3.internal.http2.h m;
  private okio.i n;
  private okio.h o;
  
  public c(okhttp3.o paramo, ax paramax)
  {
    this.g = paramo;
    this.h = paramax;
  }
  
  private ap a(int paramInt1, int paramInt2, ap paramap, af paramaf)
  {
    String str = "CONNECT " + gn.a(paramaf, true) + " HTTP/1.1";
    at localat;
    do
    {
      paramaf = new ho(null, null, this.n, this.o);
      this.n.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.o.a().a(paramInt2, TimeUnit.MILLISECONDS);
      paramaf.a(paramap.c(), str);
      paramaf.b();
      localat = paramaf.a(false).a(paramap).a();
      long l2 = hg.a(localat);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramap = paramaf.b(l1);
      gn.b(paramap, 2147483647, TimeUnit.MILLISECONDS);
      paramap.close();
      switch (localat.b())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localat.b());
      case 200: 
        if ((!this.n.c().e()) || (!this.o.c().e())) {
          throw new IOException("TLS tunnel buffered too many bytes!");
        }
        return null;
      }
      paramaf = this.h.a().d().a(this.h, localat);
      if (paramaf == null) {
        throw new IOException("Failed to authenticate with proxy");
      }
      paramap = paramaf;
    } while (!"close".equalsIgnoreCase(localat.a("Connection")));
    return paramaf;
  }
  
  private void a(int paramInt)
  {
    this.j.setSoTimeout(0);
    this.m = new okhttp3.internal.http2.o(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(paramInt).a();
    this.m.c();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, okhttp3.g paramg, okhttp3.y paramy)
  {
    ap localap = e();
    af localaf = localap.a();
    int i1 = 0;
    for (;;)
    {
      if (i1 < 21)
      {
        a(paramInt1, paramInt2, paramg, paramy);
        localap = a(paramInt2, paramInt3, localap, localaf);
        if (localap != null) {}
      }
      else
      {
        return;
      }
      gn.a(this.i);
      this.i = null;
      this.o = null;
      this.n = null;
      paramy.a(paramg, this.h.c(), this.h.b(), null);
      i1 += 1;
    }
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, okhttp3.g paramg, okhttp3.y paramy)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   4: invokevirtual 257	okhttp3/ax:b	()Ljava/net/Proxy;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   13: invokevirtual 173	okhttp3/ax:a	()Lokhttp3/a;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 272	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 278	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +14 -> 40
    //   29: aload 6
    //   31: invokevirtual 272	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 281	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +89 -> 126
    //   40: aload 5
    //   42: invokevirtual 284	okhttp3/a:c	()Ljavax/net/SocketFactory;
    //   45: invokevirtual 290	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   48: astore 5
    //   50: aload_0
    //   51: aload 5
    //   53: putfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   56: aload 4
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   63: invokevirtual 254	okhttp3/ax:c	()Ljava/net/InetSocketAddress;
    //   66: aload 6
    //   68: invokevirtual 293	okhttp3/y:a	(Lokhttp3/g;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   71: aload_0
    //   72: getfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   75: iload_2
    //   76: invokevirtual 205	java/net/Socket:setSoTimeout	(I)V
    //   79: invokestatic 298	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   82: aload_0
    //   83: getfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   86: aload_0
    //   87: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   90: invokevirtual 254	okhttp3/ax:c	()Ljava/net/InetSocketAddress;
    //   93: iload_1
    //   94: invokevirtual 301	com/tencent/token/ih:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   102: invokestatic 306	okio/o:b	(Ljava/net/Socket;)Lokio/y;
    //   105: invokestatic 309	okio/o:a	(Lokio/y;)Lokio/i;
    //   108: putfield 78	okhttp3/internal/connection/c:n	Lokio/i;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   116: invokestatic 312	okio/o:a	(Ljava/net/Socket;)Lokio/x;
    //   119: invokestatic 315	okio/o:a	(Lokio/x;)Lokio/h;
    //   122: putfield 80	okhttp3/internal/connection/c:o	Lokio/h;
    //   125: return
    //   126: new 202	java/net/Socket
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 318	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   135: astore 5
    //   137: goto -87 -> 50
    //   140: astore_3
    //   141: new 264	java/net/ConnectException
    //   144: dup
    //   145: new 56	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 320
    //   155: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   162: invokevirtual 254	okhttp3/ax:c	()Ljava/net/InetSocketAddress;
    //   165: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 324	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload 4
    //   178: aload_3
    //   179: invokevirtual 328	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   182: pop
    //   183: aload 4
    //   185: athrow
    //   186: astore_3
    //   187: ldc_w 330
    //   190: aload_3
    //   191: invokevirtual 333	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 337	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq -72 -> 125
    //   200: new 149	java/io/IOException
    //   203: dup
    //   204: aload_3
    //   205: invokespecial 340	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	c
    //   0	209	1	paramInt1	int
    //   0	209	2	paramInt2	int
    //   0	209	3	paramg	okhttp3.g
    //   0	209	4	paramy	okhttp3.y
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
    //   9: getfield 52	okhttp3/internal/connection/c:h	Lokhttp3/ax;
    //   12: invokevirtual 173	okhttp3/ax:a	()Lokhttp3/a;
    //   15: astore 6
    //   17: aload 6
    //   19: invokevirtual 346	okhttp3/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: getfield 248	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   28: aload 6
    //   30: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   33: invokevirtual 218	okhttp3/af:f	()Ljava/lang/String;
    //   36: aload 6
    //   38: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   41: invokevirtual 348	okhttp3/af:g	()I
    //   44: iconst_1
    //   45: invokevirtual 353	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   48: checkcast 355	javax/net/ssl/SSLSocket
    //   51: astore_3
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 360	okhttp3/internal/connection/b:a	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/q;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 364	okhttp3/q:d	()Z
    //   64: ifeq +23 -> 87
    //   67: invokestatic 298	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   76: invokevirtual 218	okhttp3/af:f	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 367	okhttp3/a:e	()Ljava/util/List;
    //   84: invokevirtual 370	com/tencent/token/ih:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   87: aload_3
    //   88: invokevirtual 373	javax/net/ssl/SSLSocket:startHandshake	()V
    //   91: aload_3
    //   92: invokevirtual 377	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 382	okhttp3/ac:a	(Ljavax/net/ssl/SSLSession;)Lokhttp3/ac;
    //   100: astore_2
    //   101: aload 6
    //   103: invokevirtual 385	okhttp3/a:j	()Ljavax/net/ssl/HostnameVerifier;
    //   106: aload 6
    //   108: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   111: invokevirtual 218	okhttp3/af:f	()Ljava/lang/String;
    //   114: aload_1
    //   115: invokeinterface 391 3 0
    //   120: ifne +139 -> 259
    //   123: aload_2
    //   124: invokevirtual 393	okhttp3/ac:b	()Ljava/util/List;
    //   127: iconst_0
    //   128: invokeinterface 399 2 0
    //   133: checkcast 401	java/security/cert/X509Certificate
    //   136: astore_1
    //   137: new 403	javax/net/ssl/SSLPeerUnverifiedException
    //   140: dup
    //   141: new 56	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 405
    //   151: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 6
    //   156: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   159: invokevirtual 218	okhttp3/af:f	()Ljava/lang/String;
    //   162: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 407
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokestatic 412	okhttp3/i:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   175: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 414
    //   181: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 418	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   188: invokeinterface 423 1 0
    //   193: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 425
    //   199: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokestatic 430	com/tencent/token/im:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   206: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 431	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   215: athrow
    //   216: astore_2
    //   217: aload_3
    //   218: astore_1
    //   219: aload_2
    //   220: astore_3
    //   221: aload_1
    //   222: astore_2
    //   223: aload_3
    //   224: invokestatic 434	com/tencent/token/gn:a	(Ljava/lang/AssertionError;)Z
    //   227: ifeq +142 -> 369
    //   230: aload_1
    //   231: astore_2
    //   232: new 149	java/io/IOException
    //   235: dup
    //   236: aload_3
    //   237: invokespecial 340	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   240: athrow
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +10 -> 253
    //   246: invokestatic 298	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   249: aload_2
    //   250: invokevirtual 437	com/tencent/token/ih:b	(Ljavax/net/ssl/SSLSocket;)V
    //   253: aload_2
    //   254: invokestatic 251	com/tencent/token/gn:a	(Ljava/net/Socket;)V
    //   257: aload_1
    //   258: athrow
    //   259: aload 6
    //   261: invokevirtual 440	okhttp3/a:k	()Lokhttp3/i;
    //   264: aload 6
    //   266: invokevirtual 213	okhttp3/a:a	()Lokhttp3/af;
    //   269: invokevirtual 218	okhttp3/af:f	()Ljava/lang/String;
    //   272: aload_2
    //   273: invokevirtual 393	okhttp3/ac:b	()Ljava/util/List;
    //   276: invokevirtual 443	okhttp3/i:a	(Ljava/lang/String;Ljava/util/List;)V
    //   279: aload 4
    //   281: astore_1
    //   282: aload 5
    //   284: invokevirtual 364	okhttp3/q:d	()Z
    //   287: ifeq +11 -> 298
    //   290: invokestatic 298	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   293: aload_3
    //   294: invokevirtual 446	com/tencent/token/ih:a	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   297: astore_1
    //   298: aload_0
    //   299: aload_3
    //   300: putfield 200	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   303: aload_0
    //   304: aload_0
    //   305: getfield 200	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   308: invokestatic 306	okio/o:b	(Ljava/net/Socket;)Lokio/y;
    //   311: invokestatic 309	okio/o:a	(Lokio/y;)Lokio/i;
    //   314: putfield 78	okhttp3/internal/connection/c:n	Lokio/i;
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 200	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   322: invokestatic 312	okio/o:a	(Ljava/net/Socket;)Lokio/x;
    //   325: invokestatic 315	okio/o:a	(Lokio/x;)Lokio/h;
    //   328: putfield 80	okhttp3/internal/connection/c:o	Lokio/h;
    //   331: aload_0
    //   332: aload_2
    //   333: putfield 448	okhttp3/internal/connection/c:k	Lokhttp3/ac;
    //   336: aload_1
    //   337: ifnull +25 -> 362
    //   340: aload_1
    //   341: invokestatic 453	okhttp3/Protocol:a	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   344: astore_1
    //   345: aload_0
    //   346: aload_1
    //   347: putfield 455	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   350: aload_3
    //   351: ifnull +10 -> 361
    //   354: invokestatic 298	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   357: aload_3
    //   358: invokevirtual 437	com/tencent/token/ih:b	(Ljavax/net/ssl/SSLSocket;)V
    //   361: return
    //   362: getstatic 458	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
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
    //   1	123	2	localac	ac
    //   216	4	2	localAssertionError1	java.lang.AssertionError
    //   222	154	2	localObject1	Object
    //   22	353	3	localObject2	Object
    //   379	1	3	localAssertionError2	java.lang.AssertionError
    //   3	277	4	localObject3	Object
    //   6	375	5	localq	q
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
  
  private void a(b paramb, int paramInt, okhttp3.g paramg, okhttp3.y paramy)
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
      paramy.b(paramg);
      a(paramb);
      paramy.a(paramg, this.k);
    } while (this.l != Protocol.HTTP_2);
    a(paramInt);
  }
  
  private ap e()
  {
    return new aq().a(this.h.a().a()).a("Host", gn.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", gq.a()).a();
  }
  
  public hd a(ak paramak, ai paramai, g paramg)
  {
    if (this.m != null) {
      return new okhttp3.internal.http2.f(paramak, paramai, paramg, this.m);
    }
    this.j.setSoTimeout(paramai.c());
    this.n.a().a(paramai.c(), TimeUnit.MILLISECONDS);
    this.o.a().a(paramai.d(), TimeUnit.MILLISECONDS);
    return new ho(paramak, paramg, this.n, this.o);
  }
  
  public ax a()
  {
    return this.h;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, okhttp3.g arg6, okhttp3.y paramy)
  {
    if (this.l != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject = this.h.a().f();
    b localb = new b((List)localObject);
    if (this.h.a().i() == null)
    {
      if (!((List)localObject).contains(q.d)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      }
      localObject = this.h.a().a().f();
      if (!ih.c().b((String)localObject)) {
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
            a(paramInt1, paramInt2, paramInt3, ???, paramy);
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
            a(paramInt1, paramInt2, ???, paramy);
            a(localb, paramInt4, ???, paramy);
            paramy.a(???, this.h.c(), this.h.b(), this.l);
          }
        }
      }
      catch (IOException localIOException)
      {
        gn.a(this.j);
        gn.a(this.i);
        this.j = null;
        this.i = null;
        this.n = null;
        this.o = null;
        this.k = null;
        this.l = null;
        this.m = null;
        paramy.a(???, this.h.c(), this.h.b(), null, localIOException);
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
  
  public void a(okhttp3.internal.http2.h paramh)
  {
    synchronized (this.g)
    {
      this.c = paramh.a();
      return;
    }
  }
  
  public void a(okhttp3.internal.http2.z paramz)
  {
    paramz.a(ErrorCode.REFUSED_STREAM);
  }
  
  public boolean a(a parama, @Nullable ax paramax)
  {
    if ((this.d.size() >= this.c) || (this.a)) {}
    do
    {
      do
      {
        return false;
      } while (!gl.a.a(this.h.a(), parama));
      if (parama.a().f().equals(a().a().a().f())) {
        return true;
      }
    } while ((this.m == null) || (paramax == null) || (paramax.b().type() != Proxy.Type.DIRECT) || (this.h.b().type() != Proxy.Type.DIRECT) || (!this.h.c().equals(paramax.c())) || (paramax.a().j() != im.a) || (!a(parama.a())));
    try
    {
      parama.k().a(parama.a().f(), c().b());
      return true;
    }
    catch (SSLPeerUnverifiedException parama) {}
    return false;
  }
  
  public boolean a(af paramaf)
  {
    if (paramaf.g() != this.h.a().a().g()) {
      return false;
    }
    if (!paramaf.f().equals(this.h.a().a().f()))
    {
      if ((this.k != null) && (im.a.a(paramaf.f(), (X509Certificate)this.k.b().get(0)))) {}
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
  
  public ac c()
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