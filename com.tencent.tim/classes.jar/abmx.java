import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.4;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class abmx
  implements tgl
{
  public abmx(CmGameBannerAds.4 param4, GdtBannerAd paramGdtBannerAd) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    paramGdtAd = new abmw.a();
    paramGdtAd.d = this.c;
    paramGdtAd.viewId = this.a.val$viewId;
    paramGdtAd.cqd = this.a.cqc;
    abmw.a(this.a.this$0).put(Integer.valueOf(this.a.cqc), paramGdtAd);
    abmw.a(this.a.this$0, this.a.Od, this.a.cqc, 0, 0);
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, tgk paramtgk)
  {
    QLog.e("cmgame_process.CmGameBannerAds", 1, "onAdFailedToLoad " + paramtgk.getErrorMessage());
    abmw.a(this.a.this$0, this.a.Od, this.a.cqc, -1, paramtgk.getErrorCode());
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmx
 * JD-Core Version:    0.7.0.1
 */