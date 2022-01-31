import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class zry
  implements Runnable
{
  public zry(QQAppInterface paramQQAppInterface, long paramLong, Intent paramIntent) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "runNext, ThreadManager.excute, cost=" + (l1 - l2));
    }
    QQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.decrementAndGet();
    QQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zry
 * JD-Core Version:    0.7.0.1
 */