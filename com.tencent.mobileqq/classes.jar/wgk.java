import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class wgk
  implements View.OnClickListener
{
  public wgk(CommodityItemView paramCommodityItemView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!CommodityItemView.a(this.a))) {
      if (!(this.a.a() instanceof CommodityBean)) {
        break label120;
      }
    }
    label120:
    for (paramView = ((CommodityBean)this.a.a()).mUrl;; paramView = ((CertifiedAccountMeta.StYouZanGood)this.a.a()).url.get())
    {
      if (CommodityItemView.a(this.a) != null) {
        wye.a(CommodityItemView.a(this.a).poster.id.get(), "auth_" + wfz.a(this.a.a()), "clk_goods", 0, 0, new String[0]);
      }
      vvy.a(paramView, 8002);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgk
 * JD-Core Version:    0.7.0.1
 */