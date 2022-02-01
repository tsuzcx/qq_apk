package com.tencent.token;

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
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ajf
  extends akd.b
{
  public final ait a;
  public Socket b;
  public aih c;
  akd d;
  alb e;
  ala f;
  public boolean g;
  public int h;
  public int i = 1;
  public final List<Reference<ajj>> j = new ArrayList();
  public long k = 9223372036854775807L;
  private final aia m;
  private Socket n;
  private ain o;
  
  public ajf(aia paramaia, ait paramait)
  {
    this.m = paramaia;
    this.a = paramait;
  }
  
  private void a(int paramInt)
  {
    this.b.setSoTimeout(0);
    akd.a locala = new akd.a().a(this.b, this.a.a.a.b, this.e, this.f);
    locala.e = this;
    locala.h = paramInt;
    this.d = locala.a();
    this.d.c();
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   4: getfield 107	com/tencent/token/ait:b	Ljava/net/Proxy;
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   12: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   15: astore 4
    //   17: aload_3
    //   18: invokevirtual 113	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   21: getstatic 119	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   24: if_acmpeq +28 -> 52
    //   27: aload_3
    //   28: invokevirtual 113	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   31: getstatic 122	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   34: if_acmpne +6 -> 40
    //   37: goto +15 -> 52
    //   40: new 57	java/net/Socket
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 125	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   48: astore_3
    //   49: goto +12 -> 61
    //   52: aload 4
    //   54: getfield 128	com/tencent/token/ahs:c	Ljavax/net/SocketFactory;
    //   57: invokevirtual 134	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   60: astore_3
    //   61: aload_0
    //   62: aload_3
    //   63: putfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   66: aload_0
    //   67: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   70: iload_2
    //   71: invokevirtual 60	java/net/Socket:setSoTimeout	(I)V
    //   74: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   77: aload_0
    //   78: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   81: aload_0
    //   82: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   85: getfield 144	com/tencent/token/ait:c	Ljava/net/InetSocketAddress;
    //   88: iload_1
    //   89: invokevirtual 147	com/tencent/token/akr:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   97: invokestatic 152	com/tencent/token/ali:b	(Ljava/net/Socket;)Lcom/tencent/token/alp;
    //   100: invokestatic 155	com/tencent/token/ali:a	(Lcom/tencent/token/alp;)Lcom/tencent/token/alb;
    //   103: putfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   111: invokestatic 158	com/tencent/token/ali:a	(Ljava/net/Socket;)Lcom/tencent/token/alo;
    //   114: invokestatic 161	com/tencent/token/ali:a	(Lcom/tencent/token/alo;)Lcom/tencent/token/ala;
    //   117: putfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   120: return
    //   121: astore_3
    //   122: ldc 163
    //   124: aload_3
    //   125: invokevirtual 167	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +4 -> 135
    //   134: return
    //   135: new 175	java/io/IOException
    //   138: dup
    //   139: aload_3
    //   140: invokespecial 178	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   143: athrow
    //   144: astore_3
    //   145: new 180	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 182
    //   151: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: astore 4
    //   156: aload 4
    //   158: aload_0
    //   159: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   162: getfield 144	com/tencent/token/ait:c	Ljava/net/InetSocketAddress;
    //   165: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: new 102	java/net/ConnectException
    //   172: dup
    //   173: aload 4
    //   175: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 193	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   181: astore 4
    //   183: aload 4
    //   185: aload_3
    //   186: invokevirtual 197	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   189: pop
    //   190: aload 4
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ajf
    //   0	193	1	paramInt1	int
    //   0	193	2	paramInt2	int
    //   7	56	3	localObject1	Object
    //   121	19	3	localNullPointerException	java.lang.NullPointerException
    //   144	42	3	localConnectException	java.net.ConnectException
    //   15	176	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   92	120	121	java/lang/NullPointerException
    //   74	92	144	java/net/ConnectException
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   4: ifnonnull +1541 -> 1545
    //   7: aload_0
    //   8: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   11: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   14: getfield 204	com/tencent/token/ahs:f	Ljava/util/List;
    //   17: astore 13
    //   19: new 206	com/tencent/token/aje
    //   22: dup
    //   23: aload 13
    //   25: invokespecial 209	com/tencent/token/aje:<init>	(Ljava/util/List;)V
    //   28: astore 17
    //   30: aload_0
    //   31: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   34: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   37: getfield 212	com/tencent/token/ahs:i	Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull +109 -> 149
    //   43: aload 13
    //   45: getstatic 217	com/tencent/token/aib:d	Lcom/tencent/token/aib;
    //   48: invokeinterface 222 2 0
    //   53: ifeq +79 -> 132
    //   56: aload_0
    //   57: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   60: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   63: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   66: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   69: astore 13
    //   71: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   74: aload 13
    //   76: invokevirtual 225	com/tencent/token/akr:b	(Ljava/lang/String;)Z
    //   79: ifeq +6 -> 85
    //   82: goto +88 -> 170
    //   85: new 180	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 227
    //   91: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: astore 14
    //   96: aload 14
    //   98: aload 13
    //   100: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 14
    //   106: ldc 232
    //   108: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 234	com/tencent/token/ajh
    //   115: dup
    //   116: new 236	java/net/UnknownServiceException
    //   119: dup
    //   120: aload 14
    //   122: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 237	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   128: invokespecial 240	com/tencent/token/ajh:<init>	(Ljava/io/IOException;)V
    //   131: athrow
    //   132: new 234	com/tencent/token/ajh
    //   135: dup
    //   136: new 236	java/net/UnknownServiceException
    //   139: dup
    //   140: ldc 242
    //   142: invokespecial 237	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   145: invokespecial 240	com/tencent/token/ajh:<init>	(Ljava/io/IOException;)V
    //   148: athrow
    //   149: aload_0
    //   150: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   153: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   156: getfield 244	com/tencent/token/ahs:e	Ljava/util/List;
    //   159: getstatic 248	com/tencent/token/ain:e	Lcom/tencent/token/ain;
    //   162: invokeinterface 222 2 0
    //   167: ifne +1360 -> 1527
    //   170: aconst_null
    //   171: astore 15
    //   173: iconst_0
    //   174: istore 7
    //   176: aload_0
    //   177: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   180: invokevirtual 251	com/tencent/token/ait:a	()Z
    //   183: ifeq +401 -> 584
    //   186: new 253	com/tencent/token/aip$a
    //   189: dup
    //   190: invokespecial 254	com/tencent/token/aip$a:<init>	()V
    //   193: aload_0
    //   194: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   197: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   200: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   203: invokevirtual 257	com/tencent/token/aip$a:a	(Lcom/tencent/token/aij;)Lcom/tencent/token/aip$a;
    //   206: ldc_w 259
    //   209: aload_0
    //   210: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   213: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   216: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   219: iconst_1
    //   220: invokestatic 264	com/tencent/token/aix:a	(Lcom/tencent/token/aij;Z)Ljava/lang/String;
    //   223: invokevirtual 267	com/tencent/token/aip$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aip$a;
    //   226: ldc_w 269
    //   229: ldc_w 271
    //   232: invokevirtual 267	com/tencent/token/aip$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aip$a;
    //   235: ldc_w 273
    //   238: ldc_w 275
    //   241: invokevirtual 267	com/tencent/token/aip$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aip$a;
    //   244: invokevirtual 278	com/tencent/token/aip$a:a	()Lcom/tencent/token/aip;
    //   247: astore 13
    //   249: aload 13
    //   251: getfield 281	com/tencent/token/aip:a	Lcom/tencent/token/aij;
    //   254: astore 14
    //   256: aload_0
    //   257: iload_1
    //   258: iload_2
    //   259: invokespecial 283	com/tencent/token/ajf:a	(II)V
    //   262: new 180	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 285
    //   269: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: astore 16
    //   274: aload 16
    //   276: aload 14
    //   278: iconst_1
    //   279: invokestatic 264	com/tencent/token/aix:a	(Lcom/tencent/token/aij;Z)Ljava/lang/String;
    //   282: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 16
    //   288: ldc_w 287
    //   291: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 16
    //   297: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 16
    //   302: new 289	com/tencent/token/ajw
    //   305: dup
    //   306: aconst_null
    //   307: aconst_null
    //   308: aload_0
    //   309: getfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   312: aload_0
    //   313: getfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   316: invokespecial 292	com/tencent/token/ajw:<init>	(Lcom/tencent/token/aim;Lcom/tencent/token/ajj;Lcom/tencent/token/alb;Lcom/tencent/token/ala;)V
    //   319: astore 14
    //   321: aload_0
    //   322: getfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   325: invokeinterface 297 1 0
    //   330: astore 18
    //   332: iload_2
    //   333: i2l
    //   334: lstore 9
    //   336: aload 18
    //   338: lload 9
    //   340: getstatic 303	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   343: invokevirtual 308	com/tencent/token/alq:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/alq;
    //   346: pop
    //   347: aload_0
    //   348: getfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   351: invokeinterface 311 1 0
    //   356: astore 18
    //   358: iload_3
    //   359: i2l
    //   360: lstore 9
    //   362: aload 18
    //   364: lload 9
    //   366: getstatic 303	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   369: invokevirtual 308	com/tencent/token/alq:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/alq;
    //   372: pop
    //   373: aload 14
    //   375: aload 13
    //   377: getfield 314	com/tencent/token/aip:c	Lcom/tencent/token/aii;
    //   380: aload 16
    //   382: invokevirtual 317	com/tencent/token/ajw:a	(Lcom/tencent/token/aii;Ljava/lang/String;)V
    //   385: aload 14
    //   387: invokevirtual 319	com/tencent/token/ajw:b	()V
    //   390: aload 14
    //   392: iconst_0
    //   393: invokevirtual 322	com/tencent/token/ajw:a	(Z)Lcom/tencent/token/air$a;
    //   396: astore 16
    //   398: aload 16
    //   400: aload 13
    //   402: putfield 327	com/tencent/token/air$a:a	Lcom/tencent/token/aip;
    //   405: aload 16
    //   407: invokevirtual 330	com/tencent/token/air$a:a	()Lcom/tencent/token/air;
    //   410: astore 13
    //   412: aload 13
    //   414: invokestatic 335	com/tencent/token/ajo:a	(Lcom/tencent/token/air;)J
    //   417: lstore 11
    //   419: lload 11
    //   421: lstore 9
    //   423: lload 11
    //   425: ldc2_w 336
    //   428: lcmp
    //   429: ifne +6 -> 435
    //   432: lconst_0
    //   433: lstore 9
    //   435: aload 14
    //   437: lload 9
    //   439: invokevirtual 340	com/tencent/token/ajw:a	(J)Lcom/tencent/token/alp;
    //   442: astore 14
    //   444: aload 14
    //   446: ldc_w 341
    //   449: getstatic 303	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   452: invokestatic 344	com/tencent/token/aix:a	(Lcom/tencent/token/alp;ILjava/util/concurrent/TimeUnit;)Z
    //   455: pop
    //   456: aload 14
    //   458: invokeinterface 349 1 0
    //   463: aload 13
    //   465: getfield 353	com/tencent/token/air:c	I
    //   468: istore 6
    //   470: iload 6
    //   472: sipush 200
    //   475: if_icmpeq +58 -> 533
    //   478: iload 6
    //   480: sipush 407
    //   483: if_icmpeq +39 -> 522
    //   486: new 180	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 355
    //   493: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: astore 14
    //   498: aload 14
    //   500: aload 13
    //   502: getfield 353	com/tencent/token/air:c	I
    //   505: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: new 175	java/io/IOException
    //   512: dup
    //   513: aload 14
    //   515: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokespecial 359	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   521: athrow
    //   522: new 175	java/io/IOException
    //   525: dup
    //   526: ldc_w 361
    //   529: invokespecial 359	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   532: athrow
    //   533: aload_0
    //   534: getfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   537: invokeinterface 364 1 0
    //   542: invokevirtual 368	com/tencent/token/akz:c	()Z
    //   545: ifeq +28 -> 573
    //   548: aload_0
    //   549: getfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   552: invokeinterface 369 1 0
    //   557: invokevirtual 368	com/tencent/token/akz:c	()Z
    //   560: ifeq +13 -> 573
    //   563: aload_0
    //   564: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   567: ifnonnull +23 -> 590
    //   570: goto +428 -> 998
    //   573: new 175	java/io/IOException
    //   576: dup
    //   577: ldc_w 371
    //   580: invokespecial 359	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   583: athrow
    //   584: aload_0
    //   585: iload_1
    //   586: iload_2
    //   587: invokespecial 283	com/tencent/token/ajf:a	(II)V
    //   590: aload_0
    //   591: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   594: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   597: getfield 212	com/tencent/token/ahs:i	Ljavax/net/ssl/SSLSocketFactory;
    //   600: ifnonnull +66 -> 666
    //   603: aload_0
    //   604: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   607: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   610: getfield 244	com/tencent/token/ahs:e	Ljava/util/List;
    //   613: getstatic 248	com/tencent/token/ain:e	Lcom/tencent/token/ain;
    //   616: invokeinterface 222 2 0
    //   621: ifeq +27 -> 648
    //   624: aload_0
    //   625: aload_0
    //   626: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   629: putfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   632: aload_0
    //   633: getstatic 248	com/tencent/token/ain:e	Lcom/tencent/token/ain;
    //   636: putfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   639: aload_0
    //   640: iload 4
    //   642: invokespecial 373	com/tencent/token/ajf:a	(I)V
    //   645: goto +353 -> 998
    //   648: aload_0
    //   649: aload_0
    //   650: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   653: putfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   656: aload_0
    //   657: getstatic 375	com/tencent/token/ain:b	Lcom/tencent/token/ain;
    //   660: putfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   663: goto +335 -> 998
    //   666: aload_0
    //   667: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   670: getfield 68	com/tencent/token/ait:a	Lcom/tencent/token/ahs;
    //   673: astore 16
    //   675: aload 16
    //   677: getfield 212	com/tencent/token/ahs:i	Ljavax/net/ssl/SSLSocketFactory;
    //   680: astore 13
    //   682: aload 13
    //   684: aload_0
    //   685: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   688: aload 16
    //   690: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   693: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   696: aload 16
    //   698: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   701: getfield 376	com/tencent/token/aij:c	I
    //   704: iconst_1
    //   705: invokevirtual 381	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   708: checkcast 383	javax/net/ssl/SSLSocket
    //   711: astore 14
    //   713: aload 14
    //   715: astore 13
    //   717: aload 17
    //   719: aload 14
    //   721: invokevirtual 386	com/tencent/token/aje:a	(Ljavax/net/ssl/SSLSocket;)Lcom/tencent/token/aib;
    //   724: astore 19
    //   726: aload 14
    //   728: astore 13
    //   730: aload 19
    //   732: getfield 388	com/tencent/token/aib:f	Z
    //   735: ifeq +28 -> 763
    //   738: aload 14
    //   740: astore 13
    //   742: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   745: aload 14
    //   747: aload 16
    //   749: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   752: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   755: aload 16
    //   757: getfield 244	com/tencent/token/ahs:e	Ljava/util/List;
    //   760: invokevirtual 391	com/tencent/token/akr:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   763: aload 14
    //   765: astore 13
    //   767: aload 14
    //   769: invokevirtual 394	javax/net/ssl/SSLSocket:startHandshake	()V
    //   772: aload 14
    //   774: astore 13
    //   776: aload 14
    //   778: invokevirtual 398	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   781: astore 20
    //   783: aload 14
    //   785: astore 13
    //   787: aload 20
    //   789: invokestatic 403	com/tencent/token/aih:a	(Ljavax/net/ssl/SSLSession;)Lcom/tencent/token/aih;
    //   792: astore 18
    //   794: aload 14
    //   796: astore 13
    //   798: aload 16
    //   800: getfield 406	com/tencent/token/ahs:j	Ljavax/net/ssl/HostnameVerifier;
    //   803: aload 16
    //   805: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   808: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   811: aload 20
    //   813: invokeinterface 412 3 0
    //   818: ifeq +258 -> 1076
    //   821: aload 14
    //   823: astore 13
    //   825: aload 16
    //   827: getfield 415	com/tencent/token/ahs:k	Lcom/tencent/token/ahy;
    //   830: aload 16
    //   832: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   835: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   838: aload 18
    //   840: getfield 417	com/tencent/token/aih:b	Ljava/util/List;
    //   843: invokevirtual 422	com/tencent/token/ahy:a	(Ljava/lang/String;Ljava/util/List;)V
    //   846: aload 14
    //   848: astore 13
    //   850: aload 19
    //   852: getfield 388	com/tencent/token/aib:f	Z
    //   855: ifeq +706 -> 1561
    //   858: aload 14
    //   860: astore 13
    //   862: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   865: aload 14
    //   867: invokevirtual 425	com/tencent/token/akr:a	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   870: astore 16
    //   872: goto +3 -> 875
    //   875: aload 14
    //   877: astore 13
    //   879: aload_0
    //   880: aload 14
    //   882: putfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   885: aload 14
    //   887: astore 13
    //   889: aload_0
    //   890: aload_0
    //   891: getfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   894: invokestatic 152	com/tencent/token/ali:b	(Ljava/net/Socket;)Lcom/tencent/token/alp;
    //   897: invokestatic 155	com/tencent/token/ali:a	(Lcom/tencent/token/alp;)Lcom/tencent/token/alb;
    //   900: putfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   903: aload 14
    //   905: astore 13
    //   907: aload_0
    //   908: aload_0
    //   909: getfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   912: invokestatic 158	com/tencent/token/ali:a	(Ljava/net/Socket;)Lcom/tencent/token/alo;
    //   915: invokestatic 161	com/tencent/token/ali:a	(Lcom/tencent/token/alo;)Lcom/tencent/token/ala;
    //   918: putfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   921: aload 14
    //   923: astore 13
    //   925: aload_0
    //   926: aload 18
    //   928: putfield 427	com/tencent/token/ajf:c	Lcom/tencent/token/aih;
    //   931: aload 16
    //   933: ifnull +17 -> 950
    //   936: aload 14
    //   938: astore 13
    //   940: aload 16
    //   942: invokestatic 430	com/tencent/token/ain:a	(Ljava/lang/String;)Lcom/tencent/token/ain;
    //   945: astore 16
    //   947: goto +12 -> 959
    //   950: aload 14
    //   952: astore 13
    //   954: getstatic 375	com/tencent/token/ain:b	Lcom/tencent/token/ain;
    //   957: astore 16
    //   959: aload 14
    //   961: astore 13
    //   963: aload_0
    //   964: aload 16
    //   966: putfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   969: aload 14
    //   971: ifnull +11 -> 982
    //   974: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   977: aload 14
    //   979: invokevirtual 433	com/tencent/token/akr:b	(Ljavax/net/ssl/SSLSocket;)V
    //   982: aload_0
    //   983: getfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   986: getstatic 435	com/tencent/token/ain:d	Lcom/tencent/token/ain;
    //   989: if_acmpne +9 -> 998
    //   992: aload_0
    //   993: iload 4
    //   995: invokespecial 373	com/tencent/token/ajf:a	(I)V
    //   998: aload_0
    //   999: getfield 51	com/tencent/token/ajf:a	Lcom/tencent/token/ait;
    //   1002: invokevirtual 251	com/tencent/token/ait:a	()Z
    //   1005: ifeq +31 -> 1036
    //   1008: aload_0
    //   1009: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   1012: ifnull +6 -> 1018
    //   1015: goto +21 -> 1036
    //   1018: new 234	com/tencent/token/ajh
    //   1021: dup
    //   1022: new 437	java/net/ProtocolException
    //   1025: dup
    //   1026: ldc_w 439
    //   1029: invokespecial 440	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   1032: invokespecial 240	com/tencent/token/ajh:<init>	(Ljava/io/IOException;)V
    //   1035: athrow
    //   1036: aload_0
    //   1037: getfield 95	com/tencent/token/ajf:d	Lcom/tencent/token/akd;
    //   1040: ifnull +35 -> 1075
    //   1043: aload_0
    //   1044: getfield 49	com/tencent/token/ajf:m	Lcom/tencent/token/aia;
    //   1047: astore 13
    //   1049: aload 13
    //   1051: monitorenter
    //   1052: aload_0
    //   1053: aload_0
    //   1054: getfield 95	com/tencent/token/ajf:d	Lcom/tencent/token/akd;
    //   1057: invokevirtual 443	com/tencent/token/akd:a	()I
    //   1060: putfield 38	com/tencent/token/ajf:i	I
    //   1063: aload 13
    //   1065: monitorexit
    //   1066: return
    //   1067: astore 14
    //   1069: aload 13
    //   1071: monitorexit
    //   1072: aload 14
    //   1074: athrow
    //   1075: return
    //   1076: aload 14
    //   1078: astore 13
    //   1080: aload 18
    //   1082: getfield 417	com/tencent/token/aih:b	Ljava/util/List;
    //   1085: iconst_0
    //   1086: invokeinterface 447 2 0
    //   1091: checkcast 449	java/security/cert/X509Certificate
    //   1094: astore 18
    //   1096: aload 14
    //   1098: astore 13
    //   1100: new 180	java/lang/StringBuilder
    //   1103: dup
    //   1104: ldc_w 451
    //   1107: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1110: astore 19
    //   1112: aload 14
    //   1114: astore 13
    //   1116: aload 19
    //   1118: aload 16
    //   1120: getfield 73	com/tencent/token/ahs:a	Lcom/tencent/token/aij;
    //   1123: getfield 78	com/tencent/token/aij:b	Ljava/lang/String;
    //   1126: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload 14
    //   1132: astore 13
    //   1134: aload 19
    //   1136: ldc_w 453
    //   1139: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 14
    //   1145: astore 13
    //   1147: aload 19
    //   1149: aload 18
    //   1151: invokestatic 456	com/tencent/token/ahy:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   1154: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: aload 14
    //   1160: astore 13
    //   1162: aload 19
    //   1164: ldc_w 458
    //   1167: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: aload 14
    //   1173: astore 13
    //   1175: aload 19
    //   1177: aload 18
    //   1179: invokevirtual 462	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   1182: invokeinterface 467 1 0
    //   1187: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: aload 14
    //   1193: astore 13
    //   1195: aload 19
    //   1197: ldc_w 469
    //   1200: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload 14
    //   1206: astore 13
    //   1208: aload 19
    //   1210: aload 18
    //   1212: invokestatic 474	com/tencent/token/akv:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   1215: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload 14
    //   1221: astore 13
    //   1223: new 476	javax/net/ssl/SSLPeerUnverifiedException
    //   1226: dup
    //   1227: aload 19
    //   1229: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokespecial 477	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   1235: athrow
    //   1236: astore 16
    //   1238: goto +16 -> 1254
    //   1241: astore 13
    //   1243: aconst_null
    //   1244: astore 14
    //   1246: goto +51 -> 1297
    //   1249: astore 16
    //   1251: aconst_null
    //   1252: astore 14
    //   1254: aload 14
    //   1256: astore 13
    //   1258: aload 16
    //   1260: invokestatic 480	com/tencent/token/aix:a	(Ljava/lang/AssertionError;)Z
    //   1263: ifeq +17 -> 1280
    //   1266: aload 14
    //   1268: astore 13
    //   1270: new 175	java/io/IOException
    //   1273: dup
    //   1274: aload 16
    //   1276: invokespecial 178	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   1279: athrow
    //   1280: aload 14
    //   1282: astore 13
    //   1284: aload 16
    //   1286: athrow
    //   1287: astore 16
    //   1289: aload 13
    //   1291: astore 14
    //   1293: aload 16
    //   1295: astore 13
    //   1297: aload 14
    //   1299: ifnull +11 -> 1310
    //   1302: invokestatic 141	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
    //   1305: aload 14
    //   1307: invokevirtual 433	com/tencent/token/akr:b	(Ljavax/net/ssl/SSLSocket;)V
    //   1310: aload 14
    //   1312: invokestatic 483	com/tencent/token/aix:a	(Ljava/net/Socket;)V
    //   1315: aload 13
    //   1317: athrow
    //   1318: astore 13
    //   1320: goto +5 -> 1325
    //   1323: astore 13
    //   1325: aload_0
    //   1326: getfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   1329: invokestatic 483	com/tencent/token/aix:a	(Ljava/net/Socket;)V
    //   1332: aload_0
    //   1333: getfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   1336: invokestatic 483	com/tencent/token/aix:a	(Ljava/net/Socket;)V
    //   1339: aload_0
    //   1340: aconst_null
    //   1341: putfield 55	com/tencent/token/ajf:b	Ljava/net/Socket;
    //   1344: aload_0
    //   1345: aconst_null
    //   1346: putfield 136	com/tencent/token/ajf:n	Ljava/net/Socket;
    //   1349: aload_0
    //   1350: aconst_null
    //   1351: putfield 80	com/tencent/token/ajf:e	Lcom/tencent/token/alb;
    //   1354: aload_0
    //   1355: aconst_null
    //   1356: putfield 82	com/tencent/token/ajf:f	Lcom/tencent/token/ala;
    //   1359: aload_0
    //   1360: aconst_null
    //   1361: putfield 427	com/tencent/token/ajf:c	Lcom/tencent/token/aih;
    //   1364: aload_0
    //   1365: aconst_null
    //   1366: putfield 202	com/tencent/token/ajf:o	Lcom/tencent/token/ain;
    //   1369: aload_0
    //   1370: aconst_null
    //   1371: putfield 95	com/tencent/token/ajf:d	Lcom/tencent/token/akd;
    //   1374: aload 15
    //   1376: ifnonnull +17 -> 1393
    //   1379: new 234	com/tencent/token/ajh
    //   1382: dup
    //   1383: aload 13
    //   1385: invokespecial 240	com/tencent/token/ajh:<init>	(Ljava/io/IOException;)V
    //   1388: astore 15
    //   1390: goto +20 -> 1410
    //   1393: aload 15
    //   1395: getfield 486	com/tencent/token/ajh:a	Ljava/io/IOException;
    //   1398: aload 13
    //   1400: invokestatic 489	com/tencent/token/aix:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   1403: aload 15
    //   1405: aload 13
    //   1407: putfield 491	com/tencent/token/ajh:b	Ljava/io/IOException;
    //   1410: iload 5
    //   1412: ifeq +112 -> 1524
    //   1415: aload 17
    //   1417: iconst_1
    //   1418: putfield 493	com/tencent/token/aje:b	Z
    //   1421: iload 7
    //   1423: istore 6
    //   1425: aload 17
    //   1427: getfield 495	com/tencent/token/aje:a	Z
    //   1430: ifeq +86 -> 1516
    //   1433: iload 7
    //   1435: istore 6
    //   1437: aload 13
    //   1439: instanceof 437
    //   1442: ifne +74 -> 1516
    //   1445: iload 7
    //   1447: istore 6
    //   1449: aload 13
    //   1451: instanceof 497
    //   1454: ifne +62 -> 1516
    //   1457: aload 13
    //   1459: instanceof 499
    //   1462: istore 8
    //   1464: iload 8
    //   1466: ifeq +18 -> 1484
    //   1469: iload 7
    //   1471: istore 6
    //   1473: aload 13
    //   1475: invokevirtual 503	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   1478: instanceof 505
    //   1481: ifne +35 -> 1516
    //   1484: iload 7
    //   1486: istore 6
    //   1488: aload 13
    //   1490: instanceof 476
    //   1493: ifne +23 -> 1516
    //   1496: iload 8
    //   1498: ifne +15 -> 1513
    //   1501: iload 7
    //   1503: istore 6
    //   1505: aload 13
    //   1507: instanceof 507
    //   1510: ifeq +6 -> 1516
    //   1513: iconst_1
    //   1514: istore 6
    //   1516: iload 6
    //   1518: ifeq +6 -> 1524
    //   1521: goto -1348 -> 173
    //   1524: aload 15
    //   1526: athrow
    //   1527: new 234	com/tencent/token/ajh
    //   1530: dup
    //   1531: new 236	java/net/UnknownServiceException
    //   1534: dup
    //   1535: ldc_w 509
    //   1538: invokespecial 237	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   1541: invokespecial 240	com/tencent/token/ajh:<init>	(Ljava/io/IOException;)V
    //   1544: athrow
    //   1545: new 511	java/lang/IllegalStateException
    //   1548: dup
    //   1549: ldc_w 513
    //   1552: invokespecial 514	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1555: athrow
    //   1556: astore 13
    //   1558: goto -233 -> 1325
    //   1561: aconst_null
    //   1562: astore 16
    //   1564: goto -689 -> 875
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1567	0	this	ajf
    //   0	1567	1	paramInt1	int
    //   0	1567	2	paramInt2	int
    //   0	1567	3	paramInt3	int
    //   0	1567	4	paramInt4	int
    //   0	1567	5	paramBoolean	boolean
    //   468	1049	6	i1	int
    //   174	1328	7	i2	int
    //   1462	35	8	bool	boolean
    //   334	104	9	l1	long
    //   417	7	11	l2	long
    //   1241	1	13	localObject2	Object
    //   1256	60	13	localObject3	Object
    //   1318	1	13	localIOException1	IOException
    //   1323	183	13	localIOException2	IOException
    //   1556	1	13	localIOException3	IOException
    //   94	884	14	localObject4	Object
    //   1067	153	14	localObject5	Object
    //   1244	67	14	localObject6	Object
    //   171	1354	15	localajh	ajh
    //   272	847	16	localObject7	Object
    //   1236	1	16	localAssertionError1	java.lang.AssertionError
    //   1249	36	16	localAssertionError2	java.lang.AssertionError
    //   1287	7	16	localObject8	Object
    //   1562	1	16	localObject9	Object
    //   28	1398	17	localaje	aje
    //   330	881	18	localObject10	Object
    //   724	504	19	localObject11	Object
    //   781	31	20	localSSLSession	javax.net.ssl.SSLSession
    // Exception table:
    //   from	to	target	type
    //   1052	1066	1067	finally
    //   1069	1072	1067	finally
    //   717	726	1236	java/lang/AssertionError
    //   730	738	1236	java/lang/AssertionError
    //   742	763	1236	java/lang/AssertionError
    //   767	772	1236	java/lang/AssertionError
    //   776	783	1236	java/lang/AssertionError
    //   787	794	1236	java/lang/AssertionError
    //   798	821	1236	java/lang/AssertionError
    //   825	846	1236	java/lang/AssertionError
    //   850	858	1236	java/lang/AssertionError
    //   862	872	1236	java/lang/AssertionError
    //   879	885	1236	java/lang/AssertionError
    //   889	903	1236	java/lang/AssertionError
    //   907	921	1236	java/lang/AssertionError
    //   925	931	1236	java/lang/AssertionError
    //   940	947	1236	java/lang/AssertionError
    //   954	959	1236	java/lang/AssertionError
    //   963	969	1236	java/lang/AssertionError
    //   1080	1096	1236	java/lang/AssertionError
    //   1100	1112	1236	java/lang/AssertionError
    //   1116	1130	1236	java/lang/AssertionError
    //   1134	1143	1236	java/lang/AssertionError
    //   1147	1158	1236	java/lang/AssertionError
    //   1162	1171	1236	java/lang/AssertionError
    //   1175	1191	1236	java/lang/AssertionError
    //   1195	1204	1236	java/lang/AssertionError
    //   1208	1219	1236	java/lang/AssertionError
    //   1223	1236	1236	java/lang/AssertionError
    //   682	713	1241	finally
    //   682	713	1249	java/lang/AssertionError
    //   717	726	1287	finally
    //   730	738	1287	finally
    //   742	763	1287	finally
    //   767	772	1287	finally
    //   776	783	1287	finally
    //   787	794	1287	finally
    //   798	821	1287	finally
    //   825	846	1287	finally
    //   850	858	1287	finally
    //   862	872	1287	finally
    //   879	885	1287	finally
    //   889	903	1287	finally
    //   907	921	1287	finally
    //   925	931	1287	finally
    //   940	947	1287	finally
    //   954	959	1287	finally
    //   963	969	1287	finally
    //   1080	1096	1287	finally
    //   1100	1112	1287	finally
    //   1116	1130	1287	finally
    //   1134	1143	1287	finally
    //   1147	1158	1287	finally
    //   1162	1171	1287	finally
    //   1175	1191	1287	finally
    //   1195	1204	1287	finally
    //   1208	1219	1287	finally
    //   1223	1236	1287	finally
    //   1258	1266	1287	finally
    //   1270	1280	1287	finally
    //   1284	1287	1287	finally
    //   362	419	1318	java/io/IOException
    //   435	470	1318	java/io/IOException
    //   486	522	1318	java/io/IOException
    //   522	533	1318	java/io/IOException
    //   533	570	1318	java/io/IOException
    //   573	584	1318	java/io/IOException
    //   584	590	1318	java/io/IOException
    //   590	645	1318	java/io/IOException
    //   648	663	1318	java/io/IOException
    //   666	682	1318	java/io/IOException
    //   974	982	1318	java/io/IOException
    //   982	998	1318	java/io/IOException
    //   1302	1310	1318	java/io/IOException
    //   1310	1318	1318	java/io/IOException
    //   176	332	1323	java/io/IOException
    //   336	358	1556	java/io/IOException
  }
  
  public final void a(akd paramakd)
  {
    synchronized (this.m)
    {
      this.i = paramakd.a();
      return;
    }
  }
  
  public final void a(akf paramakf)
  {
    paramakf.a(ajy.e);
  }
  
  public final boolean a()
  {
    return this.d != null;
  }
  
  public final boolean a(ahs paramahs, @Nullable ait paramait)
  {
    if (this.j.size() < this.i)
    {
      if (this.g) {
        return false;
      }
      if (!aiv.a.a(this.a.a, paramahs)) {
        return false;
      }
      if (paramahs.a.b.equals(this.a.a.a.b)) {
        return true;
      }
      if (this.d == null) {
        return false;
      }
      if (paramait == null) {
        return false;
      }
      if (paramait.b.type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (this.a.b.type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (!this.a.c.equals(paramait.c)) {
        return false;
      }
      if (paramait.a.j != akv.a) {
        return false;
      }
      if (!a(paramahs.a)) {
        return false;
      }
    }
    try
    {
      paramahs.k.a(paramahs.a.b, this.c.b);
      return true;
    }
    catch (SSLPeerUnverifiedException paramahs) {}
    return false;
    return false;
  }
  
  public final boolean a(aij paramaij)
  {
    if (paramaij.c != this.a.a.a.c) {
      return false;
    }
    if (!paramaij.b.equals(this.a.a.a.b))
    {
      if (this.c != null)
      {
        akv localakv = akv.a;
        if (akv.a(paramaij.b, (X509Certificate)this.c.b.get(0))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if ((!this.b.isClosed()) && (!this.b.isInputShutdown()))
    {
      if (this.b.isOutputShutdown()) {
        return false;
      }
      akd localakd = this.d;
      if (localakd != null) {
        return !localakd.d();
      }
      if (!paramBoolean) {}
    }
    try
    {
      int i1 = this.b.getSoTimeout();
      try
      {
        this.b.setSoTimeout(1);
        paramBoolean = this.e.c();
        return !paramBoolean;
      }
      finally
      {
        this.b.setSoTimeout(i1);
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
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Connection{");
    localStringBuilder.append(this.a.a.a.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.a.a.a.c);
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(" cipherSuite=");
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((aih)localObject).a;
    } else {
      localObject = "none";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.o);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajf
 * JD-Core Version:    0.7.0.1
 */