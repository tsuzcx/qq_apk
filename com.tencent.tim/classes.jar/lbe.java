import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lbe
{
  private static volatile lbe a;
  private final List<lbf> mObserverList = new ArrayList();
  
  public static lbe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lbe();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<lbm> paramList, int paramInt2)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = new ArrayList(this.mObserverList).iterator();
      if (localIterator.hasNext()) {
        ((lbf)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = new ArrayList(this.mObserverList).iterator();
      if (localIterator.hasNext()) {
        ((lbf)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void a(lbf paramlbf)
  {
    if (paramlbf == null) {}
    while (this.mObserverList.contains(paramlbf)) {
      return;
    }
    synchronized (this.mObserverList)
    {
      this.mObserverList.add(paramlbf);
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = new ArrayList(this.mObserverList).iterator();
      if (localIterator.hasNext()) {
        ((lbf)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void b(lbf paramlbf)
  {
    synchronized (this.mObserverList)
    {
      this.mObserverList.remove(paramlbf);
      return;
    }
  }
  
  public void o(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = new ArrayList(this.mObserverList).iterator();
      if (localIterator.hasNext()) {
        ((lbf)localIterator.next()).o(paramInt, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbe
 * JD-Core Version:    0.7.0.1
 */