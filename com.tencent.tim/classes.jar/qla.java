import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class qla
  implements Animation.AnimationListener
{
  public qla(ExploreAnimalView paramExploreAnimalView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.j = new AlphaAnimation(0.5F, 1.0F);
    this.a.j.setDuration(600L);
    this.a.j.setRepeatCount(-1);
    this.a.j.setRepeatMode(2);
    this.a.a.startAnimation(this.a.j);
    paramAnimation = (ImageView)this.a.findViewById(2131366042);
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131366043);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131362978);
    this.a.b(paramAnimation, 100L);
    this.a.b(localImageView1, 240L);
    this.a.b(localImageView2, 360L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qla
 * JD-Core Version:    0.7.0.1
 */