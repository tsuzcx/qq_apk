package com.tencent.moai.mailsdk.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import javax.net.SocketFactory;

public class Socks5ProxySocketFactory
  extends SocketFactory
{
  private String mProxyPassword;
  private int mProxyPort;
  private String mProxyServer;
  private String mProxyUsername;
  
  public Socks5ProxySocketFactory(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mProxyServer = paramString1;
    this.mProxyPort = paramInt;
    this.mProxyUsername = paramString2;
    this.mProxyPassword = paramString3;
  }
  
  private void fill(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, i, paramInt - i);
      if (j <= 0) {
        throw new IOException("ProxySOCKS5, stream is closed");
      }
      i += j;
    }
  }
  
  /* Error */
  private Socket socks5ProxifiedSocket(String paramString, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 17	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:mProxyServer	Ljava/lang/String;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 19	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:mProxyPort	I
    //   13: istore_3
    //   14: aload_0
    //   15: getfield 21	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:mProxyUsername	Ljava/lang/String;
    //   18: astore 8
    //   20: aload_0
    //   21: getfield 23	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:mProxyPassword	Ljava/lang/String;
    //   24: astore 9
    //   26: new 48	java/net/Socket
    //   29: dup
    //   30: aload 6
    //   32: iload_3
    //   33: invokespecial 51	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   36: astore 6
    //   38: aload 6
    //   40: sipush 15000
    //   43: invokevirtual 55	java/net/Socket:setSoTimeout	(I)V
    //   46: aload 6
    //   48: invokevirtual 59	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   51: astore 10
    //   53: aload 6
    //   55: invokevirtual 63	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   58: astore 11
    //   60: aload 6
    //   62: iconst_1
    //   63: invokevirtual 67	java/net/Socket:setTcpNoDelay	(Z)V
    //   66: sipush 1024
    //   69: newarray byte
    //   71: astore 7
    //   73: aload 7
    //   75: iconst_0
    //   76: iconst_5
    //   77: bastore
    //   78: aload 7
    //   80: iconst_1
    //   81: iconst_2
    //   82: bastore
    //   83: aload 7
    //   85: iconst_2
    //   86: iconst_0
    //   87: bastore
    //   88: aload 7
    //   90: iconst_3
    //   91: iconst_2
    //   92: bastore
    //   93: aload 11
    //   95: aload 7
    //   97: iconst_0
    //   98: iconst_4
    //   99: invokevirtual 73	java/io/OutputStream:write	([BII)V
    //   102: aload_0
    //   103: aload 10
    //   105: aload 7
    //   107: iconst_2
    //   108: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   111: aload 7
    //   113: iconst_1
    //   114: baload
    //   115: istore 5
    //   117: iload 4
    //   119: istore_3
    //   120: iload 5
    //   122: sipush 255
    //   125: iand
    //   126: tableswitch	default:+26 -> 152, 0:+28->154, 1:+26->152, 2:+50->176
    //   153: istore_3
    //   154: iload_3
    //   155: ifne +147 -> 302
    //   158: aload 6
    //   160: invokevirtual 78	java/net/Socket:close	()V
    //   163: new 28	java/io/IOException
    //   166: dup
    //   167: ldc 80
    //   169: invokespecial 39	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   172: athrow
    //   173: astore_1
    //   174: aload_1
    //   175: athrow
    //   176: aload 8
    //   178: ifnull -26 -> 152
    //   181: aload 9
    //   183: ifnonnull +8 -> 191
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -34 -> 154
    //   191: aload 7
    //   193: iconst_0
    //   194: iconst_1
    //   195: bastore
    //   196: aload 7
    //   198: iconst_1
    //   199: aload 8
    //   201: invokevirtual 86	java/lang/String:length	()I
    //   204: i2b
    //   205: bastore
    //   206: aload 8
    //   208: invokevirtual 90	java/lang/String:getBytes	()[B
    //   211: iconst_0
    //   212: aload 7
    //   214: iconst_2
    //   215: aload 8
    //   217: invokevirtual 86	java/lang/String:length	()I
    //   220: invokestatic 96	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   223: aload 8
    //   225: invokevirtual 86	java/lang/String:length	()I
    //   228: iconst_2
    //   229: iadd
    //   230: istore_3
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore 5
    //   236: aload 7
    //   238: iload_3
    //   239: aload 9
    //   241: invokevirtual 86	java/lang/String:length	()I
    //   244: i2b
    //   245: bastore
    //   246: aload 9
    //   248: invokevirtual 90	java/lang/String:getBytes	()[B
    //   251: iconst_0
    //   252: aload 7
    //   254: iload 5
    //   256: aload 9
    //   258: invokevirtual 86	java/lang/String:length	()I
    //   261: invokestatic 96	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   264: aload 11
    //   266: aload 7
    //   268: iconst_0
    //   269: aload 9
    //   271: invokevirtual 86	java/lang/String:length	()I
    //   274: iload 5
    //   276: iadd
    //   277: invokevirtual 73	java/io/OutputStream:write	([BII)V
    //   280: aload_0
    //   281: aload 10
    //   283: aload 7
    //   285: iconst_2
    //   286: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   289: aload 7
    //   291: iconst_1
    //   292: baload
    //   293: ifne -141 -> 152
    //   296: iload 4
    //   298: istore_3
    //   299: goto -145 -> 154
    //   302: aload 7
    //   304: iconst_0
    //   305: iconst_5
    //   306: bastore
    //   307: aload 7
    //   309: iconst_1
    //   310: iconst_1
    //   311: bastore
    //   312: aload 7
    //   314: iconst_2
    //   315: iconst_0
    //   316: bastore
    //   317: aload_1
    //   318: invokevirtual 90	java/lang/String:getBytes	()[B
    //   321: astore_1
    //   322: aload_1
    //   323: arraylength
    //   324: istore_3
    //   325: aload 7
    //   327: iconst_3
    //   328: iconst_3
    //   329: bastore
    //   330: aload 7
    //   332: iconst_4
    //   333: iload_3
    //   334: i2b
    //   335: bastore
    //   336: aload_1
    //   337: iconst_0
    //   338: aload 7
    //   340: iconst_5
    //   341: iload_3
    //   342: invokestatic 96	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   345: iload_3
    //   346: iconst_5
    //   347: iadd
    //   348: istore_3
    //   349: iload_3
    //   350: iconst_1
    //   351: iadd
    //   352: istore 4
    //   354: aload 7
    //   356: iload_3
    //   357: iload_2
    //   358: bipush 8
    //   360: iushr
    //   361: i2b
    //   362: bastore
    //   363: aload 7
    //   365: iload 4
    //   367: iload_2
    //   368: sipush 255
    //   371: iand
    //   372: i2b
    //   373: bastore
    //   374: aload 11
    //   376: aload 7
    //   378: iconst_0
    //   379: iload 4
    //   381: iconst_1
    //   382: iadd
    //   383: invokevirtual 73	java/io/OutputStream:write	([BII)V
    //   386: aload_0
    //   387: aload 10
    //   389: aload 7
    //   391: iconst_4
    //   392: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   395: aload 7
    //   397: iconst_1
    //   398: baload
    //   399: istore_2
    //   400: iload_2
    //   401: ifeq +60 -> 461
    //   404: aload 6
    //   406: invokevirtual 78	java/net/Socket:close	()V
    //   409: new 28	java/io/IOException
    //   412: dup
    //   413: new 98	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   420: ldc 101
    //   422: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 7
    //   427: iconst_1
    //   428: baload
    //   429: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokespecial 39	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   438: athrow
    //   439: astore_1
    //   440: aload 6
    //   442: ifnull +8 -> 450
    //   445: aload 6
    //   447: invokevirtual 78	java/net/Socket:close	()V
    //   450: new 28	java/io/IOException
    //   453: dup
    //   454: ldc 114
    //   456: aload_1
    //   457: invokespecial 117	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   460: athrow
    //   461: aload 7
    //   463: iconst_3
    //   464: baload
    //   465: sipush 255
    //   468: iand
    //   469: tableswitch	default:+107 -> 576, 1:+31->500, 2:+107->576, 3:+44->513, 4:+74->543
    //   501: aload 10
    //   503: aload 7
    //   505: bipush 6
    //   507: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   510: aload 6
    //   512: areturn
    //   513: aload_0
    //   514: aload 10
    //   516: aload 7
    //   518: iconst_1
    //   519: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   522: aload_0
    //   523: aload 10
    //   525: aload 7
    //   527: aload 7
    //   529: iconst_0
    //   530: baload
    //   531: sipush 255
    //   534: iand
    //   535: iconst_2
    //   536: iadd
    //   537: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   540: aload 6
    //   542: areturn
    //   543: aload_0
    //   544: aload 10
    //   546: aload 7
    //   548: bipush 18
    //   550: invokespecial 75	com/tencent/moai/mailsdk/net/Socks5ProxySocketFactory:fill	(Ljava/io/InputStream;[BI)V
    //   553: aload 6
    //   555: areturn
    //   556: astore_1
    //   557: goto -394 -> 163
    //   560: astore_1
    //   561: goto -152 -> 409
    //   564: astore 6
    //   566: goto -116 -> 450
    //   569: astore_1
    //   570: aconst_null
    //   571: astore 6
    //   573: goto -133 -> 440
    //   576: aload 6
    //   578: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	Socks5ProxySocketFactory
    //   0	579	1	paramString	String
    //   0	579	2	paramInt	int
    //   13	344	3	i	int
    //   1	382	4	j	int
    //   115	162	5	k	int
    //   7	547	6	localObject	java.lang.Object
    //   564	1	6	localException	Exception
    //   571	6	6	localSocket	Socket
    //   71	476	7	arrayOfByte	byte[]
    //   18	206	8	str1	String
    //   24	246	9	str2	String
    //   51	494	10	localInputStream	InputStream
    //   58	317	11	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   26	38	173	java/lang/RuntimeException
    //   38	73	173	java/lang/RuntimeException
    //   93	111	173	java/lang/RuntimeException
    //   158	163	173	java/lang/RuntimeException
    //   163	173	173	java/lang/RuntimeException
    //   196	231	173	java/lang/RuntimeException
    //   236	289	173	java/lang/RuntimeException
    //   317	325	173	java/lang/RuntimeException
    //   336	345	173	java/lang/RuntimeException
    //   374	395	173	java/lang/RuntimeException
    //   404	409	173	java/lang/RuntimeException
    //   409	439	173	java/lang/RuntimeException
    //   500	510	173	java/lang/RuntimeException
    //   513	540	173	java/lang/RuntimeException
    //   543	553	173	java/lang/RuntimeException
    //   38	73	439	java/lang/Exception
    //   93	111	439	java/lang/Exception
    //   163	173	439	java/lang/Exception
    //   196	231	439	java/lang/Exception
    //   236	289	439	java/lang/Exception
    //   317	325	439	java/lang/Exception
    //   336	345	439	java/lang/Exception
    //   374	395	439	java/lang/Exception
    //   409	439	439	java/lang/Exception
    //   500	510	439	java/lang/Exception
    //   513	540	439	java/lang/Exception
    //   543	553	439	java/lang/Exception
    //   158	163	556	java/lang/Exception
    //   404	409	560	java/lang/Exception
    //   445	450	564	java/lang/Exception
    //   26	38	569	java/lang/Exception
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return socks5ProxifiedSocket(paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    try
    {
      paramInetAddress = socks5ProxifiedSocket(paramString, paramInt1);
      return paramInetAddress;
    }
    catch (Exception paramInetAddress)
    {
      if ((paramInetAddress.getCause() instanceof SocketTimeoutException)) {
        return socks5ProxifiedSocket(paramString, paramInt1);
      }
      throw paramInetAddress;
    }
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return socks5ProxifiedSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return socks5ProxifiedSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.Socks5ProxySocketFactory
 * JD-Core Version:    0.7.0.1
 */