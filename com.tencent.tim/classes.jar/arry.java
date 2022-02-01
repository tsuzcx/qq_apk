import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.open.agent.OpenCardContainer;

public class arry
  implements ValueAnimator.AnimatorUpdateListener
{
  public arry(OpenCardContainer paramOpenCardContainer, ImageView paramImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.bI.getLayoutParams().height = i;
    this.bI.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arry
 * JD-Core Version:    0.7.0.1
 */