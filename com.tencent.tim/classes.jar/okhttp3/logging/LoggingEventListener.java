package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public final class LoggingEventListener
  extends EventListener
{
  private final HttpLoggingInterceptor.Logger logger;
  private long startNs;
  
  private LoggingEventListener(HttpLoggingInterceptor.Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  private void logWithTime(String paramString)
  {
    long l = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
    this.logger.log("[" + l + " ms] " + paramString);
  }
  
  public void callEnd(Call paramCall)
  {
    logWithTime("callEnd");
  }
  
  public void callFailed(Call paramCall, IOException paramIOException)
  {
    logWithTime("callFailed: " + paramIOException);
  }
  
  public void callStart(Call paramCall)
  {
    this.startNs = System.nanoTime();
    logWithTime("callStart: " + paramCall.request());
  }
  
  public void connectEnd(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, @Nullable Protocol paramProtocol)
  {
    logWithTime("connectEnd: " + paramProtocol);
  }
  
  public void connectFailed(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, @Nullable Protocol paramProtocol, IOException paramIOException)
  {
    logWithTime("connectFailed: " + paramProtocol + " " + paramIOException);
  }
  
  public void connectStart(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy)
  {
    logWithTime("connectStart: " + paramInetSocketAddress + " " + paramProxy);
  }
  
  public void connectionAcquired(Call paramCall, Connection paramConnection)
  {
    logWithTime("connectionAcquired: " + paramConnection);
  }
  
  public void connectionReleased(Call paramCall, Connection paramConnection)
  {
    logWithTime("connectionReleased");
  }
  
  public void dnsEnd(Call paramCall, String paramString, List<InetAddress> paramList)
  {
    logWithTime("dnsEnd: " + paramList);
  }
  
  public void dnsStart(Call paramCall, String paramString)
  {
    logWithTime("dnsStart: " + paramString);
  }
  
  public void requestBodyEnd(Call paramCall, long paramLong)
  {
    logWithTime("requestBodyEnd: byteCount=" + paramLong);
  }
  
  public void requestBodyStart(Call paramCall)
  {
    logWithTime("requestBodyStart");
  }
  
  public void requestHeadersEnd(Call paramCall, Request paramRequest)
  {
    logWithTime("requestHeadersEnd");
  }
  
  public void requestHeadersStart(Call paramCall)
  {
    logWithTime("requestHeadersStart");
  }
  
  public void responseBodyEnd(Call paramCall, long paramLong)
  {
    logWithTime("responseBodyEnd: byteCount=" + paramLong);
  }
  
  public void responseBodyStart(Call paramCall)
  {
    logWithTime("responseBodyStart");
  }
  
  public void responseHeadersEnd(Call paramCall, Response paramResponse)
  {
    logWithTime("responseHeadersEnd: " + paramResponse);
  }
  
  public void responseHeadersStart(Call paramCall)
  {
    logWithTime("responseHeadersStart");
  }
  
  public void secureConnectEnd(Call paramCall, @Nullable Handshake paramHandshake)
  {
    logWithTime("secureConnectEnd");
  }
  
  public void secureConnectStart(Call paramCall)
  {
    logWithTime("secureConnectStart");
  }
  
  public static class Factory
    implements EventListener.Factory
  {
    private final HttpLoggingInterceptor.Logger logger;
    
    public Factory()
    {
      this(HttpLoggingInterceptor.Logger.DEFAULT);
    }
    
    public Factory(HttpLoggingInterceptor.Logger paramLogger)
    {
      this.logger = paramLogger;
    }
    
    public EventListener create(Call paramCall)
    {
      return new LoggingEventListener(this.logger, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.logging.LoggingEventListener
 * JD-Core Version:    0.7.0.1
 */