import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdateThumb;

public class aarw
  implements ValueAnimator.AnimatorUpdateListener
{
  public aarw(NewFlowCameraActivity.RunnableUpdateThumb paramRunnableUpdateThumb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)NewFlowCameraActivity.a(this.a.this$0).getLayoutParams();
    paramValueAnimator.width = ((int)((this.cjj - this.cjk) * f + this.cjk));
    paramValueAnimator.height = ((int)((this.cjl - this.cjm) * f + this.cjm));
    paramValueAnimator.leftMargin = ((int)((this.bqb + 0) * f + 0.0F));
    paramValueAnimator.bottomMargin = ((int)(f * (this.bqd + 0) + 0.0F));
    NewFlowCameraActivity.a(this.a.this$0).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarw
 * JD-Core Version:    0.7.0.1
 */