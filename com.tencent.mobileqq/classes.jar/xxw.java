import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;

public class xxw
  extends AnimatorListenerAdapter
{
  public xxw(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxw
 * JD-Core Version:    0.7.0.1
 */