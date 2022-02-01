import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class afbu
  implements ValueAnimator.AnimatorUpdateListener
{
  public afbu(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.mRadius = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbu
 * JD-Core Version:    0.7.0.1
 */