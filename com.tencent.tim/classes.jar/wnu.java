import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class wnu
  extends Drawable
{
  wnu.a a;
  protected Object bN;
  protected int mFrameDelay = 50;
  protected Paint mPaint = new Paint(6);
  Resources mResources;
  protected int mType = -1;
  Handler sHandler = new Handler(Looper.getMainLooper());
  
  public wnu(Resources paramResources)
  {
    this.mResources = paramResources;
  }
  
  public void a(wnu.a parama)
  {
    this.a = parama;
  }
  
  public void c(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.mType == 0) && (this.bN != null) && (!(this.bN instanceof wnu.b)))
        {
          boolean bool = Arrays.equals((String[])this.bN, paramArrayOfString);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("VipPendantDrawable", 1, "setPngPaths, exception=" + MsfSdkUtils.getStackTraceString(localException));
        }
      }
    }
    recycle();
    this.mType = 0;
    this.bN = paramArrayOfString;
    this.mFrameDelay = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mType == -1) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
      } while (this.a == null);
      localBitmap = this.a.getCurrentBitmap();
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.mPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void recycle()
  {
    this.mType = -1;
    this.mFrameDelay = 50;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void xy(String paramString)
  {
    if ((this.bN != null) && ((this.bN instanceof wnu.b)) && (((wnu.b)this.bN).src != null) && (this.mType == 1) && (((wnu.b)this.bN).src.equals(paramString))) {
      return;
    }
    recycle();
    this.mType = 1;
    this.bN = new wnu.b(paramString);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap getCurrentBitmap();
  }
  
  class b
  {
    String src;
    
    public b(String paramString)
    {
      this.src = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnu
 * JD-Core Version:    0.7.0.1
 */