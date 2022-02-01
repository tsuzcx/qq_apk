import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ajua
  extends apsy
{
  public ajua(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      QQToast.a(TroopGiftPanelForNearby.a(this.b), acfp.m(2131715780), 0).show(this.b.getResources().getDimensionPixelSize(2131299627));
    }
    for (;;)
    {
      acie.i("gift_store", "fail_one", this.b.nD(), TroopGiftPanelForNearby.b(this.b) + "", "", "");
      return;
      QQToast.a(TroopGiftPanelForNearby.b(this.b), acfp.m(2131715777), 0).show(this.b.getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  public void yH(int paramInt)
  {
    acie.i("gift_store", "suc_one", this.b.nD(), TroopGiftPanelForNearby.a(this.b) + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajua
 * JD-Core Version:    0.7.0.1
 */