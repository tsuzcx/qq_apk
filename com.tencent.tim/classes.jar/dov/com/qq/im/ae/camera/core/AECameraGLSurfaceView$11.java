package dov.com.qq.im.ae.camera.core;

import acfp;
import alwb;
import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import awvv;
import awwg;
import awyu;
import axbr;
import axgm;
import axiy;
import ayzk;
import azaj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import java.io.File;
import mqq.os.MqqHandler;

public class AECameraGLSurfaceView$11
  implements Runnable
{
  AECameraGLSurfaceView$11(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    if ((this.this$0.isRecording()) || (!AECameraGLSurfaceView.c(this.this$0))) {
      QLog.d("AECameraGLSurfaceView", 1, new Object[] { "setFaceEffect fail ", Boolean.valueOf(this.this$0.isRecording()) });
    }
    Object localObject2;
    awwg localawwg;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.val$path;
        localawwg = (awwg)AECameraGLSurfaceView.a(this.this$0);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          AECameraGLSurfaceView.a(this.this$0).f(null);
          AECameraGLSurfaceView.a(this.this$0, null);
          AECameraGLSurfaceView.c(this.this$0, false);
          this.this$0.queueEvent(new AECameraGLSurfaceView.11.1(this, localawwg));
          AECameraGLSurfaceView.a(this.this$0).eUC();
          AECameraGLSurfaceView.a(this.this$0, null);
          return;
        }
        localObject1 = localObject2;
        if (!new File((String)localObject2).exists()) {
          localObject1 = (String)localObject2 + "Android";
        }
      } while (!new File((String)localObject1).exists());
      localObject2 = AEMaterialConfigParser.parseVideoMaterial((String)localObject1);
    } while ((localObject2 == null) || (((VideoMaterial)localObject2).getGameParams() != null));
    AECameraGLSurfaceView.a(this.this$0).f((VideoMaterial)localObject2);
    ((VideoMaterial)localObject2).setDataPath((String)localObject1);
    if ((!FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject2)) || ((ayzk.c((VideoMaterial)localObject2)) && (!ayzk.aRy())))
    {
      AECameraGLSurfaceView.a(this.this$0, acfp.m(2131690026));
      ayzk.a((VideoMaterial)localObject2, (Activity)this.this$0.getContext(), ((VideoMaterial)localObject2).getDataPath());
      return;
    }
    label333:
    label464:
    label495:
    int i;
    if (VideoMaterialUtil.isWatermarkMaterial((VideoMaterial)localObject2))
    {
      LogicDataManager.getInstance().init((VideoMaterial)localObject2);
      if (!AECameraGLSurfaceView.d(this.this$0))
      {
        AECameraGLSurfaceView.d(this.this$0, true);
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11.2(this));
      }
    }
    else
    {
      if (axbr.b() != null) {
        axbr.b().editablewatermark = VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2);
      }
      if (AECameraGLSurfaceView.a(this.this$0) != null)
      {
        AECameraGLSurfaceView.a(this.this$0).t(VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2), ((VideoMaterial)localObject2).getVoicekind(), ((VideoMaterial)localObject2).getEnvironment());
        if ((!AECameraGLSurfaceView.e(this.this$0)) || (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2))) {
          break label677;
        }
        localObject1 = AECameraGLSurfaceView.a(this.this$0).bZj + File.separator + System.currentTimeMillis() + ".aac";
        AECameraGLSurfaceView.a(this.this$0).aJ(true, (String)localObject1);
        AECameraGLSurfaceView.a(this.this$0).aK(false, null);
      }
      if (!VideoMaterialUtil.isAudio2textMaterial((VideoMaterial)localObject2)) {
        break label778;
      }
      AECameraGLSurfaceView.a(this.this$0).a(this.this$0.getContext(), AECameraGLSurfaceView.a(this.this$0));
      AECameraGLSurfaceView.c(this.this$0, ((VideoMaterial)localObject2).needFaceInfo());
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "back")) {
        break label791;
      }
      if (AECameraGLSurfaceView.a(this.this$0) != null) {
        AECameraGLSurfaceView.a(this.this$0).adl(2);
      }
      label551:
      if (!VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject2)) {
        break label830;
      }
      if ((AECameraGLSurfaceView.a(this.this$0) != null) && (AECameraGLSurfaceView.a(this.this$0).getId().equals(((VideoMaterial)localObject2).getId()))) {
        break label835;
      }
      i = 1;
    }
    for (;;)
    {
      AECameraGLSurfaceView.a(this.this$0, (VideoMaterial)localObject2);
      if (i != 0) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.11.4(this, localawwg, (VideoMaterial)localObject2));
      }
      if ((!awyu.aOl()) || (TextUtils.isEmpty(this.val$path))) {
        break;
      }
      awyu.a(this.this$0.a, 1500L);
      return;
      axiy.i("AECameraGLSurfaceView", "updateWMProps mIsTryLocationPermission false");
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11.3(this));
      break label333;
      label677:
      if ((AECameraGLSurfaceView.e(this.this$0)) && (VideoMaterialUtil.needVoiceChange((VideoMaterial)localObject2)))
      {
        localObject1 = AECameraGLSurfaceView.a(this.this$0).bZj + File.separator + System.currentTimeMillis() + ".aac";
        AECameraGLSurfaceView.a(this.this$0).aJ(false, null);
        AECameraGLSurfaceView.a(this.this$0).aK(true, (String)localObject1);
        break label464;
      }
      AECameraGLSurfaceView.a(this.this$0).aK(false, null);
      break label464;
      label778:
      AECameraGLSurfaceView.a(this.this$0).eUC();
      break label495;
      label791:
      if ((!StringUtils.equals(((VideoMaterial)localObject2).getPreferCameraId(), "front")) || (AECameraGLSurfaceView.a(this.this$0) == null)) {
        break label551;
      }
      AECameraGLSurfaceView.a(this.this$0).adl(1);
      break label551;
      label830:
      i = 1;
      continue;
      label835:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.11
 * JD-Core Version:    0.7.0.1
 */