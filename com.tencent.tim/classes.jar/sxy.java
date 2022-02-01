import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class sxy
{
  public boolean isImgCenterCropMode;
  public int selectStatus = 2;
  public Rect thubmRect;
  
  public static int getCutValue(Rect paramRect, Drawable paramDrawable)
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
  
  public abstract Drawable getAnimationDrawable();
  
  public abstract int getCutValue();
  
  public Rect getStartSrcRect()
  {
    return null;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    return this.thubmRect;
  }
  
  public boolean needAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void setSelected(int paramInt)
  {
    this.selectStatus = paramInt;
  }
  
  public int uG()
  {
    return this.selectStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxy
 * JD-Core Version:    0.7.0.1
 */