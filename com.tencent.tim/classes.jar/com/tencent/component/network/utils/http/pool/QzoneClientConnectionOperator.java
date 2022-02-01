package com.tencent.component.network.utils.http.pool;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class QzoneClientConnectionOperator
  extends DefaultClientConnectionOperator
{
  private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
  private final CustomDnsResolve customDnsResolve;
  
  public QzoneClientConnectionOperator(SchemeRegistry paramSchemeRegistry, CustomDnsResolve paramCustomDnsResolve)
  {
    super(paramSchemeRegistry);
    this.customDnsResolve = paramCustomDnsResolve;
  }
  
  /* Error */
  public void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, java.net.InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 36	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 38
    //   10: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: new 36	java/lang/IllegalArgumentException
    //   21: dup
    //   22: ldc 43
    //   24: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: aload 5
    //   30: ifnonnull +13 -> 43
    //   33: new 36	java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc 45
    //   39: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: aload_1
    //   44: invokeinterface 51 1 0
    //   49: ifeq +13 -> 62
    //   52: new 36	java/lang/IllegalArgumentException
    //   55: dup
    //   56: ldc 53
    //   58: invokespecial 41	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: aload_0
    //   63: getfield 57	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:schemeRegistry	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   66: aload_2
    //   67: invokevirtual 63	org/apache/http/HttpHost:getSchemeName	()Ljava/lang/String;
    //   70: invokevirtual 69	org/apache/http/conn/scheme/SchemeRegistry:getScheme	(Ljava/lang/String;)Lorg/apache/http/conn/scheme/Scheme;
    //   73: astore 14
    //   75: ldc 71
    //   77: aload_2
    //   78: invokevirtual 63	org/apache/http/HttpHost:getSchemeName	()Ljava/lang/String;
    //   81: invokevirtual 77	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   84: ifne +15 -> 99
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: aload_3
    //   91: aload 4
    //   93: aload 5
    //   95: invokespecial 79	org/apache/http/impl/conn/DefaultClientConnectionOperator:openConnection	(Lorg/apache/http/conn/OperatedClientConnection;Lorg/apache/http/HttpHost;Ljava/net/InetAddress;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   98: return
    //   99: aload 14
    //   101: invokevirtual 85	org/apache/http/conn/scheme/Scheme:getSocketFactory	()Lorg/apache/http/conn/scheme/SocketFactory;
    //   104: astore 11
    //   106: aload 11
    //   108: instanceof 87
    //   111: ifeq +97 -> 208
    //   114: getstatic 17	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:staticPlainSocketFactory	Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   117: astore 8
    //   119: aload 11
    //   121: checkcast 87	org/apache/http/conn/scheme/LayeredSocketFactory
    //   124: astore 9
    //   126: aload_0
    //   127: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   130: ifnull +88 -> 218
    //   133: aload_0
    //   134: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   137: aload_2
    //   138: invokevirtual 90	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   141: invokevirtual 96	com/tencent/component/network/utils/http/pool/CustomDnsResolve:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   144: astore 7
    //   146: ldc 98
    //   148: astore 10
    //   150: aload 7
    //   152: ifnull +97 -> 249
    //   155: iconst_0
    //   156: istore 6
    //   158: iload 6
    //   160: aload 7
    //   162: arraylength
    //   163: if_icmpge +61 -> 224
    //   166: new 100	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   173: aload 10
    //   175: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 7
    //   180: iload 6
    //   182: aaload
    //   183: invokevirtual 110	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   186: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 112
    //   191: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 10
    //   199: iload 6
    //   201: iconst_1
    //   202: iadd
    //   203: istore 6
    //   205: goto -47 -> 158
    //   208: aconst_null
    //   209: astore 9
    //   211: aload 11
    //   213: astore 8
    //   215: goto -89 -> 126
    //   218: aconst_null
    //   219: astore 7
    //   221: goto -75 -> 146
    //   224: ldc 117
    //   226: new 100	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   233: ldc 119
    //   235: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 10
    //   240: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 125	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 7
    //   251: ifnull +9 -> 260
    //   254: aload 7
    //   256: arraylength
    //   257: ifgt +313 -> 570
    //   260: aload_2
    //   261: invokevirtual 90	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   264: invokestatic 126	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   267: astore 7
    //   269: iconst_0
    //   270: istore 6
    //   272: iload 6
    //   274: aload 7
    //   276: arraylength
    //   277: if_icmpge -179 -> 98
    //   280: aload 8
    //   282: invokeinterface 132 1 0
    //   287: astore 12
    //   289: aload_1
    //   290: aload 12
    //   292: aload_2
    //   293: invokeinterface 136 3 0
    //   298: aload 8
    //   300: aload 12
    //   302: aload 7
    //   304: iload 6
    //   306: aaload
    //   307: invokevirtual 110	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   310: aload 14
    //   312: aload_2
    //   313: invokevirtual 140	org/apache/http/HttpHost:getPort	()I
    //   316: invokevirtual 144	org/apache/http/conn/scheme/Scheme:resolvePort	(I)I
    //   319: aload_3
    //   320: iconst_0
    //   321: aload 5
    //   323: invokeinterface 148 7 0
    //   328: astore 13
    //   330: aload 12
    //   332: astore 10
    //   334: aload 12
    //   336: aload 13
    //   338: if_acmpeq +16 -> 354
    //   341: aload_1
    //   342: aload 13
    //   344: aload_2
    //   345: invokeinterface 136 3 0
    //   350: aload 13
    //   352: astore 10
    //   354: aload 9
    //   356: ifnull +162 -> 518
    //   359: aload 9
    //   361: aload 10
    //   363: aload_2
    //   364: invokevirtual 90	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   367: aload 14
    //   369: aload_2
    //   370: invokevirtual 140	org/apache/http/HttpHost:getPort	()I
    //   373: invokevirtual 144	org/apache/http/conn/scheme/Scheme:resolvePort	(I)I
    //   376: iconst_1
    //   377: invokeinterface 151 5 0
    //   382: astore 12
    //   384: aload 12
    //   386: aload 10
    //   388: if_acmpeq +12 -> 400
    //   391: aload_1
    //   392: aload 12
    //   394: aload_2
    //   395: invokeinterface 136 3 0
    //   400: aload_0
    //   401: aload 12
    //   403: aload 4
    //   405: aload 5
    //   407: invokevirtual 155	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:prepareSocket	(Ljava/net/Socket;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   410: aload_1
    //   411: aload 11
    //   413: aload 12
    //   415: invokeinterface 159 2 0
    //   420: aload 5
    //   422: invokeinterface 163 3 0
    //   427: return
    //   428: astore 10
    //   430: iload 6
    //   432: aload 7
    //   434: arraylength
    //   435: iconst_1
    //   436: isub
    //   437: if_icmpne +124 -> 561
    //   440: new 165	org/apache/http/conn/HttpHostConnectException
    //   443: dup
    //   444: aload_2
    //   445: aload 10
    //   447: invokespecial 168	org/apache/http/conn/HttpHostConnectException:<init>	(Lorg/apache/http/HttpHost;Ljava/net/ConnectException;)V
    //   450: athrow
    //   451: astore 10
    //   453: aload_0
    //   454: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   457: ifnull +58 -> 515
    //   460: ldc 117
    //   462: ldc 170
    //   464: aload 10
    //   466: invokestatic 174	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   469: aload_0
    //   470: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   473: aload_2
    //   474: invokevirtual 90	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   477: invokevirtual 177	com/tencent/component/network/utils/http/pool/CustomDnsResolve:resolveByDns	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   480: astore 7
    //   482: aload 7
    //   484: ifnull +9 -> 493
    //   487: aload 7
    //   489: arraylength
    //   490: ifgt +15 -> 505
    //   493: ldc 117
    //   495: ldc 170
    //   497: aload 10
    //   499: invokestatic 174	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   502: aload 10
    //   504: athrow
    //   505: ldc 117
    //   507: ldc 179
    //   509: invokestatic 181	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -243 -> 269
    //   515: aload 10
    //   517: athrow
    //   518: aload_0
    //   519: aload 10
    //   521: aload 4
    //   523: aload 5
    //   525: invokevirtual 155	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:prepareSocket	(Ljava/net/Socket;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   528: aload_1
    //   529: aload 11
    //   531: aload 10
    //   533: invokeinterface 159 2 0
    //   538: aload 5
    //   540: invokeinterface 163 3 0
    //   545: return
    //   546: astore 10
    //   548: iload 6
    //   550: aload 7
    //   552: arraylength
    //   553: iconst_1
    //   554: isub
    //   555: if_icmpne +6 -> 561
    //   558: aload 10
    //   560: athrow
    //   561: iload 6
    //   563: iconst_1
    //   564: iadd
    //   565: istore 6
    //   567: goto -295 -> 272
    //   570: goto -301 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	QzoneClientConnectionOperator
    //   0	573	1	paramOperatedClientConnection	OperatedClientConnection
    //   0	573	2	paramHttpHost	HttpHost
    //   0	573	3	paramInetAddress	java.net.InetAddress
    //   0	573	4	paramHttpContext	HttpContext
    //   0	573	5	paramHttpParams	HttpParams
    //   156	410	6	i	int
    //   144	407	7	arrayOfInetAddress	java.net.InetAddress[]
    //   117	182	8	localObject1	java.lang.Object
    //   124	236	9	localLayeredSocketFactory	org.apache.http.conn.scheme.LayeredSocketFactory
    //   148	239	10	localObject2	java.lang.Object
    //   428	18	10	localConnectException	java.net.ConnectException
    //   451	81	10	localThrowable	java.lang.Throwable
    //   546	13	10	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   104	426	11	localSocketFactory	org.apache.http.conn.scheme.SocketFactory
    //   287	127	12	localSocket1	Socket
    //   328	23	13	localSocket2	Socket
    //   73	295	14	localScheme	org.apache.http.conn.scheme.Scheme
    // Exception table:
    //   from	to	target	type
    //   298	330	428	java/net/ConnectException
    //   341	350	428	java/net/ConnectException
    //   359	384	428	java/net/ConnectException
    //   391	400	428	java/net/ConnectException
    //   400	427	428	java/net/ConnectException
    //   518	545	428	java/net/ConnectException
    //   260	269	451	java/lang/Throwable
    //   298	330	546	org/apache/http/conn/ConnectTimeoutException
    //   341	350	546	org/apache/http/conn/ConnectTimeoutException
    //   359	384	546	org/apache/http/conn/ConnectTimeoutException
    //   391	400	546	org/apache/http/conn/ConnectTimeoutException
    //   400	427	546	org/apache/http/conn/ConnectTimeoutException
    //   518	545	546	org/apache/http/conn/ConnectTimeoutException
  }
  
  protected void prepareSocket(Socket paramSocket, HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    super.prepareSocket(paramSocket, paramHttpContext, paramHttpParams);
  }
  
  public void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    super.updateSecureConnection(paramOperatedClientConnection, paramHttpHost, paramHttpContext, paramHttpParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.QzoneClientConnectionOperator
 * JD-Core Version:    0.7.0.1
 */