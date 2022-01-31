import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ImageSpan;

public class uaa
  extends ImageSpan
{
  public uaa(@NonNull Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    try
    {
      paramCharSequence = getDrawable();
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    try
    {
      paramCharSequence = getDrawable().getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramInt2 = paramPaint.bottom - paramPaint.top;
        int i = paramCharSequence.bottom - paramCharSequence.top;
        paramInt1 = i / 2 - paramInt2 / 4;
        i /= 2;
        paramInt2 = paramInt2 / 4 + i;
        paramFontMetricsInt.ascent = (-paramInt2);
        paramFontMetricsInt.top = (-paramInt2);
        paramFontMetricsInt.bottom = paramInt1;
        paramFontMetricsInt.descent = paramInt1;
      }
      paramInt1 = paramCharSequence.right;
      return paramInt1;
    }
    catch (Exception paramPaint) {}
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uaa
 * JD-Core Version:    0.7.0.1
 */