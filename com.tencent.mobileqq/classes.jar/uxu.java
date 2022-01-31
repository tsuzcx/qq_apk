import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class uxu
  implements Animation.AnimationListener
{
  uxu(uxt paramuxt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationEnd " + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationRepeat " + paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationStart " + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */