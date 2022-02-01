import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class rsf
  extends ImageSpan
{
  private WeakReference<Drawable> mDrawableRef;
  
  public rsf(Drawable paramDrawable)
  {
    this(paramDrawable, 4);
  }
  
  public rsf(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  private Drawable au()
  {
    Object localObject = this.mDrawableRef;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      this.mDrawableRef = new WeakReference(localObject);
    }
    return localObject;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramPaint = paramCharSequence.getBounds();
    float f;
    switch (this.mVerticalAlignment)
    {
    case 2: 
    default: 
      f = paramInt5 - paramPaint.height();
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat, f);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      f = paramInt4 - paramPaint.height();
      continue;
      f = (paramInt5 - paramInt3 - paramPaint.height()) / 2 + paramInt3;
      continue;
      f = paramInt3;
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = au().getBounds();
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetrics();
      f1 = paramPaint.top - paramPaint.ascent;
      f2 = paramPaint.bottom - paramPaint.descent;
      f3 = paramPaint.descent;
      f4 = paramPaint.ascent;
      paramInt1 = paramCharSequence.height();
      switch (this.mVerticalAlignment)
      {
      case 2: 
      default: 
        f2 = paramPaint.descent - paramInt1;
        paramFontMetricsInt.ascent = ((int)f2);
        paramFontMetricsInt.top = ((int)(f2 + f1));
      }
    }
    for (;;)
    {
      return paramCharSequence.right;
      f4 = paramPaint.descent - (f3 - f4) / 2.0F;
      f3 = f4 - paramInt1 / 2;
      f4 += paramInt1 / 2;
      paramFontMetricsInt.ascent = ((int)f3);
      paramFontMetricsInt.top = ((int)(f1 + f3));
      paramFontMetricsInt.descent = ((int)f4);
      paramFontMetricsInt.bottom = ((int)(f4 + f2));
      continue;
      f2 = -paramInt1;
      paramFontMetricsInt.ascent = (-paramInt1);
      paramFontMetricsInt.top = ((int)(f2 + f1));
      continue;
      f1 = paramInt1;
      f1 = paramPaint.ascent + f1;
      paramFontMetricsInt.descent = ((int)f1);
      paramFontMetricsInt.bottom = ((int)(f1 + f2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsf
 * JD-Core Version:    0.7.0.1
 */