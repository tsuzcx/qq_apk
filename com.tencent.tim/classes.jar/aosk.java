import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;

public class aosk
  implements Animation.AnimationListener
{
  public aosk(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.cOx = false;
    paramAnimation.setAnimationListener(null);
    this.this$0.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */