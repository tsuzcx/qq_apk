import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.qphone.base.util.QLog;

public class xpp
  implements Runnable
{
  public xpp(NewPreFlowCamera paramNewPreFlowCamera, int paramInt) {}
  
  public void run()
  {
    NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "onDownloadProgress mGestureState=" + NewPreFlowCamera.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera) + " mVideoState=" + NewPreFlowCamera.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera) + "mFilterSoState=" + NewPreFlowCamera.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera));
    }
    NewPreFlowCamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpp
 * JD-Core Version:    0.7.0.1
 */