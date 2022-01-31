import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class fki
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static fki a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localfki = (fki)a.remove(0);
        localfki.b();
        return localfki;
      }
      fki localfki = new fki();
      return localfki;
    }
  }
  
  public static fki a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static fki a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static fki a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    fki localfki = a();
    localfki.f = paramInt1;
    localfki.c = paramInt2;
    localfki.d = paramInt3;
    localfki.e = paramInt4;
    return localfki;
  }
  
  public static fki a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    fki localfki = a();
    localfki.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localfki.f = 1;
      localfki.d = ExpandableListView.d(paramLong);
      return localfki;
    }
    localfki.f = 2;
    return localfki;
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
 * Qualified Name:     fki
 * JD-Core Version:    0.7.0.1
 */