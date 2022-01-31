import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.widget.CircleProgress;
import java.util.concurrent.atomic.AtomicInteger;

public class xxn
  implements Runnable
{
  public xxn(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.k) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.f >= 60000)
        {
          i = 10000;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.D) {
            break label142;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i * 1.0F / (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.p * 10));
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(100.0F);
        }
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.f % 10000;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.f;
        break;
        label142:
        if (!NewFlowCameraActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) {
          break label181;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i * 1.0F / (NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) * 10));
      }
      label181:
      CircleProgress localCircleProgress = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
      float f = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.i) {}
      for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c() + 1;; i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c())
      {
        localCircleProgress.setProgress(1.0F * f / i);
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxn
 * JD-Core Version:    0.7.0.1
 */