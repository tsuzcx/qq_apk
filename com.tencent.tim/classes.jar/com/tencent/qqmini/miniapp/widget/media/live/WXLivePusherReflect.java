package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import org.json.JSONObject;

public class WXLivePusherReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePusher";
  public static final String ON_BGM_NOTIFY_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$OnBGMNotify";
  private static final String TAG = "WXLivePusherReflect";
  public static boolean backgroundMute;
  
  public static boolean isPushing(Object paramObject)
  {
    paramObject = (Boolean)JarReflectUtil.callSpecifiedMethod(paramObject, "isPushing", false, null, new Object[0]);
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static Object newInstance(Context paramContext)
  {
    return JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePusher", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { paramContext });
  }
  
  public static boolean pauseBGM(Object paramObject)
  {
    paramObject = JarReflectUtil.callSpecifiedMethod(paramObject, "pauseBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void pausePusher(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "pausePusher", false, null, new Object[0]);
  }
  
  public static boolean playBGM(String paramString, Object paramObject)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(paramObject, "playBGM", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public static boolean resumeBGM(Object paramObject)
  {
    paramObject = JarReflectUtil.callSpecifiedMethod(paramObject, "resumeBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void resumePusher(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "resumePusher", false, null, new Object[0]);
  }
  
  public static boolean sendMessageEx(byte[] paramArrayOfByte, Object paramObject)
  {
    paramArrayOfByte = (Boolean)JarReflectUtil.callSpecifiedMethod(paramObject, "sendMessageEx", false, JarReflectUtil.getParamsClass(new Class[] { [B.class }), new Object[] { paramArrayOfByte });
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.booleanValue();
    }
    return false;
  }
  
  public static void setBGMNofify(Object paramObject1, Object paramObject2)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(paramObject2, "setBGMNofify", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setBGMPosition(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setBGMPosition", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean setBGMVolume(float paramFloat, Object paramObject)
  {
    paramObject = JarReflectUtil.callSpecifiedMethod(paramObject, "setBGMVolume", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setBeautyFilter", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public static void setConfig(Object paramObject1, Object paramObject2)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(paramObject2, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePushConfig") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setEnableCamera(JSONObject paramJSONObject, Object paramObject1, Object paramObject2)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("enable-camera", true))) {
      JarReflectUtil.callSpecifiedMethod(paramObject1, "startCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { paramObject2.getClass() }), new Object[] { paramObject2 });
    }
  }
  
  public static void setLocalVideoMirrorType(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setLocalVideoMirrorType", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMicVolume(float paramFloat, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setMicVolume", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public static void setMirror(boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setMirror", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setMode(JSONObject paramJSONObject, Object paramObject)
  {
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("mode", "RTC");
      paramJSONObject = "VIDEO_QUALITY_REALTIEM_VIDEOCHAT";
      if (!"SD".equals(str)) {
        break label98;
      }
      paramJSONObject = "VIDEO_QUALITY_STANDARD_DEFINITION";
    }
    for (;;)
    {
      paramJSONObject = JarReflectUtil.getStaticField("com.tencent.rtmp.TXLiveConstants", paramJSONObject);
      if ((paramJSONObject instanceof Integer)) {
        JarReflectUtil.callSpecifiedMethod(paramObject, "setVideoQuality", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { paramJSONObject, Boolean.valueOf(true), Boolean.valueOf(true) });
      }
      return;
      label98:
      if ("HD".equals(str)) {
        paramJSONObject = "VIDEO_QUALITY_HIGH_DEFINITION";
      } else if ("FHD".equals(str)) {
        paramJSONObject = "VIDEO_QUALITY_SUPER_DEFINITION";
      } else {
        QMLog.w("WXLivePusherReflect", "setMode unknown mode " + str);
      }
    }
  }
  
  public static void setMuted(boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setMute", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setPushListener(Object paramObject1, Object paramObject2)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(paramObject2, "setPushListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePushListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setPusherUrl(String paramString, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setPusherUrl", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
  }
  
  public static void setRenderRotation(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setRenderRotation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setReverb(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setReverb", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setSurface(Surface paramSurface, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setSurface", false, JarReflectUtil.getParamsClass(new Class[] { Surface.class }), new Object[] { paramSurface });
  }
  
  public static void setSurfaceSize(int paramInt1, int paramInt2, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setSurfaceSize", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setVideoQuality", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public static void showDebugLog(boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "showDebugLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void snapshot(Object paramObject1, Object paramObject2)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(paramObject2, "snapshot", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void startAudioRecord(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "startAudioRecord", false, null, new Object[0]);
  }
  
  public static void startCameraPreview(Object paramObject1, Object paramObject2)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(paramObject2, "startCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static int startDumpAudioData(String paramString, Object paramObject)
  {
    paramString = (Integer)JarReflectUtil.callSpecifiedMethod(paramObject, "startDumpAudioData", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    if (paramString != null) {
      return paramString.intValue();
    }
    return -10;
  }
  
  public static boolean startPusher(String paramString, Object paramObject)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(paramObject, "startPusher", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Integer)) && (((Integer)paramString).intValue() == 0);
  }
  
  public static void stopAudioRecord(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "stopAudioRecord", false, null, new Object[0]);
  }
  
  public static boolean stopBGM(Object paramObject)
  {
    paramObject = JarReflectUtil.callSpecifiedMethod(paramObject, "stopBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void stopCameraPreview(boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "stopCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void stopDumpAudioData(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "stopDumpAudioData", false, null, new Object[0]);
  }
  
  public static void stopPusher(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "stopPusher", false, null, new Object[0]);
  }
  
  public static void switchCamera(Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "switchCamera", false, null, new Object[0]);
  }
  
  public static void toggleTorch(Object paramObject)
  {
    QMLog.w("WXLivePusherReflect", "toggleTorch: not implement");
  }
  
  public static boolean turnOnFlashLight(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Boolean)JarReflectUtil.callSpecifiedMethod(paramObject, "turnOnFlashLight", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.WXLivePusherReflect
 * JD-Core Version:    0.7.0.1
 */