import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

public class afej
  extends ColorDrawable
{
  private final int cQI;
  private final int cQJ;
  private float mCornerRadius;
  private final Paint mPaint;
  private final RectF mRect = new RectF();
  
  public afej(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.mCornerRadius = paramFloat;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(paramInt1);
    this.mRect.set(0.0F, 0.0F, paramInt2, paramInt3);
    this.cQI = paramInt2;
    this.cQJ = paramInt3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(this.mRect, this.mCornerRadius, this.mCornerRadius, this.mPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.cQJ;
  }
  
  public int getIntrinsicWidth()
  {
    return this.cQI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afej
 * JD-Core Version:    0.7.0.1
 */