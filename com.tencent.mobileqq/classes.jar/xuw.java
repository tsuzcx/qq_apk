import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowPlusPanel;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.qphone.base.util.QLog;

public class xuw
  extends AnimatorAdapter
{
  public xuw(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationEnd <<===");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowPlusPanel != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowPlusPanel.a();
    }
    this.a.k();
    this.a.e.setVisibility(4);
    this.a.e.setPadding(0, 0, 0, 0);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.y();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationStart ===>>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuw
 * JD-Core Version:    0.7.0.1
 */