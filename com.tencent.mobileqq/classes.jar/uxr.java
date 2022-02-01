import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class uxr
  implements Animation.AnimationListener
{
  public uxr(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.startAnimation(PublicAccountImageCollectionMainActivity.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxr
 * JD-Core Version:    0.7.0.1
 */