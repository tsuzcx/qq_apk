import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.TextPaint;

public class ilh
  extends ilc
{
  TextPaint d = new TextPaint();
  
  public ilh(ijn paramijn, boolean paramBoolean)
  {
    super(paramijn, paramBoolean);
    this.d.setStrokeWidth(4.0F);
    this.d.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public void a(Typeface paramTypeface, int paramInt, jhc.a parama)
  {
    super.a(paramTypeface, paramInt, parama);
    if (paramTypeface != null) {
      this.d.setTypeface(paramTypeface);
    }
  }
  
  protected void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.mTextSize - 8;
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setTextSize(k);
    this.mPaint.setFlags(1);
    this.d.setTextSize(k);
    this.d.setFlags(1);
    igd.aJ("ARZimuTask_SpitZimuItemTask", "onDraw width = " + paramInt1);
    float f = -this.mPaint.getFontMetrics().ascent;
    String str2 = this.a.l.toString();
    String str1 = str2;
    if (str2.length() > 10) {
      str1 = str2.substring(str2.length() - 10);
    }
    str2 = ilf.dn(str1);
    int j = str1.length();
    str1 = str1 + str2;
    igd.aJ("ARZimuTask_SpitZimuItemTask", "onDraw showText = " + str1);
    paramInt2 = str1.length();
    paramInt1 = paramInt2;
    if (paramInt2 > 13) {
      paramInt1 = 13;
    }
    int i = 2;
    k -= 6;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      if (paramInt2 >= j)
      {
        this.mPaint.setTextSize(k);
        this.d.setTextSize(k);
      }
      str2 = str1.substring(paramInt2, paramInt2 + 1);
      ilf.a(this.mPaint, this.d);
      paramCanvas.drawText(str2, i, f, this.d);
      paramCanvas.drawText(str2, i, f, this.mPaint);
      i += this.mTextSize;
      paramInt2 += 1;
    }
    igd.aJ("ARZimuTask_SpitZimuItemTask", "onDraw offsetX = " + i);
  }
  
  public int getHeight()
  {
    return this.mTextSize;
  }
  
  public int getWidth()
  {
    return this.mTextSize * 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilh
 * JD-Core Version:    0.7.0.1
 */