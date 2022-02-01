import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.tencent.biz.subscribe.other.story.StoryGameShotView;

public class sfi
  implements Animator.AnimatorListener
{
  public sfi(StoryGameShotView paramStoryGameShotView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (StoryGameShotView.a(this.this$0) != null) {
      StoryGameShotView.a(this.this$0).start();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfi
 * JD-Core Version:    0.7.0.1
 */