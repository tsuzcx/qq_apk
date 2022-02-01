import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class snk
  extends apsy
{
  public snk(TroopGiftPanel paramTroopGiftPanel, sne paramsne) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (this.this$0.asi >= 4)
    {
      acie.i("gift_store", "fail_all", this.this$0.nD(), this.this$0.um() + "", "", "");
      return;
    }
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_fail", 0, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
  
  public void yI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult productId = " + paramInt);
    }
    if (this.this$0.asi >= 4)
    {
      acie.i("gift_store", "suc_all", this.this$0.nD(), this.this$0.um() + "", "", "");
      return;
    }
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_suc", 0, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snk
 * JD-Core Version:    0.7.0.1
 */