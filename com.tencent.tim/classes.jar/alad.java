import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;

public class alad
{
  private static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
  public View FI;
  private Matrix N;
  private int cbW;
  private boolean cvD;
  private int dqU;
  private int height;
  private long lastAddTime;
  public int mAlpha;
  private Bitmap[] mBitmaps;
  public Context mContext;
  private Paint mPaint;
  private int width;
  private ArrayList<alac> yA;
  private float yp;
  private float yq;
  
  public static int iB(int paramInt)
  {
    return Math.round(paramInt * DENSITY);
  }
  
  public void SB(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(5.0D * Math.random());
      alac localalac = alac.a(this.mBitmaps[j], this.yp, this.yq, j, this.mContext.getResources());
      localalac.startTime = System.currentTimeMillis();
      localalac.alpha = this.mAlpha;
      this.yA.add(localalac);
      i += 1;
    }
    this.dqU += paramInt;
  }
  
  public void invalidate()
  {
    this.FI.invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!this.cvD) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.lastAddTime > 400L)
    {
      this.lastAddTime = l;
      if (this.dqU <= 5) {
        SB(1);
      }
    }
    int i = 0;
    alac localalac;
    float f1;
    float f2;
    if (i < this.dqU)
    {
      localalac = (alac)this.yA.get(i);
      localalac.yo = ((float)(System.currentTimeMillis() - localalac.startTime) / 1000.0F);
      f1 = localalac.qB;
      f2 = localalac.yo;
      float f3 = localalac.qC;
      float f4 = localalac.yo;
      float f5 = iB(400);
      float f6 = localalac.yo;
      float f7 = localalac.yo;
      localalac.cT[0] = (f1 * f2 + this.yp);
      localalac.cT[1] = (this.yq - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localalac.alpha > 200)
      {
        localalac.alpha -= 1;
        label206:
        if ((localalac.alpha < 0) || ((this.cbW > 0) && (localalac.cT[1] > this.cbW)))
        {
          localalac.cT[0] = this.yp;
          localalac.cT[1] = this.yq;
          localalac.alpha = this.mAlpha;
          localalac.startTime = System.currentTimeMillis();
          localalac.angle = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localalac.speed = (iB(90) + (float)Math.random() * iB(50));
          localalac.qB = ((float)(localalac.speed * Math.cos(localalac.angle)));
          localalac.qC = ((float)(localalac.speed * Math.sin(localalac.angle)));
          localalac.rotation = ((float)Math.random() * iB(18) - iB(18));
          int j = (int)(Math.random() * 5.0D);
          Bitmap localBitmap = this.mBitmaps[j];
          localalac.bitmap = alac.a(j, localalac.width, localalac.height, localBitmap);
          if (j != 0) {
            break label514;
          }
        }
      }
      label514:
      for (localalac.width = wja.dp2px(30.0F, this.mContext.getResources());; localalac.width = wja.dp2px(22.0F, this.mContext.getResources()))
      {
        localalac.height = ((int)(localalac.bitmap.getHeight() / localalac.bitmap.getWidth() * localalac.width));
        i += 1;
        break;
        localalac.alpha -= (int)(Math.random() * 5.0D + 26.0D);
        break label206;
      }
    }
    i = 0;
    while (i < this.dqU)
    {
      localalac = (alac)this.yA.get(i);
      if ((localalac.cT[0] < this.width) && (localalac.cT[0] > 0.0F) && (localalac.cT[1] < this.height) && (localalac.cT[1] > 0.0F))
      {
        f1 = localalac.width * 1.0F / localalac.bitmap.getWidth();
        f2 = localalac.height * 1.0F / localalac.bitmap.getHeight();
        this.N.setTranslate(-localalac.width / 2 / f1, -localalac.height / 2 / f2);
        this.N.postRotate(localalac.rotation);
        this.N.postTranslate(localalac.cT[0] / f1, localalac.cT[1] / f2);
        this.N.postScale(f1, f2);
        this.mPaint.setAlpha(localalac.alpha);
        paramCanvas.drawBitmap(localalac.bitmap, this.N, this.mPaint);
      }
      i += 1;
    }
    invalidate();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.cbW = (paramInt2 * 3 / 8);
    this.yA.clear();
    this.dqU = 0;
  }
  
  public void setPoint(int paramInt1, int paramInt2)
  {
    this.yp = paramInt1;
    this.yq = paramInt2;
  }
  
  public void startAnimation()
  {
    this.cvD = true;
    invalidate();
    this.lastAddTime = System.currentTimeMillis();
  }
  
  public void stopAnimation()
  {
    this.yA.clear();
    this.cvD = false;
    this.dqU = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alad
 * JD-Core Version:    0.7.0.1
 */