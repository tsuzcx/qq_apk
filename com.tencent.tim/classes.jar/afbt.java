import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class afbt
  implements Animation.AnimationListener
{
  public afbt(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.Rh.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.iD.setVisibility(0);
    this.this$0.cYq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbt
 * JD-Core Version:    0.7.0.1
 */