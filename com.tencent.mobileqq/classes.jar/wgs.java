import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wgs
  implements View.OnClickListener
{
  public wgs(RelativeFeedItemView paramRelativeFeedItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((!RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView)) || (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a() == null) || (!vvz.a(((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a()).status.get()))) {
      return;
    }
    if (!RelativeFeedItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView))
    {
      bbmy.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.getContext(), ajjy.a(2131647577), 0).a();
      return;
    }
    RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView, false);
    paramView = new DoLikeRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(paramView, new wgt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */