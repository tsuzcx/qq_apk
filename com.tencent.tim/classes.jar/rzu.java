import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class rzu
  implements sgs.a
{
  public rzu(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void ut(boolean paramBoolean)
  {
    String str2 = RecommendBannerFeedItemView.a(this.a).poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder().append("recom_");
    if (paramBoolean) {}
    for (String str1 = "cancel";; str1 = "dislike")
    {
      sqn.b(str2, "auth_page", str1, 0, 0, new String[] { "", RecommendBannerFeedItemView.a(this.a) + "", RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzu
 * JD-Core Version:    0.7.0.1
 */