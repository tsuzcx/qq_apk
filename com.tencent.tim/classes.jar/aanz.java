import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;

public class aanz
  implements ValueAnimator.AnimatorUpdateListener
{
  public aanz(TimLoginQQView paramTimLoginQQView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int i = (int)((TimLoginQQView.b(this.this$0) - TimLoginQQView.c(this.this$0)) * f + TimLoginQQView.c(this.this$0));
    int j = (int)((TimLoginQQView.d(this.this$0) - TimLoginQQView.e(this.this$0)) * f + TimLoginQQView.e(this.this$0));
    int k = (int)((TimLoginQQView.f(this.this$0) - TimLoginQQView.g(this.this$0)) * f + TimLoginQQView.g(this.this$0));
    int m = (int)((TimLoginQQView.h(this.this$0) - TimLoginQQView.i(this.this$0)) * f + TimLoginQQView.i(this.this$0));
    TimLoginQQView.a(this.this$0, i, j, k, m, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanz
 * JD-Core Version:    0.7.0.1
 */