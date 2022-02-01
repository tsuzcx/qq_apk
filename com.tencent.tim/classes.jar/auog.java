import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.tim.todo.widget.TodoCardView;

class auog
  implements ValueAnimator.AnimatorUpdateListener
{
  auog(auof paramauof) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setAlpha(f);
    this.a.La.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auog
 * JD-Core Version:    0.7.0.1
 */