import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class vdz
  implements ValueAnimator.AnimatorUpdateListener
{
  vdz(vdr paramvdr) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    vdr.a(this.a).getLayoutParams().width = (((Integer)paramValueAnimator.getAnimatedValue()).intValue() + bhtq.a(50.0F));
    vdr.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdz
 * JD-Core Version:    0.7.0.1
 */