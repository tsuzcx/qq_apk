import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;

public class zqy
  extends AnimatorListenerAdapter
{
  public zqy(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqy
 * JD-Core Version:    0.7.0.1
 */