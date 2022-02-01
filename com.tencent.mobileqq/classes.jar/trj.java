import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;

class trj
  implements tro
{
  trj(trg paramtrg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = trg.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      trg.c(this.a, paramGiftServiceBean);
      trg.c(this.a).setText(paramGiftServiceBean.t);
    }
    trg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trj
 * JD-Core Version:    0.7.0.1
 */