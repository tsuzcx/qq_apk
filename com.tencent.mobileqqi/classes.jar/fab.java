import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class fab
  implements Runnable
{
  fab(faa paramfaa) {}
  
  public void run()
  {
    ConditionSearchManager.a(this.a.a, false);
    if (this.a.a.b)
    {
      if (this.a.a.a != null)
      {
        Iterator localIterator = this.a.a.a.iterator();
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
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
      }
      ConditionSearchManager.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fab
 * JD-Core Version:    0.7.0.1
 */