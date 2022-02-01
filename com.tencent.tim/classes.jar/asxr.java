import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class asxr
  extends WebSocketListener
{
  asxr(asxq.a parama, asxq paramasxq) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    this.b.socketClosedCallbacked = true;
    this.b.mListener.onClose(this.b.eoa, paramInt, paramString);
    this.b.this$0.taskMap.remove(Integer.valueOf(this.b.eoa));
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    this.b.mListener.onError(this.b.eoa, asum.getRetCodeFrom(paramThrowable, -1), "WebSocket error:network");
    this.b.this$0.taskMap.remove(Integer.valueOf(this.b.eoa));
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.b.mListener.onMessage(this.b.eoa, paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.b.mListener.onMessage(this.b.eoa, paramByteString.toByteArray());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.b.mWebSocket = paramWebSocket;
    this.b.mListener.onOpen(this.b.eoa, paramResponse.code(), paramResponse.headers().toMultimap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxr
 * JD-Core Version:    0.7.0.1
 */