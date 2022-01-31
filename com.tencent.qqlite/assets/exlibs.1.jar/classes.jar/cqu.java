import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.util.Iterator;
import java.util.LinkedList;

public class cqu
  implements Runnable
{
  public cqu(ConditionSearchManager paramConditionSearchManager, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.jdField_b_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((ConditionSearchManager.IConfigListener)localIterator.next()).a(1, this.jdField_a_of_type_Boolean);
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqu
 * JD-Core Version:    0.7.0.1
 */