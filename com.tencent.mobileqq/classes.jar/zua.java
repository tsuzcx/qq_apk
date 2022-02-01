import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qphone.base.util.QLog;

public class zua
  implements abla
{
  public zua(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onAdClicked(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClicked");
  }
  
  public void onAdClosed(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClosed");
  }
  
  public void onAdFailedToLoad(GdtAd paramGdtAd, abkz paramabkz)
  {
    QLog.e("TroopGiftPanel", 1, "onAdFailedToLoad: " + paramabkz.a());
  }
  
  public void onAdImpression(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdImpression");
  }
  
  public void onAdLoaded(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdLoaded");
    TroopGiftPanel.a(this.a, paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zua
 * JD-Core Version:    0.7.0.1
 */