import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.tim.cloudfile.anima.DynamicButton;

final class atjg
  implements ValueAnimator.AnimatorUpdateListener
{
  atjg(atjf.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)atjf.b.a(this.a).getLayoutParams();
    localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int i = (atjf.b.a(this.a) - localLayoutParams.height) / 2;
    if (i > 0) {
      localLayoutParams.bottomMargin = i;
    }
    atjf.b.a(this.a).setText(atjf.b.a(this.a));
    atjf.b.a(this.a).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjg
 * JD-Core Version:    0.7.0.1
 */