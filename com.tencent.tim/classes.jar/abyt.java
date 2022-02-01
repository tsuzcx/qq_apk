import com.tencent.mobileqq.data.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abyt
{
  private List<WeakReference<abyz>> listeners = new ArrayList();
  
  public void c(abyz paramabyz)
  {
    if (this.listeners != null)
    {
      Iterator localIterator = this.listeners.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() != paramabyz));
    }
    return;
    this.listeners.add(new WeakReference(paramabyz));
  }
  
  public void cGn()
  {
    if (this.listeners != null)
    {
      int i = 0;
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          abyz localabyz = (abyz)((WeakReference)this.listeners.get(i)).get();
          if (localabyz != null) {
            localabyz.cCN();
          }
        }
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    if (this.listeners != null) {
      this.listeners.clear();
    }
  }
  
  public void d(abyz paramabyz)
  {
    if (this.listeners != null) {
      this.listeners.remove(paramabyz);
    }
  }
  
  public void g(ApolloActionData paramApolloActionData)
  {
    if (this.listeners != null)
    {
      int i = 0;
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          abyz localabyz = (abyz)((WeakReference)this.listeners.get(i)).get();
          if (localabyz != null) {
            localabyz.h(paramApolloActionData);
          }
        }
        i += 1;
      }
    }
  }
  
  public void m(Boolean paramBoolean)
  {
    if (this.listeners != null)
    {
      int i = 0;
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          abyz localabyz = (abyz)((WeakReference)this.listeners.get(i)).get();
          if (localabyz != null) {
            localabyz.n(paramBoolean);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyt
 * JD-Core Version:    0.7.0.1
 */