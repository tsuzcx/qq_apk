import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class tqf
  implements Animation.AnimationListener
{
  public tqf(ExploreAnimalView paramExploreAnimalView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(600L);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatCount(-1);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatMode(2);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    paramAnimation = (ImageView)this.a.findViewById(2131299750);
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131299751);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131297252);
    this.a.a(paramAnimation, 100L);
    this.a.a(localImageView1, 240L);
    this.a.a(localImageView2, 360L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqf
 * JD-Core Version:    0.7.0.1
 */