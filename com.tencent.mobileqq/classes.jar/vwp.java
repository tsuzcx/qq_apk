import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class vwp
  implements vxl
{
  public vwp(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a()
  {
    if (RecommendBannerFeedItemView.a(this.a) == null) {
      return;
    }
    wye.a(RecommendBannerFeedItemView.a(this.a).poster.id.get(), "auth_page", "recom_follow_b", 0, 0, new String[] { "", RecommendBannerFeedItemView.a(this.a) + "", RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vwp
 * JD-Core Version:    0.7.0.1
 */