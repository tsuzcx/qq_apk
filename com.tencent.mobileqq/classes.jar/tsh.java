import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdDownloadView.3.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdDownloadView.3.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdDownloadView.3.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdDownloadView.3.4;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tsh
  implements tky
{
  tsh(tse paramtse) {}
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.1(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.3(this, paramInt));
  }
  
  public void a(tqt paramtqt, int paramInt1, int paramInt2)
  {
    if (tse.a(this.a).a(paramtqt)) {
      ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.4(this, paramInt1, paramInt2));
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsh
 * JD-Core Version:    0.7.0.1
 */