import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class fhx
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static fhx a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localfhx = (fhx)a.remove(0);
        localfhx.b();
        return localfhx;
      }
      fhx localfhx = new fhx();
      return localfhx;
    }
  }
  
  public static fhx a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static fhx a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static fhx a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    fhx localfhx = a();
    localfhx.f = paramInt1;
    localfhx.c = paramInt2;
    localfhx.d = paramInt3;
    localfhx.e = paramInt4;
    return localfhx;
  }
  
  public static fhx a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    fhx localfhx = a();
    localfhx.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localfhx.f = 1;
      localfhx.d = ExpandableListView.d(paramLong);
      return localfhx;
    }
    localfhx.f = 2;
    return localfhx;
  }
  
  private void b()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public long a()
  {
    if (this.f == 1) {
      return ExpandableListView.b(this.c, this.d);
    }
    return ExpandableListView.c(this.c);
  }
  
  public void a()
  {
    synchronized (a)
    {
      if (a.size() < 5) {
        a.add(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhx
 * JD-Core Version:    0.7.0.1
 */