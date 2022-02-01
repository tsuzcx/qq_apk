import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

public class jlz
  extends ClipDrawable
{
  private final Rect as = new Rect();
  private Drawable ci;
  private Drawable mDrawable;
  private int mOrientation;
  private int mThumbWidth;
  private final Rect mTmpRect = new Rect();
  
  private jlz()
  {
    super(null, 17, 1);
  }
  
  public jlz(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
  {
    super(paramDrawable1, paramInt1, 1);
    this.mDrawable = paramDrawable1;
    this.ci = paramDrawable2;
    this.mOrientation = paramInt1;
    this.mThumbWidth = paramInt2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramFloat2 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat5 = (paramFloat4 + paramFloat5) / 2.0F;
    return (paramFloat3 - paramFloat2) * (paramFloat5 - paramFloat4) / (paramFloat2 - paramFloat1) + paramFloat5;
  }
  
  private float c(float paramFloat1, float paramFloat2)
  {
    return a(0.0F, paramFloat2, paramFloat1, this.mThumbWidth / 2 + 0, paramFloat2 - this.mThumbWidth / 2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = this.mTmpRect;
    Rect localRect2 = this.as;
    Rect localRect3 = getBounds();
    float f1 = getLevel() / 10000.0F;
    localRect1.set(localRect3);
    localRect2.set(localRect3);
    float f2;
    if ((this.mOrientation & 0x1) != 0)
    {
      f2 = c(localRect3.left + localRect3.width() * f1, localRect3.width());
      localRect1.right = ((int)(f2 - this.mThumbWidth / 2) + localRect3.width() / 45);
      localRect2.left = ((int)(f2 + this.mThumbWidth / 2) - localRect3.width() / 45);
    }
    if ((this.mOrientation & 0x2) != 0)
    {
      f2 = localRect3.top;
      f1 = c(f1 * localRect3.height() + f2, localRect3.height());
      localRect1.bottom = ((int)(f1 - this.mThumbWidth / 2) + localRect3.height() / 45);
      localRect2.top = ((int)(f1 + this.mThumbWidth / 2) - localRect3.height() / 45);
    }
    paramCanvas.save();
    paramCanvas.clipRect(localRect1);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(localRect2);
    this.ci.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.ci.setBounds(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.ci.setLevel(paramInt);
    return super.onLevelChange(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.ci.setState(paramArrayOfInt);
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.ci.setAlpha(paramInt);
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.ci.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ci.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlz
 * JD-Core Version:    0.7.0.1
 */