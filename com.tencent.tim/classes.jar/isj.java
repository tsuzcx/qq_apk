import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;

public class isj
  extends isd
{
  public int JO;
  public boolean UH;
  public volatile boolean UI;
  isj.a a;
  public int atc;
  public int atd;
  public int ate;
  public int atf;
  public int atg;
  public int ath;
  public int ati;
  public int atj;
  public int atk;
  public int atl;
  public Path m = new Path();
  public long mDuration = 3000L;
  public int mHeight;
  public int mLeft;
  public String mTipsText;
  public int mWidth;
  public RectF s = new RectF();
  
  public isj()
  {
    setAlpha(255);
  }
  
  public void aql()
  {
    this.mLeft = ((this.JO - this.mWidth * 3) * (this.atc + 1) / 4 + this.mWidth * this.atc);
    int k = this.mLeft + this.mWidth / 2 - this.ate / 2;
    int i = this.ate + k;
    int j = k;
    if (k < this.atl)
    {
      j = this.atl;
      i = this.ate + j;
    }
    k = i;
    if (i > this.JO - this.atl)
    {
      k = this.JO - this.atl;
      j = k - this.ate;
    }
    this.s.left = j;
    this.s.right = k;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    super.draw(paramCanvas, paramPaint);
    if (this.UH)
    {
      paramPaint.setColor(-706970);
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.s, this.atg, this.atg, paramPaint);
      paramCanvas.drawPath(this.m, paramPaint);
      paramPaint.setColor(-3398);
      paramPaint.setTextSize(this.ath);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f1 = this.s.centerY();
      float f2 = localFontMetrics.ascent;
      f2 = (localFontMetrics.descent + f2) / 2.0F;
      paramCanvas.drawText(this.mTipsText, this.s.centerX(), f1 - f2, paramPaint);
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public void iQ(boolean paramBoolean)
  {
    this.UH = paramBoolean;
  }
  
  public void lG(int paramInt)
  {
    if (this.atc != paramInt)
    {
      this.atc = paramInt;
      aql();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 176 / 750);
    this.mHeight = (paramInt1 * 176 / 750);
    this.JO = paramInt1;
    this.atd = (this.mHeight + paramInt2);
    aql();
    this.ate = (paramInt1 * 360 / 750);
    this.atf = (paramInt1 * 70 / 750);
    this.atg = (paramInt1 * 5 / 750);
    this.ath = (paramInt1 * 32 / 750);
    this.ati = (paramInt1 * 28 / 750);
    this.atj = (paramInt1 * 16 / 750);
    this.atk = (paramInt1 * -143 / 750);
    this.atl = (paramInt1 * 10 / 750);
  }
  
  public void recycle()
  {
    super.recycle();
    this.mTipsText = null;
    this.s = null;
    this.m = null;
    this.a = null;
  }
  
  public void setDuration(long paramLong)
  {
    if (this.mDuration != paramLong) {
      this.mDuration = paramLong;
    }
    QLog.d("RedPacketGameParticleEmoji", 2, "WL_DEBUG setDuration duration = " + paramLong);
  }
  
  public void setTipsText(String paramString)
  {
    this.mTipsText = paramString;
  }
  
  public void update(long paramLong)
  {
    long l = this.mStartTime;
    if (this.mDuration == 0L) {}
    int i;
    do
    {
      return;
      i = (int)((paramLong - l) * this.atd / this.mDuration - this.mHeight);
      setBounds(this.mLeft, i, this.mLeft + this.mWidth, this.mHeight + i);
      if ((this.a != null) && (this.UI) && (i > this.mHeight))
      {
        this.UI = false;
        this.a.onShow();
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameParticleEmoji", 2, "call onShow  top = " + i + ",mHeight = " + this.mHeight);
        }
      }
    } while (!this.UH);
    this.s.top = (i + this.atk);
    this.s.bottom = (this.s.top + this.atf);
    this.m.reset();
    this.m.moveTo(this.mLeft + this.mWidth / 2 - this.ati / 2, this.s.bottom);
    this.m.lineTo(this.mLeft + this.mWidth / 2 + this.ati / 2, this.s.bottom);
    this.m.lineTo(this.mLeft + this.mWidth / 2, this.s.bottom + this.atj);
    this.m.close();
  }
  
  public static abstract interface a
  {
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isj
 * JD-Core Version:    0.7.0.1
 */