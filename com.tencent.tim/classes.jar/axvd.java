import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public class axvd
  extends axtv
{
  private final int bYc;
  
  public axvd(int paramInt1, int paramInt2)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(paramInt1);
    this.bYc = paramInt2;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramCanvas == null) || (paramRectF == null)) {
      return;
    }
    float f1 = paramRectF.left;
    float f2 = this.bYc;
    float f3 = paramInt1;
    float f4 = paramRectF.top;
    float f5 = this.bYc;
    float f6 = paramInt2;
    float f7 = paramRectF.right;
    float f8 = this.bYc;
    float f9 = paramInt1;
    float f10 = paramRectF.bottom;
    float f11 = this.bYc;
    paramCanvas.drawRect(f3 + (f1 - f2), f6 + (f4 - f5), f9 + (f7 + f8), paramInt2 + (f10 + f11), this.mPaint);
  }
  
  public void a(Canvas paramCanvas, ArrayList<axvf> paramArrayList, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvd
 * JD-Core Version:    0.7.0.1
 */