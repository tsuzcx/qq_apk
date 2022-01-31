import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import java.util.Queue;

public class hdi
  implements Animation.AnimationListener
{
  public hdi(MessageSubtitleView paramMessageSubtitleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((MessageSubtitleView.a(this.a, paramAnimation)) && (!this.a.a.isEmpty())) {
      MessageSubtitleView.a(this.a).post(MessageSubtitleView.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hdi
 * JD-Core Version:    0.7.0.1
 */