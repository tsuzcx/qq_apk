import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class zii
  implements Runnable
{
  public zii(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    Object localObject1 = PhoneContactManagerImp.a(this.a).a();
    ((EntityTransaction)localObject1).a();
    try
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend)
        {
          localPhoneContact.isNewRecommend = false;
          PhoneContactManagerImp.a(this.a).a(localPhoneContact);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
    localObject1 = PhoneContactManagerImp.a(this.a);
    if (localObject1 != null) {
      ((ContactBinded)localObject1).isReaded = true;
    }
    PhoneContactManagerImp.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zii
 * JD-Core Version:    0.7.0.1
 */