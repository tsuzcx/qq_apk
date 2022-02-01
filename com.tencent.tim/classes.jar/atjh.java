import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.tim.cloudfile.anima.DynamicButton;

final class atjh
  implements ValueAnimator.AnimatorUpdateListener
{
  atjh(atjf.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)atjf.b.a(this.a).getLayoutParams();
    localLayoutParams.width = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int i = (atjf.b.c(this.a) - localLayoutParams.width) / 2;
    if (i > 0) {
      localLayoutParams.rightMargin = i;
    }
    atjf.b.a(this.a).setText(atjf.b.a(this.a));
    atjf.b.a(this.a).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjh
 * JD-Core Version:    0.7.0.1
 */