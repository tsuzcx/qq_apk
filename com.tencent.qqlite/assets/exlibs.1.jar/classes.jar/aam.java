import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class aam
  implements Animation.AnimationListener
{
  aam(aak paramaak) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "animSet onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
    this.a.a.a.post(new aan(this));
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
 * Qualified Name:     aam
 * JD-Core Version:    0.7.0.1
 */