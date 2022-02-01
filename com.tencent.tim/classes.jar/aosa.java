import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;

public class aosa
  implements Animation.AnimationListener
{
  public aosa(AudioRecordFragment paramAudioRecordFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.root.clearAnimation();
    this.a.HQ.setBackgroundColor(2130706432);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosa
 * JD-Core Version:    0.7.0.1
 */