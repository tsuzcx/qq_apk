import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

public class axtr
  extends ReplacementSpan
{
  private final float Ey;
  private final float mSize;
  
  public axtr(float paramFloat1, float paramFloat2)
  {
    this.mSize = paramFloat1;
    this.Ey = paramFloat2;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if (paramCharSequence != null)
    {
      paramPaint.setTextSize(this.mSize);
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt4, paramPaint);
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    paramPaint.setTextSize(this.mSize);
    if (paramFontMetricsInt != null)
    {
      Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.top = ((int)(localFontMetricsInt.top * this.Ey));
      paramFontMetricsInt.ascent = ((int)(localFontMetricsInt.ascent * this.Ey));
      paramFontMetricsInt.descent = localFontMetricsInt.descent;
      paramFontMetricsInt.bottom = localFontMetricsInt.bottom;
      paramFontMetricsInt.leading = localFontMetricsInt.leading;
    }
    return Math.round(paramPaint.measureText(paramCharSequence, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtr
 * JD-Core Version:    0.7.0.1
 */