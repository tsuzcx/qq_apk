import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zph
  implements Runnable
{
  public zph(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.a))
    {
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
 * Qualified Name:     zph
 * JD-Core Version:    0.7.0.1
 */