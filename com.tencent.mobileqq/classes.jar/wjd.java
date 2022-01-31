import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;

public class wjd
  extends AnimatorListenerAdapter
{
  public wjd(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FollowedRecommendBannerView.a(this.a).notifyDataSetChanged();
    this.a.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wjd
 * JD-Core Version:    0.7.0.1
 */