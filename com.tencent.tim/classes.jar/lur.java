import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lur
{
  private static lur a;
  private final List<lur.a> mObserverList = new ArrayList();
  
  public static lur a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lur();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = this.mObserverList.iterator();
      if (localIterator.hasNext()) {
        ((lur.a)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = this.mObserverList.iterator();
      if (localIterator.hasNext()) {
        ((lur.a)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(lur.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.mObserverList)
    {
      if (!this.mObserverList.contains(parama)) {
        this.mObserverList.add(parama);
      }
      return;
    }
  }
  
  public void aNy()
  {
    synchronized (this.mObserverList)
    {
      this.mObserverList.clear();
      return;
    }
  }
  
  public static class a
  {
    public void a(int paramInt, List<Long> paramList, long paramLong) {}
    
    public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lur
 * JD-Core Version:    0.7.0.1
 */