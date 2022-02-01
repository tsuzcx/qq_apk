import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;

public class autr
  extends AnimatorListenerAdapter
{
  public autr(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 1;
    super.onAnimationEnd(paramAnimator);
    if (this.a.dkq)
    {
      if (abrj.a(FitSystemWindowsRelativeLayout.a(this.a)).cqT == 1) {
        i = 0;
      }
      if (i != 0)
      {
        abrb.b(FitSystemWindowsRelativeLayout.a(this.a), "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("placeholder.sprite", 2, "show sprite (normal) in fullscreen.");
        }
      }
      this.a.dkq = false;
      this.a.o.setImageDrawable(null);
      this.a.removeView(this.a.o);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autr
 * JD-Core Version:    0.7.0.1
 */