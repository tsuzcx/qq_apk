import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zij
  implements Runnable
{
  public zij(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.a))
    {
      PhoneContactManagerImp.a(this.a).getPreferences();
      try
      {
        Iterator localIterator = PhoneContactManagerImp.a(this.a).iterator();
        while (localIterator.hasNext()) {
          ((PhoneContactManager.IPhoneContactListener)localIterator.next()).a(this.a.a);
        }
        localObject = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zij
 * JD-Core Version:    0.7.0.1
 */