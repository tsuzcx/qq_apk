import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.AddressHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class cqr
  implements Runnable
{
  public cqr(ConditionSearchManager paramConditionSearchManager, File paramFile) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager, AddressHelper.a(ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager), this.jdField_a_of_type_JavaIoFile));
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | doParse cost " + (System.currentTimeMillis() - l) / 1000L + " seconds");
    }
    ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager).runOnUiThread(new cqs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqr
 * JD-Core Version:    0.7.0.1
 */