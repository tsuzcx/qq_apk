import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Random;

public class ayog
{
  public ArrayList<ayoa> Gw;
  public int eeR;
  public int mDuration;
  public int mMode;
  public TextPaint mPaint = new TextPaint();
  public int mStartTime;
  public int mStartX;
  public int mStartY;
  
  public ayog(int paramInt1, int paramInt2, Typeface paramTypeface, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mPaint.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    this.mPaint.setDither(true);
    this.mPaint.setTextSize(paramInt1);
    this.mPaint.setColor(paramInt2);
    this.mPaint.setTypeface(paramTypeface);
    this.mStartX = paramInt3;
    this.mStartY = paramInt4;
    this.mStartTime = paramInt5;
    this.mDuration = paramInt6;
  }
  
  public static int RZ()
  {
    Random localRandom = new Random();
    int i = localRandom.nextInt(5);
    int j = localRandom.nextInt(9);
    return localRandom.nextInt(9) + (i * 100 + j * 10);
  }
  
  public static ayog a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, aynr paramaynr)
  {
    paramTypeface = new ayog(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.mMode = 1;
    paramTypeface.a(paramCharSequence, paramaynr);
    return paramTypeface;
  }
  
  public static void a(int paramInt, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramInt == 255) {
        paramPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
    }
    else {
      return;
    }
    paramPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
  }
  
  public void a(CharSequence paramCharSequence, aynr paramaynr)
  {
    a(paramCharSequence, paramaynr, 0);
  }
  
  public void a(CharSequence paramCharSequence, aynr paramaynr, int paramInt)
  {
    this.eeR = ((int)this.mPaint.measureText(paramCharSequence, 0, paramCharSequence.length()));
    if ((paramInt != 0) && (paramInt > this.eeR)) {}
    for (int j = (paramInt - this.eeR) / (paramCharSequence.length() - 1);; j = 0)
    {
      this.Gw = new ArrayList();
      int k = 0;
      paramInt = 0;
      while (k < paramCharSequence.length())
      {
        int i = paramCharSequence.charAt(k);
        if (i == 32)
        {
          paramInt = (int)this.mPaint.measureText("0", 0, 1) + paramInt;
          k += 1;
        }
        else
        {
          ayoa localayoa = new ayoa();
          String str = new String(new char[] { i });
          int m = (int)this.mPaint.measureText(str, 0, str.length());
          Object localObject = this.mPaint.getFontMetrics();
          float f1 = ((Paint.FontMetrics)localObject).bottom;
          float f2 = ((Paint.FontMetrics)localObject).top;
          float f3 = Math.abs(((Paint.FontMetrics)localObject).ascent);
          localObject = Bitmap.createBitmap(m, (int)(f1 - f2), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          BaseApplicationImpl.getContext();
          localCanvas.drawText(str, 0.0F, f3, this.mPaint);
          if (this.mMode == 0)
          {
            localayoa.eLM = paramaynr.a("", this.mStartTime + RZ(), this.mDuration, 0, 255, new LinearInterpolator());
            label282:
            localayoa.mBitmap = ((Bitmap)localObject);
            if (k != 0) {
              break label374;
            }
            localayoa.eLL = paramInt;
          }
          for (paramInt = localayoa.mBitmap.getWidth() + paramInt;; paramInt = localayoa.mBitmap.getWidth() + j + paramInt)
          {
            this.Gw.add(localayoa);
            break;
            localayoa.eLM = paramaynr.a("", this.mStartTime + this.mDuration * k / paramCharSequence.length(), this.mDuration, 0, 255, new LinearInterpolator());
            break label282;
            label374:
            localayoa.eLL = (paramInt + j);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayog
 * JD-Core Version:    0.7.0.1
 */