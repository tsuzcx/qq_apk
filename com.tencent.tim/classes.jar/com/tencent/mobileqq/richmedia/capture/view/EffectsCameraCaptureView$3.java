package com.tencent.mobileqq.richmedia.capture.view;

import aaqh;
import alwb;
import alxd;
import alxg;
import alxu;
import alxv;
import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import ayzk;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;

public class EffectsCameraCaptureView$3
  implements Runnable
{
  EffectsCameraCaptureView$3(EffectsCameraCaptureView paramEffectsCameraCaptureView, String paramString) {}
  
  public void run()
  {
    if ((EffectsCameraCaptureView.c(this.this$0)) && (TextUtils.isEmpty(this.bZu))) {}
    Object localObject1;
    label151:
    long l;
    boolean bool2;
    boolean[] arrayOfBoolean;
    Object localObject2;
    boolean bool1;
    label259:
    label326:
    do
    {
      return;
      localObject1 = alxu.a(EffectsCameraCaptureView.a(this.this$0));
      if (this.this$0.a((alxu)localObject1))
      {
        EffectsCameraCaptureView.a(this.this$0).clear();
        return;
      }
      EffectsCameraCaptureView.a(this.this$0, (alxu)localObject1);
      if ((this.bZu == null) || (this.bZu.equalsIgnoreCase("")) || (localObject1 == null)) {
        break;
      }
      EffectsCameraCaptureView.a(this.this$0).cBg = ((alxu)localObject1).hasFace;
      EffectsCameraCaptureView.a(this.this$0).cBf = ((alxu)localObject1).cAQ;
      EffectsCameraCaptureView.a(this.this$0).type = ((alxu)localObject1).category;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureType = ((alxu)localObject1).gestureType;
      com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.sGestureTips = ((alxu)localObject1).gestureWording;
      i = PTFaceAttr.PTExpression.UNKNOW.value;
      l = SystemClock.elapsedRealtime();
      localObject1 = new File(this.bZu, "paramsback" + ".json");
      bool2 = ((File)localObject1).exists();
      arrayOfBoolean = new boolean[1];
      if ((this.bZu == null) || ("".equals(this.bZu))) {
        break label713;
      }
      alxg.dKH();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (aaqh.cix != 2) {
          break label569;
        }
        bool1 = true;
        QLog.d("EffectsCameraCaptureView", 2, bool1);
      }
      if (aaqh.cix != 2) {
        break label705;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial file : " + ((File)localObject1).getAbsolutePath());
      }
      if (!bool2) {
        break label705;
      }
      localObject1 = "paramsback";
      localObject1 = QQTemplateParser.parseVideoMaterial(this.bZu, (String)localObject1);
      ((VideoMaterial)localObject1).setDataPath(this.bZu);
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial  tempMaterail type: " + ((VideoMaterial)localObject1).getShaderType() + " patternPath=" + this.bZu);
      }
    } while ((ayzk.a((VideoMaterial)localObject1, this.this$0.jdField_a_of_type_Azaj, this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture, (Activity)this.this$0.getContext(), this.bZu)) || (((VideoMaterial)localObject1).getGameParams() != null));
    if (EffectsCameraCaptureView.a(this.this$0).type == 1) {
      ((VideoMaterial)localObject1).isNeedDecodeFaceFilter = false;
    }
    int i = ((VideoMaterial)localObject1).getTriggerType();
    for (;;)
    {
      if (localObject1 != null) {}
      for (localObject2 = ((VideoMaterial)localObject1).getId();; localObject2 = null)
      {
        alxg.bZh = (String)localObject2;
        l = (SystemClock.elapsedRealtime() - l) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
        }
        if (this.this$0.mQQFilterRenderManager != null) {
          break label581;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PtvFilterUtils", 2, "mQQFilterRenderManager == null");
        return;
        EffectsCameraCaptureView.a(this.this$0).clear();
        break label151;
        label569:
        bool1 = false;
        break label259;
      }
      label581:
      localObject2 = this.this$0.mQQFilterRenderManager;
      int j = arrayOfBoolean[0];
      if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject1))
      {
        LogicDataManager.getInstance().init((VideoMaterial)localObject1);
        new alxd((Activity)this.this$0.getContext(), new alxv(this)).Qj();
      }
      if ((this.this$0.jdField_a_of_type_Alwb != null) && (localObject1 != null)) {
        this.this$0.jdField_a_of_type_Alwb.t(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject1), ((VideoMaterial)localObject1).getVoicekind(), ((VideoMaterial)localObject1).getEnvironment());
      }
      EffectsCameraCaptureView.a(this.this$0, new EffectsCameraCaptureView.3.3(this, (VideoMaterial)localObject1, (QQFilterRenderManager)localObject2, bool2, j, i));
      return;
      label705:
      localObject1 = "params";
      break label326;
      label713:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.3
 * JD-Core Version:    0.7.0.1
 */