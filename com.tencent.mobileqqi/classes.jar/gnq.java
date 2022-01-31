import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class gnq
  extends TimerTask
{
  public gnq(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.a.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gnq
 * JD-Core Version:    0.7.0.1
 */