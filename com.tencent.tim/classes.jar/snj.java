import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class snj
  extends apsy
{
  public snj(TroopGiftPanel paramTroopGiftPanel, int paramInt, sne paramsne) {}
  
  public void aU(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    Context localContext = this.this$0.mContext;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131715769);
    }
    QQToast.a(localContext, str, 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627));
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.lM, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    QQToast.a(this.this$0.mContext, acfp.m(2131715784), 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627));
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.lM, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
  
  public void yH(int paramInt)
  {
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", this.lM, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snj
 * JD-Core Version:    0.7.0.1
 */