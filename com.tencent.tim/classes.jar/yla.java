import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.zhitu.GifEncoder;
import com.tencent.mobileqq.activity.aio.zhitu.GifEncoder.EncodingType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class yla
{
  private boolean mIsSoLoaded;
  
  private yla()
  {
    aP(BaseApplicationImpl.getContext());
  }
  
  @NonNull
  private Paint a(Paint paramPaint)
  {
    paramPaint = new Paint(paramPaint);
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setColor(-1);
    paramPaint.setStrokeWidth(4.0F);
    return paramPaint;
  }
  
  @NonNull
  private Pair<String, String> a(String paramString, List<String> paramList)
  {
    int i = paramString.length();
    paramString = new StringBuilder(i);
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = (i + 1) / 2;
    i = 0;
    if (i < paramList.size())
    {
      if (paramString.length() <= j) {
        paramString.append((String)paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)paramList.get(i));
      }
    }
    return new Pair(paramString.toString(), localStringBuilder.toString());
  }
  
  public static yla a()
  {
    return yla.b.b();
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint1, String paramString, Rect paramRect, float paramFloat, Paint paramPaint2)
  {
    paramCanvas.drawText(paramString, paramRect.exactCenterX(), paramFloat, paramPaint2);
    paramCanvas.drawText(paramString, paramRect.exactCenterX(), paramFloat, paramPaint1);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, String paramString, Rect paramRect, int paramInt)
  {
    int i = 1;
    if ((paramInt == 0) || (paramInt == 3))
    {
      f1 = paramRect.exactCenterY();
      f2 = (paramPaint.descent() + paramPaint.ascent()) / 2.0F;
      paramCanvas.drawText(paramString, paramRect.exactCenterX(), f1 - f2, paramPaint);
    }
    while (paramInt != 1)
    {
      float f1;
      float f2;
      return;
    }
    if (paramRect.exactCenterY() < paramCanvas.getHeight() / 2) {}
    for (paramInt = i; paramInt != 0; paramInt = 0)
    {
      a(paramCanvas, paramPaint, paramString, paramRect, paramRect.top - paramPaint.ascent(), a(paramPaint));
      return;
    }
    a(paramCanvas, paramPaint, paramString, paramRect, paramRect.bottom - paramPaint.descent(), a(paramPaint));
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, String paramString1, String paramString2, Rect paramRect, int paramInt)
  {
    int i = 1;
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    if ((paramInt == 0) || (paramInt == 3))
    {
      f1 = paramRect.exactCenterY();
      f2 = localFontMetrics.descent;
      paramCanvas.drawText(paramString1, paramRect.exactCenterX(), f1 - f2, paramPaint);
      f1 = paramRect.exactCenterY();
      f2 = localFontMetrics.ascent;
      paramCanvas.drawText(paramString2, paramRect.exactCenterX(), f1 - f2, paramPaint);
    }
    while (paramInt != 1)
    {
      float f2;
      return;
    }
    if (paramRect.exactCenterY() < paramCanvas.getHeight() / 2) {}
    for (paramInt = i; paramInt != 0; paramInt = 0)
    {
      localPaint = a(paramPaint);
      f1 = paramRect.top - localFontMetrics.ascent;
      a(paramCanvas, paramPaint, paramString1, paramRect, f1, localPaint);
      a(paramCanvas, paramPaint, paramString2, paramRect, localFontMetrics.descent + f1 - localFontMetrics.ascent, localPaint);
      return;
    }
    Paint localPaint = a(paramPaint);
    float f1 = paramRect.bottom - localFontMetrics.descent;
    a(paramCanvas, paramPaint, paramString2, paramRect, f1, localPaint);
    a(paramCanvas, paramPaint, paramString1, paramRect, f1 - localFontMetrics.descent + localFontMetrics.ascent, localPaint);
  }
  
  private void a(String paramString, Rect paramRect, Paint paramPaint)
  {
    float f1 = 6.5F;
    float f2;
    do
    {
      paramPaint.setTextSize(paramRect.width() / f1);
      float f3 = paramPaint.measureText(paramString);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f4 = localFontMetrics.bottom;
      float f5 = localFontMetrics.top;
      f2 = f1 + 0.5F;
      if (c(f3, f4 - f5, paramRect)) {
        break;
      }
      f1 = f2;
    } while (f2 < 8.1F);
  }
  
  private void a(String paramString1, String paramString2, Rect paramRect, Paint paramPaint)
  {
    Rect localRect = new Rect(paramRect);
    localRect.bottom = (localRect.top + (localRect.bottom - localRect.top) / 2);
    float f1 = 6.5F;
    float f6;
    float f2;
    do
    {
      paramPaint.setTextSize(paramRect.width() / f1);
      f6 = paramPaint.measureText(paramString1);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      f2 = localFontMetrics.bottom;
      float f3 = localFontMetrics.top;
      float f7 = paramPaint.measureText(paramString2);
      localFontMetrics = paramPaint.getFontMetrics();
      float f4 = localFontMetrics.bottom;
      float f5 = localFontMetrics.top;
      f6 = Math.max(f6, f7);
      f2 = Math.max(f2 - f3, f4 - f5);
      f1 += 0.5F;
    } while (!c(f6, f2, localRect));
  }
  
  private boolean a(String paramString, int paramInt, Paint paramPaint)
  {
    paramPaint.setTextSize(paramInt / 8.0F);
    return paramPaint.measureText(paramString) <= paramInt * 0.9F;
  }
  
  private float[] a(int paramInt1, Paint paramPaint, Rect paramRect, int paramInt2)
  {
    paramPaint = paramPaint.getFontMetrics();
    float[] arrayOfFloat = new float[2];
    if ((paramInt2 == 0) || (paramInt2 == 3))
    {
      arrayOfFloat[0] = (paramRect.exactCenterY() - paramPaint.descent);
      arrayOfFloat[1] = (paramRect.exactCenterY() - paramPaint.ascent);
    }
    while (paramInt2 != 1) {
      return arrayOfFloat;
    }
    if (paramRect.exactCenterY() < paramInt1 / 2) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      f = paramRect.top - paramPaint.ascent;
      arrayOfFloat[0] = f;
      arrayOfFloat[1] = (f + paramPaint.descent - paramPaint.ascent);
      return arrayOfFloat;
    }
    float f = paramRect.bottom - paramPaint.descent;
    arrayOfFloat[1] = f;
    arrayOfFloat[0] = (f - paramPaint.descent + paramPaint.ascent);
    return arrayOfFloat;
  }
  
  /* Error */
  private boolean aP(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 184	yla:mIsSoLoaded	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: ldc 186
    //   20: invokestatic 192	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   23: istore_2
    //   24: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +28 -> 55
    //   30: ldc 200
    //   32: iconst_2
    //   33: new 68	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   40: ldc 203
    //   42: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_2
    //   46: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: iload_2
    //   57: putfield 184	yla:mIsSoLoaded	Z
    //   60: goto -47 -> 13
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	yla
    //   0	68	1	paramContext	android.content.Context
    //   6	51	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	63	finally
    //   17	55	63	finally
    //   55	60	63	finally
  }
  
  private float[] b(int paramInt1, Paint paramPaint, Rect paramRect, int paramInt2)
  {
    if ((paramInt2 == 0) || (paramInt2 == 3)) {
      return new float[] { paramRect.exactCenterY() - (paramPaint.descent() + paramPaint.ascent()) / 2.0F };
    }
    if (paramInt2 == 1)
    {
      if (paramRect.exactCenterY() < paramInt1 / 2) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0) {
        return new float[] { paramRect.top - paramPaint.ascent() };
      }
      return new float[] { paramRect.bottom - paramPaint.descent() };
    }
    return new float[] { 0.0F };
  }
  
  private boolean c(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    return (paramFloat1 < paramRect.width() * 0.9D) && (paramFloat2 < paramRect.height());
  }
  
  @Nullable
  public Bitmap a(Bitmap paramBitmap, String paramString1, List<String> paramList, String paramString2, Rect paramRect, int paramInt1, String paramString3, int paramInt2, @Nullable Typeface paramTypeface)
  {
    paramString3 = new Canvas();
    Bitmap localBitmap = ykm.b(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (localBitmap == null) {
      return null;
    }
    localBitmap.setDensity(paramBitmap.getDensity());
    paramString3.setBitmap(localBitmap);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setSubpixelText(true);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextAlign(Paint.Align.CENTER);
    localTextPaint.setColor(Color.parseColor(paramString2));
    if (paramTypeface != null) {
      localTextPaint.setTypeface(paramTypeface);
    }
    paramString3.drawBitmap(paramBitmap, 0.0F, 0.0F, localTextPaint);
    if (a(paramString1, paramBitmap.getWidth(), localTextPaint))
    {
      a(paramString1, paramRect, localTextPaint);
      a(paramString3, localTextPaint, paramString1, paramRect, paramInt1);
    }
    for (;;)
    {
      return localBitmap;
      paramBitmap = a(paramString1, paramList);
      a((String)paramBitmap.first, (String)paramBitmap.second, paramRect, localTextPaint);
      a(paramString3, localTextPaint, (String)paramBitmap.first, (String)paramBitmap.second, paramRect, paramInt1);
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  @Nullable
  public Bitmap a(String paramString1, String paramString2, List<String> paramList, String paramString3, Rect paramRect, int paramInt1, String paramString4, int paramInt2, Typeface paramTypeface)
  {
    long l = System.currentTimeMillis();
    do
    {
      try
      {
        paramString1 = BitmapFactory.decodeFile(paramString1);
        if (paramString1 == null)
        {
          QLog.e("ZhituManager", 1, ykm.a(paramString4, "generateZhitu", paramInt2, "decode bitmap fail"));
          paramString1 = null;
          return paramString1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        QLog.e("ZhituManager", 1, "decode origin file but oom");
        return null;
      }
      paramString2 = a(paramString1, paramString2, paramList, paramString3, paramRect, paramInt1, paramString4, paramInt2, paramTypeface);
      paramString1 = paramString2;
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, ykm.u(paramString4, "generateZhitu", "take time " + Long.toString(System.currentTimeMillis() - l)));
    return paramString2;
  }
  
  @Nullable
  public String a(@NonNull String paramString1, @NonNull yla.a parama, @NonNull String paramString2, int paramInt, @NonNull yla.c paramc)
  {
    if (!this.mIsSoLoaded)
    {
      QLog.e("ZhituManager", 1, "So load fail");
      return null;
    }
    long l = System.currentTimeMillis();
    if (paramc.pF() == null)
    {
      QLog.e("ZhituManager", 1, "create dest dir fail");
      return null;
    }
    Object localObject = new File(paramString1);
    paramc = paramc.g(paramString1);
    if (paramc.exists()) {
      paramc.delete();
    }
    paramString1 = new GifEncoder();
    try
    {
      localObject = new ykk((File)localObject, false, 0.0F);
      if ((((ykk)localObject).getHeight() <= 0) || (((ykk)localObject).getWidth() <= 0))
      {
        QLog.e("ZhituManager", 1, "gif image with invalid height or width return ");
        return null;
      }
      ((ykk)localObject).a(parama);
      int i = ((ykk)localObject).getCurrentFrameIndex();
      int k = ((ykk)localObject).getFrameCount();
      if ((i < 0) || (k < 1)) {
        return null;
      }
      paramString1.a(((ykk)localObject).getWidth(), ((ykk)localObject).getHeight(), paramc.getAbsolutePath(), GifEncoder.EncodingType.ENCODING_TYPE_SIMPLE_FAST);
      parama = ykm.b(((ykk)localObject).getWidth(), ((ykk)localObject).getHeight());
      if (parama == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(parama);
      Paint localPaint = new Paint();
      int j;
      do
      {
        if (i >= k) {
          break;
        }
        localCanvas.drawBitmap(((ykk)localObject).an(), 0.0F, 0.0F, localPaint);
        ((ykk)localObject).drawText(localCanvas);
        paramString1.a(parama, ((ykk)localObject).getFrameDelay());
        localCanvas.clipRect(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        ((ykk)localObject).chU();
        j = ((ykk)localObject).getCurrentFrameIndex();
        i = j;
      } while (j != 0);
      paramString1.close();
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ykm.a(paramString2, "generateZhituGif", paramInt, "take time: " + Long.toString(System.currentTimeMillis() - l)));
      }
      return paramc.getAbsolutePath();
    }
    catch (IOException parama)
    {
      QLog.e("ZhituManager", 1, ykm.a(paramString2, "generateZhituGif", paramInt, "generate gif file to send fail, " + parama));
      return null;
    }
    catch (OutOfMemoryError parama)
    {
      annt.e(parama, "ZhituGenerateCatchedExceptionoom when encode gif");
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public yla.a a(int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2, Rect paramRect, int paramInt3, String paramString3, int paramInt4, Typeface paramTypeface)
  {
    if (paramString1.length() > 24) {
      throw new IllegalArgumentException("length of the text to draw is over 24");
    }
    QLog.d("ghostdebug", 2, "get param: " + paramInt4 + " / " + paramInt1);
    long l = System.currentTimeMillis();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setSubpixelText(true);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextAlign(Paint.Align.CENTER);
    localTextPaint.setColor(Color.parseColor(paramString2));
    if (paramTypeface != null) {
      localTextPaint.setTypeface(paramTypeface);
    }
    boolean bool = a(paramString1, paramInt1, localTextPaint);
    if (bool)
    {
      paramList = new String[] { paramString1 };
      if (!bool) {
        break label285;
      }
      a(paramString1, paramRect, localTextPaint);
      paramString1 = b(paramInt2, localTextPaint, paramRect, paramInt3);
      label166:
      if (paramInt3 != 1) {
        break label316;
      }
    }
    label285:
    label316:
    for (paramString2 = a(localTextPaint);; paramString2 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ykm.a(paramString3, "getParamToDrawText", paramInt4, "take time: " + Long.toString(System.currentTimeMillis() - l)));
      }
      return new yla.a(paramString1, paramList, localTextPaint, paramString2);
      paramList = a(paramString1, paramList);
      paramList = new String[] { (String)paramList.first, (String)paramList.second };
      break;
      a(paramList[0], paramList[1], paramRect, localTextPaint);
      paramString1 = a(paramInt2, localTextPaint, paramRect, paramInt3);
      break label166;
    }
  }
  
  public static class a
  {
    public final float[] aP;
    public final Paint bs;
    public final String[] cN;
    public final Paint strokePaint;
    
    public a(float[] paramArrayOfFloat, String[] paramArrayOfString, Paint paramPaint1, Paint paramPaint2)
    {
      this.aP = paramArrayOfFloat;
      this.cN = paramArrayOfString;
      this.bs = paramPaint1;
      this.strokePaint = paramPaint2;
    }
  }
  
  static class b
  {
    private static yla a = new yla(null);
  }
  
  static abstract interface c
  {
    public abstract File g(String paramString);
    
    public abstract String pF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yla
 * JD-Core Version:    0.7.0.1
 */