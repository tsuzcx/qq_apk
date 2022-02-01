import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;

@ProxyService(proxy=UploaderProxy.class)
public class asxd
  extends UploaderProxy
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
  
  public boolean upload(String paramString1, Map<String, String> paramMap1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap2, int paramInt, UploaderProxy.UploadListener paramUploadListener)
  {
    TTHandleThread.getInstance().post(new UploaderProxyImpl.1(this, paramString1, paramMap1, paramString2, paramMap2, paramString3, paramString4, paramUploadListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxd
 * JD-Core Version:    0.7.0.1
 */