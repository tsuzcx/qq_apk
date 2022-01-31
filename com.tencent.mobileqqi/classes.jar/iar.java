import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class iar
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static iar a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localiar = (iar)a.remove(0);
        localiar.b();
        return localiar;
      }
      iar localiar = new iar();
      return localiar;
    }
  }
  
  public static iar a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static iar a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static iar a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    iar localiar = a();
    localiar.f = paramInt1;
    localiar.c = paramInt2;
    localiar.d = paramInt3;
    localiar.e = paramInt4;
    return localiar;
  }
  
  public static iar a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    iar localiar = a();
    localiar.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localiar.f = 1;
      localiar.d = ExpandableListView.d(paramLong);
      return localiar;
    }
    localiar.f = 2;
    return localiar;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iar
 * JD-Core Version:    0.7.0.1
 */