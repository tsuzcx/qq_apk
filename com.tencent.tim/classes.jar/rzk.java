import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import java.util.List;

public class rzk
  implements rzp
{
  public rzk(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void ag(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && ((FollowedRecommendBannerView.a(this.a) == null) || (FollowedRecommendBannerView.a(this.a).getDatas() == null) || (paramInt >= FollowedRecommendBannerView.a(this.a).getDatas().size()))) {
      return;
    }
    sqn.b(FollowedRecommendBannerView.a(this.a), "auth_person", "reco_follow", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzk
 * JD-Core Version:    0.7.0.1
 */