package okhttp3.internal.connection;

import com.tencent.token.fd;
import com.tencent.token.ff;
import com.tencent.token.fg;
import com.tencent.token.fo;
import com.tencent.token.fq;
import com.tencent.token.fy;
import com.tencent.token.gj;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CONNECT ");
    ((StringBuilder)localObject).append(ff.a(params, true));
    ((StringBuilder)localObject).append(" HTTP/1.1");
    params = ((StringBuilder)localObject).toString();
    for (;;)
    {
      fy localfy = new fy(null, null, this.n, this.o);
      this.n.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.o.a().a(paramInt2, TimeUnit.MILLISECONDS);
      localfy.a(paramx.c(), params);
      localfy.b();
      localObject = localfy.a(false).a(paramx).a();
      long l2 = fq.a((z)localObject);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramx = localfy.b(l1);
      ff.b(paramx, 2147483647, TimeUnit.MILLISECONDS);
      paramx.close();
      int i1 = ((z)localObject).b();
      if (i1 == 200) {
        break label293;
      }
      if (i1 != 407) {
        break label256;
      }
      paramx = this.h.a().d().a(this.h, (z)localObject);
      if (paramx == null) {
        break;
      }
      if ("close".equalsIgnoreCase(((z)localObject).a("Connection"))) {
        return paramx;
      }
    }
    throw new IOException("Failed to authenticate with proxy");
    label256:
    paramx = new StringBuilder();
    paramx.append("Unexpected response code for CONNECT: ");
    paramx.append(((z)localObject).b());
    throw new IOException(paramx.toString());
    label293:
    if ((this.n.c().e()) && (this.o.c().e())) {
      return null;
    }
    throw new IOException("TLS tunnel buffered too many bytes!");
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
    while (i1 < 21)
    {
      a(paramInt1, paramInt2, parame, paramp);
      localx = a(paramInt2, paramInt3, localx, locals);
      if (localx == null) {
        return;
      }
      ff.a(this.i);
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
    //   13: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 273	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 279	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +31 -> 57
    //   29: aload 6
    //   31: invokevirtual 273	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 282	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +6 -> 43
    //   40: goto +17 -> 57
    //   43: new 203	java/net/Socket
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 285	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   52: astore 5
    //   54: goto +13 -> 67
    //   57: aload 5
    //   59: invokevirtual 288	okhttp3/a:c	()Ljavax/net/SocketFactory;
    //   62: invokevirtual 294	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   65: astore 5
    //   67: aload_0
    //   68: aload 5
    //   70: putfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   73: aload 4
    //   75: aload_3
    //   76: aload_0
    //   77: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   80: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   83: aload 6
    //   85: invokevirtual 297	okhttp3/p:a	(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   88: aload_0
    //   89: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   92: iload_2
    //   93: invokevirtual 206	java/net/Socket:setSoTimeout	(I)V
    //   96: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   99: aload_0
    //   100: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   103: aload_0
    //   104: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   107: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   110: iload_1
    //   111: invokevirtual 305	com/tencent/token/gf:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   119: invokestatic 310	okio/k:b	(Ljava/net/Socket;)Lokio/q;
    //   122: invokestatic 313	okio/k:a	(Lokio/q;)Lokio/e;
    //   125: putfield 79	okhttp3/internal/connection/c:n	Lokio/e;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   133: invokestatic 316	okio/k:a	(Ljava/net/Socket;)Lokio/p;
    //   136: invokestatic 319	okio/k:a	(Lokio/p;)Lokio/d;
    //   139: putfield 81	okhttp3/internal/connection/c:o	Lokio/d;
    //   142: return
    //   143: astore_3
    //   144: ldc_w 321
    //   147: aload_3
    //   148: invokevirtual 324	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +4 -> 158
    //   157: return
    //   158: new 177	java/io/IOException
    //   161: dup
    //   162: aload_3
    //   163: invokespecial 331	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   166: athrow
    //   167: astore_3
    //   168: new 57	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc_w 333
    //   182: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: aload_0
    //   189: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   192: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   195: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 265	java/net/ConnectException
    //   202: dup
    //   203: aload 4
    //   205: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 337	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   211: astore 4
    //   213: aload 4
    //   215: aload_3
    //   216: invokevirtual 341	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   219: pop
    //   220: aload 4
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	c
    //   0	223	1	paramInt1	int
    //   0	223	2	paramInt2	int
    //   0	223	3	parame	okhttp3.e
    //   0	223	4	paramp	p
    //   16	53	5	localObject	Object
    //   7	77	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   114	142	143	java/lang/NullPointerException
    //   96	114	167	java/net/ConnectException
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   4: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   7: astore 6
    //   9: aload 6
    //   11: invokevirtual 347	okhttp3/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   14: astore_3
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
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
    //   67: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   76: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 368	okhttp3/a:e	()Ljava/util/List;
    //   84: invokevirtual 371	com/tencent/token/gf:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
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
    //   120: ifeq +113 -> 233
    //   123: aload 6
    //   125: invokevirtual 395	okhttp3/a:k	()Lokhttp3/g;
    //   128: aload 6
    //   130: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   133: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   136: aload_2
    //   137: invokevirtual 397	okhttp3/q:b	()Ljava/util/List;
    //   140: invokevirtual 402	okhttp3/g:a	(Ljava/lang/String;Ljava/util/List;)V
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: invokevirtual 365	okhttp3/k:d	()Z
    //   151: ifeq +11 -> 162
    //   154: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   157: aload_3
    //   158: invokevirtual 405	com/tencent/token/gf:a	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   161: astore_1
    //   162: aload_0
    //   163: aload_3
    //   164: putfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   172: invokestatic 310	okio/k:b	(Ljava/net/Socket;)Lokio/q;
    //   175: invokestatic 313	okio/k:a	(Lokio/q;)Lokio/e;
    //   178: putfield 79	okhttp3/internal/connection/c:n	Lokio/e;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   186: invokestatic 316	okio/k:a	(Ljava/net/Socket;)Lokio/p;
    //   189: invokestatic 319	okio/k:a	(Lokio/p;)Lokio/d;
    //   192: putfield 81	okhttp3/internal/connection/c:o	Lokio/d;
    //   195: aload_0
    //   196: aload_2
    //   197: putfield 407	okhttp3/internal/connection/c:k	Lokhttp3/q;
    //   200: aload_1
    //   201: ifnull +11 -> 212
    //   204: aload_1
    //   205: invokestatic 412	okhttp3/Protocol:a	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   208: astore_1
    //   209: goto +7 -> 216
    //   212: getstatic 415	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   215: astore_1
    //   216: aload_0
    //   217: aload_1
    //   218: putfield 417	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   221: aload_3
    //   222: ifnull +10 -> 232
    //   225: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   228: aload_3
    //   229: invokevirtual 420	com/tencent/token/gf:b	(Ljavax/net/ssl/SSLSocket;)V
    //   232: return
    //   233: aload_2
    //   234: invokevirtual 397	okhttp3/q:b	()Ljava/util/List;
    //   237: iconst_0
    //   238: invokeinterface 426 2 0
    //   243: checkcast 428	java/security/cert/X509Certificate
    //   246: astore_1
    //   247: new 57	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   254: astore_2
    //   255: aload_2
    //   256: ldc_w 430
    //   259: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload 6
    //   266: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   269: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   272: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc_w 432
    //   280: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: aload_1
    //   286: invokestatic 435	okhttp3/g:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   289: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: ldc_w 437
    //   297: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: aload_1
    //   303: invokevirtual 441	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   306: invokeinterface 446 1 0
    //   311: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 448
    //   319: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: aload_1
    //   325: invokestatic 453	com/tencent/token/gj:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   328: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: new 455	javax/net/ssl/SSLPeerUnverifiedException
    //   335: dup
    //   336: aload_2
    //   337: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 456	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   343: athrow
    //   344: astore_1
    //   345: goto +45 -> 390
    //   348: astore_2
    //   349: aload_3
    //   350: astore_1
    //   351: aload_2
    //   352: astore_3
    //   353: goto +13 -> 366
    //   356: astore_1
    //   357: aload_2
    //   358: astore_3
    //   359: goto +31 -> 390
    //   362: astore_3
    //   363: aload 5
    //   365: astore_1
    //   366: aload_1
    //   367: astore_2
    //   368: aload_3
    //   369: invokestatic 459	com/tencent/token/ff:a	(Ljava/lang/AssertionError;)Z
    //   372: ifeq +14 -> 386
    //   375: aload_1
    //   376: astore_2
    //   377: new 177	java/io/IOException
    //   380: dup
    //   381: aload_3
    //   382: invokespecial 331	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   385: athrow
    //   386: aload_1
    //   387: astore_2
    //   388: aload_3
    //   389: athrow
    //   390: aload_3
    //   391: ifnull +10 -> 401
    //   394: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   397: aload_3
    //   398: invokevirtual 420	com/tencent/token/gf:b	(Ljavax/net/ssl/SSLSocket;)V
    //   401: aload_3
    //   402: invokestatic 252	com/tencent/token/ff:a	(Ljava/net/Socket;)V
    //   405: aload_1
    //   406: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	c
    //   0	407	1	paramb	b
    //   16	321	2	localObject1	Object
    //   348	10	2	localAssertionError1	java.lang.AssertionError
    //   367	21	2	localb	b
    //   14	345	3	localObject2	Object
    //   362	40	3	localAssertionError2	java.lang.AssertionError
    //   21	123	4	localObject3	Object
    //   18	346	5	localk	okhttp3.k
    //   7	258	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   52	87	344	finally
    //   87	143	344	finally
    //   146	162	344	finally
    //   162	200	344	finally
    //   204	209	344	finally
    //   212	216	344	finally
    //   216	221	344	finally
    //   233	344	344	finally
    //   52	87	348	java/lang/AssertionError
    //   87	143	348	java/lang/AssertionError
    //   146	162	348	java/lang/AssertionError
    //   162	200	348	java/lang/AssertionError
    //   204	209	348	java/lang/AssertionError
    //   212	216	348	java/lang/AssertionError
    //   216	221	348	java/lang/AssertionError
    //   233	344	348	java/lang/AssertionError
    //   23	52	356	finally
    //   368	375	356	finally
    //   377	386	356	finally
    //   388	390	356	finally
    //   23	52	362	java/lang/AssertionError
  }
  
  private void a(b paramb, int paramInt, okhttp3.e parame, p paramp)
  {
    if (this.h.a().i() == null)
    {
      if (this.h.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE))
      {
        this.j = this.i;
        this.l = Protocol.H2_PRIOR_KNOWLEDGE;
        a(paramInt);
        return;
      }
      this.j = this.i;
      this.l = Protocol.HTTP_1_1;
      return;
    }
    paramp.b(parame);
    a(paramb);
    paramp.a(parame, this.k);
    if (this.l == Protocol.HTTP_2) {
      a(paramInt);
    }
  }
  
  private x e()
  {
    return new x.a().a(this.h.a().a()).a("Host", ff.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", fg.a()).a();
  }
  
  public fo a(v paramv, t.a parama, f paramf)
  {
    okhttp3.internal.http2.e locale = this.m;
    if (locale != null) {
      return new okhttp3.internal.http2.d(paramv, parama, paramf, locale);
    }
    this.j.setSoTimeout(parama.c());
    this.n.a().a(parama.c(), TimeUnit.MILLISECONDS);
    this.o.a().a(parama.d(), TimeUnit.MILLISECONDS);
    return new fy(paramv, paramf, this.n, this.o);
  }
  
  public ab a()
  {
    return this.h;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, okhttp3.e arg6, p paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 417	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   4: ifnonnull +491 -> 495
    //   7: aload_0
    //   8: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   11: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   14: invokevirtual 518	okhttp3/a:f	()Ljava/util/List;
    //   17: astore 8
    //   19: new 358	okhttp3/internal/connection/b
    //   22: dup
    //   23: aload 8
    //   25: invokespecial 521	okhttp3/internal/connection/b:<init>	(Ljava/util/List;)V
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   34: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   37: invokevirtual 347	okhttp3/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull +118 -> 158
    //   43: aload 8
    //   45: getstatic 524	okhttp3/k:d	Lokhttp3/k;
    //   48: invokeinterface 466 2 0
    //   53: ifeq +87 -> 140
    //   56: aload_0
    //   57: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   60: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   63: invokevirtual 214	okhttp3/a:a	()Lokhttp3/s;
    //   66: invokevirtual 219	okhttp3/s:f	()Ljava/lang/String;
    //   69: astore 8
    //   71: invokestatic 302	com/tencent/token/gf:c	()Lcom/tencent/token/gf;
    //   74: aload 8
    //   76: invokevirtual 526	com/tencent/token/gf:b	(Ljava/lang/String;)Z
    //   79: ifeq +6 -> 85
    //   82: goto +97 -> 179
    //   85: new 57	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc_w 528
    //   99: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: aload 8
    //   107: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc_w 530
    //   116: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 532	okhttp3/internal/connection/RouteException
    //   123: dup
    //   124: new 534	java/net/UnknownServiceException
    //   127: dup
    //   128: aload 6
    //   130: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 535	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   136: invokespecial 538	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   139: athrow
    //   140: new 532	okhttp3/internal/connection/RouteException
    //   143: dup
    //   144: new 534	java/net/UnknownServiceException
    //   147: dup
    //   148: ldc_w 540
    //   151: invokespecial 535	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   154: invokespecial 538	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   157: athrow
    //   158: aload_0
    //   159: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   162: invokevirtual 153	okhttp3/ab:a	()Lokhttp3/a;
    //   165: invokevirtual 368	okhttp3/a:e	()Ljava/util/List;
    //   168: getstatic 463	okhttp3/Protocol:H2_PRIOR_KNOWLEDGE	Lokhttp3/Protocol;
    //   171: invokeinterface 466 2 0
    //   176: ifne +301 -> 477
    //   179: aconst_null
    //   180: astore 9
    //   182: aload_0
    //   183: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   186: invokevirtual 541	okhttp3/ab:d	()Z
    //   189: ifeq +31 -> 220
    //   192: aload_0
    //   193: iload_1
    //   194: iload_2
    //   195: iload_3
    //   196: aload 6
    //   198: aload 7
    //   200: invokespecial 543	okhttp3/internal/connection/c:a	(IIILokhttp3/e;Lokhttp3/p;)V
    //   203: aload_0
    //   204: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   207: astore 8
    //   209: aload 8
    //   211: ifnonnull +6 -> 217
    //   214: goto +53 -> 267
    //   217: goto +13 -> 230
    //   220: aload_0
    //   221: iload_1
    //   222: iload_2
    //   223: aload 6
    //   225: aload 7
    //   227: invokespecial 245	okhttp3/internal/connection/c:a	(IILokhttp3/e;Lokhttp3/p;)V
    //   230: aload_0
    //   231: aload 10
    //   233: iload 4
    //   235: aload 6
    //   237: aload 7
    //   239: invokespecial 545	okhttp3/internal/connection/c:a	(Lokhttp3/internal/connection/b;ILokhttp3/e;Lokhttp3/p;)V
    //   242: aload 7
    //   244: aload 6
    //   246: aload_0
    //   247: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   250: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   253: aload_0
    //   254: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   257: invokevirtual 258	okhttp3/ab:b	()Ljava/net/Proxy;
    //   260: aload_0
    //   261: getfield 417	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   264: invokevirtual 263	okhttp3/p:a	(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V
    //   267: aload_0
    //   268: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   271: invokevirtual 541	okhttp3/ab:d	()Z
    //   274: ifeq +31 -> 305
    //   277: aload_0
    //   278: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   281: ifnull +6 -> 287
    //   284: goto +21 -> 305
    //   287: new 532	okhttp3/internal/connection/RouteException
    //   290: dup
    //   291: new 547	java/net/ProtocolException
    //   294: dup
    //   295: ldc_w 549
    //   298: invokespecial 550	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   301: invokespecial 538	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   304: athrow
    //   305: aload_0
    //   306: getfield 233	okhttp3/internal/connection/c:m	Lokhttp3/internal/http2/e;
    //   309: ifnull +35 -> 344
    //   312: aload_0
    //   313: getfield 51	okhttp3/internal/connection/c:g	Lokhttp3/j;
    //   316: astore 6
    //   318: aload 6
    //   320: monitorenter
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 233	okhttp3/internal/connection/c:m	Lokhttp3/internal/http2/e;
    //   326: invokevirtual 552	okhttp3/internal/http2/e:a	()I
    //   329: putfield 40	okhttp3/internal/connection/c:c	I
    //   332: aload 6
    //   334: monitorexit
    //   335: return
    //   336: astore 7
    //   338: aload 6
    //   340: monitorexit
    //   341: aload 7
    //   343: athrow
    //   344: return
    //   345: astore 8
    //   347: goto +10 -> 357
    //   350: astore 8
    //   352: goto +5 -> 357
    //   355: astore 8
    //   357: aload_0
    //   358: getfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   361: invokestatic 252	com/tencent/token/ff:a	(Ljava/net/Socket;)V
    //   364: aload_0
    //   365: getfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   368: invokestatic 252	com/tencent/token/ff:a	(Ljava/net/Socket;)V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 201	okhttp3/internal/connection/c:j	Ljava/net/Socket;
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 249	okhttp3/internal/connection/c:i	Ljava/net/Socket;
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 79	okhttp3/internal/connection/c:n	Lokio/e;
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 81	okhttp3/internal/connection/c:o	Lokio/d;
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 407	okhttp3/internal/connection/c:k	Lokhttp3/q;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 417	okhttp3/internal/connection/c:l	Lokhttp3/Protocol;
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield 233	okhttp3/internal/connection/c:m	Lokhttp3/internal/http2/e;
    //   406: aload 7
    //   408: aload 6
    //   410: aload_0
    //   411: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   414: invokevirtual 255	okhttp3/ab:c	()Ljava/net/InetSocketAddress;
    //   417: aload_0
    //   418: getfield 53	okhttp3/internal/connection/c:h	Lokhttp3/ab;
    //   421: invokevirtual 258	okhttp3/ab:b	()Ljava/net/Proxy;
    //   424: aconst_null
    //   425: aload 8
    //   427: invokevirtual 555	okhttp3/p:a	(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V
    //   430: aload 9
    //   432: ifnonnull +17 -> 449
    //   435: new 532	okhttp3/internal/connection/RouteException
    //   438: dup
    //   439: aload 8
    //   441: invokespecial 538	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   444: astore 9
    //   446: goto +10 -> 456
    //   449: aload 9
    //   451: aload 8
    //   453: invokevirtual 557	okhttp3/internal/connection/RouteException:a	(Ljava/io/IOException;)V
    //   456: iload 5
    //   458: ifeq +16 -> 474
    //   461: aload 10
    //   463: aload 8
    //   465: invokevirtual 560	okhttp3/internal/connection/b:a	(Ljava/io/IOException;)Z
    //   468: ifeq +6 -> 474
    //   471: goto -289 -> 182
    //   474: aload 9
    //   476: athrow
    //   477: new 532	okhttp3/internal/connection/RouteException
    //   480: dup
    //   481: new 534	java/net/UnknownServiceException
    //   484: dup
    //   485: ldc_w 562
    //   488: invokespecial 535	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   491: invokespecial 538	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   494: athrow
    //   495: new 564	java/lang/IllegalStateException
    //   498: dup
    //   499: ldc_w 566
    //   502: invokespecial 567	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   505: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	c
    //   0	506	1	paramInt1	int
    //   0	506	2	paramInt2	int
    //   0	506	3	paramInt3	int
    //   0	506	4	paramInt4	int
    //   0	506	5	paramBoolean	boolean
    //   0	506	7	paramp	p
    //   17	193	8	localObject	Object
    //   345	1	8	localIOException1	IOException
    //   350	1	8	localIOException2	IOException
    //   355	109	8	localIOException3	IOException
    //   180	295	9	localRouteException	RouteException
    //   28	434	10	localb	b
    // Exception table:
    //   from	to	target	type
    //   321	335	336	finally
    //   338	341	336	finally
    //   230	267	345	java/io/IOException
    //   220	230	350	java/io/IOException
    //   182	209	355	java/io/IOException
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
    if (this.d.size() < this.c)
    {
      if (this.a) {
        return false;
      }
      if (!fd.a.a(this.h.a(), parama)) {
        return false;
      }
      if (parama.a().f().equals(a().a().a().f())) {
        return true;
      }
      if (this.m == null) {
        return false;
      }
      if (paramab == null) {
        return false;
      }
      if (paramab.b().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (this.h.b().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (!this.h.c().equals(paramab.c())) {
        return false;
      }
      if (paramab.a().j() != gj.a) {
        return false;
      }
      if (!a(parama.a())) {
        return false;
      }
    }
    try
    {
      parama.k().a(parama.a().f(), c().b());
      return true;
    }
    catch (SSLPeerUnverifiedException parama) {}
    return false;
    return false;
  }
  
  public boolean a(s params)
  {
    if (params.g() != this.h.a().a().g()) {
      return false;
    }
    if (!params.f().equals(this.h.a().a().f())) {
      return (this.k != null) && (gj.a.a(params.f(), (X509Certificate)this.k.b().get(0)));
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!this.j.isClosed()) && (!this.j.isInputShutdown()))
    {
      if (this.j.isOutputShutdown()) {
        return false;
      }
      okhttp3.internal.http2.e locale = this.m;
      if (locale != null) {
        return locale.d() ^ true;
      }
      if (!paramBoolean) {}
    }
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
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
    return false;
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection{");
    localStringBuilder.append(this.h.a().a().f());
    localStringBuilder.append(":");
    localStringBuilder.append(this.h.a().a().g());
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(this.h.b());
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(this.h.c());
    localStringBuilder.append(" cipherSuite=");
    Object localObject = this.k;
    if (localObject != null) {
      localObject = ((okhttp3.q)localObject).a();
    } else {
      localObject = "none";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.c
 * JD-Core Version:    0.7.0.1
 */