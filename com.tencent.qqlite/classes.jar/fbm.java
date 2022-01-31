import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class fbm
  implements Runnable
{
  public fbm(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    fbo localfbo1 = new fbo(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localfbo1.setFillEnabled(true);
    localfbo1.setDuration(700L);
    fbo localfbo2 = new fbo(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localfbo2.setFillEnabled(true);
    localfbo2.setStartTime(700L);
    localfbo2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localfbo1);
    localAnimationSet.addAnimation(localfbo2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new fbn(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fbm
 * JD-Core Version:    0.7.0.1
 */