import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class ysi
  extends ImageSpan
{
  private WeakReference<Drawable> a;
  
  public ysi(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  private Drawable a()
  {
    Object localObject = this.a;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      this.a = new WeakReference(localObject);
    }
    return localObject;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    paramInt1 = paramCharSequence.getIntrinsicHeight();
    paramInt2 = paramPaint.getFontMetricsInt().ascent;
    paramInt3 = paramPaint.getFontMetricsInt().descent;
    paramInt4 = paramCharSequence.getBounds().bottom;
    paramCanvas.translate(paramFloat, ((paramInt1 - paramInt3 + paramInt2) / 2 + (paramInt5 - paramInt4)) / 5);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = a().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.ascent = paramPaint.ascent;
      paramFontMetricsInt.descent = paramPaint.descent;
      paramFontMetricsInt.top = paramPaint.top;
      paramFontMetricsInt.bottom = paramPaint.bottom;
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysi
 * JD-Core Version:    0.7.0.1
 */