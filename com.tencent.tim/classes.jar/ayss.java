import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class ayss
  implements Animator.AnimatorListener
{
  ayss(aysn paramaysn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + aysn.c(this.a) + " isrun:" + aysn.a(this.a));
    }
    if (this.a.isRunning())
    {
      aysn.e(this.a, aysn.c(this.a));
      if (aysn.c(this.a) != 2) {
        break label105;
      }
      this.a.afv(3);
    }
    for (;;)
    {
      aysn.a(this.a, false);
      return;
      label105:
      if (aysn.c(this.a) == 4) {
        this.a.afv(5);
      } else if (aysn.c(this.a) == 5) {
        this.a.afv(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + aysn.c(this.a) + " isrun:" + aysn.a(this.a));
    }
    if (this.a.isRunning())
    {
      aysn.d(this.a, aysn.c(this.a));
      if (aysn.c(this.a) != 2) {
        break label105;
      }
      this.a.afv(3);
    }
    for (;;)
    {
      aysn.a(this.a, false);
      return;
      label105:
      if (aysn.c(this.a) == 4)
      {
        this.a.afv(0);
      }
      else if (aysn.c(this.a) == 5)
      {
        this.a.afv(1);
        aysn.a(this.a, 0);
      }
      else if (aysn.c(this.a) == 6)
      {
        this.a.afv(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + aysn.c(this.a) + " isrun:" + aysn.a(this.a));
    }
    if (this.a.isRunning()) {
      aysn.c(this.a, aysn.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayss
 * JD-Core Version:    0.7.0.1
 */