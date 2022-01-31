import com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class wzw
  implements Runnable
{
  public wzw(PasswdRedBagManager paramPasswdRedBagManager) {}
  
  public void run()
  {
    Iterator localIterator = PasswdRedBagManager.a(this.a).a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.a.c.put(localEntry.getKey(), localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzw
 * JD-Core Version:    0.7.0.1
 */