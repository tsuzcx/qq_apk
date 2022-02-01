package com.tencent.qapmsdk.impl.instrumentation;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.harvest.HttpLibType;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingInputStream;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingOutputStream;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class QAPMHttpsURLConnectionExtension
  extends HttpsURLConnection
{
  private static final String TAG = "QAPM_Impl_QAPMHttpsURLConnectionExtension";
  private HttpsURLConnection impl;
  QAPMCountingInputStream qapmCountingInputStream;
  private QAPMTransactionState transactionState;
  
  public QAPMHttpsURLConnectionExtension(@NonNull HttpsURLConnection paramHttpsURLConnection)
  {
    super(paramHttpsURLConnection.getURL());
    this.impl = paramHttpsURLConnection;
    getTransactionState();
    try
    {
      if (TraceUtil.getCanMonitorHttp()) {
        this.transactionState.setAppPhase(0);
      }
      return;
    }
    catch (Exception paramHttpsURLConnection)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMHttpsURLConnectionExtension has an error : ", paramHttpsURLConnection);
    }
  }
  
  /* Error */
  private void addTransactionAndErrorData(QAPMTransactionState paramQAPMTransactionState)
  {
    // Byte code:
    //   0: invokestatic 38	com/tencent/qapmsdk/impl/util/TraceUtil:getCanMonitorHttp	()Z
    //   3: istore_2
    //   4: iload_2
    //   5: ifne +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   14: invokevirtual 78	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   17: invokestatic 84	com/tencent/qapmsdk/impl/util/StringUtil:contentType	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 88	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setContentType	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 92	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:end	()Lcom/tencent/qapmsdk/impl/api/data/TransactionData;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -23 -> 8
    //   34: aload 4
    //   36: invokevirtual 98	com/tencent/qapmsdk/impl/api/data/TransactionData:getStatusCode	()I
    //   39: i2l
    //   40: ldc2_w 99
    //   43: lcmp
    //   44: iflt +240 -> 284
    //   47: new 102	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   54: astore_3
    //   55: aload_0
    //   56: invokevirtual 109	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:getErrorStream	()Ljava/io/InputStream;
    //   59: astore 5
    //   61: aload 5
    //   63: instanceof 111
    //   66: ifeq +16 -> 82
    //   69: aload_3
    //   70: aload 5
    //   72: checkcast 111	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream
    //   75: invokevirtual 114	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream:getBufferAsString	()Ljava/lang/String;
    //   78: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   86: invokevirtual 122	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   89: ifnull +187 -> 276
    //   92: aload_0
    //   93: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   96: invokevirtual 122	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   99: invokeinterface 127 1 0
    //   104: ifle +172 -> 276
    //   107: new 129	java/util/TreeMap
    //   110: dup
    //   111: invokespecial 130	java/util/TreeMap:<init>	()V
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   120: invokevirtual 122	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   123: astore_3
    //   124: aload_3
    //   125: invokeinterface 134 1 0
    //   130: invokeinterface 140 1 0
    //   135: astore 6
    //   137: aload 6
    //   139: invokeinterface 145 1 0
    //   144: ifeq +52 -> 196
    //   147: aload 6
    //   149: invokeinterface 149 1 0
    //   154: checkcast 151	java/lang/String
    //   157: astore 7
    //   159: aload 7
    //   161: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne -27 -> 137
    //   167: aload 5
    //   169: aload 7
    //   171: aload_3
    //   172: aload 7
    //   174: invokeinterface 161 2 0
    //   179: checkcast 163	java/util/List
    //   182: iconst_0
    //   183: invokeinterface 166 2 0
    //   188: invokevirtual 170	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: goto -55 -> 137
    //   195: astore_3
    //   196: ldc 172
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 175	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   203: ifnull +8 -> 211
    //   206: aload_1
    //   207: invokevirtual 175	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   210: astore_3
    //   211: aload 4
    //   213: aload 5
    //   215: aload_3
    //   216: invokestatic 181	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;Ljava/util/TreeMap;Ljava/lang/String;)V
    //   219: return
    //   220: astore_1
    //   221: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   224: ldc 8
    //   226: ldc 183
    //   228: aload_1
    //   229: invokevirtual 58	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: return
    //   233: astore_3
    //   234: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   237: ldc 8
    //   239: ldc 185
    //   241: aload_3
    //   242: invokevirtual 58	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -222 -> 23
    //   248: astore 5
    //   250: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   253: iconst_2
    //   254: anewarray 151	java/lang/String
    //   257: dup
    //   258: iconst_0
    //   259: ldc 8
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload 5
    //   266: invokevirtual 188	java/lang/Exception:toString	()Ljava/lang/String;
    //   269: aastore
    //   270: invokevirtual 192	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   273: goto -191 -> 82
    //   276: aload_3
    //   277: ldc 194
    //   279: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: return
    //   284: aload 4
    //   286: invokestatic 197	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;)V
    //   289: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	QAPMHttpsURLConnectionExtension
    //   0	290	1	paramQAPMTransactionState	QAPMTransactionState
    //   3	2	2	bool	boolean
    //   54	118	3	localObject1	Object
    //   195	1	3	localException1	Exception
    //   198	18	3	str1	String
    //   233	44	3	localException2	Exception
    //   27	258	4	localTransactionData	com.tencent.qapmsdk.impl.api.data.TransactionData
    //   59	155	5	localObject2	Object
    //   248	17	5	localException3	Exception
    //   135	13	6	localIterator	java.util.Iterator
    //   157	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   116	137	195	java/lang/Exception
    //   137	192	195	java/lang/Exception
    //   0	4	220	java/lang/Exception
    //   23	29	220	java/lang/Exception
    //   34	55	220	java/lang/Exception
    //   82	116	220	java/lang/Exception
    //   199	211	220	java/lang/Exception
    //   211	219	220	java/lang/Exception
    //   234	245	220	java/lang/Exception
    //   250	273	220	java/lang/Exception
    //   276	283	220	java/lang/Exception
    //   284	289	220	java/lang/Exception
    //   9	23	233	java/lang/Exception
    //   55	82	248	java/lang/Exception
  }
  
  private void checkResponse()
  {
    if (!getTransactionState().isComplete()) {
      QAPMTransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
    }
  }
  
  /* Error */
  private void error(Exception paramException)
  {
    // Byte code:
    //   0: invokestatic 38	com/tencent/qapmsdk/impl/util/TraceUtil:getCanMonitorHttp	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokespecial 32	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:getTransactionState	()Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   17: invokevirtual 78	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   20: invokestatic 84	com/tencent/qapmsdk/impl/util/StringUtil:contentType	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokevirtual 88	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setContentType	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +18 -> 45
    //   30: aload_2
    //   31: getfield 211	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:hasParseUrlParams	Z
    //   34: ifne +11 -> 45
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   42: invokestatic 214	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionStateUtil:processUrlParams	(Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;Ljava/net/HttpURLConnection;)V
    //   45: aload_2
    //   46: aload_1
    //   47: invokestatic 218	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionStateUtil:setErrorCodeFromException	(Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;Ljava/lang/Exception;)V
    //   50: aload_2
    //   51: invokevirtual 201	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isComplete	()Z
    //   54: ifne +91 -> 145
    //   57: ldc 172
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 175	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   64: ifnull +8 -> 72
    //   67: aload_2
    //   68: invokevirtual 175	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 28	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpsURLConnectionExtension:impl	Ljavax/net/ssl/HttpsURLConnection;
    //   77: invokestatic 207	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionStateUtil:inspectAndInstrumentResponse	(Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;Ljava/net/HttpURLConnection;)V
    //   80: aload_2
    //   81: invokevirtual 92	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:end	()Lcom/tencent/qapmsdk/impl/api/data/TransactionData;
    //   84: astore_3
    //   85: aload_2
    //   86: invokevirtual 221	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isError	()Z
    //   89: ifeq +52 -> 141
    //   92: aload_3
    //   93: aload_1
    //   94: invokestatic 224	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;Ljava/lang/String;)V
    //   97: return
    //   98: astore_1
    //   99: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   102: ldc 8
    //   104: ldc 226
    //   106: aload_1
    //   107: invokevirtual 58	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: return
    //   111: astore_3
    //   112: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   115: ldc 8
    //   117: ldc 228
    //   119: aload_3
    //   120: invokevirtual 58	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: goto -97 -> 26
    //   126: astore_3
    //   127: getstatic 52	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   130: ldc 8
    //   132: ldc 230
    //   134: aload_3
    //   135: invokevirtual 58	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: goto -93 -> 45
    //   141: aload_3
    //   142: invokestatic 197	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;)V
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	QAPMHttpsURLConnectionExtension
    //   0	146	1	paramException	Exception
    //   11	75	2	localQAPMTransactionState	QAPMTransactionState
    //   84	9	3	localTransactionData	com.tencent.qapmsdk.impl.api.data.TransactionData
    //   111	9	3	localException1	Exception
    //   126	16	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	98	java/lang/Exception
    //   7	12	98	java/lang/Exception
    //   45	57	98	java/lang/Exception
    //   60	72	98	java/lang/Exception
    //   72	97	98	java/lang/Exception
    //   112	123	98	java/lang/Exception
    //   127	138	98	java/lang/Exception
    //   141	145	98	java/lang/Exception
    //   12	26	111	java/lang/Exception
    //   30	45	126	java/lang/Exception
  }
  
  private QAPMTransactionState getTransactionState()
  {
    if (this.transactionState == null)
    {
      this.transactionState = new QAPMTransactionState();
      QAPMTransactionStateUtil.setUrlAndCarrier(this.transactionState, this.impl);
    }
    return this.transactionState;
  }
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.impl.addRequestProperty(paramString1, paramString2);
  }
  
  public void connect()
    throws IOException
  {
    getTransactionState();
    try
    {
      this.impl.connect();
      return;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public void disconnect()
  {
    if ((this.transactionState != null) && (!this.transactionState.isComplete())) {
      addTransactionAndErrorData(this.transactionState);
    }
    this.impl.disconnect();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.impl.getAllowUserInteraction();
  }
  
  public String getCipherSuite()
  {
    return this.impl.getCipherSuite();
  }
  
  public int getConnectTimeout()
  {
    return this.impl.getConnectTimeout();
  }
  
  public Object getContent()
    throws IOException
  {
    getTransactionState();
    try
    {
      Object localObject = this.impl.getContent();
      int i = this.impl.getContentLength();
      if (i >= 0)
      {
        QAPMTransactionState localQAPMTransactionState = getTransactionState();
        if (!localQAPMTransactionState.isComplete())
        {
          localQAPMTransactionState.setBytesReceived(i);
          addTransactionAndErrorData(localQAPMTransactionState);
        }
      }
      return localObject;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public Object getContent(Class[] paramArrayOfClass)
    throws IOException
  {
    getTransactionState();
    try
    {
      paramArrayOfClass = this.impl.getContent(paramArrayOfClass);
      checkResponse();
      return paramArrayOfClass;
    }
    catch (IOException paramArrayOfClass)
    {
      error(paramArrayOfClass);
      throw paramArrayOfClass;
    }
  }
  
  public String getContentEncoding()
  {
    getTransactionState();
    String str = this.impl.getContentEncoding();
    checkResponse();
    return str;
  }
  
  public int getContentLength()
  {
    getTransactionState();
    int i = this.impl.getContentLength();
    checkResponse();
    return i;
  }
  
  public String getContentType()
  {
    getTransactionState();
    String str = this.impl.getContentType();
    checkResponse();
    return str;
  }
  
  public long getDate()
  {
    getTransactionState();
    long l = this.impl.getDate();
    checkResponse();
    return l;
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.impl.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.impl.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.impl.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    getTransactionState();
    if (this.qapmCountingInputStream != null) {
      return this.qapmCountingInputStream;
    }
    try
    {
      this.qapmCountingInputStream = new QAPMCountingInputStream(this.impl.getErrorStream(), true);
      return this.qapmCountingInputStream;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpsURLConnectionExtension", localException.toString() });
    }
    return this.impl.getErrorStream();
  }
  
  public long getExpiration()
  {
    getTransactionState();
    long l = this.impl.getExpiration();
    checkResponse();
    return l;
  }
  
  public String getHeaderField(int paramInt)
  {
    getTransactionState();
    String str = this.impl.getHeaderField(paramInt);
    checkResponse();
    return str;
  }
  
  public String getHeaderField(String paramString)
  {
    getTransactionState();
    paramString = this.impl.getHeaderField(paramString);
    checkResponse();
    return paramString;
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    getTransactionState();
    paramLong = this.impl.getHeaderFieldDate(paramString, paramLong);
    checkResponse();
    return paramLong;
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    getTransactionState();
    paramInt = this.impl.getHeaderFieldInt(paramString, paramInt);
    checkResponse();
    return paramInt;
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    getTransactionState();
    String str = this.impl.getHeaderFieldKey(paramInt);
    checkResponse();
    return str;
  }
  
  public Map<String, List<String>> getHeaderFields()
  {
    getTransactionState();
    Map localMap = this.impl.getHeaderFields();
    checkResponse();
    return localMap;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.impl.getHostnameVerifier();
  }
  
  public long getIfModifiedSince()
  {
    getTransactionState();
    long l = this.impl.getIfModifiedSince();
    checkResponse();
    return l;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    QAPMTransactionState localQAPMTransactionState = getTransactionState();
    try
    {
      QAPMCountingInputStream localQAPMCountingInputStream = new QAPMCountingInputStream(this.impl.getInputStream());
      QAPMTransactionStateUtil.inspectAndInstrumentResponse(localQAPMTransactionState, this.impl);
      if (localQAPMCountingInputStream != null) {
        localQAPMCountingInputStream.addStreamCompleteListener(new QAPMHttpsURLConnectionExtension.1(this, localQAPMTransactionState));
      }
      return localQAPMCountingInputStream;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.impl.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    getTransactionState();
    long l = this.impl.getLastModified();
    checkResponse();
    return l;
  }
  
  public Certificate[] getLocalCertificates()
  {
    return this.impl.getLocalCertificates();
  }
  
  public Principal getLocalPrincipal()
  {
    return this.impl.getLocalPrincipal();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    QAPMTransactionState localQAPMTransactionState = getTransactionState();
    try
    {
      QAPMCountingOutputStream localQAPMCountingOutputStream = new QAPMCountingOutputStream(this.impl.getOutputStream());
      if (localQAPMCountingOutputStream != null) {
        localQAPMCountingOutputStream.addStreamCompleteListener(new QAPMHttpsURLConnectionExtension.2(this, localQAPMTransactionState));
      }
      return localQAPMCountingOutputStream;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public Principal getPeerPrincipal()
    throws SSLPeerUnverifiedException
  {
    return this.impl.getPeerPrincipal();
  }
  
  public Permission getPermission()
    throws IOException
  {
    return this.impl.getPermission();
  }
  
  public int getReadTimeout()
  {
    return this.impl.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    QAPMTransactionState localQAPMTransactionState = getTransactionState();
    String str = this.impl.getRequestMethod();
    QAPMTransactionStateUtil.setRequestMethod(localQAPMTransactionState, str);
    this.transactionState.setHttpLibType(HttpLibType.URLConnection);
    return str;
  }
  
  public Map<String, List<String>> getRequestProperties()
  {
    return this.impl.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.impl.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
    throws IOException
  {
    getTransactionState();
    try
    {
      int i = this.impl.getResponseCode();
      checkResponse();
      return i;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public String getResponseMessage()
    throws IOException
  {
    getTransactionState();
    try
    {
      String str = this.impl.getResponseMessage();
      checkResponse();
      return str;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.impl.getSSLSocketFactory();
  }
  
  public Certificate[] getServerCertificates()
    throws SSLPeerUnverifiedException
  {
    try
    {
      Certificate[] arrayOfCertificate = this.impl.getServerCertificates();
      return arrayOfCertificate;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      error(localSSLPeerUnverifiedException);
      throw localSSLPeerUnverifiedException;
    }
  }
  
  public URL getURL()
  {
    return this.impl.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.impl.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.impl.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.impl.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.impl.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.impl.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.impl.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.impl.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.impl.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.impl.setHostnameVerifier(paramHostnameVerifier);
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.impl.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.impl.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.impl.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
    throws ProtocolException
  {
    getTransactionState();
    try
    {
      this.impl.setRequestMethod(paramString);
      this.transactionState.setMethodType(paramString);
      this.transactionState.setHttpLibType(HttpLibType.URLConnection);
      QAPMTransactionStateUtil.setRequestMethod(getTransactionState(), paramString);
      return;
    }
    catch (ProtocolException paramString)
    {
      error(paramString);
      throw paramString;
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    this.impl.setRequestProperty(paramString1, paramString2);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.impl.setSSLSocketFactory(paramSSLSocketFactory);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.impl.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.impl.toString();
  }
  
  public boolean usingProxy()
  {
    return this.impl.usingProxy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpsURLConnectionExtension
 * JD-Core Version:    0.7.0.1
 */