import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.mobileqq.pb.PBStringField;

public class wuq
  implements View.OnClickListener
{
  public wuq(SubscribeFollowInfoView paramSubscribeFollowInfoView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a() == null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a())) {
      return;
    }
    xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + wux.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a()), "clk_name", 0, 0, new String[0]);
    wis.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a(), ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a()).poster);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */