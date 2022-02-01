import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.util.ScreenShotUtil.1;
import com.tencent.mobileqq.util.ScreenShotUtil.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aqez
{
  private static boolean cTN;
  private static Method t;
  
  public static String BU()
  {
    if (CheckPermission.isHasStoragePermission(BaseApplicationImpl.getContext())) {
      return Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/web_long_shot/";
    }
    return BaseApplicationImpl.getContext().getFilesDir() + "/Tencent/MobileQQ/web_long_shot/";
  }
  
  public static <T> void a(WebView paramWebView, aqez.a<T> parama)
  {
    QLog.d("ScreenShotUtil", 1, "webViewFragmentScreenLongShot start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, mWebView is null");
      parama.g(new NullPointerException("mWebView is null"));
      return;
    }
    Object localObject1 = paramWebView.getContext();
    if (localObject1 == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, context is null");
      parama.g(new NullPointerException("context is null"));
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localObject1 = new akoy((Context)localObject1);
    ((akoy)localObject1).p(acfp.m(2131701586));
    ((akoy)localObject1).MY(true);
    ((akoy)localObject1).K(new aqfa(localAtomicBoolean, (akoy)localObject1));
    ((akoy)localObject1).show();
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofInt(new int[] { 0, 90 });
    localValueAnimator1.setDuration(2000L);
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofInt(new int[] { 90, 99 });
    localValueAnimator2.setDuration(10000L);
    Object localObject2 = new aqfb((akoy)localObject1);
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    ((AnimatorSet)localObject2).start();
    ((akoy)localObject1).setOnDismissListener(new aqfc((AnimatorSet)localObject2));
    a(paramWebView, new aqfd(localAtomicBoolean, (akoy)localObject1, parama, paramWebView, (AnimatorSet)localObject2));
  }
  
  public static void a(WebView paramWebView, aqez.b paramb)
  {
    if ((paramWebView == null) || (paramb == null)) {}
    int i;
    int j;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        i = paramWebView.getMeasuredWidth();
        j = paramWebView.getMeasuredHeight();
      } while ((i <= 0) || (j <= 0));
      localBitmap = createBitmap(i, j);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    if (paramWebView.getX5WebViewExtension() != null)
    {
      Class[] arrayOfClass;
      if ((!cTN) && (t == null))
      {
        arrayOfClass = paramWebView.getX5WebViewExtension().getClass().getInterfaces();
        j = arrayOfClass.length;
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          Class localClass;
          if (i < j)
          {
            localClass = arrayOfClass[i];
            if (!"com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(localClass.getName())) {}
          }
          else
          {
            try
            {
              t = localClass.getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
              if (QLog.isColorLevel()) {
                QLog.i("ScreenShotUtil", 2, "call snapshotVisibleWithBitmap");
              }
              cTN = true;
              try
              {
                if (t != null) {
                  t.invoke(paramWebView.getX5WebViewExtension(), new Object[] { localBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ScreenShotUtil.1(paramb, localBitmap) });
                }
                i = 1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  i = 0;
                }
              }
              if (i != 0) {
                break;
              }
              localCanvas.setDrawFilter(new PaintFlagsDrawFilter(134, 64));
              paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
              if (QLog.isColorLevel()) {
                QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
              }
              localCanvas.setDrawFilter(null);
              paramb.O(localBitmap);
              return;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("ScreenShotUtil", 2, "call snapshotVisibleWithBitmap failed: " + localException1.getMessage());
                }
                t = null;
              }
            }
          }
        }
        i += 1;
      }
    }
    paramWebView.draw(localCanvas);
    paramb.O(localBitmap);
  }
  
  public static <T> boolean a(WebView paramWebView, aqez.a<T> parama)
  {
    QLog.d("ScreenShotUtil", 1, "snapshotWholePage start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage error, mWebView is null");
      parama.g(new NullPointerException("mWebView is null"));
    }
    for (;;)
    {
      return false;
      int i = paramWebView.getMeasuredWidth();
      int k = paramWebView.getContentWidth();
      int j = paramWebView.getContentHeight();
      if ((i <= 0) || (k <= 0) || (j <= 0))
      {
        QLog.e("ScreenShotUtil", 1, "measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0");
        parama.g(new IllegalStateException("measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0"));
        return false;
      }
      float f = i / k;
      j = (int)(j * f);
      if (j > 20000)
      {
        QLog.e("ScreenShotUtil", 1, "height > 20000, out of height limit");
        parama.g(new IllegalStateException(acfp.m(2131719216)));
        return false;
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        if (localBitmap != null)
        {
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.scale(f, f);
          ThreadManagerV2.executeOnNetWorkThread(new ScreenShotUtil.2(paramWebView, localCanvas, parama, localBitmap));
          return true;
        }
      }
      catch (OutOfMemoryError paramWebView)
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        QLog.e("ScreenShotUtil", 1, "createBitmap out of memory");
        parama.g(new IllegalStateException(acfp.m(2131719216)));
      }
    }
    return false;
  }
  
  /* Error */
  public static String c(Bitmap paramBitmap, java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +20 -> 27
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: ifnull +13 -> 27
    //   17: aload_2
    //   18: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +8 -> 29
    //   24: aload 4
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 376	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_1
    //   37: invokevirtual 379	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: new 373	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 382	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   50: astore_3
    //   51: new 384	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 386	java/io/FileOutputStream
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 389	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 392	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getstatic 398	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_2
    //   76: invokevirtual 402	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_2
    //   81: ifnull +11 -> 92
    //   84: aload_2
    //   85: invokevirtual 407	java/io/OutputStream:flush	()V
    //   88: aload_2
    //   89: invokevirtual 410	java/io/OutputStream:close	()V
    //   92: aload_3
    //   93: invokevirtual 413	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: areturn
    //   97: astore_0
    //   98: ldc 61
    //   100: iconst_1
    //   101: ldc_w 415
    //   104: aload_0
    //   105: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: goto -16 -> 92
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_1
    //   116: ldc 61
    //   118: iconst_1
    //   119: aload_3
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   127: ldc_w 423
    //   130: astore_3
    //   131: aload_0
    //   132: ifnull -105 -> 27
    //   135: aload_0
    //   136: invokevirtual 407	java/io/OutputStream:flush	()V
    //   139: aload_0
    //   140: invokevirtual 410	java/io/OutputStream:close	()V
    //   143: ldc_w 423
    //   146: areturn
    //   147: astore_0
    //   148: ldc 61
    //   150: iconst_1
    //   151: ldc_w 415
    //   154: aload_0
    //   155: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: ldc_w 423
    //   161: areturn
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull +11 -> 177
    //   169: aload_1
    //   170: invokevirtual 407	java/io/OutputStream:flush	()V
    //   173: aload_1
    //   174: invokevirtual 410	java/io/OutputStream:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore_1
    //   180: ldc 61
    //   182: iconst_1
    //   183: ldc_w 415
    //   186: aload_1
    //   187: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: goto -13 -> 177
    //   193: astore_0
    //   194: goto -29 -> 165
    //   197: astore_3
    //   198: aload_2
    //   199: astore_0
    //   200: goto -86 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramFile	java.io.File
    //   0	203	2	paramString	String
    //   5	88	3	localObject1	Object
    //   111	9	3	localThrowable1	java.lang.Throwable
    //   130	1	3	str	String
    //   197	1	3	localThrowable2	java.lang.Throwable
    //   1	24	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   84	92	97	java/io/IOException
    //   51	67	111	java/lang/Throwable
    //   135	143	147	java/io/IOException
    //   51	67	162	finally
    //   169	177	179	java/io/IOException
    //   69	80	193	finally
    //   116	127	193	finally
    //   69	80	197	java/lang/Throwable
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QLog.e("ScreenShotUtil", 1, "createBitmap failed", localOutOfMemoryError1);
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.e("ScreenShotUtil", 1, "createBitmap failed again", localOutOfMemoryError2);
      }
    }
    return null;
  }
  
  public static Bitmap screenShot(WebView paramWebView, int paramInt1, int paramInt2)
  {
    if ((paramWebView == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    Bitmap localBitmap = createBitmap(paramInt1, paramInt2);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    PaintFlagsDrawFilter localPaintFlagsDrawFilter;
    float f;
    if (paramWebView.getX5WebViewExtension() != null)
    {
      localPaintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
      paramInt2 = QbSdk.getTbsVersion(paramWebView.getContext());
      if ((paramInt2 >= 43000) && (paramInt2 < 43105))
      {
        f = paramInt1 / paramWebView.getMeasuredWidth();
        localCanvas.scale(f, f);
        localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
        paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
        }
        localCanvas.setDrawFilter(null);
      }
    }
    for (;;)
    {
      return localBitmap;
      f = paramInt1 / paramWebView.getContentWidth();
      localCanvas.scale(f, f);
      localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
      paramWebView.getX5WebViewExtension().snapshotWholePage(localCanvas, false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ScreenShotUtil", 2, "snapshot with snapshotWholePage()");
      break;
      f = paramInt1 / paramWebView.getMeasuredWidth();
      localCanvas.scale(f, f);
      paramWebView = paramWebView.capturePicture();
      if (paramWebView != null) {
        paramWebView.draw(localCanvas);
      }
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T a(Bitmap paramBitmap);
    
    public abstract void a(T paramT, Bitmap paramBitmap);
    
    public abstract void g(Exception paramException);
  }
  
  public static abstract interface b
  {
    public abstract void O(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqez
 * JD-Core Version:    0.7.0.1
 */