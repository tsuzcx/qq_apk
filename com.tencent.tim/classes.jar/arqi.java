import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.open.agent.CardContainer;

public class arqi
  extends AnimatorListenerAdapter
{
  public arqi(CardContainer paramCardContainer, ImageView paramImageView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.setBackgroundColor(0);
    this.bI.getLayoutParams().width = -1;
    this.bI.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqi
 * JD-Core Version:    0.7.0.1
 */