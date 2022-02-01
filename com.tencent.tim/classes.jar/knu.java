import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class knu
  implements knw.a
{
  knu(kns paramkns) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = kns.b(this.this$0).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      kns.b(this.this$0, paramGiftServiceBean);
      kns.b(this.this$0).setText(paramGiftServiceBean.t);
      if (kns.a(this.this$0)) {
        kns.c(this.this$0, null);
      }
      kns.c(this.this$0).setText("");
      if (kns.c(this.this$0) != null) {
        kns.c(this.this$0).clear();
      }
      kns.a(this.this$0);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knu
 * JD-Core Version:    0.7.0.1
 */