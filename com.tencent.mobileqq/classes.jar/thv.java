import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public class thv
  implements TVK_ICacheMgr.IPreloadCallback
{
  public thv(WSVideoPreDownloadManager paramWSVideoPreDownloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "预下载回调 videoUrl:" + WSVideoPreDownloadManager.a(this.a) + " ERROR code: " + paramInt);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "预下载回调 videoUrl:" + WSVideoPreDownloadManager.a(this.a) + " SUCCESS");
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thv
 * JD-Core Version:    0.7.0.1
 */