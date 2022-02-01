import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okio.ByteString;

@ProxyService(proxy=WebSocketProxy.class)
public class asxq
  extends WebSocketProxy
{
  public ConcurrentHashMap<Integer, asxq.a> taskMap = new ConcurrentHashMap();
  
  public boolean closeSocket(int paramInt1, int paramInt2, String paramString)
  {
    asxq.a locala = (asxq.a)this.taskMap.get(Integer.valueOf(paramInt1));
    if ((locala != null) && (locala.mWebSocket != null)) {}
    try
    {
      locala.mWebSocket.close(paramInt2, paramString);
      ThreadManager.getSubThreadHandler().postDelayed(new WebSocketProxyImpl.1(this, locala, paramInt1, paramInt2, paramString), 1000L);
      this.taskMap.remove(Integer.valueOf(paramInt1));
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", paramString);
      }
    }
  }
  
  public boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    paramString1 = new asxq.a(paramInt1, paramString1, paramMap, paramInt2, paramWebSocketListener);
    this.taskMap.put(Integer.valueOf(paramInt1), paramString1);
    return true;
  }
  
  public boolean send(int paramInt, String paramString)
  {
    asxq.a locala = (asxq.a)this.taskMap.get(Integer.valueOf(paramInt));
    if ((locala != null) && (locala.mWebSocket != null)) {
      try
      {
        MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        locala.mWebSocket.send(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", paramString);
        return false;
      }
    }
    return false;
  }
  
  public boolean send(int paramInt, byte[] paramArrayOfByte)
  {
    asxq.a locala = (asxq.a)this.taskMap.get(Integer.valueOf(paramInt));
    if ((locala != null) && (locala.mWebSocket != null)) {
      try
      {
        locala.mWebSocket.send(ByteString.of(paramArrayOfByte));
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", paramArrayOfByte);
        return false;
      }
    }
    return false;
  }
  
  public class a
  {
    public int eoa;
    public WebSocketProxy.WebSocketListener mListener;
    private OkHttpClient mOkHttpClient;
    public String mUrl;
    public WebSocket mWebSocket;
    public boolean socketClosedCallbacked;
    
    public a(String paramString, Map<String, String> paramMap, int paramInt, WebSocketProxy.WebSocketListener paramWebSocketListener)
    {
      this.eoa = paramString;
      this.mUrl = paramMap;
      Iterator localIterator;
      this.mListener = localIterator;
      paramMap = new Request.Builder().url(paramMap).build().newBuilder();
      if (paramInt != null)
      {
        localIterator = paramInt.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramMap.addHeader(str, (String)paramInt.get(str));
        }
      }
      paramMap = paramMap.build();
      long l = paramWebSocketListener / 1000 + 1;
      this.mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.SECONDS).build();
      this.mOkHttpClient.newWebSocket(paramMap, new asxr(this, asxq.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxq
 * JD-Core Version:    0.7.0.1
 */