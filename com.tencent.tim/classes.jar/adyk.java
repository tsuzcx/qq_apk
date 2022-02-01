import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.VipBubbleDrawable.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class adyk
  extends Drawable
{
  private static int[] PRESSED_STATE_SET = { 16842919 };
  private static final ColorFilter e = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private int bLf;
  private boolean bRZ;
  public boolean bSa;
  public boolean bSb;
  private boolean bSc;
  private boolean bSd;
  private boolean bSe;
  private String bvU;
  private String bwl;
  public String bwm;
  private NinePatch g;
  private NinePatch i;
  private int[] kK;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private Paint mPaint;
  private Resources mRes;
  private int mTargetDensity = 160;
  private Handler mUiHandler;
  
  public adyk(Resources paramResources, NinePatch paramNinePatch1, NinePatch paramNinePatch2, int paramInt)
  {
    this.mRes = paramResources;
    this.g = paramNinePatch1;
    this.i = paramNinePatch2;
    this.bLf = paramInt;
    this.mPaint = new Paint();
    this.mPaint.setDither(true);
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      this.mBitmapWidth = wja.dp2px(65.0F, paramResources);
      this.mBitmapHeight = wja.dp2px(57.0F, paramResources);
    }
  }
  
  private void aP(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    label261:
    for (;;)
    {
      return;
      String str = "bubblebg://" + "0_local_default_" + this.bSb;
      Object localObject1;
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject1 = (Pair)BaseApplicationImpl.sImageCache.get(str);
        if (localObject1 != null)
        {
          localObject1 = (NinePatch)((Pair)localObject1).first;
          if (localObject1 != null) {
            ((NinePatch)localObject1).draw(paramCanvas, getBounds(), this.mPaint);
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          break label261;
        }
        if (this.bSb) {}
        for (j = 2130850823;; j = 2130851000) {
          for (;;)
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).inDensity = 320;
            ((BitmapFactory.Options)localObject1).inTargetDensity = this.mRes.getDisplayMetrics().densityDpi;
            try
            {
              localObject1 = BitmapFactory.decodeResource(this.mRes, j, (BitmapFactory.Options)localObject1);
              if (localObject1 == null) {
                break;
              }
              Object localObject2 = ((Bitmap)localObject1).getNinePatchChunk();
              if (localObject2 == null) {
                break;
              }
              localObject2 = new NinePatch((Bitmap)localObject1, (byte[])localObject2, null);
              ((NinePatch)localObject2).draw(paramCanvas, getBounds(), this.mPaint);
              if (BaseApplicationImpl.sImageCache == null) {
                break;
              }
              paramCanvas = new Pair(localObject2, Integer.valueOf(getBitmapSize((Bitmap)localObject1)));
              BaseApplicationImpl.sImageCache.put(str, paramCanvas);
              return;
            }
            catch (OutOfMemoryError paramCanvas)
            {
              QLog.e("VipBubbleDrawable", 1, "drawDefaultBubbleBg, decode default bubble bg error, bubbleId=" + this.bLf, paramCanvas);
              return;
            }
          }
        }
      }
    }
  }
  
  private int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public void GR(boolean paramBoolean)
  {
    this.bSe = paramBoolean;
    invalidateSelf();
  }
  
  public void GS(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mPaint.setColorFilter(e);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      this.mPaint.setColorFilter(null);
    }
  }
  
  public void GT(boolean paramBoolean)
  {
    if (!this.bSd) {
      return;
    }
    this.bSc = paramBoolean;
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper());
    }
    this.mUiHandler.post(new VipBubbleDrawable.1(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    this.bSc = paramBoolean;
    this.bSd = paramBoolean;
    if (this.bSc)
    {
      this.bwl = paramString1;
      this.kK = paramArrayOfInt;
      this.bvU = paramString2;
    }
  }
  
  public void bQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bSb = paramBoolean1;
    this.bSe = paramBoolean2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int j = paramCanvas.save();
    Object localObject;
    if ((this.bSe) && (this.i != null))
    {
      localObject = this.i;
      if (localObject == null) {
        break label154;
      }
      if (this.bSb) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.mPaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      localObject = (HashMap)adxn.a().eO.get(Integer.valueOf(this.bLf));
      if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
        return;
      }
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((adye)((Iterator)localObject).next()).a(this, paramCanvas);
      }
      localObject = this.g;
      break;
      label154:
      QLog.e("VipBubbleDrawable", 1, "draw, ninePatch null, use default, mUseAnimationBg=" + this.bSe + ", mNormalNinePatch=" + this.g + ", mAnimationNinePath" + this.i + ", bubbleId=" + this.bLf + ", drawable=" + this);
      aP(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    if (this.g != null) {
      if (!this.g.hasAlpha()) {}
    }
    while ((this.mPaint != null) && (this.mPaint.getAlpha() < 255))
    {
      return -3;
      return -1;
    }
    return -1;
  }
  
  public void h(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.bSb = paramBoolean;
    this.bwm = paramString;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    boolean bool2 = StateSet.stateSetMatches(PRESSED_STATE_SET, paramArrayOfInt);
    if (this.bRZ != bool2)
    {
      this.bRZ = bool2;
      if ((!this.bRZ) || (this.bSa)) {
        break label61;
      }
      this.mPaint.setColorFilter(e);
    }
    for (;;)
    {
      this.bSa = false;
      invalidateSelf();
      bool1 = true;
      return bool1;
      label61:
      this.mPaint.setColorFilter(null);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyk
 * JD-Core Version:    0.7.0.1
 */