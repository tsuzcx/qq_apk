import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class aapz
  extends aaou
{
  public aapz(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterPtvModeAnimation: onAnimationEnd <<===");
    }
    this.this$0.c.a.cwG();
    this.this$0.cwt();
    if (!this.this$0.bwR) {
      this.this$0.CJ(false);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterPtvModeAnimation: onAnimationStart ===>>");
    }
    this.this$0.zP.setVisibility(0);
    this.this$0.zQ.setBackgroundColor(this.this$0.getResources().getColor(2131165816));
    this.this$0.bwP = true;
    if (this.this$0.a != null) {
      this.this$0.a.hidePanel();
    }
    if (this.this$0.bwR)
    {
      this.this$0.ff.setOnTouchListener(this.this$0.v);
      this.this$0.ff.setLongClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapz
 * JD-Core Version:    0.7.0.1
 */