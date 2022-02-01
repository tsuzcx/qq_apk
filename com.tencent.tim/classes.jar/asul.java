import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.util.Map;

@ProxyService(proxy=DownloaderProxy.class)
public class asul
  extends DownloaderProxy
{
  public void abort(String paramString)
  {
    FileDownloadManager.abort(paramString);
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    return FileDownloadManager.download(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
  }
  
  public void preConnectDownloadHost() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asul
 * JD-Core Version:    0.7.0.1
 */