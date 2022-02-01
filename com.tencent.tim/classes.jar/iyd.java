import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;

public class iyd
  implements Animation.AnimationListener
{
  public iyd(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.w(this.this$0.TAG, 1, "showNoAnswerAnimation, onAnimationEnd, seq[" + this.kQ + "]");
    if (this.this$0.a != null)
    {
      this.this$0.Wg = true;
      this.this$0.a.aug();
    }
    paramAnimation = this.this$0.a();
    if (paramAnimation != null) {
      paramAnimation.cP(this.kQ);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.w(this.this$0.TAG, 1, "showNoAnswerAnimation, onAnimationStart, seq[" + this.kQ + "]");
    paramAnimation = this.this$0.a();
    if (paramAnimation != null) {
      paramAnimation.cP(this.kQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyd
 * JD-Core Version:    0.7.0.1
 */