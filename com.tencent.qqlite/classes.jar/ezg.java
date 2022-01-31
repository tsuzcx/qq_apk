import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class ezg
  implements Runnable
{
  public ezg(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    ezi localezi1 = new ezi(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localezi1.setFillEnabled(true);
    localezi1.setDuration(700L);
    ezi localezi2 = new ezi(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localezi2.setFillEnabled(true);
    localezi2.setStartTime(700L);
    localezi2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localezi1);
    localAnimationSet.addAnimation(localezi2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new ezh(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ezg
 * JD-Core Version:    0.7.0.1
 */