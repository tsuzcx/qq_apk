import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.subscribe.other.story.StoryGameShotView;

public class sfj
  implements Animator.AnimatorListener
{
  public sfj(StoryGameShotView paramStoryGameShotView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    StoryGameShotView.a(this.this$0, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    StoryGameShotView.a(this.this$0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */