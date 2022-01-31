import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantFetcher.Invalidatable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class yfv
  implements Runnable
{
  public yfv(DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      DiyPendantFetcher.Invalidatable localInvalidatable = (DiyPendantFetcher.Invalidatable)localIterator.next();
      if ((localInvalidatable != null) && (localInvalidatable.a() != null))
      {
        if (!localHashSet.contains(localInvalidatable))
        {
          localHashSet.add(localInvalidatable);
          localInvalidatable.invalidateSelf();
          this.a.a.remove(localInvalidatable);
        }
      }
      else {
        this.a.a.remove(localInvalidatable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + this.a.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */