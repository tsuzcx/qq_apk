import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjm
  implements View.OnClickListener
{
  public sjm(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, CertifiedAccountMeta.StYouZanShop paramStYouZanShop) {}
  
  public void onClick(View paramView)
  {
    rzd.sW(this.a.schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjm
 * JD-Core Version:    0.7.0.1
 */