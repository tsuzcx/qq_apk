import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.ScrollerRunnable.4;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ariu
  implements Animator.AnimatorListener
{
  public ariu(ScrollerRunnable.4 param4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.val$view.getParent() != null)
    {
      this.a.val$view.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationEnd:" + hashCode() + "," + this.a.val$view.hashCode() + "," + this.a.val$view.getParent());
    }
    if ((apmz.ma(this.a.this$0.eie)) && (this.a.this$0.uiHandler != null)) {
      this.a.this$0.uiHandler.obtainMessage(50).sendToTarget();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationStart:" + hashCode() + "," + this.a.val$view.hashCode() + "," + this.a.val$view.getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ariu
 * JD-Core Version:    0.7.0.1
 */