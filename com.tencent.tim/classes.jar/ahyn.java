import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.1.1;
import java.util.concurrent.atomic.AtomicInteger;

public class ahyn
  implements Animation.AnimationListener
{
  ahyn(ahym paramahym, ViewGroup paramViewGroup, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.mHandler.post(new HeartAnimator.1.1(this));
    this.a.mCounter.decrementAndGet();
    if (ahym.a(this.a) != null) {
      ahym.a(this.a).h(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.mCounter.incrementAndGet();
    if (ahym.a(this.a) != null) {
      ahym.a(this.a).g(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyn
 * JD-Core Version:    0.7.0.1
 */