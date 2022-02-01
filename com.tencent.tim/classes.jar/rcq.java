import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class rcq
  implements ValueAnimator.AnimatorUpdateListener
{
  rcq(rco paramrco, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)((this.bqb - this.bqc) * f);
    int j = this.bqc;
    int k = (int)(f * (this.bqd - this.bqe));
    int m = this.bqe;
    paramValueAnimator = (RelativeLayout.LayoutParams)this.oI.getLayoutParams();
    paramValueAnimator.leftMargin = (i + j);
    paramValueAnimator.bottomMargin = (m + k);
    this.oI.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcq
 * JD-Core Version:    0.7.0.1
 */