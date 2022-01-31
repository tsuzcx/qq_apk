import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class ezb
  implements Runnable
{
  public ezb(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    ezd localezd1 = new ezd(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localezd1.setFillEnabled(true);
    localezd1.setDuration(700L);
    ezd localezd2 = new ezd(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localezd2.setFillEnabled(true);
    localezd2.setStartTime(700L);
    localezd2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localezd1);
    localAnimationSet.addAnimation(localezd2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new ezc(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ezb
 * JD-Core Version:    0.7.0.1
 */