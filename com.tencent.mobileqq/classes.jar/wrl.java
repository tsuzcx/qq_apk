import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class wrl
  implements Animation.AnimationListener
{
  wrl(wrj paramwrj, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    wrj.a(this.jdField_a_of_type_Wrj).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrl
 * JD-Core Version:    0.7.0.1
 */