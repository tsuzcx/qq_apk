import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public class wvj
  implements View.OnClickListener
{
  public wvj(CommodityListView paramCommodityListView, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_" + wux.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView.a()), "clk_shop", 0, 0, new String[0]);
    wis.a(((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.youZhan.get(0)).schema.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvj
 * JD-Core Version:    0.7.0.1
 */