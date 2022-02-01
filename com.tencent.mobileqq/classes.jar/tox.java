import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tox
  implements tld
{
  tox(tow paramtow) {}
  
  public void a(tqt paramtqt, int paramInt1, int paramInt2)
  {
    if ((paramtqt == null) || (paramtqt.d == null) || (tow.a(this.a) == null) || (tow.a(this.a).a == null) || (tow.a(this.a).a.mAdvertisementSoftInfo == null)) {}
    while (!tow.a(this.a).a.mAdvertisementSoftInfo.o.equalsIgnoreCase(paramtqt.d)) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsSoftAdBarDelegateForAd.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tox
 * JD-Core Version:    0.7.0.1
 */