import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.b;
import com.tencent.mobileqq.pb.PBStringField;

public class rzs
  implements BaseWidgetView.b
{
  public rzs(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void bja()
  {
    if (RecommendBannerFeedItemView.a(this.a) == null) {
      return;
    }
    sqn.b(RecommendBannerFeedItemView.a(this.a).poster.id.get(), "auth_page", "recom_follow_b", 0, 0, new String[] { "", RecommendBannerFeedItemView.a(this.a) + "", RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */