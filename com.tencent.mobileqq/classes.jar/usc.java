import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;

public class usc
  implements uso
{
  public usc(WSVideoPreDownloadManager paramWSVideoPreDownloadManager) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    uya.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][onPreLoadFailed] ERROR!! videoUrl:" + paramString1 + " ERROR code: " + paramInt);
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).a(paramString1, paramInt, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    uya.g("WS_VIDEO_PRE_DL", "<<<<<<[WSVideoPreDownloadManager.java][onPreLoadSuccess] SUCCESS!! videoUrl:" + paramString1 + " SUCCESS");
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).a(paramString1, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */