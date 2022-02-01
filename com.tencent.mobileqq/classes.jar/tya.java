import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class tya
  implements tyh
{
  tya(txz paramtxz) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = txz.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      txz.a(this.a, paramGiftServiceBean);
      txz.a(this.a).setText(paramGiftServiceBean.t);
      txz.b(this.a, null);
      if (txz.a(this.a)) {
        txz.c(this.a, null);
      }
      txz.b(this.a).setText("");
      txz.c(this.a).setText("");
      txz.a(this.a, new ArrayList());
      localObject = txz.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          txz.b(this.a).add(localGiftServiceBean);
        }
      }
      if (txz.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = amtj.a(2131704397);
        paramGiftServiceBean.v = "0";
        txz.b(this.a).add(paramGiftServiceBean);
      }
      txz.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tya
 * JD-Core Version:    0.7.0.1
 */