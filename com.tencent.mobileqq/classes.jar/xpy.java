import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class xpy
{
  public Rect a;
  public int c = 2;
  public boolean c;
  
  public static int a(Rect paramRect, Drawable paramDrawable)
  {
    float f1 = paramRect.width();
    float f2 = paramRect.height();
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    if ((f1 <= 0.0F) || (f2 <= 0.0F) || (f3 <= 0.0F) || (f4 <= 0.0F)) {}
    do
    {
      return 0;
      f1 = f1 * f4 / (f2 * f3);
      if (f1 < 1.0F) {
        return 1;
      }
    } while (f1 <= 1.0F);
    return 2;
  }
  
  public abstract int a();
  
  public Rect a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public Rect b()
  {
    return this.a;
  }
  
  public int c()
  {
    return 0;
  }
  
  public abstract Drawable c();
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpy
 * JD-Core Version:    0.7.0.1
 */