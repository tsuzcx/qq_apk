import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class jjh
{
  public static Drawable d(Context paramContext, int paramInt)
  {
    BitmapDrawable localBitmapDrawable = null;
    int i = jll.getScreenWidth(paramContext);
    int j = jll.getScreenHeight(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("BitmapTools", 2, "screenWidth = " + i + " # screenHeight =" + j);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i <= 480) {}
    for (localOptions.inSampleSize = 4;; localOptions.inSampleSize = 2) {
      do
      {
        try
        {
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions));
          return localBitmapDrawable;
        }
        catch (OutOfMemoryError paramContext)
        {
          return null;
        }
        catch (Exception paramContext) {}
      } while (i > 720);
    }
    return null;
  }
  
  public static Drawable e(Context paramContext, int paramInt)
  {
    BitmapDrawable localBitmapDrawable = null;
    int i = jll.getScreenWidth(paramContext);
    int j = jll.getScreenHeight(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("BitmapTools", 2, "screenWidth = " + i + " # screenHeight =" + j);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i <= 480) {}
    for (localOptions.inSampleSize = 4;; localOptions.inSampleSize = 2) {
      do
      {
        try
        {
          localOptions.inScaled = false;
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions));
          return localBitmapDrawable;
        }
        catch (OutOfMemoryError paramContext)
        {
          return null;
        }
        catch (Exception paramContext) {}
      } while (i > 720);
    }
    return null;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjh
 * JD-Core Version:    0.7.0.1
 */