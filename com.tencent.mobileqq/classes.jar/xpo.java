import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xpo
  implements Runnable
{
  public xpo(NewPreFlowCamera paramNewPreFlowCamera, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "onStatusChanged: " + this.jdField_a_of_type_Boolean + " error:" + this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131432961, 0).a();
      NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera, -1);
      return;
    }
    NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera, 101);
    NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpo
 * JD-Core Version:    0.7.0.1
 */