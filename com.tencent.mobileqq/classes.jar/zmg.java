import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zmg
  implements View.OnClickListener
{
  public zmg(CommodityItemView paramCommodityItemView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!CommodityItemView.a(this.a))) {
      if (!(this.a.a() instanceof CommodityBean)) {
        break label127;
      }
    }
    label127:
    for (String str = ((CommodityBean)this.a.a()).mUrl;; str = ((CertifiedAccountMeta.StYouZanGood)this.a.a()).url.get())
    {
      if (CommodityItemView.a(this.a) != null) {
        zxp.a(CommodityItemView.a(this.a).poster.id.get(), "auth_" + zlv.a(this.a.a()), "clk_goods", 0, 0, new String[0]);
      }
      zbh.a(str, 8002);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmg
 * JD-Core Version:    0.7.0.1
 */