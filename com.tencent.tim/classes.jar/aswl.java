import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@ProxyService(proxy=RequestProxy.class)
public class aswl
  extends RequestProxy
{
  public ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Call localCall = (Call)this.taskMap.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    this.taskMap.remove(paramString);
  }
  
  public boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    paramArrayOfByte = MiniOkHttpClientFactory.getRequestClient().newCall(asum.a(paramString1, paramMap, paramString2.toUpperCase(), null, paramArrayOfByte));
    paramArrayOfByte.enqueue(new aswm(this, paramString1, paramRequestListener));
    this.taskMap.put(paramString1, paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswl
 * JD-Core Version:    0.7.0.1
 */