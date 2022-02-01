import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aigk
  implements aiev
{
  aigk(aigi paramaigi, DownloadCallback paramDownloadCallback, String paramString) {}
  
  public void onDownloadComplete()
  {
    QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadComplete------");
    ThreadManager.getSubThreadHandler().post(new PluginManagerInterfaceImpl.2.1(this));
    aigi.a(this.b).removeDownloadListener(this.val$url);
  }
  
  public void onDownloadFailed(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadFailed------");
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("errCode", paramInt1);
      localBundle.putInt("httpCode", paramInt2);
      localBundle.putString("errMsg", paramString);
      this.a.onDownloadError(paramInt1, paramInt2, paramString);
    }
    aigi.a(this.b).removeDownloadListener(this.val$url);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2, int paramInt)
  {
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("downloadSize", paramLong1);
      localBundle.putLong("totalSize", paramLong2);
      localBundle.putInt("percent", paramInt);
      this.a.onProgress((int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigk
 * JD-Core Version:    0.7.0.1
 */