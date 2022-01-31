import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class fic
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static fic a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localfic = (fic)a.remove(0);
        localfic.b();
        return localfic;
      }
      fic localfic = new fic();
      return localfic;
    }
  }
  
  public static fic a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static fic a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static fic a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    fic localfic = a();
    localfic.f = paramInt1;
    localfic.c = paramInt2;
    localfic.d = paramInt3;
    localfic.e = paramInt4;
    return localfic;
  }
  
  public static fic a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    fic localfic = a();
    localfic.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localfic.f = 1;
      localfic.d = ExpandableListView.d(paramLong);
      return localfic;
    }
    localfic.f = 2;
    return localfic;
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
 * Qualified Name:     fic
 * JD-Core Version:    0.7.0.1
 */