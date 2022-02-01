import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjc
  implements View.OnClickListener
{
  public sjc(CommodityListView paramCommodityListView, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    sqn.b(this.d.id.get(), "auth_" + siu.b(this.a.getExtraTypeInfo()), "clk_shop", 0, 0, new String[0]);
    rzd.sW(((CertifiedAccountMeta.StYouZanShop)this.d.youZhan.get(0)).schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjc
 * JD-Core Version:    0.7.0.1
 */