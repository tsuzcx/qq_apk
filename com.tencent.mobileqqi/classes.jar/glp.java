import com.tencent.mobileqq.subaccount.logic.SubAccountGetMessageControll;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class glp
  implements Runnable
{
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  private glp(SubAccountGetMessageControll paramSubAccountGetMessageControll) {}
  
  private void a(boolean paramBoolean)
  {
    paramBoolean = SubAccountGetMessageControll.b(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountGetMessageControll, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "LoopCycleGetMessage.startGetMsg: isOK = " + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.purge();
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new glq(this), SubAccountGetMessageControll.a(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountGetMessageControll) * 1000L);
      return;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.purge();
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
  }
  
  public void run()
  {
    try
    {
      a(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glp
 * JD-Core Version:    0.7.0.1
 */