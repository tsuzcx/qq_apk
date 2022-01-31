import com.tencent.lbsapi.QLBSNotification;
import com.tencent.lbsapi.QLBSService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.qphone.base.util.QLog;

public class cwh
  implements QLBSNotification
{
  public cwh(QQAppInterface paramQQAppInterface) {}
  
  public void onLocationNotification(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBS", 2, "onLocationNotification:" + paramInt);
    }
    if (paramInt == 1) {
      this.a.jdField_a_of_type_ArrayOfByte = this.a.jdField_a_of_type_ComTencentLbsapiQLBSService.getDeviceData();
    }
    this.a.jdField_a_of_type_ComTencentLbsapiQLBSService.stopLocation();
    synchronized (this.a.jdField_a_of_type_ComTencentLbsapiQLBSService)
    {
      this.a.jdField_a_of_type_ComTencentLbsapiQLBSService.notifyAll();
      ReportLog.a("LBS", "onLocationNotification result:" + paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwh
 * JD-Core Version:    0.7.0.1
 */