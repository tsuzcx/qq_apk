import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;

public class xxx
  implements Runnable
{
  public xxx(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, String paramString, int paramInt) {}
  
  public void run()
  {
    NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, null);
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, -1);
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidViewView.isShown())
      {
        NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, this.jdField_a_of_type_JavaLangString);
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {}
      for (long l = 1500L;; l = 3000L)
      {
        if (this.jdField_a_of_type_Int == 3) {
          l = LbsFilterStatusManager.a();
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidOsHandler.removeCallbacks(NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity));
        if (l < 0L) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity), l);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setText("");
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidOsHandler.removeCallbacks(NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxx
 * JD-Core Version:    0.7.0.1
 */