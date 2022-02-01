import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;

public class arfo
  extends arfz
{
  private PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private int efI = -872415232;
  private int efJ = 0;
  private float mCenterY;
  private int mCircleRadius;
  private Paint mPaint = new Paint();
  
  public void Yr(int paramInt)
  {
    this.mCircleRadius = paramInt;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    int i = localRect.centerX();
    int j = this.mCircleRadius;
    paramCanvas.clipRect(localRect);
    paramCanvas.drawColor(this.efI);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(this.efJ);
    this.mPaint.setXfermode(this.b);
    paramCanvas.drawCircle(i, this.mCenterY, j, this.mPaint);
    paramCanvas.restore();
  }
  
  public void setCenterY(float paramFloat)
  {
    this.mCenterY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfo
 * JD-Core Version:    0.7.0.1
 */