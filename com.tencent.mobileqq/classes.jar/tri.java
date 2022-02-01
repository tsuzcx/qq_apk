import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class tri
  implements tro
{
  tri(trg paramtrg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = trg.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      trg.b(this.a, paramGiftServiceBean);
      trg.b(this.a).setText(paramGiftServiceBean.t);
      if (trg.a(this.a)) {
        trg.c(this.a, null);
      }
      trg.c(this.a).setText("");
      if (trg.c(this.a) != null) {
        trg.c(this.a).clear();
      }
      trg.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tri
 * JD-Core Version:    0.7.0.1
 */