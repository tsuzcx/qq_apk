import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class vui
  implements Animation.AnimationListener
{
  public vui(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131380602);
    ImageView localImageView = (ImageView)this.a.findViewById(2131380603);
    PublicAccountImageCollectionMainActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */