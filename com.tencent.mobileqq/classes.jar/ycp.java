import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class ycp
  implements View.OnLongClickListener
{
  public ycp(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (RecommendBannerItemView.a(this.a) == null) {
      return false;
    }
    yll.a(this.a.getContext(), RecommendBannerItemView.a(this.a), new ycq(this), new ycr(this));
    if (RecommendBannerItemView.a(this.a)) {
      zaj.a(RecommendBannerItemView.a(this.a).id.get(), "auth_discover", "reco_press", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get(), RecommendBannerItemView.a(this.a).desc.get() });
    }
    for (;;)
    {
      return true;
      zaj.a(RecommendBannerItemView.a(this.a).id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", RecommendBannerItemView.a(this.a) + "", RecommendBannerItemView.a(this.a).nick.get() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ycp
 * JD-Core Version:    0.7.0.1
 */