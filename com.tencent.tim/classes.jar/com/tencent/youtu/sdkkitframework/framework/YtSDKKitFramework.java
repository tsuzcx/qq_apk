package com.tencent.youtu.sdkkitframework.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG = YtSDKKitFramework.class.getSimpleName();
  private static YtSDKKitFramework instance;
  private static final String version = "1.0.8.4";
  private Rect detectRect = new Rect(20, 270, 700, 1130);
  private IYtSDKKitFrameworkEventListener eventListener;
  private Rect previewRect = new Rect(0, 0, 720, 1280);
  
  public static YtSDKKitFramework getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YtSDKKitFramework();
      }
      YtSDKKitFramework localYtSDKKitFramework = instance;
      return localYtSDKKitFramework;
    }
    finally {}
  }
  
  private YtFSMBaseState parseStateFrom(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      YtFSMBaseState localYtFSMBaseState = (YtFSMBaseState)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      YtLogger.e(TAG, "Parse state " + paramString + "failed:" + localThrowable1.getMessage());
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localYtFSMBaseState.loadStateWith(paramString, paramJSONObject);
        return localYtFSMBaseState;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramJSONObject = localThrowable1;
          Object localObject = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  public int deInit()
  {
    YtFSM.getInstance().stop();
    return 0;
  }
  
  public void doPause()
  {
    YtFSM.getInstance().handlePauseEvent();
  }
  
  public void doResume()
  {
    YtFSM.getInstance().handleResumeEvent();
  }
  
  public void fireEvent(YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    YtFSM.getInstance().handleEvent(paramYtFrameworkFireEventType, paramObject);
  }
  
  public Rect getDetectRect()
  {
    return this.detectRect;
  }
  
  public YtSDKPlatformContex getPlatformContext()
  {
    return YtFSM.getInstance().getContext();
  }
  
  public Rect getPreviewRect()
  {
    return this.previewRect;
  }
  
  public int init(YtSDKPlatformContex paramYtSDKPlatformContex, JSONObject paramJSONObject, YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, ArrayList<String> paramArrayList, IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    if (paramYtSDKPlatformContex == null)
    {
      YtLogger.e(TAG, "Context cannot be null");
      return -1;
    }
    if (paramArrayList.isEmpty())
    {
      YtLogger.e(TAG, "Pipeline state name cannot be empty");
      return -1;
    }
    if (paramIYtSDKKitFrameworkEventListener == null)
    {
      YtLogger.e(TAG, "Event listener cannot be null");
      return -1;
    }
    YtFSM.getInstance().stop();
    YtFSM.getInstance().setEventListener(paramIYtSDKKitFrameworkEventListener);
    YtFSM.getInstance().setContext(paramYtSDKPlatformContex);
    paramYtSDKPlatformContex = paramArrayList.iterator();
    while (paramYtSDKPlatformContex.hasNext())
    {
      paramIYtSDKKitFrameworkEventListener = parseStateFrom((String)paramYtSDKPlatformContex.next(), paramJSONObject);
      YtFSM.getInstance().registerState(paramIYtSDKKitFrameworkEventListener);
    }
    YtFSM.getInstance().start((String)paramArrayList.get(0), paramYtSDKKitFrameworkWorkMode);
    return 0;
  }
  
  public void reset()
  {
    new Handler(Looper.getMainLooper()).post(new YtSDKKitFramework.1(this));
  }
  
  public void setDetectRect(Rect paramRect)
  {
    this.detectRect = paramRect;
  }
  
  public void setPreviewRect(Rect paramRect)
  {
    this.previewRect = paramRect;
  }
  
  public int updateWithFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    YtFSM.getInstance().update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    return 0;
  }
  
  public String version()
  {
    return "1.0.8.4";
  }
  
  public static abstract interface IYTReflectListener
  {
    public abstract void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter);
  }
  
  public static abstract interface IYtSDKKitFrameworkEventListener
  {
    public abstract void onFrameworkEvent(HashMap<String, Object> paramHashMap);
    
    public abstract void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser);
  }
  
  public static abstract interface IYtSDKKitNetResponseParser
  {
    public abstract void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException);
  }
  
  public static enum YtFrameworkFireEventType
  {
    YT_EVENT_TRIGGER_BEGIN_LIVENESS,  YT_EVENT_TRIGGER_CANCEL_LIVENESS;
    
    private YtFrameworkFireEventType() {}
  }
  
  public static enum YtSDKKitFrameworkWorkMode
  {
    private static HashMap<Integer, YtSDKKitFrameworkWorkMode> map;
    private int value;
    
    static
    {
      int i = 0;
      YT_FW_UNKNOWN = new YtSDKKitFrameworkWorkMode("YT_FW_UNKNOWN", 0, 0);
      YT_FW_OCR_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_TYPE", 1, 1);
      YT_FW_SILENT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_SILENT_TYPE", 2, 2);
      YT_FW_ACTION_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTION_TYPE", 3, 3);
      YT_FW_REFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_REFLECT_TYPE", 4, 4);
      YT_FW_ACTREFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTREFLECT_TYPE", 5, 5);
      $VALUES = new YtSDKKitFrameworkWorkMode[] { YT_FW_UNKNOWN, YT_FW_OCR_TYPE, YT_FW_SILENT_TYPE, YT_FW_ACTION_TYPE, YT_FW_REFLECT_TYPE, YT_FW_ACTREFLECT_TYPE };
      map = new HashMap();
      YtSDKKitFrameworkWorkMode[] arrayOfYtSDKKitFrameworkWorkMode = values();
      int j = arrayOfYtSDKKitFrameworkWorkMode.length;
      while (i < j)
      {
        YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = arrayOfYtSDKKitFrameworkWorkMode[i];
        map.put(Integer.valueOf(localYtSDKKitFrameworkWorkMode.value), localYtSDKKitFrameworkWorkMode);
        i += 1;
      }
    }
    
    private YtSDKKitFrameworkWorkMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static YtSDKKitFrameworkWorkMode valueOf(int paramInt)
    {
      if (map.get(Integer.valueOf(paramInt)) == null) {
        return YT_FW_UNKNOWN;
      }
      return (YtSDKKitFrameworkWorkMode)map.get(Integer.valueOf(paramInt));
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  public static class YtSDKPlatformContex
  {
    public Context currentAppContex;
    public Camera currentCamera;
    public int currentCameraId;
    public int currentRotateState;
    public int imageToComapreType = 0;
    public Bitmap imageToCompare;
    public RelativeLayout reflectLayout;
    public YtSDKKitFramework.IYTReflectListener reflectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */