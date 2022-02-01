package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

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
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ScreenJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_SCREEN_BRIGHTNESS = "getScreenBrightness";
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  public static final String EVENT_SET_KEEP_SCREEN_ON = "setKeepScreenOn";
  public static final String EVENT_SET_SCREEN_BRIGHTNESS = "setScreenBrightness";
  private static final Set<String> S_EVENT_MAP = new ScreenJsPlugin.1();
  private static final String TAG = "[mini] ScreenJsPlugin";
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    float f1;
    if (localWindow == null) {
      f1 = -1.0F;
    }
    for (;;)
    {
      return f1;
      try
      {
        f2 = localWindow.getAttributes().screenBrightness;
        f1 = f2;
        if (f2 < 0.0F)
        {
          int i;
          QLog.e("[mini] ScreenJsPlugin", 1, paramActivity, new Object[0]);
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
          return i / 255.0F;
        }
        catch (Exception paramActivity)
        {
          float f2;
          break;
        }
        paramActivity = paramActivity;
        f2 = 0.0F;
      }
    }
    return f2;
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
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] ScreenJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("setScreenBrightness".equals(paramString1)) {
      AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.3(this, paramString2, paramJsRuntime, paramString1, paramInt));
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("getScreenBrightness".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("value", getScreenBrightness(this.jsPluginEngine.appBrandRuntime.activity));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject, paramInt);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[mini] ScreenJsPlugin", 2, localThrowable, new Object[0]);
        }
      } else if ("setKeepScreenOn".equals(paramString1)) {
        AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.4(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    paramBaseJsPluginEngine = ScreenShotListenManager.newInstance(paramBaseJsPluginEngine.appBrandRuntime.activity);
    paramBaseJsPluginEngine.setListener(new ScreenJsPlugin.2(this));
    paramBaseJsPluginEngine.startListen();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
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
          QLog.d("ScreenShotListenManager", 2, "Screen Real Size: " + sScreenRealSize.x + " * " + sScreenRealSize.y);
        }
      }
      else
      {
        return;
      }
      QLog.w("ScreenShotListenManager", 2, "Get screen real size failed.");
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
            QLog.e("ScreenShotListenManager", 2, "Deviant logic.");
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
        QLog.d("ScreenShotListenManager", 2, "Cursor no data.");
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
        QLog.d("ScreenShotListenManager", 1, "ScreenShot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
        if ((this.mListener != null) && (!checkCallback(paramString))) {
          this.mListener.onShot(paramString);
        }
        return;
      }
      QLog.w("ScreenShotListenManager", 1, "Media content changed, but not screenshot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
    }
    
    public static ScreenShotListenManager newInstance(Context paramContext)
    {
      BaseJsPluginEngine.assertInMainThread();
      return new ScreenShotListenManager(paramContext);
    }
    
    public void setListener(OnScreenShotListener paramOnScreenShotListener)
    {
      this.mListener = paramOnScreenShotListener;
    }
    
    public void startListen()
    {
      BaseJsPluginEngine.assertInMainThread();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */