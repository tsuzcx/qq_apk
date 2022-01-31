import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class hlt
  implements Runnable
{
  public hlt(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    hlv localhlv1 = new hlv(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localhlv1.setFillEnabled(true);
    localhlv1.setDuration(700L);
    hlv localhlv2 = new hlv(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localhlv2.setFillEnabled(true);
    localhlv2.setStartTime(700L);
    localhlv2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localhlv1);
    localAnimationSet.addAnimation(localhlv2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new hlu(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlt
 * JD-Core Version:    0.7.0.1
 */