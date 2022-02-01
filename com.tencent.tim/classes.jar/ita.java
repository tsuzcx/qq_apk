import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;

public class ita
  extends isd
{
  public Rect ai = new Rect();
  public int ats;
  public int att;
  public LinearGradient f;
  public int mColor;
  public int mHeight;
  
  public void aqm()
  {
    this.f = new LinearGradient(0.0F, 0.0F, 0.0F, this.ai.bottom, this.mColor, 0, Shader.TileMode.CLAMP);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setAlpha(this.att);
    paramPaint.setShader(this.f);
    paramCanvas.drawRect(this.ai, paramPaint);
    paramPaint.setAlpha(255);
    paramPaint.setShader(null);
    super.draw(paramCanvas, paramPaint);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mHeight = (paramInt1 * 454 / 750);
    this.ats = (paramInt1 * -190 / 750);
    this.ai.set(0, 0, paramInt1, paramInt2 / 2);
    aqm();
  }
  
  public void recycle()
  {
    super.recycle();
    this.f = null;
    this.ai = null;
  }
  
  public void setColor(int paramInt)
  {
    if (this.mColor != paramInt)
    {
      this.mColor = paramInt;
      aqm();
    }
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int j = 0;
    int i;
    if ((paramLong > 0L) && (paramLong < 200L))
    {
      i = (int)(255L * paramLong / 200L);
      setAlpha(i);
      if (paramLong >= 200L) {
        break label164;
      }
      this.att = ((int)(255L * paramLong / 200L));
    }
    for (;;)
    {
      i = (int)(this.ats - paramLong * this.ats / 750L);
      setBounds(0, i, this.ai.right, this.mHeight + i);
      return;
      if ((paramLong >= 200L) && (paramLong <= 700L))
      {
        i = 255;
        break;
      }
      i = j;
      if (paramLong <= 700L) {
        break;
      }
      i = j;
      if (paramLong >= 750L) {
        break;
      }
      i = (int)(255L * (paramLong - 750L) / -50L);
      break;
      label164:
      if ((paramLong >= 200L) && (paramLong <= 650L)) {
        this.att = 255;
      } else if ((paramLong > 650L) && (paramLong < 750L)) {
        this.att = ((int)(255L * (paramLong - 750L) / -100L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ita
 * JD-Core Version:    0.7.0.1
 */