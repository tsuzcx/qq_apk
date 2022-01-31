import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class hhp
  implements Runnable
{
  public hhp(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    hhr localhhr1 = new hhr(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localhhr1.setFillEnabled(true);
    localhhr1.setDuration(700L);
    hhr localhhr2 = new hhr(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localhhr2.setFillEnabled(true);
    localhhr2.setStartTime(700L);
    localhhr2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localhhr1);
    localAnimationSet.addAnimation(localhhr2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new hhq(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhp
 * JD-Core Version:    0.7.0.1
 */