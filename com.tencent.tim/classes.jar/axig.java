import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import dov.com.qq.im.ae.play.UrlConHttpClient.1;
import dov.com.qq.im.ae.play.UrlConHttpClient.2;
import java.util.concurrent.Executor;

public class axig
  implements IHttpClient
{
  private static final String TAG = axig.class.getSimpleName();
  private IResponseListener a;
  
  private void ar(int paramInt, String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.response(paramInt, 1, paramString1, paramString2);
    }
  }
  
  public void download(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    LogUtils.i(TAG, "开始下载文件:" + paramString2);
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(TAG, "downUrl 无效：" + paramString2);
      return;
    }
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.2(this, paramString2, paramString3, paramInt, paramString1));
  }
  
  public void get(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(TAG, "url 无效：" + paramString2);
      return;
    }
    LogUtils.i(TAG, "GET 请求：" + paramString2);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.1(this, paramString2, paramInt, paramString1));
  }
  
  public void post(int paramInt, String paramString1, String paramString2) {}
  
  public void setResponseListener(IResponseListener paramIResponseListener)
  {
    LogUtils.i(TAG, "setResponseListener ");
    this.a = paramIResponseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axig
 * JD-Core Version:    0.7.0.1
 */