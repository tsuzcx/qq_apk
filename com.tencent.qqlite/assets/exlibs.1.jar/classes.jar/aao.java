import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class aao
  implements Animation.AnimationListener
{
  aao(aam paramaam) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "animSet onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
    this.a.a.a.post(new aap(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "animSet onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "animSet onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aao
 * JD-Core Version:    0.7.0.1
 */