import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1.2;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1.3;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class koy
  implements kjt.a
{
  koy(kox paramkox) {}
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    this.a.b.a(this.a.ox, this.a.c, paramInt1, paramInt2);
  }
  
  public void aDK()
  {
    ThreadManager.getUIHandler().post(new ReadinjoyNativeArticleAdDownloadView.1.1(this));
  }
  
  public void aDL()
  {
    ThreadManager.getUIHandler().post(new ReadinjoyNativeArticleAdDownloadView.1.2(this));
  }
  
  public void setProgress(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ReadinjoyNativeArticleAdDownloadView.1.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koy
 * JD-Core Version:    0.7.0.1
 */