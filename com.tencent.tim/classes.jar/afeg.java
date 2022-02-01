import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public class afeg
  extends BitmapDrawable
{
  private int cQG;
  private int cQH;
  private int mBackgroundColor;
  private final Paint mPaint = new Paint();
  private float vX = 960.0F;
  
  public afeg(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramResources, paramBitmap);
    this.cQG = paramInt1;
    this.cQH = paramInt2;
    this.mBackgroundColor = paramInt3;
    this.vX = (6.0F * (paramResources.getDisplayMetrics().densityDpi / 160.0F));
    super.setGravity(17);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mBackgroundColor >>> 24 != 0)
    {
      this.mPaint.setColor(this.mBackgroundColor);
      paramCanvas.drawRoundRect(new RectF(getBounds()), this.vX, this.vX, this.mPaint);
    }
    super.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.cQH > 0) {
      return this.cQH;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.cQG > 0) {
      return this.cQG;
    }
    return super.getIntrinsicWidth();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha()) {
      this.mPaint.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setTargetDensity(int paramInt)
  {
    this.vX = (6.0F * (paramInt / 160.0F));
    super.setTargetDensity(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afeg
 * JD-Core Version:    0.7.0.1
 */