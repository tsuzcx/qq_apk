import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.capture.view.StoryToastView;

public class axxv
  extends AnimatorListenerAdapter
{
  public axxv(StoryToastView paramStoryToastView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxv
 * JD-Core Version:    0.7.0.1
 */