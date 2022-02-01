import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class vcg
  implements ValueAnimator.AnimatorUpdateListener
{
  vcg(vcb paramvcb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    vcb.a(this.a).getLayoutParams().width = (((Integer)paramValueAnimator.getAnimatedValue()).intValue() + bgtn.a(50.0F));
    vcb.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcg
 * JD-Core Version:    0.7.0.1
 */