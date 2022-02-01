import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjb
  implements View.OnClickListener
{
  public sjb(CommodityItemView paramCommodityItemView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getData() != null) && (!CommodityItemView.a(this.a))) {
      if (!(this.a.getData() instanceof CommodityBean)) {
        break label127;
      }
    }
    label127:
    for (String str = ((CommodityBean)this.a.getData()).mUrl;; str = ((CertifiedAccountMeta.StYouZanGood)this.a.getData()).url.get())
    {
      if (CommodityItemView.a(this.a) != null) {
        sqn.b(CommodityItemView.a(this.a).poster.id.get(), "auth_" + siu.b(this.a.getExtraTypeInfo()), "clk_goods", 0, 0, new String[0]);
      }
      rzd.bz(str, 8002);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjb
 * JD-Core Version:    0.7.0.1
 */