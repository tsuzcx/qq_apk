import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class wjr
  implements wwt
{
  public wjr(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (RecommendBannerItemView.a(this.a))
    {
      if (RecommendBannerItemView.a(this.a) != null) {
        xhb.a(RecommendBannerItemView.a(this.a).id.get(), "auth_discover", "reco_follow_clk", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get(), RecommendBannerItemView.a(this.a).desc.get() });
      }
      return;
    }
    if (paramBoolean)
    {
      RecommendBannerItemView.a(this.a, "auth_page", "recom_follow", RecommendBannerItemView.a(this.a).id.get(), "", "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get());
      return;
    }
    RecommendBannerItemView.a(this.a, "auth_page", "recom_unfollow", RecommendBannerItemView.a(this.a).id.get(), "", "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wjr
 * JD-Core Version:    0.7.0.1
 */