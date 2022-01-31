import com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class xfm
  implements Runnable
{
  public xfm(PasswdRedBagManager paramPasswdRedBagManager) {}
  
  public void run()
  {
    try
    {
      Object localObject = PasswdRedBagManager.a(this.a).a();
      if (localObject != null)
      {
        PasswdRedBagManager.a(this.a, false);
        localObject = ((HashMap)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          this.a.c.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel()) {
        localThrowable.printStackTrace();
      }
      PasswdRedBagManager.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfm
 * JD-Core Version:    0.7.0.1
 */