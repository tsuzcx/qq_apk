import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class tyb
  implements tyh
{
  tyb(txz paramtxz) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = txz.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      txz.b(this.a, paramGiftServiceBean);
      txz.b(this.a).setText(paramGiftServiceBean.t);
      if (txz.a(this.a)) {
        txz.c(this.a, null);
      }
      txz.c(this.a).setText("");
      if (txz.c(this.a) != null) {
        txz.c(this.a).clear();
      }
      txz.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */