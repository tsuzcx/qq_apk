import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjf
  implements View.OnClickListener
{
  public sjf(BlankRecommendItemView.a parama, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    rzd.a(this.a.a.getContext(), this.e, 0, sge.a(BlankRecommendItemView.a.a(this.a), this.e.cover.width.get(), this.e.cover.height.get()));
    sqn.c(this.e.poster.id.get(), "auth_follow", "blank_content_clk", 0, 0, new String[] { "", BlankRecommendItemView.a.a(this.a) + "", this.e.poster.nick.get(), this.e.title.get() });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjf
 * JD-Core Version:    0.7.0.1
 */