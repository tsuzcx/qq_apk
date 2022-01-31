import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class ykk
  implements View.OnClickListener
{
  public ykk(RelativeFeedItemView paramRelativeFeedItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((!RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView)) || (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a() == null) || (!xxl.a(((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.a()).status.get()))) {
      return;
    }
    if (!RelativeFeedItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.getContext(), alpo.a(2131713748), 0).a();
      return;
    }
    RelativeFeedItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView, false);
    paramView = new DoLikeRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(paramView, new ykl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykk
 * JD-Core Version:    0.7.0.1
 */