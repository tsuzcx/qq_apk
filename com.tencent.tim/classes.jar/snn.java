import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class snn
  extends apsy
{
  public snn(TroopGiftPanel paramTroopGiftPanel, int paramInt, sne paramsne) {}
  
  public void aU(int paramInt, String paramString)
  {
    super.aU(paramInt, paramString);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131715774);
    }
    QQToast.a(this.this$0.mContext, str, 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627)).show();
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131715762);
    }
    QQToast.a(this.this$0.mContext, str, 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627)).show();
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.lM, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
  
  public void yH(int paramInt)
  {
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", this.lM, 0, this.this$0.nD(), "" + this.a.giftId, this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snn
 * JD-Core Version:    0.7.0.1
 */