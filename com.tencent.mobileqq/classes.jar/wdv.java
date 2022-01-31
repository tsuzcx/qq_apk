import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class wdv
  extends ImageSpan
{
  public wdv(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public wdv(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = paramPaint.descent;
    paramInt1 = (paramPaint.ascent + (paramInt1 + paramInt4 + paramInt4)) / 2;
    paramInt2 = paramCharSequence.getBounds().bottom / 2;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt1 - paramInt2);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdv
 * JD-Core Version:    0.7.0.1
 */