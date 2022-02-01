import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;

public class axdm
{
  private int eEE;
  private int height;
  private TextPaint k = new TextPaint();
  private TextPaint m = new TextPaint();
  private Bitmap r;
  private Rect rect = new Rect();
  private String text = "";
  private Canvas v;
  private int width;
  
  public axdm(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.r = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.v = new Canvas(this.r);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    while ((localRect.width() + paramInt3 > paramInt1 * 0.8F) || (localRect.height() + paramInt3 > paramInt2 * 0.8F))
    {
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public Bitmap aT()
  {
    return this.r;
  }
  
  public void draw()
  {
    setFontStyle();
    this.m.setTextSize(this.k.getTextSize());
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setStrokeWidth(this.eEE);
    this.k.setAntiAlias(true);
    this.m.setAntiAlias(true);
    this.k.getTextBounds(this.text, 0, this.text.length(), this.rect);
    float f1 = this.rect.height();
    int i = this.text.indexOf("\r\n");
    float f2;
    if (i < 0)
    {
      if (TextUtils.isEmpty(this.text)) {
        return;
      }
      a(this.text, this.m, this.width, this.height, this.eEE);
      this.k.setTextSize(this.m.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.k.ascent()) - this.k.descent()) / 2.0F;
      a(this.v, this.text, (this.width - this.m.measureText(this.text)) / 2.0F, (this.height - f1) / 2.0F + f2, this.m);
      a(this.v, this.text, (this.width - this.k.measureText(this.text)) / 2.0F, (this.height - f1) / 2.0F + f2, this.k);
    }
    for (;;)
    {
      this.v.drawBitmap(this.r, 0.0F, 0.0F, this.k);
      return;
      String str1 = this.text.substring(0, i);
      String str2 = this.text.substring("\r\n".length() + i);
      a(str1, this.m, this.width, this.height / 2, this.eEE);
      this.k.setTextSize(this.m.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.k.ascent()) - this.k.descent()) / 2.0F;
      a(this.v, str1, (this.width - this.m.measureText(str1)) / 2.0F, this.height * 0.25F - f1 / 2.0F + f2, this.m);
      a(this.v, str1, (this.width - this.k.measureText(str1)) / 2.0F, this.height * 0.25F - f1 / 2.0F + f2, this.k);
      a(this.v, str2, (this.width - this.m.measureText(str2)) / 2.0F, this.height * 0.65F - f1 / 2.0F + f2, this.m);
      a(this.v, str2, (this.width - this.k.measureText(str2)) / 2.0F, this.height * 0.65F - f1 / 2.0F + f2, this.k);
    }
  }
  
  public void release()
  {
    if ((this.r != null) && (!this.r.isRecycled())) {
      this.r.recycle();
    }
  }
  
  public void setFontStyle()
  {
    Typeface localTypeface = axck.a().c("jianqiaohei.ttf");
    this.k.setTypeface(localTypeface);
    this.m.setTypeface(localTypeface);
  }
  
  public void setOutlineColor(String paramString)
  {
    this.m.setColor(Color.parseColor(paramString));
  }
  
  public void setOutlineWidth(int paramInt)
  {
    this.eEE = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString.trim();
    if (this.r != null) {
      this.r.eraseColor(0);
    }
  }
  
  public void setTextColor(String paramString)
  {
    this.k.setColor(Color.parseColor(paramString));
  }
  
  public void setTextSize(float paramFloat)
  {
    this.k.setTextSize(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdm
 * JD-Core Version:    0.7.0.1
 */