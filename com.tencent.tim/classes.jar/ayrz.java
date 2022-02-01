import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ayrz
  implements Animator.AnimatorListener
{
  ayrz(ayrx paramayrx) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (ayrx.b(this.a))
    {
      ayrx.a(this.a, false);
      ayrx.g(this.a, ayrx.e(this.a));
      if (ayrx.e(this.a) != 1) {
        break label53;
      }
      this.a.afv(2);
    }
    label53:
    do
    {
      return;
      if (ayrx.e(this.a) == 3)
      {
        this.a.afv(0);
        return;
      }
    } while (ayrx.e(this.a) != 4);
    if ((ayrx.a(this.a)) && (ayrx.a(this.a) != null))
    {
      paramAnimator = (ayrx.a)ayrx.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = ayrx.a(this.a).c(ayrx.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(ayrx.e(this.a), ayrx.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      ayrx.b(this.a, false);
      this.a.afv(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + ayrx.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      ayrx.a(this.a, false);
      ayrx.f(this.a, ayrx.e(this.a));
      if (ayrx.e(this.a) != 1) {
        break label53;
      }
      this.a.afv(2);
    }
    label53:
    do
    {
      return;
      if (ayrx.e(this.a) == 3)
      {
        this.a.afv(0);
        return;
      }
    } while (ayrx.e(this.a) != 4);
    if ((ayrx.a(this.a)) && (ayrx.a(this.a) != null))
    {
      paramAnimator = (ayrx.a)ayrx.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = ayrx.a(this.a).c(ayrx.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(ayrx.e(this.a), ayrx.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      ayrx.b(this.a, false);
      this.a.afv(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + ayrx.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      ayrx.e(this.a, ayrx.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrz
 * JD-Core Version:    0.7.0.1
 */