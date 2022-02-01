package taiji;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import uilib.doraemon.e;

public class aw
  extends ar
{
  private final RectF e = new RectF();
  private final Paint f = new Paint();
  private final cs g;
  
  aw(e parame, cs paramcs)
  {
    super(parame, paramcs);
    this.g = paramcs;
    this.f.setAlpha(0);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(paramcs.p());
  }
  
  private void a(Matrix paramMatrix)
  {
    this.e.set(0.0F, 0.0F, this.g.r(), this.g.q());
    paramMatrix.mapRect(this.e);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    a(this.a);
    paramRectF.set(this.e);
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.f.setColorFilter(paramColorFilter);
  }
  
  public void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int i = Color.alpha(this.g.p());
    if (i == 0) {
      return;
    }
    paramInt = (int)(paramInt / 255.0F * (i / 255.0F * ((Integer)this.d.a().b()).intValue() / 100.0F) * 255.0F);
    a(paramMatrix);
    this.f.setAlpha(paramInt);
    if (paramInt > 0) {
      paramCanvas.drawRect(this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.aw
 * JD-Core Version:    0.7.0.1
 */