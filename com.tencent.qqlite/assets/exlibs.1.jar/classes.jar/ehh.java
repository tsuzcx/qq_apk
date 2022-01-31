import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ehh
  extends TimerTask
{
  public ehh(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.a.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ehh
 * JD-Core Version:    0.7.0.1
 */