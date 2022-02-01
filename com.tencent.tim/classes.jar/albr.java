import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;

public class albr
  implements ValueAnimator.AnimatorUpdateListener
{
  public albr(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.K.getAnimatedValue()).intValue();
    paramValueAnimator = (FrameLayout.LayoutParams)this.val$container.getLayoutParams();
    paramValueAnimator.height = i;
    this.val$container.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albr
 * JD-Core Version:    0.7.0.1
 */