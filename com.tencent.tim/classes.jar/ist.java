import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import com.tencent.av.redpacket.AVRedPacketManager;

public class ist
  extends isd
{
  public static final int[] cC = { -1966063, -25328, -1966063 };
  public String Qq;
  public Rect ah = new Rect();
  public int atp;
  public int atq;
  public boolean mIsReady;
  public boolean mIsSend;
  public int mTextSize;
  
  public ist(Context paramContext)
  {
    this.Qq = paramContext.getString(2131698018);
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    this.mIsSend = paramBoolean;
    if (paramBoolean) {}
    for (String str = "qav_redpacket_hbsd.png";; str = "qav_redpacket_hbll.png")
    {
      this.b = new itc(paramAVRedPacketManager.o(str));
      return;
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    super.draw(paramCanvas, paramPaint);
    if (!this.mIsReady)
    {
      paramPaint.setShader(new LinearGradient(0.0F, 0.0F, this.atq, 0.0F, cC, null, Shader.TileMode.CLAMP));
      paramCanvas.drawRect(this.ah, paramPaint);
      paramPaint.setShader(null);
      paramPaint.setColor(-16777216);
      paramPaint.setTextSize(this.mTextSize);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f1 = this.atp;
      float f2 = localFontMetrics.bottom;
      f2 = (localFontMetrics.top + f2 + this.mTextSize) / 2.0F;
      paramCanvas.drawText(this.Qq, this.ah.centerX(), f1 - f2, paramPaint);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mIsSend) {}
    paramInt4 = paramInt1 * 214 / 1500;
    int i;
    int j;
    if (this.mIsSend)
    {
      paramInt3 = 584;
      i = paramInt2 - paramInt3 * paramInt1 / 750;
      if (this.mIsSend) {}
      j = paramInt1 * 1286 / 1500;
      if (!this.mIsSend) {
        break label143;
      }
    }
    label143:
    for (paramInt3 = 364;; paramInt3 = 376)
    {
      setBounds(paramInt4, i, j, paramInt3 * paramInt1 / 750 + i);
      this.mTextSize = (paramInt1 * 28 / 750);
      this.atp = (paramInt2 - paramInt1 * 30 / 750);
      this.ah.set(0, paramInt2 - paramInt1 * 10 / 750, paramInt1, paramInt2);
      return;
      paramInt3 = 586;
      break;
    }
  }
  
  public void recycle()
  {
    super.recycle();
    this.Qq = null;
    this.ah = null;
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if (paramLong < 500L)
    {
      i = (int)(255L * paramLong / 500L);
      f1 = 0.5F * (float)(500L + paramLong) / 500.0F;
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f1);
      this.atq = ((int)(paramLong % 2000L * this.ah.right / 2000L));
      return;
      if (((paramLong >= 500L) && (paramLong <= 2167L)) || (!this.mIsReady))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 2167L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 2500L)
          {
            f1 = f2;
            i = j;
            if (this.mIsReady)
            {
              i = (int)(255L * (paramLong - 2500L) / -333L);
              f1 = f2;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ist
 * JD-Core Version:    0.7.0.1
 */