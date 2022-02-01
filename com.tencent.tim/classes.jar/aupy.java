import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.tim.todo.widget.StrikeThruTextView;

public class aupy
  implements ValueAnimator.AnimatorUpdateListener
{
  public aupy(StrikeThruTextView paramStrikeThruTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    StrikeThruTextView.a(this.b, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupy
 * JD-Core Version:    0.7.0.1
 */