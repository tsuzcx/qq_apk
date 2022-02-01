import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;

public class rzz
  implements FollowTextView.a
{
  public rzz(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (RecommendBannerItemView.a(this.this$0))
    {
      if (RecommendBannerItemView.a(this.this$0) != null) {
        sqn.b(RecommendBannerItemView.a(this.this$0).id.get(), "auth_discover", "reco_follow_clk", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.this$0)), RecommendBannerItemView.a(this.this$0).nick.get(), RecommendBannerItemView.a(this.this$0).desc.get() });
      }
      return;
    }
    if (paramBoolean)
    {
      RecommendBannerItemView.a(this.this$0, "auth_page", "recom_follow", RecommendBannerItemView.a(this.this$0).id.get(), "", "", String.valueOf(RecommendBannerItemView.a(this.this$0)), RecommendBannerItemView.a(this.this$0).nick.get());
      return;
    }
    RecommendBannerItemView.a(this.this$0, "auth_page", "recom_unfollow", RecommendBannerItemView.a(this.this$0).id.get(), "", "", String.valueOf(RecommendBannerItemView.a(this.this$0)), RecommendBannerItemView.a(this.this$0).nick.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzz
 * JD-Core Version:    0.7.0.1
 */