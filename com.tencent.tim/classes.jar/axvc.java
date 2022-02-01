import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

public class axvc
  extends axtv
{
  private static final double dv = Math.abs(Math.tan(Math.toRadians(10.0D)));
  private float Fg;
  private float Fh;
  private Path mPath = new Path();
  
  public axvc(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mPaint.setColor(paramInt1);
    this.Fg = (ankt.dip2px(4.0F) + paramInt2);
    this.Fh = paramInt3;
  }
  
  private float M(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    return f;
  }
  
  private boolean c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 - paramFloat2 >= 0.15F * paramFloat3;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2) {}
  
  public void a(Canvas paramCanvas, ArrayList<axvf> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramCanvas == null) || (paramArrayList == null)) {
      return;
    }
    this.mPath.reset();
    RectF localRectF1 = ((axvf)paramArrayList.get(0)).bx;
    RectF localRectF2 = ((axvf)paramArrayList.get(paramArrayList.size() - 1)).bx;
    float f3 = localRectF1.width() / ((axvf)paramArrayList.get(0)).mText.length();
    this.mPath.moveTo(localRectF2.right + paramInt1 + this.Fg, localRectF2.bottom + paramInt2 + this.Fh);
    this.mPath.lineTo(localRectF2.left + paramInt1 - this.Fg, localRectF2.bottom + paramInt2 + this.Fh);
    this.mPath.lineTo(localRectF1.left + paramInt1 - this.Fg, localRectF1.top + paramInt2 - this.Fh);
    this.mPath.lineTo(localRectF1.right + paramInt1 + this.Fg, localRectF1.top + paramInt2 - this.Fh);
    double d1;
    double d2;
    if (paramArrayList.size() == 1)
    {
      d1 = dv;
      d2 = ((axvf)paramArrayList.get(0)).bx.height();
      this.mPath.lineTo((float)(localRectF2.right - d2 * d1 + paramInt1) + this.Fg, localRectF2.bottom + paramInt2 + this.Fh);
      paramCanvas.drawPath(this.mPath, this.mPaint);
      return;
    }
    float f2 = -1.0F;
    float f1 = -1.0F;
    int i = 0;
    label302:
    if (i < paramArrayList.size())
    {
      localRectF1 = ((axvf)paramArrayList.get(i)).bx;
      if ((f2 != -1.0F) && (f1 != -1.0F)) {
        break label504;
      }
      localRectF2 = ((axvf)paramArrayList.get(i + 1)).bx;
      if (!c(localRectF1.width(), localRectF2.width(), f3)) {
        break label464;
      }
      f2 = localRectF1.height() + localRectF2.height() * 0.1F;
      f1 = localRectF1.top + f2;
      d1 = localRectF1.right;
      d2 = dv;
      f2 = M((float)(d1 - f2 * d2 + this.Fg));
    }
    for (;;)
    {
      this.mPath.lineTo(paramInt1 + f2, paramInt2 + f1);
      i += 1;
      break label302;
      break;
      label464:
      f2 = M((float)(localRectF1.right - dv * localRectF1.height() + this.Fg));
      f1 = localRectF2.top;
    }
    label504:
    float f4;
    if (paramArrayList.size() == i + 1)
    {
      if (f1 == localRectF1.top)
      {
        this.mPath.lineTo(localRectF1.right + paramInt1 + this.Fg, localRectF1.top + paramInt2);
        f2 = M((float)(localRectF1.right - dv * localRectF1.height()));
      }
      for (f1 = localRectF1.bottom + this.Fh;; f1 = localRectF1.bottom + this.Fh)
      {
        this.mPath.lineTo(paramInt1 + f2, paramInt2 + f1);
        break;
        f2 = M(f2 - 0.75F * f3 + this.Fg);
        f4 = localRectF1.height();
        this.mPath.lineTo(paramInt1 + f2, f1 + f4 * 0.1F + paramInt2);
        f2 = M((float)(f2 - localRectF1.height() * 0.9F * dv));
      }
    }
    localRectF2 = ((axvf)paramArrayList.get(i + 1)).bx;
    if (f1 == localRectF1.top)
    {
      f2 = localRectF1.right;
      f4 = this.Fg;
      f1 = localRectF1.top;
      this.mPath.lineTo(f4 + f2 + paramInt1, paramInt2 + f1);
      label769:
      if (!c(localRectF1.width(), localRectF2.width(), f3)) {
        break label929;
      }
      f2 = localRectF1.bottom;
      f2 = 0.1F * localRectF2.height() + (f2 - f1);
      f1 = localRectF1.top + f2;
      d1 = localRectF1.right;
      d2 = dv;
      f2 = M((float)(d1 - f2 * d2) + this.Fg);
    }
    for (;;)
    {
      this.mPath.lineTo(paramInt1 + f2, paramInt2 + f1);
      break;
      f2 = M(f2 - 0.75F * f3 + this.Fg);
      f1 = localRectF1.height() * 0.1F + f1;
      this.mPath.lineTo(f2 + paramInt1, paramInt2 + f1);
      break label769;
      label929:
      f2 = M((float)(localRectF1.right - dv * localRectF1.height()) + this.Fg);
      f1 = localRectF2.top;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvc
 * JD-Core Version:    0.7.0.1
 */