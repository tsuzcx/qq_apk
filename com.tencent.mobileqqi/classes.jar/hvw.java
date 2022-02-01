import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class hvw
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static hvw a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localhvw = (hvw)a.remove(0);
        localhvw.b();
        return localhvw;
      }
      hvw localhvw = new hvw();
      return localhvw;
    }
  }
  
  public static hvw a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static hvw a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static hvw a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    hvw localhvw = a();
    localhvw.f = paramInt1;
    localhvw.c = paramInt2;
    localhvw.d = paramInt3;
    localhvw.e = paramInt4;
    return localhvw;
  }
  
  public static hvw a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    hvw localhvw = a();
    localhvw.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localhvw.f = 1;
      localhvw.d = ExpandableListView.d(paramLong);
      return localhvw;
    }
    localhvw.f = 2;
    return localhvw;
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
 * Qualified Name:     hvw
 * JD-Core Version:    0.7.0.1
 */