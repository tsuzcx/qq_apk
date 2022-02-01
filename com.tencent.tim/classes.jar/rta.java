import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class rta
  extends Drawable
{
  public boolean aJG;
  public int bva;
  public int bvb;
  public int bvc;
  public Bitmap cS;
  public float mAngle;
  public BitmapShader mBitmapShader;
  public Paint mPaint = new Paint(1);
  public Path mPath = new Path();
  public RectF mRect;
  public float nX;
  public float nY;
  public float nZ;
  
  private void a(int paramInt, Path paramPath)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(this.mRect, paramPath);
      return;
    case 1: 
      c(this.mRect, paramPath);
      return;
    case 2: 
      b(this.mRect, paramPath);
      return;
    }
    d(this.mRect, paramPath);
  }
  
  private void a(RectF paramRectF, Path paramPath)
  {
    if (this.aJG) {
      this.nZ = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.nX / 2.0F);
    }
    paramPath.moveTo(this.nX + paramRectF.left + this.mAngle, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.mAngle, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.top, paramRectF.right, this.mAngle + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.bottom - this.mAngle, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.nX + this.mAngle, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left + this.nX, paramRectF.bottom - this.mAngle, this.mAngle + paramRectF.left + this.nX, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.nX, this.nY + this.nZ);
    paramPath.lineTo(paramRectF.left, this.nZ + this.nY / 2.0F);
    paramPath.lineTo(paramRectF.left + this.nX, this.nZ);
    paramPath.lineTo(paramRectF.left + this.nX, paramRectF.top + this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.left + this.nX, paramRectF.top, this.mAngle + paramRectF.left + this.nX, this.mAngle + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void ar(Canvas paramCanvas)
  {
    switch (this.bvc)
    {
    }
    for (;;)
    {
      a(this.bvb, this.mPath);
      paramCanvas.drawPath(this.mPath, this.mPaint);
      do
      {
        return;
        this.mPaint.setColor(this.bva);
        break;
      } while (this.cS == null);
      if (this.mBitmapShader == null) {
        this.mBitmapShader = new BitmapShader(this.cS, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
      this.mPaint.setShader(this.mBitmapShader);
      bwl();
    }
  }
  
  private void b(RectF paramRectF, Path paramPath)
  {
    if (this.aJG) {
      this.nZ = ((paramRectF.right - paramRectF.left) / 2.0F - this.nX / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + Math.min(this.nZ, this.mAngle), paramRectF.top + this.nY);
    paramPath.lineTo(paramRectF.left + this.nZ, paramRectF.top + this.nY);
    paramPath.lineTo(paramRectF.left + this.nX / 2.0F + this.nZ, paramRectF.top);
    paramPath.lineTo(paramRectF.left + this.nX + this.nZ, paramRectF.top + this.nY);
    paramPath.lineTo(paramRectF.right - this.mAngle, paramRectF.top + this.nY);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.top + this.nY, paramRectF.right, this.mAngle + paramRectF.top + this.nY), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.bottom - this.mAngle, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.mAngle, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.mAngle, this.mAngle + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.nY + this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top + this.nY, this.mAngle + paramRectF.left, this.mAngle + paramRectF.top + this.nY), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void bwl()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(null);
    int i = this.cS.getWidth();
    int j = this.cS.getHeight();
    localMatrix.postScale(getIntrinsicWidth() / i, getIntrinsicHeight() / j);
    localMatrix.postTranslate(this.mRect.left, this.mRect.top);
    this.mBitmapShader.setLocalMatrix(localMatrix);
  }
  
  private void c(RectF paramRectF, Path paramPath)
  {
    if (this.aJG) {
      this.nZ = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.nX / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.mAngle, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.mAngle - this.nX, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle - this.nX, paramRectF.top, paramRectF.right - this.nX, this.mAngle + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right - this.nX, this.nZ);
    paramPath.lineTo(paramRectF.right, this.nZ + this.nY / 2.0F);
    paramPath.lineTo(paramRectF.right - this.nX, this.nZ + this.nY);
    paramPath.lineTo(paramRectF.right - this.nX, paramRectF.bottom - this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle - this.nX, paramRectF.bottom - this.mAngle, paramRectF.right - this.nX, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.nX, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.mAngle, this.mAngle + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.mAngle + paramRectF.left, this.mAngle + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void d(RectF paramRectF, Path paramPath)
  {
    if (this.aJG) {
      this.nZ = ((paramRectF.right - paramRectF.left) / 2.0F - this.nX / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.mAngle, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.mAngle, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.top, paramRectF.right, this.mAngle + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.nY - this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.right - this.mAngle, paramRectF.bottom - this.mAngle - this.nY, paramRectF.right, paramRectF.bottom - this.nY), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.nX + this.nZ, paramRectF.bottom - this.nY);
    paramPath.lineTo(paramRectF.left + this.nZ + this.nX / 2.0F, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left + this.nZ, paramRectF.bottom - this.nY);
    paramPath.lineTo(paramRectF.left + Math.min(this.mAngle, this.nZ), paramRectF.bottom - this.nY);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.mAngle - this.nY, this.mAngle + paramRectF.left, paramRectF.bottom - this.nY), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.mAngle);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.mAngle + paramRectF.left, this.mAngle + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  public void draw(Canvas paramCanvas)
  {
    ar(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.mRect.height();
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.mRect.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rta
 * JD-Core Version:    0.7.0.1
 */