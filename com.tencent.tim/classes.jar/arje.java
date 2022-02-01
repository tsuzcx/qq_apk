import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.mobileqq.widget.SlideDownFrameLayout.a;

public class arje
  implements ValueAnimator.AnimatorUpdateListener
{
  public arje(SlideDownFrameLayout paramSlideDownFrameLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    SlideDownFrameLayout.a(this.b).aj().setY(f);
    SlideDownFrameLayout.a(this.b).c(f, SlideDownFrameLayout.a(this.b).aj().getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arje
 * JD-Core Version:    0.7.0.1
 */