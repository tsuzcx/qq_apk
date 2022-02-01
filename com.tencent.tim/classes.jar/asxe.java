import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class asxe
  implements Callback
{
  private volatile boolean canceled;
  
  public asxe(UploaderProxyImpl.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("UploaderProxyImpl", 1, "httpConnect err url:" + this.a.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage())) {
      this.a.a.onUploadFailed(-5, "download error:cancel");
    }
    for (;;)
    {
      this.a.this$0.taskMap.remove(this.a.val$url);
      return;
      this.a.a.onUploadFailed(asum.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.a.a.onUploadHeadersReceived(i, paramCall);
    this.a.a.onUploadSucceed(i, paramResponse.body().bytes(), paramCall);
    this.a.this$0.taskMap.remove(this.a.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxe
 * JD-Core Version:    0.7.0.1
 */