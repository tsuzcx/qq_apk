import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.CircleProgress;

public class aarn
  implements ValueAnimator.AnimatorUpdateListener
{
  public aarn(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.this$0.wr.getLayoutParams();
    paramValueAnimator.width = ((int)(this.cjg * f));
    paramValueAnimator.height = ((int)(this.cjg * f));
    paramValueAnimator.addRule(13);
    this.this$0.wr.setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.this$0.e.getLayoutParams();
    paramValueAnimator.width = ((int)(this.cjh * f));
    paramValueAnimator.height = ((int)(f * this.cjh));
    paramValueAnimator.addRule(13);
    this.this$0.e.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarn
 * JD-Core Version:    0.7.0.1
 */