package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.List;

public class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
    throws IOException
  {
    return new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean).proceed(this.originalRequest);
  }
  
  private String toLoggableString()
  {
    if (this.canceled) {}
    for (String str = "canceled call";; str = "call")
    {
      HttpUrl localHttpUrl = this.originalRequest.httpUrl().resolve("/...");
      return str + " to " + localHttpUrl;
    }
  }
  
  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null) {
      this.engine.cancel();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    this.client.getDispatcher().enqueue(new AsyncCall(paramCallback, paramBoolean, null));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    try
    {
      this.client.getDispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain(false);
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.client.getDispatcher().finished(this);
    }
    this.client.getDispatcher().finished(this);
    return localResponse2;
  }
  
  /* Error */
  Response getResponse(Request paramRequest, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 150	com/squareup/okhttp/Request:body	()Lcom/squareup/okhttp/RequestBody;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +382 -> 390
    //   11: aload_1
    //   12: invokevirtual 154	com/squareup/okhttp/Request:newBuilder	()Lcom/squareup/okhttp/Request$Builder;
    //   15: astore_1
    //   16: aload 6
    //   18: invokevirtual 160	com/squareup/okhttp/RequestBody:contentType	()Lcom/squareup/okhttp/MediaType;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnull +15 -> 40
    //   28: aload_1
    //   29: ldc 162
    //   31: aload 7
    //   33: invokevirtual 165	com/squareup/okhttp/MediaType:toString	()Ljava/lang/String;
    //   36: invokevirtual 171	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   39: pop
    //   40: aload 6
    //   42: invokevirtual 175	com/squareup/okhttp/RequestBody:contentLength	()J
    //   45: lstore 4
    //   47: lload 4
    //   49: ldc2_w 176
    //   52: lcmp
    //   53: ifeq +75 -> 128
    //   56: aload_1
    //   57: ldc 179
    //   59: lload 4
    //   61: invokestatic 184	java/lang/Long:toString	(J)Ljava/lang/String;
    //   64: invokevirtual 171	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   67: pop
    //   68: aload_1
    //   69: ldc 186
    //   71: invokevirtual 190	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 194	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   79: astore_1
    //   80: aload_0
    //   81: new 101	com/squareup/okhttp/internal/http/HttpEngine
    //   84: dup
    //   85: aload_0
    //   86: getfield 32	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   89: aload_1
    //   90: iconst_0
    //   91: iconst_0
    //   92: iload_2
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokespecial 197	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   99: putfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   102: iconst_0
    //   103: istore_3
    //   104: aload_0
    //   105: getfield 63	com/squareup/okhttp/Call:canceled	Z
    //   108: ifeq +39 -> 147
    //   111: aload_0
    //   112: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   115: invokevirtual 200	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   118: new 39	java/io/IOException
    //   121: dup
    //   122: ldc 136
    //   124: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload_1
    //   129: ldc 186
    //   131: ldc 202
    //   133: invokevirtual 171	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   136: pop
    //   137: aload_1
    //   138: ldc 179
    //   140: invokevirtual 190	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   143: pop
    //   144: goto -69 -> 75
    //   147: aload_0
    //   148: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   151: invokevirtual 205	com/squareup/okhttp/internal/http/HttpEngine:sendRequest	()V
    //   154: aload_0
    //   155: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   158: invokevirtual 208	com/squareup/okhttp/internal/http/HttpEngine:readResponse	()V
    //   161: aload_0
    //   162: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   165: invokevirtual 210	com/squareup/okhttp/internal/http/HttpEngine:getResponse	()Lcom/squareup/okhttp/Response;
    //   168: astore 7
    //   170: aload_0
    //   171: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   174: invokevirtual 213	com/squareup/okhttp/internal/http/HttpEngine:followUpRequest	()Lcom/squareup/okhttp/Request;
    //   177: astore 8
    //   179: aload 8
    //   181: ifnonnull +106 -> 287
    //   184: iload_2
    //   185: ifne +10 -> 195
    //   188: aload_0
    //   189: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   192: invokevirtual 200	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   195: aload 7
    //   197: areturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 217	com/squareup/okhttp/internal/http/RequestException:getCause	()Ljava/io/IOException;
    //   203: athrow
    //   204: astore_1
    //   205: iconst_1
    //   206: istore_3
    //   207: iload_3
    //   208: ifeq +13 -> 221
    //   211: aload_0
    //   212: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   215: invokevirtual 221	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   218: invokevirtual 226	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   228: aload_1
    //   229: invokevirtual 230	com/squareup/okhttp/internal/http/HttpEngine:recover	(Lcom/squareup/okhttp/internal/http/RouteException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   232: astore 6
    //   234: aload 6
    //   236: ifnull +18 -> 254
    //   239: aload_0
    //   240: aload 6
    //   242: putfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   245: goto -141 -> 104
    //   248: iconst_0
    //   249: istore_3
    //   250: astore_1
    //   251: goto -44 -> 207
    //   254: aload_1
    //   255: invokevirtual 233	com/squareup/okhttp/internal/http/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   258: athrow
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   264: aload_1
    //   265: aconst_null
    //   266: invokevirtual 236	com/squareup/okhttp/internal/http/HttpEngine:recover	(Ljava/io/IOException;Lokio/Sink;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   269: astore 6
    //   271: aload 6
    //   273: ifnull +12 -> 285
    //   276: aload_0
    //   277: aload 6
    //   279: putfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   282: goto -178 -> 104
    //   285: aload_1
    //   286: athrow
    //   287: aload_0
    //   288: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   291: invokevirtual 221	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   294: astore 6
    //   296: iload_3
    //   297: iconst_1
    //   298: iadd
    //   299: istore_3
    //   300: iload_3
    //   301: bipush 20
    //   303: if_icmple +35 -> 338
    //   306: aload 6
    //   308: invokevirtual 226	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   311: new 238	java/net/ProtocolException
    //   314: dup
    //   315: new 81	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   322: ldc 240
    //   324: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_3
    //   328: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 244	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   337: athrow
    //   338: aload 6
    //   340: astore_1
    //   341: aload_0
    //   342: getfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   345: aload 8
    //   347: invokevirtual 71	com/squareup/okhttp/Request:httpUrl	()Lcom/squareup/okhttp/HttpUrl;
    //   350: invokevirtual 248	com/squareup/okhttp/internal/http/HttpEngine:sameConnection	(Lcom/squareup/okhttp/HttpUrl;)Z
    //   353: ifne +10 -> 363
    //   356: aload 6
    //   358: invokevirtual 226	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   361: aconst_null
    //   362: astore_1
    //   363: aload_0
    //   364: new 101	com/squareup/okhttp/internal/http/HttpEngine
    //   367: dup
    //   368: aload_0
    //   369: getfield 32	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   372: aload 8
    //   374: iconst_0
    //   375: iconst_0
    //   376: iload_2
    //   377: aload_1
    //   378: aconst_null
    //   379: aload 7
    //   381: invokespecial 197	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   384: putfield 99	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   387: goto -283 -> 104
    //   390: goto -310 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	Call
    //   0	393	1	paramRequest	Request
    //   0	393	2	paramBoolean	boolean
    //   103	225	3	i	int
    //   45	15	4	l	long
    //   4	353	6	localObject1	Object
    //   21	359	7	localObject2	Object
    //   177	196	8	localRequest	Request
    // Exception table:
    //   from	to	target	type
    //   147	161	198	com/squareup/okhttp/internal/http/RequestException
    //   147	161	204	finally
    //   199	204	204	finally
    //   224	234	204	finally
    //   254	259	204	finally
    //   260	271	204	finally
    //   285	287	204	finally
    //   147	161	223	com/squareup/okhttp/internal/http/RouteException
    //   239	245	248	finally
    //   276	282	248	finally
    //   147	161	259	java/io/IOException
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  Object tag()
  {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain
    implements Interceptor.Chain
  {
    private final boolean forWebSocket;
    private final int index;
    private final Request request;
    
    ApplicationInterceptorChain(int paramInt, Request paramRequest, boolean paramBoolean)
    {
      this.index = paramInt;
      this.request = paramRequest;
      this.forWebSocket = paramBoolean;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      if (this.index < Call.this.client.interceptors().size())
      {
        Object localObject = new ApplicationInterceptorChain(Call.this, this.index + 1, paramRequest, this.forWebSocket);
        paramRequest = (Interceptor)Call.this.client.interceptors().get(this.index);
        localObject = paramRequest.intercept((Interceptor.Chain)localObject);
        if (localObject == null) {
          throw new NullPointerException("application interceptor " + paramRequest + " returned null");
        }
        return localObject;
      }
      return Call.this.getResponse(paramRequest, this.forWebSocket);
    }
    
    public Request request()
    {
      return this.request;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final boolean forWebSocket;
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback, boolean paramBoolean)
    {
      super(new Object[] { Call.this.originalRequest.urlString() });
      this.responseCallback = paramCallback;
      this.forWebSocket = paramBoolean;
    }
    
    void cancel()
    {
      Call.this.cancel();
    }
    
    /* Error */
    public void execute()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   6: aload_0
      //   7: getfield 38	com/squareup/okhttp/Call$AsyncCall:forWebSocket	Z
      //   10: invokestatic 53	com/squareup/okhttp/Call:access$100	(Lcom/squareup/okhttp/Call;Z)Lcom/squareup/okhttp/Response;
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   18: getfield 56	com/squareup/okhttp/Call:canceled	Z
      //   21: istore_2
      //   22: iload_2
      //   23: ifeq +43 -> 66
      //   26: aload_0
      //   27: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   30: aload_0
      //   31: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   34: getfield 25	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
      //   37: new 49	java/io/IOException
      //   40: dup
      //   41: ldc 58
      //   43: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   46: invokeinterface 67 3 0
      //   51: aload_0
      //   52: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   55: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   58: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   61: aload_0
      //   62: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   65: return
      //   66: aload_0
      //   67: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   70: aload_3
      //   71: invokeinterface 87 2 0
      //   76: goto -25 -> 51
      //   79: astore_3
      //   80: iload_1
      //   81: ifeq +53 -> 134
      //   84: getstatic 93	com/squareup/okhttp/internal/Internal:logger	Ljava/util/logging/Logger;
      //   87: getstatic 99	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   90: new 101	java/lang/StringBuilder
      //   93: dup
      //   94: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   97: ldc 105
      //   99: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: aload_0
      //   103: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   106: invokestatic 113	com/squareup/okhttp/Call:access$200	(Lcom/squareup/okhttp/Call;)Ljava/lang/String;
      //   109: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   115: aload_3
      //   116: invokevirtual 122	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   119: aload_0
      //   120: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   123: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   126: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   129: aload_0
      //   130: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   133: return
      //   134: aload_0
      //   135: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   138: getfield 126	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   141: ifnonnull +44 -> 185
      //   144: aload_0
      //   145: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   148: getfield 25	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
      //   151: astore 4
      //   153: aload_0
      //   154: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   157: aload 4
      //   159: aload_3
      //   160: invokeinterface 67 3 0
      //   165: goto -46 -> 119
      //   168: astore_3
      //   169: aload_0
      //   170: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   173: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   176: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   179: aload_0
      //   180: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   183: aload_3
      //   184: athrow
      //   185: aload_0
      //   186: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   189: getfield 126	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   192: invokevirtual 132	com/squareup/okhttp/internal/http/HttpEngine:getRequest	()Lcom/squareup/okhttp/Request;
      //   195: astore 4
      //   197: goto -44 -> 153
      //   200: astore_3
      //   201: iconst_0
      //   202: istore_1
      //   203: goto -123 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	206	0	this	AsyncCall
      //   1	202	1	i	int
      //   21	2	2	bool	boolean
      //   13	58	3	localResponse	Response
      //   79	81	3	localIOException1	IOException
      //   168	16	3	localObject	Object
      //   200	1	3	localIOException2	IOException
      //   151	45	4	localRequest	Request
      // Exception table:
      //   from	to	target	type
      //   26	51	79	java/io/IOException
      //   66	76	79	java/io/IOException
      //   2	22	168	finally
      //   26	51	168	finally
      //   66	76	168	finally
      //   84	119	168	finally
      //   134	153	168	finally
      //   153	165	168	finally
      //   185	197	168	finally
      //   2	22	200	java/io/IOException
    }
    
    Call get()
    {
      return Call.this;
    }
    
    String host()
    {
      return Call.this.originalRequest.httpUrl().host();
    }
    
    Request request()
    {
      return Call.this.originalRequest;
    }
    
    Object tag()
    {
      return Call.this.originalRequest.tag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Call
 * JD-Core Version:    0.7.0.1
 */