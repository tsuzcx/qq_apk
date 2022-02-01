import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;

class uma
  implements umf
{
  uma(ulx paramulx) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = ulx.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      ulx.c(this.a, paramGiftServiceBean);
      ulx.c(this.a).setText(paramGiftServiceBean.t);
    }
    ulx.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uma
 * JD-Core Version:    0.7.0.1
 */