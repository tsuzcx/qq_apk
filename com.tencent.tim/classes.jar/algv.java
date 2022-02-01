import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class algv
  implements ValueAnimator.AnimatorUpdateListener
{
  public algv(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.hI.setScaleX(paramValueAnimator.floatValue());
    this.hI.setScaleY(paramValueAnimator.floatValue());
    float f1 = this.ac.x;
    float f2 = this.this$0.ab.x;
    float f3 = this.this$0.a.getWidth();
    float f4 = this.ac.y;
    float f5 = this.this$0.ab.y;
    float f6 = this.this$0.a.getHeight();
    this.hI.setTranslationX((f1 - f2) * f3 * paramValueAnimator.floatValue());
    this.hI.setTranslationY((f4 - f5) * f6 * paramValueAnimator.floatValue());
    this.hI.setRotation(paramValueAnimator.floatValue() * 120.0F - 120.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algv
 * JD-Core Version:    0.7.0.1
 */