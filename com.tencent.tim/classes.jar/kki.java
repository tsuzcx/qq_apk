import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.1;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.2;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.3;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.2.4;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class kki
  implements kjt.a
{
  kki(kkg paramkkg) {}
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.4(this, paramInt1, paramInt2));
  }
  
  public void aDK()
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.1(this));
  }
  
  public void aDL()
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.2(this));
  }
  
  public void setProgress(int paramInt)
  {
    ThreadManager.getUIHandler().post(new GoodsSoftAdAppDelegate.2.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kki
 * JD-Core Version:    0.7.0.1
 */