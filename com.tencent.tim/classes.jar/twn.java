import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.layer.Layer;

public class twn
  extends twe
{
  private final Layer a;
  private final Paint paint = new Paint();
  private final RectF rect = new RectF();
  
  twn(trz paramtrz, Layer paramLayer)
  {
    super(paramtrz, paramLayer);
    this.a = paramLayer;
    this.paint.setAlpha(0);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setColor(paramLayer.getSolidColor());
  }
  
  private void b(Matrix paramMatrix)
  {
    this.rect.set(0.0F, 0.0F, this.a.getSolidWidth(), this.a.getSolidHeight());
    paramMatrix.mapRect(this.rect);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    b(this.boundsMatrix);
    paramRectF.set(this.rect);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int i = Color.alpha(this.a.getSolidColor());
    if (i == 0) {}
    do
    {
      return;
      float f1 = paramInt / 255.0F;
      float f2 = i / 255.0F;
      paramInt = (int)(((Integer)this.b.d().getValue()).intValue() * f2 / 100.0F * f1 * 255.0F);
      this.paint.setAlpha(paramInt);
    } while (paramInt <= 0);
    b(paramMatrix);
    paramCanvas.drawRect(this.rect, this.paint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twn
 * JD-Core Version:    0.7.0.1
 */