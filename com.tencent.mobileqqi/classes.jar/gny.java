import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;

public class gny
  implements Animation.AnimationListener
{
  public gny(QZoneShareAlbumAssistantActivity paramQZoneShareAlbumAssistantActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QZoneShareAlbumAssistantActivity.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gny
 * JD-Core Version:    0.7.0.1
 */