import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class akzm
  implements ValueAnimator.AnimatorUpdateListener
{
  akzm(akze paramakze, RelativeLayout.LayoutParams paramLayoutParams, View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {}
    float f;
    do
    {
      return;
      f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
      int i = (int)(-akze.a(this.this$0) * (1.0F - f));
      this.E.topMargin = i;
      this.Bg.setLayoutParams(this.E);
    } while (!this.this$0.bQO);
    this.Bh.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */