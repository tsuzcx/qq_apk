import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tml
  implements tld
{
  tml(tmk paramtmk) {}
  
  public void a(tqt paramtqt, int paramInt1, int paramInt2)
  {
    if ((paramtqt == null) || (paramtqt.a == null) || (tmk.a(this.a) == null) || (tmk.a(this.a).a == null)) {}
    while ((!"2".equals(tmk.a(this.a).a.s)) || (!paramtqt.d.equals(tmk.a(this.a).a.d))) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */