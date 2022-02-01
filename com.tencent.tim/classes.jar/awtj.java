import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openai.ttpicmodule.AEGenderDetector;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.ttpicmodule.AECatDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.video.AECoderFactory;

public class awtj
{
  private static boolean isInited;
  
  public static boolean init()
  {
    if (isInited) {
      return true;
    }
    if (!isSupported())
    {
      SLog.e("AEKitForQQ", "sdk version Limited!");
      return false;
    }
    atao.init();
    String str = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    SharedPreferences localSharedPreferences = axis.a().G();
    AEOpenRenderConfig.setEnableStrictMode(false);
    AEModule.initialize(localBaseApplication, AEModuleConfig.newBuilder().setLoadSo(false).setLutDir(str).setModelDir(str).setSoDir(str).setAuthMode(1).setPreferences(localSharedPreferences).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
    AECoderFactory.setAEDecoder(new awtk());
    AECoderFactory.setAEEncoder(new awtl());
    AIManager.registerDetector(AEHandDetector.class);
    AIManager.registerDetector(AECatDetector.class);
    AIManager.registerDetector(AEGenderDetector.class);
    AIManager.registerDetector(PTEmotionDetector.class);
    AIManager.registerDetector(PTHairSegmenter.class);
    AIManager.registerDetector(PTSkySegmenter.class);
    AIManager.registerDetector(PTHumanSegmenter.class);
    CfConfig.setDecryptListener(new awtm());
    isInited = true;
    return true;
  }
  
  public static boolean isSupported()
  {
    return (AEModule.isAeKitSupportVersion()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtj
 * JD-Core Version:    0.7.0.1
 */