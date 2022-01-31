import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class bgw
  implements INetInfoHandler
{
  public bgw(VideoAppInterface paramVideoAppInterface) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetMobile2None");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(0);
    }
  }
  
  public void onNetMobile2Wifi()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetMobile2Wifi");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(1);
    }
  }
  
  public void onNetNone2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetNone2Mobile");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(2);
    }
  }
  
  public void onNetNone2Wifi()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetNone2Wifi");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(1);
    }
  }
  
  public void onNetWifi2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetWifi2Mobile");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(2);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "Net Change: onNetWifi2None");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgw
 * JD-Core Version:    0.7.0.1
 */