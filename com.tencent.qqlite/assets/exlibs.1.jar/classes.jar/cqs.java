import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class cqs
  implements Runnable
{
  cqs(cqr paramcqr) {}
  
  public void run()
  {
    ConditionSearchManager.a(this.a.a, false);
    if (this.a.a.jdField_b_of_type_Boolean)
    {
      if (this.a.a.jdField_b_of_type_JavaUtilLinkedList != null)
      {
        Iterator localIterator = this.a.a.jdField_b_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          ConditionSearchManager.IConfigListener localIConfigListener = (ConditionSearchManager.IConfigListener)localIterator.next();
          if (ConditionSearchManager.a(this.a.a) != null) {}
          for (boolean bool = true;; bool = false)
          {
            localIConfigListener.a(2, bool);
            break;
          }
        }
      }
      if (this.a.a.c) {
        this.a.a.a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
    }
    ConditionSearchManager.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqs
 * JD-Core Version:    0.7.0.1
 */