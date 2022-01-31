import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.app.QQAppInterface;

public class bhl
  implements Runnable
{
  public bhl(GAudioNotifyCenter paramGAudioNotifyCenter) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = new PhoneStatusMonitor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhl
 * JD-Core Version:    0.7.0.1
 */