package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  /* Error */
  private static Platform findPlatform()
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 4
    //   7: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   10: dup
    //   11: aconst_null
    //   12: ldc 90
    //   14: iconst_1
    //   15: anewarray 82	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: getstatic 96	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   27: astore 6
    //   29: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   32: dup
    //   33: aconst_null
    //   34: ldc 101
    //   36: iconst_1
    //   37: anewarray 82	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: ldc 57
    //   44: aastore
    //   45: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   48: astore 7
    //   50: ldc 103
    //   52: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   55: astore_1
    //   56: aload_1
    //   57: ldc 105
    //   59: iconst_1
    //   60: anewarray 82	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc 107
    //   67: aastore
    //   68: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: astore_0
    //   72: aload_1
    //   73: ldc 113
    //   75: iconst_1
    //   76: anewarray 82	java/lang/Class
    //   79: dup
    //   80: iconst_0
    //   81: ldc 107
    //   83: aastore
    //   84: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: astore_1
    //   88: ldc 115
    //   90: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   93: pop
    //   94: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   97: dup
    //   98: ldc 117
    //   100: ldc 119
    //   102: iconst_0
    //   103: anewarray 82	java/lang/Class
    //   106: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   109: astore_2
    //   110: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   113: dup
    //   114: aconst_null
    //   115: ldc 121
    //   117: iconst_1
    //   118: anewarray 82	java/lang/Class
    //   121: dup
    //   122: iconst_0
    //   123: ldc 117
    //   125: aastore
    //   126: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   129: astore 5
    //   131: aload_2
    //   132: astore_3
    //   133: aload 5
    //   135: astore_2
    //   136: new 6	com/squareup/okhttp/internal/Platform$Android
    //   139: dup
    //   140: aload 4
    //   142: aload 6
    //   144: aload 7
    //   146: aload_0
    //   147: aload_1
    //   148: aload_3
    //   149: aload_2
    //   150: invokespecial 124	com/squareup/okhttp/internal/Platform$Android:<init>	(Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   153: areturn
    //   154: astore_0
    //   155: ldc 126
    //   157: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   160: astore 4
    //   162: goto -155 -> 7
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -36 -> 136
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_0
    //   183: astore_2
    //   184: aload_3
    //   185: astore_0
    //   186: aconst_null
    //   187: astore 5
    //   189: aload_0
    //   190: astore_3
    //   191: aload_2
    //   192: astore_0
    //   193: aload 5
    //   195: astore_2
    //   196: goto -60 -> 136
    //   199: astore_0
    //   200: ldc 128
    //   202: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   205: astore_0
    //   206: ldc 130
    //   208: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   211: astore_1
    //   212: new 132	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   219: ldc 130
    //   221: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 139
    //   226: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   235: astore_2
    //   236: new 132	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   243: ldc 130
    //   245: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 142
    //   250: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   259: astore_3
    //   260: new 132	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   267: ldc 130
    //   269: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 144
    //   274: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   283: astore 4
    //   285: new 12	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   288: dup
    //   289: aload_0
    //   290: aload_1
    //   291: ldc 146
    //   293: iconst_2
    //   294: anewarray 82	java/lang/Class
    //   297: dup
    //   298: iconst_0
    //   299: ldc 148
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: aload_2
    //   305: aastore
    //   306: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   309: aload_1
    //   310: ldc 149
    //   312: iconst_1
    //   313: anewarray 82	java/lang/Class
    //   316: dup
    //   317: iconst_0
    //   318: ldc 148
    //   320: aastore
    //   321: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   324: aload_1
    //   325: ldc 151
    //   327: iconst_1
    //   328: anewarray 82	java/lang/Class
    //   331: dup
    //   332: iconst_0
    //   333: ldc 148
    //   335: aastore
    //   336: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   339: aload_3
    //   340: aload 4
    //   342: invokespecial 154	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   345: astore_1
    //   346: aload_1
    //   347: areturn
    //   348: astore_1
    //   349: new 9	com/squareup/okhttp/internal/Platform$JdkPlatform
    //   352: dup
    //   353: aload_0
    //   354: invokespecial 157	com/squareup/okhttp/internal/Platform$JdkPlatform:<init>	(Ljava/lang/Class;)V
    //   357: astore_0
    //   358: aload_0
    //   359: areturn
    //   360: astore_0
    //   361: new 2	com/squareup/okhttp/internal/Platform
    //   364: dup
    //   365: invokespecial 158	com/squareup/okhttp/internal/Platform:<init>	()V
    //   368: areturn
    //   369: astore_1
    //   370: goto -21 -> 349
    //   373: astore_1
    //   374: goto -196 -> 178
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_0
    //   380: aconst_null
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -198 -> 186
    //   387: astore_1
    //   388: aconst_null
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_0
    //   393: astore_2
    //   394: aload_3
    //   395: astore_0
    //   396: goto -210 -> 186
    //   399: astore_2
    //   400: aconst_null
    //   401: astore_3
    //   402: aload_0
    //   403: astore_2
    //   404: aload_3
    //   405: astore_0
    //   406: goto -220 -> 186
    //   409: astore_3
    //   410: aload_0
    //   411: astore_3
    //   412: aload_2
    //   413: astore_0
    //   414: aload_3
    //   415: astore_2
    //   416: goto -230 -> 186
    //   419: astore_3
    //   420: goto -252 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	76	0	localMethod	Method
    //   154	1	0	localClassNotFoundException1	ClassNotFoundException
    //   175	1	0	localClassNotFoundException2	ClassNotFoundException
    //   177	16	0	localObject1	Object
    //   199	1	0	localClassNotFoundException3	ClassNotFoundException
    //   205	154	0	localObject2	Object
    //   360	1	0	localClassNotFoundException4	ClassNotFoundException
    //   377	1	0	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   379	35	0	localObject3	Object
    //   55	292	1	localObject4	Object
    //   348	1	1	localClassNotFoundException5	ClassNotFoundException
    //   369	1	1	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   373	1	1	localClassNotFoundException6	ClassNotFoundException
    //   381	1	1	localObject5	Object
    //   387	1	1	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   391	1	1	localObject6	Object
    //   109	41	2	localObject7	Object
    //   165	1	2	localClassNotFoundException7	ClassNotFoundException
    //   167	227	2	localObject8	Object
    //   399	1	2	localNoSuchMethodException4	java.lang.NoSuchMethodException
    //   403	13	2	localObject9	Object
    //   132	273	3	localObject10	Object
    //   409	1	3	localNoSuchMethodException5	java.lang.NoSuchMethodException
    //   411	4	3	localObject11	Object
    //   419	1	3	localClassNotFoundException8	ClassNotFoundException
    //   5	336	4	localClass	Class
    //   129	65	5	localOptionalMethod1	OptionalMethod
    //   27	116	6	localOptionalMethod2	OptionalMethod
    //   48	97	7	localOptionalMethod3	OptionalMethod
    // Exception table:
    //   from	to	target	type
    //   0	7	154	java/lang/ClassNotFoundException
    //   88	110	165	java/lang/ClassNotFoundException
    //   50	72	175	java/lang/ClassNotFoundException
    //   7	50	199	java/lang/ClassNotFoundException
    //   136	154	199	java/lang/ClassNotFoundException
    //   155	162	199	java/lang/ClassNotFoundException
    //   206	346	348	java/lang/ClassNotFoundException
    //   200	206	360	java/lang/ClassNotFoundException
    //   349	358	360	java/lang/ClassNotFoundException
    //   206	346	369	java/lang/NoSuchMethodException
    //   72	88	373	java/lang/ClassNotFoundException
    //   50	72	377	java/lang/NoSuchMethodException
    //   72	88	387	java/lang/NoSuchMethodException
    //   88	110	399	java/lang/NoSuchMethodException
    //   110	131	409	java/lang/NoSuchMethodException
    //   110	131	419	java/lang/ClassNotFoundException
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if ((localObject == null) || (!paramClass.isInstance(localObject))) {
          break label110;
        }
        localObject = paramClass.cast(localObject);
        return localObject;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    if (!paramString.equals("delegate"))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    return null;
    label110:
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void log(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  static class Android
    extends Platform
  {
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
    {
      this.sslParametersClass = paramClass;
      this.setUseSessionTickets = paramOptionalMethod1;
      this.setHostname = paramOptionalMethod2;
      this.trafficStatsTagSocket = paramMethod1;
      this.trafficStatsUntagSocket = paramMethod2;
      this.getAlpnSelectedProtocol = paramOptionalMethod3;
      this.setAlpnProtocols = paramOptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      if (paramString != null)
      {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
      if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
      {
        paramString = concatLengthPrefixed(paramList);
        this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (Util.isAndroidGetsocknameError(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.getAlpnSelectedProtocol == null) {}
      while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
    }
    
    public void log(String paramString)
    {
      int i = 0;
      int k = paramString.length();
      int j;
      if (i < k)
      {
        j = paramString.indexOf('\n', i);
        if (j == -1) {}
      }
      for (;;)
      {
        int m = Math.min(j, i + 4000);
        Log.d("OkHttp", paramString.substring(i, m));
        if (m >= j)
        {
          i = m + 1;
          break;
          j = k;
          continue;
          return;
        }
        i = m;
      }
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      Object localObject = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
      if (localObject == null) {}
      for (;;)
      {
        try
        {
          paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
          localObject = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
          if (localObject != null) {
            return localObject;
          }
        }
        catch (ClassNotFoundException paramSSLSocketFactory)
        {
          return null;
        }
        return (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
        paramSSLSocketFactory = (SSLSocketFactory)localObject;
      }
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
    {
      TrustRootIndex localTrustRootIndex = AndroidTrustRootIndex.get(paramX509TrustManager);
      if (localTrustRootIndex != null) {
        return localTrustRootIndex;
      }
      return super.trustRootIndex(paramX509TrustManager);
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
  }
  
  static class JdkPlatform
    extends Platform
  {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> paramClass)
    {
      this.sslContextClass = paramClass;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, this.sslContextClass, "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  static class JdkWithJettyBootPlatform
    extends Platform.JdkPlatform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> paramClass1, Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass2, Class<?> paramClass3)
    {
      super();
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.removeMethod = paramMethod3;
      this.clientProviderClass = paramClass2;
      this.serverProviderClass = paramClass3;
    }
    
    public void afterHandshake(SSLSocket paramSSLSocket)
    {
      try
      {
        this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label19:
        break label19;
      }
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int j = paramList.size();
      int i = 0;
      Object localObject;
      if (i < j)
      {
        localObject = (Protocol)paramList.get(i);
        if (localObject == Protocol.HTTP_1_0) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((Protocol)localObject).toString());
        }
      }
      try
      {
        paramList = Platform.class.getClassLoader();
        localObject = this.clientProviderClass;
        Class localClass = this.serverProviderClass;
        paramString = new Platform.JettyNegoProvider(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label147:
        break label147;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (Platform.JettyNegoProvider.access$000(paramSSLSocket)) {
          paramSSLSocket = null;
        } else {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
        }
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        label71:
        break label71;
      }
      return paramSSLSocket;
    }
  }
  
  static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = paramObject.size();
        int i = 0;
        while (i < j)
        {
          if (this.protocols.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.selected = paramObject;
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = paramObject;
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform
 * JD-Core Version:    0.7.0.1
 */