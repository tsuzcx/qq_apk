import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class hvx
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static hvx a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localhvx = (hvx)a.remove(0);
        localhvx.b();
        return localhvx;
      }
      hvx localhvx = new hvx();
      return localhvx;
    }
  }
  
  public static hvx a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static hvx a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static hvx a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    hvx localhvx = a();
    localhvx.f = paramInt1;
    localhvx.c = paramInt2;
    localhvx.d = paramInt3;
    localhvx.e = paramInt4;
    return localhvx;
  }
  
  public static hvx a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    hvx localhvx = a();
    localhvx.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localhvx.f = 1;
      localhvx.d = ExpandableListView.d(paramLong);
      return localhvx;
    }
    localhvx.f = 2;
    return localhvx;
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
 * Qualified Name:     hvx
 * JD-Core Version:    0.7.0.1
 */