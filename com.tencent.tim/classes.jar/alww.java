import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class alww
  implements ValueAnimator.AnimatorUpdateListener
{
  final int blue = Color.blue(this.TJ);
  final int green = Color.green(this.TJ);
  final int red = Color.red(this.TJ);
  
  alww(int paramInt, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.val$v.setBackgroundColor(Color.argb(i, this.red, this.green, this.blue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alww
 * JD-Core Version:    0.7.0.1
 */