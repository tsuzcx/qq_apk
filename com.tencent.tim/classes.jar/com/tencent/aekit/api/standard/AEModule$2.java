package com.tencent.aekit.api.standard;

import android.content.Context;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.util.SecurityUtils;

final class AEModule$2
  implements Runnable
{
  AEModule$2(boolean paramBoolean) {}
  
  public void run()
  {
    Context localContext = AEModule.getContext();
    try
    {
      DeviceAttrs.getInstance().init(localContext.getApplicationContext(), SecurityUtils.getSignMD5(localContext));
      if (this.val$forceUpdate) {
        DeviceAttrs.getInstance().update(FileUtils.genSeperateFileDir(FeatureManager.getSoDir()) + "phone_attrs_config.dat", new AEModule.2.1(this));
      }
      GpuScopeAttrs.getInstance().init(localContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), FeatureManager.getResourceDir());
      if (DeviceUtils.hasDeviceHigh(AEModule.getContext()))
      {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 280.0F;
        return;
      }
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext()))
      {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 230.0F;
        return;
      }
      com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 180.0F;
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      LogUtils.e("AEKitModule", "initPhoneAttrs：" + localError.getMessage());
      GpuScopeAttrs.getInstance().init(localContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), FeatureManager.getResourceDir());
      if (DeviceUtils.hasDeviceHigh(AEModule.getContext()))
      {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 280.0F;
        return;
      }
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext()))
      {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 230.0F;
        return;
      }
      com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 180.0F;
      return;
    }
    finally
    {
      GpuScopeAttrs.getInstance().init(localContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), FeatureManager.getResourceDir());
      if (!DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
        break label241;
      }
    }
    com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 280.0F;
    for (;;)
    {
      throw localObject;
      label241:
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 230.0F;
      } else {
        com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_WIDTH = 180.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule.2
 * JD-Core Version:    0.7.0.1
 */