import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class amfz
  extends argi
{
  public boolean cCu = true;
  private Drawable fv;
  public float left;
  private int mHeight;
  private Paint mPaint;
  private String mText;
  private int mTextColor;
  private float[] mTextWidths;
  private int mWidth;
  public float top;
  
  public amfz(Drawable paramDrawable1, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable2, float paramFloat)
  {
    super(paramDrawable1, paramInt1);
    this.mText = paramString;
    this.mTextColor = paramInt2;
    this.mTextWidths = new float[this.mText.length()];
    this.fv = paramDrawable2;
    this.mPaint = new Paint(1);
    this.mPaint.setTextSize(paramFloat);
    this.mPaint.setColor(paramInt2);
  }
  
  public int IF()
  {
    getSize(this.mPaint, this.mText, 0, this.mText.length(), this.mPaint.getFontMetricsInt());
    return this.mWidth;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (this.cCu) {}
    for (int i = this.mPaint.getFontMetricsInt().top + paramInt4;; i = paramInt4)
    {
      if ((this.mWidth > 0) && (this.mHeight > 0))
      {
        this.fv.setBounds(0, i, this.mWidth, this.mHeight + i);
        this.fv.draw(paramCanvas);
      }
      super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
      float f = getDrawable().getBounds().right;
      paramInt1 = this.mPaint.getFontMetricsInt().ascent;
      if (this.cCu) {}
      for (;;)
      {
        paramCanvas.drawText(this.mText, paramFloat + f, paramInt4, this.mPaint);
        return;
        paramInt4 -= paramInt1;
      }
    }
  }
  
  public int getHeight()
  {
    Rect localRect = getDrawable().getBounds();
    Paint.FontMetricsInt localFontMetricsInt = this.mPaint.getFontMetricsInt();
    int i = localRect.bottom;
    int j = -localFontMetricsInt.top;
    this.mHeight = Math.max(i, localFontMetricsInt.bottom + j);
    return this.mHeight;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    this.mPaint.getTextWidths(this.mText, this.mTextWidths);
    paramInt1 = paramCharSequence.right;
    paramFontMetricsInt = this.mTextWidths;
    int i = paramFontMetricsInt.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      float f = paramFontMetricsInt[paramInt2];
      paramInt1 = (int)(paramInt1 + f);
      paramInt2 += 1;
    }
    this.mWidth = paramInt1;
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt2 = paramCharSequence.bottom;
    i = -paramPaint.top;
    this.mHeight = Math.max(paramInt2, paramPaint.bottom + i);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfz
 * JD-Core Version:    0.7.0.1
 */