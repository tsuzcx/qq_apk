import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public class ukl
  implements TVK_ICacheMgr.IPreloadCallback
{
  public ukl(WSVideoPreDownloadManager paramWSVideoPreDownloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    upe.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][onPreLoadFailed] ERROR!! videoUrl:" + paramString1 + " ERROR code: " + paramInt);
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).onPreLoadFailed(paramString1, paramInt, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    upe.g("WS_VIDEO_PRE_DL", "<<<<<<[WSVideoPreDownloadManager.java][onPreLoadSuccess] SUCCESS!! videoUrl:" + paramString1 + " SUCCESS");
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).onPreLoadSucess(paramString1, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukl
 * JD-Core Version:    0.7.0.1
 */