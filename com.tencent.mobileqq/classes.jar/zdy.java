import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zdy
  implements View.OnClickListener
{
  zdy(zdx paramzdx, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (((this.jdField_a_of_type_Zdx.itemView instanceof RelativeFeedItemView)) && (zds.a(this.jdField_a_of_type_Zdx.a) != null)) {
      zds.a(this.jdField_a_of_type_Zdx.a).a(this.jdField_a_of_type_Zdx.itemView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdy
 * JD-Core Version:    0.7.0.1
 */