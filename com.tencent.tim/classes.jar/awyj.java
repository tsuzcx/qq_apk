import android.graphics.Point;
import android.view.View;

public abstract class awyj
{
  abstract awyj.a a();
  
  static abstract interface a
  {
    public abstract float a(Point paramPoint, int paramInt1, int paramInt2);
    
    public abstract void a(int paramInt, spl paramspl);
    
    public abstract void a(Point paramPoint1, int paramInt, Point paramPoint2);
    
    public abstract void a(awwo paramawwo, int paramInt, Point paramPoint);
    
    public abstract boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract boolean a(awyh paramawyh);
    
    public abstract int bf(int paramInt1, int paramInt2);
    
    public abstract int bg(int paramInt1, int paramInt2);
    
    public abstract int bh(int paramInt1, int paramInt2);
    
    public abstract boolean canScrollHorizontally();
    
    public abstract boolean canScrollVertically();
    
    public abstract int lC(int paramInt);
    
    public abstract int lD(int paramInt);
  }
  
  public static class b
    extends awyj
  {
    awyj.a a()
    {
      return new awyj.c();
    }
  }
  
  public static class c
    implements awyj.a
  {
    public float a(Point paramPoint, int paramInt1, int paramInt2)
    {
      return paramInt1 - paramPoint.x;
    }
    
    public void a(int paramInt, spl paramspl)
    {
      paramspl.offsetChildrenHorizontal(paramInt);
    }
    
    public void a(Point paramPoint1, int paramInt, Point paramPoint2)
    {
      paramPoint2.set(paramPoint1.x - paramInt, paramPoint1.y);
    }
    
    public void a(awwo paramawwo, int paramInt, Point paramPoint)
    {
      paramPoint.set(paramPoint.x + paramawwo.lA(paramInt), paramPoint.y);
    }
    
    public boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramPoint.x;
      int i = paramPoint.x;
      return (paramInt2 - paramInt1 < paramInt3 + paramInt4) && (i + paramInt1 > -paramInt4);
    }
    
    public boolean a(awyh paramawyh)
    {
      boolean bool = false;
      View localView1 = paramawyh.cJ();
      View localView2 = paramawyh.cK();
      int i = -paramawyh.QQ();
      int j = paramawyh.getWidth();
      int k = paramawyh.QQ();
      if ((paramawyh.getDecoratedLeft(localView1) > i) && (paramawyh.getPosition(localView1) > 0))
      {
        i = 1;
        if ((paramawyh.getDecoratedRight(localView2) >= j + k) || (paramawyh.getPosition(localView2) >= paramawyh.getItemCount() - 1)) {
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
    
    public int bf(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    public int bg(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    public int bh(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    public boolean canScrollHorizontally()
    {
      return true;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public int lC(int paramInt)
    {
      return paramInt;
    }
    
    public int lD(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyj
 * JD-Core Version:    0.7.0.1
 */