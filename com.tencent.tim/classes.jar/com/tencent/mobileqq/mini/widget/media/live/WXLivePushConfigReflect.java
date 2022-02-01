package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import awcj;

public class WXLivePushConfigReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePushConfig";
  private static final String TAG = "WXLivePushConfigReflect";
  
  public static void enableAGC(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "enableAGC", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableANS(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "enableANS", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "enableAudioEarMonitoring", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enablePureAudioPush(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "enablePureAudioPush", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static Object newInstance()
  {
    return awcj.creatSpecifiedObject("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void setAudioSampleRate(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setAudioSampleRate", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setEnableZoom(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setEnableZoom", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setFrontCamera(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setFrontCamera", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setHomeOrientation(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setHomeOrientation", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMaxVideoBitrate(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setMaxVideoBitrate", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMinVideoBitrate(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setMinVideoBitrate", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseFlag(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setPauseFlag", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseImg(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      awcj.callSpecifiedMethod(paramObject, "setPauseImg", false, awcj.getParamsClass(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void setTouchFocus(boolean paramBoolean, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setTouchFocus", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setVideoEncodeGop(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setVideoEncodeGop", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVideoResolution(int paramInt1, int paramInt2, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setVideoResolution", false, awcj.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void setVideoResolution(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setVideoResolution", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVolumeType(int paramInt, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setVolumeType", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    awcj.callSpecifiedMethod(paramObject, "setWatermark", false, awcj.getParamsClass(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.WXLivePushConfigReflect
 * JD-Core Version:    0.7.0.1
 */