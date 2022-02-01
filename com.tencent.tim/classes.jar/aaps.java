import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class aaps
  extends aaou
{
  public aaps(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationEnd <<===");
    }
    if (this.this$0.a != null) {
      this.this$0.a.cwK();
    }
    this.this$0.cwr();
    this.this$0.zP.setVisibility(4);
    this.this$0.zP.setPadding(0, 0, 0, 0);
    if ((this.this$0.c != null) && (this.this$0.c.a != null)) {
      this.this$0.c.a.cwH();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationStart ===>>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaps
 * JD-Core Version:    0.7.0.1
 */