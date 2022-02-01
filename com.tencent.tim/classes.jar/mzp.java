import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class mzp
  implements Animation.AnimationListener
{
  mzp(mzn parammzn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)mzn.a(this.this$0).findViewById(2131381397);
    ImageView localImageView = (ImageView)mzn.a(this.this$0).findViewById(2131381398);
    mzn.a(this.this$0, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzp
 * JD-Core Version:    0.7.0.1
 */