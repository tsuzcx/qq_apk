import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.ArrayList;
import java.util.Iterator;

public class dfq
  implements Runnable
{
  public dfq(EnterpriseQQManager paramEnterpriseQQManager) {}
  
  public void run()
  {
    if ((EnterpriseQQManager.a(this.a) != null) && (EnterpriseQQManager.a(this.a) != null))
    {
      EnterpriseQQManager.a(this.a).a(this.a.a);
      ??? = EnterpriseQQManager.a(this.a).b();
      ((LBSHandler)EnterpriseQQManager.a(this.a).a(3)).a(???);
      return;
    }
    synchronized (EnterpriseQQManager.a())
    {
      if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
        break label180;
      }
      Iterator localIterator = EnterpriseQQManager.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        dfs localdfs = (dfs)localIterator.next();
        if (localdfs != null) {
          this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localdfs.a, localdfs.b, false, 0.0D, 0.0D);
        }
      }
    }
    EnterpriseQQManager.a(this.a).clear();
    label180:
    EnterpriseQQManager.a(this.a, null);
    EnterpriseQQManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dfq
 * JD-Core Version:    0.7.0.1
 */