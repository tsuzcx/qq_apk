import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.qphone.base.util.QLog;

public class fca
  implements Runnable
{
  public fca(EmoticonManagerImp paramEmoticonManagerImp, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Boolean) {
        EmoticonManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerImp", 2, "asyncReloadEmoticonKeyword,isChanged=" + this.jdField_a_of_type_Boolean);
      }
      EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fca
 * JD-Core Version:    0.7.0.1
 */