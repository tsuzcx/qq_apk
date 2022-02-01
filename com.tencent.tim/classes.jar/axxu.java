import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import dov.com.qq.im.capture.view.StoryToastView;

public class axxu
  extends AnimatorListenerAdapter
{
  public axxu(StoryToastView paramStoryToastView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    StoryToastView.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxu
 * JD-Core Version:    0.7.0.1
 */