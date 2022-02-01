import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;

class knv
  implements knw.a
{
  knv(kns paramkns) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = kns.c(this.this$0).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      kns.c(this.this$0, paramGiftServiceBean);
      kns.c(this.this$0).setText(paramGiftServiceBean.t);
    }
    kns.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knv
 * JD-Core Version:    0.7.0.1
 */