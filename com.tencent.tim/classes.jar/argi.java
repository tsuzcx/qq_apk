import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class argi
  extends ImageSpan
{
  private float BH;
  private int egM;
  
  public argi(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public argi a(float paramFloat)
  {
    this.BH = paramFloat;
    return this;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    if ((this.egM == 0) && (this.BH != 0.0F)) {
      this.egM = ((int)((paramInt5 - paramInt3) * this.BH));
    }
    paramCanvas.translate(paramFloat, paramInt1 + this.egM);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */