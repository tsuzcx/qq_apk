import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class tsu
  implements TVK_SDKMgr.InstallListener
{
  public tsu(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void onInstallProgress(float paramFloat)
  {
    acvc.a("ReadInJoyArticleBottomVideoView", "installSDK onInstallProgress arg0=");
  }
  
  public void onInstalledFailed(int paramInt)
  {
    acvc.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledFailed arg0=");
  }
  
  public void onInstalledSuccessed()
  {
    acvc.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledSuccessed");
    if ((ReadInJoyArticleBottomVideoView.b()) && (ReadInJoyArticleBottomVideoView.a(this.a) != null)) {
      ReadInJoyArticleBottomVideoView.a(this.a).post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this.a, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsu
 * JD-Core Version:    0.7.0.1
 */