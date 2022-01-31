import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class xod
  implements Runnable
{
  public xod(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getString(2131428347);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getString(2131428346), new xoe(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("PTV.NewFlowCameraActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xod
 * JD-Core Version:    0.7.0.1
 */