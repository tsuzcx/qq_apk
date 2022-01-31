import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zil
  implements Runnable
{
  public zil(ConditionSearchManager paramConditionSearchManager, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a.iterator();
      while (localIterator.hasNext()) {
        ((ConditionSearchManager.IConfigListener)localIterator.next()).a(1, this.jdField_a_of_type_Boolean);
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c)) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zil
 * JD-Core Version:    0.7.0.1
 */