import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qphone.base.util.QLog;

public class wnz
  implements yka
{
  public wnz(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdLoaded");
    TroopGiftPanel.a(this.a, paramGdtAd);
  }
  
  public void a(GdtAd paramGdtAd, yjz paramyjz)
  {
    QLog.e("TroopGiftPanel", 1, "onAdFailedToLoad: " + paramyjz.a());
  }
  
  public void b(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdImpression");
  }
  
  public void c(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClicked");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wnz
 * JD-Core Version:    0.7.0.1
 */