import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class xsr
  implements Runnable
{
  public xsr(NewPreFlowCamera paramNewPreFlowCamera, String paramString) {}
  
  public void run()
  {
    if (NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera.a.setProgress((NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera) + NewPreFlowCamera.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("NewPreFlowCamera", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + (NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera) + NewPreFlowCamera.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera)) / 2);
      }
      NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera.a.setProgress(NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera));
    } while (!QLog.isColorLevel());
    QLog.d("NewPreFlowCamera", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsr
 * JD-Core Version:    0.7.0.1
 */