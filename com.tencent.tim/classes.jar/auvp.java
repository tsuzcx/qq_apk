import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class auvp
  extends BaseAdapter
  implements auvq
{
  private final auvp.b a = new auvp.b();
  
  public void ld(int paramInt1, int paramInt2)
  {
    this.a.ld(paramInt1, paramInt2);
  }
  
  public void notifyDataSetChanged()
  {
    this.a.notifyChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.a.notifyInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
  
  public static abstract interface a
  {
    public abstract void lb(int paramInt1, int paramInt2);
  }
  
  class b
    extends DataSetObservable
  {
    b() {}
    
    public void ld(int paramInt1, int paramInt2)
    {
      for (;;)
      {
        int i;
        synchronized (this.mObservers)
        {
          i = this.mObservers.size() - 1;
          if (i >= 0)
          {
            DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
            if ((localDataSetObserver instanceof auvp.a)) {
              ((auvp.a)localDataSetObserver).lb(paramInt1, paramInt2);
            } else {
              localDataSetObserver.onChanged();
            }
          }
        }
        return;
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvp
 * JD-Core Version:    0.7.0.1
 */