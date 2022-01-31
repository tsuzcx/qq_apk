package com.tencent.apkupdate.b;

import org.apache.http.client.HttpClient;

public final class a
{
  private static String a = "10.0.0.172";
  private static int b = 80;
  private static String c = "10.0.0.200";
  private static HttpClient d = null;
  
  /* Error */
  public static HttpClient a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/apkupdate/b/a:d	Lorg/apache/http/client/HttpClient;
    //   6: ifnonnull +136 -> 142
    //   9: new 29	org/apache/http/params/BasicHttpParams
    //   12: dup
    //   13: invokespecial 32	org/apache/http/params/BasicHttpParams:<init>	()V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc2_w 33
    //   21: invokestatic 40	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   24: aload_0
    //   25: sipush 200
    //   28: invokestatic 44	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   31: aload_0
    //   32: new 46	org/apache/http/conn/params/ConnPerRouteBean
    //   35: dup
    //   36: bipush 20
    //   38: invokespecial 49	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   41: invokestatic 53	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   44: aload_0
    //   45: sipush 30000
    //   48: invokestatic 58	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   51: aload_0
    //   52: sipush 30000
    //   55: invokestatic 61	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   58: aload_0
    //   59: iconst_1
    //   60: invokestatic 67	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   63: aload_0
    //   64: iconst_1
    //   65: invokestatic 72	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   68: aload_0
    //   69: sipush 4096
    //   72: invokestatic 75	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   75: new 77	org/apache/http/conn/scheme/SchemeRegistry
    //   78: dup
    //   79: invokespecial 78	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: new 80	org/apache/http/conn/scheme/Scheme
    //   87: dup
    //   88: ldc 82
    //   90: invokestatic 88	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   93: bipush 80
    //   95: invokespecial 91	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   98: invokevirtual 95	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   101: pop
    //   102: aload_1
    //   103: new 80	org/apache/http/conn/scheme/Scheme
    //   106: dup
    //   107: ldc 97
    //   109: invokestatic 102	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   112: sipush 443
    //   115: invokespecial 91	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   118: invokevirtual 95	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   121: pop
    //   122: new 104	org/apache/http/impl/client/DefaultHttpClient
    //   125: dup
    //   126: new 106	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   129: dup
    //   130: aload_0
    //   131: aload_1
    //   132: invokespecial 109	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   135: aload_0
    //   136: invokespecial 112	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   139: putstatic 25	com/tencent/apkupdate/b/a:d	Lorg/apache/http/client/HttpClient;
    //   142: getstatic 25	com/tencent/apkupdate/b/a:d	Lorg/apache/http/client/HttpClient;
    //   145: astore_1
    //   146: invokestatic 117	com/tencent/apkupdate/c/b:a	()Lcom/tencent/apkupdate/c/b;
    //   149: invokevirtual 120	com/tencent/apkupdate/c/b:b	()Landroid/content/Context;
    //   152: astore_0
    //   153: aload_0
    //   154: ifnonnull +78 -> 232
    //   157: ldc 122
    //   159: astore_0
    //   160: aload_0
    //   161: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +59 -> 223
    //   167: aload_0
    //   168: ldc 130
    //   170: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   173: ifne +21 -> 194
    //   176: aload_0
    //   177: ldc 138
    //   179: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   182: ifne +12 -> 194
    //   185: aload_0
    //   186: ldc 140
    //   188: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq +117 -> 308
    //   194: new 142	org/apache/http/HttpHost
    //   197: dup
    //   198: getstatic 17	com/tencent/apkupdate/b/a:a	Ljava/lang/String;
    //   201: getstatic 19	com/tencent/apkupdate/b/a:b	I
    //   204: invokespecial 145	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   207: astore_0
    //   208: aload_1
    //   209: invokeinterface 151 1 0
    //   214: ldc 153
    //   216: aload_0
    //   217: invokeinterface 159 3 0
    //   222: pop
    //   223: getstatic 25	com/tencent/apkupdate/b/a:d	Lorg/apache/http/client/HttpClient;
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: areturn
    //   232: aload_0
    //   233: ldc 161
    //   235: invokevirtual 167	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   238: iconst_m1
    //   239: if_icmpne +9 -> 248
    //   242: ldc 122
    //   244: astore_0
    //   245: goto -85 -> 160
    //   248: aload_0
    //   249: ldc 169
    //   251: invokevirtual 173	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   254: checkcast 175	android/net/ConnectivityManager
    //   257: invokevirtual 179	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   260: astore_0
    //   261: aload_0
    //   262: ifnonnull +9 -> 271
    //   265: ldc 122
    //   267: astore_0
    //   268: goto -108 -> 160
    //   271: aload_0
    //   272: invokevirtual 185	android/net/NetworkInfo:getType	()I
    //   275: iconst_1
    //   276: if_icmpne +9 -> 285
    //   279: ldc 187
    //   281: astore_0
    //   282: goto -122 -> 160
    //   285: aload_0
    //   286: invokevirtual 191	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   289: astore_0
    //   290: aload_0
    //   291: ifnonnull +9 -> 300
    //   294: ldc 122
    //   296: astore_0
    //   297: goto -137 -> 160
    //   300: aload_0
    //   301: invokevirtual 194	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   304: astore_0
    //   305: goto -145 -> 160
    //   308: aload_0
    //   309: ldc 196
    //   311: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   314: ifeq -91 -> 223
    //   317: new 142	org/apache/http/HttpHost
    //   320: dup
    //   321: getstatic 23	com/tencent/apkupdate/b/a:c	Ljava/lang/String;
    //   324: getstatic 19	com/tencent/apkupdate/b/a:b	I
    //   327: invokespecial 145	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   330: astore_0
    //   331: aload_1
    //   332: invokeinterface 151 1 0
    //   337: ldc 153
    //   339: aload_0
    //   340: invokeinterface 159 3 0
    //   345: pop
    //   346: goto -123 -> 223
    //   349: astore_0
    //   350: ldc 2
    //   352: monitorexit
    //   353: aload_0
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	324	0	localObject1	Object
    //   349	5	0	localObject2	Object
    //   82	250	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	142	349	finally
    //   142	153	349	finally
    //   160	194	349	finally
    //   194	223	349	finally
    //   223	227	349	finally
    //   232	242	349	finally
    //   248	261	349	finally
    //   271	279	349	finally
    //   285	290	349	finally
    //   300	305	349	finally
    //   308	346	349	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.a
 * JD-Core Version:    0.7.0.1
 */