import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class hho
  implements Runnable
{
  public hho(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    hhq localhhq1 = new hhq(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localhhq1.setFillEnabled(true);
    localhhq1.setDuration(700L);
    hhq localhhq2 = new hhq(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localhhq2.setFillEnabled(true);
    localhhq2.setStartTime(700L);
    localhhq2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localhhq1);
    localAnimationSet.addAnimation(localhhq2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new hhp(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hho
 * JD-Core Version:    0.7.0.1
 */