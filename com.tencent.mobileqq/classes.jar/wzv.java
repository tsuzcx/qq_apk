import com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import java.util.Iterator;
import java.util.List;

public class wzv
  implements Runnable
{
  public wzv(PasswdRedBagManager paramPasswdRedBagManager) {}
  
  public void run()
  {
    Iterator localIterator = PasswdRedBagManager.a(this.a).a().iterator();
    while (localIterator.hasNext())
    {
      PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)localIterator.next();
      PasswdRedBagManager.a(this.a, localPasswdRedBagInfo);
      this.a.a(false, localPasswdRedBagInfo.a, localPasswdRedBagInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzv
 * JD-Core Version:    0.7.0.1
 */