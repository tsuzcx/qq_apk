import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class aqeq
{
  @Nullable
  public static Bitmap a(int paramInt, Bitmap.Config paramConfig, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      throw new IllegalArgumentException("bitmapArray should not be null or empty");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfBitmap.length);
    int j = paramArrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramArrayOfBitmap[i];
        if (localObject != null)
        {
          localArrayList.add(localObject);
          if (localArrayList.size() < 6) {}
        }
      }
      else
      {
        j = localArrayList.size();
        if (j > 0) {
          break;
        }
        throw new IllegalArgumentException("can not find any bitmap from bitmapArray");
      }
      i += 1;
    }
    paramArrayOfBitmap = paramConfig;
    if (paramConfig == null) {
      paramArrayOfBitmap = Bitmap.Config.RGB_565;
    }
    Object localObject = new aqeq.a[j];
    i = 0;
    while (i < j)
    {
      localObject[i] = new aqeq.a(null);
      i += 1;
    }
    float f = paramInt / 100.0F;
    i = 0;
    RectF localRectF;
    Rect localRect;
    Paint localPaint1;
    Canvas localCanvas;
    Paint localPaint2;
    label295:
    Bitmap localBitmap;
    int k;
    int m;
    if (j == 1)
    {
      localObject[0].left = 0;
      localObject[0].top = 0;
      i = paramInt;
      localRectF = new RectF();
      localRect = new Rect();
      localPaint1 = new Paint();
      localPaint1.setAntiAlias(true);
      localPaint1.setDither(true);
      localPaint1.setFilterBitmap(true);
      paramArrayOfBitmap = Bitmap.createBitmap(paramInt, paramInt, paramArrayOfBitmap);
      paramConfig = null;
      localCanvas = new Canvas(paramArrayOfBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint2 = new Paint();
      localPaint2.setAntiAlias(true);
      localPaint2.setDither(true);
      localPaint2.setFilterBitmap(true);
      localPaint2.setColor(0);
      paramInt = 0;
      if (paramInt >= j) {
        break label1172;
      }
      localBitmap = (Bitmap)localArrayList.get(paramInt);
      k = i / 2;
      m = i * 3 / 40;
      localRectF.set(localObject[paramInt].left, localObject[paramInt].top, localObject[paramInt].left + i, localObject[paramInt].top + i);
      localRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      if ((paramInt != 1) || (j < 3)) {
        break label1134;
      }
      localPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      localCanvas.drawCircle(localObject[paramInt].left + k, localObject[paramInt].top + k, m + k, localPaint2);
      paramConfig = Bitmap.createBitmap(paramArrayOfBitmap);
      localPaint2.setXfermode(null);
    }
    for (;;)
    {
      localPaint1.setShader(a(localRectF, localBitmap));
      localCanvas.drawCircle(localObject[paramInt].left + k, localObject[paramInt].top + k, k, localPaint1);
      paramInt += 1;
      break label295;
      if (j == 2)
      {
        i = (int)(60.0F * f + 0.5F);
        localObject[0].left = 0;
        localObject[0].top = 0;
        localObject[1].left = (paramInt - i);
        localObject[1].top = (paramInt - i);
        break;
      }
      if (j == 3)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].left = ((paramInt - i) / 2);
        localObject[0].top = ((int)(2.0F * f));
        localObject[1].left = (paramInt - i);
        localObject[1].top = (paramInt - i - (int)(2.0F * f));
        localObject[2].left = 0;
        localObject[2].top = (paramInt - i - (int)(f * 2.0F));
        break;
      }
      if (j == 4)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].left = (paramInt - i);
        localObject[0].top = 0;
        localObject[1].left = (paramInt - i);
        localObject[1].top = (paramInt - i);
        localObject[2].left = 0;
        localObject[2].top = (paramInt - i);
        localObject[3].left = 0;
        localObject[3].top = 0;
        break;
      }
      if (j == 5)
      {
        i = (int)(40.0F * f + 0.5F);
        localObject[0].left = (paramInt - i);
        localObject[0].top = ((int)(24.0F * f + 0.5F));
        localObject[1].left = (paramInt - i - (int)(12.0F * f + 0.5F));
        localObject[1].top = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].left = ((int)(12.0F * f + 0.5F));
        localObject[2].top = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].left = 0;
        localObject[3].top = ((int)(24.0F * f + 0.5F));
        localObject[4].left = ((int)(30.0F * f + 0.5F));
        localObject[4].top = ((int)(f * 2.0F + 0.5F));
        break;
      }
      if (j >= 6)
      {
        i = (int)(36.0F * f + 0.5F);
        localObject[0].top = ((int)(2.0F * f + 0.5F));
        localObject[0].left = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[1].top = ((int)(32.0F * f + 0.5F));
        localObject[1].left = (paramInt - i);
        localObject[2].top = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].left = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[3].top = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].left = ((int)(15.0F * f + 0.5F));
        localObject[4].top = ((int)(32.0F * f + 0.5F));
        localObject[4].left = 0;
        localObject[5].top = ((int)(2.0F * f + 0.5F));
        localObject[5].left = ((int)(f * 15.0F + 0.5F));
      }
      break;
      label1134:
      localCanvas.drawCircle(localObject[paramInt].left + k, localObject[paramInt].top + k, m + k, localPaint2);
    }
    label1172:
    if (paramConfig != null)
    {
      localRectF.set(0.0F, 0.0F, paramConfig.getWidth(), paramConfig.getHeight());
      localRect.set(0, 0, paramConfig.getWidth(), paramConfig.getHeight());
      localPaint1.setShader(null);
      localCanvas.drawBitmap(paramConfig, localRect, localRectF, localPaint1);
    }
    return paramArrayOfBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2;
    if (paramFloat2 < 1.5F) {
      f = 1.5F;
    }
    int j = Math.max(paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i = Math.max(paramBitmap2.getWidth(), paramBitmap2.getHeight());
    j = (int)(Math.max(j, i) * f);
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    paramFloat2 = j / i;
    Object localObject = new Matrix();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap2.getWidth() / 2.0F, paramBitmap2.getHeight() / 2.0F);
    }
    ((Matrix)localObject).postScale(paramFloat2, paramFloat2);
    localCanvas.drawBitmap(paramBitmap2, (Matrix)localObject, localPaint);
    paramBitmap2 = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    localObject = new RectF(0.0F, 0.0F, j, j);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap1, paramBitmap2, (RectF)localObject, localPaint);
    return localBitmap;
  }
  
  public static BitmapShader a(RectF paramRectF, @NonNull Bitmap paramBitmap)
  {
    float f1 = 0.0F;
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    paramBitmap = new Matrix();
    float f3;
    float f2;
    if (paramRectF.width() / paramRectF.height() < j / i)
    {
      f3 = paramRectF.height() / i;
      f2 = (paramRectF.width() - j * f3) * 0.5F;
    }
    for (;;)
    {
      paramBitmap.setScale(f3, f3);
      paramBitmap.postTranslate((int)(f2 + 0.5F) + paramRectF.left, (int)(f1 + 0.5F) + paramRectF.top);
      localBitmapShader.setLocalMatrix(paramBitmap);
      return localBitmapShader;
      f3 = paramRectF.width() / j;
      f1 = paramRectF.height();
      float f4 = i;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  public static Bitmap b(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      paramArrayOfBitmap = null;
    }
    Bitmap[] arrayOfBitmap;
    int i;
    aqeq.a[] arrayOfa;
    Paint localPaint;
    RectF localRectF;
    Rect localRect;
    Canvas localCanvas;
    label279:
    do
    {
      Bitmap localBitmap;
      do
      {
        return paramArrayOfBitmap;
        arrayOfBitmap = new Bitmap[paramArrayOfBitmap.length];
        i = 0;
        j = 0;
        while (j < paramArrayOfBitmap.length)
        {
          k = i;
          if (paramArrayOfBitmap[j] != null)
          {
            arrayOfBitmap[i] = paramArrayOfBitmap[j];
            k = i + 1;
          }
          j += 1;
          i = k;
        }
        if (i < 1) {
          return null;
        }
        if (i == 1) {
          return paramArrayOfBitmap[0];
        }
        arrayOfa = new aqeq.a[i];
        j = 0;
        while (j < i)
        {
          arrayOfa[j] = new aqeq.a(null);
          j += 1;
        }
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localRectF = new RectF();
        localRect = new Rect();
        localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localCanvas.drawARGB(0, 0, 0, 0);
        if (i != 2) {
          break;
        }
        arrayOfa[0].left = 0;
        arrayOfa[0].top = 0;
        arrayOfa[0].right = (paramInt / 2 - 1);
        arrayOfa[0].bottom = paramInt;
        arrayOfa[0].maskType = 1;
        arrayOfa[1].left = (paramInt / 2 + 1);
        arrayOfa[1].top = 0;
        arrayOfa[1].right = paramInt;
        arrayOfa[1].bottom = paramInt;
        arrayOfa[1].maskType = 1;
        paramInt = 0;
        paramArrayOfBitmap = localBitmap;
      } while (paramInt >= i);
      paramArrayOfBitmap = localBitmap;
    } while (paramInt >= 4);
    int j = arrayOfBitmap[paramInt].getWidth();
    int k = arrayOfBitmap[paramInt].getHeight();
    if (arrayOfa[paramInt].maskType == 1) {
      localRect.set(j / 4, 0, j / 4 * 3, k);
    }
    for (;;)
    {
      localRectF.set(arrayOfa[paramInt].left, arrayOfa[paramInt].top, arrayOfa[paramInt].right, arrayOfa[paramInt].bottom);
      localCanvas.drawBitmap(arrayOfBitmap[paramInt], localRect, localRectF, localPaint);
      paramInt += 1;
      break label279;
      if (i == 3)
      {
        arrayOfa[0].left = 0;
        arrayOfa[0].top = 0;
        arrayOfa[0].right = (paramInt / 2 - 1);
        arrayOfa[0].bottom = paramInt;
        arrayOfa[0].maskType = 1;
        arrayOfa[1].left = (paramInt / 2 + 1);
        arrayOfa[1].top = 0;
        arrayOfa[1].right = paramInt;
        arrayOfa[1].bottom = (paramInt / 2 - 1);
        arrayOfa[1].maskType = 2;
        arrayOfa[2].left = (paramInt / 2 + 1);
        arrayOfa[2].top = (paramInt / 2 + 1);
        arrayOfa[2].right = paramInt;
        arrayOfa[2].bottom = paramInt;
        arrayOfa[2].maskType = 2;
        break;
      }
      if (i < 4) {
        break;
      }
      arrayOfa[0].left = 0;
      arrayOfa[0].top = 0;
      arrayOfa[0].right = (paramInt / 2 - 1);
      arrayOfa[0].bottom = (paramInt / 2 - 1);
      arrayOfa[0].maskType = 2;
      arrayOfa[1].left = (paramInt / 2 + 1);
      arrayOfa[1].top = 0;
      arrayOfa[1].right = paramInt;
      arrayOfa[1].bottom = (paramInt / 2 - 1);
      arrayOfa[1].maskType = 2;
      arrayOfa[2].left = (paramInt / 2 + 1);
      arrayOfa[2].top = (paramInt / 2 + 1);
      arrayOfa[2].right = paramInt;
      arrayOfa[2].bottom = paramInt;
      arrayOfa[2].maskType = 2;
      arrayOfa[3].left = 0;
      arrayOfa[3].top = (paramInt / 2 + 1);
      arrayOfa[3].right = (paramInt / 2 - 1);
      arrayOfa[3].bottom = paramInt;
      arrayOfa[3].maskType = 2;
      break;
      localRect.set(0, 0, j, k);
    }
  }
  
  static class a
  {
    public int bottom;
    public int left;
    public int maskType;
    public int right;
    public int top;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeq
 * JD-Core Version:    0.7.0.1
 */