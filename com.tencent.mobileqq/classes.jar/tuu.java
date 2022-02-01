import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tuu
  implements tqt
{
  tuu(tut paramtut) {}
  
  public void a(txh paramtxh, int paramInt1, int paramInt2)
  {
    if ((paramtxh == null) || (paramtxh.d == null) || (tut.a(this.a) == null) || (tut.a(this.a).a == null) || (tut.a(this.a).a.mAdvertisementSoftInfo == null)) {}
    while (!tut.a(this.a).a.mAdvertisementSoftInfo.o.equalsIgnoreCase(paramtxh.d)) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsSoftAdBarDelegateForAd.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuu
 * JD-Core Version:    0.7.0.1
 */