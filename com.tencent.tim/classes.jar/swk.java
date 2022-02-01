import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.widgets.TabLayout;
import java.io.PrintStream;

public class swk
  implements ValueAnimator.AnimatorUpdateListener
{
  public swk(TabLayout paramTabLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, int paramInt5) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    System.out.println("value = " + f);
    int i = 0;
    while (i < this.val$from - this.bzG)
    {
      paramValueAnimator = this.c.getChildAt(this.bzH + i);
      if (paramValueAnimator != null) {
        paramValueAnimator.setTranslationX(this.val$width * f);
      }
      i += 1;
    }
    this.qM.setTranslationX(f * -this.aiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     swk
 * JD-Core Version:    0.7.0.1
 */