import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class isd
{
  public itc b;
  public int mAlpha;
  public Rect mBounds = new Rect();
  public Matrix mMatrix = new Matrix();
  public float mPivotX;
  public float mPivotY;
  public float mRotation;
  public float mScale = 1.0F;
  public long mStartTime;
  
  protected float a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) / 2;
  }
  
  public void aoo()
  {
    this.mMatrix.reset();
    this.mMatrix.preRotate(this.mRotation, this.mPivotX, this.mPivotY);
    this.mMatrix.preScale(this.mScale, this.mScale, this.mPivotX, this.mPivotY);
  }
  
  protected float b(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) / 2;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.b != null)
    {
      paramCanvas.save();
      paramCanvas.concat(this.mMatrix);
      paramPaint.setAlpha(this.mAlpha);
      this.b.draw(paramCanvas, this.mBounds, paramPaint);
      paramCanvas.restore();
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public Rect getBounds()
  {
    return this.mBounds;
  }
  
  public float getScale()
  {
    return this.mScale;
  }
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void recycle()
  {
    if (this.b != null)
    {
      this.b.recycle();
      this.b = null;
    }
    this.mMatrix = null;
    this.mBounds = null;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    this.mBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = a(paramInt1, paramInt3);
    float f2 = b(paramInt2, paramInt4);
    paramInt1 = 0;
    if (this.mPivotX != f1)
    {
      this.mPivotX = f1;
      paramInt1 = 1;
    }
    if (this.mPivotY != f2)
    {
      this.mPivotY = f2;
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        aoo();
      }
      return;
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (this.mRotation != paramFloat)
    {
      this.mRotation = paramFloat;
      aoo();
    }
  }
  
  public void setScale(float paramFloat)
  {
    if (this.mScale != paramFloat)
    {
      this.mScale = paramFloat;
      aoo();
    }
  }
  
  public abstract void update(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isd
 * JD-Core Version:    0.7.0.1
 */