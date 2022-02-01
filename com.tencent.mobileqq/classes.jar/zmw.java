import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zmw
  implements View.OnClickListener
{
  public zmw(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, CertifiedAccountMeta.StYouZanShop paramStYouZanShop) {}
  
  public void onClick(View paramView)
  {
    zbh.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StYouZanShop.schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmw
 * JD-Core Version:    0.7.0.1
 */