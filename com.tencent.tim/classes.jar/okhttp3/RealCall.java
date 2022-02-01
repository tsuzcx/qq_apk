package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  @Nullable
  private EventListener eventListener;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
  final AsyncTimeout timeout;
  
  private RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
    this.timeout = new RealCall.1(this);
    this.timeout.timeout(paramOkHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
  }
  
  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }
  
  static RealCall newRealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    paramRequest = new RealCall(paramOkHttpClient, paramRequest, paramBoolean);
    paramRequest.eventListener = paramOkHttpClient.eventListenerFactory().create(paramRequest);
    return paramRequest;
  }
  
  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }
  
  public RealCall clone()
  {
    return newRealCall(this.client, this.originalRequest, this.forWebSocket);
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    this.client.dispatcher().enqueue(new AsyncCall(paramCallback));
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
    captureCallStackTrace();
    this.timeout.enter();
    this.eventListener.callStart(this);
    try
    {
      this.client.dispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain();
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = timeoutExit(localIOException1);
      this.eventListener.callFailed(this, localIOException2);
      throw localIOException2;
    }
    finally
    {
      this.client.dispatcher().finished(this);
    }
    this.client.dispatcher().finished(this);
    return localResponse2;
  }
  
  Response getResponseWithInterceptorChain()
    throws IOException
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.client.interceptors());
    ((List)localObject).add(this.retryAndFollowUpInterceptor);
    ((List)localObject).add(new BridgeInterceptor(this.client.cookieJar()));
    ((List)localObject).add(new CacheInterceptor(this.client.internalCache()));
    ((List)localObject).add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket) {
      ((List)localObject).addAll(this.client.networkInterceptors());
    }
    ((List)localObject).add(new CallServerInterceptor(this.forWebSocket));
    localObject = new RealInterceptorChain((List)localObject, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    if (this.retryAndFollowUpInterceptor.isCanceled())
    {
      Util.closeQuietly((Closeable)localObject);
      throw new IOException("Canceled");
    }
    return localObject;
  }
  
  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
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
  
  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  @Nullable
  IOException timeoutExit(@Nullable IOException paramIOException)
  {
    if (!this.timeout.exit()) {
      return paramIOException;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.forWebSocket) {
        break label65;
      }
    }
    label65:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + redactedUrl();
      str = "";
      break;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final Callback responseCallback;
    
    static
    {
      if (!RealCall.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    AsyncCall(Callback paramCallback)
    {
      super(new Object[] { RealCall.this.redactedUrl() });
      this.responseCallback = paramCallback;
    }
    
    /* Error */
    public void execute()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iconst_0
      //   3: istore_1
      //   4: aload_0
      //   5: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   8: getfield 50	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
      //   11: invokevirtual 55	okio/AsyncTimeout:enter	()V
      //   14: aload_0
      //   15: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   18: invokevirtual 59	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
      //   21: astore_3
      //   22: iconst_1
      //   23: istore_2
      //   24: iconst_1
      //   25: istore_1
      //   26: aload_0
      //   27: getfield 41	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   30: aload_0
      //   31: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   34: aload_3
      //   35: invokeinterface 65 3 0
      //   40: aload_0
      //   41: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   44: getfield 69	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   47: invokevirtual 75	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   50: aload_0
      //   51: invokevirtual 81	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   54: return
      //   55: astore_3
      //   56: aload_0
      //   57: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   60: aload_3
      //   61: invokevirtual 85	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
      //   64: astore_3
      //   65: iload_1
      //   66: ifeq +51 -> 117
      //   69: invokestatic 91	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
      //   72: iconst_4
      //   73: new 93	java/lang/StringBuilder
      //   76: dup
      //   77: invokespecial 95	java/lang/StringBuilder:<init>	()V
      //   80: ldc 97
      //   82: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: aload_0
      //   86: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   89: invokevirtual 104	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
      //   92: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   98: aload_3
      //   99: invokevirtual 111	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   102: aload_0
      //   103: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   106: getfield 69	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   109: invokevirtual 75	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   112: aload_0
      //   113: invokevirtual 81	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   116: return
      //   117: aload_0
      //   118: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   121: invokestatic 115	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
      //   124: aload_0
      //   125: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   128: aload_3
      //   129: invokevirtual 121	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
      //   132: aload_0
      //   133: getfield 41	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   136: aload_0
      //   137: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   140: aload_3
      //   141: invokeinterface 124 3 0
      //   146: goto -44 -> 102
      //   149: astore_3
      //   150: aload_0
      //   151: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   154: getfield 69	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   157: invokevirtual 75	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   160: aload_0
      //   161: invokevirtual 81	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   164: aload_3
      //   165: athrow
      //   166: astore_3
      //   167: aload_0
      //   168: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   171: invokevirtual 127	okhttp3/RealCall:cancel	()V
      //   174: iload_2
      //   175: ifne +46 -> 221
      //   178: new 44	java/io/IOException
      //   181: dup
      //   182: new 93	java/lang/StringBuilder
      //   185: dup
      //   186: invokespecial 95	java/lang/StringBuilder:<init>	()V
      //   189: ldc 129
      //   191: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   194: aload_3
      //   195: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   198: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   201: invokespecial 135	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   204: astore 4
      //   206: aload_0
      //   207: getfield 41	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   210: aload_0
      //   211: getfield 28	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   214: aload 4
      //   216: invokeinterface 124 3 0
      //   221: aload_3
      //   222: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	223	0	this	AsyncCall
      //   3	63	1	i	int
      //   1	174	2	j	int
      //   21	14	3	localResponse	Response
      //   55	6	3	localIOException1	IOException
      //   64	77	3	localIOException2	IOException
      //   149	16	3	localObject	Object
      //   166	56	3	localThrowable	java.lang.Throwable
      //   204	11	4	localIOException3	IOException
      // Exception table:
      //   from	to	target	type
      //   14	22	55	java/io/IOException
      //   26	40	55	java/io/IOException
      //   14	22	149	finally
      //   26	40	149	finally
      //   56	65	149	finally
      //   69	102	149	finally
      //   117	146	149	finally
      //   167	174	149	finally
      //   178	221	149	finally
      //   221	223	149	finally
      //   14	22	166	java/lang/Throwable
      //   26	40	166	java/lang/Throwable
    }
    
    void executeOn(ExecutorService paramExecutorService)
    {
      assert (!Thread.holdsLock(RealCall.this.client.dispatcher()));
      try
      {
        paramExecutorService.execute(this);
        return;
      }
      catch (RejectedExecutionException paramExecutorService)
      {
        InterruptedIOException localInterruptedIOException = new InterruptedIOException("executor rejected");
        localInterruptedIOException.initCause(paramExecutorService);
        RealCall.this.eventListener.callFailed(RealCall.this, localInterruptedIOException);
        this.responseCallback.onFailure(RealCall.this, localInterruptedIOException);
        return;
      }
      finally
      {
        RealCall.this.client.dispatcher().finished(this);
      }
    }
    
    RealCall get()
    {
      return RealCall.this;
    }
    
    String host()
    {
      return RealCall.this.originalRequest.url().host();
    }
    
    Request request()
    {
      return RealCall.this.originalRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.RealCall
 * JD-Core Version:    0.7.0.1
 */