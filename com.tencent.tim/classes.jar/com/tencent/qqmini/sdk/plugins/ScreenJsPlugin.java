package com.tencent.qqmini.sdk.plugins;

import alld;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
public class ScreenJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  private static final String TAG = "ScreenJsPlugin";
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    f1 = 0.0F;
    float f3 = 0.0F;
    Window localWindow;
    if (paramActivity != null)
    {
      localWindow = paramActivity.getWindow();
      if (localWindow != null) {
        break label30;
      }
      f1 = -1.0F;
    }
    for (;;)
    {
      return f1;
      localWindow = null;
      break;
      try
      {
        label30:
        f2 = localWindow.getAttributes().screenBrightness;
        if (f2 >= 0.0F)
        {
          f1 = f2;
          if (f2 <= 1.0F) {
            break label71;
          }
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          int i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
          f1 = i / 255.0F;
          label71:
          f2 = f1;
          if (f1 > 1.0F) {
            f2 = 1.0F;
          }
          f1 = f3;
          if (f2 < 0.0F) {
            continue;
          }
          return f2;
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            float f2;
            f1 = f2;
          }
        }
        paramActivity = paramActivity;
      }
    }
    QMLog.e("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
    return f1;
  }
  
  public static boolean keepScreenOn(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != null) {}
    for (paramActivity = paramActivity.getWindow(); paramActivity == null; paramActivity = null) {
      return false;
    }
    if (paramBoolean)
    {
      paramActivity.addFlags(128);
      paramActivity.clearFlags(1);
      return true;
    }
    paramActivity.clearFlags(128);
    paramActivity.addFlags(1);
    return true;
  }
  
  public static void setScreenBrightness(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (paramActivity == null);
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  @JsEvent({"getScreenBrightness"})
  public String getScreenBrightness(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mMiniAppContext.getAttachedActivity()));
      paramRequestEvent.ok(localJSONObject);
      return "";
    }
    catch (Throwable paramRequestEvent)
    {
      for (;;)
      {
        QMLog.e("ScreenJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      }
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.1(this));
  }
  
  @JsEvent({"setKeepScreenOn"})
  public String setKeepScreenOn(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.3(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"setScreenBrightness"})
  public String setScreenBrightness(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.2(this, paramRequestEvent));
    return "";
  }
  
  public static class ScreenShotListenManager
  {
    private static final String[] KEYWORDS = { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
    private static final String[] MEDIA_PROJECTIONS = { "_data", "datetaken" };
    private static final String[] MEDIA_PROJECTIONS_API_16 = { "_data", "datetaken", "width", "height" };
    private static final String TAG = "ScreenShotListenManager";
    private static Point sScreenRealSize;
    private Context mContext;
    private MediaContentObserver mExternalObserver;
    private MediaContentObserver mInternalObserver;
    private OnScreenShotListener mListener;
    private long mStartListenTime;
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final List<String> sHasCallbackPaths = new ArrayList();
    
    private ScreenShotListenManager(Context paramContext)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("The context must not be null.");
      }
      this.mContext = paramContext;
      if (sScreenRealSize == null)
      {
        sScreenRealSize = getRealScreenSize();
        if (sScreenRealSize != null) {
          QMLog.d("ScreenShotListenManager", "Screen Real Size: " + sScreenRealSize.x + " * " + sScreenRealSize.y);
        }
      }
      else
      {
        return;
      }
      QMLog.w("ScreenShotListenManager", "Get screen real size failed.");
    }
    
    public static void assertInMainThread()
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (arrayOfStackTraceElement != null)
        {
          localObject1 = localObject2;
          if (arrayOfStackTraceElement.length >= 4) {
            localObject1 = arrayOfStackTraceElement[3].toString();
          }
        }
        throw new IllegalStateException("Call the method must be in main thread: " + (String)localObject1);
      }
    }
    
    private boolean checkCallback(String paramString)
    {
      if (this.sHasCallbackPaths.contains(paramString)) {
        return true;
      }
      if (this.sHasCallbackPaths.size() >= 20)
      {
        int i = 0;
        while (i < 5)
        {
          this.sHasCallbackPaths.remove(0);
          i += 1;
        }
      }
      this.sHasCallbackPaths.add(paramString);
      return false;
    }
    
    private boolean checkScreenShot(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      if ((paramLong < this.mStartListenTime) || (System.currentTimeMillis() - paramLong > 10000L)) {}
      for (;;)
      {
        return false;
        if (((sScreenRealSize == null) || ((paramInt1 <= sScreenRealSize.x) && (paramInt2 <= sScreenRealSize.y)) || ((paramInt2 <= sScreenRealSize.x) && (paramInt1 <= sScreenRealSize.y))) && (!TextUtils.isEmpty(paramString)))
        {
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
        }
      }
    }
    
    private Point getImageSize(String paramString)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      return new Point(localOptions.outWidth, localOptions.outHeight);
    }
    
    private Point getRealScreenSize()
    {
      try
      {
        localPoint = new Point();
        try
        {
          Display localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
          if (Build.VERSION.SDK_INT >= 17) {
            localDisplay.getRealSize(localPoint);
          }
          for (;;)
          {
            return localPoint;
            try
            {
              Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
              Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
              localPoint.set(((Integer)localMethod1.invoke(localDisplay, new Object[0])).intValue(), ((Integer)localMethod2.invoke(localDisplay, new Object[0])).intValue());
            }
            catch (Exception localException3)
            {
              localPoint.set(localDisplay.getWidth(), localDisplay.getHeight());
              localException3.printStackTrace();
            }
          }
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Point localPoint = null;
        }
      }
      return localPoint;
    }
    
    private void handleMediaContentChange(Uri paramUri)
    {
      int j = -1;
      Point localPoint = null;
      Object localObject1 = localPoint;
      do
      {
        for (;;)
        {
          try
          {
            ContentResolver localContentResolver = this.mContext.getContentResolver();
            localObject1 = localPoint;
            if (Build.VERSION.SDK_INT < 16)
            {
              localObject1 = localPoint;
              localObject2 = MEDIA_PROJECTIONS;
              localObject1 = localPoint;
              paramUri = alld.query(localContentResolver, paramUri, (String[])localObject2, null, null, "_id desc limit 1");
              if (paramUri != null) {
                continue;
              }
              localObject1 = paramUri;
            }
          }
          catch (Exception localException1)
          {
            Object localObject2;
            int k;
            int m;
            long l;
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
          try
          {
            QMLog.e("ScreenShotListenManager", "Deviant logic.");
            if ((paramUri != null) && (!paramUri.isClosed())) {
              paramUri.close();
            }
            return;
          }
          catch (Exception localException2)
          {
            Uri localUri;
            continue;
            i = -1;
            continue;
          }
          localObject1 = localPoint;
          localObject2 = MEDIA_PROJECTIONS_API_16;
        }
        localObject1 = paramUri;
        if (paramUri.moveToFirst()) {
          break;
        }
        localObject1 = paramUri;
        QMLog.d("ScreenShotListenManager", "Cursor no data.");
      } while ((paramUri == null) || (paramUri.isClosed()));
      paramUri.close();
      return;
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
    
    private void handleMediaRowData(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      if (checkScreenShot(paramString, paramLong, paramInt1, paramInt2))
      {
        QMLog.d("ScreenShotListenManager", "ScreenShot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
        if ((this.mListener != null) && (!checkCallback(paramString))) {
          this.mListener.onShot(paramString);
        }
        return;
      }
      QMLog.w("ScreenShotListenManager", "Media content changed, but not screenshot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
    }
    
    public static ScreenShotListenManager newInstance(Context paramContext)
    {
      assertInMainThread();
      return new ScreenShotListenManager(paramContext);
    }
    
    public void setListener(OnScreenShotListener paramOnScreenShotListener)
    {
      this.mListener = paramOnScreenShotListener;
    }
    
    public void startListen()
    {
      assertInMainThread();
      this.sHasCallbackPaths.clear();
      this.mStartListenTime = System.currentTimeMillis();
      this.mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
      this.mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
      this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.mInternalObserver);
      this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.mExternalObserver);
    }
    
    public void stopListen()
    {
      
      if (this.mInternalObserver != null) {}
      try
      {
        this.mContext.getContentResolver().unregisterContentObserver(this.mInternalObserver);
        this.mInternalObserver = null;
        if (this.mExternalObserver == null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          this.mContext.getContentResolver().unregisterContentObserver(this.mExternalObserver);
          this.mExternalObserver = null;
          this.mStartListenTime = 0L;
          this.sHasCallbackPaths.clear();
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
    
    class MediaContentObserver
      extends ContentObserver
    {
      private Uri mContentUri;
      
      public MediaContentObserver(Uri paramUri, Handler paramHandler)
      {
        super();
        this.mContentUri = paramUri;
      }
      
      public void onChange(boolean paramBoolean)
      {
        super.onChange(paramBoolean);
        ScreenJsPlugin.ScreenShotListenManager.this.handleMediaContentChange(this.mContentUri);
      }
    }
    
    public static abstract interface OnScreenShotListener
    {
      public abstract void onShot(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */