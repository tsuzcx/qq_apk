import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.style.DynamicDrawableSpan;
import com.etrump.mixlayout.AnimatedImageDrawable;
import com.etrump.mixlayout.AnimatedImageSpan.1;

public class kk
  extends DynamicDrawableSpan
{
  private Drawable mDrawable;
  
  public kk(Drawable paramDrawable)
  {
    this.mDrawable = paramDrawable;
    paramDrawable = new Handler();
    paramDrawable.post(new AnimatedImageSpan.1(this, paramDrawable));
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = this.mDrawable;
    if ((paramCharSequence instanceof AnimatedImageDrawable)) {
      paramCharSequence = ((AnimatedImageDrawable)this.mDrawable).getDrawable();
    }
    for (;;)
    {
      if (paramCharSequence == null) {
        return;
      }
      paramCanvas.save();
      paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
      paramInt1 = paramInt2;
      if (this.mVerticalAlignment == 1) {
        paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
      }
      paramCanvas.translate(paramFloat, paramInt1);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramPaint = getDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-paramPaint.bottom);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return paramPaint.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kk
 * JD-Core Version:    0.7.0.1
 */