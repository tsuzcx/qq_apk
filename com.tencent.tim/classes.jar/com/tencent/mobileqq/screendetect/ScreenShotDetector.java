package com.tencent.mobileqq.screendetect;

import acfp;
import alld;
import amiw;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import sws;

public class ScreenShotDetector
  extends sws
{
  private static final String[] KEYWORDS;
  private static final String[] MEDIA_PROJECTIONS = { "_data", "datetaken" };
  private static final String[] MEDIA_PROJECTIONS_API_16 = { "_data", "datetaken", "width", "height" };
  private static ScreenShotDetector jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector = new ScreenShotDetector();
  private static String cah;
  private static final String[] gr;
  private static Point sScreenRealSize;
  private a jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a;
  private b jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$b;
  private a b;
  private WeakReference<Context> mContext;
  private long mStartListenTime;
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    KEYWORDS = new String[] { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
    gr = new String[] { "三星F9000", "三星A8S", "三星S8+", "华为MHA-AL00", "华为P30", "vivoX27", "小米9", "OPPOA59S", "魅族Pro7-H", acfp.m(2131714069), acfp.m(2131714070) };
    cah = "";
  }
  
  private boolean checkCallback(String paramString)
  {
    if ((cah.length() > 0) && (TextUtils.equals(cah, paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: imgPath has done; imagePath = " + paramString);
      }
      return true;
    }
    cah = paramString;
    return false;
  }
  
  private boolean checkScreenShot(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, "ScreenShotDetector called with checkScreenShot  当前时间与图片获取时间差 : " + (System.currentTimeMillis() - paramLong));
    }
    if ((paramLong < this.mStartListenTime) || (System.currentTimeMillis() - paramLong > 4000L)) {
      return false;
    }
    if (sScreenRealSize == null)
    {
      sScreenRealSize = amiw.a((Context)this.mContext.get());
      if (sScreenRealSize == null) {
        break label188;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "Screen Real Size: " + sScreenRealSize.x + " * " + sScreenRealSize.y);
      }
    }
    while ((sScreenRealSize != null) && ((paramInt1 > sScreenRealSize.x) || (paramInt2 > sScreenRealSize.y)) && ((paramInt2 > sScreenRealSize.x) || (paramInt1 > sScreenRealSize.y)))
    {
      return false;
      label188:
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "Get screen real size failed.");
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    String[] arrayOfString = KEYWORDS;
    paramInt2 = arrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramString.contains(arrayOfString[paramInt1])) {
        return true;
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  private void dNH()
  {
    Context localContext;
    if (this.mContext != null)
    {
      localContext = (Context)this.mContext.get();
      if (localContext == null) {}
    }
    else
    {
      try
      {
        localContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a);
        localContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.b);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error", localException);
        return;
      }
    }
    QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error context is null");
  }
  
  /* Error */
  private void dNI()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/tencent/mobileqq/screendetect/ScreenShotDetector:mContext	Ljava/lang/ref/WeakReference;
    //   4: ifnull +106 -> 110
    //   7: aload_0
    //   8: getfield 127	com/tencent/mobileqq/screendetect/ScreenShotDetector:mContext	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 201	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: checkcast 203	android/content/Context
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +82 -> 101
    //   22: aload_0
    //   23: getfield 250	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +19 -> 47
    //   31: aload_1
    //   32: invokevirtual 242	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_0
    //   36: getfield 250	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   39: invokevirtual 275	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 250	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   47: aload_0
    //   48: getfield 261	com/tencent/mobileqq/screendetect/ScreenShotDetector:b	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +57 -> 110
    //   56: aload_1
    //   57: invokevirtual 242	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload_0
    //   61: getfield 261	com/tencent/mobileqq/screendetect/ScreenShotDetector:b	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   64: invokevirtual 275	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 261	com/tencent/mobileqq/screendetect/ScreenShotDetector:b	Lcom/tencent/mobileqq/screendetect/ScreenShotDetector$a;
    //   72: return
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   78: goto -36 -> 42
    //   81: astore_1
    //   82: ldc 159
    //   84: iconst_1
    //   85: ldc_w 280
    //   88: aload_1
    //   89: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: return
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   98: goto -31 -> 67
    //   101: ldc 159
    //   103: iconst_1
    //   104: ldc_w 282
    //   107: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ScreenShotDetector
    //   17	40	1	localContext	Context
    //   81	8	1	localException1	Exception
    //   93	2	1	localException2	Exception
    //   26	27	2	locala	a
    //   73	2	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   31	42	73	java/lang/Exception
    //   22	27	81	java/lang/Exception
    //   42	47	81	java/lang/Exception
    //   47	52	81	java/lang/Exception
    //   67	72	81	java/lang/Exception
    //   74	78	81	java/lang/Exception
    //   94	98	81	java/lang/Exception
    //   56	67	93	java/lang/Exception
  }
  
  private Point getImageSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  public static ScreenShotDetector getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector;
  }
  
  private void handleMediaContentChange(Uri paramUri)
  {
    int j = -1;
    Point localPoint = null;
    Object localObject2 = (Context)this.mContext.get();
    if (localObject2 == null) {
      QLog.e("ScreenShotDetector", 2, "context null.");
    }
    for (;;)
    {
      return;
      Object localObject1 = localPoint;
      try
      {
        ContentResolver localContentResolver = ((Context)localObject2).getContentResolver();
        localObject1 = localPoint;
        if (Build.VERSION.SDK_INT < 16) {
          localObject1 = localPoint;
        }
        for (localObject2 = MEDIA_PROJECTIONS;; localObject2 = MEDIA_PROJECTIONS_API_16)
        {
          for (;;)
          {
            localObject1 = localPoint;
            paramUri = alld.query(localContentResolver, paramUri, (String[])localObject2, null, null, "date_added desc limit 1");
            if (paramUri != null) {
              break label130;
            }
            localObject1 = paramUri;
            try
            {
              QLog.e("ScreenShotDetector", 2, "Deviant logic.");
              if ((paramUri == null) || (paramUri.isClosed())) {
                break;
              }
              paramUri.close();
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                int k;
                int m;
                long l;
                Uri localUri;
                continue;
                int i = -1;
              }
            }
          }
          localObject1 = localPoint;
        }
        label130:
        localObject1 = paramUri;
        if (!paramUri.moveToFirst())
        {
          localObject1 = paramUri;
          if (QLog.isColorLevel())
          {
            localObject1 = paramUri;
            QLog.d("ScreenShotDetector", 2, "Cursor no data.");
          }
          if ((paramUri == null) || (paramUri.isClosed())) {
            continue;
          }
          paramUri.close();
          return;
        }
        localObject1 = paramUri;
        k = paramUri.getColumnIndex("_data");
        localObject1 = paramUri;
        m = paramUri.getColumnIndex("datetaken");
        localObject1 = paramUri;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = paramUri;
          j = paramUri.getColumnIndex("width");
          localObject1 = paramUri;
          i = paramUri.getColumnIndex("height");
          localObject1 = paramUri;
          localObject2 = paramUri.getString(k);
          localObject1 = paramUri;
          l = paramUri.getLong(m);
          if ((j >= 0) && (i >= 0))
          {
            localObject1 = paramUri;
            k = paramUri.getInt(j);
            localObject1 = paramUri;
            j = paramUri.getInt(i);
            i = k;
          }
          for (;;)
          {
            localObject1 = paramUri;
            handleMediaRowData((String)localObject2, l, i, j);
            if ((paramUri == null) || (paramUri.isClosed())) {
              break;
            }
            paramUri.close();
            return;
            localObject1 = paramUri;
            localPoint = getImageSize((String)localObject2);
            localObject1 = paramUri;
            i = localPoint.x;
            localObject1 = paramUri;
            j = localPoint.y;
          }
        }
      }
      catch (Exception localException1)
      {
        paramUri = null;
      }
      finally
      {
        try
        {
          localException1.printStackTrace();
          if ((paramUri == null) || (paramUri.isClosed())) {
            continue;
          }
          paramUri.close();
          return;
        }
        finally
        {
          localUri = paramUri;
          paramUri = localObject3;
        }
        paramUri = finally;
        if ((localException1 != null) && (!localException1.isClosed())) {
          localException1.close();
        }
      }
    }
  }
  
  private void handleMediaRowData(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (checkScreenShot(paramString, paramLong, paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong + "; diffTime = " + (System.currentTimeMillis() - paramLong));
      }
      if (!checkCallback(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShotDetector", 2, "ScreenShot 机型：" + Build.MANUFACTURER + Build.MODEL);
        }
        amiw.cN("0X8009FED", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$b != null) {
          this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$b.dNJ();
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        this.mUiHandler.post(new ScreenShotDetector.1(this, paramString));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScreenShotDetector", 2, "Media content changed, but not screenshot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$b = paramb;
  }
  
  protected boolean avW()
  {
    if (!amiw.aqC())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: onChange screen switch is closed!");
      }
      return true;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).a.He())) {
      return true;
    }
    return (localAppRuntime == null) || (localAppRuntime.isBackground_Pause) || (localAppRuntime.isBackground_Stop);
  }
  
  public void cQ(Context paramContext)
  {
    if ((paramContext instanceof QQLSActivity))
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: startListen error, context is QQLSActivity!");
      return;
    }
    this.mContext = new WeakReference(paramContext);
    this.mStartListenTime = 0L;
    this.mStartListenTime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector$a = new a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
    this.b = new a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.2(this), false);
  }
  
  public void cR(Context paramContext)
  {
    this.mUiHandler.removeCallbacksAndMessages(null);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.3(this), false);
  }
  
  public void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    amiw.disaptchTouchEventCallback(paramActivity, paramMotionEvent);
  }
  
  public void onWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper-ScreenShotDetector", 2, "ScreenShot: onWindowFocusChanged " + paramBoolean);
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
    if (paramBoolean) {
      amiw.a(paramActivity, this.mUiHandler);
    }
    while (!"XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
      return;
    }
    amiw.cd(paramActivity);
  }
  
  class a
    extends ContentObserver
  {
    private Uri mContentUri;
    
    public a(Uri paramUri, Handler paramHandler)
    {
      super();
      this.mContentUri = paramUri;
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      if (ScreenShotDetector.this.avW()) {
        return;
      }
      try
      {
        ThreadManager.getSubThreadHandler().post(new ScreenShotDetector.MediaContentObserver.1(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ScreenShotDetector", 2, "ScreenShot: onChange error!", localException);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void dNJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector
 * JD-Core Version:    0.7.0.1
 */