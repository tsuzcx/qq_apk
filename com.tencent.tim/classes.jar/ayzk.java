import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import dov.com.tencent.mobileqq.shortvideo.PtuTemplate.PtuTemplateManager.3;
import mqq.os.MqqHandler;

public class ayzk
{
  private static final String cYp = acfp.m(2131710191);
  public static String cYq;
  
  public static boolean a(VideoMaterial paramVideoMaterial, Activity paramActivity, String paramString)
  {
    if ((c(paramVideoMaterial)) && ((!angh.cFq) || (!aRy())))
    {
      if (!aqiw.isWifiConnected(paramActivity)) {
        ThreadManager.getUIHandler().post(new PtuTemplateManager.3(paramActivity, paramString));
      }
      for (;;)
      {
        return true;
        axiy.i("PtuTemplateManager", "【Camera is in Prepareing wifi】prepare to download");
        adL(paramString);
      }
    }
    axiy.e("PtuTemplateManager", "【Camera is in Prepareing Error】PTU_RES_DOWNLOADED: " + angh.cFq);
    axiy.e("PtuTemplateManager", "【Camera is in Prepareing Error】isSpecialTemplate: " + c(paramVideoMaterial));
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, azaj paramazaj, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!angh.cFq) && (c(paramVideoMaterial)))
    {
      if (!aqiw.isWifiConnected(paramActivity)) {
        aqha.a(paramActivity, 230).setMessage(cYp).setPositiveButton(paramActivity.getString(2131695681), new ayzm(paramString)).setNegativeButton(paramActivity.getString(2131695677), new ayzl()).show();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtuTemplateManager", 2, "handleSpecialTempleate true");
        }
        return true;
        adL(paramString);
      }
    }
    if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
    {
      if (!VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) {
        break label120;
      }
      paramazaj.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      cYq = null;
      return false;
      label120:
      paramazaj.eUC();
    }
  }
  
  public static boolean aRy()
  {
    boolean bool = false;
    if (axis.a().l("key_ae_res_1", 0, 4) >= 83604) {
      bool = true;
    }
    return bool;
  }
  
  private static void aV(Context paramContext, String paramString)
  {
    Bundle localBundle = anjx.a().b("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || ((!aRy()) && (axce.a().a(axcd.d) == 4)))
    {
      aqha.a(paramContext, 230).setMessage(cYp).setPositiveButton(paramContext.getString(2131695681), new ayzo(paramString)).setNegativeButton(paramContext.getString(2131695677), new ayzn()).show();
      return;
    }
    QQToast.a(paramContext, 2131689936, 1).show();
  }
  
  private static void adL(String paramString)
  {
    cYq = paramString;
    anjx.a().b("CMD_DOWNLOAD_PTU_ADDITIONAL_RES", new Bundle());
  }
  
  public static boolean c(VideoMaterial paramVideoMaterial)
  {
    return (VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isSegmentMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) || (VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) || (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isRapidNetMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGenderDetect(paramVideoMaterial)) || (VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isPagMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isHairSegMaterial(paramVideoMaterial)) || (VideoMaterialUtil.is3DMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzk
 * JD-Core Version:    0.7.0.1
 */