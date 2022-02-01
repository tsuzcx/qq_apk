import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class aaul
{
  public float an;
  private boolean bzB = true;
  private boolean bzC;
  StaticLayout c = null;
  private int mAlign = 2;
  public float mHeight;
  private TextPaint mPaint = new TextPaint();
  public String mText;
  public float mWidth;
  
  public aaul(String paramString, float paramFloat1, int paramInt1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, Typeface paramTypeface)
  {
    this.mPaint.setTextAlign(Paint.Align.LEFT);
    this.mAlign = paramInt2;
    this.mPaint.setColor(paramInt1);
    this.mPaint.setTextSize(paramFloat1);
    if (paramTypeface != null) {
      this.mPaint.setTypeface(paramTypeface);
    }
    if (paramFloat4 > 0.0F)
    {
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setFakeBoldText(true);
      this.mPaint.setStrokeWidth(paramFloat4);
    }
    if (paramFloat3 == -1.0F)
    {
      this.bzC = true;
      if (paramFloat2 != -1.0F) {
        break label157;
      }
      this.bzB = true;
    }
    for (;;)
    {
      setText(paramString);
      return;
      this.bzC = false;
      this.mHeight = paramFloat3;
      break;
      label157:
      this.bzB = false;
      this.mWidth = paramFloat2;
    }
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if ((TextUtils.isEmpty(this.mText)) || (paramCanvas == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.bzB) && (this.bzC))
          {
            paramCanvas.save();
            paramCanvas.drawText(this.mText, paramFloat1, paramFloat2 - this.an, this.mPaint);
            paramCanvas.restore();
            return;
          }
          if ((this.bzB) || (this.bzC)) {
            break;
          }
        } while (this.c == null);
        paramCanvas.save();
        paramCanvas.clipRect(paramFloat1, paramFloat2, this.mWidth + paramFloat1, paramFloat2 - this.an);
        paramCanvas.translate(paramFloat1, paramFloat2);
        this.c.draw(paramCanvas);
        paramCanvas.restore();
        return;
      } while ((!this.bzB) && (!this.bzC));
      if (this.bzB) {
        break;
      }
    } while (this.c == null);
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    this.c.draw(paramCanvas);
    paramCanvas.restore();
    return;
    paramCanvas.save();
    paramCanvas.drawText(this.mText, paramFloat1, paramFloat2 - this.an, this.mPaint);
    paramCanvas.restore();
  }
  
  public int getLineCount()
  {
    if (this.c != null) {
      return this.c.getLineCount();
    }
    return 1;
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.mText = paramString;
      paramString = this.mPaint.getFontMetrics();
      float f1 = paramString.bottom;
      float f2 = paramString.top;
      this.an = paramString.top;
      paramString = Layout.Alignment.ALIGN_NORMAL;
      if (this.mAlign == 2) {
        paramString = Layout.Alignment.ALIGN_CENTER;
      }
      while ((this.bzB) && (this.bzC))
      {
        this.mWidth = this.mPaint.measureText(this.mText);
        this.mHeight = (f1 - f2);
        this.c = null;
        return;
        if (this.mAlign == 1) {
          paramString = Layout.Alignment.ALIGN_NORMAL;
        }
      }
      if ((!this.bzB) && (!this.bzC))
      {
        this.c = new StaticLayout(this.mText, this.mPaint, (int)this.mWidth + 1, paramString, 1.0F, 0.0F, false);
        return;
      }
    } while ((!this.bzB) && (!this.bzC));
    if (!this.bzB)
    {
      this.c = new StaticLayout(this.mText, this.mPaint, (int)this.mWidth + 1, paramString, 1.0F, 0.0F, false);
      this.mHeight = this.c.getHeight();
      return;
    }
    this.c = null;
    this.mWidth = this.mPaint.measureText(this.mText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaul
 * JD-Core Version:    0.7.0.1
 */