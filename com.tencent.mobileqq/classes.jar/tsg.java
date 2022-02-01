import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tsg
  implements tqt
{
  tsg(tsf paramtsf) {}
  
  public void a(txh paramtxh, int paramInt1, int paramInt2)
  {
    if ((paramtxh == null) || (paramtxh.a == null) || (tsf.a(this.a) == null) || (tsf.a(this.a).a == null)) {}
    while ((!"2".equals(tsf.a(this.a).a.s)) || (!paramtxh.d.equals(tsf.a(this.a).a.d))) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsg
 * JD-Core Version:    0.7.0.1
 */