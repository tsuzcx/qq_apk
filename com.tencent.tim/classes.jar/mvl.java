import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView;

public class mvl
  extends AnimatorListenerAdapter
{
  public mvl(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.b);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvl
 * JD-Core Version:    0.7.0.1
 */