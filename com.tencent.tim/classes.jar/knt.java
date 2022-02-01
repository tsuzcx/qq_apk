import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class knt
  implements knw.a
{
  knt(kns paramkns) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = kns.a(this.this$0).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      kns.a(this.this$0, paramGiftServiceBean);
      kns.a(this.this$0).setText(paramGiftServiceBean.t);
      kns.b(this.this$0, null);
      if (kns.a(this.this$0)) {
        kns.c(this.this$0, null);
      }
      kns.b(this.this$0).setText("");
      kns.c(this.this$0).setText("");
      kns.a(this.this$0, new ArrayList());
      localObject = kns.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          kns.b(this.this$0).add(localGiftServiceBean);
        }
      }
      if (kns.b(this.this$0).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.v = "0";
        kns.b(this.this$0).add(paramGiftServiceBean);
      }
      kns.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knt
 * JD-Core Version:    0.7.0.1
 */