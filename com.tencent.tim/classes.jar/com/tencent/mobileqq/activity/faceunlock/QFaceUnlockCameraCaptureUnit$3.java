package com.tencent.mobileqq.activity.faceunlock;

import allc;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import anij;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;
import zeh;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(zeh paramzeh) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (zeh.a(this.this$0) == null) {
        zeh.a(this.this$0, new MediaRecorder());
      }
      if (anij.a().mCamera != null)
      {
        Object localObject2 = anij.a().mCamera.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = zeh.a(this.this$0, (List)localObject1, (List)localObject2);
        anij.a().mCamera.unlock();
        zeh.a(this.this$0).setOrientationHint(270);
        zeh.a(this.this$0).reset();
        zeh.a(this.this$0).setCamera(anij.a().mCamera);
        zeh.a(this.this$0).setAudioSource(0);
        zeh.a(this.this$0).setVideoSource(1);
        zeh.a(this.this$0).setOutputFormat(2);
        zeh.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        zeh.a(this.this$0).setVideoEncoder(2);
        zeh.a(this.this$0).setAudioEncoder(3);
        zeh.a(this.this$0).setVideoEncodingBitRate(5242880);
        zeh.a(this.this$0, ShortVideoUtils.zL());
        zeh.a(this.this$0).setOutputFile(zeh.a(this.this$0));
        zeh.a(this.this$0).prepare();
        allc.a(zeh.a(this.this$0));
        zeh.a(this.this$0).postDelayed(zeh.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      zeh.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */