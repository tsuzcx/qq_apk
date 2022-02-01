import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sji
  implements View.OnClickListener
{
  public sji(RelativeFeedItemView paramRelativeFeedItemView) {}
  
  public void onClick(View paramView)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.a.getData();
    if (localStFeed == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      rzd.a(this.a.getContext(), localStFeed, 0, sge.a(this.a.f, localStFeed.cover.width.get(), localStFeed.cover.height.get()));
      ExtraTypeInfo localExtraTypeInfo = this.a.getExtraTypeInfo();
      if ((localExtraTypeInfo != null) && (localStFeed != null)) {
        if (localExtraTypeInfo.pageType == 7003) {
          sqn.b(localStFeed.poster.id.get(), "auth_follow", "new_c_clk", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
        } else if (localExtraTypeInfo.pageType == 7004) {
          sqn.b(localStFeed.poster.id.get(), "auth_discover", "clk_content", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sji
 * JD-Core Version:    0.7.0.1
 */