import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

class u
  implements ValueAnimator.AnimatorUpdateListener
{
  u(t paramt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.i[0])
    {
      this.a.a.cancel();
      this.a.e = 0;
      t.a(this.a).a = t.a(this.a).d();
      t.a(this.a).requestLayout();
      t.a(this.a).invalidate();
    }
    while (i <= this.a.e) {
      return;
    }
    this.a.e = i;
    t.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     u
 * JD-Core Version:    0.7.0.1
 */