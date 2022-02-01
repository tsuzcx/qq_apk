package com.tencent.mobileqq.activity.richmedia.view;

import aaqh;
import aavi;
import acfp;
import android.os.SystemClock;
import anjd;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class CameraFilterGLView$5
  implements Runnable
{
  CameraFilterGLView$5(CameraFilterGLView paramCameraFilterGLView, AESticker paramAESticker, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, VideoMaterial paramVideoMaterial, boolean paramBoolean4, int paramInt, boolean paramBoolean5) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    this.this$0.a.a(this.b, this.bzS);
    this.this$0.a.mHasBackFilter = this.bzT;
    label92:
    Object localObject;
    if ((this.b != null) && (this.bzU))
    {
      this.this$0.a.setFaceDetectFlags(this.c.mEnableFaceDetect);
      if ((this.b == null) || (!this.bzV)) {
        break label441;
      }
      this.this$0.a.Qa(true);
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
      }
      if (this.b == null) {
        break label540;
      }
      if (!CameraFilterGLView.a(this.this$0).bzX)
      {
        CameraFilterGLView.a(this.this$0).bzX = true;
        if ((CameraFilterGLView.a(this.this$0) != null) && (this.bzU))
        {
          CameraFilterGLView.a(this.this$0).aM(this.this$0.a.mDetectedFace, 0);
          localObject = this.this$0;
          if (this.this$0.a.mDetectedFace) {
            break label455;
          }
          bool = true;
          label236:
          CameraFilterGLView.a((CameraFilterGLView)localObject, bool);
        }
      }
      if (!CameraFilterGLView.a(this.this$0).bzX)
      {
        CameraFilterGLView.a(this.this$0).bzX = true;
        if ((CameraFilterGLView.a(this.this$0) != null) && (!CameraFilterGLView.a(this.this$0)) && (this.bzV))
        {
          CameraFilterGLView.a(this.this$0).aM(this.this$0.a.mDetectedGesture, 1);
          if (this.this$0.a.mDetectedGesture == true) {
            CameraFilterGLView.a(this.this$0, false);
          }
        }
      }
      localObject = CameraFilterGLView.a(this.this$0, this.ckT);
      if (localObject != null) {
        break label671;
      }
    }
    label397:
    label540:
    label671:
    for (boolean bool = false;; bool = true)
    {
      int i;
      if (CameraFilterGLView.a(this.this$0) != null)
      {
        String str = this.c.mGuideTips;
        if ((!this.bzT) || (aaqh.cix == 2)) {
          break label461;
        }
        i = 1;
        if ((str == null) || (str.length() == 0)) {
          break label466;
        }
        CameraFilterGLView.a(this.this$0).n(true, str, 2);
      }
      for (;;)
      {
        return;
        this.this$0.a.setFaceDetectFlags(false);
        break;
        label441:
        this.this$0.a.Qa(false);
        break label92;
        label455:
        bool = false;
        break label236;
        label461:
        i = 0;
        break label397;
        label466:
        if ((i != 0) && (!this.bzW))
        {
          CameraFilterGLView.a(this.this$0).n(true, acfp.m(2131703368), 0);
          return;
        }
        if (this.bzW)
        {
          CameraFilterGLView.a(this.this$0).n(true, aavi.qI(), 3);
          return;
        }
        CameraFilterGLView.a(this.this$0).n(bool, (String)localObject, 1);
        return;
        CameraFilterGLView.a(this.this$0).bzX = false;
        CameraFilterGLView.a(this.this$0).bzX = false;
        if ((CameraFilterGLView.a(this.this$0) != null) && (this.bzU))
        {
          CameraFilterGLView.a(this.this$0).aM(true, 0);
          CameraFilterGLView.a(this.this$0, false);
        }
        while (CameraFilterGLView.a(this.this$0) != null)
        {
          CameraFilterGLView.a(this.this$0).n(false, null, -1);
          return;
          if ((CameraFilterGLView.a(this.this$0) != null) && (this.bzV))
          {
            CameraFilterGLView.a(this.this$0).aM(true, 1);
            CameraFilterGLView.a(this.this$0, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.5
 * JD-Core Version:    0.7.0.1
 */