import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.4;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tll
  implements tky
{
  tll(tlj paramtlj) {}
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.1(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.3(this, paramInt));
  }
  
  public void a(tqt paramtqt, int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.4(this, paramInt1, paramInt2));
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tll
 * JD-Core Version:    0.7.0.1
 */