package com.tencent.mobileqq.activity.faceunlock;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import zeh;

public class QFaceUnlockCameraCaptureUnit$5
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$5(zeh paramzeh) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    if (zeh.c(this.this$0) > 10) {
      localIntent.putExtra("recording_time_out", true);
    }
    localIntent.putExtra("target_media_url", zeh.a(this.this$0));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    this.this$0.getActivity().sendBroadcast(localIntent);
    this.this$0.getActivity().finish();
    this.this$0.getActivity().overridePendingTransition(2130772077, 2130772307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */