import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

class soi
  implements ValueAnimator.AnimatorUpdateListener
{
  soi(sof paramsof, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.val$rootView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      ((LinearLayout.LayoutParams)localLayoutParams).topMargin = paramValueAnimator.intValue();
      this.val$rootView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soi
 * JD-Core Version:    0.7.0.1
 */