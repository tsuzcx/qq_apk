import android.os.Handler;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCMng;

public class zfn
  implements Runnable
{
  public zfn(HotchatSCHelper paramHotchatSCHelper, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long - Math.abs(l1 - this.b);
    if (l2 < 0L) {
      l1 = 100L;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
      return;
      l1 = l2;
      if (l2 > this.jdField_a_of_type_Long) {
        l1 = this.jdField_a_of_type_Long;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfn
 * JD-Core Version:    0.7.0.1
 */