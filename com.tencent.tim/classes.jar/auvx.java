import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.shapes.Shape;

public class auvx
  extends Shape
{
  private int direction;
  Path path = new Path();
  
  public auvx(int paramInt)
  {
    this.direction = paramInt;
  }
  
  private void f(float paramFloat1, float paramFloat2, int paramInt)
  {
    PointF localPointF1 = null;
    PointF localPointF3;
    PointF localPointF2;
    if (paramInt == 33)
    {
      localPointF3 = new PointF(0.0F, paramFloat2);
      localPointF2 = new PointF(paramFloat1, paramFloat2);
      localPointF1 = new PointF(paramFloat1 / 2.0F, 0.0F);
    }
    for (;;)
    {
      if (localPointF3 != null) {
        this.path.moveTo(localPointF3.x, localPointF3.y);
      }
      if (localPointF2 != null) {
        this.path.lineTo(localPointF2.x, localPointF2.y);
      }
      if (localPointF1 != null) {
        this.path.lineTo(localPointF1.x, localPointF1.y);
      }
      return;
      if (paramInt == 34)
      {
        localPointF3 = new PointF(0.0F, 0.0F);
        localPointF2 = new PointF(paramFloat1, 0.0F);
        localPointF1 = new PointF(paramFloat1 / 2.0F, paramFloat2);
      }
      else if (paramInt == 35)
      {
        localPointF3 = new PointF(0.0F, 0.0F);
        localPointF2 = new PointF(0.0F, paramFloat2);
        localPointF1 = new PointF(paramFloat1, paramFloat2 / 2.0F);
      }
      else if (paramInt == 36)
      {
        localPointF3 = new PointF(paramFloat1, 0.0F);
        localPointF2 = new PointF(0.0F, paramFloat2 / 2.0F);
        localPointF1 = new PointF(paramFloat1, paramFloat2);
      }
      else
      {
        localPointF2 = null;
        localPointF3 = null;
      }
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    f(getWidth(), getHeight(), this.direction);
    paramCanvas.drawPath(this.path, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvx
 * JD-Core Version:    0.7.0.1
 */