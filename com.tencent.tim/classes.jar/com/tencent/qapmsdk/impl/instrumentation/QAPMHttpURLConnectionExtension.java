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
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class QAPMHttpURLConnectionExtension
  extends HttpURLConnection
{
  private static final String TAG = "QAPM_Impl_QAPMHttpURLConnectionExtension";
  private HttpURLConnection impl;
  QAPMCountingInputStream qapmCountingInputStream;
  private QAPMTransactionState transactionState;
  
  public QAPMHttpURLConnectionExtension(@NonNull HttpURLConnection paramHttpURLConnection)
  {
    super(paramHttpURLConnection.getURL());
    this.impl = paramHttpURLConnection;
    getTransactionState();
    if (TraceUtil.getCanMonitorHttp())
    {
      getTransactionState();
      this.transactionState.setAppPhase(0);
    }
  }
  
  /* Error */
  private void addTransactionAndErrorData(QAPMTransactionState paramQAPMTransactionState)
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/qapmsdk/impl/util/TraceUtil:getCanMonitorHttp	()Z
    //   3: istore_2
    //   4: iload_2
    //   5: ifne +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   14: invokevirtual 69	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   17: invokestatic 75	com/tencent/qapmsdk/impl/util/StringUtil:contentType	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setContentType	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 83	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:end	()Lcom/tencent/qapmsdk/impl/api/data/TransactionData;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -23 -> 8
    //   34: aload_1
    //   35: invokevirtual 86	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isError	()Z
    //   38: ifeq +254 -> 292
    //   41: new 88	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: aload_0
    //   50: invokevirtual 95	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:getErrorStream	()Ljava/io/InputStream;
    //   53: astore 5
    //   55: aload 5
    //   57: instanceof 97
    //   60: ifeq +16 -> 76
    //   63: aload_3
    //   64: aload 5
    //   66: checkcast 97	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream
    //   69: invokevirtual 100	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream:getBufferAsString	()Ljava/lang/String;
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 106	java/util/TreeMap
    //   79: dup
    //   80: invokespecial 107	java/util/TreeMap:<init>	()V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   89: invokevirtual 111	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   92: ifnull +98 -> 190
    //   95: aload_0
    //   96: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   99: invokevirtual 111	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   102: invokeinterface 117 1 0
    //   107: ifle +83 -> 190
    //   110: aload_0
    //   111: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   114: invokevirtual 111	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   117: astore_3
    //   118: aload_3
    //   119: invokeinterface 121 1 0
    //   124: invokeinterface 127 1 0
    //   129: astore 6
    //   131: aload 6
    //   133: invokeinterface 132 1 0
    //   138: ifeq +52 -> 190
    //   141: aload 6
    //   143: invokeinterface 136 1 0
    //   148: checkcast 138	java/lang/String
    //   151: astore 7
    //   153: aload 7
    //   155: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -27 -> 131
    //   161: aload 5
    //   163: aload 7
    //   165: aload_3
    //   166: aload 7
    //   168: invokeinterface 148 2 0
    //   173: checkcast 150	java/util/List
    //   176: iconst_0
    //   177: invokeinterface 153 2 0
    //   182: invokevirtual 157	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: goto -55 -> 131
    //   189: astore_3
    //   190: ldc 159
    //   192: astore_3
    //   193: aload_1
    //   194: invokevirtual 162	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   197: ifnull +8 -> 205
    //   200: aload_1
    //   201: invokevirtual 162	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   204: astore_3
    //   205: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   208: iconst_3
    //   209: anewarray 138	java/lang/String
    //   212: dup
    //   213: iconst_0
    //   214: ldc 8
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: ldc 170
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: aload_3
    //   225: aastore
    //   226: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   229: aload 4
    //   231: aload 5
    //   233: aload_3
    //   234: invokestatic 180	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;Ljava/util/TreeMap;Ljava/lang/String;)V
    //   237: return
    //   238: astore_1
    //   239: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   242: ldc 8
    //   244: ldc 182
    //   246: aload_1
    //   247: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: return
    //   251: astore_3
    //   252: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   255: ldc 8
    //   257: ldc 188
    //   259: aload_3
    //   260: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -240 -> 23
    //   266: astore_3
    //   267: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   270: iconst_2
    //   271: anewarray 138	java/lang/String
    //   274: dup
    //   275: iconst_0
    //   276: ldc 8
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload_3
    //   282: invokevirtual 191	java/lang/Exception:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokevirtual 194	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   289: goto -213 -> 76
    //   292: aload 4
    //   294: invokestatic 197	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;)V
    //   297: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	QAPMHttpURLConnectionExtension
    //   0	298	1	paramQAPMTransactionState	QAPMTransactionState
    //   3	2	2	bool	boolean
    //   48	118	3	localObject1	Object
    //   189	1	3	localException1	Exception
    //   192	42	3	str1	String
    //   251	9	3	localException2	Exception
    //   266	16	3	localException3	Exception
    //   27	266	4	localTransactionData	com.tencent.qapmsdk.impl.api.data.TransactionData
    //   53	179	5	localObject2	Object
    //   129	13	6	localIterator	java.util.Iterator
    //   151	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   85	131	189	java/lang/Exception
    //   131	186	189	java/lang/Exception
    //   0	4	238	java/lang/Exception
    //   23	29	238	java/lang/Exception
    //   34	49	238	java/lang/Exception
    //   76	85	238	java/lang/Exception
    //   193	205	238	java/lang/Exception
    //   205	237	238	java/lang/Exception
    //   252	263	238	java/lang/Exception
    //   267	289	238	java/lang/Exception
    //   292	297	238	java/lang/Exception
    //   9	23	251	java/lang/Exception
    //   49	76	266	java/lang/Exception
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
    //   0: invokestatic 36	com/tencent/qapmsdk/impl/util/TraceUtil:getCanMonitorHttp	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokespecial 30	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:getTransactionState	()Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   17: invokevirtual 69	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   20: invokestatic 75	com/tencent/qapmsdk/impl/util/StringUtil:contentType	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:setContentType	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +18 -> 45
    //   30: aload_2
    //   31: getfield 211	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:hasParseUrlParams	Z
    //   34: ifne +11 -> 45
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 26	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpURLConnectionExtension:impl	Ljava/net/HttpURLConnection;
    //   42: invokestatic 214	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionStateUtil:processUrlParams	(Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;Ljava/net/HttpURLConnection;)V
    //   45: aload_2
    //   46: aload_1
    //   47: invokestatic 218	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionStateUtil:setErrorCodeFromException	(Lcom/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState;Ljava/lang/Exception;)V
    //   50: aload_2
    //   51: invokevirtual 201	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isComplete	()Z
    //   54: ifne +137 -> 191
    //   57: ldc 159
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 162	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   64: ifnull +8 -> 72
    //   67: aload_2
    //   68: invokevirtual 162	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   71: astore_1
    //   72: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   75: iconst_3
    //   76: anewarray 138	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc 8
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: ldc 170
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: aload_1
    //   92: aastore
    //   93: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 83	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:end	()Lcom/tencent/qapmsdk/impl/api/data/TransactionData;
    //   100: astore_3
    //   101: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   104: iconst_3
    //   105: anewarray 138	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: ldc 8
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc 220
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_2
    //   121: invokevirtual 86	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isError	()Z
    //   124: invokestatic 224	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   127: aastore
    //   128: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   131: aload_2
    //   132: invokevirtual 86	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isError	()Z
    //   135: ifeq +52 -> 187
    //   138: aload_3
    //   139: aload_1
    //   140: invokestatic 227	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;Ljava/lang/String;)V
    //   143: return
    //   144: astore_1
    //   145: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   148: ldc 8
    //   150: ldc 229
    //   152: aload_1
    //   153: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: return
    //   157: astore_3
    //   158: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   161: ldc 8
    //   163: ldc 188
    //   165: aload_3
    //   166: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto -143 -> 26
    //   172: astore_3
    //   173: getstatic 168	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   176: ldc 8
    //   178: ldc 231
    //   180: aload_3
    //   181: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -139 -> 45
    //   187: aload_3
    //   188: invokestatic 197	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;)V
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	QAPMHttpURLConnectionExtension
    //   0	192	1	paramException	Exception
    //   11	121	2	localQAPMTransactionState	QAPMTransactionState
    //   100	39	3	localTransactionData	com.tencent.qapmsdk.impl.api.data.TransactionData
    //   157	9	3	localException1	Exception
    //   172	16	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	144	java/lang/Exception
    //   7	12	144	java/lang/Exception
    //   45	57	144	java/lang/Exception
    //   60	72	144	java/lang/Exception
    //   72	143	144	java/lang/Exception
    //   158	169	144	java/lang/Exception
    //   173	184	144	java/lang/Exception
    //   187	191	144	java/lang/Exception
    //   12	26	157	java/lang/Exception
    //   30	45	172	java/lang/Exception
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
      this.qapmCountingInputStream.addStreamCompleteListener(new QAPMHttpURLConnectionExtension.2(this));
      return this.qapmCountingInputStream;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "errorStream :", localException.toString() });
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
        localQAPMCountingInputStream.addStreamCompleteListener(new QAPMHttpURLConnectionExtension.1(this, localQAPMTransactionState));
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
  
  public OutputStream getOutputStream()
    throws IOException
  {
    try
    {
      QAPMCountingOutputStream localQAPMCountingOutputStream = new QAPMCountingOutputStream(this.impl.getOutputStream());
      if (localQAPMCountingOutputStream != null) {
        localQAPMCountingOutputStream.addStreamCompleteListener(new QAPMHttpURLConnectionExtension.3(this));
      }
      return localQAPMCountingOutputStream;
    }
    catch (IOException localIOException)
    {
      error(localIOException);
      throw localIOException;
    }
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
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpURLConnectionExtension
 * JD-Core Version:    0.7.0.1
 */