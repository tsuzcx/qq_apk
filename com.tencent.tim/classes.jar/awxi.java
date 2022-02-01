import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.10.1;

public class awxi
  implements Animation.AnimationListener
{
  awxi(awxg paramawxg, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    awxg.b(this.this$0).postDelayed(new VideoStoryAIScenePart.10.1(this), 1000L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    awxg.b(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxi
 * JD-Core Version:    0.7.0.1
 */