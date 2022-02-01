import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;

public class zqx
  extends AnimatorListenerAdapter
{
  public zqx(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FollowedRecommendBannerView.a(this.a).notifyDataSetChanged();
    this.a.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqx
 * JD-Core Version:    0.7.0.1
 */