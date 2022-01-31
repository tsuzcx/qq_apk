import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoInfo;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

public class wkq
  implements TroopBarShortVideoUploadUtil.OnUploadVideoListener
{
  public wkq(BlessResultActivity paramBlessResultActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadSuccess!");
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.g = this.a.b(this.a.d);
    if (this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1003);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStart!");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStop!");
    }
  }
  
  public void c(long paramLong)
  {
    long l = FileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo.a);
    int i = (int)(100L * paramLong / l);
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadProcess! rawLen = " + l + ",offset = " + paramLong + ",process = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */