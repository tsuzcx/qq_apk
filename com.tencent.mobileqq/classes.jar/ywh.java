import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qphone.base.util.QLog;

public class ywh
  implements aane
{
  public ywh(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdLoaded");
    TroopGiftPanel.a(this.a, paramGdtAd);
  }
  
  public void a(GdtAd paramGdtAd, aand paramaand)
  {
    QLog.e("TroopGiftPanel", 1, "onAdFailedToLoad: " + paramaand.a());
  }
  
  public void b(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdImpression");
  }
  
  public void c(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClicked");
  }
  
  public void d(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClosed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywh
 * JD-Core Version:    0.7.0.1
 */