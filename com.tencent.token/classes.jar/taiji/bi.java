package taiji;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import uilib.doraemon.e;

class bi
  extends bd
{
  private final Paint e = new Paint(3);
  private final Rect f = new Rect();
  private final Rect g = new Rect();
  private final float h;
  
  bi(e parame, cs paramcs, float paramFloat)
  {
    super(parame, paramcs);
    this.h = paramFloat;
  }
  
  private Bitmap f()
  {
    String str = this.c.g();
    return this.b.b(str);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    paramMatrix = f();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.a.mapRect(paramRectF);
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
  
  public void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = f();
    if (localBitmap == null) {
      return;
    }
    this.e.setAlpha(paramInt);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.f.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.g.set(0, 0, (int)(localBitmap.getWidth() * this.h), (int)(localBitmap.getHeight() * this.h));
    paramCanvas.drawBitmap(localBitmap, this.f, this.g, this.e);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bi
 * JD-Core Version:    0.7.0.1
 */