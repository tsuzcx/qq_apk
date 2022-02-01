import android.support.v4.util.SparseArrayCompat;

public class yvs<T>
{
  SparseArrayCompat<yvr<T>> e = new SparseArrayCompat();
  
  public yvr a(int paramInt)
  {
    return (yvr)this.e.get(paramInt);
  }
  
  public yvs<T> a(yvr<T> paramyvr)
  {
    int i = this.e.size();
    if (paramyvr != null) {
      this.e.put(i, paramyvr);
    }
    return this;
  }
  
  public void a(yvx paramyvx, T paramT, int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      yvr localyvr = (yvr)this.e.valueAt(i);
      if (localyvr.a(paramT, paramInt))
      {
        localyvr.a(paramyvx, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
  
  public int b(T paramT, int paramInt)
  {
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      if (((yvr)this.e.valueAt(i)).a(paramT, paramInt)) {
        return this.e.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public int xH()
  {
    return this.e.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvs
 * JD-Core Version:    0.7.0.1
 */