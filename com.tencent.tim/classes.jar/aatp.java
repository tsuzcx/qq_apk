import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

class aatp
{
  public float am = -1.0F;
  public float an = -1.0F;
  private Paint bv = new Paint();
  private float lS;
  public float mHeight;
  public String mText;
  private TextPaint mTextPaint = new TextPaint();
  public float mWidth;
  private float rJ;
  private float rK;
  ArrayList<String> si = new ArrayList();
  ArrayList<PointF> sj = new ArrayList();
  
  public aatp(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Typeface paramTypeface)
  {
    this.mTextPaint.setColor(-16777216);
    this.mTextPaint.setTextSize(paramFloat1);
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    if (paramTypeface != null) {
      this.mTextPaint.setTypeface(paramTypeface);
    }
    this.am = paramFloat5;
    this.an = paramFloat6;
    this.rJ = paramFloat2;
    this.lS = paramFloat3;
    this.rK = paramFloat4;
    setText(paramString);
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    float f1 = this.an;
    f1 = this.rJ / 2.0F + f1;
    float f2 = this.rJ / 2.0F;
    float f3 = (this.rJ - this.rK) / 2.0F;
    int i = 0;
    while (i < this.si.size())
    {
      float f4 = this.am + this.rJ / 2.0F + i * (this.rJ + this.lS);
      this.bv.setColor(-16777216);
      paramCanvas.drawCircle(f4, f1, f2, this.bv);
      this.bv.setColor(-1);
      paramCanvas.drawCircle(f4, f1, f3, this.bv);
      i += 1;
    }
  }
  
  private void drawText(Canvas paramCanvas)
  {
    float f1 = this.mTextPaint.getFontMetrics().ascent;
    int i = 0;
    while (i < this.si.size())
    {
      String str = (String)this.si.get(i);
      float f2 = this.am;
      float f3 = i;
      float f4 = this.lS;
      float f5 = this.rJ;
      float f6 = ((PointF)this.sj.get(i)).x;
      float f7 = this.an;
      paramCanvas.drawText(str, f3 * (f4 + f5) + f2 + f6, ((PointF)this.sj.get(i)).y + (f7 + f1 * -1.0F), this.mTextPaint);
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.si == null) || (this.si.size() == 0) || (paramCanvas == null) || (this.si.size() != this.sj.size())) {
      return;
    }
    drawBackground(paramCanvas);
    drawText(paramCanvas);
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.mText = paramString;
      this.si.clear();
      int i = 0;
      while (i < paramString.length())
      {
        this.si.add(paramString.substring(i, i + 1));
        i += 1;
      }
      this.mWidth = (this.si.size() * (this.rJ + this.lS));
      this.mHeight = this.rJ;
      this.sj.clear();
      paramString = this.mTextPaint.getFontMetrics();
      float f1 = paramString.bottom;
      float f2 = paramString.top;
      paramString = this.si.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = new PointF((this.rJ - this.mTextPaint.measureText((String)localObject)) / 2.0F, (this.rJ - (f1 - f2)) / 2.0F);
        this.sj.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatp
 * JD-Core Version:    0.7.0.1
 */