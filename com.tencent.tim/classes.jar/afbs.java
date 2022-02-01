import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class afbs
  implements ValueAnimator.AnimatorUpdateListener
{
  public afbs(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.mRadius = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbs
 * JD-Core Version:    0.7.0.1
 */