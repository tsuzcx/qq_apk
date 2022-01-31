import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.AddressHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class zij
  implements Runnable
{
  public zij(ConditionSearchManager paramConditionSearchManager, File paramFile) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager, AddressHelper.a(ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager), this.jdField_a_of_type_JavaIoFile));
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | doParse cost " + (float)(System.currentTimeMillis() - l) / 1000.0F + " seconds");
      }
      ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager).runOnUiThread(new zik(this));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ConditionSearch.Manager", 2, "", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zij
 * JD-Core Version:    0.7.0.1
 */