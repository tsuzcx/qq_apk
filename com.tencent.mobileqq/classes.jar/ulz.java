import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class ulz
  implements umf
{
  ulz(ulx paramulx) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = ulx.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      ulx.b(this.a, paramGiftServiceBean);
      ulx.b(this.a).setText(paramGiftServiceBean.t);
      if (ulx.a(this.a)) {
        ulx.c(this.a, null);
      }
      ulx.c(this.a).setText("");
      if (ulx.c(this.a) != null) {
        ulx.c(this.a).clear();
      }
      ulx.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageDialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulz
 * JD-Core Version:    0.7.0.1
 */