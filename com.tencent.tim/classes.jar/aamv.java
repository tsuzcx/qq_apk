import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class aamv
  implements ValueAnimator.AnimatorUpdateListener
{
  public aamv(LoginView paramLoginView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int i = (int)((LoginView.b(this.this$0) - LoginView.c(this.this$0)) * f + LoginView.c(this.this$0));
    int j = (int)((LoginView.d(this.this$0) - LoginView.e(this.this$0)) * f + LoginView.e(this.this$0));
    int k = (int)((LoginView.f(this.this$0) - LoginView.g(this.this$0)) * f + LoginView.g(this.this$0));
    int m = (int)((LoginView.h(this.this$0) - LoginView.i(this.this$0)) * f + LoginView.i(this.this$0));
    LoginView.a(this.this$0, i, j, k, m, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamv
 * JD-Core Version:    0.7.0.1
 */