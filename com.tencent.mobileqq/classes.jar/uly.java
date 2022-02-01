import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class uly
  implements umf
{
  uly(ulx paramulx) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = ulx.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      ulx.a(this.a, paramGiftServiceBean);
      ulx.a(this.a).setText(paramGiftServiceBean.t);
      ulx.b(this.a, null);
      if (ulx.a(this.a)) {
        ulx.c(this.a, null);
      }
      ulx.b(this.a).setText("");
      ulx.c(this.a).setText("");
      ulx.a(this.a, new ArrayList());
      localObject = ulx.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          ulx.b(this.a).add(localGiftServiceBean);
        }
      }
      if (ulx.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = anvx.a(2131704748);
        paramGiftServiceBean.v = "0";
        ulx.b(this.a).add(paramGiftServiceBean);
      }
      ulx.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uly
 * JD-Core Version:    0.7.0.1
 */