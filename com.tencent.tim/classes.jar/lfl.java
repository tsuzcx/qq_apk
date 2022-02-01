import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class lfl
  implements Animator.AnimatorListener
{
  public lfl(VideoView paramVideoView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VideoView.a(this.this$0) != null) {
      VideoView.a(this.this$0).setVisibility(4);
    }
    if (VideoView.b(this.this$0) != null) {
      VideoView.b(this.this$0).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfl
 * JD-Core Version:    0.7.0.1
 */