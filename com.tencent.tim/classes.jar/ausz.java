import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class ausz
  extends Drawable
{
  Rect db = new Rect();
  private int esu;
  private Bitmap mBitmap;
  private int mDisplayHeight;
  private int mDisplayWidth;
  private int mHeight;
  private Paint mPaint = new Paint();
  Rect mSrcRect = new Rect();
  private int mTop;
  private int mWidth;
  
  public ausz(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.mBitmap = paramBitmap;
    this.mDisplayWidth = paramInt1;
    this.mDisplayHeight = paramInt2;
    if (this.mDisplayWidth <= 0) {
      this.mDisplayWidth = 1080;
    }
    if (this.mDisplayHeight <= 0) {
      this.mDisplayHeight = 1920;
    }
    this.esu = (this.mDisplayHeight * this.mWidth / this.mDisplayWidth);
    if (this.mHeight > this.esu) {
      this.mTop = (this.mHeight - this.esu);
    }
    if (QLog.isColorLevel())
    {
      QLog.i("UserGuideWeiShiActivity", 2, "displayWidth" + paramInt1 + " displayHeight " + paramInt2);
      QLog.i("UserGuideWeiShiActivity", 2, "mWidth" + this.mWidth + " mHeight " + this.mHeight);
      QLog.i("UserGuideWeiShiActivity", 2, "mNewBitmMapHeight" + this.esu + " mTop " + this.mTop);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mSrcRect.set(0, this.mTop, this.mWidth, this.mHeight);
    this.db.set(0, 0, this.mWidth, this.esu);
    paramCanvas.drawBitmap(this.mBitmap, this.mSrcRect, this.db, this.mPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.esu;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausz
 * JD-Core Version:    0.7.0.1
 */