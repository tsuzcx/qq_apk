import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

public class afzc
  extends AnimatorListenerAdapter
{
  public afzc(MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (MatchingView.a(this.this$0)) {
      MatchingView.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzc
 * JD-Core Version:    0.7.0.1
 */