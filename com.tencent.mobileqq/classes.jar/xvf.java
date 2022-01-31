import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class xvf
  implements Runnable
{
  public xvf(FlowCameraActivity2 paramFlowCameraActivity2, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.getString(2131428347);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.getString(2131428346), new xvg(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FlowCameraActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvf
 * JD-Core Version:    0.7.0.1
 */