import android.graphics.Point;
import android.view.View;

public class wwd
  implements wwb
{
  public float a(Point paramPoint, int paramInt1, int paramInt2)
  {
    return paramInt1 - paramPoint.x;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public void a(int paramInt, wwn paramwwn)
  {
    paramwwn.a(paramInt);
  }
  
  public void a(Point paramPoint1, int paramInt, Point paramPoint2)
  {
    paramPoint2.set(paramPoint1.x - paramInt, paramPoint1.y);
  }
  
  public void a(wwe paramwwe, int paramInt, Point paramPoint)
  {
    paramPoint.set(paramPoint.x + paramwwe.a(paramInt), paramPoint.y);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramPoint.x;
    int i = paramPoint.x;
    return (paramInt2 - paramInt1 < paramInt3 + paramInt4) && (i + paramInt1 > -paramInt4);
  }
  
  public boolean a(wvn paramwvn)
  {
    boolean bool = false;
    View localView1 = paramwvn.a();
    View localView2 = paramwvn.b();
    int i = -paramwvn.c();
    int j = paramwvn.getWidth();
    int k = paramwvn.c();
    if ((paramwvn.getDecoratedLeft(localView1) > i) && (paramwvn.getPosition(localView1) > 0))
    {
      i = 1;
      if ((paramwvn.getDecoratedRight(localView2) >= j + k) || (paramwvn.getPosition(localView2) >= paramwvn.getItemCount() - 1)) {
        break label102;
      }
    }
    label102:
    for (j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wwd
 * JD-Core Version:    0.7.0.1
 */