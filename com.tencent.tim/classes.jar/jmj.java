import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.widget.stageview.StageEffectView.5.1;
import com.tencent.av.widget.stageview.StageMemberView;

public class jmj
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.aaw) {
      return;
    }
    this.a.setBackgroundDrawable(this.cl);
    this.gZ.post(new StageEffectView.5.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmj
 * JD-Core Version:    0.7.0.1
 */