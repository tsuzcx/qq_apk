import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;

public class axvf
  extends axtx
{
  protected float mBaseLine;
  protected String mText;
  
  public axvf(int paramInt1, int paramInt2, TextPaint paramTextPaint, String paramString, RectF paramRectF, float paramFloat)
  {
    super(paramInt1, paramInt2, paramTextPaint, paramRectF);
    this.mText = paramString;
    this.mBaseLine = paramFloat;
  }
  
  public void a(Canvas paramCanvas, axtv paramaxtv, int paramInt1, int paramInt2)
  {
    paramaxtv.a(paramCanvas, this.bx, paramInt1, paramInt2);
  }
  
  public void f(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    String str = this.mText;
    int i = this.mText.length();
    float f1 = paramInt1;
    float f2 = this.bx.left;
    float f3 = paramInt2;
    float f4 = this.mBaseLine;
    paramCanvas.drawText(str, 0, i, f2 + f1, this.bx.top + (f3 + f4), this.mPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvf
 * JD-Core Version:    0.7.0.1
 */