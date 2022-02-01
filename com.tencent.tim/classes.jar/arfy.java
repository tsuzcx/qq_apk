import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class arfy
  extends Drawable
{
  private Path T;
  private Path U;
  private ColorMatrixColorFilter a;
  private Paint cw;
  private Paint mPaint = new Paint();
  private float mRadius;
  private Paint mShaderPaint;
  private RectF rectF = new RectF();
  
  public arfy()
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mShaderPaint = new Paint();
    this.mShaderPaint.setAntiAlias(true);
    this.mShaderPaint.setStyle(Paint.Style.FILL);
    this.mShaderPaint.setColor(Color.argb(200, 0, 0, 0));
    this.mPaint.setColor(-1);
    this.T = new Path();
    this.U = new Path();
    this.cw = new Paint();
    this.cw.setAntiAlias(true);
    this.cw.setStyle(Paint.Style.FILL);
    this.cw.setColor(0);
  }
  
  public void Yx(int paramInt)
  {
    this.cw.setColor(paramInt);
    invalidateSelf();
  }
  
  public void b(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.a = paramColorMatrixColorFilter;
    this.mShaderPaint.setColorFilter(paramColorMatrixColorFilter);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.T.reset();
    this.U.reset();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if (this.mRadius > Math.min(i, j)) {}
    do
    {
      return;
      this.rectF.bottom = (j / 2.0F + this.mRadius);
      this.rectF.top = (j / 2.0F - this.mRadius);
      this.rectF.left = (i / 2.0F - this.mRadius);
      this.rectF.right = (i / 2.0F + this.mRadius);
      this.T.moveTo(0.0F, j / 2.0F);
      this.T.lineTo(0.0F, 0.0F);
      this.T.lineTo(i, 0.0F);
      this.T.lineTo(i, j / 2.0F);
      this.T.lineTo(this.rectF.right, j / 2.0F);
      this.T.arcTo(this.rectF, 0.0F, -180.0F, true);
      this.T.lineTo(this.rectF.left, j / 2.0F);
      this.T.close();
      this.U.moveTo(0.0F, j / 2.0F);
      this.U.lineTo(0.0F, j);
      this.U.lineTo(i, j);
      this.U.lineTo(i, j / 2.0F);
      this.T.lineTo(this.rectF.right, j / 2.0F);
      this.U.arcTo(this.rectF, 0.0F, 180.0F, true);
      this.T.lineTo(this.rectF.left, j / 2.0F);
      this.U.close();
      paramCanvas.drawPath(this.T, this.mPaint);
      paramCanvas.drawPath(this.U, this.mPaint);
      if (this.cw.getColor() != 0) {
        paramCanvas.drawCircle(i / 2.0F, j / 2.0F, this.mRadius, this.cw);
      }
    } while (this.a == null);
    paramCanvas.drawPath(this.T, this.mShaderPaint);
    paramCanvas.drawPath(this.U, this.mShaderPaint);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfy
 * JD-Core Version:    0.7.0.1
 */