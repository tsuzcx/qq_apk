import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class otx
  implements Animation.AnimationListener
{
  public otx(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.this$0.findViewById(2131381397);
    ImageView localImageView = (ImageView)this.this$0.findViewById(2131381398);
    PublicAccountImageCollectionMainActivity.a(this.this$0, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otx
 * JD-Core Version:    0.7.0.1
 */