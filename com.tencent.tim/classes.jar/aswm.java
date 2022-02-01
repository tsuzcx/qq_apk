import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class aswm
  implements Callback
{
  private volatile boolean canceled;
  
  aswm(aswl paramaswl, String paramString, RequestProxy.RequestListener paramRequestListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("RequestProxyImpl", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestFailed(-5, "request error:cancel");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aswl.taskMap.remove(this.val$url);
      return;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestFailed(asum.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestHeadersReceived(i, localMap);
    paramCall = null;
    try
    {
      paramResponse = paramResponse.body().bytes();
      paramCall = paramResponse;
    }
    catch (IOException paramResponse)
    {
      for (;;)
      {
        paramResponse.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestSucceed(i, paramCall, localMap);
    this.jdField_a_of_type_Aswl.taskMap.remove(this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswm
 * JD-Core Version:    0.7.0.1
 */