package com.tencent.mobileqq.richmedia.capture.view;

import aaqh;
import aavi;
import acfp;
import android.os.SystemClock;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

class EffectsCameraCaptureView$3$3
  implements Runnable
{
  EffectsCameraCaptureView$3$3(EffectsCameraCaptureView.3 param3, VideoMaterial paramVideoMaterial, QQFilterRenderManager paramQQFilterRenderManager, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    Object localObject2;
    if (this.d != null)
    {
      this.a.this$0.mQQFilterRenderManager.initAEDetector_sync();
      if (!this.a.this$0.mQQFilterRenderManager.hasAEDetectorInited()) {
        if (QLog.isColorLevel()) {
          QLog.e("EffectsCameraCaptureView", 2, "initFaceDetectorSDK_Sync failed!");
        }
      }
      while (!FeatureManager.ensureMaterialSoLoaded(this.d)) {
        return;
      }
      this.c.getBusinessOperation().clearPtvVideoActiveFilter();
      localObject2 = new AESticker(this.d, this.c.getFaceDetector());
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        if (((AESticker)localObject2).getFilters() != null) {
          QLog.d("EffectsCameraCaptureView", 2, "createFilters = " + ((AESticker)localObject2).getFilters().size() + " tempMaterail getShaderType=" + this.d.getShaderType());
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      EffectsCameraCaptureView.a(this.a.this$0, null);
      EffectsCameraCaptureView.a(this.a.this$0, -1);
      long l = SystemClock.elapsedRealtime();
      if (this.a.this$0.cAX) {
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = AdvancedProviderView.QV();
      }
      boolean bool2;
      label349:
      boolean bool1;
      label390:
      label436:
      int i;
      if ((this.d != null) && (this.d.getChildrenPendants() != null) && (!this.d.getChildrenPendants().isEmpty()))
      {
        EffectsCameraCaptureView.a(this.a.this$0, new GroupVideoFilterList(this.d, this.c.getFaceDetector()));
        this.c.getBusinessOperation().setPtvGroupVideoFilterList(EffectsCameraCaptureView.a(this.a.this$0));
        this.c.getBusinessOperation().mHasBackFilter = this.bzT;
        if ((localObject1 == null) || (!EffectsCameraCaptureView.a(this.a.this$0, this.d)) || (!EffectsCameraCaptureView.a(this.a.this$0).cBg)) {
          break label674;
        }
        bool2 = true;
        if ((localObject1 == null) || (!EffectsCameraCaptureView.a(this.a.this$0, this.d)) || (!EffectsCameraCaptureView.a(this.a.this$0).cBf)) {
          break label680;
        }
        bool1 = true;
        boolean bool3 = VideoMaterialUtil.isGestureDetectMaterial(this.d);
        EffectsCameraCaptureView.a(this.a.this$0, bool2);
        localObject2 = this.c;
        if ((!bool2) || (!this.d.mEnableFaceDetect)) {
          break label686;
        }
        bool2 = true;
        ((QQFilterRenderManager)localObject2).setFaceDetectFlags(bool2);
        this.c.setGestureDetectectFlags(bool1);
        this.c.setYTGestureDetectFlags(bool3);
        l = (SystemClock.elapsedRealtime() - l) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
        }
        EffectsCameraCaptureView.a(this.a.this$0, this.d);
        if ((localObject1 == null) || (this.d == null)) {
          break label918;
        }
        localObject1 = this.d.mGuideTips;
        if ((!this.bzT) || (aaqh.cix == 2)) {
          break label692;
        }
        i = 1;
        label563:
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break label697;
        }
        EffectsCameraCaptureView.a(this.a.this$0, (String)localObject1);
        EffectsCameraCaptureView.a(this.a.this$0, 2);
      }
      for (;;)
      {
        for (;;)
        {
          if (EffectsCameraCaptureView.a(this.a.this$0).type != 0) {
            break label816;
          }
          this.a.this$0.a(this.c.mNeedDoFaceDetect, this.c.mDetectedFace, false, false, 0);
          return;
          try
          {
            this.c.getBusinessOperation().setPtvVideoFilter((AESticker)localObject1, this.d);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        break;
        label674:
        bool2 = false;
        break label349;
        label680:
        bool1 = false;
        break label390;
        label686:
        bool2 = false;
        break label436;
        label692:
        i = 0;
        break label563;
        label697:
        if ((i != 0) && (!this.bzW))
        {
          EffectsCameraCaptureView.a(this.a.this$0, acfp.m(2131705754));
          EffectsCameraCaptureView.a(this.a.this$0, 0);
        }
        else if (this.bzW)
        {
          EffectsCameraCaptureView.a(this.a.this$0, aavi.qI());
          EffectsCameraCaptureView.a(this.a.this$0, 3);
        }
        else
        {
          EffectsCameraCaptureView.a(this.a.this$0, EffectsCameraCaptureView.a(this.a.this$0, this.dzF));
          EffectsCameraCaptureView.a(this.a.this$0, 1);
        }
      }
      label816:
      if (EffectsCameraCaptureView.a(this.a.this$0).type == 1)
      {
        this.a.this$0.a(false, false, this.c.mNeedDoGestureDetect, this.c.mDetectedGesture, 1);
        return;
      }
      if (EffectsCameraCaptureView.a(this.a.this$0).type != 2) {
        break;
      }
      this.a.this$0.a(this.c.mNeedDoFaceDetect, this.c.mDetectedFace, this.c.mNeedDoGestureDetect, this.c.mDetectedGesture, 2);
      return;
      label918:
      this.a.this$0.a(false, false, false, false, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.3.3
 * JD-Core Version:    0.7.0.1
 */