import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class trh
  implements tro
{
  trh(trg paramtrg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = trg.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      trg.a(this.a, paramGiftServiceBean);
      trg.a(this.a).setText(paramGiftServiceBean.t);
      trg.b(this.a, null);
      if (trg.a(this.a)) {
        trg.c(this.a, null);
      }
      trg.b(this.a).setText("");
      trg.c(this.a).setText("");
      trg.a(this.a, new ArrayList());
      localObject = trg.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          trg.b(this.a).add(localGiftServiceBean);
        }
      }
      if (trg.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = anzj.a(2131704168);
        paramGiftServiceBean.v = "0";
        trg.b(this.a).add(paramGiftServiceBean);
      }
      trg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */