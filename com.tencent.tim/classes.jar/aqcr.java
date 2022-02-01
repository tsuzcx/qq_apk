import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;

public abstract class aqcr
  extends Drawable
{
  protected Drawable fP;
  protected Drawable fQ;
  protected int mAlpha = -1;
  protected boolean mCancelled;
  protected ColorFilter mColorFilter;
  protected int mCurState = 0;
  protected Drawable mLoadingDrawable;
  
  protected aqcr(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.mLoadingDrawable = paramDrawable1;
    this.fQ = paramDrawable2;
  }
  
  public Bitmap aF()
  {
    if ((this.fP != null) && ((this.fP instanceof BitmapDrawable))) {
      return ((BitmapDrawable)this.fP).getBitmap();
    }
    return null;
  }
  
  public void cancel()
  {
    this.mCancelled = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public Drawable getCurrDrawable()
  {
    switch (this.mCurState)
    {
    default: 
      return null;
    case 0: 
      return this.mLoadingDrawable;
    case 1: 
      return this.fP;
    }
    return this.fQ;
  }
  
  public int getIntrinsicHeight()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicWidth();
    }
    return i;
  }
  
  public int getMinimumHeight()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getMinimumHeight();
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getMinimumWidth();
    }
    return i;
  }
  
  public int getOpacity()
  {
    int i = 0;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      i = localDrawable.getOpacity();
    }
    return i;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mCurState == 1)
    {
      this.fP = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), aqff.getDrawableBitmap(this.fP));
      this.fP.setBounds(paramRect);
      if (this.mAlpha != -1) {
        this.fP.setAlpha(this.mAlpha);
      }
      invalidateSelf();
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getCurrDrawable();
    } while (localDrawable == null);
    localDrawable.setBounds(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mColorFilter = paramColorFilter;
    Drawable localDrawable = getCurrDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcr
 * JD-Core Version:    0.7.0.1
 */