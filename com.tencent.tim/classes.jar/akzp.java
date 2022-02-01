import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.ImageShakeAnimView;

public class akzp
  implements ValueAnimator.AnimatorUpdateListener
{
  public akzp(FormalView paramFormalView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = -(int)(FormalView.a(this.this$0) * f);
    int j = -(int)((1.0F - f) * FormalView.b(this.this$0));
    ((RelativeLayout.LayoutParams)FormalView.a(this.this$0).getLayoutParams()).topMargin = j;
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.a(this.this$0).getLayoutParams();
    paramValueAnimator.leftMargin = i;
    FormalView.a(this.this$0).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.b(this.this$0).getLayoutParams();
    paramValueAnimator.rightMargin = i;
    FormalView.b(this.this$0).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.a(this.this$0).getLayoutParams();
    paramValueAnimator.topMargin = ((int)((1.0F - f) * FormalView.c(this.this$0)));
    FormalView.a(this.this$0).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzp
 * JD-Core Version:    0.7.0.1
 */