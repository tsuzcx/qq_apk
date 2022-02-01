import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import java.util.List;

public class zbp
  implements zbv
{
  public zbp(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && ((FollowedRecommendBannerView.a(this.a) == null) || (FollowedRecommendBannerView.a(this.a).a() == null) || (paramInt >= FollowedRecommendBannerView.a(this.a).a().size()))) {
      return;
    }
    zxp.a(FollowedRecommendBannerView.a(this.a), "auth_person", "reco_follow", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbp
 * JD-Core Version:    0.7.0.1
 */